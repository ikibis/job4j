package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;

public class ConfigTest {
    Config config;

    @Before
    public void beforeTest() {
        config = new Config();
    }

    @Test
    public void checkConnection() {
        config.init();
        config.createNewDB();
    }
    @Test
    public void insert() {

        config.add(1);
    }
    @Test
    public void checkfindAll() {

        config.add(5);
        config.findAll();
    }
    @Test
    public void dropTable() {

        config.deleteDB();
    }
}
