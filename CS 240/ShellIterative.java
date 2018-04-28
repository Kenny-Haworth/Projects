/**
	A shell sort algorithm that uses iteration to
	sort an array from low numbers to high numbers.
	@author Kendall Haworth
*/

import java.util.Random;

public class ShellIterative
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
		
		//This loop unscrambles values to make the insertion sort faster afterwords.
		int hibbard = 3;
		for (int p = 0; p < hibbard; p++)
		{
			int numberOfComparisons = (array.length/hibbard) + 1;
			if ((((numberOfComparisons-1)*hibbard) + p) > array.length-1)
			{
				numberOfComparisons--;
			}
			
			for (int r = 1; r < numberOfComparisons; r++)
			{
				for (int w = r; w > 0; w--)
				{
					if (array[(w*hibbard)+p] < array[((w-1)*hibbard)+p]) //If the element is less than the element behind it, swap them.
					{
						int temp = array[((w-1)*hibbard)+p];
						array[((w-1)*hibbard)+p] = array[(w*hibbard)+p];
						array[(w*hibbard)+p] = temp;
					}
					else //If it's greater than or equal to the element in front of it,
					{				//it is sorted up to that element and can break out of the second for loop.
						break;
					}
				}
			}
		}
		
		//This loop performs insertion sort.
		for (int b = 1; b < array.length; b++)
		{
			for (int n = b; n > 0; n--)
			{
				if (array[n] < array[n-1]) //If the element is less than the element in front of it, swap them.
				{
					int temp = array[n-1];
					array[n-1] = array[n];
					array[n] = temp;
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