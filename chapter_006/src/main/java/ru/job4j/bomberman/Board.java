package ru.job4j.bomberman;

public class Board {
    Hero hero;

    public Board(Hero hero) {
        this.hero = hero;
    }

    public boolean move(Cell source, Cell dest) {
        boolean result = false;
        if (source.equals(hero.position)) {
            hero.position = dest;
            result = true;
        }
        return result;
    }
}
