package ru.job4j.servlets.action;

import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Update implements Action {
    @Override
    public boolean doAction(ValidateService validateService, Map<String, String[]> map) {
        boolean result = false;
        User user = null;
        int idToUpdate = Integer.valueOf(Objects.requireNonNull(map.get("id")[0]));
        if (validateService.findById(idToUpdate)) {
            user = validateService.getUserById(idToUpdate);
        }
        User udatedUser = new User(map.get("name")[0],
                map.get("login")[0],
                map.get("password")[0],
                map.get("email")[0]);
        if (validateService.update(user, udatedUser)) {
            result = true;
        }
        return result;
    }

    @Override
    public List<User> findAll(ValidateService validateService) {
        return null;
    }
}
