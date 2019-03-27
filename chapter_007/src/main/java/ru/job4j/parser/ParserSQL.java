package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ParserSQL {
    private static final Logger LOGGER = LogManager.getLogger(ParserSQL.class.getName());
    private Connection connection;

    public boolean init() {
        try (InputStream in = ParserSQL.class.getClassLoader().getResourceAsStream("appParser.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    public void createNewDB() {
        try (PreparedStatement tableItems = connection.prepareStatement(
                "create table if not exists vacancy  ( "
                        + "id serial primary key, "
                        + "name varchar(2000), "
                        + "url varchar(2000), "
                        + "description varchar(2000), "
                        + "date varchar(2000));"
        )) {
            tableItems.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void deleteDB() {
        try (PreparedStatement tableItems = connection.prepareStatement(
                "drop table vacancy;"
        )) {
            tableItems.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public Vacancy add(Vacancy vacancy) {
        if (!this.duplicateCheck(vacancy)) {
            try (
                    PreparedStatement insertLine = connection.prepareStatement(
                            "insert into vacancy(name, url, description, date) values(?, ?, ?, ?);"
                    )
            ) {
                insertLine.setString(1, vacancy.getName());
                insertLine.setString(2, vacancy.getUrl());
                insertLine.setString(3, vacancy.getDescription());
                insertLine.setString(4, vacancy.getDate());
                insertLine.executeUpdate();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return vacancy;
    }

    public boolean duplicateCheck(Vacancy vacancy) {
        boolean writeFlag = false;

        try (PreparedStatement tableVacancy = connection.prepareStatement(
                "select name from vacancy where name = ?;"
        )) {
            tableVacancy.setString(1, vacancy.getName());
            ResultSet rs = tableVacancy.executeQuery();
            writeFlag = rs.next();
            rs.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return writeFlag;
    }
}