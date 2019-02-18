package ru.job4j.servlets.controller;

import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

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
    private AtomicInteger id = new AtomicInteger(0);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
  /*      resp.setContentType("text/html");
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
                + "<input required type='text' name='password'>"
                + "<input required type='text' name='email'>"
                + "<button type = 'submit'> Save</button>"
                + "</form>"
                + "<br/>"
                + "</body>"
                + "</html>");
        writer.flush();
        */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String date = sdf.format(new Date());
        User user = new User(id.incrementAndGet(), name, login, password, email, date);
        if (validateService.add(user)) {
            resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
        } else {
            doGet(req, resp);
        }
    }
}