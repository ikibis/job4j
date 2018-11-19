package ru.job4j.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class Bomberman extends Hero {
    private ReentrantLock position;
    public static boolean live = true;
    public Bomberman(String name) {
        super(name);
    }

    public Bomberman() {
    }

    @Override
    public void setPosition(ReentrantLock position) {
        super.setPosition(position);
    }

    public ReentrantLock getPosition() {
        return super.getPosition();
    }
}
