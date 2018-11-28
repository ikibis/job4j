package ru.job4j.array;

import java.sql.*;

/**
 * @author sqlitetutorial.net
 */
public class Main {

    /**
     * Connect to a sample database
     *
     * @param fileName the database file name
     */
    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:/home/ilya/job4j/chapter_007/src/main/java/ru/job4j/array/" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                PreparedStatement tableItems = conn.prepareStatement(
                        "create table entry (id serial primary key, field integer );"
                );
                tableItems.executeUpdate();
                for(int i = 0; i < 10; i++) {
                    PreparedStatement insertLine = conn.prepareStatement(
                            "insert into entry(field) values(i);"
                    );
                    insertLine.executeUpdate();
                }
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createNewDatabase("test.db");
    }
}
