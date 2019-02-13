package ru.job4j.servlets;

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
        int count = 0;
        for (String name : validateService.findAll()) {
            sb.append("<tr><td>" + name + "</td>"
                    + "<td>"
                    + "<form action'" + req.getContextPath() + "/servlets/user_update_servlet method='post'>"
                    + "<input type='submit' value='Edit'>"
                    + "<input type=hidden name='action' value='edit' >"
                    + "<input type=hidden name='name' value='" + name + "' >"
                    + "<input type=hidden name='id' value='" + count + "' >"
                    + "</form>"
                    + "</td>"
                    + "<td>"
                    + "<form action'" + req.getContextPath() + "/servlets' method='post'>"
                    + "<input type='submit' value='Delete'>"
                    + "<input type=hidden name='action' value='delete' >"
                    + "<input type='hidden' name='id' value='" + count + "' >"
                    + "</form>"
                    + "</td>"
                    + "</tr>"
            );
            count++;
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
                + "<form action'" + req.getContextPath() + "/servlets" + "' method='post'>"
                + "<input type=hidden name='action' value='add' >"
                + "<input type='submit' value='Add User'>"
                + "</form>"
                + sb.toString()
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        switch (req.getParameter("action")) {
            case "add":
                resp.sendRedirect("servlets/user_create_servlet");
                break;
            case "edit":
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

/*
Добавим три сервлета
UsersServlet
- doGet URL  /list - открывает таблицу со всеми пользователями. В каждой строку должна быть колонка с кнопками (редактировать, удалить)
UserCreateServlet
- doGet URL /create - Открывает форму для создания нового пользователя.
- doPost - / - сохраняет пользователя.
UserUpdateServlet
- doGet URL /edit?id={userId} - открывает форму для редактирования с заполенными полями.
- doPost - / - сохраняет пользователя.
Интерфейс - это html.
1. Список пользователей - таблица.
В таблице должны быть две кнопки. она кнопка должны открывать форму редактирования.
Вторая должна выполнять запрос на сервер для удаления этой заявки.
При построении таблицу, каждую кнопку нужно обернуть в форму.
...
<td>
   <form action="/" method="post">
        <input type="hidden" name="id" value="<%=id%>"/>
....
2. Создание - форма ввода
3. Редактирование - заполненная форма ввода.
 */