package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;

public class SQLConnectorTest {
    SQLConnector sql;
    Config config;

    @Before
    public void createConnection() {
        config = new Config();
        sql = new SQLConnector(config);
    }

    @Test
    public void createDB() {
        sql.createNewDB();
    }

    @Test
    public void addvalues() {
        for (int i = 0; i < 10; i++) {
            sql.add(i);
        }
        sql.findAll();
    }

    @Test
    public void dropTable() {
        sql.deleteDB();
    }

    @Test
    public void propertiesTest() {
        Config conf = new Config();
        System.out.println(conf.get("url"));
        System.out.println(conf.get("username"));
        System.out.println(conf.get("password"));
        System.out.println(conf.get("driver-class-name"));
    }

}
