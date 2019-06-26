package com.revature.example;

import java.lang.reflect.Field;
import java.util.Arrays;

import com.revature.beans.Car;

public class FunWithReflection {

	public static void main(String[] args)
	{
		//Reflection API
		//allows us to inspect objects and classes at runtime
		
		//instanceOf operator
		//allows a runtime check on an object's type
		//gives us some safety when downcasting
		
		//declared type is Object
		//actual type is Car
		Object o = new Car(2003, "Lamborghini", "Gallardo", 0.0);
		System.out.println("Is " + o + " a car? " + isItACar(o));
		
		Object o2 = new Object();
		System.out.println("Is " + o2 + " a car? " + isItACar(o2));
		
		//get a Class by its fully qualified classname (package.classname)
		try 
		{
			//can throw a checked exception - ClassNotFoundException
			Class clazz = Class.forName("com.revature.beans.Car");
			System.out.println(clazz.getTypeName());
			
			//get the fields of a Car
			Field[] fields = clazz.getDeclaredFields();
			System.out.println(Arrays.toString(fields)); //Arrays with an S is the arrays utility class
			for(Field f : fields)
			{
				System.out.println(f.getName());
			}
			
			//remember yesterday? String.split?
			String[] redundantFieldsArray = Arrays.toString(fields).split(",");
			for(String s : redundantFieldsArray)
			{
				System.out.println(s);
			}
			
			//new instance of Car
			Car c = (Car) clazz.newInstance();
			Field yearManufactured = clazz.getDeclaredField("yearManufactured");
			yearManufactured.setAccessible(true);
			yearManufactured.set(c, 1998); //this breaks encapsulation
			System.out.println(c);
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (InstantiationException e) 
		{
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) 
		{
			e.printStackTrace();
		} 
		catch (NoSuchFieldException e) 
		{
			e.printStackTrace();
		} 
		catch (SecurityException e) 
		{
			e.printStackTrace();
		}
		//if youre doing the same thing in EVERY CATCH BLOCK
		//you might as well have one, more general catch block
	}
	
	static boolean isItACar(Object o)
	{
		boolean b = o instanceof Car; //perform a runtime type check
		return b;
	}

}
