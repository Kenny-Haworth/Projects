/**
 * @author Kendall Haworth
 * @version 1.0
 * 
 * CS 3010 Assignment 3
 * Objective: Find 0's for polynomial functions using Bisection, Newton, Secant, and hybrid (starts Bisection, switches to Newton) methods
 *
 * This program takes runtime arguments of the following form, where [] denotes an optional field:
 * 		polRoot [-newt, -sec, -hybrid] [-maxIter n] initP [initP2] polyFileName
 * 
 * The program by default will run using bisection with a limit of 10,000 iterations.
 * Specifying -newt, -sec, and -hybrid will change the method to Newton, Secant, or hybrid, respectively.
 * The -maxIter flag specifies the maximum number of iterations allowed to run before the program terminates.
 * initP is the initial point, always required. initP2 is an extra point, required for Bisection, Secant, and Hybrid methods.
 * Failure to include the extra point for the Bisection, Secant, and Hybrid methods results in program termination.
 * polyFileName is the input file, which takes the following form:
 *
 * n
 * a(n) a(n-1) a(n-2) ... a(2) a(1) b
 * 
 * where n is the degree of the polynomial, a(i)  is the coefficient of the monomial of degree i, and b is the constant term.
 * For example, the polynomial 3x^3 + 5x^2 - 7 would be represented as:
 * 
 * 3
 * 3  5  0 -7
 * 
 * The output is written to a file with the same name as the input file, but with extension .sol, in the following form:
 * 
 * root iterations outcome
 * 
 * Where root is the last root approximation, iterations is the total number of iterations performed by the algorithm,
 * and outcome is success if the algorithm reached convergence or fail if the algorithm didn't converge for the given number of iterations.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.Math;

public class polRoot
{
	static String file = ""; //global file name so methods have access without needing to pass it
	public static void main(String[] args) throws FileNotFoundException
	{
		int maxIterations = 10000; //default 10,000 iterations
		String method = "bisection"; //default use bisection method
		float initialPoint = 0;
		float secondPoint = 0;

		//read in the runtime arguments
		if (args.length == 6)
		{
			if (args[0].equals("-newt"))
			{
				method = "newton";
			}
			else if (args[0].equals("-sec"))
			{
				method = "secant";
			}
			else if (args[0].equals("-hybrid"))
			{
				method = "hybrid";
			}
			else
			{
				System.out.println("Invalid first argument. To specify the algorithm to run, use either \"-newt\" or \"-sec\". Otherwise, the program will by default run using Bisection.");
				System.exit(0);
			}

			if (args[1].equals("-maxIter"))
			{
				maxIterations = Integer.parseInt(args[2]);
			}
			else
			{
				System.out.println("Invalid second argument. Use \"-maxIter\" followed by an integer to specify the maximum number of iterations to run.");
				System.out.println("By default, the program will run for 10,000 iterations.");
				System.exit(0);
			}

			initialPoint = Float.parseFloat(args[3]);
			secondPoint = Float.parseFloat(args[4]);
			file = args[5];
		}
		else if (args.length == 5)
		{
			if (args[0].equals("-newt"))
			{
				method = "newton";

				if (args[1].equals("-maxIter"))
				{
					maxIterations = Integer.parseInt(args[2]);
					initialPoint = Float.parseFloat(args[3]);
				}
				else
				{
					System.out.println("Invalid second argument. Use \"-maxIter\" followed by an integer to specify the maximum number of iterations to run.");
					System.out.println("By default, the program will run for 10,000 iterations.");
				}
			}
			else if (args[0].equals("-maxIter"))
			{
				maxIterations = Integer.parseInt(args[1]);
				initialPoint = Float.parseFloat(args[2]);
				secondPoint = Float.parseFloat(args[3]);
			}
			else
			{
				System.out.println("Invalid first argument. To specify the algorithm to run, use either \"-newt\" or \"-sec\".");
				System.out.println("Use \"-maxIter\" followed by an integer to specify the maximum number of iterations to run.");
				System.out.println("By default, the program will run for 10,000 iterations.");
				System.exit(0);
			}

			file = args[4];
		}
		else if (args.length == 4)
		{
			if (args[0].equals("-sec") || args[0].equals("-hybrid"))
			{
				if (args[0].equals("-sec"))
				{
					method = "secant";
				}
				else if (args[0].equals("-hybrid"))
				{
					method = "hybrid";
				}
				initialPoint = Float.parseFloat(args[1]);
				secondPoint = Float.parseFloat(args[2]);
				file = args[3];
			}
			else
			{
				System.out.println("Please provide command line arguments of the following form: ");
				System.out.println("java polRoot [-newt, -sec, -hybrid] [-maxIter n] initP [initP2] polyFileName");
				System.out.println("They must be in this order. The Newton method requires only 1 point while all other methods require 2 points.");
				System.exit(0);
			}
		}
		else if (args.length == 3) //3 is the minimum number of arguments needed for the program to run. Any more or less would cause errors
		{
			if (args[0].equals("-newt"))
			{
				method = "newton";
				initialPoint = Float.parseFloat(args[1]);
			}
			else
			{
				initialPoint = Float.parseFloat(args[0]);
				secondPoint = Float.parseFloat(args[1]);
			}
			file = args[2];
		}
		else
		{
			System.out.println("Please provide command line arguments of the following form: ");
			System.out.println("java polRoot [-newt, -sec, -hybrid] [-maxIter n] initP [initP2] polyFileName");
			System.out.println("At the minimum, please specify either an initial starting point, ending point, and file name to run the default Bisection method,");
			System.out.println("or speficy the Newton method with an initial start point and a file to read in.");
			System.exit(0);
		}

		if (maxIterations <= 0)
		{
			System.out.println(maxIterations + " iterations have been specified, but the algorithm must run for at least one iteration if it has any hope of finding a solution.");
			System.out.println("Please try again with more iterations.");
			System.exit(0);
		}

		File read = new File(file); //read in the file
		Scanner inputFile = new Scanner(read);
		int degree = inputFile.nextInt(); //get the polynomial degree
		inputFile.nextLine(); //move to the next line
		int[] polynomial = new int[degree+1];
		StringTokenizer token = new StringTokenizer(inputFile.nextLine(), " ");
		inputFile.close();

		for (int i = 0; i < polynomial.length; i++)
		{
			polynomial[i] = Integer.parseInt(token.nextToken());
		}

		if (method.equals("bisection"))
		{
			Bisection(polynomial, initialPoint, secondPoint, maxIterations, 0);
		}
		else if (method.equals("newton"))
		{
			int[] derivative = new int[degree];
			for (int i = 0; i < derivative.length; i++)
			{
				derivative[i] = (degree-i)*polynomial[i];
			}

			Newton(polynomial, derivative, initialPoint, maxIterations, 0);
		}
		else if (method.equals("secant"))
		{
			Secant(polynomial, initialPoint, secondPoint, maxIterations);
		}
		else if (method.equals("hybrid"))
		{
			int[] derivative = new int[degree];
			for (int i = 0; i < derivative.length; i++)
			{
				derivative[i] = (degree-i)*polynomial[i];
			}

			Hybrid(polynomial, derivative, initialPoint, secondPoint, maxIterations);
		}
	}

	/**
	 * @param polynomial A polynomial in array form
	 * @param point1 An initial starting point
	 * @param point2 A second ending point
	 * @param maxIterations The maximum iteratiosn to perform before stopping
	 * @param flag A flag to indicate if this method has been called from the Hybrid() method or not
	 * @return Returns a Data object if this method has been called from the Hybrid() method; calls Output() and returns null otherwise
	 * @throws FileNotFoundException Needed since this method calls the Output() method, which outputs answer to a file
	 */
	public static Data Bisection(int[] polynomial, float point1, float point2, int maxIterations, int flag) throws FileNotFoundException
	{
		float xa = point1;
		float xb = point2;

		for (int iteration = 0; iteration < maxIterations; iteration++)
		{
			float xab = (xa+xb)/2;
			float fxa = 0;
			float fxb = 0;
			float fxab = 0;

			for (int i = 0; i < polynomial.length; i++)
			{
				fxa += (Math.pow(xa,polynomial.length-1-i) * polynomial[i]);
				fxb += (Math.pow(xb,polynomial.length-1-i) * polynomial[i]);
				fxab += (Math.pow(xab,polynomial.length-1-i) * polynomial[i]);
			}

			if (fxa*fxb >= 0) //if the signs are not opposite, something is wrong. End execution
			{
				System.out.println("An error occurred during execution of the Bisection method.");
				System.out.println("The signs of the computed polynomials were the same. Please check your input starting points and try again.");
				System.exit(0);
			}

			if (fxab == 0) //the zero was found
			{
				if (flag == 1) //return the data to the hybrid method if the hybrid method called this
				{
					return new Data(xab, iteration+1, "success");
				}
				Output(xab, iteration+1, "success"); //otherwise immediately print the answer to file
				return null;
			}
			else if ((iteration+1 == maxIterations) || (flag == 1 && Math.abs(fxab) < 10)) //maxIterations has been reached or it is the hybrid method and the error is less than 10
			{
				if (flag == 1) //return the data to the hybrid method if the hybrid method called this
				{
					return new Data(xab, iteration+1, "fail");
				}
				Output(xab, iteration+1, "fail"); //otherwise immediately print the answer to file
				return null;
			}

			if (((fxa > 0) && (fxb < 0)))
			{
				if (fxab > 0)
				{
					xa = xab;
				}
				else
				{
					xb = xab;
				}
			}
			else if (((fxa < 0) && (fxb > 0)))
			{
				if (fxab > 0)
				{
					xb = xab;
				}
				else
				{
					xa = xab;
				}
			}
		}

		return null;
	}

	/**
	 * @param polynomial A polynomial in array form
	 * @param derivative The deriviative of the polynomial in array form
	 * @param point1 An initial starting point
	 * @param maxIterations The maximum iteratiosn to perform before stopping
	 * @param flag A flag to indicate if this method has been called from the Hybrid() method or not
	 * @return Returns a Data object if this method has been called from the Hybrid() method; calls Output() and returns null otherwise
	 * @throws FileNotFoundException Needed since this method calls the Output() method, which outputs answer to a file
	 */
	public static Data Newton(int[] polynomial, int[] derivative, float point1, int maxIterations, int flag) throws FileNotFoundException
	{
		float x0 = point1;

		for (int iteration = 0; iteration < maxIterations; iteration++)
		{
			float fx0 = 0;
			float fx1 = 0;

			for (int i = 0; i < polynomial.length; i++)
			{
				fx0 += (Math.pow(x0,polynomial.length-1-i) * polynomial[i]);

				if (i != derivative.length) //don't compute the last iteration, which is outside the bounds of the derivative size
				{
					fx1 += (Math.pow(x0,derivative.length-1-i) * derivative[i]);
				}
			}

			if (fx1 == 0) //if slope of the derivative is 0, we will get stuck in an infinite loop. Recompute the derivative, adding 1 to the root
			{
				fx1 = 0;
				x0++;
				for (int i = 0; i < polynomial.length-1; i++)
				{
					fx1 += (Math.pow(x0,derivative.length-1-i) * derivative[i]);
				}
			}

			if (fx0 == 0) //the zero was found
			{
				if (flag == 1) //return the data to the hybrid method if the hybrid method called this
				{
					return new Data(x0, iteration+1, "success");
				}
				Output(x0, iteration+1, "success"); //otherwise immediately write the output to file
				return null;
			}
			else if (iteration+1 == maxIterations) //maxIterations has been reached
			{
				if (flag == 1) //return the data to the hybrid method if the hybrid method called this
				{
					return new Data(x0, iteration+1, "fail");
				}
				Output(x0, maxIterations, "fail"); //otherwise immediately write the output to file
				return null;
			}

			x0 = x0 - (fx0/fx1);
		}

		return null;
	}

	/**
	 * @param polynomial A polynomial in array form
	 * @param point1 An initial starting point
	 * @param point2 A second ending point
	 * @param maxIterations The maximum iteratiosn to perform before stopping
	 * @throws FileNotFoundException Needed since this method calls the Output() method, which outputs answer to a file
	 */
	public static void Secant(int[] polynomial, float point1, float point2, int maxIterations) throws FileNotFoundException
	{
		float x0 = point1;
		float x1 = point2;

		for (int iteration = 0; iteration < maxIterations; iteration++)
		{
			float fx0 = 0;
			float fx1 = 0;

			for (int i = 0; i < polynomial.length; i++)
			{
				fx0 += (Math.pow(x0,polynomial.length-1-i) * polynomial[i]);
				fx1 += (Math.pow(x1,polynomial.length-1-i) * polynomial[i]);
			}

			if (fx1 == 0) //the zero has been found
			{
				Output(x1, iteration+1, "success");
				return;
			}
			else if (iteration+1 == maxIterations) //maxIterations has been reached
			{
				Output(x1, maxIterations, "fail");
				return;
			}

			float x2 = x1 - (((x1-x0)/(fx1-fx0))*fx1);
			x0 = x1;
			x1 = x2;
		}
	}
	
	//hybrid method, starts with Bisection for early iterations, then switches to Newton once the error is beneath 10
	public static void Hybrid(int[] polynomial, int[] derivative, float point1, float point2, int maxIterations) throws FileNotFoundException
	{
		Data data = Bisection(polynomial, point1, point2, maxIterations, 1); //this method will return once the error is less than 10

		if (data.getOutcome().equals("success")) //if the Bisection method found success on it's own, there is no need to perform Newton
		{
			System.out.println("Found answer using only the Bisection method.");
			Output(data.getRoot(), data.getIterations(), data.getOutcome());
		}
		else if (data.getIterations() == maxIterations) //the secant method never converged and used all the iterations
		{
			System.out.println("Used all iterations on the Bisection method without converging beneath the error threshold.");
			Output(data.getRoot(), data.getIterations(), data.getOutcome());
		}
		else
		{
			Data data1 = Newton(polynomial, derivative, data.getRoot(), maxIterations-data.getIterations(), 1); //input the partial solution found from the Bisection method

			if (data1.getOutcome().equals("success"))
			{
				System.out.println("Used " + data.getIterations() + " iterations of the Bisection method, then swapped and iterated for " + data1.getIterations() + " times using Newton's method.");
			}
			else
			{
				System.out.println("Used " + data.getIterations() + " iterations on the Bisection method, then swapped and iterated for the remaining " + data1.getIterations() + " iterations using Newton's method.");
			}
			Output(data1.getRoot(), data.getIterations() + data1.getIterations(), data1.getOutcome());
		}
	}

	//writes the output to a file, whether the root was found or not
	public static void Output(float root, int iterations, String outcome) throws FileNotFoundException
	{
		if (outcome.equals("success"))
		{
			System.out.println("Algorithm converged after " + iterations + " total iterations.");
		}
		else
		{
			System.out.println("Maximum iterations reached without convergence.");
		}

		StringTokenizer token = new StringTokenizer(file, ".");
		String outputFile = token.nextToken();

		PrintWriter writer = new PrintWriter(outputFile + ".sol");
		
		writer.print(root + " " + iterations + " " + outcome);
		writer.close();

		System.out.println("The output has been written to " + outputFile + ".sol.");
	}
	
	/**
		The inner class Data allows the creation of objects that encapsulate information,
		so that the methods Bisection and Newton can return more than one piece of information to the Hybrid method.
	*/
	private static class Data
	{
		float root;
		int iterations;
		String outcome;
		
		public Data(float root, int iterations, String outcome)
		{
			this.root = root;
			this.iterations = iterations;
			this.outcome = outcome;
		}

		public float getRoot(){return root;}
		public int getIterations(){return iterations;}
		public String getOutcome(){return outcome;}
	}
}