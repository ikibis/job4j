package ru.job4j.servlets.action;

import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Delete implements Action {
    @Override
    public boolean doAction(ValidateService validateService, Map<String, String[]> map) {
        boolean result = false;
        int idToDelete = Integer.valueOf(Objects.requireNonNull(map.get("id")[0]));
        if (validateService.findById(idToDelete)) {
            validateService.delete(idToDelete);
            result = true;
        }
        return result;
    }

    @Override
    public List<User> findAll(ValidateService validateService) {
        return null;
    }
}
