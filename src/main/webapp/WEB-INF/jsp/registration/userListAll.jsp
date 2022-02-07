<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:include page="../include/header.jsp" />
<form method="GET" action="/registration-url-path/userListAll">
<input type="text" name="search">
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
     </tr>
    <c:forEach items = "${userKey}" var="user">
      <tr>
           <td>${user.id}</td>
           <td>${user.username}</b></td>
           <td>${user.email}</b></td>
           <td>${user.firstName}</td>
           <td><b>${user.lastName}</td>
           <td><b>${user.password}</td>
      </tr>
</c:forEach>
</table>
<jsp:include page="../include/footer.jsp" />
