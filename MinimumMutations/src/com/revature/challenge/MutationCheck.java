package com.revature.challenge;

import java.util.HashSet;

public class MutationCheck {

	public static int minMutations(String geneStart, String geneEnd, String[] geneBank)
	{
		int mutations = 0; //numbers of mutations to get from start to end
		HashSet bank = new HashSet(); //for easier searching in the geneBank
		
		for(String geneString : geneBank)
		{
			bank.add(geneString); //adds each gene string in geneBank to "bank"
		}
		
		if(!bank.contains(geneEnd)) //ensures that geneBank contains geneEnd
		{
			return -1;
		}
		
	/*	//trying to use geneBank
		for(int i = 0; i < geneBank.length; i++)
		{
			String gene = geneBank[i];
			for(int j = 0; i < 8; i++)
			{
				if(gene.charAt(j) != geneStart.charAt(j))
				{
					
				}
			}
		}
	*/		
		for(int i = 0; i < 8; i++)
		{
			if(geneStart.charAt(i) != geneEnd.charAt(i))
			{
				mutations++;
			}
		}
		
		return mutations;
	}
	
}

/*
 * I understand how bank is used, however not sure how to implement.
 * I convert geneBank into a HashSet to make searching through it easier
 * to make sure it contains the end gene. If it does not return -1 as instructions state
 * 
 * I can tell how many mutations occur just by counting how many letters are different between
 * start and end. However, I'm not sure how to check if geneBank contains each individual mutation
 * 
 * AACCGGTT
 *        |
 * AACCGGTA     2 different mutations
 *   | 
 * AAACGGTA
*/ 
