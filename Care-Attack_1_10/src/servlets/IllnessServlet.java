package servlets;

import illness.Illness;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IllnessServlet
 */
public class IllnessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IllnessServlet() {
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
		String illnessName = request.getParameter("illnessName");
		String illnessDescription = request.getParameter("illnessDescription");
		String illnessCategory = request.getParameter("illnessCategory");
		String severity = request.getParameter("severity");
		Illness illness = new Illness(illnessName,illnessDescription,illnessCategory,severity);
		boolean success = illness.createIllness();
	}

}
