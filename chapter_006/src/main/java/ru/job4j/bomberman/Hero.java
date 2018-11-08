package ru.job4j.bomberman;

public class Hero {
    int x;
    int y;

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setDestination(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
