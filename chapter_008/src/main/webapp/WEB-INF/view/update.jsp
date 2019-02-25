<%@ page import="ru.job4j.servlets.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update User</title>
</head>
<body>
<br/>
<table style="border: 1px solid black" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>login</th>
        <th>password</th>
        <th>email</th>
        <th>Button 1</th>
    </tr>
    <tr>
        <form action="<%=request.getContextPath()%>/user_update_servlet" method="post">
            <td>
                <%User user = (User)request.getAttribute("user");%>
                <%=user.getId()%>
            </td>
            <input type="hidden" name="id" value="<%=user.getId()%>">
            <input type="hidden" name="action" value="update">
            <td><input required type=text name="name" value="<%=user.getName()%>"></td>
            <td><input required type=text name="login" value="<%=user.getLogin()%>"></td>
            <td><input required type=text name="password" value="<%=user.getPassword()%>"></td>
            <td><input required type=text name="email" value="<%=user.getEmail()%>"></td>
            <td>
                <button type="submit"> Save Changes</button>
            </td>
        </form>
    </tr>
</table>
</body>
</html>
