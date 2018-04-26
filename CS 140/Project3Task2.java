/**

	Name: Kendall Haworth
	Class: CS140, Section 01
	Date Due: Novemeber 3, 2016
	
	Assignment: Project 3 Task 2 - Create a Java program that asks the user for the names of three files.
				The program should read the contents of the first file, change all characters to uppercase,
				and store the results in the second file, at the same time appending them to the third file.
				
*/

import java.util.Scanner; // Needed to create the Scanner class.
import java.io.*; // Needed to create the class to work with files.

public class Project3Task2
{
	public static void main(String[] args) throws IOException // Throws IOException allows the program to rethrow any exceptions that might occur.
	{
		String inputFile, outputFile, appendFile; // To hold the names of each file as a string.
		
		Scanner keyboard = new Scanner(System.in); // To accept input from the keyboard using the Scanner class.
		
		File input; // Defines the symbol for File outside the following do-while statement.
					// Without this, the scope of "input" is only within the do-while statement and does not apply to the rest of the main method.
		do
		{
			System.out.println("Enter the input file name: "); // To get the input file name.
			inputFile = keyboard.nextLine(); // To set the name of the file to "inputFile".
		
			input = new File(inputFile); // Creates an instance of the File class. It passes the string "inputFile" to the constructor, creating a File object that represents the inputted file.
		
			if (!input.exists()) // This if statement tests to ensure the file exists. If it doesn't, an error message is displayed and the loop repeats.
			{
				System.out.println("The file " + inputFile + " does not exist, or was not found in the location specified. Please try again.");
				System.out.println();
			}
		}
		while (!input.exists()); // This do-while statement will loop and continue asking for a valid file as long as what the user inputs is not valid. This prevents crashing the program.
		
		Scanner inputData = new Scanner(input); // Creates a Scanner class that will use the file the user has indicated as input. This opens the file now that it has been tested and found to be a real file.
		
		System.out.println("Enter the output file name: "); // To get the file name for output. If the file does not exist, one will be created.
		outputFile = keyboard.nextLine(); // To set the name of the file to "outputFile".
		
		PrintWriter output = new PrintWriter(outputFile); // Creates the PrintWriter class to write data to the output file.
		
		System.out.println("Enter another output file name to append the data to: "); // To get the name of the file that the data will be appended to. If the file does not exist, one will be created.
		appendFile = keyboard.nextLine(); // To set the name of the append file to "appendFile".
		
		FileWriter fileWriter = new FileWriter(appendFile, true); // Creates an instance of the FileWriter class to append the data to "appendFile".
		PrintWriter append = new PrintWriter(fileWriter); // Creates another instance of the PrintWriter class to print the data to the append file.
		
		while (inputData.hasNext()) // This while-loop will continue to loop as long as the first file that is being read from has not reached the end.
		{
			String line = inputData.nextLine(); // Sets each line from the input text file equal to the string "line".
			String upper = line.toUpperCase(); // Uppercases the string "line" and sets it equal to the string "upper".
			output.println(upper); // Prints out the string "upper" into the output file.
			append.println(upper); // Appends the string "upper" into the append file.
		}
		
		inputData.close(); // Closes the first file, the input file.
		output.close(); // Closes the second file, the output file.
		append.close(); // Closes the third file, the append file.
		
		System.out.println("The program has executed successfully."); // A nice closing statement that informs the user the program has executed, rather then it just abruptly ending.
	}
}