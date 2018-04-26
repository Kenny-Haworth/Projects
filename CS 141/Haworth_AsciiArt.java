/***************************************************************
* File: Haworth_AsciiArt.java
* Author: Kendall Haworth
* Class: CS 141-01 – Intro to Programming and Problem Solving
*
* Assignment: Program 3
* Date last modified: 29/1/17
*
* Purpose: This program creates a 2D array from reading a text file
* and traverses the rows and columns vertically, horizontally, and diagonally.
* 
****************************************************************/

import java.io.*;
import java.util.Scanner;

public class Haworth_AsciiArt
{
	public static void main(String[] args) throws IOException
	{	
		File input = new File("blinkers.life");
		
		Scanner inputData = new Scanner(input); //Reads in a file and creates a Scanner class to read it into the array.
		
		int row = inputData.nextInt();
		int column = inputData.nextInt();
	
		char[][] array = new char[row][column]; //Creates a 2D array with the size determined
												//by the first two numbers of the text file.
		inputData.nextLine();
		
		while (inputData.hasNext())			//This while loop fills the 2D array
		{									//with the information from the text file.
			for (int q = 0; q < row; q++)
			{	
				String cheese = inputData.nextLine();
				
				for (int w = 0; w < column; w++)
				{
					array[q][w] = cheese.charAt(w);
				}
			}
		}
		
		System.out.println("\nOriginal Text:\n");
		
		for (int r = 0; r < row; r++)
		{
			for (int c = 0; c < column; c++)
			{
				System.out.print(array[r][c]);
			}
			System.out.println();
		}
		
		System.out.println("\nTransformations: \n");
		
		for (int m = row-1; m >= 0; m--) 		//Reverses the rows to create a horizontal transformation
		{										//by starting with the last row and decrementing.	
			for (int o = 0; o < column; o++)
			{
				System.out.print(array[m][o]);
			}
			System.out.println();
		}
		
		System.out.println();			//Creates a vertical transformation by starting with the
										//last column and decrementing it.
		for (int p = 0; p < row; p++)
		{
			for (int l = column-1; l >= 0; l--)
			{
				System.out.print(array[p][l]);
			}
			System.out.println();
		}
		
		System.out.println();					//Creates a horizontal transformation by starting with
												//the last row and column and decrementing them.
		for (int co = column-1; co >= 0; co--)
		{
			for (int ro = row-1; ro >= 0; ro--)
			{
				System.out.print(array[ro][co]);
			}
			System.out.println();
		}
	}
}