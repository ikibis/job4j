package ru.job4j.bomberman;

import org.junit.Before;
import org.junit.Test;

public class BombermanTest {

    Hero hero;
    Move move;
    Board board;
    Thread one;
    Thread two;

    private class ThreadOne extends Thread {
        @Override
        public void run() {
            Move move = new Move();
            move.run();
        }
    }

    private class ThreadTwo extends Thread {
        @Override
        public void run() {
            Move move = new Move();
            move.run();
        }
    }

    @Before
    public void beforeTest() {
        hero = new Hero();
        board = new Board(hero);
        move = new Move(board, hero);
        one = new ThreadOne();
        two = new ThreadTwo();
    }

    @Test
    public void when2Threads() throws InterruptedException {
        one.start();

        two.start();

    }
}
