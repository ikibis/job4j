package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(    new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add("Menu.")
                        .add("---------------------")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("---------------------")
                        .add("------------ Adding a new item --------------")
                        .add("------------ New item with Id : " + tracker.findByName("test name")[0].getId() + "-----------")
                        .add("Menu.")
                        .add("---------------------")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("---------------------")
                        .toString()
                )
        );
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(    new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add("Menu.")
                        .add("---------------------")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("---------------------")
                        .add("------------ Edit item : --------------")
                        .add("Item with ID : " + item.getId() + " replaced")
                        .add("Menu.")
                        .add("---------------------")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("---------------------")
                        .toString()
                )
        );
    }

    @Test
    public void whenUserAddAndDeleteItemThenTrackerHasShowAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(    new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add("Menu.")
                        .add("---------------------")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("---------------------")
                        .add("------------ Delete item : --------------")
                        .add("Item with ID : " + item.getId() + " deleted")
                        .add("Menu.")
                        .add("---------------------")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("---------------------")
                        .toString()
                )
        );
    }

    @Test
    public void whenUserAddItemThenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(    new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add("Menu.")
                        .add("---------------------")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("---------------------")
                        .add("------------ Find item by Id : --------------")
                        .add(item.toString())
                        .add("Menu.")
                        .add("---------------------")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("---------------------")
                        .toString()
                )
        );
    }
    @Test
    public void whenUserAddItemThenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(    new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add("Menu.")
                        .add("---------------------")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("---------------------")
                        .add("------------ Find item by Name : --------------")
                        .add(item.toString())
                        .add("Menu.")
                        .add("---------------------")
                        .add("0. Add new Item")
                        .add("1. Show all items")
                        .add("2. Edit item")
                        .add("3. Delete item")
                        .add("4. Find item by Id")
                        .add("5. Find items by name")
                        .add("6. Exit Program")
                        .add("---------------------")
                        .toString()
                )
        );
    }
}