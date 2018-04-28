/**
	A merge sort algorithm that uses recursion to
	sort an array from low numbers to high numbers.
	@author Kendall Haworth
*/

import java.util.Random;

public class MergeRecursive
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
		
		mergeSort(array, 0, array.length-1); //Call the method to sort the array.
		
		//This loop prints out the sorted array.
		for (int m = 0; m < array.length; m++)
		{
			System.out.print(array[m] + " ");
		}
	}
	
	//This method sorts the array using merge sort
	public static void mergeSort(int[] array, int first, int last)
	{
		if (first < last) //If the array has more than one element, split it up more.
		{
			int midpoint = (first + last)/2;
			mergeSort(array, first, midpoint); //The left half of the array to be split up more
			mergeSort(array, midpoint+1, last); //The right half of the array to be split up more
			merge(array, first, midpoint, last); //Merge the array together
		}
	}

	public static void merge(int[] array, int first, int midpoint, int last)
	{
		int firstHalf = midpoint - first + 1; //Define the size of the left half
		int secondHalf = last - midpoint; //Define the size of the right half
		
		int[] left = new int[firstHalf]; //Create a new array to hold the left sorted half
		int[] right = new int[secondHalf]; //Create a new array to hold the right sorted half
		
		for(int i = 0; i < firstHalf; i++) //Add the elements to the left half of the array
		{
			left[i] = array[first + i];
		}
		
		for(int i = 0; i < secondHalf; i++) //Add the elements to the right half of the array
		{
			right[i] = array[midpoint + 1 + i];
		}

		int leftPointer = 0;
		int rightPointer = 0;
		int index = first;
		
		while(leftPointer < firstHalf && rightPointer < secondHalf) //Loops as long as there are more elements to sort
		{
			if(left[leftPointer] <= right[rightPointer]) //If the left element is less than the right element,
			{											//add the left element to the array and increment the left pointer
				array[index] = left[leftPointer];
				leftPointer++;
			}
			else									//If the right element is less than the left element,
			{										//add the right element to the array and increment the right pointer
				array[index] = right[rightPointer];
				rightPointer++;
			}
			index++;
		}

		while(leftPointer < firstHalf) //If there are more elements in the left side, add them to the array
		{
			array[index] = left[leftPointer];
			leftPointer++;
			index++;
		}

		while(rightPointer < secondHalf) //If there are more elements in the right side, add them to the array
		{
			array[index] = right[rightPointer];
			rightPointer++;
			index++;
		}
	}
}