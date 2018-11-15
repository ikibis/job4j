package ru.job4j.bomberman;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Blocks {
    private Random random = new Random();
    private HashMap<ReentrantLock, Coordinates> blocks = new HashMap<>();
    private Coordinates posCoord = new Coordinates();
    public Blocks(int quantity) {
        while (blocks.size() < quantity) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            if (Board.board[x][y].tryLock()) {
                blocks.put(Board.board[x][y], new Coordinates(x, y));
            }
        }
    }
}
