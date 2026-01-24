<%--
  Created by IntelliJ IDEA.
  User: DELL G3
  Date: 1/10/2026
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/convert">
    Amount:
    <input type="number" name="amount" value="${money.amount}" />

    Rate:
    <input type="number" name="rate" value="${money.rate}" />

    Type:
    <select name="type" onchange="this.form.submit()">
        <option value="VND" ${money.type == 'VND' ? 'selected' : ''}>VND → USD</option>
        <option value="USD" ${money.type == 'USD' ? 'selected' : ''}>USD → VND</option>
    </select>

    <button>Convert</button>
</form>

<c:if test="${not empty result and money.type == 'VND'}">
    <h3>Kết quả: ${result} USD</h3>
</c:if>

<c:if test="${not empty result and money.type == 'USD'}">
    <h3>Kết quả: ${result} VND</h3>
</c:if>
</body>
</html>
