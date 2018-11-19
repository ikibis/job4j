package ru.job4j.bomberman;
public class Game {
    private int blocksQuantity;
    private int monstersQuantity;
    private Bomberman bomberman;

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

    public Game(int monstersQuantity, int blocksQuantity) {
        this.blocksQuantity = blocksQuantity;
        this.monstersQuantity = monstersQuantity;
    }

    public void gameStart() {
        bomberman = new Bomberman("Bomberman");
        new Board(bomberman);

        new Blocks(blocksQuantity);
        Thread bomberThread = new HeroThread(bomberman);


        for (int i = 0; i < monstersQuantity; i++) {
            Monster monster = new Monster("Monster " + i);
            Thread monsterThread = new HeroThread(monster);
            monsterThread.setDaemon(true);
            monsterThread.start();
        }
        bomberThread.start();
        try {
            bomberThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}