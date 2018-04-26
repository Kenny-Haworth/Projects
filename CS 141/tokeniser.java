import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class tokeniser
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("test.txt");
		Scanner inputData = new Scanner(file);
		int count = 0;
		
		while (inputData.hasNext())
		{
			String cheese = inputData.nextLine();
			StringTokenizer token = new StringTokenizer(cheese);
			
			while (token.hasMoreTokens())
			{
				count++;
				cheese = token.nextToken();
			}
		}
		System.out.println(count);
		
		inputData.close();
	}
}