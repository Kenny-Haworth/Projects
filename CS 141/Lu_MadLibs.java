/**********************************************************
*	file: Lu_MadLibs.java
*	author: Kevin Lu
*	class: CS 140 - Introduction to Computer Science
*
*	assignment program 4
*	date last modified: 5/9/2017
*
*	purpose: This program accepts user inputs to fill in blanks in a 
*	story.
*
******************************************************/

import java.util.Scanner;
import java.io.*;

public class Lu_MadLibs
{
	public static void main (String []args) throws IOException //method: main
	{
		Scanner keyboard = new Scanner(System.in); // method: keyboard input

		System.out.println("Enter a file name: "); //Get file name
		String file = keyboard.nextLine();
		
		File wu = new File(file);
		Scanner inputFile = new Scanner(wu);

		int count = inputFile.nextInt();
		inputFile.nextLine();
		
		PrintWriter output = new PrintWriter("outputFile30.txt");
		
		for (int q = 0; q < count; q++)
		{
			System.out.println(inputFile.nextLine());
			String input = keyboard.nextLine();
			output.println(input);
			System.out.println();
		}
		
		output.close();
		
		File hu = new File("outputFile30.txt");
		Scanner haworth = new Scanner(hu);
		
		for (int r = 0; r <= count; r++)
		{
			System.out.print(inputFile.nextLine());
			
			if (r != count)
			{
				System.out.print(haworth.nextLine());
			}
		}
		
		inputFile.close();
		haworth.close();
	}
}
