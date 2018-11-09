package ru.job4j.bomberman;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Hero implements Runnable {
    ReentrantLock position;
    Queue<ReentrantLock> steps = new LinkedList<>();

    public void setPosition(ReentrantLock position) {
        this.position = position;
    }

    public synchronized void way() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((Board.board[i][j]).equals(this.position)) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        if (x - 1 >= 0) {
            steps.add(Board.board[x - 1][y]);
        }
        if (x + 1 < Board.board.length) {
            steps.add(Board.board[x + 1][y]);
        }
        if (y - 1 >= 0) {
            steps.add(Board.board[x][y - 1]);
        }
        if (y + 1 < Board.board.length) {
            steps.add(Board.board[x][y + 1]);
        }
    }

    public boolean move(ReentrantLock source, ReentrantLock dest) {
        boolean result = false;
        if (source.equals(this.position)) {
            try {
                ReentrantLock moveDest = dest;
                while (!steps.isEmpty()) {
                    if (moveDest.tryLock(500, TimeUnit.MILLISECONDS)) {

                        source.unlock();
                        this.position = moveDest;
                        System.out.println("source :" + source + " dest :" + dest);
                        result = true;
                        break;
                    } else {
                        moveDest = steps.poll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        steps = new LinkedList<>();
        return result;
    }

    @Override
    public void run() {
        this.position.lock();
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                this.way();
                this.move(this.position, steps.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

