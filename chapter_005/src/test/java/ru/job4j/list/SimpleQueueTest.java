package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class SimpleQueueTest {
    private SimpleQueue<Integer> demoQueue;

    @Before
    public void beforeTest() {
        demoQueue = new SimpleQueue<>();
        demoQueue.push(1);
        demoQueue.push(2);
        demoQueue.push(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(demoQueue.poll(), is(1));
        demoQueue.push(4);
        assertThat(demoQueue.poll(), is(2));
        assertThat(demoQueue.poll(), is(3));
        assertThat(demoQueue.poll(), is(4));
    }

    @Test
    public void whenNotAddThenNull() {
        SimpleQueue<Integer> demoQueue2 = new SimpleQueue<>();
        assertThat(demoQueue2.poll(), is(nullValue()));
    }
}
