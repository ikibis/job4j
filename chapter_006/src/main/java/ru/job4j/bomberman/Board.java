package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class Board {
    private Hero hero;
    static ReentrantLock[][] board = new ReentrantLock[10][10];

    public Board(Hero hero) {
        this.hero = hero;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
        hero.setPosition(board[4][4]);
    }
}
