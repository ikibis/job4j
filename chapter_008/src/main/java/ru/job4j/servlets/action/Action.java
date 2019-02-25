package ru.job4j.servlets.action;

import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface Action {
    boolean doAction(ValidateService validateService, HttpServletRequest req);
    List<User> doAction(ValidateService validateService);
}
