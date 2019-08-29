/**
 * @author Kendall Haworth
 * @version 1.0
 * 
 * CS 3010 Assignment 4
 * Objective: Construct an interpolation polynomial using Newton's interpolation method and evaluate it at a given point.
 *
 * This program takes as input a file that contains data points in the following format:
 * 
 * x0 x1 x2 x3 ... xn
 * y0 y1 y2 y3 ... yn
 * 
 * The program will then ask for a value to be used to evaluate the polynomial, print the output, then loop and ask again.
 * Entering 'q' instead will exit the program.
 * 
 * This program first fills out all the necessary values in the matrix, then constructs and evaluates the polynomial at the given point.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class newton
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner kb = new Scanner(System.in); //get the file for input
        System.out.print("Enter a file name: ");
        String file = kb.nextLine();
        File read = new File(file);
        Scanner inputFile = new Scanner(read);

        int n = 0; //get the number of points in the file so an array can be initialized
        StringTokenizer token = new StringTokenizer(inputFile.nextLine(), " ");

        while (token.hasMoreTokens())
        {
            token.nextToken();
            n++;
        }

        inputFile.close(); //close and reopen the file to restart where the file begins
        inputFile = new Scanner(read);

        double[] x = new double[n];
        double[] y = new double[n];
        token = new StringTokenizer(inputFile.nextLine(), " ");
        StringTokenizer token2 = new StringTokenizer(inputFile.nextLine(), " ");
        inputFile.close();

        for (int i = 0; i < n; i++)
        {
            x[i] = Double.parseDouble(token.nextToken());
            y[i] = Double.parseDouble(token2.nextToken());
        }

        double[][] matrix = new double[n][n]; //nxn matrix to hold computed C values
        fillMatrix(matrix, x, y); //fill in the matrix

        System.out.print("\nEnter a value for the polynomial to be interpolated at (or enter 'q' to quit): ");
        String value = kb.nextLine();

        while (!value.equals("q"))
        {
            double num = Double.parseDouble(value); //the number to evaluate the polynomial at
            double sum = 0;

            for (int i = 0; i < n; i++)
            {
                double minResult = 1;

                for (int q = 0; q < i; q++)
                {
                    if (q == 0)
                    {
                        minResult = num-x[q];
                    }
                    else
                    {
                        minResult *= (num-x[q]);
                    }
                }

                sum += (matrix[0][i] * minResult);
            }

            System.out.println("The polynomial interpolation at " + value + " is " + sum + ".\n");
            System.out.print("Enter another value for the polynomial to be evaluated at (or enter 'q' to quit): ");
            value = kb.nextLine();
        }
    }

    /**
     * This method fills out all necessary values in the matrix so that the polynomial can be constructed.
     * 
     * @param matrix The matrix to fill in
     * @param x The x values of the points
     * @param y The y values of the points
     */
    public static void fillMatrix(double[][] matrix, double[] x, double[] y)
    {
        for (int i = 0; i < matrix.length; i++) //fill in the first column
        {
            matrix[i][0] = y[i];
        }

        for (int col = 1; col < matrix.length; col++) //fill in each column all the way down to one less than the previous column
        {
            for (int row = 0; row < (matrix.length-col); row++)
            {
                matrix[row][col] = (matrix[row+1][col-1] - matrix[row][col-1])/(x[col+row] - x[row]);
            }
        }
    }
}