function createCalendar(){
	$('#popCal').fadeOut();
	$('.taskMgr').css('background','#fff');
	
	    $('#calendar').fullCalendar({
	    	
//	    	  dayClick: function(date, allDay, jsEvent, view) {
//
//	    	        if (allDay) {
//	    	            alert('Clicked on the entire day: ' + date);
//	    	        }else{
//	    	            alert('Clicked on the slot: ' + date);
//	    	        }
//
//	    	        alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
//
//	    	        alert('Current view: ' + view.name);
//	    	    },
	        header: {
	            left: 'prev,next today',
	            center: 'title',
	            ignoreTimezone: false
	        },
	        selectable: true,
	        selectHelper: true,
	        editable: true,
	        events:'taskplanner',
	        defaultView: 'agendaDay',
	        defaultEventMinutes : 60
	    });
	    console.log("Current data in gsonObj : " + gsonObj);
		
	}