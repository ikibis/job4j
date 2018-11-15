package ru.job4j.bomberman;

import java.util.ArrayList;
import java.util.List;

public class Monster extends Hero {
    List<Hero> monsters = new ArrayList<>();

    public Monster(int quantity) {
        while (monsters.size() < quantity) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            if (Board.board[x][y].tryLock()) {
                Hero monster = new Hero();
                monster.setPosition(Board.board[x][y]);
                monsters.add(monster);
            }
        }
        System.out.println(monsters.size());
    }

    @Override
    public void run() {
        for (Hero monster : monsters) {
            monster.run();
        }
    }
}
