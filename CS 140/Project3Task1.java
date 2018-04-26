/**

	Name: Kendall Haworth
	Class: CS140, Section 01
	Date Due: Novemeber 3, 2016
	
	Assignment: Project 3 Task 1 - Create a Java program that opens a text file and determines
				how many times each vowel or other character appears in the file. Use a loop
				to read the characters and use a switch statement to count vowels.
				
	Note: This program additionally tests the inputted file to make sure it both exists and has content.
		  Otherwise, it will display an error message and ask for another file.
				
*/

import java.util.Scanner; // Needed to create the Scanner class.
import java.io.*; // Needed to create the class to work with files.

public class Project3Task1
{
	public static void main(String[] args) throws IOException // Throws IOException allows the program to rethrow any exceptions that might occur.
	{
		final int count = 0; // To control the do-while loop.
		String fileName; // To hold the file's name as a string.
		int a=0, e=0, i=0, o=0, u=0, other=0; // Initializes all the variables that will hold vowels or other characters to 0.
		
		Scanner keyboard = new Scanner (System.in); // To accept input from the keyboard using the Scanner class.
		
		File input; // Defines the symbol for File outside the following do-while statement.
					// Without this, the scope of "input" is only within the do-while statement and does not apply to the rest of the main method.
		
		do
		{
			System.out.println("Enter the name of a file: "); // To get the file name.
			fileName = keyboard.nextLine(); // To set the name of the file to "fileName".
		
			input = new File(fileName); // Creates an instance of the File class. It passes the string "fileName" to the constructor, creating a File object that represents the inputted file.
		
			if (!input.exists()) // This if statement tests to ensure the file exists. If it doesn't, an error message is displayed, and the program loops to the beginning to ask for another file.
			{
				System.out.println();
				System.out.println("The file " + fileName + " does not exist, or was not found in the location specified. Please try again.");
			}
			else if (input.exists()) // Now that we know the file exists, it is tested for contents to make sure it is not an empty file.
			{
				Scanner inputFile = new Scanner(input); // Creates a Scanner class that will use the file the user has indicated as input. This opens the file now that it has been tested and found to be a real file.
				
				if (!(inputFile.hasNext())) // This tests if the file is empty. If it is, the user must choose another file to read.
				{
					System.out.println();
					System.out.println("The file " + fileName + " is empty. Please choose another file to read.");
				}
				else if (inputFile.hasNext()) // If the file does have content, the program exits the do-while loop and continues.
				{
					break; // Exits the do-while loop.
				}
			}
		}
		while (count == 0); // Conditions such as "!input.exists()" or "!inputFile.hasNext()" cannot be used here to control the loop, as the scope of these tested statements is within the do-while loop.
							// Because the program only needs to continue if both conditions (file exists and file has content) are true, a simple statement that is always true will be referenced
							// if the loop needs to continue. Otherwise, "break" is used to exit the loop (as in line 55).
		
		Scanner inputFile = new Scanner(input); // The Scanner class for the file must be re-created, since its scope was previously confined to the do-while loop.
		
		while (inputFile.hasNext()) // This while-loop will continue to execute as long as the end of the file has not been reached. Once it has been reached, the hasNext method returns 'false'.
		{
			String line = inputFile.nextLine();  // Sets the current text line in the file equal to the string "line".
			
			for (int q = 0; q < line.length(); q++) // This for-loop will continue to execute until q is the same length as "line", the string of the current line called from the text file.
			{										// Once it is, the while-loop starts from the beginning and pulls the next line from the text file and repeats the process.
				char r = line.charAt(q);
				switch (r)
				{
					case 'a':
					case 'A':
						a++;
						break;
					case 'e':
					case 'E':						//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						e++;						//																																	//
						break;						//	Line 71 calls each character in the string "line" and sets it equal to r, which is then tested by the switch statement			//
					case 'i':						//	to determine what vowel it is. Should the char not be a vowel, the "default:" statement identifies it as an "other".			//
					case 'I':						//	The resulting vowel or other is then incremented, so that it can eventually be called upon in the final println statement		//
						i++;						//	once all the characters from each line have run through the for loop and all lines have run through the while loop.				//
						break;						//	Line 71 takes the character of number q because each time the for statement runs, q is incremented and the code needs to read	//
					case 'o':						//	the very next character and run it through the switch statement to identify it.													//
					case 'O':						//																																	//
						o++;						//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						break;
					case 'u':
					case 'U':
						u++;
						break;
					default:
						other++;
						break;
				}
			}
		}

		System.out.println(); // Blank line for added clarity and separation.
		System.out.println("Number of vowels 'a' or 'A': " + a +		// This simply prints out the resulting values for all the int variables after they
							"\nNumber of vowels 'e' or 'E': " + e +		// have been incremented by the above while-loop according to the contents of the file.
							"\nNumber of vowels 'i' or 'I': " + i +
							"\nNumber of vowels 'o' or 'O': " + o +
							"\nNumber of vowels 'u' or 'U': " + u +
							"\nNumber of other characters: " + other);

		inputFile.close(); // This closes the file.
	}
}