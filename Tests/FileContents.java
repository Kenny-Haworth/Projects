import java.util.Scanner; // Needed to create the Scanner class.
import java.io.*; // Needed to create the class to work with files.

public class FileContents
{
	public static void main(String[] args) throws IOException
	{
		int count = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		File input;
		
		System.out.println();
		System.out.println("Enter a file. I will tell you whether the file exists or not. If it does not exist, you may create it, or enter another file.");
		System.out.println("If it does exist, I will tell you if it has contents.");
		System.out.println("If it does have contents, I will ask you before overwriting. If you don't want me to overwrite you may choose another file.");
		System.out.println("I will put \"Hello World!\" into your text file after the validation process.");
		System.out.println();
		
		do
		{
			System.out.println("Enter a file: ");
			String inputFile = keyboard.nextLine();
			
			input = new File(inputFile); // Creates an instance of the File class. It passes the string "inputFile" to the constructor, creating a File object that represents the inputted file.
			
			if (!input.exists()) // This if statement tests to ensure the file exists. If it doesn't, an error message is displayed.
			{
				System.out.println("The file " + inputFile + " does not exist, or was not found in the location specified. Would you like to create this file?");
				System.out.println("Enter y or Y for yes, or anything else to choose another file: ");
				
				String charInput = keyboard.next(); //This accepts input from the question just asked and assigns it to charInput.
				char proceed = charInput.charAt(0); //This gets the first letter of what they just inputted, the first letter of what was assigned to charInput.
				keyboard.nextLine();
				
				if (proceed == 'Y' || proceed == 'y')
				{
					System.out.println("The file " + inputFile + " has been created.");
					PrintWriter output = new PrintWriter(inputFile);
					output.println("Hello World!");
					output.close();
					break;
				}
				else if (!(proceed == 'Y' || proceed == 'y'))
				{
					continue;
				}
			}
			else if (input.exists())
			{
				System.out.println("The file " + inputFile + " exists. I will now test and see if it has contents or not.");
				
				Scanner inputData = new Scanner(input);
				
				if (inputData.hasNext())
				{
					System.out.println("This file is not empty.");
					System.out.println("Would you like me to overwrite the contents of this file?");
					System.out.println("Enter y or Y for yes, or anything else to choose another file: ");
					
					String charInput = keyboard.next(); //This accepts input from the question just asked and assigns it to charInput.
					char proceed = charInput.charAt(0); //This gets the first letter of what they just inputted, the first letter of what was assigned to charInput.
					
					if (proceed == 'Y' || proceed == 'y')
					{
						System.out.println("Very well, I will overwrite the contents of this file.");
						inputData.close();
						PrintWriter output = new PrintWriter(inputFile);
						output.println("Hello World!");
						output.close();
						break;
					}
					else if (!(proceed == 'Y' || proceed == 'y'))
					{
						keyboard.nextLine();
						inputData.close();
						continue;
					}
				}
				else if (!(inputData.hasNext()))
				{
					System.out.println("This file is empty. I will now proceed to enter \"Hello World!\" into your text file.");
					inputData.close();
					PrintWriter output = new PrintWriter(inputFile);
					output.println("Hello World!");
					output.close();
					break;
				}
			}
		}
		while (count == 0);
		System.out.println("The program has executed successfully.");
	}
}