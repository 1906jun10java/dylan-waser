package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.PowersDAOImpl;
import com.revature.daoimpl.SuperHeroDAOImpl;

public class Driver {

	public static void main(String[] args)
	{
		SuperHeroDAOImpl shdi = new SuperHeroDAOImpl();
		PowersDAOImpl pdi = new PowersDAOImpl();
	/*	try {
			pdi.createPowers("FLIGHT");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	/*	try 
		{
			shdi.createSuperHero("black panther");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			System.out.println(shdi.getSuperHeroList());
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
		try {
			System.out.println(pdi.readAllPowers());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
