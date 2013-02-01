package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		MyCalendar mc = new MyCalendar();
		ArrayList<TaskPlanner> tasks = new ArrayList<TaskPlanner>();
		TaskPlanner t = new TaskPlanner("Bash Test",false,mc.getCurrentTime());
		TaskPlanner t1 = new TaskPlanner("Sad life",false,"2013-02-01T14:00Z");
		TaskPlanner t3 = new TaskPlanner("Calendar TEst!",false,"2013-02-01T17:45Z");
		TaskPlanner t2 = new TaskPlanner("YAY",false,"2013-02-02T14:00Z");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
