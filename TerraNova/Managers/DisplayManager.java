/**
	A class to display specific menu's to the screen.
		@note Make print method and enter method universal.
*/

package Managers;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DisplayManager
{
	private int colonyMenuDelay;
	
	public DisplayManager(){}
	
	public DisplayManager(int colonyMenu)
	{
		colonyMenuDelay = colonyMenu;
	}
	
	public int displayMainMenu(int textDelay) throws Exception
	{
		int input;
		int mainmenuDelay = 3;
		int questionDelay = 40;
		
		if (textDelay == 1)
		{
			mainmenuDelay = 0;
			questionDelay = 0;
		}
		
		print("||==========================================||\n", mainmenuDelay);
		print("||                                          ||\n", mainmenuDelay);
		print("||         Welcome to Terra Nova!!!         ||\n", mainmenuDelay);
		print("||                                          ||\n", mainmenuDelay);
		print("||          1) New Game                     ||\n", mainmenuDelay);
		print("||                                          ||\n", mainmenuDelay);
		print("||          2) Toggle Text Delay            ||\n", mainmenuDelay);
		print("||          (default on)                    ||\n", mainmenuDelay);
		print("||                                          ||\n", mainmenuDelay);
		print("||          3) Tutorial                     ||\n", mainmenuDelay);
		print("||          (recommended for new players)   ||\n", mainmenuDelay);
		print("||                                          ||\n", mainmenuDelay);
		print("||          4) Credits                      ||\n", mainmenuDelay);
		print("||                              ____        ||\n", mainmenuDelay);
		print("||                             / *__)       ||\n", mainmenuDelay);
		print("||                            /  /          ||\n", mainmenuDelay);
		print("||                           /  /           ||\n", mainmenuDelay);
		print("||                          /  /            ||\n", mainmenuDelay);
        print("||                _____    /  /             ||\n", mainmenuDelay);
	    print("||            ___/     \\__/  /              ||\n", mainmenuDelay); // Offset one space because of escape character "\"
        print("||           /              /               ||\n", mainmenuDelay);
        print("||          /               |               ||\n", mainmenuDelay);
	    print("||         / /|             |               ||\n", mainmenuDelay);
        print("||        / / |   _______   |               ||\n", mainmenuDelay);
        print("||       / /  |  |       |  |               ||\n", mainmenuDelay);
		print("||      /_/   |  |       |  |               ||\n", mainmenuDelay);
		print("||            |  |       |  |               ||\n", mainmenuDelay);
		print("||            |__|       |__|               ||\n", mainmenuDelay);
		print("||                                          ||\n", mainmenuDelay);																				
		print("||==========================================||\n", mainmenuDelay);
		print("           Enter your number choice:          \n", questionDelay); //Remove this line if I can highlight 1, 2, and 3 at some point, change color of choosable numbers
		
		Scanner kb = new Scanner(System.in);
		
		do
		{
			try
			{
				input = kb.nextInt();
			}
			catch (InputMismatchException e)
			{
				kb.next();
				input = -1;
			}
			
			if (!(input == 1 || input == 2 || input == 3 || input == 4))
			{
				print("\nPlease enter 1, 2, 3, or 4.\n\n", mainmenuDelay);
			}
		}
		while (!(input == 1 || input == 2 || input == 3 || input == 4));
		
		return input;
	}
	
	public void displayExposition(int textDelay) throws Exception
	{
		int loreDelay = 40;
		
		if (textDelay == 1)
		{
			loreDelay = 0;
		}
		
		print("\n", loreDelay);
		print("Here's the lore.\n", loreDelay);
		print("\n", loreDelay);
	}
	
	public void displayTutorial(int textDelay) throws Exception
	{
		int tutorialDelay = 40;
		
		if (textDelay == 1)
		{
			tutorialDelay = 0;
		}
		
		print("\n", tutorialDelay);
		print("Here's the tutorial.\n", tutorialDelay);
		print("\n", tutorialDelay);
	}
	
	public void displayCredits(int textDelay) throws Exception
	{
		int creditsDelay = 40;
		
		if (textDelay == 1)
		{
			creditsDelay = 0;
		}
		
		print("\n", creditsDelay);
		print("I'm Kenny and I made the game.\n", creditsDelay);
		print("\n", creditsDelay);
	}
	
	public void displayColonyStatistics(ColonyManager colony) throws InterruptedException
	{
		int happinessLen = Integer.toString(colony.getHappiness()).length() - 1;
		int foodLen = Integer.toString(colony.getFood()).length() - 1;
		int populationLen = Integer.toString(colony.getPopulation()).length() - 1;
		int offenseLen = Integer.toString(colony.getOffense()).length() - 1;
		int defenseLen = Integer.toString(colony.getDefense()).length() - 1;
		int materialsLen = Integer.toString(colony.getMaterials()).length() - 1;
		
		print("||====================================================||\n", colonyMenuDelay);
		print("||                                                    ||\n", colonyMenuDelay);
		print("||       Happiness        Food        Population      ||\n", colonyMenuDelay);     
		
		printBoxes(happinessLen, foodLen, populationLen, colony.getHappiness(), colony.getFood(), colony.getPopulation());
		
		print("||                                                    ||\n", colonyMenuDelay);
		
		if (materialsLen == 1)
		{
			print("||        Offense       Defense        Materials      ||\n", colonyMenuDelay);
		}
		else
		{
			print("||        Offense       Defense       Materials       ||\n", colonyMenuDelay);
		}
		
		printBoxes(offenseLen, defenseLen, materialsLen, colony.getOffense(), colony.getDefense(), colony.getMaterials());
		
		print("||                                                    ||\n", colonyMenuDelay);
		print("||====================================================||\n", colonyMenuDelay);
		Scanner kb = new Scanner(System.in); //this is the "enter()" method
		kb.nextLine();
	}
	
	/**
		@param firstLen, secondLen, and thirdLen: The number of digits of the stat - 1.
		@param first, second, and third: the actual stat
		
		@note Fun fact, there are 27x27 possible combinations of menu's to be generated, or 729. By using a "smart" method such as this,
			  the required if statements can be brought down to just 49 by taking into account the number of digits of each stat and
			  the total spacing from either side of the menu. Special thanks to Ryan Bucinell for the idea behind this.
	*/
	public void printBoxes(int firstLen, int secondLen, int thirdLen, int first, int second, int third) throws InterruptedException
	{
		for (int i = 0; i < 3; i++)
		{
			if (firstLen == 0) //spaces from the side
			{
				print("||       ||", colonyMenuDelay);
			}
			else if (firstLen == 1)
			{
				print("||     ||", colonyMenuDelay);
			}
			else //firstLen == 2
			{
				print("||      ||", colonyMenuDelay);
			}
			
			if (firstLen == 0) //equals in the middle
			{
				if (i == 0)
				{
					print("=====", colonyMenuDelay);
				}
				else if (i == 1)
				{
					print("  " + first + "  ", colonyMenuDelay);
				}
				else //i == 2
				{
					print("=====", colonyMenuDelay);
				}
			}
			else if (firstLen == 1)
			{
				if (i == 0)
				{
					print("========", colonyMenuDelay);
				}
				else if (i == 1)
				{
					print("   " + first + "   ", colonyMenuDelay);
				}
				else //i == 2
				{
					print("========", colonyMenuDelay);
				}
			}
			else //firstLen == 2
			{
				if (i == 0)
				{
					print("=======", colonyMenuDelay);
				}
				else if (i == 1)
				{
					print("  " + first + "  ", colonyMenuDelay);
				}
				else //i == 2
				{
					print("=======", colonyMenuDelay);
				}
			}
			
			if (firstLen == 0 && secondLen == 0) //spaces inbetween
			{
				print("||     ||", colonyMenuDelay);
			}
			else if (firstLen == 0 || secondLen == 0)
			{
				print("||    ||", colonyMenuDelay);
			}
			else
			{
				print("||   ||", colonyMenuDelay);
			}
			
			if (secondLen == 0) //spaces in the middle
			{
				if (i == 0)
				{
					print("=====", colonyMenuDelay);
				}
				else if (i == 1)
				{
					print("  " + second + "  ", colonyMenuDelay);
				}
				else //i == 2
				{
					print("=====", colonyMenuDelay);
				}
			}
			else if (secondLen == 1)
			{
				if (i == 0)
				{
					print("========", colonyMenuDelay);
				}
				else if (i == 1)
				{
					print("   " + second + "   ", colonyMenuDelay);
				}
				else //i == 2
				{
					print("========", colonyMenuDelay);
				}
			}
			else //secondLen == 2
			{
				if (i == 0)
				{
					print("=======", colonyMenuDelay);
				}
				else if (i == 1)
				{
					print("  " + second + "  ", colonyMenuDelay);
				}
				else //i == 2
				{
					print("=======", colonyMenuDelay);
				}
			}
			
			if (secondLen == 0 && thirdLen == 0) //spaces inbetween
			{
				print("||     ", colonyMenuDelay);
			}
			else if (secondLen == 0 || thirdLen == 0)
			{
				print("||    ", colonyMenuDelay);
			}
			else
			{
				print("||   ", colonyMenuDelay);
			}
			
			if (secondLen != 1)
			{
				print(" ", colonyMenuDelay);
			}
			
			print("||", colonyMenuDelay);
			
			if (thirdLen == 0) //spaces in the middle
			{
				if (i == 0)
				{
					print("=====", colonyMenuDelay);
				}
				else if (i == 1)
				{
					print("  " + third + "  ", colonyMenuDelay);
				}
				else //i == 2
				{
					print("=====", colonyMenuDelay);
				}
			}
			else if (thirdLen == 1)
			{
				if (i == 0)
				{
					print("========", colonyMenuDelay);
				}
				else if (i == 1)
				{
					print("   " + third + "   ", colonyMenuDelay);
				}
				else //i == 2
				{
					print("========", colonyMenuDelay);
				}
			}
			else //thirdLen == 2
			{
				if (i == 0)
				{
					print("=======", colonyMenuDelay);
				}
				else if (i == 1)
				{
					print("  " + third + "  ", colonyMenuDelay);
				}
				else //i == 2
				{
					print("=======", colonyMenuDelay);
				}
			}
			
			if (thirdLen == 0) //spaces from the side
			{
				print("||       ||\n", colonyMenuDelay);
			}
			else if (thirdLen == 1)
			{
				print("||     ||\n", colonyMenuDelay);
			}
			else //thirdLen == 2
			{
				print("||      ||\n", colonyMenuDelay);
			}
		}
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