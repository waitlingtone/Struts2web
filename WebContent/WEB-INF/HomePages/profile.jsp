<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
<head>

<title><s:property value="#application.member.username"/> </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script><sb:head/>
</head>

<body>
	<s:actionerror/>

<div class="boxCss">
			<s:if test="member.avatar!=''">
				<a href="javascript:void(0)" onclick="upload()" class="imgCss"> <img id="member-ava" src=<s:property value="member.avatar"/> width="120" height="120"></a>
			</s:if>
			<s:else>
				<a href="javascript:void(0)" onclick="upload()" class="imgCss"> <img id="member-ava" src="includes/pictures/avatar/defaultavatar.jpg" alt="user-img" width="120" height="120"></a>
			</s:else>
</div>


<div>
	<s:form action="uploadImg" method="post" enctype="multipart/form-data">
		     	<div class="divCss">
			     	 Chọn file: <s:file id="image_src" name="userImage" label="Image" class="fileCss" />
			    	<s:submit id="uploadbtn" value="Upload" align="center" cssClass="btn btn-primary" />
		     	</div>
		     	<div>
		     		<img alt="Your-choose" src="#" id="pre_ava"/>
		     	</div>
	</s:form>
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

$("#image_src").change(function() {
  readURL(this);
});
</script>
</html>