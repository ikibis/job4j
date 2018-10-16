package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<K> {
    private HashBox[] hashmap;
    private int size = 0;

    public SimpleHashMap() {
        this.hashmap = new HashBox[5];
    }

    private void checkSize() {
        if (size == this.hashmap.length) {
            HashBox[] containerCopy = new HashBox[this.hashmap.length + 5];
            int i = 0;
            for (HashBox element : hashmap) {
                containerCopy[i++] = element;
            }
            this.hashmap = containerCopy;
        }
    }

    private int generateHash(K key) {
        return 17 + 31 * key.hashCode();
    }

    private int indexFor(int h) {
        return h & (hashmap.length - 1);
    }

    boolean insert(K key, V value) {
        boolean result = true;
        if (size > 0) {
            int hash = this.generateHash(key);
            for (HashBox elements : hashmap) {
                if (elements != null && hash == (int) elements.getHash()) {
                    result = false;
                    break;
                }
            }
        }
        if (result) {
            checkSize();
            HashMapElement toInsert = new HashMapElement(key, value);
            int hash = this.generateHash(key);
            int index = this.indexFor(hash);
            hashmap[index] = new HashBox(hash, toInsert);
            size++;
        }
        return result;
    }

    V get(K key) {
        V result = null;
        for (HashBox elements : hashmap) {
            int hash = this.generateHash(key);
            if (hash == (int) elements.getHash()) {
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
                return (K) hashmap[iteratorIndex++].getValue();
            }
        };
    }
}
