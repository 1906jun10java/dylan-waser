package com.revature.arrays;

public class Wednesday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//toCharArray
							//String class
		//charAt
		
		//no recursion yet - loops for now
		//System.out.println(reverse("Fart"));
		
		//System.out.println("Is it a palindrome: " + isPalindrome("doGeeseeGod")); 
		
		//System.out.println(calculateFactorial(5));
		
		String str = "Things";
		int n = str.length()-1; 
		System.out.println(recursiveReverse(str, n));
	}

	public static String reverse(String str) //write a method to reverse a string
	{
		String rts = "";
		for(int i = str.length()-1; i >= 0; i--)
		{
			rts+= str.charAt(i);
		}
		return rts;
	}
	
	public static boolean isPalindrome(String str) //check if a string is a palindrome
	{
		boolean isPalindrome = false;
		char[] charArr = str.toCharArray();
		int x = 0;
		int y = charArr.length-1;
		
		while(x <= y)
		{
			if(charArr[x] == charArr[y])
			{
				isPalindrome = true;
			}
			else
			{
				isPalindrome = false;
			}
			
			x++;
			y--;
		}
		return isPalindrome;
	}
	
	//mechanics of recursion
	public static int calculateFactorial(int n)
	{
		//base case
		if(n == 0 || n == 1)
		{
			return 1;
		}
		
		//recursive case
		return n * calculateFactorial(n-1);
	}
	
	//write a recursiveReverse method
	public static String recursiveReverse(String str, int n)
	{
		String rts = "";
		
		rts+= str.charAt(n);
		if(n >= 0)
		{
			recursiveReverse(rts, n);
		}
		return rts;
	}
	
}
