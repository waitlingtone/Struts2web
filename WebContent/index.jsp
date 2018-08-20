<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Hello World</title>
<s:head/>
</head>
<body>
<s:a action="register.action">register</s:a>
  <h1>Struts2 - Hello World</h1>
  <s:form action="login.action" validate="true">
    <s:textfield name="member.username" label="Username"/>
    <s:password name="member.password" label="Password"></s:password>
    <s:submit value="Submit" />
  </s:form>
  <s:form action="checkConnection.action">
  	<s:submit value = "Test Connection"></s:submit>
  </s:form>
  <br/>
</body>
</html>
