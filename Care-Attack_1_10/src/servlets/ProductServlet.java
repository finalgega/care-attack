package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Products;

/**
 * Servlet implementation class for Servlet: ProductServlet
 *
 */
 public class ProductServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
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
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String productName = request.getParameter("productName");
		String productDescription = request.getParameter("productDescription");
		String status = request.getParameter("status");
		String referer = request.getHeader("referer");
		System.out.println("Quantity : " + quantity);
		System.out.println("Name : " + productName);
		System.out.println("Description : " + productDescription);
		System.out.println("Status : " + status);
		
		try
		{
			Products p = new Products();
			boolean success = p.createProducts(quantity, productName, productDescription, status);
			if(success)
			{
				session.setAttribute("productName", productName);
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