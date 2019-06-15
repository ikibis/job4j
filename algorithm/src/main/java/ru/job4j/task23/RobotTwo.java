package ru.job4j.task23;

import ru.job4j.task22.Vertex;

import java.util.*;

public class RobotTwo {

    private Map<String, List<Vertex>> wayPoints = new HashMap<>();
    private Stack<Vertex> way = new Stack<>();

    public int optimalWay(int[][] board, int sx, int sy, int fx, int fy) {
        int result = -1;
        Vertex start = new Vertex(board[sy][sx], sx, sy);
        Vertex finish = new Vertex(board[fy][fx], fx, fy);
        way.push(start);
        wayPoints.put(start.toString(), List.of(start));
        while (!way.empty()) {
            Vertex currentVertex = way.pop();
            int x = currentVertex.x;
            int y = currentVertex.y;
            if (y - 1 >= 0 && board[y - 1][x] != 0) {
                Vertex upVertex = new Vertex(board[y - 1][x], x, y - 1);
                this.checkVertex(currentVertex, upVertex);
            }
            if (y + 1 < board.length && board[y + 1][x] != 0) {
                Vertex downVertex = new Vertex(board[y + 1][x], x, y + 1);
                this.checkVertex(currentVertex, downVertex);
            }
            if (x + 1 < board[0].length && board[y][x + 1] != 0) {
                Vertex rightVertex = new Vertex(board[y][x + 1], x + 1, y);
                this.checkVertex(currentVertex, rightVertex);
            }
            if (x - 1 >= 0 && board[y][x - 1] != 0) {
                Vertex leftVertex = new Vertex(board[y][x - 1], x - 1, y);
                this.checkVertex(currentVertex, leftVertex);
            }
        }
        result = wayPoints.get(finish.toString()).size() - 1;
        System.out.println("Steps : " + result + " Optimal Way : " + wayPoints.get(finish.toString()));
        return result;
    }

    public void checkVertex(Vertex current, Vertex next) {
        if (wayPoints.get(next.toString()) == null) {
            way.push(next);
            List<Vertex> points = new ArrayList<>(wayPoints.get(current.toString()));
            points.add(next);
            wayPoints.put(next.toString(), points);
        }
    }
}