<%--
  Created by IntelliJ IDEA.
  User: DELL G3
  Date: 11/29/2025
  Time: 4:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <c:import url="../layout/library.jsp"/>
</head>
<body>
<table class="table table-dark table-striped"> CUSTOMER LIST
    <c:if test="${customerList == null}">
        <tr>
            <td colspan="6">No customers available.</td>
        </tr>
    </c:if>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>Score</th>
        <th>Rank</th>
    </tr>
    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${customer.id}</td>
            <td>${customer.name}</td>

            <c:if test="${customer.gender}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!customer.gender}">
                <td>Nữ</td>
            </c:if>

            <td>${customer.score}</td>

            <td>
                <c:choose>
                    <c:when test="${customer.score >= 8}">
                        Excellent
                    </c:when>
                    <c:when test="${customer.score >= 6.5}">
                        Good
                    </c:when>
                    <c:when test="${customer.score >= 5}">
                        Average
                    </c:when>
                    <c:otherwise>
                        Idiot
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>