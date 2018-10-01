<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tree-tags" %>
<h2>Thông tin cá nhân</h2>
<div><label>Họ tên:</label><p>${member.firstname}&nbsp;${member.lastname} </p></div>
<div><label>Giới tính:</label><p><s:if test="%{member.sex == '1'}">Nam</s:if><s:else>Nữ</s:else></p></div>
<div><label>Ngày sinh:</label><p>${member.birthday}</p></div>
<div><label>Địa chỉ:</label><p>${member.address}</p></div>