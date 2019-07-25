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
	
	@Override
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

	@Override
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

	@Override
	public Employee readEmployee(int id) throws SQLException {
		Connection conn = cf.getConnection();			
		String sql = "SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = ? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Employee e = null;
		while(rs.next())
		{
			e = new Employee(rs.getInt(1), //empid
							rs.getString(2), //firstname
							rs.getString(3), //lastname
							rs.getString(4), //email
							rs.getString(5), //username
							rs.getString(6), //password
							rs.getInt(7));
		}
		return e;
	}

	@Override
	public void updateEmployee(Employee e) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE EMPLOYEE SET USERNAME = ?, FIRSTNAME = ?, LASTNAME = ?, EMAIL = ? WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, e.getUsername());
		ps.setString(2, e.getFirstName());
		ps.setString(3, e.getLastName());
		ps.setString(4, e.getEmail());
		ps.setInt(5, e.getEmployeeID());
		ps.execute();
	}

	@Override
	public void deleteEmployee(Employee e) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM EMPLOYEE WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, e.getEmployeeID());
		ps.executeUpdate();
		
	}

}
