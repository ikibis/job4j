package ru.job4j.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbStorage implements Storage {
    private final Storage storage;
    private static final StorageWrapper WRAPPER = StorageWrapper.getINSTANCE();

    @Autowired
    public DbStorage(Storage storage) {
        this.storage = storage;
    }

    public User add(User user) {
        return WRAPPER.tx(session -> {
            session.saveOrUpdate(user);
            return user;
        });
    }

    public List<User> findAll() {
        return WRAPPER.tx(
                session -> session.createQuery("from User").list()
        );
    }

    public User findById(int id) {
        return WRAPPER.tx(
                session -> session.get(User.class, id)
        );
    }

}
