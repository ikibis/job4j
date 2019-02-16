package ru.job4j.servlets.storage;

import ru.job4j.servlets.model.User;

import java.util.List;

public interface Store {
    boolean add(String name, String login, String email);

    boolean update(User user, String newName, String newLogin, String newEmail);

    boolean delete(User user);

    List<User> findAll();

    User findById(int id);

    User findByLogin(String login);

    User findByEmail(String email);

}
