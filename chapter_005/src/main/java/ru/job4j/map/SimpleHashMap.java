package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<K> {
    HashMapElement[] hashmap;
    private int size = 0;

    public SimpleHashMap() {
        this.hashmap = new HashMapElement[5];
    }

    private void checkSize() {
        if (size == this.hashmap.length) {
            HashMapElement[] containerCopy = new HashMapElement[size + 5];
            int i = 0;
            for (HashMapElement element : hashmap) {
                containerCopy[i++] = element;
            }
            this.hashmap = containerCopy;
        }
    }

    boolean insert(K key, V value) {
        boolean result = true;
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (key.equals(hashmap[i].getKey())) {
                    result = false;
                    break;
                }
            }
        }
        if (result) {
            checkSize();
            hashmap[size++] = new HashMapElement(key, value);
        }
        return result;
    }

    V get(K key) {
        V result = null;
        for (HashMapElement elements : hashmap) {
            if (key.equals(elements.getKey())) {
                result = (V) elements.getValue();
            }
            break;
        }
        return result;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                return iteratorIndex < size;
            }

            @Override
            public K next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (K) hashmap[iteratorIndex++].getKey();
            }
        };
    }
}
