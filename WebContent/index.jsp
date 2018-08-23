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
<div>

<s:a href ="register">register</s:a>

</div>
<div class = "a">
 <h2  >
 	<span style = "text-align:center"> Đăng nhập</span>
 </h2>
</div>
  <div  class = "container-fluid" >
  <s:form action="login.action"  method ="POST" cssClass="well form-vertical" theme = "bootstrap">
  
    <s:textfield  name="member.username" label="Username" tooltip="Nhập tên của bạn ở đây"/>
    <s:password name="member.password" label="Password"  ></s:password>
    <div class="b">
    <s:submit value="Submit" cssClass = "btn btn-primary"  />
    </div>
    
  </s:form>
  </div>
  
  <s:form action="checkConnection.action" theme = "bootstrap">
  <div class = "b">
  	<s:submit value = "Test Connection" cssClass ="btn btn-danger" ></s:submit>
  </div>
  </s:form>

  <br/>
</body>
</html>
