package ru.job4j.cache;

public class Base {
    private int id;
    private String name;
    private int version = 0;

    public Base(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public synchronized int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }
}
