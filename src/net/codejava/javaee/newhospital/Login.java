package net.codejava.javaee.newhospital;

/**
 * Login.java
 * This is a model class represents a book entity
 * @author www.codejava.net
 *
 */
public class Login {
	protected int id;
	protected String username;
	protected String password;
	
	public Login() {
	}

	public Login(int id) {
		this.id = id;
	}

	public Login(int id, String username, String password) {
		this(username, password);
		this.id = id;
	}
	
	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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