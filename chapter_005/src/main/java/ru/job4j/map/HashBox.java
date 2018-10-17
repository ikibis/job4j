package ru.job4j.map;

public class HashBox<K, V> {
    public K key;
    public V value;

    public HashBox(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
