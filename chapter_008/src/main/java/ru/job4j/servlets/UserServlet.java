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
        StringBuilder sb = new StringBuilder("<table>");
        for (String name : validateService.findAll()) {
            sb.append("<tr><td>" + name + "</td>"
                    + "<td>"
                    + "<form action'" + req.getContextPath() + "/servlets' method='post'>"
                    + "<input type='submit'>"
                    + "</form>"
                    + "</td>"
                    + "<td>"
                    + "<form action'" + req.getContextPath() + "/servlets' method='post'>"
                    + "<input type='submit'>"
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
                + sb.toString()
                + "</body>"
                + "</html>");
        writer.flush();
    }

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