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
        int count = 0;
        for (String name : validateService.findAll()) {
            sb.append("<tr><td>" + name + "</td>"
                    + "<td>"
                    + "<form action'" + req.getContextPath() + "/servlets/user_update_servlet?id={12}" + "'" + "method='get'>"
                    + "<input type='submit' value='Edit'>"
                    + "</form>"
                    + "</td>"
                    + "<td>"
                    + "<form action'" + req.getContextPath() + "/servlets' method='delete'>"
                    + "<input type='submit' value='Delete'>"
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
                + "<form action'" + req.getContextPath() + "/servlets/user_create_servlet" + "' method='get'>"
                + "<input type='submit' value='Add User'>"
                + "</form>"
                + sb.toString()
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.sendRedirect(req.getContextPath() + "/user_create_servlet");
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