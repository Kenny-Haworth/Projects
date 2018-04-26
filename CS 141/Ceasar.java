import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class Ceasar
{	
	public static void main (String[] args) throws IOException
	{
		Scanner keyboard = new Scanner(System.in); //97-122, a-z
		
		System.out.println("Enter a message you would like to encrypt:");
		String message = keyboard.nextLine();
		System.out.println("Enter the number of times you would like to transfer your message over:");
		int number = keyboard.nextInt();
		
		char[] letterArray = message.toCharArray();
		
		for (int i = 0; i < letterArray.length; i++)
		{
			if (Character.isLetter(letterArray[i]))
			{
				letterArray[i] = Character.toLowerCase(letterArray[i]);
			}
			int temporary = (int)(letterArray[i] + number);
			if (letterArray[i] == ' ' || letterArray[i] == ',' || letterArray[i] == '.')
			{
				continue;
			}
			else if (temporary > 122)
			{
				letterArray[i] = (char)(letterArray[i] - (26 - number));
			}
			else
			{
				letterArray[i] = (char)(letterArray[i] + number);
			}
		}
		
		for (int q = 0; q < letterArray.length; q++)
		{
			System.out.print(letterArray[q]);
		}
		System.out.println();
		
		System.out.println("I will now attempt to unencrypt your message without knowing how many times it was transferred over.");
		
		File input = new File("database.txt");
		Scanner inputData = new Scanner(input);
		ArrayList<String> database = new ArrayList<String>();
		
		int[] letterIndexes = new int[26];
		letterIndexes[0] = 0;
		
		int count = 1;
		int numbers = 97;
		int index = 0;
		while (inputData.hasNext())
		{
			String cheese = inputData.nextLine();
			database.add(cheese);
			if ((int)cheese.charAt(0) == numbers)
			{
				index++;
			}
			else
			{
				letterIndexes[count] = index;
				numbers++;
				count++;
			}
		}
		
		boolean found = false;
		
		while (!found)
		{
			for (int m = 0; m < 27; m++)
			{
				for (int i = 0; i < letterArray.length; i++)
				{
					int basic = (int)(letterArray[i] - m);
					if (letterArray[i] == ' ' || letterArray[i] == ',' || letterArray[i] == '.')
					{
						continue;
					}
					else if (basic < 97)
					{
						letterArray[i] = (char)(letterArray[i] + (26 - m));
					}
					else
					{
						letterArray[i] = (char)(letterArray[i] - m);
					}
			
					String test = new String(letterArray);
					StringTokenizer tokens = new StringTokenizer(test, " .,");
			
					int hit = 0;
					int amount = 0;
			
					while (tokens.hasMoreTokens())
					{
						String current = tokens.nextToken();
						amount++;
						if (database.contains(current))
						{
							hit++;
						}
					}
			
					if ((double)hit/(double)amount >= .9)
					{
						found = true;
						System.out.println(test);
						break;
					}
				}
				if (found)
				{
					break;
				}
			}
			if (found)
			{
				break;
			}
		}
		
		/*System.out.println("I will now unencrypt your message:");
		
		for (int i = 0; i < letterArray.length; i++)
		{
			int basic = (int)(letterArray[i] - number);
			if (letterArray[i] == ' ' || letterArray[i] == ',' || letterArray[i] == '.')
			{
				continue;
			}
			else if (basic < 97)
			{
				letterArray[i] = (char)(letterArray[i] + (26 - number));
			}
			else
			{
				letterArray[i] = (char)(letterArray[i] - number);
			}
		}
		
		for (int q = 0; q < letterArray.length; q++)
		{
			System.out.print(letterArray[q]);
		}*/
	}
}