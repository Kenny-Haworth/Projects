/**

	Name: Kendall Haworth
	Class: CS140, Section 01
	Date Due: Novemeber 29, 2016
	
	Assignment: Project 4 - Create a java program that reads a file containing the days in a month
				and a list of double values containing the average temperature. Display the original
				data and the highest, lowest, and average temperature. Terminate the program if the
				file does not exist.

*/

import java.util.Scanner;
import java.io.*;

public class Project5
{
	public static void main(String[] args) throws IOException
	{
		double[] array;
		char degrees = '\u00B0'; // This is the unicode for a degree symbol.

		array = inputData(); // Gets the array from the text file.
		printArray(array); // Prints the array.
		double average = average(array); // Calculates the average value of the array.
		System.out.printf("The average temperature was %.1f" + degrees + "F degrees.", average); // %.1f keeps the result rounded to one decimal place.
		double max = max(array); // Calculates the maximum value of the array.
		System.out.printf("\nThe highest temperature was %.1f" + degrees + "F degrees.", max);
		double min = min(array); // Calculates the minimum value of the array.
		System.out.printf("\nThe lowest temperature was %.1f" + degrees + "F degrees.\n", min);
		selectionSort(array); // Sorts the array into ascending order.
		
		System.out.println("\nValues sorted in ascending order: ");
		for (int q = 0; q < array.length; q++) // Prints the ascending array.
		{		
			if (q % 10 == 0 && !(q == 0))
			{
				System.out.println();
			}
			System.out.printf("%.1f ", array[q]);
		}
	}
	
	public static double[] inputData() throws IOException
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.println("\nEnter the input file name: "); // Asks for the input file.
		String input = keyboard.nextLine();
			
		File inputInfo = new File(input);
			
		if (!inputInfo.exists()) // Checks if the file exists.
		{
			System.out.println("\nThe file " + input + " does not exist, or was not found in the location specified. The system will now shutdown.");
			System.exit(0);
		}
		Scanner inputFile = new Scanner(inputInfo); // Creates the Scanner class to read input from the file.
		
		int month = inputFile.nextInt();
		double[] array = new double[month]; // Sets the size of the array equal to the first number in the text file on the first line.
		
		for (int i = 0; i < array.length; i++) // Puts values in the array for as long as the array is, according to the first number in the text file.
		{
			array[i] = inputFile.nextDouble();
		}
		inputFile.close(); // Closes the file.
		
		return array;
	}
	
	public static void printArray(double[] array)
	{
		System.out.println("\nOriginal Array: ");
		for (int q = 0; q < array.length; q++) // Prints the original array out. After every ten numbers a new line is made.
			{		
				if (q % 10 == 0 && !(q == 0))
				{
					System.out.println();
				}
				System.out.printf("%.1f ", array[q]);
			}
		System.out.println("\n");
	}
	
	public static double average(double[] array) // Calculates and returns the average value.
	{
		double average;
		double total = 0;
		
		for (int r = 0; r < array.length; r++)
		{
			total += array[r];
		}
		average = total/array.length;
		
		return average;
	}
	
	public static double max(double[] array)
	{
		double max = -1;
		for (int s = 0; s < array.length; s++) // Searches each number in the array. If it's greater than the current max, it replaces it.
		{
			if (max < array[s])
			{
				max = array[s];
			}
		}
		return max;
	}
	
	public static double min(double[] array) // Searches each number in the array. If it's less than the current minimum, it replaces it.
	{
		double min = array[0];
		for (int p = 1; p < array.length; p++)
		{
			if (min > array[p])
			{
				min = array[p];
			}
		}
		return min;
	}
	
	public static void selectionSort (double[] array) // Implements selection sort to sort the array from highest to lowest.
	{                                                 // It reads the entire array and switches the lowest number with the first placement number,
		int control;                                  // then the next lowest with the second, and so on until they have all been sorted.
		int placement;
		int value;
		double minValue;
		
		for (control = 0; control < (array.length-1); control++)
		{
			value = control;
			minValue = array[control];
			for (placement = control + 1; placement < array.length; placement++)
			{
				if (array[placement] < minValue)
				{
					minValue = array[placement];
					value = placement;
				}
			}
			array[value] = array[control];
			array[control] = minValue;
		}
	}
}