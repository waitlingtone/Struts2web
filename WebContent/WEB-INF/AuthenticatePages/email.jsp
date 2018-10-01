<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href='<s:url value="/includes/css/home-css.css"/>'>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href='<s:url value="/includes/css/email-css.css"/>'>
<title>Insert title here</title>
</head>
<body>
<div class="sendEmailDiv">
	<s:form id="frm_emailer" method="post">
		<s:hidden id="to" for="to" name="to" value="%{member.email}"/>
		<s:hidden for="member.verifyCode"  key="member.verifyCode" value="%{member.verifyCode}"/>
		<label class="label">Email bạn đã đăng kí:</label> <s:property value="%{member.email}"/><br>
		<button id="btn_submit">Send your code</button>
   </s:form>
</div>
<div id="backgroundGrey" class="contentGrey">
</div>
<div>
<div class="modal" id="inputCode">
				<div class="modal-dialog">
					
					<div class="modal-content">
						<!-- Modal header -->
						<div class="modal-header">
							<h4 class="modal-title">Nhập Mã Xác Nhận</h4>
							<button type="button" class="close" id="closeX">&times;</button>
						</div>
						<!-- Modal body -->
						<div class="modal-body">
						
						</div>
						<!-- Modal footer -->
						<div class="modal-footer">
							<button  class="btn btn-primary" id="btnCheckCodeEqual">Submit Verify Code</button>
						</div>
					</div>
				</div>
		</div>
</div>

</body>
<script type="text/javascript" src="<s:url value='/includes/script/email-script.js'/>"></script>
</html>