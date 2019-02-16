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
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
    private int id = 1;

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
                             + "email varchar(2000), "
                             + "date varchar(2000));"
             )) {
            st.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public boolean add(String name, String login, String email) {
        boolean result = false;
        String date = sdf.format(new Date());
        User user = new User(this.id, name, login, email, date);
        if (!this.duplicateCheck(user)) {
            try (Connection connection = SOURCE.getConnection();
                 PreparedStatement st = connection.prepareStatement(
                         "insert into users(name, login, email, date) values(?, ?, ?, ?);"
                 )) {
                st.setString(1, user.getName());
                st.setString(2, user.getLogin());
                st.setString(3, user.getEmail());
                st.setString(4, user.getCreateDate());
                st.executeUpdate();
                result = true;
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        this.id++;
        return result;
    }

    @Override
    public boolean update(User user, String newName, String newLogin, String newEmail) {
        boolean result = false;
        if (!this.duplicateCheck(newLogin, newEmail)) {
            try (Connection connection = SOURCE.getConnection();
                 PreparedStatement st = connection.prepareStatement(
                         "update users set users.name = ?, users.login = ?, users.email = ? WHERE users.id = ?;"
                 )) {
                st.setString(1, newName);
                st.setString(2, newLogin);
                st.setString(3, newEmail);
                st.setString(4, String.valueOf(user.getId()));
                st.executeUpdate();
                result = true;
            } catch (SQLException e) {
                LOGGER.error(e.getMessage(), e);
            }
        }
        this.id++;
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = true;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement st = connection.prepareStatement(
                     "delete from users where users.id = ?;"
             )) {
            st.setInt(1, Integer.valueOf(id));
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

    public boolean duplicateCheck(String login, String email) {
        boolean writeFlag = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement users = connection.prepareStatement(
                     "select name from users where users.name = ? OR users.login = ?;"
             )) {
            users.setString(1, login);
            users.setString(2, email);
            ResultSet rs = users.executeQuery();
            writeFlag = rs.next();
            rs.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return writeFlag;
    }
}