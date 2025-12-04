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
    <title>HOME</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/products" method="post">
    <input type="hidden" name="action" value="list">
    <button type="submit">ZO DAY</button>
</form>
</body>
</html>
