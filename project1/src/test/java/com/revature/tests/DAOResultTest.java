package com.revature.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;

public class DAOResultTest {

	private static EmployeeDAOImpl edi = new EmployeeDAOImpl();
	private static ArrayList<Employee> empList = null;
	static Employee e1, e2, e3;
	
	@BeforeClass
	public static void initEmpMap() {
		e1 = new Employee(2, "fName", "lName", "email", "username1", "password", 1);
		e2 = new Employee(3, "fName2", "lName2", "email2", "username2", "password", 1);
		e2 = new Employee(4, "fName3", "lName3", "email3", "username3", "password", 1);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none(); // if any exception is thrown, test will fail
	
	@Test
	public void testDAOResult() throws Throwable{
		empList = edi.readAllEmployees();
		assertEquals(empList == null, false);
	}
}
