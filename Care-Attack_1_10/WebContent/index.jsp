<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" "/>
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Paprika" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Shadows Into Light Two" />
<title>Welcome to Care-Attack</title>
<link href="styles/index.css" rel="stylesheet" />
<link rel="stylesheet" href="styles/gratitude.css" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Paprika" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Shadows Into Light Two" />
<script src="scripts/jquery-1.8.2.js" type="text/javascript"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<script language="javascript">
		function clear() {
			$("#createLetters").prop('input')
		}

		function validateForm() {
			var name = document.forms["createLetters"]["name"].value;
			var message = document.forms["createLetters"]["message"].value;
			if (name == null || name == "") {
				alert("Please enter your name!");
				return false;
			}
			
			else if (message == null || message == "") {
				alert("Please enter your message!");
				return false;
			}
			
			else{
				alert("Message sent");
			}
		}
		
		function displayDate()
		{
		document.getElementById("nametext").innerHTML=Date();
		}
		
		function hideshow() {
		    var toggle = document.getElementById('boxer');
		    toggle.style.display = toggle.style.display == "block" ? "none" : "block";
		}

	</script>
		<div class="content">
			<%@ page import="announcements.*,entity.*,java.util.*"%>
			<%
			ArrayList<Announcement> announceArrList = new ArrayList<Announcement>();
			Announcement annon = new Announcement();
			announceArrList = annon.retrieveAnnouncement();
		%>

			<article>
				<h1>Announcements</h1>
				<%
				for (int i = announceArrList.size() - 1; i > 0; i--) {
					annon = announceArrList.get(i);
			%>

				<h2><%=annon.getaTopic()%></h2>
				<p>
					Posted on :
					<%=annon.getaDate()%></p>
				<p><%=annon.getaContent()%></p>
				<hr />
				<%
				}
			%>

			</article>
		</div>
		<div class="sideContent">
			<div class="auntSarahCorner">
				<aside>
					<h1>Auntie Sarah's Corner</h1>
					<h2>Tip Per Day</h2>
					<p>Some text here~</p>
				</aside>
			</div>
		<div id="lettersOfGratitude">

				<h1>Letters Of Gratitude</h1>

			
			<form id="createLetters" name="createLetters" method="post" action="LetterServlet" onSubmit="return validateForm()">
			<img src="images/heart.png" id="heart" />
			<div id="contain">
				<div id="name">
						Name<br /> <input type="text" name="name" height="10px" />
				</div>
				<br /> <br />

				<div id="text">
						Messages <br />
						<textarea name="message" id="message" cols="45" rows="5"></textarea>
						<br /> 
				</div>
				<div class="goButton"><input type="submit" value="SEND MESSAGE!" /></div>
			</div>
						
			</form>
			<br/>
			
				<div class="button" id="testclick1" onclick="hideshow()">

				<center><strong>CLICK HERE TO SHOW/HIDE MESSAGES!</strong></center>

		</div>
		
	
			<div id="boxer">


				<div id="appear">
					<%
						ArrayList<letters> l = new ArrayList<letters>();
						letters letter = new letters();
						l = letter.retrieveData();
					%>
					<%
						for (int i = l.size()-1; i > 0 ;i--) {
							letter = l.get(i);
					%>

					<div id="nametext">
							
							&nbsp; &nbsp; <div id="names"><h3><%=letter.getName()%></h3></div>
							&nbsp; &nbsp; <div id="texts"><p><%=letter.getMessage()%></p></div>
							<script><div id ="datedate">displayDate();</div></script>
					
					</div>

					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
</body>
</html>