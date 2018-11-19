package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Hero {
    public String name;

    List<Hero> monsters = new ArrayList<>();

    public Monster(String name) {
        super(name);
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        if (Board.board[x][y].tryLock()) {
            Hero monster = new Hero(name);
            monster.setPosition(Board.board[x][y]);
            monsters.add(monster);
        }
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                super.way();
                int index = random.nextInt(super.steps.size());
                super.move(super.getPosition(), steps.get(index));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
