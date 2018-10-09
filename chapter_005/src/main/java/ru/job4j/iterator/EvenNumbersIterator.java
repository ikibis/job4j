package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private final int[] values;
    private int index = 0;

    @Override
    public boolean hasNext() {
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                this.index = i;
                break;
            } else {
                index++;
            }
        }
        return values.length > index;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return values[index++];
    }

    public EvenNumbersIterator(final int[] values) {
        this.values = values;
    }
}
