package ru.job4j.task22;

public class Vertex {

    public int value;
    public int x;
    public int y;
    private boolean isVisited;
    public Vertex previous;

    public Vertex(int value, int x, int y) {
        this.value = value;
        this.x = x;
        this.y = y;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    @Override
    public String toString() {
        return "x = " + this.x + " y = " + this.y + " value = " + this.value + " isVisited = " + this.isVisited();
    }
   /* @Override
    public boolean equals(Object obj) {
        Vertex vertex = (Vertex) obj;
        return this.value == vertex.value && this.x == vertex.x && this.y == vertex.y;
    }*/
}
