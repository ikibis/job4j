package ru.job4j.set;

import ru.job4j.generic.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    public SimpleArray<T> set;

    public SimpleSet(int size) {
        this.set = new SimpleArray<>(size);
    }

    public boolean add(T model) {
        boolean result = true;
        for (Object o : set) {
            if (o.equals(model)) {
                result = false;
                break;
            }
        }
        if (result) {
            set.add(model);
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}

