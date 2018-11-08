package ru.job4j.bomberman;

import org.junit.Before;
import org.junit.Test;

public class BombermanTest {

    Hero hero;
    Board board;
    Thread one;
    Thread two;

    private class ThreadOne extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                hero.run();
            }
        }
    }

    private class ThreadTwo extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                hero.run();
            }
        }
    }

    @Before
    public void beforeTest() {
        hero = new Hero();
        board = new Board(hero);
        one = new ThreadOne();
        two = new ThreadTwo();
    }

    @Test
    public void when2Threads() throws InterruptedException {
        one.start();
        two.start();
    }
}
