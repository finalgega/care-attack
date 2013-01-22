<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CSS/Project.css">
<link rel="stylesheet" type="text/css" href="CSS/layout.css">
<title>Auntie Sarah</title>
</head>
<body>

	<header>
	<div id="globalHeader">
		<img src="images/Care-Attack-Logo-Transparent.png" id="careAttackIcon"
			alt="" />
		<h1>Welcome to Care-Attack!</h1>
		<nav id="globalNav">
		<table>
			<tr>
				<td><a href="Project/index.html">Home</a></td>
				<td><a href="taskPlanner.html">Task Planner</a></td>
				<td>Meals & Meal Plans</td>
				<td><a href="MainBlogPage.html">Blog</a></td>
				<td><a href="Rental Service.html">Rental Service</a></td>
				<td><input type="search"
					placeholder="Enter your search terms here" /></td>
			</tr>
		</table>
		</nav>
	</div>
	</header>


	<div id="layout">

		<center>
			<img src="images/AuntieSarah.png" />
		</center>

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
				<h2>Tip Per Day</h2>
			</div>

			Caregiving can trigger a host of difficult emotions, including anger,
			fear, resentment, guilt, helplessness, and grief. It's important to
			acknowledge and accept what you're feeling, both good and bad. Don't
			beat yourself up over your doubts and misgivings. These feelings
			don't mean that you don't love your family member–they simply mean
			you're human.

		</div>



		<div id="questionsession">

			<div id="heading">
				<h2>Monthly Sessions</h2>
			</div>

			<div id="questions">

				<%@ page import="blog.*,java.util.*"%>

				<%
							ArrayList<auntieSarah> monthlySessions = new ArrayList<auntieSarah>();
							auntieSarah createMonthlySessions = new auntieSarah();
						monthlySessions = createMonthlySessions.retrieveQuestion();
						%>


				<article>
				<h1>Categories</h1>
			</div>

			<%
							 for (int i = 0; i < monthlySessions.size(); i++) {
								 createMonthlySessions = monthlySessions.get(i);
							%>

			<p>
				<a href="#"><%=createMonthlySessions.getTopic()%></a> <a href="#"><%=createMonthlySessions.getSubject()%></a>
				<a href="#"><%=createMonthlySessions.getQuestion()%></a>

			</p>

			<div id="datesetting">
				<p><%=createMonthlySessions.getDate()%>
					by &nbsp; <a href="#"><%=createMonthlySessions.getUsername()%></a>
				</p>
			</div>
			<% } %>


			</article>

		</div>

	</div>

	</div>


</body>
</html>