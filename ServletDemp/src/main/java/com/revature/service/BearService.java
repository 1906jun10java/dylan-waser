package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.dao.BearDAO;
import com.revature.daoimpl.FakeBearDAOImpl;

public class BearService {

	private BearDAO bd = new FakeBearDAOImpl(); //this is the only line i have to change to swap out dao implementation
	//
	
	public BearService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Bear> getBears() {		
		return bd.getBear();
	}
	
	public Bear getBearByID(int id)
	{
		return bd.getBearById(id);
	}
	
	public boolean createBear(Bear bear)
	{
		bd.createBear(bear);
		return true;
	}

}
