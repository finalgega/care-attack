package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.BlogPost;


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
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		System.out.println("title: " + title);
		System.out.println("content : " + content);
		try
		{
			BlogPost createblogpost  = new BlogPost();
			boolean success = createblogpost.createABlogPost(title, content);
			if(success)
			response.getWriter().println("Creation Success");
			else{
				response.getWriter().println("<script>alert('Something went wrong! ')</script>");
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
