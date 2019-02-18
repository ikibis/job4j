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
        <form action="<%=request.getContextPath()%>/servlets/user_update_servlet" method="post">
            <td>
                <input type=hidden name="id" value="<%=request.getParameter("id")%>">
                <%=request.getParameter("id")%>
                <%User user = (User) request.getAttribute("user");%>
                <%request.setAttribute("user", user);%>
            </td>
            <td><input required type=text name="name" value="<%=request.getParameter("name")%>"></td>
            <td><input required type=text name="login" value="<%=request.getParameter("login")%>"></td>
            <td><input required type=text name="password" value="<%=request.getParameter("password")%>"></td>
            <td><input required type=text name="email" value="<%=request.getParameter("email")%>"></td>
            <td>
                <button type="submit"> Save Changes</button>
            </td>
        </form>
        </td>
    </tr>
</table>
</body>
</html>
