<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<s:iterator value="list_comment">
<div class="post-comment">
<div class="col-sm-1"><img alt="avatar" src=<s:property value="avatar"/> class="img-circle" width="30px" height="30px" ></div>
<div class="col-sm-11">
<label style="float:left;"><a href="/Struts2web/user/${memberId}/home">${cmt_person}</a></label>
	<p name="comment_post_p">&nbsp;&nbsp;${content}</p>
</div>
</div>
</s:iterator>
<div class="post-comment">
<div class="col-sm-1"><img alt="avatar" src="${profile.avatar}" class="img-circle" width="30px" height="30px" ></div>
<div class="col-sm-11">
	<input type="text" placeholder="Write comment here ...." class="comment_post" name="comment_post" />
</div>
</div>
