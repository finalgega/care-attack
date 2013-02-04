package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.BlogPost;
import blog.auntieSarah;


/**
 * Servlet implementation class CreateBlogPostServlet
 */
public class CreateBlogPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBlogPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String username = (String)session.getAttribute("username");
		System.out.println("title: " + title);
		System.out.println("content : " + content);
		System.out.println("username : " + username);
		try
		{
			BlogPost createblogpost  = new BlogPost();
			boolean success = createblogpost.createABlogPost(title, content,username);
			if(success){
			//response.getWriter().println("<script>alert('Congratulations, blog post created!! ')</script>");
			response.sendRedirect("MainBlogPage.jsp");
			}
			else{
				
				if (username == null){
					response.getWriter().println("<script>alert('try again. You are probably not logged in!! ')</script>");   
					RequestDispatcher rd = request.getRequestDispatcher
					        ("MainBlogPage.jsp");
					    rd.forward(request, response);
					}
				else{
				response.getWriter().println("<script>alert('Something went wrong! Might have connection problems ')</script>");
				}
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
