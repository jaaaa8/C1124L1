<%--
  Created by IntelliJ IDEA.
  User: DELL G3
  Date: 12/6/2025
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/accounts" method="post">
    <input type="hidden" name="action" value="list">
    <button type="submit">ZO DAY</button>
</form>
</body>
</html>
