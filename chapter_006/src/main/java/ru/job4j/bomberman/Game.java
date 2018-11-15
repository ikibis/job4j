package ru.job4j.bomberman;

public class Game {
    private Monster monster;

    public Game(int blocksQuantity, int monsterQuantity) {
        new Board();
        new Blocks(blocksQuantity);
        monster = new Monster(monsterQuantity);
    }

    private Thread bomberThread = new BomberThread();

    private class BomberThread extends Thread {
        @Override
        public void run() {
            monster.run();
        }
    }

    public void gameStart() {
        bomberThread.start();
        try {
            bomberThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
