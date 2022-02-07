<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" /><br>
<form method="GET" action="/registration-url-path/userList" >
<input type="text" name="search" value="${searchInput}">
    <button type="submit">Search</button>
</form>
<form method="GET" action="/registration-url-path/userListAll">
FirstName<input type="text" name="firstName" value="${searchInput1}"><br>
LastName<input type="text" name="lastName" value="${searchInput2}">

    <button type="submit">Search</button>
</form>
   <table border="1">
     <tr>
          <td><b>Id</b></td>
          <td><b>Username</b></td>
          <td><b>Email</b></td>
          <td><b>FirstName</b></td>
          <td><b>LastName</b></td>
          <td><b>Password</b></td>
          <td><b>Edit</b></td>
          <td><b>Delete</b></td>
     </tr>
    <c:forEach items = "${userKey}" var="user">
      <tr>
           <td>${user.id}</td>
           <td>${user.username}</td>
           <td>${user.email}</td>
           <td>${user.firstName}</td>
           <td>${user.lastName}</td>
           <td>${user.password}</td>
           <td><a href = "/registration-url-path/register?id=${user.id}">Edit</td>
           <td><a href = "/registration-url-path/deleteUser?id=${user.id}">Delete</td>

      </tr>
</c:forEach>
</table>
<jsp:include page="../include/footer.jsp" />




