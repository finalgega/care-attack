package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Products;
import entity.Rental;

/**
 * Servlet implementation class RentalServlet
 */
public class RentalServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String productName = request.getParameter("list");
		System.out.println("Product Name :  " + productName);
		String referer = request.getHeader("referer");
		System.out.println("Referer! : " + referer);
		try{
			Rental rent = new Rental();
			Products p = rent.retrieveProduct(productName);
			if (p !=null){
				session.setAttribute("productName", productName);
				session.setAttribute("productDescription", p.getProductDescription());
				session.setAttribute("productQuantity", p.getQuantity());
				session.setAttribute("status", p.getStatus());
			
			}else
			{
				System.out.println("NOthing returned in rent.retrieveProduct");
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
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String nric = request.getParameter("nric");
		String rentalName = session.getAttribute("productName").toString();
		int rentalQuantity = Integer.parseInt(request.getParameter("rentalQuantity"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String referer = request.getHeader("referer");
		System.out.println("Name : " + name);
		System.out.println("NRIC : " + nric);
		System.out.println("Rental Name : " + rentalName);
		System.out.println("Quantity : " + rentalQuantity);
		System.out.println("Start Date : " + startDate);
		System.out.println("End Date : " + endDate);

		try
		{
			Rental rent = new Rental();
			boolean success = rent.createRental(name, nric, rentalName, rentalQuantity, startDate, endDate);
			if(success)
			{
				session.setAttribute("rentalName", rentalName);
				response.sendRedirect(referer);
			}
			//response.getWriter().println("Product Created Successfully!");
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
