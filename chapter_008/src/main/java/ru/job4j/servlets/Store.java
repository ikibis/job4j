package ru.job4j.servlets;

import java.util.List;

public interface Store {
    boolean add(User user);

    boolean update(User user, String newName);

    boolean delete(User user);

    List<User> findAll();

    User findById(int id);

}
