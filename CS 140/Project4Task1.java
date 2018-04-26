/**

	Name: Kendall Haworth
	Class: CS140, Section 01
	Date Due: November 10, 2016
	
	Assignment: Project4, Task1. Create a java program that asks for a number greater
				than or equal to 2 and tells whether it is prime or not using the method
				isPrime. If invalid input, ask again 3 times and after the third time exit
				the program. The isPrime method should return a boolean value.

*/

import java.util.Scanner;

public class Project4Task1
{
	public static void main(String[] args)
	{
		int input; // To hold the inputted number.
		int count = 0; // To count the number of invalid numbers entered.
		
		Scanner keyboard = new Scanner(System.in); // Needed for keyboard input.
		
		do
		{
			System.out.println("Enter a number greater than or equal to 2:");
			input = keyboard.nextInt(); // Gets the number.
				
			if (input < 2)
			{
				count++; // Increments count each time invalid number is entered.
				
				if (count == 3) // The third time an invalid number is entered, the system will display an error message and shutdown.
				{
					System.out.println("\nInvalid number entered too many times. The system will now shutdown.");
					System.exit(0);
				}
				else
				{
					System.out.println("\nError, please enter a valid number.");
				}
			}
		}
		while (input < 2); // Will loop as long as input is invalid.
		
		if (isPrime(input)) // References the isPrime method with the user's input which returns "true" or "false" for the number.
		{
			System.out.println("\nTrue, number is prime");
		}
		else
		{
			System.out.println("\nFalse, number is not prime.");
		}
	}
	
	public static boolean isPrime(int input) // The isPrime method with "input" sent to it.
	{
		boolean prime = false; // Declares and initializes the return boolean variable.
		int calculate; // To hold a simple math calculation to show what the number is divisible by if it's not prime
		
		if (input == 2 || input == 3 || input == 5) // Easy cases which will immediately return "true".
		{
			prime = true;
		}
		else
		{
			for (int i = 2; i < input; i++) // This loop checks every number in the range of 2 to the inputted number and tries to divide it evenly.
			{								// If it does divide evenly, the number is not prime. Every number needs to be checked besides 1 and the number
				if (input % i == 0)			// because a number is only prime if it divides only into itself and 1 evenly.
				{
					System.out.println();
					System.out.print(input + " is divisible by " + i + ". ");				// Tells the user what their number is divisible by.
					calculate = (input/i);													// Divides the actual number into it.
					System.out.print("(" + input + "/" + i + ") = " + calculate + ".");		// Displays the calculation.
					prime = false;
					break;			// Exits the loop, now that the number is found to not be prime.
				}
				else
				{
					prime = true; // If each iteration of the previous if statement is false, the number is prime.
				}
			}
		}
		return prime; // Returns the boolean prime to the main method.
	}
}