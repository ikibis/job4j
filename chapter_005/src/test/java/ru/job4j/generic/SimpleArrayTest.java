package ru.job4j.generic;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleArrayTest {
    @Test
    public void createNewSimpleArrayAndAddAndGetElement() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        assertThat(array.get(0), is(1));
    }

    @Test
    public void createNewSimpleArrayAndAddAndSetElement() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        array.set(0, 2);
        assertThat(array.get(0), is(2));
    }

    @Test
    public void createNewSimpleArrayAndAddAndDeleteElement() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        array.delete(0);
        assertThat(array.get(0), is(nullValue()));
    }

    @Test
    public void createNewSimpleArrayAndAdd3AndDelete1Element() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.delete(2);
        assertThat(array.get(1), is(2));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        Iterator<Integer> iter = array.iterator();
        array.add(1);
        array.add(2);
        array.add(3);
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(1));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(2));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(3));
        assertThat(iter.hasNext(), is(false));
        iter.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        Iterator<Integer> iter = array.iterator();
        array.add(1);
        array.add(2);
        array.add(3);
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(1));
        assertThat(iter.next(), is(2));
        assertThat(iter.next(), is(3));
    }

    @Test
    public void shouldReturnFalseIfNoAnyEvenNumbers() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        Iterator<Integer> iter = array.iterator();
        assertThat(iter.hasNext(), is(false));
    }

    @Test
    public void allNumbersAreEven() {
        SimpleArray<Integer> array = new SimpleArray<>(10);
        Iterator<Integer> iter = array.iterator();
        array.add(1);
        array.add(2);
        array.add(3);
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(1));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(2));
        assertThat(iter.hasNext(), is(true));
        assertThat(iter.next(), is(3));
    }
}
