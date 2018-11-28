package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;

public class ConfigTest {
    Config config;

    @Before
    public void beforeTest() {
        config = new Config();
        config.init();
        config.createNewDB();
    }

    @Test
    public void insert() {
        for (int i = 0; i < 10; i++) {
            config.add(i);
        }
        config.findAll();
    }
/*
    @Test
    public void dropTable() {
        config.deleteDB();
    }
    */
}
