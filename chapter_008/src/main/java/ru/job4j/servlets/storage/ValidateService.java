package ru.job4j.servlets.storage;

import ru.job4j.servlets.model.User;
import java.util.List;

public class ValidateService {
    private static ValidateService service;
    private final Store memory = DbStore.getInstance();


    public static ValidateService getInstance() {
        if (service == null) {
            service = new ValidateService();
        }
        return service;
    }

    public boolean add(User user) {
        boolean result = false;
        if (user.getName() != null && user.getLogin() != null
                && user.getPassword() != null && user.getEmail() != null) {
            result = memory.add(user);
        }
        return result;
    }

    public boolean update(User user, User udatedUser) {
        boolean result = false;
        if (udatedUser.getName() != null && udatedUser.getLogin() != null
                && udatedUser.getPassword() != null && udatedUser.getEmail() != null) {
            result = memory.update(user, udatedUser);
        }
        return result;
    }

    public boolean delete(User user) {
        return memory.delete(user);
    }

    public List<User> findAll() {
        return memory.findAll();
    }

    public User findById(int id) {
        return memory.findById(id);
    }
}
