package servlets;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.MyCalendar;
import announcements.Announcement;

/**
 * Servlet implementation class UpdateAnnouncementServlet
 */
public class UpdateAnnouncementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAnnouncementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		MyCalendar myCal = new MyCalendar();
		int annonID = (Integer)session.getAttribute("annonID");
		String currentDate = myCal.getCurrentDate();
		String annonTopic = request.getParameter("annonTopic");
		System.out.println("Announcement Topic At UpdateAnnonServ... : " + annonTopic );
		String annonContent = request.getParameter("annonContent");
		System.out.println("Announcement Content at UAS : " + annonContent);
		Announcement annon = new Announcement();
		annon.updateAnnouncenet(annonID, annonTopic, annonContent, currentDate);
		response.sendRedirect("index.jsp");
	}

}
