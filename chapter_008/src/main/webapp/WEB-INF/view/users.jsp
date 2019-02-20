<%@ page import="ru.job4j.servlets.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users Store</title>
</head>
<body>
<h2>
    <a href="${pageContext.servletContext.contextPath}/WEB-INF/view/create.jsp"> Add User</a>
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
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.name}"></c:out>
            </td>
            <td><c:out value="${user.login}"></c:out>
            </td>
            <td><c:out value="${user.password}"></c:out>
            </td>
            <td><c:out value="${user.email}"></c:out>
            </td>
            <td>
                <form action="${pageContext.servletContext.contextPath}/WEB-INF/view/update.jsp" method="get">
                    <% request.getSession().setAttribute("user", request);%>
                    <button type="submit"> Edit</button>
                </form>
            </td>
            <td>
                <form action="${pageContext.servletContext.contextPath}/servlets" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<c:out value="${user.id}"></c:out>">
                    <button type="submit"> Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
