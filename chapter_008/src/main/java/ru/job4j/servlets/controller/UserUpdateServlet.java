package ru.job4j.servlets.controller;

import ru.job4j.servlets.storage.ValidateService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUpdateServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();
    private String id;
    private String name;
    private String login;
    private String email;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("doGet");
        resp.setContentType("text/html");
        id = req.getParameter("id");
        name = req.getParameter("name");
        login = req.getParameter("login");
        email = req.getParameter("email");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF - 8\">"
                + "<title>Create User</title>"
                + "</head>"
                + "<body>"
                + "<form action='" + req.getContextPath() + "/servlets/user_update_servlet' " + "method='post'>"
                + "<input required type='text' name='name' value='" + name + "'>"
                + "<input required type='text' name='login' value='" + login + "'>"
                + "<input required type='text' name='email' value='" + email + "'>"
                + "<button type = 'submit'> Save Changes</button>"
                + "</form>"
                + "<br/>"
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        name = req.getParameter("name");
        login = req.getParameter("login");
        email = req.getParameter("email");
        if (validateService.update(id, name, login, email)) {
            resp.sendRedirect(String.format("%s/servlets", req.getContextPath()));
        } else {
            doGet(req, resp);
        }
    }
}
