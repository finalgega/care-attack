<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Administrator Control Panel</title>
<link href="styles/index.css" rel="stylesheet">

</head>
<body>
<% System.out.println("What is my privilege level? " + (String)session.getAttribute("privilege"));
if(((String)session.getAttribute("privilege") == "admin") || (session.getAttribute("username") != null))
	{%>
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
	<%
	}else
	{
	%>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="content">
		<h1>Administrator Control Panel</h1>
		<p>Test area</p>
		<a href="CreateAnnouncements.jsp">Create Announcements</a> <a
			href="CreateBlogPost.jsp">Create Blog Post</a> 
			<a href="createProducts.jsp">Create Products</a> 
			<a href="CreateQuestions.jsp">Create Questions</a> 
			<a href="CreateMedicine.jsp">Create Medicine</a> 
			<a href="CreateIllness.jsp">Create Illness</a>
	</div>
	<%} %>
</body>
</html>