<%@ page contentType="text/html; charset=UTF-8" language="java"
	import="java.sql.*" errorPage=""%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Planner v2.0</title>
<script src="scripts/jquery-1.8.2.js"></script>
<script src="scripts/jquery-ui-1.9.1.custom.js"></script>
<script src="scripts/fullcalendar.js"></script>
<!-- <script src="scripts/taskApplication.js"></script> -->
<link href="styles/layout.css" rel="stylesheet" />
<link href="styles/taskPlanner.css" rel="stylesheet" />
<link href="styles/jquery-ui-1.9.1.custom.css" rel="stylesheet" />
<link href="styles/fullcalendar.css" rel="stylesheet" />
	<script>
	$(function(){
	    $('#calendar').fullCalendar({
	        header: {
	            left: 'prev,next today',
	            center: 'title',
	            right: 'month,basicWeek,basicDay',
	            ignoreTimezone: false
	        },
	        selectable: true,
	        selectHelper: true,
	        editable: true,
	        events: 'events'
	    });
	});
	</script>
    <script>
    function callServlet(e)
    {
    $.get('taskplanner',function(data){
    alert(data);
    document.getElementById('test').value = data;
    });
    }
    </script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
    <button onclick="callServlet()">Click Me!</button>
    <input type="text" id="test"/>
	<div class="taskMgr">
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

</body>
</html>