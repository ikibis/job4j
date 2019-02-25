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

public class UserServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();
    private ActionFactory factory = ActionFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        final List<User> allUsers = validateService.findAll();
        req.setAttribute("users", allUsers);
        req.getRequestDispatcher("/WEB-INF/view/users.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        factory.action("delete", req);
        resp.setContentType("text/html");
        doGet(req, resp);
    }
}