/***************************************************************
* File: Haworth_Decoder.java
* Author: Kendall Haworth
* Class: CS 141-01 – Intro to Programming and Problem Solving
*
* Assignment: Program 1
* Date last modified: 11/1/17
*
* Purpose: This program takes a text file that consists of a sentence and numbers
* and uses the numbers to create an index of the characters in the sentence to reveal
* a "hidden" message.
*
****************************************************************/

import java.util.Scanner;

public class Haworth_Decoder
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in); // Creates the scanner class.
		
		String string = keyboard.nextLine(); // Pulls the first sentence and sets it as a string.
		
		System.out.print("\nYour secret message is: ");
		
		while(keyboard.hasNextInt()) // Will continue to loop as long as there are more integers to be read in.
		{
			System.out.print(string.charAt(keyboard.nextInt())); // Prints the character at the indicated number location in the string.
		}
	}
}