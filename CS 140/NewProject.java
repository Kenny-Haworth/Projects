/**

	Name: Kendall Haworth
	Class: CS140, Section 01
	Date Due: Novemeber 3, 2016
	
	Assignment: Project 3 Task 2 - Create a Java program that asks the user for the names of three files.
				The program should read the contents of the first file, change all characters to uppercase,
				and store the results in the second file, at the same time appending them to the third file.
				
	Note: This program additionally tests the existence of the input and ouput files and the contents of the input and output files.
		  It is designed to follow the user's input closely to prevent overwriting files or creating new ones where the user thought they already existed.
				
*/

import java.util.Scanner; // Needed to create the Scanner class.
import java.io.*; // Needed to create the class to work with files.

public class NewProject
{
	public static void main(String[] args) throws IOException // Throws IOException allows the program to rethrow any exceptions that might occur.
	{
		final int count = 0; // To control the do-while loops.
		
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
				System.out.println();
				System.out.println("The file " + inputFile + " does not exist, or was not found in the location specified. Please try again.");
			}
			else if (input.exists()) // Now that we know the file exists, it is tested for contents to make sure it is not an empty file.
			{
				Scanner inputData = new Scanner(input); // Creates a Scanner class that will use the file the user has indicated as input. This opens the file now that it has been tested and found to be a real file.
				
				if (!(inputData.hasNext())) // This tests if the file is empty. If it is, the user must choose another file to read.
				{
					System.out.println();
					System.out.println("This file is empty. Please choose another file.");
					inputData.close();
				}
				else if (inputData.hasNext()) // If the file does have content, the program exits the do-while loop and continues.
				{
					inputData.close();
					break; // Exits the do-while loop.
				}
			}
		}
		while (count == 0); // Conditions such as "!input.exists()" or "!inputFile.hasNext()" cannot be used here to control the loop, as the scope of these tested statements is within the do-while loop.
							// Because the program only needs to continue if both conditions (file exists and file has content) are true, a simple statement that is always true will be referenced
							// if the loop needs to continue. Otherwise, "break" is used to exit the loop (as in line 55).
		
		Scanner inputData = new Scanner(input); // The Scanner class for the file must be re-created, since its scope was previously confined to the do-while loop.
		
		File outputTest; // Defines the symbol for File outside the following do-while statement.
						 // Without this, the scope of "outputTest" is only within the do-while statement and does not apply to the rest of the main method.
					 
		do
		{
			System.out.println("Enter the output file name: ");
			outputFile = keyboard.nextLine();
			
			outputTest = new File(outputFile); // Creates an instance of the File class. It passes the string "outputFile" to the constructor, creating a File object that represents the inputted file.
			
			if (!outputTest.exists()) // This if statement tests to ensure the file exists. If it doesn't, the user has the option of creating the file or choosing another one.
			{
				System.out.println();
				System.out.println("The file " + inputFile + " does not exist, or was not found in the location specified. Would you like to create this file?");
				System.out.println("Enter y or Y for yes, or anything else to choose another file: ");
				
				String charInput = keyboard.next(); //This accepts input from the question just asked and assigns it to charInput.
				char proceed = charInput.charAt(0); //This gets the first letter of what they just inputted, the first letter of what was assigned to charInput.
				keyboard.nextLine(); // To consume the remaining new line.
				
				if (proceed == 'Y' || proceed == 'y') // If they answer yes, the loop is exited. The file is automatically created when the PrintWriter class opens it outside the loop.
				{
					System.out.println("The file " + outputFile + " has been created.");
					break;
				}
				else if (!(proceed == 'Y' || proceed == 'y')) // If they don't want to create the file, the loop continues.
				{
					keyboard.nextLine(); // Consumes the remaining new line.
					continue; // Simply skips to the while statement at the end (which is always true) and continues the loop.
				}
			}
			else if (outputTest.exists()) // If the file does exist, it is then tested to make sure it has content.
			{	
				Scanner outputData = new Scanner(outputTest); // Creates a Scanner class that will use the file the user has indicated as input. This opens the file now that it has been tested and found to be a real file.
				
				if (outputData.hasNext())
				{
					System.out.println();
					System.out.println("This file is not empty.");
					System.out.println("Would you like me to overwrite the contents of this file?");
					System.out.println("Enter y or Y for yes, or anything else to choose another file: ");
					
					String charInput = keyboard.next(); //This accepts input from the question just asked and assigns it to charInput.
					char proceed = charInput.charAt(0); //This gets the first letter of what they just inputted, the first letter of what was assigned to charInput.
					
					if (proceed == 'Y' || proceed == 'y')
					{
						System.out.println("The contents of " + outputFile + " will now be overwritten.");
						outputData.close();
						break;
					}
					else if (!(proceed == 'Y' || proceed == 'y'))
					{
						keyboard.nextLine(); // Consumes the remaining new line.
						outputData.close();
						continue; // Skips to the while statement at the end (which is always true) and continues the loop.
					}
				}
				else if (!(outputData.hasNext())) // If the file is empty, the program can exit the loop and write data to it.
				{
					outputData.close();
					break; // Exits the loop.
				}
			}
		}
		while (count == 0);
		
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
		
		inputData.close(); // Closes the first filem, the input file.
		output.close(); // Closes the second file, the output file.
		append.close(); // Closes the third file, the append file.
		
		System.out.println("The program has executed successfully."); // A nice closing statement that informs the user the program has executed, rather then it just abruptly ending.
	}
}