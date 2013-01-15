package servlets;

import java.io.IOException;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.User;

/**
 * Servlet implementation class for Servlet: Login
 *
 */
 public class Login extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public Login() {
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
		HttpSession session = request.getSession(true);
		String id = request.getParameter("username");
		String pwd = request.getParameter("password");
		String referer = request.getHeader("referer");
		try
		{
			//	Instantiate DB controller instance
			boolean status = false;
			User user = new User();
			String privilege;
			status = user.isExist(id, pwd);
			System.out.println("username = " + id);
			System.out.println("password = " + pwd);
			if(status)
			{
				session.setAttribute("username", id);
				privilege = user.getPrivilegeLevel(id);
				session.setAttribute("privilege", privilege);
				System.out.println("Privilege level : " + privilege);
				System.out.println("Success!");
				response.sendRedirect(referer);
			}
			else
			{
				System.out.println("Failure!");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}   	  	    
}