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
	function createCalendar(e){
	    $('#calendar').fullCalendar({
	    	  dayClick: function(date, allDay, jsEvent, view) {

	    	        if (allDay) {
	    	            alert('Clicked on the entire day: ' + date);
	    	        }else{
	    	            alert('Clicked on the slot: ' + date);
	    	        }

	    	        alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);

	    	        alert('Current view: ' + view.name);

	    	        // change the day's background color just for fun
	    	   //     $(this).css('background-color', 'red');

	    	    },
	        header: {
	            left: 'prev,next today',
	            center: 'title',
	            ignoreTimezone: false
	        },
	        selectable: true,
	        selectHelper: true,
	        editable: false,
	        events: [{
	            title: 'Inject insulin',
	            start: '2013-01-22 13:00:00 GMT +0800',
	            end: '2013-01-22 14:00:00 GMT +0800'
	            
	        },
	        {
	            title: 'Event2',
	            start: '2013-01-23 12:30:00'
	        }
	        ],
	        defaultView: 'agendaDay',
	        defaultEventMinutes : 60
	    });
	};
	   function callServlet(e)
	    {
	    $.get('taskplanner',function(data){
	    alert(data);
	    });
	    }
	</script>
</head>
<body>
	<!-- 	<jsp:include page="header.jsp"></jsp:include> -->
	<button onclick="callServlet()">Click Me!</button>
	<button onclick="createCalendar()">Populate Calendar!</button>
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