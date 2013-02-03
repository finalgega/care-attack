package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Products;
import entity.Rental;

import blog.BlogPost;
import blog.Comment;

/**
 * Servlet implementation class retrieveArchivePostServlet
 */
public class RetrieveArchivePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrieveArchivePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String categories = request.getParameter("categoriesDDL");
		System.out.println("Categories :  " + categories);
		String referer = request.getHeader("referer");
		System.out.println("Referer! : " + referer);
		try{
			BlogPost cate = new BlogPost();
			ArrayList<BlogPost> success = cate.retrievePostTitle(categories);
			if (success !=null){
				session.setAttribute("BlogID", cate.getBlogid());
				session.setAttribute("Title", categories);
				session.setAttribute("Content", cate.getContent());
				session.setAttribute("BlogUsername", cate.getBlogUsername());
				session.setAttribute("Dated", cate.getDate());
				session.setAttribute("AccUsernameContent", cate.getAccUsernameComment());
			}else
			{
				System.out.println("----");
			}
		
				}
			
				catch (Exception e){
					e.printStackTrace();
				}
				
				finally
				{
					System.out.println("End of doGet");
					response.sendRedirect(referer);
				}
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
		String archiveDate = request.getParameter("archiveDate");
		try
		{
			Comment searchPost  = new Comment();
			ArrayList<Comment> success = searchPost.searchPost(archiveDate);
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
