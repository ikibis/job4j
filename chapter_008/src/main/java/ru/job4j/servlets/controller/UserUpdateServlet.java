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
    private String id;
    private String name;
    private String login;
    private String password;
    private String email;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher(String.format("%s/update.jsp", req.getContextPath())).forward(req, resp);
   /*     resp.setContentType("text/html");
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
                + "<input required type='text' name='login' value='" + password + "'>"
                + "<input required type='text' name='email' value='" + email + "'>"
                + "<button type = 'submit'> Save Changes</button>"
                + "</form>"
                + "<br/>"
                + "</body>"
                + "</html>");
        writer.flush();
        */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        id = req.getParameter("id");
        name = req.getParameter("name");
        login = req.getParameter("login");
        password = req.getParameter("password");
        email = req.getParameter("email");
        User user = (User) req.getAttribute("user");
        User udatedUser = new User(name, login, password, email);
        if (validateService.update(user, udatedUser)) {
            resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
        } else {
            doGet(req, resp);
        }
    }
}
