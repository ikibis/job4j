package ru.job4j.servlets.storage;

import ru.job4j.servlets.model.User;

import java.util.List;

public interface Store {
    boolean add(User user);

    boolean update(User user, User updatedUser);

    boolean delete(String id);

    List<User> findAll();

    User findById(int id);

}
