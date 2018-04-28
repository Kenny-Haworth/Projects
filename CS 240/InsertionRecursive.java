/**
	An insertion sort algorithm that uses recursion to
	sort an array from low numbers to high numbers.
	@author Kendall Haworth
*/

import java.util.Random;

public class InsertionRecursive
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
		
		Sort(array, 1); //Calls the recursive sorting method starting at element 1.
		
		//This loop prints out the sorted array.
		for (int m = 0; m < array.length; m++)
		{
			System.out.print(array[m] + " ");
		}
	}
	
	public static void Sort(int[] array, int w)
	{
		if (w == array.length - 1) //Base case. If scanning at the end of the array, sort and don't call insertionSort() again.
		{
			checks(array, w);
		}
		else //Recursive case, if not done sorting the array.
		{
			checks(array, w);
			
			w++;
			Sort(array, w);
		}
	}
	
	/*
		This method sorts the array by swapping the current element with the previous if it is smaller.
		insertionSort() calls this method to perform checks and swaps on the array.
	*/
	public static int[] checks(int[] array, int r)
	{
		if (r == 0) //Base case, if finished scanning the array.
		{
			return array;
		}
		
		if (array[r] < array[r-1]) //If the previous element is larger, swap with it.
		{
			int temp = array[r-1];
			array[r-1] = array[r];
			array[r] = temp;
			r--;
			checks(array, r);
		}

		return array;
	}
}