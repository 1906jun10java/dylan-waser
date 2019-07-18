package com.revature.driver;

import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.ReimbursementDAOImpl;

public class Driver {

	static public EmployeeDAOImpl edi = new EmployeeDAOImpl();
	static public ReimbursementDAOImpl rdi = new ReimbursementDAOImpl();
	
	public static void main(String[] args) {
			
		try
		{
			rdi.createReimbursement(7, 50, "Gas", "reciept.jpg");
		}
		catch(Exception e)
		{
			System.out.println("Exception from the main.");
		}
	}

}
