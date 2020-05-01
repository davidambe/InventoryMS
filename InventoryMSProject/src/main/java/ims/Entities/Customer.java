package ims.Entities;

public class Customer {
	private Long customerID;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String postCode;

	// CREATE
	public Customer(long customerID, String firstName, String lastName, String email, String address, String postCode) {
		// this.customer = createtCustomer();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.postCode = postCode;
		this.customerID = customerID;

	}

	// Getters
	public Long getCustomerID() {
		return customerID;
	}
	public String getfirstName() {
		return firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public String getemail() {
		return email;
	}

	public String getaddress() {
		return address;
	}

	public String getpostCode() {
		return postCode;
	}

	// Setters
	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public void setpostCode(String postCode) {
		this.postCode = postCode;
	}

}
