/**
	A class to manage displaying menu's and receiving input.
		@note Make print method universal.
*/

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.StringTokenizer;
import java.util.InputMismatchException;
import java.lang.StringBuilder;

public class MenuManager
{
	private int questionDelay;
	private int waitAfterQuestionDelay;
	private int menuDelay;
	private int largeMenuDelay;
	private int resultDelay;
	private int colonyMenuDelay;
	
	public MenuManager(int question, int waitAfterQuestion, int menu, int largeMenu, int result, int colonyMenu)
	{
		questionDelay = question;
		waitAfterQuestionDelay = waitAfterQuestion;
		menuDelay = menu;
		largeMenuDelay = largeMenu;
		resultDelay = result;
		colonyMenuDelay = colonyMenu;
	}
	
	public int displayMenu(ColonyManager colony, String textFile) throws FileNotFoundException, InterruptedException
	{
		Scanner kb = new Scanner(System.in);
		boolean optionNotChosen = true;
		int input = -1;
			
		while (optionNotChosen)
		{
			File inputFile = new File(textFile);
			Scanner inputData = new Scanner(inputFile);
			
			int count = 0;
			String requirement = null; //some menu's require a certain amount of resources for valid input
			String delay = null; //should never be null, always in a text file
			
			while (inputData.hasNext()) //read all lines from the file
			{
				String cheese = inputData.nextLine();
				
				if (count == 0) //first line is special case, it gives the text delay and possibly the requirement
				{
					StringTokenizer token = new StringTokenizer(cheese, ";");
					
					cheese = token.nextToken(); //cheese holds the line to print
					
					if (token.hasMoreTokens()) //get the text delay
					{
						delay = token.nextToken();
					}
					
					if (token.hasMoreTokens()) //get the requirement if there is one
					{
						requirement = token.nextToken();
					}
					
					if (cheese.charAt(cheese.length()-1) == '?') //the first line is a question
					{
						StringBuilder stringBuilder = new StringBuilder(cheese);
						stringBuilder.deleteCharAt(cheese.length()-1); //remove the last character from the string
						cheese = stringBuilder.toString(); //now print the line without the question mark...
						print(cheese, questionDelay);
						print("?", waitAfterQuestionDelay); //...and add the question mark at the end with a delay
					}
					else //the first line is not a question
					{
						if (delay.equals("fast"))
						{
							print(cheese, largeMenuDelay);
						}
						else //delay.equals("slow")
						{
							print(cheese, menuDelay);
						}
					}
					
					if (delay.equals("fast"))
					{
						print("\n", largeMenuDelay);
					}
					else if (delay.equals("slow"))
					{
						print("\n", menuDelay);
					}
					else //a logic check to make sure the file has a valid text delay. No text delay in the file will cause a crash earlier
					{
						System.out.println("Please give this text document a valid delay!");
						System.exit(1);
					}
				}
				else
				{
					StringTokenizer token = new StringTokenizer(cheese, ";");
					
					if (delay.equals("fast"))
					{
						print("\t" + token.nextToken() + "\n", largeMenuDelay);
					}
					else //delay.equals("slow")
					{
						print("\t" + token.nextToken() + "\n", menuDelay);
					}
				}
				
				if (inputData.hasNext()) //don't print a new line once the file is finished reading
				{
					print("\n", menuDelay);
				}
				
				count++;
			}
			
			try
			{
				input = kb.nextInt();
			}
			catch (InputMismatchException e)
			{
				kb.next();
				input = -1;
			}
			
			if (input == 0)
			{
				print("\n", menuDelay);
				DisplayManager displayManager = new DisplayManager(colonyMenuDelay);
				displayManager.displayColonyStatistics(colony);
			}
			else //check for valid input
			{
				boolean validInput = false;
				
				for (int i = 1; i < count; i++) //the input should be one of the options
				{
					if (input == i)
					{
						validInput = true;
						break;
					}
				}
				
				if (!validInput)
				{
					print("\nPlease enter ", resultDelay); //a smart way to print valid inputs
					
					for (int i = 1; i < count; i++)
					{
						if (i == count-1) //the last part to be printed
						{
							print("or " + i + ".\n\n", resultDelay);
						}
						else
						{
							print(i + ", ", resultDelay);
						}
					}
				}
				else //validInput == true, now check that they meet the requirement
				{
					if (requirement != null && input != count-1) //requirement for this menu, if input == count-1 they're asking to go back. menu's you can't go back on don't have requirements
					{
						File inFile = new File(textFile); //possible error, opening the same file twice
						Scanner data = new Scanner(inFile);
						String cheese = "";
						
						for (int i = 0; i <= input; i++)
						{
							cheese = data.nextLine();
						}
						
						StringTokenizer token = new StringTokenizer(cheese, ";");
						token.nextToken(); //throw away the first token
						
						if (requirement.equals("materials"))
						{
							if (colony.getMaterials() < Integer.parseInt(token.nextToken()))
							{
								print("\n" + token.nextToken() + "\n\n", resultDelay);
								validInput = false;
							}
						}
						else if (requirement.equals("food"))
						{
							if (colony.getFood() < Integer.parseInt(token.nextToken()))
							{
								print("\n" + token.nextToken() + "\n\n", resultDelay);
								validInput = false;
							}
						}
						else
						{
							System.out.println("MenuManager received an invalid requirement from the text file!");
							System.exit(1);
						}
						
						data.close();
					}
					
					if (validInput) //the input met the requirement if there was one
					{
						optionNotChosen = false;
						inputData.close(); //because memory leaks are a bad thing
					}
				}
			}
		} //end while
		
		print("\n", menuDelay);
		
		return input;
	}
	
	public static void print(String data, long delay) throws InterruptedException
	{
		for (char ch : data.toCharArray())
		{
			System.out.print(ch);
			TimeUnit.MILLISECONDS.sleep(delay);
		}
	}
}