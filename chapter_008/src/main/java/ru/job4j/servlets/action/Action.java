package ru.job4j.servlets.action;

import ru.job4j.servlets.storage.ValidateService;

import javax.servlet.http.HttpServletRequest;

public interface Action {
    boolean doAction(ValidateService validateService, HttpServletRequest req);
}
