package ru.job4j.servlets.controller;

import ru.job4j.servlets.model.User;
import ru.job4j.servlets.storage.ValidateService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        StringBuilder sb = new StringBuilder("<table>");
        for (User user : validateService.findAll()) {
            sb.append("<tr>"
                    + "<td>" + user.getName() + "</td>"
                    + "<td>" + user.getLogin() + "</td>"
                    + "<td>" + user.getEmail() + "</td>"
                    + "<td>"
                    + "<form action='" + req.getContextPath() + "/servlets/user_update_servlet' method='get'>"
                    + "<input type=hidden name='id' value='" + user.getId() + "' >"
                    + "<input type=hidden name='name' value='" + user.getName() + "' >"
                    + "<input type=hidden name='login' value='" + user.getLogin() + "' >"
                    + "<input type=hidden name='email' value='" + user.getEmail() + "' >"
                    + "<button type = 'submit'> Edit</button>"
                    + "</form>"
                    + "</td>"
                    + "<td>"
                    + "<form action='" + req.getContextPath() + "/servlets' method='post'>"
                    + "<input type=hidden name='action' value='delete' >"
                    + "<input type='hidden' name='id' value='" + user.getId() + "' >"
                    + "<button type = 'submit'> Delete</button>"
                    + "</form>"
                    + "</td>"
                    + "</tr>"
            );
        }
        sb.append("</table>");

        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF - 8\">"
                + "<title>Users Store</title>"
                + "</head>"
                + "<body>"
                + "<br/>"
                + "<h2><a href='" + req.getContextPath() + "/servlets/user_create_servlet'> Add User</a></h2>"
                + sb.toString()
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        switch (req.getParameter("action")) {
            case "edit":
                System.out.println("here");
                req.getRequestDispatcher("servlets/user_update_servlet").forward(req, resp);
                break;
            case "delete":
                String idToDelete = req.getParameter("id");
                validateService.delete(idToDelete);
                break;
            default:
                break;
        }
        doGet(req, resp);
    }
}
