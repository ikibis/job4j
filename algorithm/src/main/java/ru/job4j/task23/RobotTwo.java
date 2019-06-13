package ru.job4j.task23;

import ru.job4j.task22.Robot;
import ru.job4j.task22.Vertex;

import java.util.*;

public class RobotTwo extends Robot {
    @Override
    public int optimalWay(int[][] board, int sx, int sy, int fx, int fy) {
        return super.optimalWay(board, sx, sy, fx, fy);
    }

    @Override
    public int shortestWay(List<LinkedList<Vertex>> filteredWays) {
        Map<Integer, LinkedList<Vertex>> map = new HashMap<>();
        for (LinkedList<Vertex> list : filteredWays) {
            map.put(list.size(), list);
            System.out.println(list.size() + " : " + list);
        }
        int key = new ArrayList<>(map.keySet()).get(0);
        System.out.println(key + ". Way : " + map.get(key));
        return key;
    }

    @Override
    public List<LinkedList<Vertex>> filterWays(List<LinkedList<Vertex>> allWays, Vertex finish) {
        return super.filterWays(allWays, finish);
    }

    @Override
    public List<LinkedList<Vertex>> fillWayList(Map<String, List<Vertex>> wayMap, Vertex start, Vertex finish) {
        return super.fillWayList(wayMap, start, finish);
    }

    @Override
    public Map<String, List<Vertex>> fillVertexMap(int[][] board) {
        int vert = board.length;
        int horizon = board[0].length;
        Map<String, List<Vertex>> wayMap = new HashMap<>();
        for (int y = 0; y < vert; y++) {
            for (int x = 0; x < horizon; x++) {
                List<Vertex> way = new ArrayList<>();
                if (board[y][x] == 0) {
                    continue;
                }
                Vertex currentVertex = new Vertex(board[y][x], x, y);
                if (y - 1 >= 0 && board[y - 1][x] != 0) {
                    Vertex upVertex = new Vertex(board[y - 1][x], x, y - 1);
                    way.add(upVertex);
                }
                if (y + 1 < vert && board[y + 1][x] != 0) {
                    Vertex downVertex = new Vertex(board[y + 1][x], x, y + 1);
                    way.add(downVertex);
                }
                if (x + 1 < horizon && board[y][x + 1] != 0) {
                    Vertex rightVertex = new Vertex(board[y][x + 1], x + 1, y);
                    way.add(rightVertex);
                }
                if (x - 1 >= 0 && board[y][x - 1] != 0) {
                    Vertex leftVertex = new Vertex(board[y][x - 1], x - 1, y);
                    way.add(leftVertex);
                }
                String name = currentVertex.getX() + ":" + currentVertex.getY();
                wayMap.put(name, way);
            }
        }
        return wayMap;
    }
}
