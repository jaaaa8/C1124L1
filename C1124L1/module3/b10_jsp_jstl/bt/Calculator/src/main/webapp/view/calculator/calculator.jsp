<%--
  Created by IntelliJ IDEA.
  User: DELL G3
  Date: 12/1/2025
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
<h1>Calculator</h1>
<c:if test="${not empty error}">
    <c:out value="${error}"/>
</c:if>
<c:if test="${empty error}">
    <p>
    <c:out value="${number1}"/> <c:out value="${operator}"/> <c:out value="${number2}"/> = <c:out value="${result}"/>
    </p>
</c:if>
</body>
</html>
