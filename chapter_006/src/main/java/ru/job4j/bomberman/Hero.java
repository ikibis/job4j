package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class Hero {
    ReentrantLock position;

    public void setPosition(ReentrantLock position) {
        this.position = position;
    }
}
