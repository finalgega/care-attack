<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<link href="styles/header.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Shadows Into Light Two" />
	<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Paprika" />
<script src="scripts/jquery-1.8.2.js"></script>
<script src="scripts/jquery-ui-1.9.1.custom.js"></script>
<script src="scripts/jquery.easing.1.3.js"></script>
<script src="scripts/animated-menu.js"></script>
<script src="scripts/fullcalendar.js"></script>
</head>
<body>
	<header>
	<div id="globalHeader">
		<img src="images/Care-Attack-Logo-Transparent.png" id="careAttackIcon"
			alt="" />
		<h1 id="bannerTitle">Welcome to Care-Attack!</h1>
		<!--  Login code here -->
		<%
			if (session.getAttribute("username") == null) {
		%>
		<div id="login">
			<form name="login" method="POST" action="Login" id="login">
				<input type="text" placeholder="Username" name="username"
					id="username" /> <input type="password" placeholder="Password"
					name="password" id="password" /> <input type="submit"
					value="Log On" name="loginBtn" id="loginBtn" />
			</form>
		</div>
		<%
			} else {
		%>
		<div id="loggedIn">
			Welcome
			<%=session.getAttribute("username").toString()%>
			<%
				if (session.getAttribute("privilege").toString()
							.equalsIgnoreCase("admin")) {
			%>
			<a href="AdminControlPanel.jsp">Admin Control Panel</a>
			<%
				} else if (session.getAttribute("privilege").toString()
							.equalsIgnoreCase("user")) {
			%>
			<a href="UserControlPanel.jsp">User Control Panel</a>
			<%
				}
			%>
			<form action="Logout" method="POST" id="loggedout">
				<input type="submit" name="logout" id="logout" value="Log out" />
			</form>
		</div>
		<%
			}
		%>
		<nav class="gummyBar">
		<ul>
			<li class="green">
				<p>
					<a href="index.jsp">Home</a>
				</p>
				<p class="subtext">The front page</p>
			</li>
			<li class="yellow">
				<p>
					<a href="taskPlanner.jsp">Task Planner</a>
				</p>
				<p class="subtext">Visit the App</p>
			</li>
			<li class="red">
				<p>
					<a href="#">Meal Plans</a>
				</p>
				<p class="subtext">Find out what they can eat!</p>
			</li>
			<li class="blue">
				<p>
					<a href="MainBlogPage.jsp">Blog</a>
				</p>
				<p class="subtext">Read Personal Stories!</p>
			</li>
			<li class="purple">
				<p>
					<a href="IndividualProductPage.jsp">Rental Service</a>
				</p>
				<p class="subtext">Rent your products here!</p>
			</li>
		</ul>
		</nav>
	</div>
	</header>
</body>
</html>