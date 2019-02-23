package ru.job4j.servlets.controller;

import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdateServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.valueOf(req.getParameter("id"));
        if (validateService.findById(id)) {
            User user = validateService.getUserById(id);
            req.setAttribute("user", user);
        }
        req.getRequestDispatcher("/WEB-INF/view/update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
    }
}

