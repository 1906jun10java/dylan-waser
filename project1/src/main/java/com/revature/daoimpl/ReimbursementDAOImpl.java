package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.beans.Reimbursement;
import com.revature.dao.ReimbursementDAO;
import com.revature.util.ConnFactory;

public class ReimbursementDAOImpl implements ReimbursementDAO{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public boolean createReimbursement(int EMPLOYEEID, double AMOUNT, String REASON, String PHOTO, int RESOLVED)
			throws SQLException {
		Connection conn = cf.getConnection();
		try {
			String sql = "{ call INSERTREM(?, ?, ?, ?, ?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, EMPLOYEEID);
			call.setDouble(2, AMOUNT);
			call.setString(3, REASON);
			call.setString(4, PHOTO);
			call.setInt(5, RESOLVED);
			call.execute();
			return true; //successfully created
		}
		catch(SQLException sqle)
		{
			System.out.println("Something went wrong during reimbursement creation.");
		}
		return false; //not created		
	}

	public ArrayList<Reimbursement> readAllReimbursement() throws SQLException {
		ArrayList<Reimbursement> reimList = new ArrayList<Reimbursement>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM REIMBURSEMENT");
		Reimbursement r = null;
		while(rs.next())
		{
			r = new Reimbursement(rs.getInt(2),
									rs.getDouble(3),
									rs.getString(4),
									rs.getString(5),
									rs.getInt(6));
			reimList.add(r);
		}
		return reimList;
	}

	public Reimbursement readReimbursement(Reimbursement r) throws SQLException {
		
		return null;
	}
	
	public ArrayList<Reimbursement> readReimbursementByEmpID(int employeeID) throws SQLException {
		ArrayList<Reimbursement> reimListOfEmp = new ArrayList<Reimbursement>();
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REIMBURSEMENT WHERE EMPLOYEEID = ?";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setInt(1, employeeID);
		ResultSet rs = ps.executeQuery();
		Reimbursement r = null;
		while(rs.next())
		{
			r = new Reimbursement(rs.getInt(2), //employeeID
									rs.getDouble(3), //amount
									rs.getString(4), //reason
									rs.getString(5), //photo
									rs.getInt(6)); //resolved
			reimListOfEmp.add(r);
		}
		return reimListOfEmp;
	}

	public void updateReimbursement(Reimbursement r) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call UPDATEREIM(?, ?, ?, ?, ?, ?";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, r.getEmployeeID());
		call.setDouble(2, r.getAmount());
		call.setString(3, r.getReason());
		call.setString(4, r.getPhoto());
		call.setInt(5, r.getResolvedBit());
		call.execute();
		
	}

	public void deleteReimbursement(Reimbursement r) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM REIMBURSEMENT WHERE REIMBURESEMENTID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, r.getReimbursementID());
		ps.executeUpdate();
		
	}
	
}
