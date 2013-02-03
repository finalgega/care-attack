package servlets;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import medicine.Medicine;

/**
 * Servlet implementation class MedicineServlet
 */
public class MedicineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String illnessName = request.getParameter("illness");
		System.out.println("illnessName : " + illnessName);
		session.setAttribute("illnessName", illnessName);
		response.sendRedirect("taskPlanner.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String medicineName = request.getParameter("medicineName");
		String medicineDescription = request.getParameter("medicineDescription");
		String contraindications = request.getParameter("contraindications");
		String instructions = request.getParameter("instructions");
		String strtimesPerDay = request.getParameter("timesPerDay");
		Scanner sc = new Scanner(strtimesPerDay);
		int timesPerDay = sc.nextInt();
		String sideEffects = request.getParameter("sideEffects");
		Medicine med = new Medicine();
		med.createMedicine(medicineName,medicineDescription,contraindications,instructions,timesPerDay,sideEffects);
	}
	

}
