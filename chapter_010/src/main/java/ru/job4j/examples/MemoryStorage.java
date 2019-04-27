package ru.job4j.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class MemoryStorage implements Storage {
    private final List<User> users;

    @Autowired
    public MemoryStorage() {
        users = new CopyOnWriteArrayList<>();
    }

    @Override
    public User add(User user) {
        if (user != null) {
            users.add(user);
        }
        return user;
    }
    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findAny()
                .orElse(null);
    }
}
