package com.revature.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;

public class AuthenticationService {

	static public EmployeeDAOImpl edi = new EmployeeDAOImpl(); 
	
	public AuthenticationService() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee authenticateUser(String usernameLog, String passwordLog) {
		ArrayList<Employee> emps;
		Employee e = null;
		try {
			emps = edi.readAllEmployees();
			if(emps != null)
			{	
				for(Employee emp : emps)
				{
					if(usernameLog.equals(emp.getUsername()) && passwordLog.equals(emp.getPassw0rd()))
					{
						e = new Employee(emp.getEmployeeID(), emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getUsername(), emp.getPassw0rd(), emp.getManagerID());
					}
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

}
