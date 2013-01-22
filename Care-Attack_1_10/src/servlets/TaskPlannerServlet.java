package servlets;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		MyCalendar mCal = new MyCalendar();
		String data = mCal.getCurrentTime();
		Gson gson = new Gson();
		ArrayList<Object> tasks =  new ArrayList<Object>();
		TaskPlanner t = new TaskPlanner();
		t.setAllDay(false);
		Time time = new Time(220031);
		t.setEventName("Bash Test");
		t.setStartTime(time);
		tasks.add(t);
		gson.toJson(tasks);
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(data);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
