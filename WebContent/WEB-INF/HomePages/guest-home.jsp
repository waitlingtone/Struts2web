<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tree-tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href='<s:url value="/includes/css/guest-home-css.css"/>'>
  <link rel="stylesheet" href='<s:url value="/includes/css/home-css.css"/>'>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/Struts2web/home">home</a></li>
        <li><a href="#">Messages</a></li>
        <li>
        <s:form class="navbar-form" autocomplete="off" id="frmSearchMember" method="POST" action="searchMember">
        <div class="form-group input-group">
          <input type="text" id="search-name" name="search-name" class="form-control" placeholder="Search..">
          <span class="input-group-btn">
            <button class="btn btn-default" type="button" id="btn-searchMember">
              <span class="glyphicon glyphicon-search"></span>
            </button>
          </span>        
        </div>
        <div class="dropdown-content">
        </div>
      </s:form></li>
      </ul>
       <ul class="nav navbar-nav navbar-right">
        <li><a href='<s:url action="profile"/>'><span class="glyphicon glyphicon-user">%{member.firstName}</span></a></li>
        <li><a href='<s:url action="logout"/>'><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
      </ul>
    </div>
  </div>
</nav>
<div>
	<div class="img-coverphoto">
		<img alt="default" src=<s:property value="profile.coverPhoto"/> >
	</div>
	<div class="img-avatar">
		<img alt="avatar" src=<s:property value="profile.avatar"/> >
	</div>
</div>
<div class="content-div">
<div class="row">
	<div class="col-sm-3 content-info">
	<%@ include file="/includes/div-content-infomation.jsp" %>
	</div>
	<div class="col-sm-8 content-post">
	      <div id="resultDiv">
      <div class="presentation"></div>
      <s:iterator value="list_post">
		<%@ include file="/includes/div-post.jsp" %>
      </s:iterator>     
    </div>
	</div>
</div>
</div>
<script type="text/javascript" src='<s:url value="/includes/script/home-script.js"/>'></script>
</body>
</html>