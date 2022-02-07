<%--<html>
<body>
<h1> in success page </h1>
<h1> Hello ${username} your have logged in to your account successfully.  </h1>

</body>
</html>--%>


<--%<html>

<body>--%>

<jsp:include page="../include/header.jsp"/>

User <b>${usernameSessionKey }</b> is logged in ( from session )
<br>
Logged in user = <b>${loggedInUser }</b> ( from response model )
<br>
<a href="/logout">Logout</a>
<--%</body>

</html>--%>

<jsp:include page="../include/footer.jsp"/>