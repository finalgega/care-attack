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
				session.setAttribute("productQuantity", p.getProductQuantity());
				session.setAttribute("status", p.getStatus());
				session.setAttribute("price", p.getPrice());
			
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
		int phone = Integer.parseInt(request.getParameter("phone"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String referer = request.getHeader("referer");
		
		System.out.println("Name : " + name);
		System.out.println("NRIC : " + nric);
		System.out.println("Rental Name : " + rentalName);
		System.out.println("Quantity : " + rentalQuantity);
		System.out.println("Start Date : " + startDate);
		System.out.println("End Date : " + endDate);

		int productQuantity = (Integer) session.getAttribute("productQuantity");
		
		productQuantity = productQuantity - rentalQuantity;
		System.out.println(productQuantity);
		
		Products p = new Products();
		int price = (Integer)session.getAttribute("price");
		int totalPrice = price * rentalQuantity;
		System.out.println(totalPrice);
		
		
		Rental r = new Rental();
		r.retrieveRental(nric);
		session.setAttribute("name", name);
		session.setAttribute("nric", nric);
		session.setAttribute("phone", phone);
		session.setAttribute("rentalQuantity", rentalQuantity);
		session.setAttribute("startDate", startDate);
		session.setAttribute("endDate", endDate);
		session.setAttribute("totalPrice", totalPrice);
		
		try
		{
			Rental rent = new Rental();
			boolean success = rent.createRental(name, nric, phone, rentalName, rentalQuantity, startDate, endDate, totalPrice);
			if(success)
			{
				session.setAttribute("rentalName", rentalName);
				response.sendRedirect("ViewRentDetails.jsp");
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
