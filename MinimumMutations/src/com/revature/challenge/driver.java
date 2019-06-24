package com.revature.challenge;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class driver {

	public static void main(String[] args) {
		//hard coded version which works
		String geneStart = "AACCGGTT";
		String geneEnd =   "AAACGGTA";
		String[] geneBank = {"AACCGGTA", "AACCGCTA", "AAACGGTA", "CCAATTAA"};
		
		//read in from scanner version which works
	/*	Scanner kb = new Scanner(System.in);
		System.out.println("What is the starting gene?");
		String geneStart = kb.next();
		
		System.out.println("What is the ending gene?");
		String geneEnd = kb.next();
		
		System.out.println("How many gene strings will be in the bank?");
		int numOfStrings = kb.nextInt();
		String[] geneBank = new String[numOfStrings];
		for(int i = 0; i < numOfStrings; i++)
		{
			System.out.println("What is the string for position " + i);
			geneBank[i] = kb.next();
		}
	*/	
		
		
		
		//file read in version which is not finished
	/*	String fileName = "mutations.txt";
		try
		{
			FileInputStream inFile = new FileInputStream(fileName);
			ObjectInputStream inStream = new ObjectInputStream(inFile);
			
		}
		catch(Exception e)
		{
			System.out.println("File not found, goodbye.");
			System.exit(-1);
		}
	*/
		
		
		System.out.println("Printing the minimum amount of mutations for " + geneStart + " and " + geneEnd + "\n" +
							MutationCheck.minMutations(geneStart, geneEnd, geneBank));
		
		

	}

}
