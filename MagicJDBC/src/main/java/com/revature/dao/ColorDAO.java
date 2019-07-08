package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Color;

public interface ColorDAO {
	public abstract void createColor(String colorName) //create
		throws SQLException;
	
	public abstract List<Color> readAllColor()
		throws SQLException;//readAll???
}
