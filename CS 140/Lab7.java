/**

	Name: Kendall Haworth
	Class: CS140, Section 01
	Date Due: Novemeber 17, 2016
	
	Assignment: Lab6 - Write a program that simulates a lottery. Your program should have an array
					   of five integers named lotteryNumbers. Use the Random class to generate a
					   random number in the range of 0 through 9 for each element in the array.
					   Your program should either read in five integers that represent a person’s
					   lottery picks or let the computer to select numbers for the user. The program
					   should then display the number of digits that match the lottery numbers.
				
*/

import java.util.Scanner;
import java.util.Random;

public class Lab7
{
	public static void main (String[] args)
	{
		int[] inputLotteryNumbers = new int[5]; // For the array holding the user's choice of lottery numbers, or to generate them one.
		int[] generatedLotteryNumbers;			// For the array of the winning lottery number, or the computer's.
		int input;	// To hold the user's choice.
		int count;	// To hold how many numbers are the same between both lottery numbers.
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("||------------------------------------||");
		System.out.println("||      Welcome to Play Lottery!      ||");
		System.out.println("||------------------------------------||");
		System.out.println("||                                    ||");
		System.out.println("||      1) Enter your own             ||");
		System.out.println("||         lottery number             ||");
		System.out.println("||                                    ||");
		System.out.println("||      2) Quick Pick                 ||");
		System.out.println("||         (computer generated)       ||");
		System.out.println("||         lottery number             ||");
		System.out.println("||                                    ||");
		System.out.println("||------------------------------------||");

		do
		{
			System.out.println("       Enter your number choice:        ");
			input = keyboard.nextInt();
		
			if (!(input == 1 || input == 2))
			{
				System.out.println("Error, please enter a valid number.");
			}
		}
		while (!(input == 1 || input == 2)); // Loops as long as input is invalid.
		
		if (input == 1) // This if statement uses the user's lottery number compared to the generated one.
		{
			System.out.println("\nEnter 5 single-digit numbers, each separated by a space: ");
			for (int i = 0; i < inputLotteryNumbers.length; i++)	// The for loop gets each inputted number and sets it equal
			{														// to the subscripted number in the array.
				inputLotteryNumbers[i]=keyboard.nextInt();
			}
			
			generatedLotteryNumbers = generatedLotteryNumber(); // Refences the method to generate an array for computers lottery number.
			System.out.println("\nThe Winning Lottery Number is: ");
			System.out.print("        ");
			for (int number : generatedLotteryNumbers)	// This for statement will print out each subscript in the generated array.
			{
				System.out.print(number + " ");
			}
			
			System.out.println("\nYour Lottery Number is: "); // This for statement will print out each subscript in the inputted array.
			System.out.print("        ");
			for (int value : inputLotteryNumbers)
			{
				System.out.print(value + " ");
			}
			
			count = compareNumbers(inputLotteryNumbers, generatedLotteryNumbers); // References the method that compares the lottery numbers and returns
			System.out.println("\nThere are " + count + " matching digits.");	  // the number of times the numbers match.
			if (count == 5)		// Displays a congratulations message if you win.
			{
				System.out.println("Congratulations!! You win!!!!");
				System.out.println("There was a 1 in 100,000 chance of you getting that! Cheater.");
			}
		}
		else if (input == 2) // This else if statement generates the user a random lottery number to compare to the winning one.
		{
			generatedLotteryNumbers = generatedLotteryNumber(); // Refences the method to generate an array for computer's lottery numbers.
			System.out.println("\nThe Winning Lottery Number is: "); // This for statement will print out each subscript in the computer's generated array.
			System.out.print("        ");
			for (int number : generatedLotteryNumbers)
			{
				System.out.print(number + " ");
			}
			
			inputLotteryNumbers = generatedLotteryNumber(); // Refences the method to generate an array for user's lottery numbers.
			System.out.println("\nYour Lottery Number is: ");
			System.out.print("        ");
			for (int value : inputLotteryNumbers) // This for statement will print out each subscript in the user's generated array.
			{
				System.out.print(value + " ");
			}
			
			count = compareNumbers(inputLotteryNumbers, generatedLotteryNumbers); // References the method that compares the lottery numbers and returns
			System.out.println("\nThere are " + count + " matching digits.");	  // the number of times the numbers match.
			if (count == 5)		// Displays a congratulations message if you win.
			{
				System.out.println("Congratulations!! You win!!!!");
				System.out.println("There was a 1 in 100,000 chance of you getting that! Cheater.");
			}
			
		}
	}
	
	public static int[] generatedLotteryNumber() // This method generates a random lottery number and returns it.
	{
		int[] lotteryNumbers = new int[5]; // Defines an array to generate with 5 numbers.
		Random generate = new Random();
		
		for (int q = 0; q < lotteryNumbers.length; q++) // This for loop will continue until each number in the array is filled.
		{
			lotteryNumbers[q]=generate.nextInt(10); // Generates a random number in the range of 0 to 9 and sets it equal to each subscript.
		}
		
		return lotteryNumbers; // Sends the generated array back to the main method.
	}
	
	public static int compareNumbers (int[] inputLotteryNumbers, int[] generatedLotteryNumbers) // This method compares the number of same lottery numbers.
	{
		int count = 0;	// Initializes the number of same lottery numbers to 0.
		for (int r = 0; r < inputLotteryNumbers.length; r++)	// This for loop will continue as long as there are more numbers in the array to read.
		{
			if (generatedLotteryNumbers[r] == inputLotteryNumbers[r])	// If the same subscript of each array holds the same number, count is incremented.
			{															// If not, the loop continues until it is finished.
				count++;
			}
			else
			{
				continue;
			}
		}
		return count; // Returns count to the main method.
	}
}