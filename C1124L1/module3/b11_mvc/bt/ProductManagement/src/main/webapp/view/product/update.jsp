<%--
  Created by IntelliJ IDEA.
  User: DELL G3
  Date: 12/2/2025
  Time: 5:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UPDATE</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/products?action=list">BACK TO LIST</a>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="number" name="price" value="${product.price}"></td>
            </tr>
            <tr>
                <td>Category: </td>
                <td><input type="text" name="category" value="${product.category}"></td>
            </tr>
            <tr>
                <td>Quantity: </td>
                <td><input type="text" name="quantity" value="${product.quantity}"></td>
            </tr>
            <tr>
                <td>Discount: </td>
                <td><input type="text" name="discount" value="${product.discount}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update product"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
