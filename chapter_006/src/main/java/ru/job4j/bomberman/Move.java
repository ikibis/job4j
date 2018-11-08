package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Move implements Runnable {

    final Random random = new Random();
    public ReentrantLock[][] board;
    public Hero hero;

    public Move(ReentrantLock[][] board, Hero hero) {
        this.board = board;
        this.hero = hero;
    }

    public List<ReentrantLock> way() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals(hero.position)) {
                    x = i;
                    y = j;
                }
            }
        }
        List<ReentrantLock> steps = new ArrayList<>();
        if (x - 1 >= 0) {
            steps.add(board[x - 1][y]);
        }
        if (x + 1 < board.length) {
            steps.add(board[x + 1][y]);
        }
        if (y - 1 >= 0) {
            steps.add(board[x][y - 1]);
        }
        if (y + 1 < board.length) {
            steps.add(board[x][y + 1]);
        }
        return steps;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            List<ReentrantLock> steps = this.way();
            ReentrantLock dest = null;
            while (dest == null) {
                try {
                    Thread.sleep(500);
                    dest = steps.get(random.nextInt(steps.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Board.move(hero.position, dest);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
