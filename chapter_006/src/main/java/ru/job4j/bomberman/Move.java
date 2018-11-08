package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class Move implements Runnable {
    public Board board;
    public Hero hero;

    public Move(Board board, Hero hero) {
        this.board = board;
        this.hero = hero;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int coordX = hero.x;
            int coordy = hero.y;
            board.move(ReentrantLock source, ReentrantLock dest);
        }
    }
}
