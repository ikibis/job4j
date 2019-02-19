package ru.job4j.servlets.storage;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.servlets.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DbStore implements Store {

    private static final Logger LOGGER = LogManager.getLogger(DbStore.class.getName());
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static DbStore store;

    public DbStore() {
        Config conf = new Config();
        SOURCE.setUrl(conf.get("url"));
        SOURCE.setUsername(conf.get("username"));
        SOURCE.setPassword(conf.get("password"));
        SOURCE.setDriverClassName(conf.get("driver-class-name"));
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        this.createNewDB();
    }

    public static DbStore getInstance() {
        if (store == null) {
            store = new DbStore();
        }
        return store;
    }

    public void createNewDB() {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(
                     "create table users ( "
                             + "id serial primary key, "
                             + "name varchar(2000), "
                             + "login varchar(2000), "
                             + "password varchar(2000), "
                             + "email varchar(2000), "
                             + "date varchar(2000));"
             )) {
            st.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public boolean add(User user) {
        boolean result = false;
        if (!this.duplicateCheck(user)) {
            try (Connection connection = SOURCE.getConnection();
                 PreparedStatement st = connection.prepareStatement(
                         "insert into users(name, login, password, email, date) values(?, ?, ?, ?, ?);"
                 )) {
                st.setString(1, user.getName());
                st.setString(2, user.getLogin());
                st.setString(3, user.getPassword());
                st.setString(4, user.getEmail());
                st.setString(5, user.getCreateDate());
                st.executeUpdate();
                result = true;
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return result;
    }

    @Override
    public boolean update(User user, User updatedUser) {
        boolean result = false;
        if (!this.duplicateCheck(updatedUser)) {
            try (Connection connection = SOURCE.getConnection();
                 PreparedStatement st = connection.prepareStatement(
                         "update users set users.name = ?, users.login = ?, users.password = ?, users.email = ? WHERE users.id = ?;"
                 )) {
                st.setString(1, updatedUser.getName());
                st.setString(2, updatedUser.getLogin());
                st.setString(3, updatedUser.getPassword());
                st.setString(4, updatedUser.getEmail());
                st.setString(5, String.valueOf(user.getId()));
                st.executeUpdate();
                result = true;
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        return result;
    }

    @Override
    public boolean delete(User user) {
        boolean result = true;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(
                     "delete from users where users.id = ?;"
             )) {
            st.setInt(1, user.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            result = false;
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<User> findAll() {
        List<User> result = new CopyOnWriteArrayList<>();
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(
                     "select * from users;"
             )) {
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                result.add(new User(
                        Integer.valueOf(rs.getString("id")),
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("date")
                ));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public User findById(int id) {
        User result = null;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(
                     "select from items where items.id = ?;"
             )) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            result = new User(
                    Integer.valueOf(rs.getString("id")),
                    rs.getString("name"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("date")
            );
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return result;
    }

    public boolean duplicateCheck(User user) {
        boolean writeFlag = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement users = connection.prepareStatement(
                     "select name from users where users.login = ? OR users.email = ?;"
             )) {
            users.setString(1, user.getLogin());
            users.setString(2, user.getEmail());
            ResultSet rs = users.executeQuery();
            writeFlag = rs.next();
            rs.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return writeFlag;
    }
}