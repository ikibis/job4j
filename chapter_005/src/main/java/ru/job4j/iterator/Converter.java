package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator iterator = it.next();

            @Override
            public boolean hasNext() {
                this.check();
                return iterator.hasNext();
            }

            @Override
            public Integer next() throws NoSuchElementException {
                this.check();
                if (!iterator.hasNext()) {
                    throw new NoSuchElementException();
                }
                return (Integer) iterator.next();
            }
            private void check() {
                if (!iterator.hasNext() && it.hasNext()) {
                    iterator = it.next();
                }
            }
        };
    }
}
