package com.revature.services;

import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;

public class EmployeeServices {

	//updates employee using the EmployeeDAOImpl updateEmp()
	public boolean updateEmployee(int id, String newUsername, String newFirstName, String newLastName, String newEmail)
	{
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		boolean updated = false;
		
		Employee e = null;
		try
		{
			e = edi.readEmployee(id);
			e.toString();//just making sure we got an employee
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		//set e's properties to the new properties values
		//check if what was entered from website are not null values
		if(newUsername != null)
		{
			e.setUsername(newUsername);
		}
		if(newFirstName != null)
		{
			e.setFirstName(newFirstName);
		}
		if(newLastName != null)
		{
			e.setLastName(newLastName);
		}
		if(newEmail != null)
		{
			e.setEmail(newEmail);
		}
		
		//once local employee has been set to new values
		//updateEmp database side
		try {
			edi.updateEmployee(e);
			updated = true;
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return updated;
	}
}
