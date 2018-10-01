<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
<style>
div.a {
    text-align: center;
    font-size: 35%;
    color : blue;
}
div.b{
	text-align: center;
}
</style>

   <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> 
<sb:head/>
</head>
<body>
<div class="container">
<div>
  <s:form action="register" theme = "bootstrap">
  <div class = "b">
  	<s:submit value = "Đăng ký" cssClass ="btn btn-danger" ></s:submit>
  </div>
  </s:form>
</div>
<div>
  <s:form action="login" theme = "bootstrap">
  <div class = "b">
  	<s:submit value = "Đăng nhập" cssClass ="btn btn-danger" ></s:submit>
  </div>
  </s:form>
</div>
<div>
  <s:form action="checkConnection.action" theme = "bootstrap">
  <div class = "b">
  	<s:submit value = "Test Connection" cssClass ="btn btn-danger" ></s:submit>
  </div>
  </s:form>
</div>
<div>
	<p><a href="test">Email</a><p>
</div>

</body>
</html>
