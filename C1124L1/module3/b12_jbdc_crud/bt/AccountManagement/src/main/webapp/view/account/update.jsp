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
    <title>UPDATE</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/accounts?action=list">BACK TO LIST</a>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="username" value="${account.username}" disabled></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="text" name="password" value="${account.password}"></td>
            </tr>
            <tr>
                <td>Email: </td>
                <td><input type="text" name="email" value="${account.email}"></td>
            </tr>
            <tr>
                <td>Role: </td>
                <td><select name="role">
                    <option value="admin">Admin</option>
                    <option value="customer">Customer</option>
                </select>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update account"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
