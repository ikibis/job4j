package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleHashMapTest {
    SimpleHashMap<Integer, String> hashmap;
    Iterator<Integer> iter;

    @Before
    public void beforeTest() {
        hashmap = new SimpleHashMap<>();
        iter = hashmap.iterator();
        hashmap.insert(1, "mark");
        hashmap.insert(2, "eva");
        hashmap.insert(3, "dasha");
    }

    @Test
    public void whenAddThreeElementsAndAddOneEqualsElement() {
        assertThat(hashmap.insert(4, "katya"), is(true));
        assertThat(hashmap.insert(4, "lena"), is(false));
    }

    @Test
    public void whenAddThreeElementsAndIterate() {
        assertThat(iter.next(), is(1));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(2));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(3));
        assertThat(iter.hasNext(), is(false));
    }

    @Test
    public void whenAddElementsAndSizeUp() {
        hashmap.insert(4, "mark");
        hashmap.insert(5, "mark");
        assertThat(hashmap.insert(6, "mark"), is(true));
        hashmap.insert(7, "mark");
        hashmap.insert(8, "eva");
        hashmap.insert(9, "dasha");
        assertThat(hashmap.insert(10, "mark"), is(true));
        assertThat(hashmap.insert(11, "mark"), is(true));
    }
}
