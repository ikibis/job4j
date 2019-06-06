package ru.job4j.lsp.storage;

import ru.job4j.lsp.product.Food;
import ru.job4j.lsp.product.RefrigeratorFood;

import java.util.LinkedList;
import java.util.List;

public class Refrigerator implements Storage {
    private static final Storage FACTORY = new Refrigerator();

    public static Storage getInstance() {
        return FACTORY;
    }
    private final List<Food> storage = new LinkedList<>();

    public void add(Food food) {
        this.storage.add(food);
    }

    @Override
    public boolean accept(Food food) {
        boolean result = false;
        if (((RefrigeratorFood) food).isVegetable()) {
            result = true;
        }
        return result;
    }

    public List<Food> getStorage() {
        return this.storage;
    }
}
