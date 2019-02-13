package ru.job4j.servlets;

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
                + "<form action'" + req.getContextPath() + "/servlets/" + "user_create_servlet" + "' method='post'>"
                + "<input required type='text' name='name'>"
                + "<input type = 'submit' value = 'Save'>"
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
        validateService.add(name);
        doGet(req, resp);
    }
}

/*
@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        switch (req.getParameter("action")) {
            case "add":
                String name = req.getParameter("name");
                validateService.add(name);
                break;
            case "update":
                String id = req.getParameter("id");
                String newName = req.getParameter("new_name");
                validateService.update(id, newName);
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
 */