<%--
  Created by IntelliJ IDEA.
  User: Mike
  Date: 22.02.2018
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<div>Name:<c:out value="${requestScope.user.name}"></c:out></div>
<div>Age:<c:out value="${requestScope.user.age}"></c:out></div>

<form method="post" action="/update">

    <label>  New name:<input type="text" name="name"></label> <br>
    <label>  New age:<input type="text" name="age"></label>
    <input type="number" hidden name="id" value="${requestScope.user.id}">
    <input type="submit" ><br>

</form>

</body>
</html>
