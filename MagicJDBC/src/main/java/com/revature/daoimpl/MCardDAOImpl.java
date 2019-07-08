package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.MCard;
import com.revature.dao.MCardDAO;
import com.revature.util.ConnFactory;

public class MCardDAOImpl implements MCardDAO{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void createMCard(String mCardName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call INSERTMCARD(?)";
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, mCardName);
		call.execute();
		
	}

	public List<MCard> readAllMCardList() throws SQLException {
		List<MCard> mCardList = new ArrayList<MCard>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM MCARD");
		MCard card = null;
		while(rs.next())
		{
			card = new MCard(rs.getInt(1),
								rs.getString(2));
			mCardList.add(card);
		}
		return mCardList;
	}
}
