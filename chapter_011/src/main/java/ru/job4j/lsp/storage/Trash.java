package ru.job4j.lsp.storage;

import ru.job4j.lsp.product.Food;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Trash implements Storage {

    private final List<Food> storage = new LinkedList<>();

    public void add(Food food) {
        this.storage.add(food);
    }

    public boolean accept(Food food) {
        long createDate = food.getCreateDate().getTime();
        long expireDate = food.getExpireDate().getTime();
        long currentDate = new Date().getTime();
        long expiration = (currentDate - createDate) / (createDate - expireDate);
        return expiration >= 1;
    }

    public List<Food> getStorage() {
        return this.storage;
    }
}