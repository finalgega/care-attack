<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Paprika" />
<style>
body {
	background-color: black;
}

#image {
	width: 500px;
	height: 530px;
	border: 5px solid black;
	margin-left: 260px;
}

#form1 {
	float: right;
}

h1 {
	color: white;
	font-family: paprika;
}

#container {
	width: 1000px;
	height: 550px;
	margin-left: 150px;
	margin-top: 150px;
}

#left {
	height: 10px;
	width: 100px;
	margin-top: 230px;
	float: left;
}

#right {
	height: 10px;
	width: 100px;
	float: right;
	margin-top: -300px;
}

h2 {
	font-size: 12px;
	font-weight: normal;
	font-style: italic;
	margin: 0 0 20px
}

p {
	margin-top: 0
}

ul {
	margin: 0;
	padding-left: 20px
}

#testdiv {
	width: 600px;
	margin: 0 auto;
	border: 1px solid #ccc;
	padding: 20px 25px;
	background: pink;
	margin-left: 350px;
}

#tinybox {
	position: absolute;
	display: none;
	padding: 10px;
	background: #fff url(images/preload.gif) no-repeat 50% 50%;
	border: 10px solid #e3e3e3;
	z-index: 2000
}

#tinymask {
	position: absolute;
	display: none;
	top: 0;
	left: 0;
	height: 100%;
	width: 100%;
	background: #000;
	z-index: 1500
}

#tinycontent {
	background: #fff
}

.button {
	font: 14px Georgia, Verdana;
	margin-bottom: 10px;
	padding: 8px 10px 9px;
	border: 1px solid #ccc;
	background: #eee;
	cursor: pointer
}

.button:hover {
	border: 1px solid #bbb;
	background: #e3e3e3
}
}
</style>
<title>Rental Services</title>
<script type="text/javascript" src="tinybox.js"></script>
</head>
<body>
	<center>
		<h1>Rental Services</h1>
	</center>
	<div id="container">
		<div id="left">
			<img src="images/left.png" />
		</div>
		<div id="image">
			<img src="images/wheelchair1.jpg" />
			<button style="width: 100; height: 10; float: right;">
				<a href="IndividualProductPage.jsp">Read more >></a>
			</button>
		</div>
		<div id="right">
			<img src="images/right.png" />
		</div>
	</div>
	<div id="testdiv">
		<div class="button" id="testclick1">
			<center>
				<strong>&hearts;&hearts;&hearts;&hearts;&hearts;CREATE NEW
					PRODUCTS HERE!&hearts;&hearts;&hearts;&hearts;&hearts;</strong>
			</center>
		</div>
		<div class="button" id="testclick2">
			<strong>Image</strong> - <em>click here</em>
		</div>

		<div class="button" id="testclick3">
			<strong>Auto-Hide</strong> - <em>click here</em>
		</div>
	</div>

	<script type="text/javascript">
	T$('testclick1').onclick = function(){TINY.box.show('createProducts.jsp',1,300,150,1)}
	var content2 = "<img src='images/walkingstick.jpg' width='298' height='373' alt='' />";
	T$('testclick2').onclick = function(){TINY.box.show(content2,0,0,0,1)}
	var content3 = "This will disappear in 3 seconds.";
	T$('testclick3').onclick = function(){TINY.box.show(content3,0,0,0,0,3)}
</script>
</body>
</html>