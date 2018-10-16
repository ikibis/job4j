package ru.job4j.map;

public class HashMapElement<K, V> {
    public K key;
    public V value;
    public HashMapElement(K key, V value) {
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
