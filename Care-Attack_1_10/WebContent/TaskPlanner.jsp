	<jsp:include page="header.jsp"></jsp:include>
<%@ page contentType="text/html; charset=UTF-8" language="java"
	import="java.sql.*,java.util.*,illness.*" errorPage=""%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Planner v2.0</title>
<script src="scripts/jquery-1.8.2.js"></script>
<script src="scripts/jquery-ui-1.9.1.custom.js"></script>
<script src="scripts/fullcalendar.js"></script>
<script src="scripts/taskPlanner.js"></script>
<script type="text/javascript" src="scripts/purr-notifications.js"></script>
<link href="styles/taskPlanner.css" rel="stylesheet" />
<link href="styles/jquery-ui-1.9.1.custom.css" rel="stylesheet" />
<link href="styles/fullcalendar.css" rel="stylesheet" />
<link href="styles/notifications.css" rel="stylesheet"/>
</head>
<body>
	<div class="content">
	<div class="taskMgr">
		<button id="popCal" onclick="createCalendar()">Populate Calendar!</button>
		<% ArrayList<Illness> listOfIllness = new ArrayList<Illness>();
		Illness ill = new Illness();
		listOfIllness = ill.retrieveListOfIllness();
		%>
		<form name="populateCalendar" id="getTasks" method="GET" action="TaskPlannerServlet">
		<select name="illness" id="illness">
		<option value="">Select an illness</option>
		<% for(int i = 0; i < listOfIllness.size();i++)
			{ Illness illness = listOfIllness.get(i);%>
		<option value="<%=illness.getIllnessName()%>"><%= illness.getIllnessName() %></option>
		<% } %>
		</select>
		<input type="submit" value="Get Tasks!" formaction="MedicineServlet" onclick="return validate()" formmethod="GET">
		</form>
		<div id="calendar"></div>
		<div id="eventDialog" class="dialog ui-helper-hidden">
			<form>
				<div>
					<label>Title:</label> <input id="title" class="field" type="text" />
				</div>
				<div>
					<label>Color:</label> <input id="color" class="field" type="text" />
				</div>
			</form>
		</div>
		<!--  
		To include fallback content, AJAX scripts, JSON objs, googlecalendar integration,
		event creations,etc
	 -->
	</div>
	</div>



</body>
</html>