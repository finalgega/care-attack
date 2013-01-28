<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Paprika" />
<link rel="stylesheet" type="text/css" href="styles/index.css" />
<link rel="stylesheet" type="text/css" href="styles/rentalSvc.css" />
<title>Rental Services</title>
<script type="text/javascript" src="scripts/tinyboxs.js"></script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<center>
	<br/>
		<h1>Rental Services</h1>
	</center>
	<form id="createProducts" method="POST" action="ProductServlet" >
		<div id="testdiv">
		<div class="button" id="testclick1">
			<center>
				<strong>&hearts;&hearts;&hearts;&hearts;&hearts;CREATE NEW
					PRODUCTS HERE!&hearts;&hearts;&hearts;&hearts;&hearts;</strong>
			</center>
		</div>
		<div class="button" id="testclick2">
			<center>
				<strong>&hearts;&hearts;&hearts;&hearts;&hearts;VIEW IMAGES
					HERE!&hearts;&hearts;&hearts;&hearts;&hearts;</strong>
			</center>
		</div>

		<div class="button" id="testclick3">
			<center>
				<strong>&hearts;&hearts;&hearts;&hearts;&hearts;VIEW
					MESSAGE HERE!&hearts;&hearts;&hearts;&hearts;&hearts;</strong>
			</center>
		</div>

	</div>

	<script type="text/javascript">
	T$('testclick1').onclick = function(){TINY.box.view("createProducts.jsp",1,400,200,1)}
	var content2 = "<img src='images/walkingstick.jpg' width='298' height='373' alt='' />";
	T$('testclick2').onclick = function(){TINY.box.view(content2,0,0,0,1)}
	var content3 = "Hello, welcome to our rental services! Over here, you can rent our items for the disabled people at a lower price! <br/><br/> *Terms & Conditions apply.";
	T$('testclick3').onclick = function(){TINY.box.view(content3,0,0,0,0,8)}
</script>
</form>
</body>
</html>