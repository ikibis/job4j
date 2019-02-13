package ru.job4j.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserUpdateServlet extends HttpServlet {
    private final ValidateService validateService = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("id");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "<meta charset=\"UTF - 8\">"
                + "<title>Create User</title>"
                + "</head>"
                + "<body>"
                + "<form action'" + req.getContextPath() + "/servlets/" + "user_update_servlet" + "' method='post'>"
                + "<input required type='text' value='" + id + "'>"
                + "<input required type='text' value='new_name'>"
                + "<input type = 'submit' value = 'Save Changes'>"
                + "</form>"
                + "<br/>"
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        String id = req.getParameter("id");
        System.out.println(id);
        String newName = req.getParameter("new_name");
        validateService.update(id, newName);
        doGet(req, resp);
    }
}
