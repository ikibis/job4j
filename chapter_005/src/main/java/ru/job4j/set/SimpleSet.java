package ru.job4j.set;

import ru.job4j.generic.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleArray<T> set;

    public SimpleSet(int size) {
        this.set = new SimpleArray<>(size);
    }

    private boolean isUnicue(T model) {
        boolean result = true;
        for (Object o : this.set) {
            if (o.equals(model)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean add(T model) {
        boolean result = false;
        if (this.isUnicue(model)) {
            set.add(model);
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}

