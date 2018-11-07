package ru.job4j.email;

import java.util.LinkedList;
import java.util.Queue;

public class UserStorage {
    public Queue<User> users;

    public UserStorage() {
        this.users = new LinkedList<>();
    }

    public void add(User user) {
        this.users.add(user);
    }

    public User poll() {
        return this.users.poll();
    }
}
