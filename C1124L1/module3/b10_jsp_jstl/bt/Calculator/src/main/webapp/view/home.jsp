<%--
  Created by IntelliJ IDEA.
  User: DELL G3
  Date: 12/1/2025
  Time: 1:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1>SIMPLE CALCULATOR</h1>
<form action="${pageContext.request.contextPath}/calculator" method="post">
    <label> Number 1:
        <input type="number" name="number1" value="${number1}"/>
    </label> <br>
    <label> Operator:
        <select name="operator">
            <option value="+" <c:if test="${operator == '+'}">selected</c:if>>+</option>
            <option value="-" <c:if test="${operator == '-'}">selected</c:if>>-</option>
            <option value="*" <c:if test="${operator == '*'}">selected</c:if>>*</option>
            <option value="/" <c:if test="${operator == '/'}">selected</c:if>>/</option>
        </select>
    </label><br>
    <label> Number 2:
        <input type="number" name="number2" value="${number2}"/>
    </label><br>
    <button type="submit">SUBMIT</button>
</form>
</body>
</html>
