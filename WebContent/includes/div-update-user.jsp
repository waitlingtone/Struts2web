<%@page import="com.opensymphony.xwork2.util.ValueStack"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="Model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h2>Thông tin cá nhân</h2>
<form id="updateProfile" action="saveChangeData">
<s:hidden id="idMember" name="member.memberid" value="%{member.memberId}" />
<s:textfield cssClass="form-control" id="firstname" name="member.firstname" value="%{member.firstname}" label="Tên" ></s:textfield>
<s:textfield  cssClass="form-control" id="lastname" name="member.lastname" value="%{member.lastname}" label="Họ"  ></s:textfield>
<s:textfield  cssClass="form-control" id="phone" name="member.phone" value="%{member.phone}" label="Điện thoại"></s:textfield>
<s:textfield cssClass="form-control" id="address" name="member.address" value="%{member.address}" label="Địa chỉ"></s:textfield>
<s:textfield cssClass="form-control" id="passport" name="member.passport" value="%{member.passport}" label="Passport"></s:textfield>
<s:textfield cssClass="form-control" id="birthday" name="member.birthday" value="#" label="Sinh nhật" type="date"></s:textfield>
</form>
