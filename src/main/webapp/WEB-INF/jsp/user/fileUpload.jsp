<jsp:include page="../include/header.jsp"/>
<h1>In  File Upload page...</h1>
<form method="POST" enctype="multipart/form-data" action="/user/fileUploadSubmit">

title : <input type = "text" name="title" />
select File: <input type ="file" name="file" />
<br>
<input type="submit" value="Submit"/>
<br>
</form>
<jsp:include page="../include/footer.jsp" />