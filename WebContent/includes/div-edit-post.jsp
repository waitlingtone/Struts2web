<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="edit-post">
<s:form action="post/edit" cssClass="well form-vertical" theme = "bootstrap">
	<div class="edit-title">
		<s:textfield label="Title" name="post.title" value="%{post.title}"></s:textfield>
	</div>
	<div class="edit-content">
	<s:textarea label="Content" rows="5" name="post.content" value="%{post.content}"></s:textarea>
	</div>
	<input type="hidden" name="post.memberId" id="memberId" value="${post.memberId}"/>
	<input type="hidden" name="post.postId" id="postId" value="${post.postId}"/>
	<s:submit cssClass="btn btn-primary submit_edit" value="Update"></s:submit>
	<button class="btn btn-success" onclick="return false;">Cancel</button>
</s:form>
</div>