package taskPlanner;

import java.util.ArrayList;

import com.sun.jmx.snmp.tasks.Task;

public class TaskPlanner{
	
	private String title;
	//private int id;
	//private String eventDescription;
    private boolean allDay;
    private String start;
   // private int duration;
	public TaskPlanner()
	{}
	
//	public TaskPlanner(ArrayList<Task> task)
//	{
//	}
	
	public TaskPlanner(String title)
	{
		this.title = title;
		System.out.println("TaskPlanner(String title)");
	}
	
	public TaskPlanner(String title,boolean allDay, String start)
	{
		this.title = title;
		this.allDay = allDay;
		this.start = start;
		System.out.println("We're in TaskPlanner(String title,boolean allDay,String start)");
	}
    
    /**
     *  need to figure out how to implement the 'date start portion'
     **/
//    public TaskPlanner(int id, String title, boolean allDay)
//    {
//        this.id = id;
//        this.title = title;
//        this.allDay = allDay;
//		System.out.println("We're in TaskPlanner(int id,String title,boolean allDay)");
//    }  
//    public TaskPlanner(int id, String title,boolean allDay, String start, int duration )
//    {
//    	this.id= id;
//    	this.title = title;
//    	this.allDay = allDay;
//    	this.start = start;
//    	this.duration = duration;
//		System.out.println("We're in TaskPlanner(int id,String title,boolean allDay,String start,int duration)");
//    }
//    public TaskPlanner(int id, String title,String eventDescription,boolean allDay, String start, int duration )
//    {
//    	this.id= id;
//    	this.title = title;
//    	this.allDay = allDay;
//    	this.start = start;
//    	this.duration = duration;
//    	this.eventDescription = eventDescription;
//		System.out.println("We're in TaskPlanner(int id,String title, String eventDescription, boolean allDay,String start, int duration)");
//    }
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getEventDescription() {
//		return eventDescription;
//	}
//
//	public void setEventDescription(String eventDescription) {
//		this.eventDescription = eventDescription;
//	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

//	public int getDuration() {
//		return duration;
//	}
//
//	public void setDuration(int duration) {
//		this.duration = duration;
//	}

	public ArrayList<TaskPlanner> retrieveTasks(String medication)
    {
    	ArrayList<TaskPlanner> tasks = new ArrayList<TaskPlanner>();
    	
    	return null;
    }
  

}
