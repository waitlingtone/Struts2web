<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
div.a{
	text-align : center;
	color : blue;
	font-size : 25%;
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
<div class = "a">
<h2>
<span style = "text-align:center"> Đăng kí</span>
</h2>
</div>
<div>
<s:form action ="insertMemberintodatabase" cssClass = "well form-vertical" theme = "bootstrap" method= "POST">
<s:textfield  name="member.username" label="Username" ></s:textfield>
<s:password  name="member.password" label="Password"></s:password>
<br>
<s:textfield  name="member.firstname" label="First name"></s:textfield>
<s:textfield name="member.lastname" label="Last name"></s:textfield>
<s:textfield type="email" name="member.email" label="Email address"></s:textfield>
<s:textfield name="member.phone" label="Phone number"></s:textfield>
<s:textfield name="member.address" label="Address"></s:textfield>
<s:textfield name="member.passport" label="Passport"></s:textfield>
<s:select key="member.sex" label="Select your gender"
		  list="#{'1':'Nam','2': 'Nữ'}"
		  value="1"/>
<s:textfield type= "date" format="dd-MM-yyyy" name="member.birthday" label ="Your birthday"/>
<s:submit value="Register" cssClass = "btn btn-primary"></s:submit>
</s:form>
</div>

</body>
</html>