package ru.job4j.bomberman;

import org.junit.Test;

public class BombermanTest {

    private class ThreadOne extends Thread {
        Hero hero;

        public ThreadOne(Hero hero) {
            this.hero = hero;
        }

        @Override
        public void run() {
            hero.run();
        }
    }

    @Test
    public void when2Threads() throws InterruptedException {
        Hero hero = new Hero();
        Board board = new Board(hero);
        Thread one = new ThreadOne(hero);
        one.start();
        one.join();
    }
}
