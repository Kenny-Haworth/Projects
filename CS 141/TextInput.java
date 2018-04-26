import java.util.Scanner;
import java.io.*;

public class TextInput
{
	public static void main (String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		
		File input;
		String inputFile;

		do
		{
			System.out.println("Enter the input file name: "); 
			inputFile = keyboard.nextLine();
		
			input = new File(inputFile);
		
			if (!input.exists())
			{
				System.out.println("The file " + inputFile + " does not exist, or was not found in the location specified. Please try again.");
				System.out.println();
			}
		}
		while (!input.exists());
		
		Scanner inputData = new Scanner(input);
		
		int position;
		int counter = 0;
		
		while (inputData.hasNext())
		{
			String cheese = inputData.nextLine();
			
			position = cheese.indexOf("the");
			
			while (position != -1)
			{
				position = cheese.indexOf("the", position + 1);
				counter++;
			}
		}
		
		System.out.println("The appears " + counter + " times in the text file.");
	}
}