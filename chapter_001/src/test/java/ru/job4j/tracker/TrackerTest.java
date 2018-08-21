package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    public static void main(String args[]) {
        Tracker tracker = new Tracker();
        Item task1 = new Item("1212", "name", 12121212);
        Item task2 = new Item("1414", "name1", 14141414);
        tracker.add(task1);
        tracker.add(task2);

        System.out.println(task1.getId());
        System.out.println(task2.getId());
        task2.setId(task1.getId());
        System.out.println(task1.getId());
        System.out.println(task2.getId());
        System.out.println(tracker.findById(task2.getId()).getName());
        tracker.replace(task1.getId(), task2);

    }
   /* @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }*/
}
