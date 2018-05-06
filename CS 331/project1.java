/**
	@author Kendall Haworth
	@version 1.5

	A program that calculates the product of two matrixes using
	the classical method, the divide and conquer method, and Strassen's
	method.
	
	The number of matrixes to be calculated and the matrix size can be
	changed from the declared variables at the beginning of the program.
	
	The program will return to the user the average time in nanoseconds
	and in seconds to complete each method based upon the number of iterations.
	
	All randomly generated matrixes are stored in an array list so that the methods
	multiply the same matrixes.
*/

import java.util.Random;
import java.util.ArrayList;

public class project1
{
	public static void main(String[]args)
	{
		Random random = new Random();
		double totalTime = 0;
		int total = 0;
		
		int iterations = 1; //the number of two matrixes to multiply together
		int matrixSize = 4096; //the size of each matrix to be multiplied (only use powers of 2, ie 2^2, 2^3, etc)
		System.out.println("Number of iterations: " + iterations);
		System.out.println("Matrix size: " + matrixSize + "\n");
		
		ArrayList<int[][]> matrixList = new ArrayList<int[][]>(); //a list to store the matrixes in
		
		//generates random matrixes and stores them in the matrix lists
		for (int i = 0; i < iterations; i++)
		{
			int[][] matrix1 = new int[matrixSize][matrixSize];
			int[][] matrix2 = new int[matrixSize][matrixSize];
			
			for (int r = 0; r < matrixSize; r++)
			{
				for (int c = 0; c < matrixSize; c++)
				{
					matrix1[r][c] = random.nextInt(1000000);
					matrix2[r][c] = random.nextInt(1000000);
				}
			}
			
			matrixList.add(matrix1);
			matrixList.add(matrix2);
		}
		
		System.out.println("Matrixes are completed generating.");
		
		//////////////////////////////////////////////////
		//				Classical Method				//
		//////////////////////////////////////////////////
		for (int l = 0; l < iterations; l++)
		{
			//retrieve the matrixes from the list
			int[][] matrix1 = matrixList.get(l);
			int[][] matrix2 = matrixList.get(l);
			int[][] matrix3 = new int[matrixSize][matrixSize];
			
			double startTime = System.nanoTime(); //take the current system time
			
			for (int r = 0; r < matrixSize; r++)
			{
				for (int c = 0; c < matrixSize; c++)
				{
					for (int i = 0; i < matrixSize; i++)
					{
						total += (matrix1[r][i] * matrix2[i][c]);
					}
					
					matrix3[r][c] = total;
					total = 0;
				}
			}
			
			double duration = System.nanoTime() - startTime; //the duration is the current system time minus the previous system time
			totalTime += duration; //add the duration to the total time
		}
		
		double averageTime = totalTime/iterations; //the average time (in nanoseconds) will be the total time divided by the number of iterations
		
		System.out.println("Classical Method");
		System.out.println("Average time in nanoseconds: " + averageTime);
		System.out.println("Average time in seconds: " + (averageTime/1000000000) + "\n");
		averageTime = 0;
		totalTime = 0;
		
		//////////////////////////////////////////////////
		//			Divide and Conquer Method			//
		//////////////////////////////////////////////////
		for (int l = 0; l < iterations; l++)
		{
			int[][] matrix1 = matrixList.get(l);
			int[][] matrix2 = matrixList.get(l);
			
			double startTime = System.nanoTime();
			
			int[][] matrix3 = divideAndConquer(matrix1, matrix2);
			
			double duration = System.nanoTime() - startTime;
			totalTime += duration;
		}
		
		averageTime = totalTime/iterations;
		
		System.out.println("Divide and Conquer Method");
		System.out.println("Average time in nanoseconds: " + averageTime);
		System.out.println("Average time in seconds: " + (averageTime/1000000000) + "\n");
		averageTime = 0;
		totalTime = 0;
		
		//////////////////////////////////////////////////
		//				Strassen's Method				//
		//////////////////////////////////////////////////
		for (int l = 0; l < iterations; l++)
		{
			int[][] matrix1 = matrixList.get(l);
			int[][] matrix2 = matrixList.get(l);
			
			double startTime = System.nanoTime();
			
			int[][] matrix3 = Strassen(matrix1, matrix2);
			
			double duration = System.nanoTime() - startTime;
			totalTime += duration;
		}
		
		averageTime = totalTime/iterations;
		
		System.out.println("Strassen's Method");
		System.out.println("Average time in nanoseconds: " + averageTime);
		System.out.println("Average time in seconds: " + (averageTime/1000000000));
	}
	
	/**
		The recursive divide and conquer method.
	
		@param matrix1 The first 2D array to be multiplied
		@param matrix2 The second 2D array to be multiplied
		@return The multiplication of matrix1 and matrix2
	*/
	public static int[][] divideAndConquer(int[][] matrix1, int[][] matrix2)
	{
		if (matrix1.length == 2) //base case, the matrixes to be multiplied are 2x2
		{
			int[][] matrix3 = new int[matrix1.length][matrix1.length];
			
			matrix3[0][0] = (matrix1[0][0]*matrix2[0][0] + matrix1[0][1]*matrix2[1][0]);
			matrix3[0][1] = (matrix1[0][0]*matrix2[0][1] + matrix1[0][1]*matrix2[1][1]);
			matrix3[1][0] = (matrix1[1][0]*matrix2[0][0] + matrix1[1][1]*matrix2[1][0]);
			matrix3[1][1] = (matrix1[1][0]*matrix2[0][1] + matrix1[1][1]*matrix2[1][1]);
			
			return matrix3;
		}
		else
		{
			//create 8 new matrixes (A11, 12, 21, 22 and B11, 12, 21, 22) based off the current two
			int matrixSize = matrix1.length/2;
			
			int[][] matrixA11 = new int[matrixSize][matrixSize];
			int[][] matrixA12 = new int[matrixSize][matrixSize];
			int[][] matrixA21 = new int[matrixSize][matrixSize];
			int[][] matrixA22 = new int[matrixSize][matrixSize];
			
			int[][] matrixB11 = new int[matrixSize][matrixSize];
			int[][] matrixB12 = new int[matrixSize][matrixSize];
			int[][] matrixB21 = new int[matrixSize][matrixSize];
			int[][] matrixB22 = new int[matrixSize][matrixSize];
			
			//fill the A set matrixes using matrix1
			//top left quadrant
			for (int r = 0; r < matrixSize; r++)
			{
				for (int c = 0; c < matrixSize; c++)
				{
					matrixA11[r][c] = matrix1[r][c];
				}
			}
			
			//top right quadrant
			for (int r = 0; r < matrixSize; r++)
			{
				for (int c = matrixSize; c < matrix1.length; c++)
				{
					matrixA12[r][c-matrixSize] = matrix1[r][c];
				}
			}
			
			//bottom left quadrant
			for (int r = matrixSize; r < matrix1.length; r++)
			{
				for (int c = 0; c < matrixSize; c++)
				{
					matrixA21[r-matrixSize][c] = matrix1[r][c];
				}
			}
			
			//bottom right quadrant
			for (int r = matrixSize; r < matrix1.length; r++)
			{
				for (int c = matrixSize; c < matrix1.length; c++)
				{
					matrixA22[r-matrixSize][c-matrixSize] = matrix1[r][c];
				}
			}
			
			//////////////////////////////////////////////////////////////
			
			//fill the B set matrixes using matrix2
			//top left quadrant
			for (int r = 0; r < matrixSize; r++)
			{
				for (int c = 0; c < matrixSize; c++)
				{
					matrixB11[r][c] = matrix2[r][c];
				}
			}
			
			//top right quadrant
			for (int r = 0; r < matrixSize; r++)
			{
				for (int c = matrixSize; c < matrix1.length; c++)
				{
					matrixB12[r][c-matrixSize] = matrix2[r][c];
				}
			}
			
			//bottom left quadrant
			for (int r = matrixSize; r < matrix1.length; r++)
			{
				for (int c = 0; c < matrixSize; c++)
				{
					matrixB21[r-matrixSize][c] = matrix2[r][c];
				}
			}
			
			//bottom right quadrant
			for (int r = matrixSize; r < matrix1.length; r++)
			{
				for (int c = matrixSize; c < matrix1.length; c++)
				{
					matrixB22[r-matrixSize][c-matrixSize] = matrix2[r][c];
				}
			}
			
			//matrix multiplication is recursive to create the C set of matrixes
			int[][] matrixC11 = addMatrix(divideAndConquer(matrixA11, matrixB11), divideAndConquer(matrixA12, matrixB21));
			int[][] matrixC12 = addMatrix(divideAndConquer(matrixA11, matrixB12), divideAndConquer(matrixA12, matrixB22));
			int[][] matrixC21 = addMatrix(divideAndConquer(matrixA21, matrixB11), divideAndConquer(matrixA22, matrixB21));
			int[][] matrixC22 = addMatrix(divideAndConquer(matrixA21, matrixB12), divideAndConquer(matrixA22, matrixB22));
			
			//create the final answer matrix
			int[][] matrix3 = new int[matrix1.length][matrix1.length];
			
			//fill matrix3 using the C set of matrixes
			for (int r = 0; r < matrix3.length; r++)
			{
				for (int c = 0; c < matrix3.length; c++)
				{
					if (r < matrix3.length/2 && c < matrix3.length/2)
					{
						matrix3[r][c] = matrixC11[r][c];
					}
					else if (r < matrix3.length/2 && c >= matrix3.length/2)
					{
						matrix3[r][c] = matrixC12[r][c-matrixSize];
					}
					else if (r >= matrix3.length/2 && c < matrix3.length/2)
					{
						matrix3[r][c] = matrixC21[r-matrixSize][c];
					}
					else if (r >= matrix3.length/2 && c >= matrix3.length/2)
					{
						matrix3[r][c] = matrixC22[r-matrixSize][c-matrixSize];
					}
					else //this should never execute if the program executes correctly
					{
						System.out.println("Fatal logic error!");
						System.exit(0);
					}
				}
			}
			
			return matrix3;
		}
	}
	
	/**
		The recursive Strassen's method.
	
		@param matrix1 The first 2D array to be multiplied
		@param matrix2 The second 2D array to be multiplied
		@return The multiplication of matrix1 and matrix2
	*/
	public static int[][] Strassen(int[][] matrix1, int[][] matrix2)
	{
		if (matrix1.length == 1) //base case, matrix sizes are 1x1 or just 1 number
		{
			int[][] matrix3 = new int[1][1]; 
			matrix3[0][0] = matrix1[0][0] * matrix2[0][0];
			return matrix3;
		}
		else
		{
			//create 8 new matrixes (A11, 12, 21, 22 and B11, 12, 21, 22) based off the current two
			int matrixSize = matrix1.length/2;
			
			int[][] matrixA11 = new int[matrixSize][matrixSize];
			int[][] matrixA12 = new int[matrixSize][matrixSize];
			int[][] matrixA21 = new int[matrixSize][matrixSize];
			int[][] matrixA22 = new int[matrixSize][matrixSize];
			
			int[][] matrixB11 = new int[matrixSize][matrixSize];
			int[][] matrixB12 = new int[matrixSize][matrixSize];
			int[][] matrixB21 = new int[matrixSize][matrixSize];
			int[][] matrixB22 = new int[matrixSize][matrixSize];
			
			//fill the A set matrixes using matrix1
			//top left quadrant
			for (int r = 0; r < matrixSize; r++)
			{
				for (int c = 0; c < matrixSize; c++)
				{
					matrixA11[r][c] = matrix1[r][c];
				}
			}
			
			//top right quadrant
			for (int r = 0; r < matrixSize; r++)
			{
				for (int c = matrixSize; c < matrix1.length; c++)
				{
					matrixA12[r][c-matrixSize] = matrix1[r][c];
				}
			}
			
			//bottom left quadrant
			for (int r = matrixSize; r < matrix1.length; r++)
			{
				for (int c = 0; c < matrixSize; c++)
				{
					matrixA21[r-matrixSize][c] = matrix1[r][c];
				}
			}
			
			//bottom right quadrant
			for (int r = matrixSize; r < matrix1.length; r++)
			{
				for (int c = matrixSize; c < matrix1.length; c++)
				{
					matrixA22[r-matrixSize][c-matrixSize] = matrix1[r][c];
				}
			}
			
			///////////////////////////////////////////////////////////////
			
			//fill the B set matrixes using matrix2
			//top left quadrant
			for (int r = 0; r < matrixSize; r++)
			{
				for (int c = 0; c < matrixSize; c++)
				{
					matrixB11[r][c] = matrix2[r][c];
				}
			}
			
			//top right quadrant
			for (int r = 0; r < matrixSize; r++)
			{
				for (int c = matrixSize; c < matrix1.length; c++)
				{
					matrixB12[r][c-matrixSize] = matrix2[r][c];
				}
			}
			
			//bottom left quadrant
			for (int r = matrixSize; r < matrix1.length; r++)
			{
				for (int c = 0; c < matrixSize; c++)
				{
					matrixB21[r-matrixSize][c] = matrix2[r][c];
				}
			}
			
			//bottom right quadrant
			for (int r = matrixSize; r < matrix1.length; r++)
			{
				for (int c = matrixSize; c < matrix1.length; c++)
				{
					matrixB22[r-matrixSize][c-matrixSize] = matrix2[r][c];
				}
			}
			
			//create P, Q, R, S, T, U, V using the formula. Multiplication is recursive
			int[][] P = Strassen(addMatrix(matrixA11, matrixA22), addMatrix(matrixB11, matrixB22));
			int[][] Q = Strassen(addMatrix(matrixA21, matrixA22), matrixB11);
			int[][] R = Strassen(matrixA11, subtractMatrix(matrixB12, matrixB22));
			int[][] S = Strassen(matrixA22, subtractMatrix(matrixB21, matrixB11));
			int[][] T = Strassen(addMatrix(matrixA11, matrixA12), matrixB22);
			int[][] U = Strassen(subtractMatrix(matrixA21, matrixA11), addMatrix(matrixB11, matrixB12));
			int[][] V = Strassen(subtractMatrix(matrixA12, matrixA22), addMatrix(matrixB21, matrixB22));
			
			//create the C set of matrixes using the formula
			int[][] matrixC11 = addMatrix(subtractMatrix(addMatrix(P, S), T), V);
			int[][] matrixC12 = addMatrix(R, T);
			int[][] matrixC21 = addMatrix(Q, S);
			int[][] matrixC22 = addMatrix(subtractMatrix(addMatrix(P, R), Q), U);
			
			//create the answer matrix
			int[][] matrix3 = new int[matrix1.length][matrix1.length];
			
			//fill the answer matrix using the C set of matrixes
			for (int r = 0; r < matrix3.length; r++)
			{
				for (int c = 0; c < matrix3.length; c++)
				{
					if (r < matrix3.length/2 && c < matrix3.length/2)
					{
						matrix3[r][c] = matrixC11[r][c];
					}
					else if (r < matrix3.length/2 && c >= matrix3.length/2)
					{
						matrix3[r][c] = matrixC12[r][c-matrixSize];
					}
					else if (r >= matrix3.length/2 && c < matrix3.length/2)
					{
						matrix3[r][c] = matrixC21[r-matrixSize][c];
					}
					else if (r >= matrix3.length/2 && c >= matrix3.length/2)
					{
						matrix3[r][c] = matrixC22[r-matrixSize][c-matrixSize];
					}
					else //this should never execute if the program executes correctly
					{
						System.out.println("Fatal logic error!");
						System.exit(0);
					}
				}
			}
			
			return matrix3;
		}
	}
	
	/**
		Adds two matrixes together.
	
		@param matrix1 The first 2D array to be added
		@param matrix2 The second 2D array to be added
		@return The addition of matrix1 and matrix2
	*/
	public static int[][] addMatrix(int[][] matrix1, int[][] matrix2)
	{
		int[][] matrix3 = new int[matrix1.length][matrix1.length];
		
		for (int r = 0; r < matrix1.length; r++)
		{
			for (int c = 0; c < matrix1.length; c++)
			{
				matrix3[r][c] = matrix1[r][c] + matrix2[r][c];
			}
		}
		
		return matrix3;
	}
	
	/**
		Subracts matrix1 from matrix2.
	
		@param matrix1 The first 2D array
		@param matrix2 The 2D array to be subtracted from the first 2D array
		@return Matrix1 minus matrix2
	*/
	public static int[][] subtractMatrix(int[][] matrix1, int[][] matrix2)
	{
		int[][] matrix3 = new int[matrix1.length][matrix1.length];
		
		for (int r = 0; r < matrix1.length; r++)
		{
			for (int c = 0; c < matrix1.length; c++)
			{
				matrix3[r][c] = matrix1[r][c] - matrix2[r][c];
			}
		}
		
		return matrix3;
	}
}