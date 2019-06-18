package com.revature.arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		//create a 2D array of ints
		int [][] arr1 = new int[10][20];
		
		//really creating an array of arrays
		int [][] arr2 = {{1,2,3}, {4,5,6}};
		int [][] arr3 = {{6,5,4}, {3,2,1}};
		
		for(int x = 0; x < arr2.length; x++) //iterating over rows (x)
		{
			for(int y = 0; y < arr2[x].length; y++) //iterating over columns (y)
			{
				System.out.println("x = " + x);
				System.out.println("y = " + y);
				System.out.println("arr2[x][y] = " + arr2[x][y]);
			}
		}
		
		int largestNum = largestElement(arr2);
		System.out.println("The largest number in arr2 is: " + largestNum);
		
		int sumOfElements = sumElement(arr2);
		System.out.println("The sum of arr2 is: " + sumOfElements);
		
		int[][] arrSorted = sortArray(arr2);
		for(int x = 0; x < arrSorted.length; x++) //iterating over rows (x)
		{
			for(int y = 0; y < arrSorted[x].length; y++) //iterating over columns (y)
			{
				System.out.println(arrSorted[x][y]);
			}
		}
	}
	/*
	 * return largest int in provided array
	 */
	public static int largestElement(int[][] arr)
	{
		int largestNum = 0;
		
		for(int x = 0; x < arr.length; x++)
		{
			for(int y = 0; y < arr[x].length; y++)
			{
				if(arr[x][y] > largestNum)
				{
					largestNum = arr[x][y];
				}
			}
		}
		
		return largestNum;
	}
	
	/*
	 * return sum of ints in provided array
	 */
	public static int sumElement(int[][] arr)
	{
		int sum = 0;
		
		for(int x = 0; x < arr.length; x++)
		{
			for(int y = 0; y < arr[x].length; y++)
			{
				sum += arr[x][y];
			}
		}
		
		return sum;
	}
	
	/*
	 * sort a provided array from top left to bottom right
	 */
	public static int[][] sortArray(int[][] arr)
	{
		int current = arr[0][0];
		for(int x = 0; x < arr.length; x++)
		{
			for(int y = 0; y < arr[x].length; y++)
			{
				if(arr[x][y] < current)
				{
					current = arr[x][y];
				}
			}
		}
		
		return arr;
	}

}
