<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE form PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Euphoria - Login</title>
</head>
<body>
	<div id="login-error">${error}</div>
	<font face="Arial" Color="Red">Sorry. You are denied access to this application</font>
	<div style="font-family: Arial;font-size: 10pt">
	To resolve this issue please follow the below steps <br>
	<ol>
	<li>Check the access log and look for the statement
		ConsumerManager  - Verification succeeded for: https://www.google.com/accounts/o8/id?id=xxxxxxxx
	<li>Open spring-security.xml and look for the bean userDetailsService
	<li>Add a new 'user' entry similar to the existing 'user' entry using the value got in step-1
	<li>If you are still unsure, please check with AJ
	</ol>
	</div>
</body>
</html>