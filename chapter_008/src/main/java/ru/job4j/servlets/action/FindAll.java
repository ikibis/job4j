package ru.job4j.servlets.action;

import ru.job4j.servlets.storage.ValidateService;

import javax.servlet.http.HttpServletRequest;

public class FindAll implements Action {

    @Override
    public boolean doAction(ValidateService validateService, HttpServletRequest req) {
        return false;
    }
}
