package ru.job4j.servlets.controller;

import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ActionClass {
    private final ValidateService validateService = ValidateService.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
    private AtomicInteger identifier = new AtomicInteger(0);

    public boolean doAction(Map<String, String[]> map) {
        boolean result = false;
        String action = map.get("action") != null ? map.get("action")[0] : null;
        String id = map.get("id") != null ? map.get("id")[0] : null;
        String name = map.get("name") != null ? map.get("name")[0] : null;
        String login = map.get("login") != null ? map.get("login")[0] : null;
        String password = map.get("password") != null ? map.get("password")[0] : null;
        String email = map.get("email") != null ? map.get("email")[0] : null;
        User user = null;
        switch (Objects.requireNonNull(action)) {
            case "create":
                String date = sdf.format(new Date());
                user = new User(identifier.getAndIncrement(), name, login, password, email, date);
                if (validateService.add(user)) {
                    result = true;
                }
                break;
            case "update":
                int idToUpdate = Integer.valueOf(Objects.requireNonNull(id));
                if (validateService.findById(idToUpdate)) {
                    user = validateService.getUserById(idToUpdate);
                }
                User udatedUser = new User(name, login, password, email);
                if (validateService.update(user, udatedUser)) {
                    result = true;
                }
                break;
            case "delete":
                int idToDelete = Integer.valueOf(Objects.requireNonNull(id));
                if (validateService.findById(idToDelete)) {
                    validateService.delete(idToDelete);
                    result = true;
                }
                break;
            default:
                break;
        }
        return result;
    }
}

