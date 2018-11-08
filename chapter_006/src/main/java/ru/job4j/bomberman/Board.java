package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class Board {
    Hero hero;
    static ReentrantLock[][] board = new ReentrantLock[10][10];

    public Board(Hero hero) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new ReentrantLock();
            }
        }
        hero.setPosition(board[4][4]);
    }

    public int length() {
        System.out.println(board.length);
        return board.length;
    }

    public boolean move(ReentrantLock source, ReentrantLock dest) {
        boolean result = false;
        if (source.equals(hero.position)) {
            hero.position.unlock();
            hero.position = dest;
            hero.position.lock();
            result = true;
        }
        return result;
    }
}
