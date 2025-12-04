<%--
  Created by IntelliJ IDEA.
  User: DELL G3
  Date: 12/2/2025
  Time: 5:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ADD NEW</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/products?action=list">BACK TO LIST</a>
<br><br>
<form action="${pageContext.request.contextPath}/products" method="post">
    <input type="hidden" name="action" value="add">
    Name: <input type="text" name="name"><br>
    Price: <input type="text" name="price"><br>
    Category: <input type="text" name="category"><br>
    Quantity: <input type="number" name="quantity"><br>
    Discount: <input type="number" name="discount"><br>
    <button type="submit">Add Product</button>
</form>
</body>
</html>
