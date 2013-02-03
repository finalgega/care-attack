function createCalendar(){
	$('#popCal').fadeOut();
	$('#getTasks').fadeIn();
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
	}
function validate()
{
	var illness = $('#illness').val();
	if(illness == "")
		{
		notify();
		return false;
		}
	else
		{
		$('#getTasks').fadeOut();
		return true;
		}
}

function notify()
{
	var notice = '<div class="notice">'
					  + '<div class="notice-body">' 
						  + '<img src="/images/excla-04.gif" alt="" />'
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
};
