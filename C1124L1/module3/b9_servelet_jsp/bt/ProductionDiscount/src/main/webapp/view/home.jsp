<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Product Discount Calculator</h1>
<form action="${pageContext.request.contextPath}/display-discount" method="post">
    <label> Description
        <input name="des" placeholder="Description">
    </label>
    <br>
    <label> Base price
        <input name="price" placeholder="Base price">
    </label>
    <br>
    <label> Discount
        <input name="discount" placeholder="Discount %">
    </label>
    <br>
    <button type="submit">Calculator</button>
</form>
</body>
</html>
