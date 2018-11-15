package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Bomberman extends Hero {
    private ReentrantLock position;
    private List<ReentrantLock> steps = new ArrayList<>();
    private Coordinates posCoord = new Coordinates();
    Random random = new Random();

    public void setPosition(ReentrantLock position) {
        super.setPosition(position);
    }
}
