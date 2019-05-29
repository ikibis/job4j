package ru.job4j.lsp.storage;

import ru.job4j.lsp.product.Food;

import java.util.LinkedList;
import java.util.List;

public class Warehouse implements Storage {

    private final List<Food> storage = new LinkedList<>();

    public void add(Food food) {
        this.storage.add(food);
    }

    public List<Food> getStorage() {
        return this.storage;
    }
}
