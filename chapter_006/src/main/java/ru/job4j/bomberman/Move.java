package ru.job4j.bomberman;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Move implements Runnable {
    private final Lock monitor = new ReentrantLock();
    final Random random = new Random();
    public Board board;
    public Hero hero;

    public Move(Board board, Hero hero) {
        this.board = board;
        this.hero = hero;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            List<Cell> steps = hero.way();
            Cell dest = null;
            while (dest == null) {
                try {
                    Thread.sleep(500);
                    dest = steps.get(random.nextInt(steps.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.monitor.lock();
            try {
                board.move(hero.position, dest);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.monitor.unlock();
            }
        }
    }
}
