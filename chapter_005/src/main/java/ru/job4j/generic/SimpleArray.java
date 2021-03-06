package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }

    public void set(int index, T model) {
        this.objects[index] = model;
    }

    public void delete(int index) {
        System.arraycopy(this.objects, index + 1, this.objects, index, this.index + 1 - index);
        this.objects[this.index--] = null;
    }

    public T get(int index) {
        return (T) this.objects[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                return iteratorIndex < index;
            }

            @Override
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) objects[iteratorIndex++];
            }
        };
    }
}
