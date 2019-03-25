/**
 * @author Kendall Haworth
 * @version 1.0
 * 
 * CS 3010 Assignment 2 - Naive Gaussian Elimination and Gaussian Elimination with Scaled Partial Pivoting
 * 
 * This program takes runtime arguments.
 * One argument is the name of the file to read in a system of equations, which by default is solved with Naive Gaussian Elimination.
 * The additional argument -spp or --spp will solve the file with Scaled Partial Pivoting.
 * 
 * The input file takes the format of:
 * 
 * n
 * a11 a12 ... a1n
 * a21 a22 ... a2n
 * ...
 * an1 an2 ... ann
 * b1 b2 ... bn
 * 
 * The output vector is written to a file with the same name as the input file but with extension .sol.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.Math;

public class linear
{
	public static void main(String[] args) throws FileNotFoundException
	{
		String file = "";
		String argument = "";

		//get the file name and runtime arguments
		if (args.length == 2)
		{
			argument = args[0];
			file = args[1];

			if (!(argument.equals("--spp") || argument.equals("-spp")))
			{
				System.out.println("Invalid argument entered. The first argument can only be \"-spp\" or \"--spp\".");
				System.out.println("The system will now exit.");
				System.exit(0);
			}
		}
		else if (args.length == 1)
		{
			file = args[0];
		}
		else
		{
			System.out.println("Unknown number of arguments entered. Please only enter 1-2 arguments.");
			System.out.println("The system will now exit.");
			System.exit(0);
		}
		
		//read in the matrix from the file
		File read = new File(file);
		Scanner inputFile = new Scanner(read);

		int rows = inputFile.nextInt();
		int columns = rows+1;
		inputFile.nextLine(); //move to the next line

		float[][] array = new float[rows][columns];

		StringTokenizer token;

		//read in each row
		for (int r = 0; r < rows; r++)
		{
			token = new StringTokenizer(inputFile.nextLine(), " ");

			int c = 0;

			while (token.hasMoreTokens())
			{
				array[r][c++] = Float.parseFloat(token.nextToken());
			}
		}

		//add the final row as input for the last column for each row sequentially
		token = new StringTokenizer(inputFile.nextLine(), " ");
		int index = 0;

		while (token.hasMoreTokens())
		{
			array[index++][rows] = Float.parseFloat(token.nextToken());
		}

		inputFile.close();

		System.out.println("\nOriginal Array: ");
		for (int w = 0; w < array.length; w++)
		{
			for (int e = 0; e < array[0].length; e++)
			{
				System.out.print(array[w][e] + " ");
			}
			System.out.println();
		}

		float[] answer;

		if (!(argument.equals("--spp") || argument.equals("-spp"))) //perform Naive Gaussian Elimination
		{
			System.out.println("\nPerforming Naive Gaussian Elimination");
			answer = NaiveElimination(array);
		}
		else //perform scaled partial pivoting
		{
			System.out.println("\nPerforming Gaussian Elimination with Scaled Partial Pivoting");
			answer = PivotingElimination(array);
		}

		System.out.print("Answers: ");
		for (int i = 0; i < answer.length; i++)
		{
			System.out.print(answer[i] + " ");
		}

		//write the output to a file
		writeOutput(answer, file);
	}

	/**
		@param array The 2D input matrix, initially unsolved.
		@return An answer vector of the solved matrix using Naive Gaussian Elimination.
	*/
	public static float[] NaiveElimination(float[][] array)
	{
		float multiplier = 0;

		//perform forward elimination
		for (int k = 0; k < array.length-1; k++) //loop over rows-1
		{
			for (int i = k; i < array.length-1; i++) //loop from k to rows-1
			{
				for (int q = k; q < array[0].length; q++) //loop over columns-k
				{
					if (q == k) //only compute the multiplier on the first iteration of the loop for each row
					{
						multiplier = -(array[i+1][q]/array[k][q]);
					}

					array[i+1][q] += (array[k][q] * multiplier);
				}
			}
		}

		//perform back-substitution
		float[] answer = new float[array[0].length-1]; //answer vector will be # of cols-1
		float sum = 0;
		int index = 3;
		
		for (int row = array.length-1; row >= 0; row--) //begin at the last row and work up backwards
		{
			for (int column = array[0].length-2; column > array[0].length-index; column--) //consider each column from the end to the beginning, plugging in the numbers we already have
			{
				if (column == array[0].length-index+1) //last column iteration
				{
					float rowAnswer = ((array[row][array[0].length-1] - sum)/array[row][column]);

					if (Float.isNaN(rowAnswer))
					{
						System.out.println("The system is inconsistent. The program will now close.");
						System.exit(0);
					}

					answer[array[0].length-index+1] = rowAnswer;
				}
				else //add known values to sum
				{
					sum += (answer[column] * array[row][column]);
				}
			}

			index++;
			sum = 0;
		}

		return answer;
	}

	/**
		@param array The 2D input matrix, initially unsolved.
		@return An answer vector of the solved matrix using Scaled Partial Pivoting.
	*/
	public static float[] PivotingElimination(float[][] array)
	{
		float[] S = new float[array.length]; //create an array to hold the largest numbers from each row
		float[] R = new float[S.length]; //create an array to hold the scaled numbers

		//get the largest number in each row, excluding the last column
		for (int r = 0; r < array.length; r++) //loop over all the rows
		{
			float max = 0;

			for (int c = 0; c < array[0].length-1; c++) //loop over all the columns but the last one
			{
				max = Math.max(max, Math.abs(array[r][c]));
			}
			S[r] = max;
		}

		//keep a list of rows that have already been the pivot
		int[] seen = new int[S.length];

		for (int l = 0; l < seen.length; l++) //initialize to unseen for every row
		{
			seen[l] = -1;
		}

		//perform scaled partial pivoting
		for (int k = 0; k < array.length-1; k++) //loop over rows-1
		{
			//for each iteration, determine which row is the pivot row by creating R based on the current matrix
			//R shrinks by 1 after each iteration; we can effectively ignore indexes we no longer need
			for (int l = 0; l < R.length; l++)
			{
				if (seen[l] < 0) //hasn't been seen
				{
					R[l] = Math.abs(array[l][k])/S[l];
				}
			}

			int pivotRow = -1;
			float max = 0;

			//determine the largest number in R, excluding the ones that have already been chosen as the pivot
			//this is our pivot index
			for (int l = 0; l < R.length; l++)
			{
				if (seen[l] < 0 && R[l] > max)
				{
					max = R[l];
					pivotRow = l;
				}
			}

			seen[pivotRow] = k; //this row has now been chosen as a pivot index

			float multiplier = 0;

			for (int i = 0; i < array.length; i++) //loop from 0 to rows
			{
				for (int q = k; q < array[0].length; q++) //loop over columns-k
				{
					if (i == pivotRow || seen[i] > -1) //immediately skip the row if it has already been used as a pivot or is currently being used as the pivot
					{
						break;
					}

					if (q == k) //only compute the multiplier on the first iteration of the loop for each row
					{
						multiplier = -(array[i][q]/array[pivotRow][q]);
					}

					array[i][q] += (array[pivotRow][q] * multiplier);
				}
			}
		}

		//Mark the last row, which wasn't used as a pivot, as the last row used as a pivot
		for (int r = 0; r < seen.length; r++)
		{
			if (seen[r] == -1)
			{
				seen[r] = array.length-1;
				break;
			}
		}

		//perform back-substitution according to the reverse order the pivots were chosen in
		float[] answer = new float[array[0].length-1]; //answer vector will be # of cols-1
		float sum = 0;
		int index = 3;
		
		for (int row = 0; row < array.length; row++) //loop over all the rows
		{
			//pick the row that was chosen as the pivot last, ignoring ones that have already been chosen
			int max = -1;
			int pivotRow = -1;

			for (int n = 0; n < seen.length; n++) //loop over all the rows
			{
				if (seen[n] > -1) //the row has not already been picked
				{
					if (seen[n] > max)
					{
						max = seen[n];
						pivotRow = n;
					}
				}
			}

			seen[pivotRow] = -1; //set the row as used as a pivot

			for (int column = array[0].length-2; column > array[0].length-index; column--) //consider each column from the end to the beginning, plugging in the numbers we already have
			{
				if (column == array[0].length-index+1) //last column iteration
				{
					float rowAnswer = ((array[pivotRow][array[0].length-1] - sum)/array[pivotRow][column]);

					if (Float.isNaN(rowAnswer))
					{
						System.out.println("The system is inconsistent. The program will now close.");
						System.exit(0);
					}

					answer[array[0].length-index+1] = rowAnswer;
				}
				else //add known values to sum
				{
					
					sum += (answer[column] * array[pivotRow][column]);
				}
			}

			index++;
			sum = 0;
		}

		return answer;
	}

	/** 
		@param array The solved vector array for a linear system.
		@param fileName The name of the file to write the output to.
	 */
	public static void writeOutput(float[] array, String fileName) throws FileNotFoundException
	{
		StringTokenizer token = new StringTokenizer(fileName, ".");
		String outputFile = token.nextToken();

		PrintWriter writer = new PrintWriter(outputFile + ".sol");
		
		for (int i = 0; i < array.length; i++)
		{
			writer.print(array[i] + " ");
		}
		writer.close();

		System.out.println("\nThe output has been written to " + outputFile + ".sol.");
	}
}