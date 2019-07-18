package com.revature.beans;

public class Employee {
	private int employeeID;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String passw0rd;
	private int managerID;
	
	public Employee(int employeeID, String firstName, String lastName, String email, String username, String passw0rd,
			int managerID) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.passw0rd = passw0rd;
		this.managerID = managerID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassw0rd() {
		return passw0rd;
	}

	public void setPassw0rd(String passw0rd) {
		this.passw0rd = passw0rd;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", username=" + username + ", passw0rd=" + passw0rd + ", managerID=" + managerID + "]";
	}
	
	
}
