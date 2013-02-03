<jsp:include page="header.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,announcements.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Announcements</title>
<link href="styles/layout.css" rel="stylesheet"/>
</head>
<body>
<div class="content">
<script language="JavaScript">
function notify()
		{
			var notice = '<div class="notice">'
							  + '<div class="notice-body">' 
								  + '<img src="/Images/excla-04.gif" alt="" />'
								  + '<h3>Invalid Choice!</h3>'
								  + '<p>No data can be retrieved. Please select a valid choice!</p>'
							  + '</div>'
							  + '<div class="notice-bottom">'
							  + '</div>'
						  + '</div>';
						  
					$( notice ).purr(
						{
							usingTransparentPNG: true
						}
					);
					
					return false;
		};

function validate(){
	var annonID = $('#annonID').val();
	if(annonID == null || annonID == "")
		{
		notify();
		return false;
		}
	else
		{return true;}
	};
</script>
<form onsubmit="return validate()" id="delAnnon">
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
	<%= annon.getaTopic()  %>
</td>
</tr>
<tr>
<td>Announcement Details : </td>
<td>
	<%= annon.getaContent() %>
</td>
</tr>

<tr>
<td><input type="submit" value="Delete Announcement" form="delAnnon" formaction="DeleteAnnouncementServlet" formmethod="POST"></td>
</tr>
</table>
<% }else{} %>
</div>
</body>
</html>