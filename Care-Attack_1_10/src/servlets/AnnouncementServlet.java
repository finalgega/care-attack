package servlets;

import java.io.File;
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
		File folder = new File(getServletContext().getRealPath("/"));
		 File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		    }

		HttpSession session = request.getSession(true);
		try{
			System.out.println("Path of announcementServlet : " + getServletContext().getRealPath("/"));
		UploadImage ui = new UploadImage();
		ArrayList<String> dataValues = new ArrayList<String>();
		dataValues = ui.processFileForm(request);
		if(dataValues!= null)
		{
			System.out.println("In if(ui.processFileForm(request)!");
			System.out.println("datavalues size : " + dataValues.size() );
			String aTopic = dataValues.get(0).toString();
			String aContent = dataValues.get(1).toString();
			int imageID = ui.getImgID();
			System.out.println("Topic : " + aTopic);
			System.out.println("Content : " + aContent);
			try
			{
				Announcement annon = new Announcement();
				MyCalendar cal = new MyCalendar();
				String date = cal.getCurrentDate();
				System.out.println("Current Date : " + date);
				boolean success = annon.createAnnouncement(aTopic, aContent, date,imageID);
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