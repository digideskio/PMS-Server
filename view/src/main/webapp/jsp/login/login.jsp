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
	<font face="Arial">Please wait while we sign you in with your <img src="/static/images/google-logo.png"></img> account...</font>
	<form name="loginForm" id="loginForm" action="/j_spring_openid_security_check" method="post">
		<input name="openid_identifier" type="hidden" value="https://www.google.com/accounts/o8/id"/>
	</form>
	
	<script>
		function login() {
		    document.forms[0].submit();
		}
		
		window.onload = login;
	</script>
</body>
</html>