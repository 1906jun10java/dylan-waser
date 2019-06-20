package com.revature.bigo;

import java.util.ArrayList;

public class Thursday {

	public static void main(String[] args) {
	/*	String str = "Java";
		String subStr = "c#";
		
		System.out.println("Does " + str + " contain " + subStr + "?"
							+ "\n" + containsSubstring(str, subStr));
		
		System.out.println(triangle(5));
	*/	
		
		
		//start coding Queue
		ArrayList<String> usernames = new ArrayList<String>();
		
		System.out.println("Adding usernames to the \"Queue\"");
		String newUsername = "reinwaser";
		
		addToQueue(usernames, newUsername); //adds a new element to the "Queue"
		addToQueue(usernames, "mordwen");
		addToQueue(usernames, "Zandius");
		addToQueue(usernames, "Shyrogue");
		System.out.println("Contents after adding: " + usernames.toString());
		
		//remove head of "Queue" and prints
		removeFromQueue(usernames);
		System.out.println("----------------------------------------------------------------------" + "\n" +
							"Printing the Queue after removing: " + usernames.toString());
		
		//polls the head of the "Queue"
		System.out.println("----------------------------------------------------------------------" + "\n" +
							"Printing the head of the queue using poll()" + "\n" +
							pollQueue(usernames) + "\n" +
							"Printing the queue after poll()" + "\n" +
							usernames.toString());
		

	}
	
	
	public static boolean containsSubstring(String str, String subStr)
	{
		boolean contains = false;
		if(str.contains(subStr))
		{
			contains = true;
		}
		return contains;
	}
	
	public static int triangle(int numRows)
	{
		if(numRows == 1)
		{
			return numRows;
			
		}
		return numRows + triangle(numRows-1);
	}
	
	
	//method that act like a Queue method.
	public static void addToQueue(ArrayList<String> usernames, String username)
	{
		usernames.add(username);
	}
	
	//method that acts like Queue remove()
	public static void removeFromQueue(ArrayList<String> usernames)
	{
		usernames.remove(0);
	}
	
	//method that acts like poll() of a Queue
	public static String pollQueue(ArrayList<String> usernames)
	{
		String username = usernames.get(0);
		usernames.remove(0);
		
		return username;
	}

}
