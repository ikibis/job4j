package ru.job4j.tracker;

import org.apache.log4j.Logger;
import ru.job4j.sql.SQLStorage;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TrackerSQL implements ITracker, Cloneable {
    private static final Logger LOGGER = Logger.getLogger(SQLStorage.class);
    private Connection connection;

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
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
                        "create table items ( id serial primary key, name varchar(200), description varchar(2000));"
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
    }

    public void deleteDB() {
        if (this.init()) {
            try {
                PreparedStatement tableItems = connection.prepareStatement(
                        "drop table items;"
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
    }

    @Override
    public Item add(Item item) {
        if (this.init()) {
            try {
                PreparedStatement insertLine = connection.prepareStatement(
                        "insert into items(name, description) values(?, ?);"
                );
                insertLine.setString(1, item.getName());
                insertLine.setString(2, item.getDescription());
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
        }
        return item;
    }

    @Override
    public void replace(String id, Item item) {
        if (this.init()) {
            try {
                PreparedStatement replacedLine = connection.prepareStatement(
                        "update items set name = ?, description = ? where items.id = ?;"
                );
                replacedLine.setString(1, item.getName());
                replacedLine.setString(2, item.getDescription());
                replacedLine.setInt(3, Integer.valueOf(id));
                replacedLine.executeUpdate();
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

    @Override
    public boolean delete(String id) {
        boolean result = true;
        if (this.init()) {
            try {
                PreparedStatement deletedLine = connection.prepareStatement(
                        "delete from items where items.id = ?;"
                );
                deletedLine.setInt(1, Integer.valueOf(id));
                deletedLine.executeUpdate();
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
                result = false;
            } finally {
                if (this.connection != null) {
                    try {
                        this.connection.close();
                    } catch (SQLException e) {
                        result = false;
                        LOGGER.error(e.getMessage(), e);
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        if (this.init()) {
            try {
                PreparedStatement selectedLine = connection.prepareStatement(
                        "select * from items;"
                );
                ResultSet rs = selectedLine.executeQuery();
                result = new Tracker().findAll();
                while (rs.next()) {
                    System.out.println(String.format("%s %s", rs.getString("name"), rs.getString("description")));
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
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        if (this.init()) {
            try {
                PreparedStatement selectedLine = connection.prepareStatement(
                        "select * from items where items.name = ?;"
                );
                selectedLine.setString(1, key);
                ResultSet rs = selectedLine.executeQuery();
                result = new Tracker().findByName(key);
                while (rs.next()) {
                    System.out.println(String.format("%s %s", rs.getString("name"), rs.getString("description")));
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
        return result;
    }

    @Override
    public Item findById(String id) {
        Item result = null;
        if (this.init()) {
            try {
                PreparedStatement selectedLine = connection.prepareStatement(
                        "select from items where items.id = ?;"
                );
                selectedLine.setInt(1, Integer.valueOf(id));
                ResultSet rs = selectedLine.executeQuery();
                result = new Tracker().findById(id);
                System.out.println(String.format("%s %s", rs.getString("name"), rs.getString("description")));
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
        return result;
    }
}