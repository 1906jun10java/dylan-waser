package com.revature.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Bear;
import com.revature.beans.BearType;
import com.revature.beans.Cave;

public class BearService {

	public BearService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Bear> getBears() {
		ArrayList<Bear> bears = new ArrayList<>();
		BearType bt = new BearType(4, "Grizzly");
		Cave c = new Cave(57, "Tampa", 12);
		bears.add(new Bear(3, "Joshua", c, bt, 650, LocalDate.of(2005, Month.APRIL, 28)));
		bears.add(new Bear(3, "Smokey", c, bt, 650, LocalDate.of(1989, Month.JULY, 24)));
		return bears;
	}

}
