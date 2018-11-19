package ru.job4j.bomberman;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Blocks {
    private Random random = new Random();
    private HashMap<ReentrantLock, Coordinates> blocks = new HashMap<>();

    public Blocks(int quantity) {
        while (blocks.size() < quantity) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (Board.board[x][y].tryLock()) {
                Coordinates blockCoord = new Coordinates(x, y);
                blocks.put(Board.board[x][y], blockCoord);
                System.out.println("Block x = " + blockCoord.getX(blockCoord) + "; y = " + blockCoord.getY(blockCoord) + " status: " + Board.board[x][y]);
            }
        }
    }
}
