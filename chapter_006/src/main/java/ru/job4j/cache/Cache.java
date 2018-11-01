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

    public void update(Base model) {
        cache.replace(model.getId(), model);
        model.setVersion(model.getVersion() + 1);
    }

    public void delete(Base model) {
        cache.remove(model.getId(), model);
    }

    public ConcurrentHashMap.KeySetView<Integer, Base> keySet() {
        return cache.keySet();
    }

    public Object get(Object key) {
        return cache.get(key);
    }

}
