<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title></title>
  </head>
  <body>

  <h1>All users </h1>
<c:forEach var="user" items="${requestScope.users}">
 <ul>
   <li> Name:<c:out value="${user.name}"> </c:out>
     <li> Age: <c:out value="${user.age}"> </c:out>
     <li> Id: <c:out value="${user.id}"> </c:out>
     <form method="get" action="/update">
         <input type="number" hidden name="id" value="${user.id}" />
         <input type="submit" value="Editing"/>
     </form>
     <form method="post" action="/delete">
         <input type="number" hidden name="id" value="${user.id}" />
         <input type="submit" name="delete" value="Delete"/>
     </form>

 </ul>

</c:forEach>


  <h2>Add new user  </h2>

  <form method="post" action="/add_user">
     <label> <input type="text" name="name">Имя</label>
      <label><input type="number" name="age">Возраст</label>
      <br>
      <input type="submit" value="Add">
  </form>






  </body>
</html>