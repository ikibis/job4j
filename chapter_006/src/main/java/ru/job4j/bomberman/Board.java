package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class Board {
    static Hero hero;
    ReentrantLock[][] board;
    public int size;

    public Board(Hero hero, int size) {
        this.hero = hero;
        this.board = new ReentrantLock[size][size];
        this.size = size;
    }

    public static boolean move(ReentrantLock source, ReentrantLock dest) {
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
