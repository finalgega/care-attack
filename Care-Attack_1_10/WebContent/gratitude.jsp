<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body {
	background-color: black;
}

h1 {
	color: white;
	text-shadow: green;
}

#letters {
	margin-left: 500px;
	margin-top: 40px;
	width: 350px;
	height: 720px;
	border: 2px solid white;
}

#text {
	width: 350px;
	height: 140px;
	border: 2px solid yellow;
}

#form1 {
	margin-top: 0px;
	width: 350px;
	height: 140px;
}

#form1 textarea {
	margin-top: 0px;
	margin-left: 0px;
	width: 340px;
	height: 105px;
	overflow-y: scroll;
}

#go {
	width: 100px;
	height: 25px;
	float: right;
}

#appear {
	margin-top: 0px;
	margin-left: 0px;
	width: 345px;
	height: 572px;
	border: 2px solid blue;
}
</style>
<title>Letters Of Gratitude</title>
</head>
<body>
	<center>
		<h1>Letters Of Gratitude</h1>
	</center>
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