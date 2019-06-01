package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class Item implements Comparable<Item> {

    private String name;
    private String number;
    private Item parent;
    private List<Item> children;

    public Item(String number, String name) {
        this.number = number;
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void setParent(Item parent) {
        this.parent = parent;
    }

    public List<Item> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public Item getParent() {
        return parent;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public int compareTo(Item o) {
        return number.compareTo(o.getNumber());
    }
}