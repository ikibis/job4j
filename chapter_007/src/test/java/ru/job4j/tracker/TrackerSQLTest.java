package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {
    TrackerSQL sql;
    @Before
    public void beforeTest() {
        sql = new TrackerSQL();
        sql.createNewDB();
    }
    @Test
    public void checkConnection() {
        assertThat(sql.init(), is(true));
    }
    @Test
    public void checkAddItem() {
        Item item1 = new Item("task1", "description1");
        Item item2 = new Item("task2", "description2");
        Item item3 = new Item("task3", "description3");
        sql.add(item1);
        sql.add(item2);
        sql.add(item3);
        sql.findAll();
    }
    @Test
    public void checkReplaceItem() {
        Item item1 = new Item("task1", "description1");
        Item item2 = new Item("task2", "description2");
        sql.add(item1);
        sql.replace(String.valueOf(1), item2);
        sql.findAll();
    }
    @Test
    public void checkDeleteItem() {
        Item item1 = new Item("task1", "description1");
        Item item2 = new Item("task2", "description2");
        Item item3 = new Item("task3", "description3");
        sql.add(item1);
        sql.add(item2);
        sql.add(item3);
        sql.delete(String.valueOf(3));
        sql.findAll();
    }
    @Test
    public void checkFindAll() {
        Item item1 = new Item("task1", "description1");
        Item item2 = new Item("task2", "description2");
        Item item3 = new Item("task3", "description3");
        sql.add(item1);
        sql.add(item2);
        sql.add(item3);
        sql.findAll();
    }
    @Test
    public void checkFindByName() {
        Item item1 = new Item("task1", "description1");
        Item item2 = new Item("task2", "description2");
        Item item3 = new Item("task3", "description3");
        sql.add(item1);
        sql.add(item2);
        sql.add(item3);
        sql.findByName("task1");
    }
    @Test
    public void checkFindByID() {
        Item item1 = new Item("task1", "description1");
        Item item2 = new Item("task2", "description2");
        Item item3 = new Item("task3", "description3");
        sql.add(item1);
        sql.add(item2);
        sql.add(item3);
        sql.findById(String.valueOf(3));
    }
    @After
    public void afterTest() {
        sql.deleteDB();
    }

}