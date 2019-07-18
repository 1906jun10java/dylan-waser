package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.util.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createEmployee(String FIRSTNAME, String LASTNAME, String EMAIL, String USERNAME,
			String PASSW0RD, int MANAGERID) throws SQLException {
		Connection conn = cf.getConnection();
		try {
			
			String sql = "{ call INSERTEMP(?, ?, ?, ?, ?, ?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, FIRSTNAME); //String firstName
			call.setString(2, LASTNAME); //String lastName
			call.setString(3, EMAIL); //String email
			call.setString(4, USERNAME); //String username
			call.setString(5, PASSW0RD); //String passw0rd
			call.setInt(6, MANAGERID); //int managerID
			call.execute();
		}
		catch(SQLException sqle)
		{
			System.out.println("Something went wrong during creation.");
		}
	}

	public ArrayList<Employee> readAllEmployees() throws SQLException {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");
		Employee e = null;
		while(rs.next())
		{
			e = new Employee(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getString(4),
					rs.getString(5),
					rs.getString(6),
					rs.getInt(7));
			empList.add(e);
		}
		return empList;
	}

	public Employee readEmployee(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(Employee e) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call UPDATEEMP(?, ?, ?, ?, ?, ?_";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, e.getFirstName());
		call.setString(2, e.getLastName());
		call.setString(3, e.getEmail());
		call.setString(4, e.getUsername());
		call.setString(5, e.getPassw0rd());
		call.execute();
	}

	public void deleteEmployee(Employee e) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, e.getEmployeeID());
		ps.executeUpdate();
		
	}

}
