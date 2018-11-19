package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Hero {
    public String name;
    private Bomberman bomberman = new Bomberman();
    List<Hero> monsters = new ArrayList<>();

    public Monster(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);
            if (Board.board[x][y].tryLock()) {
                super.setPosition(Board.board[x][y]);
                monsters.add(this);
                break;
            }
        }
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                super.way();
                int index = random.nextInt(steps.size());
                if (steps.get(index).equals(bomberman.getPosition())) {
                    bomberman.live = false;
                }
                super.move(super.getPosition(), steps.get(index));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
