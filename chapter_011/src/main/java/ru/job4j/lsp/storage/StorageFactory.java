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
        storageList.add(Warehouse.getInstance());
        storageList.add(NewWarehouse.getInstance());
        storageList.add(Shop.getInstance());
        storageList.add(Trash.getInstance());
        storageList.add(Refrigerator.getInstance());
        storageList.add(RecycleStorage.getInstance());
    }

    public List<Storage> getStorageList() {
        return this.storageList;
    }
}