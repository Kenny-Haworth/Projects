import java.util.Scanner; // Needed to create the Scanner class.
import java.io.*; // Needed to create the class to work with files.

public class FileContent
{
	public static void main(String[] args) throws IOException // Throws IOException allows the program to rethrow any exceptions that might occur.
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a file. I will tell you whether the file is empty or not: ");
		String fileName = keyboard.nextLine();
		
		File input = new File(fileName);
		Scanner inputData = new Scanner(input);
		
		if (inputData.hasNext())
		{
			System.out.println("This file is not empty.");
			System.exit(0);
		}
		else if (!(inputData.hasNext()))
		{
			System.out.println("This file is empty.");
			System.exit(0);
		}
	}
}