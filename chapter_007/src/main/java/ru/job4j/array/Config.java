package ru.job4j.array;

import org.apache.log4j.Logger;

import java.sql.*;

public class Config {
    private static final Logger LOGGER = Logger.getLogger(Config.class);

    public void init() {
        String url = "jdbc:sqlite:/home/ilya/job4j/chapter_007/src/main/java/ru/job4j/array/test.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();

                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void createNewDB() {
        String url = "jdbc:sqlite:/home/ilya/job4j/chapter_007/src/main/java/ru/job4j/array/test.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement tableItems = conn.prepareStatement(
                        "create table entry (id serial primary key, field integer );"
                );
                tableItems.executeUpdate();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("createNewDB catch (SQLException e)");
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void deleteDB() {
        String url = "jdbc:sqlite:/home/ilya/job4j/chapter_007/src/main/java/ru/job4j/array/test.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement tableItems = conn.prepareStatement(
                        "drop table entry;"
                );
                tableItems.executeUpdate();
                conn.close();
            }
        } catch (SQLException e) {
            LOGGER.info("public void deleteDB() catch (SQLException e)");
            LOGGER.error(e.getMessage(), e);
        }
    }

    public boolean add(int number) {
        String url = "jdbc:sqlite:/home/ilya/job4j/chapter_007/src/main/java/ru/job4j/array/test.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement insertLine = conn.prepareStatement(
                        "insert into entry(field) values(?);"
                );
                insertLine.setString(1, String.valueOf(number));
                insertLine.executeUpdate();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("public boolean add(int number) catch (SQLException e)");
            LOGGER.error(e.getMessage(), e);
        }
        return true;
    }

    public void findAll() {
        String url = "jdbc:sqlite:/home/ilya/job4j/chapter_007/src/main/java/ru/job4j/array/test.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                PreparedStatement selectedLine = conn.prepareStatement(
                        "select * from entry;"
                );
                ResultSet rs = selectedLine.executeQuery();
                while (rs.next()) {
                    System.out.println(String.format("%s", rs.getInt("field")));
                }
                rs.close();
                conn.close();
            }
        } catch (SQLException e) {
            LOGGER.info("public void findAll() catch (SQLException e)");
            LOGGER.error(e.getMessage(), e);

        }
    }
}