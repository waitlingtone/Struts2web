<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
<style>
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
<%
	session = request.getSession(false);
	Integer session_login = (Integer) session.getAttribute("memberId");
	if(session_login != null && !session_login.equals(0)){
		response.sendRedirect("home");
		return;
	}
%>
<div class = "container">
 <h2>
 	<span style = "text-align:center"> Đăng nhập</span>
 </h2>

  <div  class = "container-fluid" >
  <s:form action="login-action"  method ="POST" cssClass="well form-vertical" theme = "bootstrap">
  
    <s:textfield  name="member.username" label="Username" tooltip="Nhập tên của bạn ở đây"/>
    <s:password name="member.password" label="Password"  ></s:password>
    <s:submit value="Submit" cssClass = "btn btn-primary"  />
    
  </s:form>
  </div>
 </div>
</body>
</html>
