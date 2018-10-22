package ru.job4j.store;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public List<User> previous = new ArrayList<>();
    public List<User> current = new ArrayList<>();

    public void removeUser(int id) {
        User user = this.findById(id);
        previous.add(user);
        current.remove(user);
    }

    public void addUser(int id, String name) {
        current.add(new User(id, name));
    }

    public void setUser(int id, String name) {
        User user = this.findById(id);
        previous.add(user);
        User settedUser = new User(user.getId(), name);
        current.set(current.indexOf(user), settedUser);
    }

    private User findById(int id) {
        User result = null;
        for (User users : current) {
            if (users.getId() == id) {
                result = users;
                break;
            }
        }
        return result;
    }
}
