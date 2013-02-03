package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.BlogPost;
import blog.Comment;

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
		HttpSession session = request.getSession(true);
		String blogid =(String)session.getAttribute("BlogID");
		String comment = request.getParameter("comment");
		String username = (String)session.getAttribute("username");
		String referer = request.getHeader("referer");
		System.out.println("blog id : " + blogid);
		System.out.println("comments: " + comment);
		System.out.println("username : " + username);
		try
		{
			Comment createblogpost  = new Comment();
			boolean success = createblogpost.createAComment(blogid,comment,username);
			if(success){
			//response.getWriter().println("<script>alert('Congratulations, comments created!! ')</script>");
			response.sendRedirect(referer);
			//request.getRequestDispatcher("MainBlogPage.jsp").forward(request, response);
			}
			else{
				
				if (username == null){
					//response.getWriter().println("<script>alert('try again. You are probably not logged in!! ')</script>");   
					//request.getRequestDispatcher("MainBlogPage.jsp").forward(request, response);
					response.sendRedirect(referer);
				}
				else{
				//response.getWriter().println("<script>alert('Something went wrong! Might have connection problems ')</script>");
				//request.getRequestDispatcher("MainBlogPage.jsp").forward(request, response);
					response.sendRedirect(referer);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String blogid =request.getParameter("blogid");
		String comment = request.getParameter("comments");
		String username = (String)session.getAttribute("username");
		String referer = request.getHeader("referer");
		System.out.println("blog id : " + blogid);
		System.out.println("comments: " + comment);
		System.out.println("username : " + username);
		try
		{
			Comment createblogpost  = new Comment();
			boolean success = createblogpost.createAComment(blogid,comment,username);
			if(success){
			//response.getWriter().println("<script>alert('Congratulations, comments created!! ')</script>");
			response.sendRedirect(referer);
			//request.getRequestDispatcher("MainBlogPage.jsp").forward(request, response);
			}
			else{
				
				if (username == null){
					//response.getWriter().println("<script>alert('try again. You are probably not logged in!! ')</script>");   
					//request.getRequestDispatcher("MainBlogPage.jsp").forward(request, response);
					response.sendRedirect(referer);
				}
				else{
				//response.getWriter().println("<script>alert('Something went wrong! Might have connection problems ')</script>");
				//request.getRequestDispatcher("MainBlogPage.jsp").forward(request, response);
					response.sendRedirect(referer);
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
