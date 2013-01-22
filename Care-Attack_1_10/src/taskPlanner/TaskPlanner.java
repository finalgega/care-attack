package taskPlanner;

import java.sql.Time;
import java.util.ArrayList;

import medicine.Medicine;

import com.sun.jmx.snmp.tasks.Task;

public class TaskPlanner extends Medicine {
	
	private String eventName;
	private int id;
	private String eventDescription;
    private boolean allDay;
    private Time startTime;
    private int duration;
    private Medicine med;
	public TaskPlanner()
	{}
	
	public TaskPlanner(ArrayList<Task> task)
	{
	}
	
	public TaskPlanner(String eventName)
	{
		this.eventName = eventName;
	}
    
    /**
     *  need to figure out how to implement the 'date start portion'
     **/
    public TaskPlanner(int id, String title, boolean allDay)
    {
        this.id = id;
        this.eventName = title;
        this.allDay = allDay;
    }
    
    public TaskPlanner(int id, String title,boolean allDay, Time startTime, int duration )
    {
    	this.id= id;
    	this.eventName = title;
    	this.allDay = allDay;
    	this.startTime = startTime;
    	this.duration = duration;
    }
    public TaskPlanner(int id, String title,String eventDescription,boolean allDay, Time startTime, int duration )
    {
    	this.id= id;
    	this.eventName = title;
    	this.allDay = allDay;
    	this.startTime = startTime;
    	this.duration = duration;
    	this.eventDescription = eventDescription;
    }
    
    public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Medicine getMed() {
		return med;
	}

	public void setMed(Medicine med) {
		this.med = med;
	}

	public ArrayList<TaskPlanner> retrieveTasks(String medication)
    {
    	ArrayList<TaskPlanner> tasks = new ArrayList<TaskPlanner>();
    	med.getTimesperDay();
    	
    	return null;
    }
  

}
