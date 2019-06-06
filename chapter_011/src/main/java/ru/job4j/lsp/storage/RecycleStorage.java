package ru.job4j.lsp.storage;

import ru.job4j.lsp.product.CanRecyclingFood;
import ru.job4j.lsp.product.Food;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class RecycleStorage implements Storage {
    private static final Storage FACTORY = new RecycleStorage();

    public static Storage getInstance() {
        return FACTORY;
    }
    private final List<Food> storage = new LinkedList<>();

    @Override
    public void add(Food food) {
        this.storage.add(food);
    }

    @Override
    public boolean accept(Food food) {
        boolean result = false;
        if (((CanRecyclingFood) food).isCanRecycling()) {
            long createDate = food.getCreateDate().getTime();
            long expireDate = food.getExpireDate().getTime();
            long currentDate = new Date().getTime();
            long expiration = (currentDate - createDate) / (createDate - expireDate);
            result = expiration >= 1;
        }
        return result;
    }

    @Override
    public List<Food> getStorage() {
        return this.storage;
    }
}