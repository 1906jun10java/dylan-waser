package com.revature.daoimpl;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;
import com.revature.dao.BearDAO;

public class FakeBearDAOImpl implements BearDAO{

	private List<Bear> allBears = new ArrayList<>();
	
	public FakeBearDAOImpl() {
		//pre populate with some bears
		BearType bt = new BearType(4, "Grizzly");
		Cave c = new Cave(57, "Tampa", 12);
		allBears.add(new Bear(3, "Joshua", c, bt, 650, LocalDate.of(2005, Month.APRIL, 28)));
		allBears.add(new Bear(3, "Smokey", c, bt, 650, LocalDate.of(1989, Month.JULY, 24)));
	}
	
	@Override
	public List<Bear> getBear() {
		return allBears;
	}

	@Override
	public Bear getBearById(int id) {
		Bear b = null;
		for(Bear bear : allBears)
		{
			if(bear.getId() == (id))
			{
				return bear;
			}
		}
		return null;
	}

	@Override
	public boolean createBear(Bear bear) {
		allBears.add(bear);
		return true; //this is only hardcoded because wre not actually persisting anything and nothing can go wrong
		
	}

	@Override
	public void updateBear(Bear bear) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBear(Bear bear) {
		// TODO Auto-generated method stub
		
	}

}
