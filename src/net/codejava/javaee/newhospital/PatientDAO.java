package net.codejava.javaee.newhospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table patient
 * in the database.
 * @author www.codejava.net
 *
 */
public class PatientDAO {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public PatientDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(
										jdbcURL, jdbcUsername, jdbcPassword);
		}
	}
	
	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public boolean insertPatient(Patient patient) throws SQLException {
		String sql = "INSERT INTO patient (firstname, lastname, address, city, mobile) VALUES (?, ?, ?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, patient.getFirstName());
		statement.setString(2, patient.getLastName());
		statement.setString(3, patient.getAddress());
		statement.setString(4, patient.getCity());
		statement.setLong(5, patient.getMobile());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<Patient> listAllPatients() throws SQLException {
		List<Patient> listPatient = new ArrayList<>();
		
		String sql = "SELECT * FROM patient";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			int id = resultSet.getInt("patient_id");
			String firstname = resultSet.getString("firstname");
			String lastname = resultSet.getString("lastname");
			String address = resultSet.getString("address");
			String city = resultSet.getString("city");
			long mobile = resultSet.getLong("mobile");
			
			Patient patient = new Patient(id, firstname, lastname, address, city, mobile);
			listPatient.add(patient);
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listPatient;
	}
	
	public boolean deletePatient(Patient patient) throws SQLException {
		String sql = "DELETE FROM patient where patient_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, patient.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updatePatient(Patient patient) throws SQLException {
		String sql = "UPDATE patient SET firstname = ?, lastname = ?, address = ?, city = ?, mobile = ?";
		sql += " WHERE patient_id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, patient.getFirstName());
		statement.setString(2, patient.getLastName());
		statement.setString(3, patient.getAddress());
		statement.setString(4, patient.getCity());
		statement.setLong(5, patient.getMobile());
		statement.setInt(6, patient.getId());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public Patient getPatient(int id) throws SQLException {
		Patient patient = null;
		String sql = "SELECT * FROM patient WHERE patient_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			String firstname = resultSet.getString("firstname");
			String lastname = resultSet.getString("lastname");
			String address = resultSet.getString("address");
			String city = resultSet.getString("city");
			long mobile = resultSet.getLong("mobile");
			
			patient = new Patient(id, firstname, lastname, address, city, mobile);
		}
		
		resultSet.close();
		statement.close();
		
		return patient;
	}
	
	public boolean insertUser(Signup signup) throws SQLException {
		String sql = "INSERT INTO hm_users (firstname, lastname, email, username, password) VALUES (?, ?, ?, ?, ?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, signup.getFirstName());
		statement.setString(2, signup.getLastName());
		statement.setString(3, signup.getEmail());
		statement.setString(4, signup.getUserName());
		statement.setString(5, signup.getPassword());
				
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public Login selectUser(Login login) throws SQLException {
		String dbName = null;
		String dbPassword = null;
		String name = login.getUserName();
		String password = login.getPassword();
		String sql = "select * from hm_users where username=?, password=?)";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, name);
		statement.setString(2, password);
		ResultSet resultSet = statement.executeQuery();
		
		while (resultSet.next()) {
			dbName = resultSet.getString("username");
			dbPassword = resultSet.getString("password");
			login = new Login(dbName, dbPassword);					
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		return login;
	}
}
