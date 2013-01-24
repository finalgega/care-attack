package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
		try{
		UploadImage ui = new UploadImage();
		ArrayList<String> dataValues = new ArrayList<String>();
		dataValues = ui.processFileForm(request);
		if(dataValues!= null)
		{
			System.out.println("In if(ui.processFileForm(request)!");
			System.out.println("datavalues size : " + dataValues.size() );
			response.getWriter().println("<script>alert('Sucess at file upload! And Back to AnnouncementServlet!');</script>");
			String aTopic = dataValues.get(0).toString();
			String aContent = dataValues.get(1).toString();
			System.out.println("Topic : " + aTopic);
			System.out.println("Content : " + aContent);
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
			}catch(SQLException sqlErr)
			{
				System.out.println("Something went wrong on the SQL side. Please take a look");
				sqlErr.printStackTrace();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("In else ui.processFileForm failed! ");
			response.getWriter().println("<script>alert('Trial failedd to work =( !')</script>");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	
	}   	  	    
}