/** 
	Name: Kendall Haworth
	Date: October 25, 2016
	Assignment: Lab #5, Task 2 (CS140, Section 01)
	
	Create a java program that uses nested for loops to display the following pattern:
	
	1 2 3 4 5 6
	1 2 3 4 5
	1 2 3 4
	1 2 3
	1 2
	1

*/


public class Lab5Task2
{
	public static void main(String[] args)
	{
		final int baseSize = 6; // This could be easily changed here to change the size of the entire pyramid.
		
		for (int i = baseSize; i > 0; i--) // This assigns the variable i the numbers 6 through 1, decrementing it each time the loop runs.
		{
			for (int r = 1; r <= i; r++) // This assigns the variable r 1 through i, incrementing it each time the loop runs.
			{
				System.out.print(r); // This will print r for whatever value it is currently assigned, depending on how many times the loop has run.
				System.out.print(" "); // An added space for additional clarity and visibility.
			}
			System.out.println(); // Once the second for loop finishes, a new line is added to not have every number printed on the same line.
		}
	}
}