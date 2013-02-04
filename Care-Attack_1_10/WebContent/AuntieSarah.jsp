<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="styles/Project.css">
<link rel="stylesheet" type="text/css" href="styles/layout.css">
<script type="text/javascript" src="scripts/jquery-1.8.2.js"></script>
<script type="text/javascript" src="scripts/tinyboxupdated.js"></script>
<title>Auntie Sarah</title>
</head>

<body>

<script type="text/javascript">
function show ()
{TINY.box.show('CreateQuestions.jsp',1,400,320,1)}

</script>

	<jsp:include page="header.jsp"></jsp:include>

	<center> <img src="images/AuntieSarah.png" /> </center>

	<div id="layout">
		<div id="label">
			<p>Care Giving Tips &amp; Help</p>
		</div>

		<div id="image">
			<img src="images/CareGiving.jpg" width="350" height="200" />
		</div>

		<div id="introduction">
			<div id="heading">
				<h2>Introduction</h2>
			</div>
			<p>As a family caregiver, you may find yourself facing a host of
				new responsibilities, many of which are unfamiliar or intimidating.
				At times, you may feel overwhelmed and alone. But despite its
				challenges, caregiving can also be rewarding. And there are a lot of
				things you can do to make the caregiving process easier for both you
				and your loved one.</p>
		</div>

		<br />

		<div id="tipperday">
			<div id="heading">
				<%@ page import="blog.*,java.util.*"%>
				<%
					ArrayList<auntieSarah> TipPerDay = new ArrayList<auntieSarah>();
					auntieSarah retrieveTipPerDay = new auntieSarah();
					TipPerDay = retrieveTipPerDay.retrieveTipPerDay();
				%>
				<article>
				<h1>Tip Per Day</h1>
			</div>

			<%
				for (int i = 0; i < TipPerDay.size(); i++) {
					retrieveTipPerDay = TipPerDay.get(i);
			%>
			<p><%=retrieveTipPerDay.getTipperday()%></p>
			<%
				}
			%>
				</article>
		</div>


		<div id="questionsession">
				<div id="heading">
					<%@ page import="blog.*,java.util.*"%>
					<%
						ArrayList<auntieSarah> monthlySessions = new ArrayList<auntieSarah>();
						auntieSarah createMonthlySessions = new auntieSarah();
						monthlySessions = createMonthlySessions.retrieveQuestion();
					%>
					<article>
					<h2>Monthly Sessions</h2>
					<img src="images/buttonQuestion.png" onclick="show()"  width="150" height="50"	/>	
				</div>

				<%
					for (int i = 0; i < monthlySessions.size(); i++) {
						createMonthlySessions = monthlySessions.get(i);
				%>

				<p>
					<h3>Topic: <%=createMonthlySessions.getTopic()%></h3>
					<p>Subject:<%=createMonthlySessions.getSubject()%></p>
					<p>Question:<%=createMonthlySessions.getQuestion()%></p>
				</p>

				<div id="datesetting">
					<p><%=createMonthlySessions.getDate()%>
					by &nbsp; <a href="#"><%=createMonthlySessions.getUsername()%></a> </p>
					<br>
				</div>
				<%
					}
				%>
				</article>

			</div>

	</div>
</body>
</html>