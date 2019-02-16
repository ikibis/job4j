package ru.job4j.servlets.storage;

import ru.job4j.servlets.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ValidateService {
    private static ValidateService service;
    private final Store memory = MemoryStore.getInstance();

    public static ValidateService getInstance() {
        if (service == null) {
            service = new ValidateService();
        }
        return service;
    }

    public boolean add(String name, String login, String email) {
        System.out.println("public boolean add(String name)) ValidateService");
        return memory.add(name, login, email);
    }

    public boolean update(String id, String newName, String newLogin, String newEmail) {
        int idToStore = Integer.parseInt(id);
        User user = memory.findById(idToStore);
        return memory.update(user, newName, newLogin, newEmail);
    }

    public boolean delete(String id) {
        int idToStore = Integer.parseInt(id);
        User user = memory.findById(idToStore);
        return memory.delete(user);
    }

    public List<User> findAll() {
        return memory.findAll();
    }
}
