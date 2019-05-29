package ru.job4j.lsp.storage;

public class StorageFactory {
    private static final StorageFactory FACTORY = new StorageFactory();

    public static StorageFactory getInstance() {
        return FACTORY;
    }


}