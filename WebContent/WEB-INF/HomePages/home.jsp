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
  <link rel="stylesheet" href='<s:url value="/includes/css/home-css.css"/>'>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>    
    /* Set black background color, white text and some padding */
    footer {
      margin-bottom:0px;
      background-color: #555;
      color: white;
      padding: 15px;
    }
   
  </style>
</head>
<sb:head/>
<body style="background-color: #f5f5f5;">
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
        <li class="active"><a href="home">home</a></li>
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
        <li><a href="profile"><span class="glyphicon glyphicon-user">${member.getName}</span></a></li>
        <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
      </ul>
    </div>
  </div>
</nav>
<div id="main-container">
<div class="container text-center" >    
  <div class="row">
    <div class="col-sm-3 well">
      <div class="well">
        <p><a href="#">My Profile</a></p>
        <img src="bird.jpg" class="img-circle" height="65" width="65" alt="Avatar">
      </div>
      <div class="alert alert-success fade in">
        <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
        <p><strong>Ey!</strong></p>
        People are looking at your profile. Find out who.
      </div>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-7 main-row">
    
      <div class="row">
        <div class="col-sm-12">
          <div class="panel panel-default text-left">
            <div class="panel-body">
            <s:form cssClass="well form-vertical" theme = "bootstrap" action="create_post">
				<s:textfield cssClass="new-post" name="post.title" label="Title"></s:textfield>
            	<s:textarea cssClass="new-post" name="post.content" label="Content"></s:textarea>
            	            	<s:submit id="submit_post" class="btn btn-success" value="Create"/>   
            </s:form>

            </div>
          </div>
        </div>
      </div>
      <div id="resultDiv">
      <div id="showPostEdit"></div>
      <div class="presentation"></div>
      <s:iterator value="list">
		<%@ include file="/includes/div-post.jsp" %>
      </s:iterator>     
    </div>
    </div>
    <div class="col-sm-2 well">
      <div class="thumbnail">
        <p>Upcoming Events:</p>
        <img src="paris.jpg" alt="Paris" width="400" height="300">
        <p><strong>Paris</strong></p>
        <p>Fri. 27 November 2015</p>
        <button class="btn btn-primary">Info</button>
      </div>      
      <div class="well">
        <p>ADS</p>
      </div>
      <div class="well">
        <p>ADS</p>
      </div>
    </div>
  </div>
</div>
</div>
<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src='<s:url value="/includes/script/home-script.js"/>'></script>

</body>
</html>
