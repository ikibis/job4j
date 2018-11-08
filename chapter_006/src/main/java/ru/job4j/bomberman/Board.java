package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class Board {
    public ReentrantLock[][] board;

    public Board(int sizeX, int sizeY) {
        board = new ReentrantLock[sizeX][sizeY];
    }

    public boolean move(ReentrantLock source, ReentrantLock dest) {
        boolean result = true;

        return result;
    }
}
