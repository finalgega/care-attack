package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.MyCalendar;
import announcements.Announcement;

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
	/*	HttpSession session = request.getSession();
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String productName = request.getParameter("productName");
		String productDescription = request.getParameter("productDescription");
		String status = request.getParameter("status");
		int price = Integer.parseInt(request.getParameter("price")); 
		String referer = request.getHeader("referer");
		System.out.println("Quantity : " + quantity);
		System.out.println("Name : " + productName);
		System.out.println("Description : " + productDescription);
		System.out.println("Status : " + status);
		System.out.println("$" + price);
		
		
		try
		{
			Products p = new Products();
			boolean success = p.createProducts(quantity, productName, productDescription, status, price);
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
		}	*/
		try{
			UploadImage ui = new UploadImage();
			ArrayList<String> dataValues = new ArrayList<String>();
			dataValues = ui.processFileForm(request);
			if(dataValues != null)
			{
				System.out.println("In if(ui.processFileForm(request)!");
				System.out.println("datavalues size : " + dataValues.size() );
				response.getWriter().println("<script>alert('Sucess at file upload! And Back to AnnouncementServlet!');</script>");
				String productName = dataValues.get(0).toString();
				String productDescription = dataValues.get(1).toString();
				String strPrice = dataValues.get(2).toString();
				Scanner sc = new Scanner(strPrice);
				int productPrice = sc.nextInt();
				String strQuantity = dataValues.get(3).toString();
				sc = new Scanner(strQuantity);
				int productQuantity = sc.nextInt();
				String status = dataValues.get(4).toString();
				int imageID = ui.getImgID();
				System.out.println("Name : " + productName);
				System.out.println("Product Description : " + productDescription);
				System.out.println("Product Price : " + productPrice);
				System.out.println("Product Quantity : " + productQuantity);
				System.out.println("Product Status  : " + status);
				System.out.println("Product Image ID : " + imageID);
				try
				{
					Products prod = new Products();
					boolean success = prod.createProducts(productQuantity, productName, productDescription, status, productPrice, imageID);
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