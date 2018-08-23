<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>
<title>Hello World</title>
<sb:head/>
</head>
<body>
 <p> Hello World,<s:property value = "member.username"/> </p>
  Your pass is :<s:text name	 = "member.password" />
</body>
</html>
