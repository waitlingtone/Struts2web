<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
 <div class="post">
 	<div class="post-header">
 			<s:if test="%{id == null}">
 			<a href=""><img alt="more" class="more-action" src="/Struts2web/includes/pictures/icons/icon-more.png"></a>
 			<div class="dropdown-content">
			    <a href="/Struts2web/post/${postId}/edit" class="edit-link">Edit post</a>
			    <a href="/Struts2web/post/${postId}/delete" class="delete-link">Delete</a>
			  </div>
			 </s:if>
		 	<img src="${profile.avatar}"  width="100px" height="100px" class="img-circle col-sm-3" alt="Avatar">
		 	<div class="post-header-content col-sm-9" align="left">
		 		<label class="post-title"><s:property value="title"/></label><br>
		 		<p align="left" class="post-date">
		 		<s:if test="%{postDate == updateAt}">
		 			<s:property value="postDate"/>
		 		</s:if>
		 		<s:else>
		 			<s:property value="updateAt"/> - Đã chỉnh sửa
		 		</s:else>
		 		
		 		</p>
		 	</div>
	 	</div>
	 	<div class="post-content">
	 		<p align="left"><s:property value="content"/></p>
	 	</div>
	 	<input type="hidden" class="postId" value="${postId}"/>
	 	<br>
	 	<button class="btn btn-default btn-loadComment"> Load comment</button>
	 	<div class="post-footer">
	 	</div>
</div>
