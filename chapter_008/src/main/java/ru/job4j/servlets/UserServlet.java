package ru.job4j.servlets;

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
        writer.append("Users List : ").append(validateService.findAll());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        switch (req.getParameter("action")) {
            case "add":
                String name = req.getParameter("name");
                validateService.add(name);
            case "update":
                String id = req.getParameter("id");
                String newName = req.getParameter("new_name");
                validateService.update(id, newName);
            case "delete":
                String idToDelete = req.getParameter("id");
                validateService.delete(idToDelete);
            default:
        }
        doGet(req, resp);
    }
}