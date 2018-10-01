<%@ page contentType="text/html; charset=UTF-8" %>
<div class="post-comment">
<div class="col-sm-1"><img alt="avatar" src="${comment.avatar}" class="img-circle" width="30px" height="30px" ></div>
<div class="col-sm-11">
	<label  style="float:left;"><a href="/Struts2web/user/${comment.memberId}/home">${comment.cmt_person}</a></label>
	<p name="comment_post_p">&nbsp;&nbsp;${comment.content}</p>
</div>
</div>