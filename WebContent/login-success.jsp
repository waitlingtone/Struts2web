<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="report">
	<s:submit value="get List"></s:submit>
</s:form>
	<table>
	<thead>
		<tr>
		<th>User name</th>
		<th>Password</th>
		<th>First name</th>
		<th>Last name</th>
		</tr>
	</thead>
	<s:iterator value="list">
		<tr>
		<td><s:property value="username"/></td>
		<td><s:property value ="password"/></td>
		<td><s:property value="first_name"/></td>
		<td><s:property value="last_name"/></td>
		</tr>
	</s:iterator>
	</table>
</body>
</html>