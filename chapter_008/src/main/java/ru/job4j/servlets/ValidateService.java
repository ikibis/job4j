package ru.job4j.servlets;

public class ValidateService {
    private static ValidateService service;
    private final Store memory = MemoryStore.getInstance();

    public static ValidateService getInstance() {
        if (service == null) {
            service = new ValidateService();
        }
        return service;
    }

    public boolean add(String name) {
        return memory.add(name);
    }

    public boolean update(String id, String newName) {
        int idToStore = Integer.parseInt(id);
        User user = memory.findById(idToStore);
        return memory.update(user, newName);
    }

    public boolean delete(String id) {
        int idToStore = Integer.parseInt(id);
        User user = memory.findById(idToStore);
        return memory.delete(user);
    }

    public String findAll() {
        StringBuilder usersToServlet = new StringBuilder();
        for (User user : memory.findAll()) {
            usersToServlet.append(user.getName()).append(" ");
        }
        return usersToServlet.toString();
    }
}
