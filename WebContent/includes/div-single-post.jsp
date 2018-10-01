<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

 	<div class="post-header">
 			<a href="" onclick="return false;"><img alt="more" class="more-action" src="/Struts2web/includes/pictures/icons/icon-more.png"></a>
 			<div class="dropdown-content">
			    <a href="/Struts2web/post/${post.postId}/edit" class="edit-link">Edit post</a>
			    <a href="/Struts2web/post/${post.postId}/delete" class="delete-link">Delete</a>
			  </div>
		 	<img src="${profile.avatar}"  width="100px" height="100px" class="img-circle col-sm-3" alt="Avatar">
		 	<div class="post-header-content col-sm-9" align="left">
		 		<label class="post-title"><s:property value="post.title"/></label><br>
		 		<p align="left" class="post-date">
		 		<s:if test="%{post.postDate == post.updateAt}">
		 			<s:property value="post.postDate"/>
		 		</s:if>
		 		<s:else>
		 			<s:property value="post.updateAt"/> - Đã chỉnh sửa
		 		</s:else>
		 		
		 		</p>
		 	</div>
	 	</div>
	 	<div class="post-content">
	 		<p align="left"><s:property value="post.content"/></p>
	 	</div>
	 	<input type="hidden" class="postId" value="${post.postId}"/>
	 	<button class="btn btn-default btn-loadComment"> Load comment</button>
	 	<div class="post-footer">
	 	</div>
<script>
var jPostEdit;
$(".edit-link").click(function(e){
	e.preventDefault();
	jPostEdit = $(this).parents().eq(2);
	var	jUrl = $(this).attr("href");
	var jPost = $(this).attr("href").split("/");
//	console.log(jUrlPost[3]); //lay id post
	$.ajax({
		url: jUrl,
		method: "POST",
		data:{"post.postId" : jPost[3]},
		success: function(data){
			$("div .presentation").addClass("presentation-visited");
			$("#showPostEdit").html(data);
			$("#showPostEdit").addClass("higherIndex");
		}
	})
});
</script>