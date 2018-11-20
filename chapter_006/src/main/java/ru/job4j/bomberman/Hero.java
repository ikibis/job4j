package ru.job4j.bomberman;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Hero implements Runnable {
    public String name;
    private ReentrantLock position;
    public List<ReentrantLock> steps = new ArrayList<>();
    private Coordinates posCoord = new Coordinates();

    Random random = new Random();

    public void setPosition(ReentrantLock position) {
        this.position = position;
    }
    public ReentrantLock getPosition() {
       return this.position;
    }
    public Hero(String name) {
        this.name = name;
    }
    public synchronized void way() {
        Coordinates pos = findCoordinates(this.position);
        int x = posCoord.getX(pos);
        int y = posCoord.getY(pos);
        if (x - 1 >= 0) {
            steps.add(Board.board[x - 1][y]);
        }
        if (x + 1 < Board.board.length) {
            steps.add(Board.board[x + 1][y]);
        }
        if (y - 1 >= 0) {
            steps.add(Board.board[x][y - 1]);
        }
        if (y + 1 < Board.board.length) {
            steps.add(Board.board[x][y + 1]);
        }
    }

    private Coordinates findCoordinates(ReentrantLock position) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((Board.board[i][j]).equals(position)) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        return new Coordinates(x, y);
    }

    public void move(ReentrantLock source, ReentrantLock dest) {
        if (source.equals(this.position)) {
            try {
                ReentrantLock moveDest = dest;
                while (!Thread.currentThread().isInterrupted()) {
                    if (moveDest.tryLock(500, TimeUnit.MILLISECONDS)) {
                        Coordinates posSource = findCoordinates(source);
                        Coordinates posDest = findCoordinates(dest);
                        source.unlock();
                        this.position = moveDest;
                        System.out.println(this.name + " source : x = " + posCoord.getX(posSource)
                                + "  y = " + posCoord.getY(posSource)
                                + " dest : x = " + posCoord.getX(posDest)
                                + "  y = " + posCoord.getY(posDest) + " " + Thread.currentThread().getName());
                        break;
                    } else {
                        int index = random.nextInt(steps.size());
                        moveDest = steps.get(index);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        steps = new LinkedList<>();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            this.position.lock();
            try {
                Thread.sleep(1000);
                if (this.position.hasQueuedThreads()) {
                    System.out.println("Bomber is dead GAME OVER!!!");
                    Thread.currentThread().interrupt();
                }
                this.way();
                int index = random.nextInt(steps.size());
                this.move(this.position, steps.get(index));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}