package ru.job4j.task22;

import java.util.*;

public class Robot {
    private Map<String, Integer> wayMap = new HashMap<>();
    private Map<String, List<Vertex>> wayPoints = new HashMap<>();
    private Stack<Vertex> way = new Stack<>();

    public int optimalWay(int[][] board, int sx, int sy, int fx, int fy) {
        int result = -1;
        Vertex start = new Vertex(board[sy][sx], sx, sy);
        Vertex finish = new Vertex(board[fy][fx], fx, fy);
        wayMap.put(start.toString(), 0);
        way.push(start);
        wayPoints.put(start.toString(), List.of(start));
        while (!way.empty()) {
            Vertex currentVertex = way.pop();
            int x = currentVertex.x;
            int y = currentVertex.y;
            if (y - 1 >= 0) {
                Vertex upVertex = new Vertex(board[y - 1][x], x, y - 1);
                this.checkVertex(currentVertex, upVertex);
            }
            if (y + 1 < board.length) {
                Vertex downVertex = new Vertex(board[y + 1][x], x, y + 1);
                this.checkVertex(currentVertex, downVertex);
            }
            if (x + 1 < board[0].length) {
                Vertex rightVertex = new Vertex(board[y][x + 1], x + 1, y);
                this.checkVertex(currentVertex, rightVertex);
            }
        }
        result = wayMap.get(finish.toString());
        System.out.println(result + " Optimal Way : " + wayPoints.get(finish.toString()));
        return result;
    }

    void checkVertex(Vertex current, Vertex next) {
        int value = next.value - current.value;
        value = value < 0 ? 0 : value;
        int sumValue = wayMap.get(current.toString());
        if (wayMap.get(next.toString()) == null || wayMap.get(next.toString()) > sumValue + value) {
            way.push(next);
            wayMap.put(next.toString(), sumValue + value);
            List<Vertex> points = new ArrayList<>(wayPoints.get(current.toString()));
            points.add(next);
            wayPoints.put(next.toString(), points);
        }
    }
}