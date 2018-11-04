package net.codejava.javaee.newhospital;

/**
 * Patient.java
 * This is a model class represents a book entity
 * @author www.codejava.net
 *
 */
public class Patient {
	protected int id;
	protected String firstname;
	protected String lastname;
	protected String address;
	protected String city;
	protected long mobile;

	public Patient() {
	}

	public Patient(int id) {
		this.id = id;
	}

	public Patient(int id, String firstname, String lastname, String address, String city, long mobile) {
		this(firstname, lastname, address, city, mobile);
		this.id = id;
	}
	
	public Patient(String firstname, String lastname, String address, String city, long mobile) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.mobile = mobile;
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
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

}
