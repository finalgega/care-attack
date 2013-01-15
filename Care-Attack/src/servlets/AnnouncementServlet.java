package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.MyCalendar;
import announcements.Announcement;

/**
 * Servlet implementation class for Servlet: AnnouncementServlet
 *
 */
 public class AnnouncementServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public AnnouncementServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String aTopic = request.getParameter("annon-topic");
		String aContent = request.getParameter("annon-content");
		System.out.println("Topic : " + aTopic);
		System.out.println("Content : " + aContent);
		String referer = request.getHeader("referer");
		try
		{
			Announcement annon = new Announcement();
			MyCalendar cal = new MyCalendar();
			String date = cal.getCurrentDate();
			boolean success = annon.createAnnouncement(aTopic, aContent, date);
			if(success)
			{
				session.setAttribute("aTopic", aTopic);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			getServletContext().getRequestDispatcher(referer).forward(request, response);
		}
	
	}   	  	    
}