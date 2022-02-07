<%@ page contentType="text/html; charset=UTF-8" %>
<%--<html>
<head><title>First JSP</title></head>
<link rel="stylesheet" href="/pub/css/style.css">
<body>--%>
<jsp:include page="include/header.jsp"/>

<h1>The first JSP page</h1>

<form method="GET" action="/indexSubmit">
  Username <input type="text"  name="username"><br><br>
  First Name  <input type="text"  name="firstName"><br><br>
  Last name <input type="text" name ="lastName"><br><br>
  <button type="submit" >Submit </button>
</form>
<jsp:include page="include/footer.jsp" />
<%--</body>
</html>--%>


