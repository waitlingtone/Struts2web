<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
<s:form>
<s:textfield class="text-field" name="username" label="Username" ></s:textfield>
<s:password class="text-field" name="password" label="Password"></s:password>
<br>
<s:textfield class="text-field" name="first_name" label="First name"></s:textfield>
<s:textfield name="last_name" label="Last name"></s:textfield>
<s:textfield type="email" name="email" label="Email address"></s:textfield>
<s:textfield name="phone" label="Phone number"></s:textfield>
<s:textfield name="passport" label="Passport"></s:textfield>
<s:submit value="Register"></s:submit>
</s:form>

</body>
</html>