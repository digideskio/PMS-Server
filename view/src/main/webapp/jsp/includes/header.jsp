<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<table>
<tr><td><img src="/static/images/logo.png"/></td><td><div style="font:24px arial,sans-serif"><font color="red">E</font>uphoria</div></td><td align=right>
<security:authorize access="isAuthenticated()">
    logged in as <security:authentication property="principal.username" /> 
</security:authorize>

<security:authorize access="! isAuthenticated()">
    not logged in
</security:authorize>
</td></tr>
</table>
