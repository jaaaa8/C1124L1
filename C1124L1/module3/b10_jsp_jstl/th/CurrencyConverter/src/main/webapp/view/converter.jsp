<%--
  Created by IntelliJ IDEA.
  User: DELL G3
  Date: 11/28/2025
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<%
    double rate = Float.parseFloat(request.getParameter("rate"));
    double usd = Float.parseFloat(request.getParameter("usd"));
    double vnd = rate * usd;
%>

<h1>Rate: <%=rate%></h1>
<h1>USD: <%=usd%></h1>
<h1>VND: <%=vnd%></h1>

</body>
</html>
