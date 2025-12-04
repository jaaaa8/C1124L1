<%--
  Created by IntelliJ IDEA.
  User: DELL G3
  Date: 12/2/2025
  Time: 5:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DETAIL</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/products?action=list">BACK TO LIST</a>
<h1>
    <c:out value="${product.name}"/>
</h1>
<h4>
    <c:out value="Price: ${product.price}"/>
</h4>
<h4>
    <c:out value="Category: ${product.category}"/>
</h4>
<h4>
    <c:out value="Quantity: ${product.quantity}"/>
</h4>
<h4>
    <c:out value="Discount: ${product.discount}"/>
</h4>
</body>
</html>
