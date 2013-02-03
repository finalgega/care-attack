package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import medicine.Medicine;
import taskPlanner.TaskPlanner;
import util.MyCalendar;

import com.google.gson.Gson;

/**
 * Servlet implementation class TaskPlannerServlet
 */
public class TaskPlannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskPlannerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Gson gson = new Gson();
		ArrayList<TaskPlanner> tasks = new ArrayList<TaskPlanner>();
		Medicine med = new Medicine();
		String illnessName = (String)session.getAttribute("illnessName");
		med = med.retrieveMedicine(illnessName);
		int timesPerDay = med.getTimesperDay();
		System.out.println("Times Per Day : " + timesPerDay);
		String instructions = "Feed " + med.getMedicineName();
		System.out.println("Instructions  : " + instructions);
		switch(timesPerDay)
		{
		case 1:
		{
			TaskPlanner t = new TaskPlanner(1,instructions,false,"2013-02-04T14:00Z");
			tasks.add(t);
			break;
		}
		case 2:
		{
			TaskPlanner t = new TaskPlanner(1,instructions,false,"2013-02-04T09:00Z");
			TaskPlanner t1 = new TaskPlanner(1,instructions,false,"2013-02-04T18:00Z");
			tasks.add(t);
			tasks.add(t1);
			break;
		}
		case 3:
		{
			TaskPlanner t = new TaskPlanner(1,instructions,false,"2013-02-04T09:00Z");
			TaskPlanner t1 = new TaskPlanner(1,instructions,false,"2013-02-04T13:00Z");
			TaskPlanner t2 = new TaskPlanner(1,instructions,false,"2013-02-04T18:00Z");
			tasks.add(t);
			tasks.add(t1);
			tasks.add(t2);
			break;
		}
		}
		String json = gson.toJson(tasks);
		session.setAttribute("gsonObj", json);
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Gson gson = new Gson();
		MyCalendar mc = new MyCalendar();
		ArrayList<TaskPlanner> tasks = new ArrayList<TaskPlanner>();
		TaskPlanner t = new TaskPlanner(1,"Feed Insulin",false,mc.getCurrentTime());
		TaskPlanner t1 = new TaskPlanner(1,"Feed Insulin",false,"2013-02-01T14:00Z");
		TaskPlanner t3 = new TaskPlanner(2 ,"Calendar TEst!",false,"2013-02-01T17:45Z");
		TaskPlanner t2 = new TaskPlanner(3,"YAY",false,"2013-02-02T14:00Z");
		tasks.add(t);
		tasks.add(t1);
		tasks.add(t2);
		tasks.add(t3);
		String json = gson.toJson(tasks);
		System.out.println("JSON : " + json);
		session.setAttribute("gsonObj", json);
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

}
