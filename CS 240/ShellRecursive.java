/**
	A shell sort algorithm that uses recursion to
	sort an array from low numbers to high numbers.
	@author Kendall Haworth
*/

import java.util.Random;

public class ShellRecursive
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
		
		int hibbard = 3;
		shellSort(array, hibbard, 0); //Unscramble values using shell sort to make insertion sort faster.
		insertionSort(array, 1); //Use insertion sort to finish sorting the array.
		
		//This loop prints out the sorted array.
		for (int m = 0; m < array.length; m++)
		{
			System.out.print(array[m] + " ");
		}
	}
	
	/**
		First recursive method for shell sort, determining the
		numberOfComparisons and calling itself until p equals hibbard.
	*/
	public static void shellSort(int[] array, int hibbard, int p)
	{
		if (p != hibbard)
		{
			int numberOfComparisons = (array.length/hibbard) + 1;
			if ((((numberOfComparisons-1)*hibbard) + p) > array.length-1)
			{
				numberOfComparisons--;
			}
			
			firstLoop(array, numberOfComparisons, p, 1, hibbard);
			p++;
			shellSort(array, hibbard, p);
		}
	}
	
	/**
		Second recursive method for shell sort, looping itself and
		calling secondLoop() until r equals numberOfComparisons.
	*/
	public static void firstLoop(int[] array, int numberOfComparisons, int p, int r, int hibbard)
	{
		if (r != numberOfComparisons)
		{
			int w = r;
			secondLoop(array, p, w, hibbard);
			r++;
			firstLoop(array, numberOfComparisons, p, r, hibbard);
		}
	}
	/**
		Third and final recursive method for shell sort, looping itself
		until w equals 0. At this point, the elements have been sorted within
		the gap of hibbard.
	*/
	public static void secondLoop(int[] array, int p, int w, int hibbard)
	{
		if (w != 0)
		{
			if (array[(w*hibbard)+p] < array[((w-1)*hibbard)+p]) //If the element is less than the element behind it, swap them.
			{
				int temp = array[((w-1)*hibbard)+p];
				array[((w-1)*hibbard)+p] = array[(w*hibbard)+p];
				array[(w*hibbard)+p] = temp;
				w--;
				secondLoop(array, p, w, hibbard);
			}
		}
	}
	
	//Insertion sorts the array.
	public static void insertionSort(int[] array, int w)
	{
		if (w == array.length - 1) //Base case. If scanning at the end of the array, sort and don't call insertionSort() again.
		{
			checks(array, w);
		}
		else //Recursive case, if not done sorting the array.
		{
			checks(array, w);
			
			w++;
			insertionSort(array, w);
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