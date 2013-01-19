<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link href="styles/index.css" rel="stylesheet" />
<title>User Control Panel</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<% if(session.getAttribute("username") != null)
	{
%>
	<%@ page import="login.*"%>
	<% User user = new User();
	String username = session.getAttribute("username").toString();
	user.getUserInfo(username);
	String password = "******************";
%>
	<h1>User Control Panel</h1>
	<table>
		<tr>
			<p>
				Username :
				<%= user.getUsername() %></p>
		</tr>
		<tr>
			<td><p>
					Password :
					<%= password %></p></td>
			<td><input type="button" action="index.jsp"
				value="Change Password" />
		</tr>
		<tr>
			<td><p>
					Email Address :
					<%= user.getEmail() %></p></td>
		</tr>
	</table>
	<% }else
	{
%>
	<h1>You are not authorized to view this page!</h1>
	<p>Redirecting you in 5 seconds</p>
	<%} %>
</body>
</html>