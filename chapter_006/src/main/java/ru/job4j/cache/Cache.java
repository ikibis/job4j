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
        int ver = model.getVersion();
        cache.computeIfPresent(model.getId(), (k, v) -> {
                    if (ver != v.getVersion()) {
                        throw new OptimisticException();
                    }
                    v.setVersion(ver + 1);
                    cache.replace(model.getId(), v);
                    return v;
                }
        );
    }

        public void delete (Base model){
            cache.remove(model.getId(), model);
        }

        public Object get (Object key){
            return cache.get(key);
        }
    }

