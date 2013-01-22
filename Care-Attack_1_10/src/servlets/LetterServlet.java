package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Products;
import entity.letters;

/**
 * Servlet implementation class LetterServlet
 */
public class LetterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LetterServlet() {
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
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		String referer = request.getHeader("referer");
		
		
		System.out.println("Name : " + name);
		System.out.println("Message : " + message);
		
		
		try
		{
			letters l = new letters();
			boolean success = l.createLetters(name, message);
			if(success)
			{
				session.setAttribute("name", name);
				//response.getWriter().println("<script>alert('Lettters Created Successfully!')</script>");
				response.sendRedirect(referer);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			System.out.println("End of doPost");
		}
	
	}
	  	    

}
