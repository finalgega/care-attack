package servlets;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import announcements.Announcement;

import database.MySQLController;

/**
 * Servlet implementation class RetrieveAnnouncementServlet
 */
public class RetrieveAnnouncementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveAnnouncementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String referer = request.getHeader("referer");
		System.out.println("My Servlet Path :" + request.getServletPath());
		String strAnnonID = request.getParameter("annonID");
		Scanner sc = new Scanner(strAnnonID);
		int annonID = sc.nextInt();
		Announcement annon = new Announcement();
		annon = annon.retrieveAnnouncement(annonID);
		session.setAttribute("annonID", annon);
		response.sendRedirect(referer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
