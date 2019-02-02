package ru.job4j.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ParserSQL implements Closeable {
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
        if (this.init()) {
            try {
                PreparedStatement tableItems = connection.prepareStatement(
                        "create table vacancy ( "
                                + "id serial primary key, "
                                + "name varchar(200), "
                                + "url varchar(2000), "
                                + "description varchar(2000));"
                );
                tableItems.executeUpdate();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            } finally {
                if (this.connection != null) {
                    try {
                        this.close();
                    } catch (IOException e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                }
            }
        }
    }

    public void deleteDB() {
        if (this.init()) {
            try {
                PreparedStatement tableItems = connection.prepareStatement(
                        "drop table vacancy;"
                );
                tableItems.executeUpdate();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            } finally {
                if (this.connection != null) {
                    try {
                        this.close();
                    } catch (IOException e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                }
            }
        }
    }

    public Vacancy add(Vacancy vacancy) {
        if (this.init()) {
            try {
                if (!this.duplicateCheck(vacancy)) {
                    PreparedStatement insertLine = connection.prepareStatement(
                            "insert into vacancy(name, url, description) values(?, ?, ?);"
                    );
                    insertLine.setString(1, vacancy.getName());
                    insertLine.setString(2, vacancy.getUrl());
                    insertLine.setString(3, vacancy.getDescription());
                    insertLine.executeUpdate();
                }
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            } finally {
                if (this.connection != null) {
                    try {
                        this.close();
                    } catch (IOException e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                }
            }
        }
        return vacancy;
    }

    public boolean duplicateCheck(Vacancy vacancy) {
        boolean writeFlag = false;
        if (this.init()) {
            try {
                PreparedStatement tableVacancy = connection.prepareStatement(
                        "select name from vacancy where name = ?;"
                );
                tableVacancy.setString(1, vacancy.getName());
                ResultSet rs = tableVacancy.executeQuery();
                writeFlag = rs.next();
                rs.close();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return writeFlag;
    }

    @Override
    public void close() throws IOException {
        try {
            this.connection.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}

