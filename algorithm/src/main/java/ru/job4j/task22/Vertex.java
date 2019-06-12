package ru.job4j.task22;

public class Vertex {

    public int value;
    public int x;
    public int y;

    public Vertex(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "" + this.x + this.y;
        //return "x = " + this.x + " y = " + this.y + " value = " + this.value + " isVisited = " + this.isVisited();
    }

    @Override
    public boolean equals(Object obj) {
        Vertex vertex = (Vertex) obj;
        return this.x == vertex.x && this.y == vertex.y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
