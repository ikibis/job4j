package ru.job4j.storage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    List<User> list;
    public UserStorage() {
        list = new ArrayList<>();
    }

    public synchronized boolean add(User user) {
        boolean result = false;
        User u = findUser(user.getIdt());
        if (u == null) {
            list.add(user);
            result = true;
        }
        return result;
    }

    public synchronized boolean update(User user) {
        boolean result = false;
        User u = findUser(user.getIdt());
        if (u != null) {
            list.remove(u);
            list.add(user);
            result = true;
        }
        return result;
    }

    public synchronized boolean delete(User user) {
        boolean result = false;
        User u = findUser(user.getIdt());
        if (u != null) {
            list.remove(user);
            result = true;
        }
        return result;
    }

    public boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        User fromUser = findUser(fromId);
        User toUser = findUser(toId);
        if (fromUser != null && toUser != null) {
            fromUser.setAmount(fromUser.getAmount() - amount);
            toUser.setAmount(toUser.getAmount() + amount);
            result = true;
        }
        return result;
    }

    public synchronized User findUser(int id) {
        User result = null;
        for (User u : list) {
            if (id == u.getIdt()) {
                result = u;
                break;
            }
        }
        return result;
    }
}
