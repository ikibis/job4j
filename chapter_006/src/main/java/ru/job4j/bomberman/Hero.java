package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class Hero {
    ReentrantLock position;

    public Hero(ReentrantLock position) {
        this.position = position;
    }
}
