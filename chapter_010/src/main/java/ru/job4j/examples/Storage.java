package ru.job4j.examples;

import java.util.List;

public interface Storage {
    User add(User user);

    List<User> findAll();

    User findById(int id);
}
