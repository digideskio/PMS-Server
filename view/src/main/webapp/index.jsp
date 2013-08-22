<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<!-- The DOCTYPE declaration above will set the    -->
<!-- browser's rendering engine into               -->
<!-- "Standards Mode". Replacing this declaration  -->
<!-- with a "Quirks Mode" doctype may lead to some -->
<!-- differences in layout.                        -->
<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="euphoria/reset.css" />
    <title>Euphoria</title>

    <!--                                           -->
    <!-- This script loads your compiled module.   -->
    <!-- If you add any GWT meta tags, they must   -->
    <!-- be added before this line.                -->
    <!--                                           -->
    <script type="text/javascript" src="euphoria/euphoria.nocache.js"></script>
	<script type="text/javascript">
    	function getLoginUsername() {
    		return document.forms[0].userid.value;
    	}
    </script>    
  </head>

  <body>
  	<form id="loginform" name="loginform">
		 <security:authorize access="isAuthenticated()">
		    <input type="hidden" name="userid" value='<security:authentication property="principal.username" />' />
		</security:authorize>
		
		<security:authorize access="! isAuthenticated()">
		    <input type="hidden" name="userid" value='Not logged in' />
		</security:authorize> 	
  	</form>
  	
    <!-- OPTIONAL: include this if you want history support -->
    <iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1' style="position:absolute;width:0;height:0;border:0"></iframe>

    <!-- RECOMMENDED if your web app will not function without JavaScript enabled -->
    <noscript>
      <div style="width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif">
        Your web browser must have JavaScript enabled
        in order for this application to display correctly.
      </div>
    </noscript>
    <div id="loading" style="font-family: Arial;font-size: 11pt">Loading. Please wait...</div> 
	<div id="bodypanel">
	</div>
  </body>
</html>
