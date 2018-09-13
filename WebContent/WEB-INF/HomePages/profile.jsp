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

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<sb:head/>
<style type="text/css">

	#ownerProfile
	{
		color:blue;
	}
	.col-sm-4{
		border-right: 1px solid blue;
		
	}
	.col-sm-8{
		
	}
	#updateImage{
		text-align: center;
	}
	
	label[for="imageavatar_src"], label[for="username"],
	{color:red;}
	.label{
		color:red;
		width:180px;
	    clear:left;
	    text-align:right;
	    padding-right:10px;
	}
	
	#imageavatar_src{
		white-space: nowrap;
	    overflow: hidden;
	    text-overflow: ellipsis;
	    width: 250px;
	}
	#memberinfo{
	 	display: grid;
 		grid-template-columns: 1fr 3fr;
	}
	
</style>


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
			<h3>Thông tin cá nhân</h3>
			<form action="updateMember">
			<div id="memberinfo" >
				<s:textfield cssClass="form-control" id="username" name="member.username" value="%{member.firstname}" label="Tên đăng nhập" disabled="true" ></s:textfield>
				<s:textfield cssClass="form-control" id="firstname" name="member.firstname" value="%{member.firstname}" label="Tên" disabled="true" ></s:textfield>
				<s:textfield cssClass="form-control" id="lastname" name="member.lastname" value="%{member.lastname}" label="Họ" disabled="true" ></s:textfield>
				<s:textfield cssClass="form-control" id="birthday" name="member.birthday" value="%{member.birthday}" label="Sinh nhật" type="Date" disabled="true" ></s:textfield>
				<s:textfield cssClass="form-control" id="phone" name="member.phone" value="%{member.phone}" label="Điện thoại" disabled="true" ></s:textfield>
				<s:textfield cssClass="form-control" id="address" name="member.address" value="%{member.address}" label="Địa chỉ" disabled="true" ></s:textfield>
				<button id="updatebtn" value="Cập nhật" class="form-control"></button>
			</div>
			</form>
			
		
			
	</div>
	</div>			
</div>
</body>
<script type="text/javascript">
function readURL(input) {

  if (input.files && input.files[0]) {
    var reader = new FileReader();

    reader.onload = function(e) {
      $('#member_ava').attr('src', e.target.result);
    }

    reader.readAsDataURL(input.files[0]);
  }
}

$("#imageavatar_src").change(function() {
  readURL(this);
});
</script>
</html>