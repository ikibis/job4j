package ru.job4j.bomberman;

public class Game {
    private Hero hero = new Hero();
    private Board board = new Board(hero);
    private Thread bomberThread = new BomberThread();

    private class BomberThread extends Thread {
        @Override
        public void run() {
            hero.run();
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

/*
все поля сделай private !!!
создай класс Game  в котором будет создаваться доска, герой
метод который будет запускать игру
в котором будут запускаться потоки
сделай нормальный вывод в консоль с координатами
 */
