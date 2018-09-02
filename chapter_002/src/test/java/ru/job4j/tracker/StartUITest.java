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
    private  final PrintStream stdout = System.out;
    private  final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private  String ls = System.lineSeparator();
    private StringBuilder menu = new StringBuilder()
        .append("0. Add new Item").append(ls)
        .append("1. Show all items").append(ls)
        .append("2. Edit item").append(ls)
        .append("3. Delete item").append(ls)
        .append("4. Find item by Id").append(ls)
        .append("5. Find items by name").append(ls)
        .append("6. Exit Program");

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
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"0", "test", "desk", "y"}));
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add(menu)
                        .add("------------ Adding new item --------------")
                        .add("------------ New Item with Id : " + tracker.findAll()[0].getId())
                        .add("------------ New Item with Name : test")
                        .add("------------ New Item with Description : desk")
                        .toString()
                )
        );
    }
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{
                        "2", item.getId(), "test replace", "заменили заявку", "y"}));
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add(menu)
                        .add("------------ Edit item : --------------")
                        .add("Item with ID : " + item.getId() + " replaced")
                        .toString()
                )
        );
    }
    @Test
    public void whenUserAddAndDeleteItemThenTrackerHasShowAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"3", item.getId(), "y"}));
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add(menu)
                        .add("------------ Delete item : --------------")
                        .add("Item with ID : " + item.getId() + " deleted")
                        .toString()
                )
        );
    }
    @Test
    public void whenUserAddItemThenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"4", item.getId(), "y"}));
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add(menu)
                        .add("------------ Find item by Id : --------------")
                        .add(item.toString())
                        .toString()
                )
        );
    }
    @Test
    public void whenUserAddItemThenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        ValidateInput input = new ValidateInput(
            new StubInput(new String[]{"5", item.getName(), "y"}));
        new StartUI(input, tracker).init();
        assertThat(
                new String(this.out.toByteArray()),
                is(new StringJoiner(
                        System.lineSeparator(), "",
                        System.lineSeparator())
                        .add(menu)
                        .add("------------ Find item by Name : --------------")
                        .add(item.toString())
                        .toString()
                )
        );
    }
}