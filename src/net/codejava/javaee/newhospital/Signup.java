package net.codejava.javaee.newhospital;

/**
 * Signup.java
 * This is a model class represents a book entity
 * @author www.codejava.net
 *
 */
public class Signup {
	protected int id;
	protected String firstname;
	protected String lastname;
	protected String email;
	protected String username;
	protected String password;
	
	public Signup() {
	}

	public Signup(int id) {
		this.id = id;
	}

	public Signup(int id, String firstname, String lastname, String email, String username, String password) {
		this(firstname, lastname, email, username, password);
		this.id = id;
	}
	
	public Signup(String firstname, String lastname, String email, String username, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
