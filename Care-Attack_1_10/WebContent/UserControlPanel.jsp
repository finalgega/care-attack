<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<link href="styles/index.css" rel="stylesheet" />
<style>
content
{
width:auto;
}
</style>
<title>User Control Panel</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="content">
	<% if(session.getAttribute("username") != null)
	{
%>
	<%@ page import="login.*"%>
	<% User user = new User();
	String username = (String)session.getAttribute("username");
	System.out.println("Username gotten : " + username);
	User useInfo = new User();
	useInfo = user.getUserInfo(username);
	String password = "******************";
%>
	<h1>User Control Panel</h1>
	<table>
		<tr>
			<p>
				Username :
				<%= useInfo.getUsername() %></p>
		</tr>
		<tr>
			<td><p>
					Password :
					<%= password %></p></td>
			<td><input type="button" onclick="index.jsp"
				value="Change Password" />
		</tr>
		<tr>
			<td><p>
					Email Address :
					<%= useInfo.getEmail() %></p></td>
		</tr>
	</table>
	<% }else
	{
%>
	<h1>You are not authorized to view this page!</h1>
	<script type="text/javascript">
	var count = 6;
	var redirect="index.jsp";
	  
	function countDown(){  
	 if (count <=0){  
	  window.location = redirect;  
	 }else{  
	  count--;  
	  document.getElementById("timer").innerHTML = "This page will redirect in "+count+" seconds.";  
	  setTimeout("countDown()", 1000)  ;
	 }  
	}  
	</script>  
	<span id="timer"></span>
	<script type="text/javascript">countDown();</script>
	<%} %>
	</div>
</body>
</html>