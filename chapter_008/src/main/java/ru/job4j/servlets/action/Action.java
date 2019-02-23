package ru.job4j.servlets.action;

import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

import java.util.List;
import java.util.Map;

public interface Action {
    boolean doAction(ValidateService validateService, Map<String, String[]> map);
    List<User> findAll(ValidateService validateService);
}
