package ru.job4j.servlets.action;

import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

import java.util.List;
import java.util.Map;

public class FindAll implements Action {
    @Override
    public boolean doAction(ValidateService validateService, Map<String, String[]> map) {
        return false;
    }

    @Override
    public List<User> findAll(ValidateService validateService) {
        return validateService.findAll();
    }
}
