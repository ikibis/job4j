package ru.job4j.lsp;

import ru.job4j.lsp.product.Food;
import ru.job4j.lsp.storage.*;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final StorageFactory factory = StorageFactory.getInstance();

    public void add(Food food) {
        for (Storage store : factory.getStorageList()) {
            if (store.accept(food)) {
                store.add(food);
            }
        }
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        List<Storage> storageList = factory.getStorageList();
        for (Storage store : storageList) {
            foods.addAll(store.getStorage());
        }
        for (Food food : foods) {
            this.add(food);
        }
    }
}
