/**
	A selective sort algorithm that uses recursion to
	sort an array from low numbers to high numbers.
	@author Kendall Haworth
*/

import java.util.Random;

public class SelectiveRecursive
{
	public static void main(String[] args)
	{
		int[] array = new int[10];
		
		Random randomObj = new Random();
		
		//This loop fills each element of the array with random numbers.
		for (int q = 0; q < array.length; q++)
		{
			array[q] = randomObj.nextInt(1000);
			System.out.print(array[q] + " ");
		}
		
		System.out.println();
		
		Sort(array, 0);
	}
	
	/*
		This method will sort the values in the array recursively
		and print them out.
	*/
	public static void Sort(int[] array, int w)
	{
		int minSize = 1000;
		int location = -1;
		int temp;
		
		if (w == array.length - 1) //Base case, when the method scans the last element of the array.
		{
			System.out.print(array[w] + " "); //The array is already sorted, so just print out the last element.
		}
		else
		{
			location = findMin(array, w, minSize, location); //Calls another method to find the location of the smallest number.
			minSize = array[location];
			
			//These statements place the smallest value into the first element that has not been sorted.
			temp = array[w];
			array[w] = minSize;
			array[location] = temp;
			System.out.print(array[w] + " ");
			
			w++;
			Sort (array, w);
		}
	}
	
	/*
		This method will find the location of the smallest value and return it.
	*/
	public static int findMin(int[] array, int w, int minSize, int location)
	{
		if (w == array.length - 1) //Base case, when it scans the last element in the array.
		{
			if (array[w] < minSize)
			{
				location = w;
			}
			return location;
		}
		
		if (array[w] < minSize)
		{
			minSize = array[w];
			location = w;
		}
		w++;
		return findMin(array, w, minSize, location);
	}
}