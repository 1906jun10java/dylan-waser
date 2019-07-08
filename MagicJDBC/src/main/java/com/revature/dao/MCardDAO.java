package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.MCard;

public interface MCardDAO {
	//CRUD operations
	public abstract void createMCard(String mCardName) //create
		throws SQLException;
	
	public abstract List<MCard> readAllMCardList() //readAll
		throws SQLException;
}
