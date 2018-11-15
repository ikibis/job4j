package ru.job4j.bomberman;

public class Coordinates {
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }

    public int getX(Coordinates coordinates) {
        return coordinates.x;
    }

    public int getY(Coordinates coordinates) {
        return coordinates.y;
    }
}
