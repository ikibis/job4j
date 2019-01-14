package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {

    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")


            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException, IOException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }



/*

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
    */
}

