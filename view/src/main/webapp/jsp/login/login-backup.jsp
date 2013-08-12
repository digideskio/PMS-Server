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
	<% if(request.getAttribute("error") == null) { %>
		<font face="Calibri" size="12pt">Transferring to Google Login.
			Please wait...</font>
		<form name="loginForm" id="loginForm" action="/j_spring_openid_security_check" method="post">
			<input name="openid_identifier" type="hidden"
				value="https://www.google.com/accounts/o8/id" />
			<input type="hidden" name="submit" value="Login"/> 	
		</form>
		<script type="text/javascript">
		    window.onload=function(){
		          document.forms["myForm"].submit();
		    }
		</script>		
	<% } else { %>
		<div id="login-error">${error}</div>
		<img src="/static/images/google-logo.png"></img>
		<form  name="loginForm" id="loginForm" action="/j_spring_openid_security_check" method="post">
			   Login again:
			  <input name="openid_identifier" type="hidden" value="https://www.google.com/accounts/o8/id"/>
			  <input type="submit" value="Sign with Google"/>
		</form>
	<% } %>
</body>
</html>