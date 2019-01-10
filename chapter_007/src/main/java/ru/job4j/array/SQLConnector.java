package ru.job4j.array;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLConnector {

    private static final Logger LOGGER = LogManager.getLogger(SQLConnector.class.getName());
    Connection conn;

    public SQLConnector(Config config) {
        try {
            conn = DriverManager.getConnection(
                    config.get("url"),
                    config.get("username"),
                    config.get("password"));
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void createNewDB() {
        try {
            if (conn != null) {
                PreparedStatement tableItems = conn.prepareStatement(
                        "create table entry (field integer );"
                );
                tableItems.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void deleteDB() {
        try {
            if (conn != null) {
                PreparedStatement tableItems = conn.prepareStatement(
                        "drop table entry;"
                );
                tableItems.executeUpdate();
                //conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    public boolean add(int number, int count) {
        try {
            if (conn != null) {
                PreparedStatement tableItems = conn.prepareStatement(
                        "insert into entry(field) values(?);"
                );
                tableItems.setString(1, String.valueOf(number));
                tableItems.executeUpdate();
            }
            if (count == 100000) {
                conn.commit();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
        return true;
    }

    public void findAll() {
        try {
            if (conn != null) {
                PreparedStatement tableItems = conn.prepareStatement(
                        "select * from entry;"
                );
                ResultSet rs = tableItems.executeQuery();
                while (rs.next()) {
                    System.out.println(String.format("%s", rs.getInt("field")));
                }
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            LOGGER.error(e.getMessage(), e);
        }
    }

    public List<XmlUsage.Field> generate(int n) {
        List<XmlUsage.Field> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(new XmlUsage.Field(i));
        }
        return result;
    }
}