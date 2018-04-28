/**
	An insertion sort algorithm that uses iteration to
	sort an array from low numbers to high numbers.
	@author Kendall Haworth
*/

import java.util.Random;

public class InsertionIterative
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
		
		//This loop cycles through each element starting with one to sort the array.
		for (int r = 1; r < array.length; r++)
		{
			for (int w = r; w > 0; w--)
			{
				if (array[w] < array[w-1]) //If the element is less than the element in front of it, swap them.
				{
					int temp = array[w-1];
					array[w-1] = array[w];
					array[w] = temp;
				}
				else //If it's greater than or equal to the element in front of it,
				{				//it is sorted up to that element and can break out of the second for loop.
					break;
				}
			}
		}
		
		//This loop prints out the sorted array.
		for (int m = 0; m < array.length; m++)
		{
			System.out.print(array[m] + " ");
		}
	}
}