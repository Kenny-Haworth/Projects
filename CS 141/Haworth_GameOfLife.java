/***************************************************************
* File: Haworth_GameOfLife.java
* Author: Kendall Haworth
* Class: CS 141-01 – Intro to Programming and Problem Solving
*
* Assignment: Program 6
* Date last modified: 3/10/17
*
* Purpose: This proram simulates Conway's Game of Life
* using a 2D array, asking the user for how many generations to display.
* 
****************************************************************/

import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Haworth_GameOfLife
{
	int rows;		//Declares global variables accessible to all the methods
	int columns;
	char[][] array;
	char[][] temporary;
	int count = 1;
	
	public static void main (String[] args) throws IOException
	{	
		Scanner keyboard = new Scanner(System.in);
		Haworth_GameOfLife game = new Haworth_GameOfLife(); //Creates a new object and references the constructor
		
		int generations;
		
		do
		{
			System.out.println("Enter how many generations to compute:"); //Gets the generations from the user
			generations = keyboard.nextInt();
			if (generations < 1)
			{
				System.out.println("Error, please enter a number greater than one.");
			}
		}
		while(generations < 1); //Loops until a valid amount of generations is entered
		System.out.println();
		
		game.computeNextGeneration(generations); //References the computerNextGeneration method with the int generations
	}
	
	//Constructor: Haworth_GameOfLife
	//Purpose: Initializes a new game board, prompting the user for a file
	// 		   and loading the game board data from the file into an array.
	public Haworth_GameOfLife() throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the name of the file:");
		String file = keyboard.nextLine();
		
		File input = new File(file);
		Scanner inputData = new Scanner(input);
		
		rows = inputData.nextInt();
		columns = inputData.nextInt();
		
		array = new char[rows][columns]; //Creates a 2D array with the size determined
		temporary = new char[rows][columns];	//by the first two numbers of the text file.
		inputData.nextLine();
		
		while (inputData.hasNext())			//This while loop fills the 2D array
		{									//with the information from the text file.
			for (int q = 0; q < rows; q++)
			{	
				String cheese = inputData.nextLine();
				StringTokenizer tokens = new StringTokenizer(cheese, " ");
				
				while (tokens.hasMoreTokens())
				{
					for (int s = 0; s < columns; s++)
					{
						array[q][s] = tokens.nextToken().charAt(0);
					}
				}
			}
		}
		
		inputData.close();
	}
	
	//Method: getCell
	//Purpose: Returns the value of the cell at the
	// 		   passed in row and column as an int.
	public int getCell(int row, int column)
	{
		if (column >= columns || (column < 0))
		{
			return 0;
		}
		else if (row >= rows || (row < 0))
		{
			return 0;
		}
		else
		{
			if (array[row][column] == 'X')
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}
	
	//Method: setCell
	//Purpose: Sets the value of the cell at the passed row and column
	// 		   as the char value corresponding to the passed int in
	//		   the temporary array.
	public void setCell(int row, int column, int value)
	{
		char status;
		if (value == 0)
		{
			status = '0';
		}
		else
		{
			status = 'X';
		}
		temporary[row][column] = status;
	}
	
	//Method: computeNextGeneration
	//Purpose: Generates the next generation of the 2D
	// 		   array and references the print() method.
	public void computeNextGeneration(int generation)
	{
		if (count == 1)
		{
			System.out.println("Original Generation");
			print();
		}
		
		for (int row = 0; row < rows; row++) //Cycles through the entire 2D array
		{
			for (int col = 0; col < columns; col++)
			{
				int number = isNextGenAlive(row, col); //Determines if the next row and column is alive
				setCell(row, col, number); //Sets the life/death of the next row and column
			}
		}
 
        for (int r = 0; r < rows; r++) //Reindexes the array the temporary array.
        {
            for (int c = 0; c < columns; c++)
            {
                array[r][c] = temporary[r][c];
            }
        }
		
		System.out.println("Generation " + count);
		System.out.println();
		count++;
		print();
		generation--;
		if (generation != 0) //Will execute as long as there are more generations to compute 
		{
			computeNextGeneration(generation); //Recursively calls itself
		}
	}
	
	//Method: getCell
	//Purpose: Prints out the 2D array to the screen
	public void print()
	{
		for (int r = 0; r < rows; r++)
		{
			for (int c = 0; c < columns; c++)
			{
				System.out.print(array[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
		
	//Method: isNextGenAlive
	//Purpose: Simply determines if the cell at the
	// 		   passed row and column should be alive or
	//		   dead in the next generation.
	private int isNextGenAlive(int row, int col)
	{
		if (array[row][col] == 'X')
		{
			int index = 0;
			for (int t = (row - 1); t < (row + 2); t++) //Cycles through all 3 rows around the cell
			{
				for (int v = (col - 1); v < (col + 2); v++) //Cycles through all 3 columns around the cell
				{
					if (t == row && v == col) //Makes sure the cell doesn't count
					{						  //itself as alive.
						continue;
					}
					else
					{
						if (getCell(t, v) == 1)
						{
							index++; //Each index reperesents an alive neighbor.
						}
					}
				}
			}
			
			if (index > 3) //Dies of overpopulation is more than 3
			{
				return 0;
			}
			else if (index == 2 || index == 3) //Stays alive if 2 or 3 neighbors
			{
				return 1;
			}
			else //Dies of lonliness if less than 2 neighbors
			{
				return 0;
			}
		}
		else //If not alive, or if 0...
		{
			int index = 0;
			for (int t = (row - 1); t < (row + 2); t++)
			{
				for (int v = (col - 1); v < (col + 2); v++)
				{
					if (getCell(t, v) == 1)
					{
						index++;
					}
				}
			}
			
			if (index == 3) //If exactly three neighbors, comes to life!
			{
				return 1;
			}
			else //If not exactly three neighbors, stays dead
			{
				return 0;
			}
		}
	}
}

