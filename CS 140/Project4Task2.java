/**

	Name: Kendall Haworth
	Class: CS140, Section 01
	Date Due: November 10, 2016
	
	Assignment: Project4, Task2. Write a java program that lets the user play rock,
				paper, scissors against the computer. First, generate the computer's choice,
				then ask the user their choice, then display the computer's choice, then
				declare the winner. Each step must be programmed as a method.

*/

import java.util.Scanner;
import java.util.Random;

public class Project4Task2
{
	public static void main(String[] args)
	{
		int repeat;
		int count = 0;
		final int loop = 0;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to Rock, Paper, Scissors!");
		do
		{
			System.out.println("How many times would you like to play?");
			repeat = keyboard.nextInt();
		
			if (repeat <= 0)
			{
				System.out.println("Please enter a valid number.\n");
				continue;
			}
			else if (repeat > 20)
			{
				System.out.println("You really don't want to play this game more than 20 times. Enter a different number!\n");
			}
			else
			{
				break;
			}
		}
		while (loop == 0);
		
		if (repeat > 1)
		{
			do
			{
				System.out.println("Would you like me to keep count of your wins and losses?");
			}
		}
		
		do
		{
			int computerChoice;
			int userChoice;
			
			computerChoice = computerGenerateNumber(); // Sets the result of computerGenerateNumber() method as the int computerChoice.
			displayMenu();							   // Shows the displayMenu() method.
			userChoice = getUserChoice();			   // Sets the result of getUserChoice() method as the int userChoice.
			displayComputerChoice(computerChoice);	   // Sends computerChoice to the displayComputerChoice() method and displays the computer's choice.
			displayWinner(computerChoice, userChoice); // Sends computerChoice and userChoice to the displayWinner() method and displays the winner.
			count++;
		}
		while (count < repeat);
	}
	
	public static int computerGenerateNumber() // Creates the computer's choice and returns it to the main method.
	{
		int computerChoice;
		
		Random number = new Random(); // Needed for random number class.
		computerChoice = number.nextInt(3) + 1;	// Generates a number from 1-3.
		return computerChoice;	// Returns the int computerChoice that was just generated.
	}
	
	public static void displayMenu() // Displays the menu for the user to choose their options.
	{
		System.out.println();
		System.out.println("||==========================||");
		System.out.println("||   ROCK, PAPER, SCISSORS  ||");
		System.out.println("||==========================||");
		System.out.println("||    CHOOSE YOUR WEAPON    ||");
		System.out.println("||                          ||");
		System.out.println("||      1) ROCK             ||");
		System.out.println("||      2) PAPER            ||");
		System.out.println("||      3) SCISSORS         ||");
		System.out.println("||                          ||");
		System.out.println("||==========================||");
		System.out.println("Enter your number choice: ");
	}
	
	public static int getUserChoice() // Gets the user's choice.
	{
		int userChoice;
		
		do
		{
			Scanner keyboard = new Scanner(System.in);
			userChoice = keyboard.nextInt();
			
			if (userChoice == 1)
			{
				System.out.println("\nYou have chosen ROCK!");
			}
			else if (userChoice == 2)
			{
				System.out.println("\nYou have chosen PAPER!");
			}
			else if (userChoice == 3)
			{
				System.out.println("\nYou have chosen SCISSORS!");
			}
			else // If userChoice is not 1, 2, or 3 an error is displayed and the question loops and is asked again.
			{
				userChoice = 0;
				System.out.println();
				System.out.println("Error, invalid number. Enter 1, 2, or 3: ");
			}
		}
		while (userChoice == 0); //Will continue to loop as long as the user's input is invalid.
		return userChoice;	// Returns userChoice to the main method.
	}
	
	public static void displayComputerChoice(int computerChoice) // Shows the computer's choice.
	{
		if (computerChoice == 1)
		{
			System.out.println("The computer has chosen ROCK!");
		}
		else if (computerChoice == 2)
		{
			System.out.println("The computer has chosen PAPER!");
		}
		else if (computerChoice == 3)
		{
			System.out.println("The computer has chosen SCISSORS!");
		}
	}
	
	public static void displayWinner(int computerChoice, int userChoice) // Displays the winner, sending computerChoice and userChoice to the
	{																	 // displayWinner() method from the main method.
		if (computerChoice == 1 && userChoice == 1)
		{
			System.out.println("Both players chose ROCK! It's a tie!");
		}
		else if (computerChoice == 2 && userChoice == 2)
		{
			System.out.println("Both players chose PAPER! It's a tie!");
		}
		else if (computerChoice == 3 && userChoice == 3)
		{
			System.out.println("Both players chose SCISSORS! It's a tie!");
		}
		else if (userChoice == 1 && computerChoice == 2)
		{
			System.out.println("PAPER folds ROCK! You lose!");
		}
		else if (userChoice == 1 && computerChoice == 3)
		{
			System.out.println("ROCK crushes SCISSORS! You win!");
		}
		else if (userChoice == 2 && computerChoice == 1)
		{
			System.out.println("PAPER folds ROCK! You win!");
		}
		else if (userChoice == 2 && computerChoice == 3)
		{
			System.out.println("SCISSORS cuts PAPER! You lose!");
		}
		else if (userChoice == 3 && computerChoice == 1)
		{
			System.out.println("ROCK crushes SCISSORS! You lose!");
		}
		else if (userChoice == 3 && computerChoice == 2)
		{
			System.out.println("SCISSORS cuts PAPER! You win!");
		}
	}
}