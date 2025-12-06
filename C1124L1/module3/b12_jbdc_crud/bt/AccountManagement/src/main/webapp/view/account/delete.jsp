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
    <title>DELETE</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/accounts?action=list">BACK TO LIST</a>
<br><br>
<form method="post">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="id" value="${account.id}">
    Are you sure you want to delete the account: <strong>${account.username}</strong>
    <br><br>
    <button type="submit">Yes, Delete</button>
</form>
</body>
</html>
