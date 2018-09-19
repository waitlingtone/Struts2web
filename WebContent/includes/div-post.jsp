 <div class="post">
 	<div class="post-header">
		 	<img src=<s:property value="profile.avatar"/> width="100px" height="100px" class="img-circle col-sm-3" alt="Avatar">
		 	<div class="post-header-content col-sm-9" align="left">
		 		<label class="post-title"><s:property value="title"/></label><br>
		 		<p align="left" class="post-date"><s:property value="postDate"/></p>
		 	</div>
	 	</div>
	 	<div class="post-content">
	 		<p align="left"><s:property value="content"/></p>
	 	</div>
	 	<input type="hidden" class="postId" value="${postId}"/>
	 	<button class="btn btn-default btn-loadComment"> Load comment</button>
	 	<div class="post-footer">
	 	</div>
</div>
