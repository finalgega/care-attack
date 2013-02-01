function createCalendar(){
//		$.get('taskplanner',function(gsonObj)
//		{
//		alert("gsonObj : " + gsonObj);
//		var obj = $.parseJSON(gsonObj);
//		for(var i = 0;i<obj.length;i++)
//			{
//		alert("title of event : " + obj[i].title);
//			}
	    $('#calendar').fullCalendar({
	    	
	    	  dayClick: function(date, allDay, jsEvent, view) {

	    	        if (allDay) {
	    	            alert('Clicked on the entire day: ' + date);
	    	        }else{
	    	            alert('Clicked on the slot: ' + date);
	    	        }

	    	        alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);

	    	        alert('Current view: ' + view.name);

	    	     //    change the day's background color just for fun
//	    	        $(this).css('background-color', 'red');

	    	    },
	        header: {
	            left: 'prev,next today',
	            center: 'title',
	            ignoreTimezone: false
	        },
	        selectable: true,
	        selectHelper: true,
	        editable: false,
	        events:'taskplanner',
	        defaultView: 'agendaDay',
	        defaultEventMinutes : 60
	    });
	    console.log("Current data in gsonObj : " + gsonObj);

//		});
		
	}
function callServlet()
	    {
	    $.get('taskplanner',function(data){
	    alert(data);
	    });
	    }