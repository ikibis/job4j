package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenAddNewItemsAndDeleteFirstItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker.add(item2);
        String deletedId = item2.getId();
        tracker.delete(item2.getId());
        boolean result = false;
        if (tracker.findById(deletedId) == null) {
            result = true;
        }
        assertThat(result, is(true));
    }
    @Test
    public void whenAddNewItemsAndFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2", 1234L);
        tracker.add(item2);
        int result = tracker.findAll().length;
        assertThat(result, is(2));
    }
    @Test
    public void whenAddNewItemsAndFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        assertThat(tracker.findByName(item1.getName())[0].equals(item1), is(true));
    }
    @Test
    public void whenAddNewItemsAndFindById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription", 123L);
        tracker.add(item1);
        assertThat(tracker.findById(item1.getId()).equals(item1), is(true));
    }
}
