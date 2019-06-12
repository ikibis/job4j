package ru.job4j.task22;

import java.util.*;

public class Robot {
    int optimalWay(int[][] board, int sx, int sy, int fx, int fy) {
        Vertex start = new Vertex(board[sy][sx], sx, sy);
        Vertex finish = new Vertex(board[fy][fx], fx, fy);
        Map<String, List<Vertex>> wayMap = fillVertexMap(board);
        List<LinkedList<Vertex>> allWays = this.fillWayList(wayMap, start, finish);
        List<LinkedList<Vertex>> filteredWays = this.filterWays(allWays, finish);
        return this.shortestWay(filteredWays);
    }

    int shortestWay(List<LinkedList<Vertex>> filteredWays) {
        Map<Integer, LinkedList<Vertex>> map = new HashMap<>();
        for (LinkedList<Vertex> list : filteredWays) {
            int way = 0;
            Vertex[] arr = list.toArray(new Vertex[0]);
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].getValue() < arr[i + 1].getValue()) {
                    way += arr[i + 1].getValue() - arr[i].getValue();
                }
            }
            map.put(way, list);
        }
        int key = new ArrayList<>(map.keySet()).get(0);
        System.out.println(key + ". Way : " + map.get(key));
        return key;
    }


    List<LinkedList<Vertex>> filterWays(List<LinkedList<Vertex>> allWays, Vertex finish) {
        List<LinkedList<Vertex>> filteredResult = new LinkedList<>();
        for (LinkedList<Vertex> list : allWays) {
            if (finish.equals(list.getLast())) {
                filteredResult.add(list);
            }
        }
        return filteredResult;
    }

    List<LinkedList<Vertex>> fillWayList(Map<String, List<Vertex>> wayMap, Vertex start, Vertex finish) {
        List<LinkedList<Vertex>> result = new LinkedList<>();
        Stack<Vertex> stack = new Stack<>();
        stack.push(start);
        LinkedList<Vertex> linkedList = new LinkedList<>();
        linkedList.add(start);
        result.add(linkedList);
        while (!stack.empty()) {
            Vertex currentVertex = stack.pop();
            if (currentVertex.equals(finish)) {
                continue;
            }
            List<LinkedList<Vertex>> resultCopy = new LinkedList<>(result);
            List<Vertex> list = wayMap.get(currentVertex.getX() + ":" + currentVertex.getY());
            for (Vertex vert : list) {
                for (LinkedList<Vertex> list1 : result) {
                    if (list1.getLast().equals(currentVertex) && !list1.contains(vert)) {
                        LinkedList<Vertex> newList = new LinkedList<>(list1);
                        newList.add(vert);
                        if (!resultCopy.contains(newList)) {
                            resultCopy.add(newList);
                            stack.push(vert);
                        }
                    }
                }
            }
            result = resultCopy;
        }
        return result;
    }

    Map<String, List<Vertex>> fillVertexMap(int[][] board) {
        int vert = board.length;
        int horizon = board[0].length;
        Map<String, List<Vertex>> wayMap = new HashMap<>();
        for (int y = 0; y < vert; y++) {
            for (int x = 0; x < horizon; x++) {
                List<Vertex> way = new ArrayList<>();
                Vertex currentVertex = new Vertex(board[y][x], x, y);
                if (y - 1 >= 0) {
                    Vertex upVertex = new Vertex(board[y - 1][x], x, y - 1);
                    way.add(upVertex);
                }
                if (y + 1 < vert) {
                    Vertex downVertex = new Vertex(board[y + 1][x], x, y + 1);
                    way.add(downVertex);
                }
                if (x + 1 < horizon) {
                    Vertex rightVertex = new Vertex(board[y][x + 1], x + 1, y);
                    way.add(rightVertex);
                }
                String name = currentVertex.getX() + ":" + currentVertex.getY();
                wayMap.put(name, way);
            }
        }
        return wayMap;
    }
}