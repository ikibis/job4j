package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Move implements Runnable {

    final Random random = new Random();
    public Hero hero;
    Board board;

    public Move(Board board, Hero hero) {
        this.board = board;
        this.hero = hero;
    }

    public Move() {
    }

    public synchronized List<ReentrantLock> way() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                //System.out.println(hero.position);
                //System.out.println(Board.board[i][j]);
                if ((Board.board[i][j]).equals(null)) {
                    x = i;
                    y = j;
                }
            }
        }
        List<ReentrantLock> steps = new ArrayList<>();
        if (x - 1 >= 0) {
            steps.add(board.board[x - 1][y]);
        }
        if (x + 1 < board.length()) {
            steps.add(board.board[x + 1][y]);
        }
        if (y - 1 >= 0) {
            steps.add(board.board[x][y - 1]);
        }
        if (y + 1 < board.length()) {
            steps.add(board.board[x][y + 1]);
        }
        return steps;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            List<ReentrantLock> steps = way();
            ReentrantLock dest = steps.get(random.nextInt(steps.size()));
            while (!dest.tryLock()) {
                try {
                    Thread.sleep(500);
                    dest = steps.get(random.nextInt(steps.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {

                board.move(hero.position, dest);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
