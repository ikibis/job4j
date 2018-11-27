package ru.job4j.array;


import org.apache.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();
    private static final Logger LOGGER = Logger.getLogger(Config.class);
    private Connection connection;

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("appSQLLite.properties")) {
            values.load(in);

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }

    public void createNewDB() {
        try {
            this.connection = DriverManager.getConnection(
                    values.getProperty("url"),
                    values.getProperty("username"),
                    values.getProperty("password")
            );
            PreparedStatement tableItems = connection.prepareStatement(
                    "create table entry (id serial primary key, field integer );"
            );
            tableItems.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (this.connection != null) {
                try {
                    this.connection.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    public void deleteDB() {

        try {
            this.connection = DriverManager.getConnection(
                    values.getProperty("url"),
                    values.getProperty("username"),
                    values.getProperty("password")
            );
            PreparedStatement tableItems = connection.prepareStatement(
                    "drop table entry;"
            );
            tableItems.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (this.connection != null) {
                try {
                    this.connection.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    public boolean add(int number) {
        try {
            this.connection = DriverManager.getConnection(
                    values.getProperty("url"),
                    values.getProperty("username"),
                    values.getProperty("password")
            );
            PreparedStatement insertLine = this.connection.prepareStatement(
                    "insert into entry(field) values(?);"
            );
            insertLine.setString(1, String.valueOf(number));

            insertLine.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (this.connection != null) {
                try {
                    this.connection.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        return true;
    }

    public void findAll() {
        try {
            this.connection = DriverManager.getConnection(
                    values.getProperty("url"),
                    values.getProperty("username"),
                    values.getProperty("password")
            );
            PreparedStatement selectedLine = connection.prepareStatement(
                    "select * from entry;"
            );
            ResultSet rs = selectedLine.executeQuery();
            while (rs.next()) {
                System.out.println(String.format("%s", rs.getInt("field")));
            }
            rs.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (this.connection != null) {
                try {
                    this.connection.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }
}