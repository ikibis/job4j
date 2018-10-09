package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

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
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            T current = iterator.next();
            Predicate<T> predicate = p -> p.equals(this.objects[index]);
            if (predicate.test(current)) {
                for (int i = index; i <= this.index; i++) {
                    this.objects[i] = this.objects[i + 1];
                }
                this.objects[this.index--] = null;
                break;
            }
        }
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
