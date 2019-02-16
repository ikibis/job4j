package ru.job4j.servlets.controller;

import ru.job4j.servlets.storage.ValidateService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserCreateServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF - 8\">"
                + "<title>Create User</title>"
                + "</head>"
                + "<body>"
                + "<form action='" + req.getContextPath() + "/servlets/user_create_servlet' " + "method='post'>"
                + "<input required type='text' name='name'>"
                + "<input required type='text' name='login'>"
                + "<input required type='text' name='email'>"
                + "<button type = 'submit'> Save</button>"
                + "</form>"
                + "<br/>"
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        System.out.println(name);
        String login = req.getParameter("login");
        System.out.println(login);
        String email = req.getParameter("email");
        System.out.println(email);
        if (validateService.add(name, login, email)) {
            System.out.println("validateService.add(name) ValidateService");
            resp.sendRedirect(String.format("%s/servlets", req.getContextPath()));
        } else {
            doGet(req, resp);
        }
    }
}