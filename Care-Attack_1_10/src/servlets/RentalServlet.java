package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String rentalName = request.getParameter("rentalName");
		int rentalQuantity = Integer.parseInt(request.getParameter("rentalQuantity"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String referer = request.getHeader("referer");
		System.out.println("Name : " + rentalName);
		System.out.println("Quantity : " + rentalQuantity);
		System.out.println("Start Date : " + startDate);
		System.out.println("End Date : " + endDate);

		
		try
		{
			Rental rent = new Rental();
			boolean success = rent.createRental(rentalName, rentalQuantity, startDate, endDate);
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
