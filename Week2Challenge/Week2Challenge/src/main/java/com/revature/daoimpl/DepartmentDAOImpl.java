package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.beans.Department;
import com.revature.dao.DepartmentDAO;
import com.revature.util.ConnFactory;

public class DepartmentDAOImpl implements DepartmentDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	public ArrayList<Department> readAllDepartments() throws SQLException {
		ArrayList<Department> departmentList = new ArrayList<Department>();
		Connection conn = cf.getConnection();
		Statement stmt;
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM DEPARTMENT");
			Department d = null;
			while(rs.next())
			{
				d = new Department(rs.getInt(1),	//int departmentID
								rs.getString(2));	//String departmentName
								
				departmentList.add(d);
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block	
			e.printStackTrace();
		}
		return departmentList;
	}
}
