package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int outIndex = 0;
    private int inIndex = 0;

    @Override
    public boolean hasNext() {
        return values.length > outIndex;
    }

    @Override
    public Object next() throws NoSuchElementException {
        Object result;
        if (this.hasNext()) {
            result = values[outIndex][inIndex++];
            if (inIndex == values[outIndex].length) {
                outIndex++;
                inIndex = 0;
            }
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }
}
