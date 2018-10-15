package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    SimpleSet<Integer> set;
    Iterator<Integer> it;

    @Before
    public void beforeTest() {
        set = new SimpleSet<>(10);
        it = set.iterator();
        set.add(1);
        set.add(2);
        set.add(3);
    }

    @Test
    public void whenAddThreeElementsAndAddOneEqualsElement() {
        assertThat(set.add(4), is(true));
        assertThat(set.add(4), is(false));
    }

    @Test
    public void whenAddThreeElementsAndCreateIterator() {
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }
}
