package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import blog.BlogPost;
import blog.Comment;

/**
 * Servlet implementation class searchEngineServlet
 */
public class searchEngineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchEngineServlet() {
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
		if(session.getAttribute("searchResult") != null)
		{
			session.removeAttribute("searchResult");
		}
		String referer = request.getHeader("referer");
		System.out.println("In doPost");
		String words = request.getParameter("searchName");
		try
		{
			Comment searchPost  = new Comment();
			ArrayList<Comment> success = searchPost.searchPost(words);
			System.out.println("success size : " + success.size());
			for(int i=0; i<success.size();i++)
			{
				searchPost = success.get(i);
				System.out.println("Search Result :" + searchPost.getBlogid() + "   " + searchPost.getTitle() + "   " + searchPost.getBlogContent() + "   " + searchPost.getBlogUsername() +  "   " + searchPost.getDate() + "   "  + searchPost.getAccUsernameComment());
			}
			session.setAttribute("searchResult", success);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		response.sendRedirect(referer);
	}

}
