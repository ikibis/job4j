package ru.job4j.search;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        var queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("middle", 3));
        queue.put(new Task("low", 5));
        queue.put(new Task("middle", 3));
        queue.put(new Task("middle1", 2));
        queue.put(new Task("middle", 3));
        queue.put(new Task("middle1", 2));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle1", 2));
        queue.put(new Task("middle", 3));
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));

        assertThat(queue.take().getDesc(), is("urgent"));
        assertThat(queue.take().getDesc(), is("urgent"));
        assertThat(queue.take().getDesc(), is("middle1"));
        assertThat(queue.take().getDesc(), is("middle1"));
        assertThat(queue.take().getDesc(), is("middle1"));
        assertThat(queue.take().getDesc(), is("middle"));
        assertThat(queue.take().getDesc(), is("middle"));
        assertThat(queue.take().getDesc(), is("middle"));
        assertThat(queue.take().getDesc(), is("middle"));
        assertThat(queue.take().getDesc(), is("low"));
        assertThat(queue.take().getDesc(), is("low"));
        assertThat(queue.take().getDesc(), is("low"));
    }
}