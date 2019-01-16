package ru.job4j.array;

import org.junit.Before;
import org.junit.Test;

import java.net.URISyntaxException;

public class SQLConnectorTest {
    Program program;
    String path = "/home/ilya/job4j/chapter_007/src/main/java/ru/job4j/array/";

    @Before
    public void createConnection() {
        program = new Program();
    }

    @Test
    public void startProgram() throws URISyntaxException {
        long startTime = System.currentTimeMillis();
        program.start(100);
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
