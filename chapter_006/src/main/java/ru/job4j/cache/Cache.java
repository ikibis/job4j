package ru.job4j.cache;

import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    ConcurrentHashMap<Integer, Base> cache;

    public Cache() {
        this.cache = new ConcurrentHashMap<>();
    }

    public void add(Base model) {
        cache.put(model.getId(), model);
    }

    public void update(Base model) throws OptimisticException {
        cache.replace(model.getId(), model);
        int ver = model.getVersion();
        if (ver != model.getVersion()) {
            throw new OptimisticException();
        }
        cache.computeIfPresent(model.getId(), (k, v) -> v).setVersion(ver + 1);
    }

    public void delete(Base model) {
        cache.remove(model.getId(), model);
    }

    public Object get(Object key) {
        return cache.get(key);
    }
}

