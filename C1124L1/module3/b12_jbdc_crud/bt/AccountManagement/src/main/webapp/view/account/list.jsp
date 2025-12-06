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
    <title>LIST PRODUCT</title>
</head>
<body>
<p>
    <a href="${pageContext.request.contextPath}/accounts?action=add">ADD NEW ACCOUNT</a>
</p>
<table border="1">
    <tr>
        <th>USERNAME</th>
        <th>PASSWORD</th>
        <th>EMAIL</th>
        <th>ROLE</th>
    </tr>
    <c:forEach var="account" items="${accounts}">
        <tr>
            <td>${account.username}</td>
            <td>${account.password}</td>
            <td>${account.email}</td>
            <td>${account.role}</td>
            <td>
                <a href="${pageContext.request.contextPath}/accounts?action=update&id=${account.id}">Update</a> |
                <a href="${pageContext.request.contextPath}/accounts?action=delete&id=${account.id}">Delete</a> |
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
