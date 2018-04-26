/**
	Name: Kendall Haworth
	Date: October 25, 2016
	Assignment: Lab #5, Task 3 (CS140, Section 01)

	Create a java program that uses nested for loops to display a hollow square
	of a size between 1 and 20, depending on what the user inputs.

*/

import java.util.Scanner;

public class Lab5Task3
{
	public static void main(String[] args)
	{
		int n; // Defines n as a whole number.
		
		Scanner keyboard = new Scanner(System.in); // To create the Scanner class for input.
		
		do // This do-while loop ensures the input entered for n is within the range of 1 and 20.
		{
			System.out.println("Enter a number in the range of 1 and 20."); // Asks for n.
			n = keyboard.nextInt(); // Assigns the number the user enters to n.
		
			if (n < 1 || n > 20)
			{
				System.out.println("Error, try again."); // Tests first to see if n is within the range, and if not displays an error.
			}
		}
		while (n < 1 || n > 20); // If n is within the range the program continues. If not, the user must re-enter a correct number.
		
		for (int rows = 0; rows < n; rows++) // The first for loop increments "rows" as many times as necessary until it is less than n, the inputted variable, to create n number of rows.
		{
			for (int col = 0; col < n; col++) // The second for loop increments "col" as many times as necessary until it is less than n.
			{
				if (col == 0 || col == (n-1)) // The first and last columns must always have an *, so this ensures "*" will always be printed if that is the case. This is tested first.
				{
					System.out.print("*");
				}
				else if (rows == 0 || rows == (n-1)) // The first and last row must always be filled with *, so this ensures "*" will always be printed if that is the case. This is tested second.
				{
					System.out.print("*");
				}
				else // In any other case, if the row or column is neither the first nor the last, a space should be printed to create the hollow part inside the square.
				{
					System.out.print(" ");
				}
			}
			System.out.println(); // This advances the output to a new line each time after the second for loop has fully executed to separate each line in the square.
		}
	}
}