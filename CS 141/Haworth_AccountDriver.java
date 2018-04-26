/***************************************************************
* File: Haworth_AccountDriver.java
* Author: Kendall Haworth
* class: CS 141 – Programming and Problem Solving
*
* Assignment: Program 5
* Date Last Modified: 2/24/2017
*
* Purpose: This program creates Haworth_BankAccount and
* Haworth_ExtendsAbstract objects, allows interaction with
* them, and acts as the main driver for all three java files.
*
****************************************************************/ 

import java.util.Scanner;

public class Haworth_AccountDriver
{
	public static void main(String[] args)
	{
		Haworth_ExtendsAbstract account1 = new Haworth_ExtendsAbstract(100, 12); // Creates and initializes a Haworth_BankAccount object
		Haworth_SavingsAccount account2 = new Haworth_SavingsAccount(200, 12); // Creates and initializes a Haworth_SavingsAccount object

		boolean runtime = true; // Controls the runtime for the program
		String input;
		String innerInput;
		double withdrawAmount;
		double depositAmount;
		Scanner keyboard = new Scanner(System.in);
		
		do
		{
			System.out.println();
			System.out.println("Which account would you like to access, regular or savings?");
			input = keyboard.nextLine();
			
			if (input.equalsIgnoreCase("REGULAR"))
			{
				System.out.println("What action do you wish to perform (withdraw, deposit, monthly processing)?");
				innerInput = keyboard.nextLine();
				
				if (innerInput.equalsIgnoreCase("WITHDRAW"))
				{
					System.out.println("Enter amount to withdraw:");
					withdrawAmount = keyboard.nextDouble();
					
					if (withdrawAmount < 0)
					{
						System.out.println("You cannot withdraw a negative number.");
					}
					else
					{
						account1.withdraw(withdrawAmount);
						System.out.printf("Account balance is $%.2f.", account1.getBalance());
					}
					keyboard.nextLine();
				}
				else if (innerInput.equalsIgnoreCase("DEPOSIT"))
				{
					System.out.println("Enter amount to deposit:");
					depositAmount = keyboard.nextDouble();
					
					if (depositAmount < 0)
					{
						System.out.println("You cannot deposit a negative number.");
					}
					else
					{
						account1.deposit(depositAmount);
						System.out.printf("Account balance is $%.2f.", account1.getBalance());
					}
					keyboard.nextLine();
				}
				else if (innerInput.equalsIgnoreCase("MONTHLY PROCESSING"))
				{
					account1.monthlyProcess();
					System.out.printf("Account balance is $%.2f.", account1.getBalance());
				}
				else
				{
					System.out.println("Command not recognized.");
					System.out.println("Please only insert \"withdraw\", "
										+ "\"deposit\", or \"monthly processing\".");
				}
			}
			else if (input.equalsIgnoreCase("SAVINGS"))
			{
				System.out.println("What action do you wish to perform (withdraw, deposit, monthly processing)?");
				innerInput = keyboard.nextLine();
				
				if (innerInput.equalsIgnoreCase("WITHDRAW"))
				{
					System.out.println("Enter amount to withdraw:");
					withdrawAmount = keyboard.nextDouble();
					
					if (withdrawAmount < 0)
					{
						System.out.println("You cannot withdraw a negative number.");
					}
					else
					{
						account2.withdraw(withdrawAmount);
						System.out.printf("Account balance is $%.2f.", account2.getBalance());
					}
					keyboard.nextLine();
				}
				else if (innerInput.equalsIgnoreCase("DEPOSIT"))
				{
					System.out.println("Enter amount to deposit:");
					depositAmount = keyboard.nextDouble();
					
					if (depositAmount < 0)
					{
						System.out.println("You cannot deposit a negative number.");
					}
					else
					{
						account2.deposit(depositAmount);
						System.out.printf("Account balance is $%.2f.", account2.getBalance());
					}
					keyboard.nextLine();
				}
				else if (innerInput.equalsIgnoreCase("MONTHLY PROCESSING"))
				{
					account2.monthlyProcess();
					System.out.printf("Account balance is $%.2f.", account2.getBalance());
				}
				else
				{
					System.out.println("Command not recognized.");
					System.out.println("Please only insert \"withdraw\", "
										+ "\"deposit\", or \"monthly processing\".");
				}
			}
			else
			{
				if (Character.toLowerCase(input.charAt(0)) == 'q') // If the user enters a String starting with q or Q, the program ends
				{
					runtime = false;
				}
				else
				{
					System.out.println("That command was not recognized.");
					System.out.println("Please only insert \"regular\" or "
										+ "\"savings account\".");
				}
			}
		}
		while (runtime); // The program will loop as long as runtime is true
	}
}