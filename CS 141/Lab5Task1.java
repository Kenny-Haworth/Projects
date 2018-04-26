/**
	Name: Kendall Haworth
	Date: October 25, 2016
	Assignment: Lab #5, Task 1 (CS 140, Section 01)
 
	This program calculates the user's BMI using either the metric or
	English system based upon the user's weight and height and issues
	a message based upon it, stating their BMI status. It will then repeat
	as many times as the user wants it to to calculate additional BMI's.
*/

import java.util.Scanner;

public class Lab5Task1
{
	public static void main(String[] args)
	{
		double weight, height; //To hold the user's information.
		int BMI; //To hold the user's calculated BMI.
		String input; //To hold the user's input as a String.
		String charInput; //To hold the user's letter to repeat the program as a string.
		char repeat = 'n'; //To hold 'y', 'Y', 'n', or 'N' to repeat the program.

		Scanner keyboard = new Scanner(System.in); //Creates the Scanner object for keyboard input.
		
		do
		{
			//Ask the user if they want to use the metric or English system to calculate their BMI.
			System.out.println("Do you want to use the English system or the metric system to calculate your BMI?");
			input = keyboard.nextLine();

			//Determine what system the user wants to use using the following if-else statement. Letter case is ignored.
			if (input.equalsIgnoreCase("ENGLISH"))
			{
				System.out.println("What is your weight in pounds?"); //To get the user's weight in pounds.
				weight = keyboard.nextDouble();

				System.out.println("What is your height in inches?"); //To get the user's height in inches.
				height = keyboard.nextDouble();

				BMI = (int)((weight * 703)/(height * height)); //Calculate the user's BMI based on the ENGLISH system.

				if (BMI <= 24)
					System.out.println("Your BMI is " + BMI + ". You are normal.\n");
				else if (BMI <= 29)
					System.out.println("Your BMI is " + BMI + ". You are overweight.\n");
				else if (BMI <= 39)
					System.out.println("Your BMI is " + BMI + ". You are obese!\n");
				else
					System.out.println("Your BMI is " + BMI + ". You are extremely obese!!!\n");
				
				System.out.println("Would you like to calculate another BMI? Enter y or Y to say yes.");
				charInput = keyboard.next(); //This accepts input from the question just asked and assigns it to charInput.
				repeat = charInput.charAt(0); //This gets the first letter of what they just inputted, the first letter of what was assigned to charInput.
				keyboard.nextLine(); //To consume the remaining new line. Without this, if the program repeated it would perform the next action twice.
				
			}
			else if (input.equalsIgnoreCase("METRIC"))
			{
				System.out.println("What is your weight in kilograms?"); //To get the user's weight in kilograms.
				weight = keyboard.nextDouble();
	
				System.out.println("What is your height in meters?"); //To get the user's height in meters.
				height = keyboard.nextDouble();

				BMI = (int)(weight/(height * height)); //Calculate the user's BMI based on the METRIC system.

				if (BMI <= 24)
					System.out.println("Your BMI is " + BMI + ". You are normal.\n");
				else if (BMI <= 29)
					System.out.println("Your BMI is " + BMI + ". You are overweight!\n");
				else if (BMI <= 39)
					System.out.println("Your BMI is " + BMI + ". You are obese!\n");
				else
					System.out.println("Your BMI is " + BMI + ". You are extremely obese!!!\n");
				
				System.out.println("Would you like to calculate another BMI? Enter y or Y to say yes.");
				charInput = keyboard.next(); //This accepts input from the question just asked and assigns it to charInput.
				repeat = charInput.charAt(0); //This gets the first letter of what they just inputted, the first letter of what was assigned to charInput.
				keyboard.nextLine(); //To consume the remaining new line. Without this, if the program repeated it would perform the next action twice.
			}
		}	
		while (repeat == 'Y' || repeat == 'y');
	}
}
