package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private final int[] values;
    private int index = 0;

    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() throws NoSuchElementException {
        try {
            while (values[index] % 2 != 0) {
                index++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
        return values[index++];
    }

    public EvenNumbersIterator(final int[] values) {
        this.values = values;
    }
}
