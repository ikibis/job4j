package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class Board {
    static ReentrantLock[][] board = new ReentrantLock[8][8];
    public Board(Bomberman bomberman) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
        bomberman.setPosition(board[3][3]);
    }
}
