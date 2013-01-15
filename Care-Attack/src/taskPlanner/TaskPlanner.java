package taskPlanner;

import java.util.ArrayList;

import com.sun.jmx.snmp.tasks.Task;

public class TaskPlanner {
	
	private String eventName;
	private int id;
	private String eventDescription;
    private boolean allDay;
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

}
