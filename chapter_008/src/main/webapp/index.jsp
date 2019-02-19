<%@ page import="ru.job4j.servlets.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users Store</title>
</head>
<body>
<h2>
    <a href="<%=request.getContextPath()%>/create.jsp"> Add User</a>
</h2>
<br/>
<br/>
<table style="border: 1px solid black" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <th>name</th>
        <th>login</th>
        <th>password</th>
        <th>email</th>
        <th>Button 1</th>
        <th>Button 2</th>
    </tr>
    <% List<User> users = (List<User>) request.getAttribute("users");%>
    <% for (User user : users) { %>
    <tr>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getLogin()%>
        </td>
        <td><%=user.getPassword()%>
        </td>
        <td><%=user.getEmail()%>
        </td>
        <td>
            <form action="<%=request.getContextPath()%>/update.jsp" method="get">
                <% request.getSession().setAttribute("user", user);%>
                <button type="submit"> Edit</button>
            </form>
        </td>
        <td>
            <form action="<%=request.getContextPath()%>/servlets" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%=user.getId()%>">
                <button type="submit"> Delete</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>
