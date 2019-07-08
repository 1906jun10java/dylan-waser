package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.util.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO{

	public static ConnFactory cf = ConnFactory.getInstance();

	public ArrayList<Employee> readAllEmployees() throws SQLException {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		Statement stmt;
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
			Employee e = null;
			while(rs.next())
			{
				e = new Employee(rs.getInt(1),	//int employeeID
								rs.getString(2), //String empFirstName
								rs.getString(3),	//String empLastName
								rs.getInt(4), //int departmendID
								rs.getDouble(5), //double salary
								rs.getString(6)); //String salary
								
				employeeList.add(e);
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
		return employeeList;
		
	}

	public ArrayList<Employee> createEmployee(String empFirstName, String empLastName, int departmentID, double salary,
			String empEmail) throws SQLException {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		try {
			String sql = "{ call INSERTEMPLOYEE(?, ?, ?, ?, ?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, empFirstName);
			call.setString(2,  empLastName);
			call.setInt(3, departmentID);
			call.setDouble(4, salary);
			call.setString(5, empEmail);
			call.execute();
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong during employee creation.");
		}
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
		Employee e = null;
		while(rs.next())
		{
			e = new Employee(rs.getInt(1),	//int employeeID
							rs.getString(2), //String empFirstName
							rs.getString(3),	//String empLastName
							rs.getInt(4), //int departmendID
							rs.getDouble(5), //double salary
							rs.getString(6)); //String salary
							
			employeeList.add(e);
		}
		return employeeList;
	}

	public void calcAVGSalaryPerDepartment() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT D.DEPARTMENT_NAME, AVG(E.SALARY) FROM DEPARTMENT D RIGHT JOIN EMPLOYEE E ON D.DEPARTMENT_ID = E.DEPARTMENT_ID GROUP BY D.DEPARTMENT_NAME ORDER BY AVG(E.SALARY) DESC";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		String str = "";
		while(rs.next())
		{
			System.out.println(rs.getString(1) + " " + rs.getDouble(2)); //departmentName
			
		}
	}
}
