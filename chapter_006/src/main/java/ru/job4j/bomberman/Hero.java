package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Hero implements Runnable {
    ReentrantLock position;
    final Random random = new Random();

    public void setPosition(ReentrantLock position) {
        this.position = position;
    }

    public synchronized List<ReentrantLock> way() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((Board.board[i][j]).equals(this.position)) {
                    x = i;
                    y = j;
                }
            }
        }
        List<ReentrantLock> steps = new ArrayList<>();
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
        return steps;
    }
    public boolean move(ReentrantLock source, ReentrantLock dest) {
        boolean result = false;
        if (source.equals(this.position)) {
            try {
                source.tryLock(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            source.unlock();
            source = dest;
            source.lock();
            result = true;
        }
        return result;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            List<ReentrantLock> steps = way();
            ReentrantLock dest = null;
            while (dest == null) {
                    dest = steps.get(random.nextInt(steps.size()));
            }
            try {
                this.move(this.position, dest);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
