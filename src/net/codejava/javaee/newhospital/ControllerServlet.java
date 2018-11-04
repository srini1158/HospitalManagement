package net.codejava.javaee.newhospital;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientDAO patientDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		patientDAO = new PatientDAO(jdbcURL, jdbcUsername, jdbcPassword);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertPatient(request, response);
				break;
			case "/delete":
				deletePatient(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updatePatient(request, response);
				break;
			case "/signup":
				updateSignup(request, response);
				break;
			case "/login":
				checkLogin(request, response);
				break;
			default:
				listPatient(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void updateSignup(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		
		Signup newSignup = new Signup(firstname, lastname, email, name, password);
		patientDAO.insertUser(newSignup);
		PrintWriter out = response.getWriter();
		out.println("You have successfully signed up");
		//response.sendRedirect("list");
	}
	
	private void checkLogin(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		
	    Login newLogin = new Login(name, password);
			
		//PrintWriter out = response.getWriter();	
		//response.sendRedirect("list");
		/*
		if (name.equals(dbName) && password.equals(dbPassword)) { 
			out.println("You have successfully Logged In");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		*/
	}
	
	private void listPatient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Patient> listPatient = patientDAO.listAllPatients();
		request.setAttribute("listPatient", listPatient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("PatientList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("PatientForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Patient existingPatient = patientDAO.getPatient(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("PatientForm.jsp");
		request.setAttribute("patient", existingPatient);
		dispatcher.forward(request, response);

	}

	private void insertPatient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		long mobile = (long) Float.parseFloat(request.getParameter("mobile"));

		Patient newPatient = new Patient(firstname, lastname, address, city, mobile);
		patientDAO.insertPatient(newPatient);
		response.sendRedirect("list");
	}

	private void updatePatient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		long mobile = (long) Float.parseFloat(request.getParameter("mobile"));

		Patient patient = new Patient(id, firstname, lastname, address, city, mobile);
		patientDAO.updatePatient(patient);
		response.sendRedirect("list");
	}

	private void deletePatient(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Patient patient = new Patient(id);
		patientDAO.deletePatient(patient);
		response.sendRedirect("list");

	}

}
