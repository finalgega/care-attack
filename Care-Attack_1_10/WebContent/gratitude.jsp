<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/gratitude.css"/>
<title>Letters Of Gratitude</title>
</head>
<body>
	<center>
		<h1>Letters Of Gratitude</h1>
	</center>
	<div id="kitty"><img src="images/hk.jpg"/></div>
	<div id="letters">
		<div id="appear"></div>
		<div id="text">
			<form id="form1" name="form1" method="post" action="">
				<label for="text"></label>
				<textarea name="text" id="text" cols="45" rows="5"></textarea>
				<input id="go" name="goButton" type="submit" value="Go" />
			</form>
		</div>
	</div>
</body>
</html>