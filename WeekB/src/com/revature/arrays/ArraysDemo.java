package com.revature.arrays;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
		//create a 2D array of ints
		int [][] arr1 = new int[10][20];
		
		//really creating an array of arrays
		int [][] arr2 = {{1,2,3}, {4,5,6}};
		int [] arr4 = {7, 54, 32, 86, 5, 12};
		
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
		
	/*
		System.out.println("Print Arr4 sorted.");
		int[] sortedBubbleArr = bubbleSort(arr4);
		for(int x = 0; x < sortedBubbleArr.length; x++)
		{
			System.out.println(sortedBubbleArr[x]);
		}
	*/
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
		int length = arr.length;
		
		for(int x = arr.length; x < arr.length; x++)
		{
			for(int y = 0; y < arr[x].length; y++)
			{
				for(int z = 0; z < arr[x].length - x; z++)
				{
					if(arr[x][y] > arr[x][y])
					{
						int storeNumber = arr[x][y];
						arr[x][y] = arr[x][arr.length-1-y];
						arr[x][y] = storeNumber;
					}
				}
			}
		}
		return arr;
	}
	
	
	public static int[] bubbleSort(int[] arr)
	{
		for(int x = 0; x < arr.length; x++)
		{
			for(int y = 0; y < arr.length-1; y++) //Improvement #1: could change to arr.length-1-x, stop checking when already bubbled values are reached
			{									  //getting rid of redundant calculations
				if(arr[x] < arr[y])
				{								  //Improvement #2: keep track of whether additional passes are necessary
					int store = arr[x];
					arr[x] = arr[y];
					arr[y] = store;
				}
			}
		}
		return arr;
	}

}
