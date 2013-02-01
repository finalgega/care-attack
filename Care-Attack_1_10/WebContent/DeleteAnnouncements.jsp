<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,announcements.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Announcements</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div id="content">
<form>
<table>
<tr>
<td>Announcement ID : </td>
<td><select name="annonID">
<% Announcement annon = new Announcement();
   ArrayList<Integer> annonList = new ArrayList<Integer>();
   annonList = annon.retrieveAnnouncementIDs();
   boolean success = false;
   for(int i=0; i < annonList.size(); i++)
   {
	   int annonID = annonList.get(i);
	   success = true;
%>
	<option><%= annonID %></option>
<% } %>
</select>
</tr>
<% if(!success){ 
	String strAnnonID = request.getParameter("annonID");
	Scanner sc = new Scanner(strAnnonID);
	int annonID = sc.nextInt();
	annon.retrieveAnnouncement(annonID);
%>
<tr>
<td>Announcement Topic : 
</td>
<td>
	<%= annon.getaTopic()  %>
</td>
</tr>
<tr>
<td>Announcement Details : </td>
<td>
	<%= annon.getaContent() %>
</td>
</tr>
<% }else{} %>
<tr>
<td><input type="submit" value="Delete Announcement"></td>
</tr>
</table>
</form>
</div>
</body>
</html>