package ru.job4j.servlets.controller;

import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class UserCreateServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //req.getRequestDispatcher("/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String date = sdf.format(new Date());
        User user = new User(name, login, password, email, date);
        if (validateService.add(user)) {
            resp.sendRedirect(String.format("%s/servlets", req.getContextPath()));
        } else {
            doGet(req, resp);
        }
    }
}