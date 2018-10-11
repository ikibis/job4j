package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DynamicLinkedListTest {
    private DynamicLinkedList<Integer> list;

    @Before
    public void beforeTest() {
        list = new DynamicLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        Iterator<Integer> iter = list.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(3));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(2));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(1));
        assertThat(iter.hasNext(), is(false));
        iter.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        Iterator<Integer> iter = list.iterator();
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(3));
        assertThat(iter.next(), is(2));
        assertThat(iter.next(), is(1));
    }

    @Test
    public void shouldReturnFalseIfNoAny() {
        DynamicLinkedList<Integer> list1 = new DynamicLinkedList<>();
        Iterator<Integer> iter = list1.iterator();
        assertThat(iter.hasNext(), is(false));
    }

}

