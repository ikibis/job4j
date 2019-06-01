package ru.job4j.lsp.storage;

import java.util.ArrayList;
import java.util.List;

public class StorageFactory {
    private static final StorageFactory FACTORY = new StorageFactory();
    private List<Storage> storageList = new ArrayList<>();

    public static StorageFactory getInstance() {
        return FACTORY;
    }

    {
        storageList.add(new Warehouse());
        storageList.add(new NewWarehouse());
        storageList.add(new Shop());
        storageList.add(new Trash());
        storageList.add(new Refrigerator());
    }

    public List<Storage> getStorageList() {
        return this.storageList;
    }
}