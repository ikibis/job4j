package ru.job4j.store;

import java.util.HashMap;

public class Store {
    public HashMap<Integer, User> previous = new HashMap<>();
    public HashMap<Integer, User> current = new HashMap<>();
    public int setted;

    public void removeUser(int id) {
        User user = this.findById(id);
        previous.put(user.getId(), user);
        current.remove(user);
    }

    public void addUser(int id, String name) {
        User user = new User(id, name);
        current.put(user.getId(), user);
    }

    public void setUser(int id, String name) {
        User user = this.findById(id);
        previous.put(user.getId(), user);
        User settedUser = new User(user.getId(), name);
        current.put(user.getId(), settedUser);
        setted++;
    }

    private User findById(int id) {
        User result = null;
        for (Integer userId : current.keySet()) {
            if (userId == id) {
                result = current.get(userId);
                break;
            }
        }
        return result;
    }
}
