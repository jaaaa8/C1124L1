<%--
  Created by IntelliJ IDEA.
  User: DELL G3
  Date: 12/2/2025
  Time: 5:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>LIST PRODUCT</title>
</head>
<body>
<p>
    <a href="${pageContext.request.contextPath}/products?action=add">ADD NEW PRODUCT</a>
</p>
<table border="1">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PRICE</th>
        <th>CATEGORY</th>
        <th>QUANTITY</th>
        <th>DISCOUNT</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.category}</td>
            <td>${product.quantity}</td>
            <td><fmt:formatNumber value="${product.discount * 100}" pattern="#0.0"/>%</td>
            <td>
                <a href="${pageContext.request.contextPath}/products?action=detail&id=${product.id}">Detail</a> |
                <a href="${pageContext.request.contextPath}/products?action=update&id=${product.id}">Update</a> |
                <a href="${pageContext.request.contextPath}/products?action=delete&id=${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
