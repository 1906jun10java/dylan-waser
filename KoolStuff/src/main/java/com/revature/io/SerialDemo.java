package com.revature.io;

import com.revature.funfactory.Car;
import com.revature.funfactory.HondaFactory;

public class SerialDemo {
	private static HondaFactory hf = new HondaFactory();
	
	public static void main(String[] args) 
	{
		IO io = new IO();
		/*
		String a = "Zelda";
		io.writeOutputStreamContents("Trevor likes to play " + a);
		*/
		//read from a file
		//System.out.println(io.readInputStreamContents());
		
	/*	Car c1 = hf.getCar("crv", "blue/green");
		Car c2 = hf.getCar("civic", "black");
		Car c3 = hf.getCar("accord", "white");
		
		IOWithCollections.carList.add(c1);
		IOWithCollections.carList.add(c2);
		IOWithCollections.carList.add(c3);
		
		IOWithCollections.writeCarFile();		*/
		
		IOWithCollections.readCarFile();
		System.out.println(IOWithCollections.carList.toString());
	}

}
