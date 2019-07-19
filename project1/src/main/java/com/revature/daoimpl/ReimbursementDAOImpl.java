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
	
	public void createReimbursement(int EMPLOYEEID, int AMOUNT, String REASON, String PHOTO, int RESOLVED)
			throws SQLException {
		Connection conn = cf.getConnection();
		try {
			String sql = "{ call INSERTREM(?, ?, ?, ?, ?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, EMPLOYEEID);
			call.setInt(2, AMOUNT);
			call.setString(3, REASON);
			call.setString(4, PHOTO);
			call.setInt(5, RESOLVED);
			call.execute();
		}
		catch(SQLException sqle)
		{
			System.out.println("Something went wrong during reimbursement creation.");
		}
		
	}

	public ArrayList<Reimbursement> readAllReimbursement() throws SQLException {
		ArrayList<Reimbursement> reimList = new ArrayList<Reimbursement>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM REIMBURSEMENT");
		Reimbursement r = null;
		while(rs.next())
		{
			r = new Reimbursement(rs.getInt(1),
									rs.getInt(2),
									rs.getInt(3),
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

	public void updateReimbursement(Reimbursement r) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call UPDATEREIM(?, ?, ?, ?, ?, ?_";
		CallableStatement call = conn.prepareCall(sql);
		call.setInt(1, r.getEmployeeID());
		call.setInt(2, r.getAmount());
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
