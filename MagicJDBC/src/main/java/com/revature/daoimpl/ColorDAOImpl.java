package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Color;
import com.revature.dao.ColorDAO;
import com.revature.util.ConnFactory;

public class ColorDAOImpl implements ColorDAO{
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createColor(String colorName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO COLORS VALUES(COLSEQ.NEXTVAL,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, colorName);
		ps.executeUpdate();
	}

	public List<Color> readAllColor() throws SQLException {
		List<Color> colorsList = new ArrayList<Colors>();
		Connection conn = cf.getConnection();
		
		return null;
	}
	
}
