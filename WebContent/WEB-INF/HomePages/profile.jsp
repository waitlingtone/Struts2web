<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html>
<head>

<title><s:property value="#application.member.username"/> </title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href='<s:url value="/includes/css/profile-css.css"/>'>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<sb:head/>
</head>



<body>
<div class="jumbotron text-center"  style="background-image:url(<s:property value='memProfile.coverPhoto'/>); background-size: contain;">

  <h1 id="ownerProfile"><s:property value="member.firstname"/> &nbsp;'S Profile </h1>
  <p> 
  		<s:if test="memProfile.avatar!=''">
			<a href="javascript:void(0)" onclick="upload()" class="imgCss"> <img id="member_ava" src=<s:property value="memProfile.avatar"/> width="120" height="120" ></a>
		</s:if>
		<s:else>
			<a href="javascript:void(0)" onclick="upload()" class="imgCss"> <img id="member_ava" src="includes/pictures/avatar/defaultavatar.jpg" alt="user-img" width="120" height="120"></a>
		</s:else> 
		</p> 
</div>


<div class="container">
	<div class="row" >
		<div class="col-sm-4">
			<h3>Column 1</h3>
			<s:form action="uploadImg" method="post" enctype="multipart/form-data">
			     	<s:file id="imageavatar_src" name="userImage" label="Your Avatar"  />
			     	
			    	<s:submit id="uploadAvabtn" value="Upload" align="center" cssClass="btn btn-primary" />
			</s:form>
		</div>
		<div class="col-sm-8">
			<div class="div-form"></div>
		
			
			<div class="modal" id="update_Show">
				<div class="modal-dialog">
					
					<div class="modal-content">
						<!-- Modal header -->
						<div class="modal-header">
							<h4 class="modal-title">Nhập thông tin cập nhật</h4>
							<button type="button" class="close" id="closeX">&times;</button>
						</div>
						<!-- Modal body -->
						<div class="modal-body">
						
						</div>
						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary" id="saveChangebtn">Lưu thay đổi</button>
						</div>
					</div>
				</div>
		</div>
		
		<div class="example"></div>
		
		<div id="member_info" >
				<h3>Thông tin cá nhân</h3><br>
				<form action="updateMember" id="profileForm">
					<input type="hidden" value="${member.memberId}" id="idmember"/>
					<s:label value="Tên đăng nhập:"/>  <s:property value="member.username"/> <br>
					<s:label value="Tên:"/>  <s:property value="member.firstname"/><br>
					<s:label value="Họ:"/>  <s:property value="member.lastname"/><br>
					<s:label value="Điện thoại:"/> <s:property value="member.phone"/><br>
					<s:label value="Sinh nhật:"/> <s:property value="member.birthday"/><br>
					<s:label value="Passport:"/> <s:property value="member.birthday"/><br>
					<s:label value="Email:"/>  <s:property value="member.email"/><br>
					<s:label value="Địa chỉ:"/>  <s:property value="member.address"/><br>
					<s:label value="Giới tính:"/>&nbsp;
					<s:if test="member.sex==0"> Nam</s:if>	<s:else>Nữ</s:else>
					<s:label value="Test:"/>  <s:property value="key1"/><br>
					<br><button id="updatebtn" class="btn btn-primary" style="float: right;">Cập nhật</button>
					
				
				</form>
				
		</div>
				
	</div>
	</div>			
</div>
</body> 
<script type="text/javascript" src='<s:url value="/includes/script/profile-script.js"/>'></script>
</html>