package ru.job4j.task22;

import java.util.*;
import java.util.stream.Collectors;

public class Robot {
    int optimalWay(int[][] board, int sx, int sy, int fx, int fy) {
        int vert = board.length;
        int horizon = board[0].length;
        Vertex start = new Vertex(board[sy][sx], sx, sy);
        Stack<Vertex> stack = new Stack<>();
        Map<Vertex, List<Vertex>> wayMap = new HashMap<>();
        wayMap.put(start, List.of());
        stack.push(start);
        while (!stack.empty()) {
            Vertex currentVertex = stack.pop();
            currentVertex.setVisited(true);
            System.out.println(currentVertex.toString());
            if (currentVertex.y - 1 > 0) {
                Vertex upVertex = new Vertex(board[sy - 1][sx], sx, sy - 1);
                List<Vertex> currentList = wayMap.get(currentVertex);
                if (currentList != null && !currentList.contains(upVertex)) {
                    currentList.add(upVertex);
                    wayMap.put(upVertex, currentList);
                    stack.push(upVertex);
                }
            }
            if (currentVertex.y + 1 < vert) {
                Vertex downVertex = new Vertex(board[sy + 1][sx], sx, sy + 1);
                List<Vertex> currentList = wayMap.get(currentVertex);
                if (currentList != null && !currentList.contains(downVertex)) {
                    currentList.add(downVertex);
                    wayMap.put(downVertex, currentList);
                    stack.push(downVertex);
                }
            }
            if (currentVertex.x + 1 < horizon) {
                Vertex rightVertex = new Vertex(board[sy][sx + 1], sx + 1, sy);
                List<Vertex> currentList = wayMap.get(currentVertex);
                if (currentList != null && !currentList.contains(rightVertex)) {
                    currentList.add(rightVertex);
                    wayMap.put(rightVertex, currentList);
                    stack.push(rightVertex);
                }
            }
        }
        return 1;
    }
}
