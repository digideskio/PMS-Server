<!doctype html>
<!-- The DOCTYPE declaration above will set the    -->
<!-- browser's rendering engine into               -->
<!-- "Standards Mode". Replacing this declaration  -->
<!-- with a "Quirks Mode" doctype may lead to some -->
<!-- differences in layout.                        -->

<html>
  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Euphoria</title>

    <!--                                           -->
    <!-- This script loads your compiled module.   -->
    <!-- If you add any GWT meta tags, they must   -->
    <!-- be added before this line.                -->
    <!--                                           -->
    <script type="text/javascript" src="euphoria/euphoria.nocache.js"></script>
  </head>

  <body>
    <!-- OPTIONAL: include this if you want history support -->
    <iframe src="javascript:''" id="__gwt_historyFrame" tabIndex='-1' style="position:absolute;width:0;height:0;border:0"></iframe>

    <!-- RECOMMENDED if your web app will not function without JavaScript enabled -->
    <noscript>
      <div style="width: 22em; position: absolute; left: 50%; margin-left: -11em; color: red; background-color: white; border: 1px solid red; padding: 4px; font-family: sans-serif">
        Your web browser must have JavaScript enabled
        in order for this application to display correctly.
      </div>
    </noscript>
	<table>
		<tr><td colspan=2><%@include file="/jsp/includes/header.jsp" %></td></tr>
		<tr><td width="20%"><%@include file="/jsp/includes/menu.jsp" %></td><td><div id="rootpane"></div></td></tr>
	</table>
  </body>
</html>
