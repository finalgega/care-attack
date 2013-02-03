<jsp:include page="header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="announcements.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Announcement</title>
<link href="styles/layout.css" rel="stylesheet"/>
</head>
<body>
<div class="content">
<script>
function validate(){
$('#delAnnon').submit(function(event){
	if($('#annonID').val() == "")
		{
		alert('You have not selected a valid choice!');
	event.preventDefault();
		return false;
		}
	else
		{return true;}
	});
}
</script>
<form onsubmit="validate()" id="updateAnnon">
<table id="annonIDTbl" name="annonIDTbl">
<tr>
<td>Announcement ID : </td>
<td><select id="annonID" name="annonID">
<option value="" selected>Select an Announcement</option>
<% Announcement annon = new Announcement();
   ArrayList<Integer> annonList = new ArrayList<Integer>();
   annonList = annon.retrieveAnnouncementIDs();
   boolean success = false;
   for(int i=0; i < annonList.size(); i++)
   {
	   int annonID = annonList.get(i);
	   success = true;
%>
	<option value=<%= annonID %>><%= annonID %></option>
<% } %>
</select>
</td>
<td>
<input type="submit" formaction="RetrieveAnnouncementServlet" value="Retrieve Data"/>
</td>
</tr>
</table>
</form>
<table id="annonDetails">
<% if(session.getAttribute("annon") != null){ 
	annon = (Announcement)session.getAttribute("annon");
%>
<tr>
<td>Announcement Topic : 
</td>
<td>
	<input type="text" name="annonTopic" value="<%= annon.getaTopic() %>"/>
</td>
</tr>
<tr>
<td>Announcement Details : </td>
<td>
	<input type="text" name="annonContent" value="<%= annon.getaContent() %>"/>
</td>
</tr>
<% }else{} %>
<tr>
<td><input type="submit" value="Update Announcement" form="updateAnnon" formaction="UpdateAnnouncementServlet" formmethod="POST"></td>
</tr>
</table>
</div>
</body>
</html>