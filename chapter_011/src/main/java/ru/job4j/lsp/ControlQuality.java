package ru.job4j.lsp;

import ru.job4j.lsp.product.Food;
import ru.job4j.lsp.storage.*;

public class ControlQuality {
    private final StorageFactory factory = StorageFactory.getInstance();

    public void add(Food food) {
        for (Storage store : factory.getStorageList()) {
            if (store.accept(food)) {
                store.add(food);
            }
        }
    }
}
