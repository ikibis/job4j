package ru.job4j.ajax;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder(String.valueOf(reader));
        System.out.println(sb);

        /*PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("[{'login':'test2', 'email':'email2'}, {'login':'test2', 'email':'email2'}]");
        writer.flush();*/
    }
}
