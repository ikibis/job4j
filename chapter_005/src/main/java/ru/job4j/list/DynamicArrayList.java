package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayList<T> implements Iterable<T> {
    private Object[] container;
    private int index = 0;
    private int modCount = 0;

    public DynamicArrayList() {
        this.container = new Object[5];
    }

    public void add(T model) {
        checkSize();
        modCount++;
        this.container[index++] = model;
    }

    public T get(int index) {
        return (T) this.container[index];
    }
    private void checkSize() {

        if (index == this.container.length - 1) {
            Object[] containerCopy = new Object[this.container.length + 5];
            System.arraycopy(this.container, 5, containerCopy, 0, 5);
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int iteratorIndex = 0;
            private int modCountCopy = modCount;

            @Override
            public boolean hasNext() throws ConcurrentModificationException {
                checkModCount();
                return iteratorIndex < index;
            }

            @Override
            public T next() throws NoSuchElementException, ConcurrentModificationException {
                checkModCount();
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[iteratorIndex++];
            }

            private void checkModCount() throws ConcurrentModificationException {
                if (modCountCopy != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };

    }
}
