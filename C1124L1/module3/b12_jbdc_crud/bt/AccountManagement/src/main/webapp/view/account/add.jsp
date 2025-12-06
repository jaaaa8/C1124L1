<%--
  Created by IntelliJ IDEA.
  User: DELL G3
  Date: 12/6/2025
  Time: 6:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ADD NEW</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/accounts?action=list">BACK TO LIST</a>
<br><br>
<form action="${pageContext.request.contextPath}/accounts" method="post">
    <input type="hidden" name="action" value="add">
    Name: <input type="text" name="username"><br>
    Password: <input type="text" name="password"><br>
    Email: <input type="text" name="email"><br>
    Role: <select name="role">
            <option value="admin">Admin</option>
            <option value="customer">Customer</option>
    </select><br>
    <button type="submit">Add Account</button>
</form>
</body>
</html>
