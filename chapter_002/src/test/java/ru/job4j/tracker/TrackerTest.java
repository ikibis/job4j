package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2");
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findAll().get(0).getName(), is("test2"));
    }
    @Test
    public void whenAddNewItemsAndDeleteFirstItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2");
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
        Item item1 = new Item("test1", "testDescription");
        tracker.add(item1);
        Item item2 = new Item("test2", "testDescription2");
        tracker.add(item2);
        int result = tracker.findAll().size();
        assertThat(result, is(2));
    }
    @Test
    public void whenAddNewItemsAndFindByName() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");
        tracker.add(item1);
        assertThat(tracker.findByName(item1.getName()).get(0).getName(), is("test1"));
    }
    @Test
    public void whenAddNewItemsAndFindById() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1", "testDescription");
        tracker.add(item1);
        assertThat(tracker.findById(item1.getId()).equals(item1), is(true));
    }
}
