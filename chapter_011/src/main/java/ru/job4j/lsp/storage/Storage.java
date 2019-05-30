package ru.job4j.lsp.storage;

import ru.job4j.lsp.product.Food;

import java.util.List;

public interface Storage {

    void add(Food food);

    boolean accept(Food food);

    List<Food> getStorage();
}
