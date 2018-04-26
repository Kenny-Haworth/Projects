//Name: Kendall Haworth
//Date: October 6, 2016
//Assignment: Lab #3 (CS 140)

import java.util.Scanner;

/** 
	This program calculates the user's BMI using either the metric or
	English system based upon the user's weight and height and issues
	a message based upon it, stating their BMI status.
*/

public class Lab3
{
	public static void main(String[] args)
	{
		double weight, height; //To hold the user's information.
		int BMI; //To hold the user's calculated BMI.
		String input; //To hold the user's input as a String.

		Scanner keyboard = new Scanner(System.in); //Creates the Scanner object for keyboard input.

		//Ask the user if they want to use the metric or English system to calculate their BMI.
		System.out.println("Do you want to use the English system or the metric system to calculate your BMI?");
		input = keyboard.nextLine();

		//Determine what system the user wants to use using the following if-else statement. Ensure letter case is ignored.
		if (input.equalsIgnoreCase("ENGLISH"))
		{
			System.out.println("What is your weight in pounds?"); //To get the user's weight in pounds.
			weight = keyboard.nextDouble();

			System.out.println("What is your height in inches?"); //To get the user's height in inches.
			height = keyboard.nextDouble();

			BMI = (int)((weight * 703)/(height * height)); //Calculate the user's BMI based on the ENGLISH system.

			if (BMI <= 24)
				System.out.println("Your BMI is " + BMI + ". You are normal.");
			else if (BMI <= 29)
				 System.out.println("Your BMI is " + BMI + ". You are overweight.");
			else if (BMI <= 39)
				 System.out.println("Your BMI is " + BMI + ". You are obese!");
			else
				 System.out.println("Your BMI is " + BMI + ". You are extremely obese!!!");
		}
		else if (input.equalsIgnoreCase("METRIC"))
		{
			System.out.println("What is your weight in kilograms?"); //To get the user's weight in kilograms.
			weight = keyboard.nextDouble();

			System.out.println("What is your height in meters?"); //To get the user's height in meters.
			height = keyboard.nextDouble();

			BMI = (int)(weight/(height * height)); //Calculate the user's BMI based on the METRIC system.

			if (BMI <= 24)
				System.out.println("Your BMI is " + BMI + ". You are normal.");
			else if (BMI <= 29)
				System.out.println("Your BMI is " + BMI + ". You are overweight!");
			else if (BMI <= 39)
				System.out.println("Your BMI is " + BMI + ". You are obese!");
			else
				System.out.println("Your BMI is " + BMI + ". You are extremely obese!!!");
		}
	}
}
