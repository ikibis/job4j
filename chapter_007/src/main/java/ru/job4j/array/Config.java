package ru.job4j.array;

import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("appSQLLite.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        this.init();
        return this.values.getProperty(key);
    }
}


