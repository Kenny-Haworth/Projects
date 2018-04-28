/**
	A radix sort algorithm that uses recursion to
	sort an array from low numbers to high numbers.
	@author Kendall Haworth
*/

import java.util.Random;

public class RadixRecursive
{
	public static void main(String[] args)
	{
		int[] array = new int[10];
		int[] temp = new int[array.length];
		
		Random randomObj = new Random();
		
		//This loop fills each element of the array with random numbers.
		for (int q = 0; q < array.length; q++)
		{
			array[q] = randomObj.nextInt(1000);
			System.out.print(array[q] + " ");
		}
		
		System.out.println();
		
		radixSort(array, temp); //Sort the array using radix sort.
		
		//This loop prints out the sorted array.		
		for (int v = 0; v < temp.length; v++)
		{
			System.out.print(temp[v] + " ");
		}
	}
	
	//Sort the array using radix sort.
	public static void radixSort(int[] array, int[] temp)
	{
		sortFirst(array, temp, 0, 0, 0); //Sorts the 1's place
		sortSecond(array, temp, 0, 0, 0); //Sorts the 10's place
		sortThird(array, temp, 0, 0, 0); //Sorts the 100's place
	}
	
	//Sorts the items according to the 1's place based upon the temporary array and stores it in the temporary array
	public static void sortFirst(int[] array, int[] temp, int m, int q, int i)
	{
		if (array[q]%10 == i)
		{
			temp[m] = array[q];
			m++;
		}
		
		q++;
				
		if (q == array.length)
		{
			q = 0;
			i++;
		}
				
		if (i != 10)
		{
			sortFirst(array, temp, m, q, i);
		}
	}
	
	//Sorts the items in the 10's places based upon the temporary array and stores it back in the array
	public static void sortSecond(int[] array, int[] temp, int z, int q, int i)
	{
		if (((temp[q]%100)/10) == i)
		{
			array[z] = temp[q];
			z++;
		}
		
		q++;
				
		if (q == array.length)
		{
			q = 0;
			i++;
		}
				
		if (i != 10)
		{
			sortSecond(array, temp, z, q, i);
		}
	}
	
	//Sorts the items according to the 100's place based upon the temporary array and stores it in the temporary array
	public static void sortThird(int[] array, int[] temp, int b, int q, int i)
	{
		if ((array[q]/100) == i)
		{
			temp[b] = array[q];
			b++;
		}
		
		q++;
				
		if (q == array.length)
		{
			q = 0;
			i++;
		}
				
		if (i != 10)
		{
			sortThird(array, temp, b, q, i);
		}
	}
}