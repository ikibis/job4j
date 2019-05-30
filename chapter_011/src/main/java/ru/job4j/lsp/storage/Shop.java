package ru.job4j.lsp.storage;

import ru.job4j.lsp.product.Food;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Shop implements Storage {

    private final List<Food> storage = new LinkedList<>();

    public void add(Food food) {
        this.storage.add(food);
    }

    @Override
    public boolean accept(Food food) {
        long createDate = food.getCreateDate().getTime();
        long expireDate = food.getExpireDate().getTime();
        long currentDate = new Date().getTime();
        long expiration = (currentDate - createDate) / (createDate - expireDate);
        if (expiration > 0.75 && expiration < 1) {
            food.setDiscount(true);
        }
        return expiration > 0.25 && expiration < 1;
    }

    public List<Food> getStorage() {
        return this.storage;
    }
}