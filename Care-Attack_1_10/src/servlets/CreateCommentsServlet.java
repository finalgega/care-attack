package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.BlogPost;

/**
 * Servlet implementation class CreateCommentsServlet
 */
public class CreateCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCommentsServlet() {
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
		String comments = request.getParameter("comments");
		String username = (String)session.getAttribute("username");
		System.out.println("title: " + comments);
		System.out.println("username : " + username);
		try
		{
			BlogPost createblogpost  = new BlogPost();
			boolean success = createblogpost.createABlogPost(comments,username);
			if(success){
			//response.getWriter().println("<script>alert('Congratulations, blog post created!! ')</script>");
			response.sendRedirect("MainBlogPage.jsp");
			}
			else{
				
				if (username == null){
					//response.getWriter().println("<script>alert('try again. You are probably not logged in!! ')</script>");
					response.getWriter().println("<script>alert('try again. You are probably not logged in!! ')</script>");   
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
