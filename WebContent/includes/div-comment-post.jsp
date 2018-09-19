<%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="list_comment">
<div class="post-comment">
<div class="col-sm-1"><img alt="avatar" src="" class="img-circle" width="30px" height="30px" ></div>
<label class="col-sm-3">member name</label>
<div class="col-sm-7">
	<p name="comment_post_p">${content}</p>
</div>
</div>
</s:iterator>
<div class="post-comment">
<div class="col-sm-1"><img alt="avatar" src="" class="img-circle" width="30px" height="30px" ></div>
<div class="col-sm-11">
	<input type="text" placeholder="Write comment here ...." class="comment_post" name="comment_post" />
</div>
</div>
