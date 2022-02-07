
<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>--%>
<%--<html>
<head><title>Login JSP</title></head>

<body>

<h1>The Login JSP page</h1>

<form method="GET" action="/loginSubmit">
  Username <input type="text"  name="username"><br><br>
  Password  <input type="text"  name="password"><br><br>

  <button type="submit" >Submit </button>
</form>
</body>
</html>--%>


<%--<html>

<body>

<form action="/loginFormSubmit">
	Username : <input type="text" name="usernameFromForm">
	<br>
	Password: <input type="password" name="passwordFromForm">

	<button type="submit">Submit</button>

</form>

</body>

</html>--%>


<%--<html>

<body>--%>

<jsp:include page="../include/header.jsp"/>

<%--<form action="/loginsubmit2">
<h1 style="color:red" >${errorMessage}</h1>
	Username : <input type="text" name="usernameFromForm"><br>
	Password: <input type="password" name="passwordFromForm"><br>
    <button type="submit">Submit</button>

</form>--%>

<form action="/login/loginSecurityPost" method="POST">
<h1 style="color:red" >${errorMessage}</h1>
	Username : <input type="text" name="username"><br>
	Password: <input type="password" name="password"><br>
    <button type="submit">Submit</button>

</form>


<%--</body>

</html>--%>

<jsp:include page="../include/footer.jsp" />
