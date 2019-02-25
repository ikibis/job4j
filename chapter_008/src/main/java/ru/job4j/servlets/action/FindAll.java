package ru.job4j.servlets.action;

import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FindAll implements Action {

    @Override
    public boolean doAction(ValidateService validateService, HttpServletRequest req) {
        return false;
    }

    @Override
    public List<User> doAction(ValidateService validateService) {
        return validateService.findAll();
    }
}
