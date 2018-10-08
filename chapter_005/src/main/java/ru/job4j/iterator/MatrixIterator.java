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
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        Object result = values[outIndex][inIndex++];
        checkIndex();
        return result;
    }

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }
    private void checkIndex() {
        if (inIndex == values[outIndex].length) {
            outIndex++;
            inIndex = 0;
        }
    }
}
