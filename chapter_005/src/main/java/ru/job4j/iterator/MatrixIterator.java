package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator {

    private final int[][] values;
    private int outIndex = 0;
    private int inIndex = 0;

    @Override
    public boolean hasNext() {
        this.check();
        return values.length > outIndex;
    }

    @Override
    public Object next() throws NoSuchElementException {
        int result;
        try {
            this.check();
            result = values[outIndex][inIndex++];
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
        return result;
    }

    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    private void check() {
        if (inIndex == values[outIndex].length) {
            outIndex++;
            inIndex = 0;
        }
    }
}
