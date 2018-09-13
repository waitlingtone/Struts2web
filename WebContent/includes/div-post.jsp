 <div class="post">
 	<div class="post-header">
		 	<img src=<s:property value="profile.avatar"/> class="img-circle col-sm-3" alt="Avatar">
		 	<div class="post-header-content col-sm-9" align="left">
		 		<label class="post-title"><s:property value="title"/></label><br>
		 		<p align="left" class="post-date"><s:property value="postDate"/></p>
		 	</div>
	 	</div>
	 	<div class="post-content">
	 		<p align="left"><s:property value="content"/></p>
	 	</div>
	 	<%@ include file="/includes/div-comment-post.jsp" %>
 </div>