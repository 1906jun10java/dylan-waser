package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Powers;
import com.revature.dao.PowerDAO;
import com.revature.util.ConnFactory;

public class PowersDAOImpl implements PowerDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createPowers(String powerName) throws SQLException 
	{
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO POWERS VALUES(POWSEQ.NEXTVAL,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, powerName);
		ps.executeUpdate();
	}
	
	public List<Powers> readAllPowers() throws SQLException
	{
		List<Powers> powersList = new ArrayList<Powers>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM POWERS");
		Powers p = null;
		while(rs.next())
		{
			p = new Powers(rs.getInt(1),
							rs.getString(2));
			
			powersList.add(p);
		}
		return powersList;
	}
}
