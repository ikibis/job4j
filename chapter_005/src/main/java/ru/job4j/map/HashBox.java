package ru.job4j.map;

public class HashBox<K, V> {
    public K hash;
    public V value;

    public HashBox(K hash, V value) {
        this.hash = hash;
        this.value = value;
    }

    public K getHash() {
        return hash;
    }

    public V getValue() {
        return value;
    }
}
