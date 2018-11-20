package ru.job4j.bomberman;

public class Game {
    private int blocksQuantity;
    private int monstersQuantity;

    private class HeroThread extends Thread {
        private Hero hero;

        public HeroThread(Hero hero) {
            this.hero = hero;
        }

        @Override
        public void run() {
            hero.run();
        }
    }
    private class MonsterThread extends Thread {
        private Monster monster;

        public MonsterThread(Monster monster) {
            this.monster = monster;
        }

        @Override
        public void run() {
            monster.run();
        }
    }
    public Game(int monstersQuantity, int blocksQuantity) {
        this.blocksQuantity = blocksQuantity;
        this.monstersQuantity = monstersQuantity;
    }

    public void gameStart() {
        Bomberman bomberman = new Bomberman("Bomberman");
        new Board(bomberman);
        new Blocks(blocksQuantity);
        Thread bomberThread = new HeroThread(bomberman);
        bomberThread.start();

        for (int i = 0; i < monstersQuantity; i++) {
            Monster monster = new Monster("Monster " + i);
            Thread monsterThread = new MonsterThread(monster);
            monsterThread.setDaemon(true);
            monsterThread.start();
        }
        try {
            bomberThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}