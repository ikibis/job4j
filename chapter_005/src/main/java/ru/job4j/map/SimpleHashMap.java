package ru.job4j.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<K> {
    private HashBox[] hashmap;
    private int size = 0;
    private int modCount = 0;

    public SimpleHashMap() {
        this.hashmap = new HashBox[16];
    }

    private void checkSize() {
        if (size >= 0.75 * this.hashmap.length) {
            hashmap = Arrays.copyOf(hashmap, 16 + hashmap.length);
        }
    }

    private int generateHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int indexFor(int h) {
        return h & (hashmap.length - 1);
    }

    boolean insert(K key, V value) {
        boolean result = false;
        int hash = this.generateHash(key.hashCode());
        int index = indexFor(hash);
        if (hashmap[index] == null) {
            hashmap[index] = new HashBox(key, value);
            size++;
            modCount++;
            checkSize();
            result = true;
        }
        return result;
    }

    V get(K key) {
        V result = null;
        int hash = this.generateHash(key.hashCode());
        int index = indexFor(hash);
        return (V) this.hashmap[index];
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int iteratorIndex = 0;
            private int entryModCount = modCount;

            @Override
            public boolean hasNext() {
                checkModCount();
                return iteratorIndex <= size;
            }

            @Override
            public K next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (hashmap[iteratorIndex] == null) {
                    iteratorIndex++;
                }
                return (K) hashmap[iteratorIndex++].getValue();
            }

            private void checkModCount() throws ConcurrentModificationException {
                if (entryModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }
}

