package com.revature.funfactory;

public class Driver {

	private static HondaFactory hf = new HondaFactory();
	
	public static void main(String[] args)
	{
		Car c1 = hf.getCar("crv", "blue/green");
		Car c2 = hf.getCar("civic", "black");
		Car c3 = hf.getCar("accord", "white");
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
	}

}
