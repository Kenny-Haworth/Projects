/**
 * @author Kendall Haworth
 * @version 1.0
 * 
 * CS 3010 Assignment 4
 * Objective: Construct an interpolation polynomial using Newton's interpolation method and evaluate it at a random point.
 *
 * This program asks the user for a value n and generates n random data points in a file of the form:
 * 
 * x0 x1 x2 x3 ... xn
 * y0 y1 y2 y3 ... yn
 * 
 * The program will then randomly evaluate the polynomial at a point, print the output, then loop and ask if it should be evaluated at another random point.
 * Entering 'q' instead will exit the program.
 * 
 *  * This program first fills out all the necessary values in the matrix, then constructs and evaluates the polynomial at a random point.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.util.Random;

public class newtonRandom
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner kb = new Scanner(System.in); //get the number of data points to generate
        System.out.print("Enter the number of data points to generate: ");
        int n = kb.nextInt();

        PrintWriter writer = new PrintWriter("generated.point"); //generate n random data points in the file
        Random random = new Random();
    
        for (int i = 0; i < n*2; i++)
        {
            writer.print((random.nextDouble()*200)-100); //-100 to 100 random range
            writer.print(" "); //print a space between points

            if (i == n-1) //advance to the next line and generate the y data points if the x data points are generated
            {
                writer.println();
            }
        }
        writer.close(); //close the output writer

        File read = new File("generated.point"); //read in the data points
        Scanner inputFile = new Scanner(read);
        double[] x = new double[n];
        double[] y = new double[n];
        StringTokenizer token = new StringTokenizer(inputFile.nextLine(), " ");
        StringTokenizer token2 = new StringTokenizer(inputFile.nextLine(), " ");
        inputFile.close();

        for (int i = 0; i < n; i++)
        {
            x[i] = Double.parseDouble(token.nextToken());
            y[i] = Double.parseDouble(token2.nextToken());
        }

        double[][] matrix = new double[n][n]; //nxn matrix to hold computed C values
        double startTime = System.nanoTime(); //keep track of how long it takes to evaluate the polynomial
        fillMatrix(matrix, x, y); //fill in the matrix

        String value = "";
        kb.nextLine();

        while (!value.equals("q"))
        {
            double num = (random.nextDouble()*200)-100; //the number to evaluate the polynomial at, double from -100 to 100
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

            System.out.println("The polynomial interpolation at " + num + " is " + sum + ".\n");
            double endTime = System.nanoTime() - startTime;
            System.out.println("Time to evaluate (nanoseconds): " + endTime);
            System.out.println("Time to evaluate (microseconds): " + endTime/1000000);
            System.out.println("Time to evalute (milliseconds): " + endTime/1000);
            System.out.println("Time to evaluate (seconds): " + endTime/1000000000);
            System.out.print("Enter 'q' to quit or anything else to evaluate at a different random point: ");
            value = kb.nextLine();
            startTime = System.nanoTime(); //restart the timer
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