/**
	A selective sort algorithm that uses iteration to
	sort an array from low numbers to high numbers.
	@author Kendall Haworth
*/

import java.util.Random;

public class SelectiveIterative
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
		
		//This loop sorts the array from lowest to highest numbers.
		for (int r = 0; r < array.length; r++)
		{
			int minSize = 1000; //These variables must be initialized.
			int temp = -1;
			int location = -1;
			
			//This loop finds the smallest element and "saves" the data and location.
			for (int w = r; w < array.length; w++)
			{
				if (array[w] < minSize)
				{
					minSize = array[w];
					location = w;
				}
			}
			
			//These statements place the smallest value into the first element that has not been sorted.
			temp = array[r];
			array[r] = minSize;
			array[location] = temp;
		}
		
		//This loop prints out the sorted array.
		for (int m = 0; m < array.length; m++)
		{
			System.out.print(array[m] + " ");
		}
	}
}