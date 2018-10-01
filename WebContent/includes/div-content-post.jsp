<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tree-tags" %>
<div id="resultDiv">
      <div class="presentation"></div>
      <s:iterator value="list">
		<%@ include file="/includes/div-post.jsp" %>
      </s:iterator>     
</div>