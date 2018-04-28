/**
	A quick sort algorithm that uses recursion to
	sort an array from low numbers to high numbers.
	@author Kendall Haworth
*/

import java.util.Random;

public class QuickRecursive
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
		
		quickSort(array, 0, array.length-1);
		
		//This loop prints out the sorted array.
		for (int m = 0; m < array.length; m++)
		{
			System.out.print(array[m] + " ");
		}
	}
	
	public static void quickSort(int[] array, int leftPointer, int rightPointer)
	{
		if (leftPointer < rightPointer) //Base case, if leftPointer equals rightPointer, sorting is complete
		{
			int pivotPoint = sort(array, leftPointer, rightPointer); //sorts the array and returns the pivot position
			quickSort(array, leftPointer, pivotPoint - 1); //left side of array to be sorted
			quickSort(array, pivotPoint + 1, rightPointer); //right side of array to be sorted
		}
	}
	
	public static int sort(int[] array, int leftPointer, int rightPointer) //Sorts the array according to the pointers and a pivot
	{
		int pivot = array[rightPointer];
		int index = leftPointer - 1;
		
		index = swap(array, rightPointer, leftPointer, index, pivot); //Sorts the array about the pivot and returns the index.
		
		//Swap the first element greater than the pivot with the pivot.
		array[rightPointer] = array[index + 1];
		array[index + 1] = pivot;
		
		return index + 1; //return the location of the pivot
	}
	
	//Performs checks and swaps until the array has been sorted about the pivot.
	public static int swap(int[] array, int rightPointer, int q, int index, int pivot)
	{
		if (array[q] <= pivot) //Swap elements if they are less than the pivot.
		{
			index++;
				
			int temp = array[index];
			array[index] = array[q];
			array[q] = temp;
		}
		
		q++;
		
		if (q != rightPointer) //When q < rightPointer, more checking and swapping needs to be performed
		{
			index = swap(array, rightPointer, q, index, pivot);
		}

		return index;
	}
}