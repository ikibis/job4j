package ru.job4j.servlets.controller;

import ru.job4j.servlets.action.Action;
import ru.job4j.servlets.action.ActionFactory;
import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class UserServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();
    private ActionClass action = new ActionClass();
    //private ActionFactory actionFactory = new ActionFactory();
    ConcurrentHashMap<String, String[]> map = new ConcurrentHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        //Action action = actionFactory.createAction(req.getParameterMap());
        //final List<User> allUsers = action.findAll(validateService);
        //map.clear();
        final List<User> allUsers = validateService.findAll();
        req.setAttribute("users", allUsers);
        req.getRequestDispatcher("/WEB-INF/view/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        //Action action = actionFactory.createAction(req.getParameterMap());
        //action.doAction(validateService, req.getParameterMap());
        //map.clear();
        map.putAll(req.getParameterMap());
        action.doAction(map);
        map.clear();
          doGet(req, resp);
    }
}