package ru.job4j.servlets;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MemoryStore implements Store {
    private static Store store;
    private List<User> users = new CopyOnWriteArrayList<>();

    public static Store getInstance() {
        if (store == null) {
            store = new MemoryStore();
        }
        return store;
    }

    @Override
    public boolean add(User user) {
        boolean result = true;
        for (User userSearched : users) {
            String userSearchedName = userSearched.getName();
            if (userSearchedName.equals(user.getName())) {
                result = false;
            }
        }
        if (result) {
            users.add(user);
        }
        return result;
    }

    @Override
    public boolean update(User user, String newName) {
        boolean result = false;
        for (User userSearched : users) {
            String userSearchedName = userSearched.getName();
            if (userSearchedName.equals(user.getName())) {
                user.setName(newName);
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean delete(User user) {
        return users.remove(user);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        User result = null;
        for (User userSearched : users) {
            int userSearchedId = userSearched.getId();
            if (userSearchedId == id) {
                result = userSearched;
                break;
            }
        }
        return result;
    }
}
