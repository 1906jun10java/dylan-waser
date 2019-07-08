package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Powers;

public interface PowerDAO {
	public abstract void createPowers(String powerName)
			throws SQLException;
	
	public abstract List<Powers> readAllPowers()
			throws SQLException;
}
