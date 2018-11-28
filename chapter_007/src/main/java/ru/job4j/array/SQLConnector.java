package ru.job4j.array;

import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLConnector {
    private static final Logger LOGGER = Logger.getLogger(SQLConnector.class);
    private Config config;

    public SQLConnector(Config config) {
        this.config = config;
    }

    public void createNewDB() {
        try (Connection conn = DriverManager.getConnection(
                config.get("url"),
                config.get("username"),
                config.get("password"))) {
            if (conn != null) {
                PreparedStatement tableItems = conn.prepareStatement(
                        "create table entry (field integer );"
                );
                tableItems.executeUpdate();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void deleteDB() {
        try (Connection conn = DriverManager.getConnection(
                config.get("url"),
                config.get("username"),
                config.get("password"))) {
            if (conn != null) {
                PreparedStatement tableItems = conn.prepareStatement(
                        "drop table entry;"
                );
                tableItems.executeUpdate();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    public boolean add(int number) {
        try (Connection conn = DriverManager.getConnection(
                config.get("url"),
                config.get("username"),
                config.get("password"))) {
            if (conn != null) {
                PreparedStatement tableItems = conn.prepareStatement(
                        "insert into entry(field) values(?);"
                );
                tableItems.setString(1, String.valueOf(number));
                tableItems.executeUpdate();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
        return true;
    }

    public void findAll() {
        try (Connection conn = DriverManager.getConnection(
                config.get("url"),
                config.get("username"),
                config.get("password"))) {
            if (conn != null) {
                PreparedStatement tableItems = conn.prepareStatement(
                        "select * from entry;"
                );
                ResultSet rs = tableItems.executeQuery();
                while (rs.next()) {
                    System.out.println(String.format("%s", rs.getInt("field")));
                }
                rs.close();
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    public List<XmlUsage.Field> generate(int n) {
        List<XmlUsage.Field> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            this.add(i);
            result.add(new XmlUsage.Field(i));
        }
        return result;
    }
}