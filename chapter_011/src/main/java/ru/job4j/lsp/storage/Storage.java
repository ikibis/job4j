package ru.job4j.lsp.storage;

import ru.job4j.lsp.product.Food;

import java.util.List;

public interface Storage {

    public void add(Food food);

    public List<Food> getStorage();
}
