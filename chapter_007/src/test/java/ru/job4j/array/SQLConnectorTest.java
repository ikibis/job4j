package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;

public class SQLConnectorTest {
    Program program;

    @Before
    public void createConnection() {
        program = new Program();
    }

    @Test
    public void startProgram() {
        long startTime = System.currentTimeMillis();
        program.start(10000);
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась " + timeSpent / 1000 + " секунд");
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
