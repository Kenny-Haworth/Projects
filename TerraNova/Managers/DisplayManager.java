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
		int loreDelay = 30;
		
		if (textDelay == 1)
		{
			loreDelay = 0;
		}
		
		print("\n", loreDelay);
		print("The year is 2149. The Earth is threatened from overpopulation, lack of resources, and unbreathable air.\n", loreDelay);
		print("Scientists have discovered a temporal rift to a parallel Earth, one untouched by humans and full of resources.\n", loreDelay);
		print("This parallel Earth is in an era resembling Earth's Cretaceous Period, where dinosaurs rule the land.\n", loreDelay);
		print("You have been selected for your expertise and will be leading a colony on this parallel Earth, with the end goal of eventually making the land safe and habitable.\n", loreDelay);
		print("\n", loreDelay);
		print("You are opposed by a group of separatists from Earth, the \"Sixers\", so named because they came from Earth on the sixth pilgrimage.\n", loreDelay);
		print("The Sixers desire to wipe out all colonists who come to the parallel Earth, so that they might rule it for themselves.\n", loreDelay);
		print("You must keep your colony, Terra Nova, alive and well despite the threat of both dinosaurs and Sixers.\n", loreDelay);
		print("You will receive help at the end of each day from the portal between the worlds in the form of new colonists, food, and materials.\n", loreDelay);
		print("The fate of the Earth depends on your success.\n", loreDelay);
		enter();
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //clears the screen
		print("\n", loreDelay);
	}
	
	public void displayTutorial(int textDelay) throws Exception
	{
		int tutorialDelay = 30;
		
		if (textDelay == 1)
		{
			tutorialDelay = 0;
		}
		
		print("\n", tutorialDelay);
		print("Terra Nova is a turn-based video game, where each day is a loop.\n", tutorialDelay);
		print("Each day you must make decisions to keep your colony healthy.\n", tutorialDelay);
		print("\n", tutorialDelay);
		print("Your colony has 6 statistics, which do the following:\n", tutorialDelay);
		print("\tHappiness affects fighting strength. If happiness is under 85, the colony's effective defense will be penalized. If it is over 85, a boost is given.\n", tutorialDelay);
		print("\tFood keeps your people alive. Each day, 1 food is consumed per 1 population you have. People will starve if you don't have enough food.\n", tutorialDelay);
		print("\tPopulation, like happiness, effects your defense. Try to keep your population as high as your defense. Having additional population beyond defense is only a waste of food.\n", tutorialDelay);
		print("\tOffense determines how successful you will be in raiding dangerous areas. Raise offense if you're having trouble gathering food and materials.\n", tutorialDelay);
		print("\tDefense, together with happiness and population, determines the effective defense of your colony.\n", tutorialDelay);
		print("\tMaterials are used to upgrade your offense and defense.\n", tutorialDelay);
		print("\n", tutorialDelay);
		print("Anytime the text stops without asking for a number input, simply press enter to continue.\n", tutorialDelay);
		print("The rest is trial-and-error, so you may have to die a few times to get good at it! Good luck!\n", tutorialDelay);
		enter();
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
		
		@note Fun fact, there are 64x64 possible combinations of menu's to be generated, or 4096. By using a "smart" method such as this,
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
			else if (firstLen == 1 || firstLen == 3)
			{
				print("||     ||", colonyMenuDelay);
			}
			else //firstLen == 2
			{
				print("||      ||", colonyMenuDelay);
			}
			
			if (firstLen == 0) //equals in the middle
			{
				if (i == 0 || i == 2)
				{
					print("=====", colonyMenuDelay);
				}
				else //i == 1
				{
					print("  " + first + "  ", colonyMenuDelay);
				}
			}
			else if (firstLen == 1)
			{
				if (i == 0 || i == 2)
				{
					print("========", colonyMenuDelay);
				}
				else //i == 1
				{
					print("   " + first + "   ", colonyMenuDelay);
				}
			}
			else if (firstLen == 2)
			{
				if (i == 0 || i == 2)
				{
					print("=======", colonyMenuDelay);
				}
				else //i == 1
				{
					print("  " + first + "  ", colonyMenuDelay);
				}
			}
			else //firstLen == 3
			{
				if (i == 0 || i == 2)
				{
					print("========", colonyMenuDelay);
				}
				else
				{
					print("  " + first + "  ", colonyMenuDelay);
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
			else //firstLen != 0 && secondLen != 0
			{
				print("||   ||", colonyMenuDelay);
			}
			
			if (secondLen == 0) //spaces in the middle
			{
				if (i == 0 || i == 2)
				{
					print("=====", colonyMenuDelay);
				}
				else //i == 1
				{
					print("  " + second + "  ", colonyMenuDelay);
				}
			}
			else if (secondLen == 1)
			{
				if (i == 0 || i == 2)
				{
					print("========", colonyMenuDelay);
				}
				else //i == 1
				{
					print("   " + second + "   ", colonyMenuDelay);
				}
			}
			else if (secondLen == 2)
			{
				if (i == 0 || i == 2)
				{
					print("=======", colonyMenuDelay);
				}
				else //i == 1
				{
					print("  " + second + "  ", colonyMenuDelay);
				}
			}
			else //secondLen == 3
			{
				if (i == 0 || i == 2)
				{
					print("========", colonyMenuDelay);
				}
				else
				{
					print("  " + second + "  ", colonyMenuDelay);
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
			else //secondLen != 0 && thirdLen != 0
			{
				print("||   ", colonyMenuDelay);
			}
			
			if (secondLen != 1 && secondLen != 3)
			{
				print(" ", colonyMenuDelay);
			}
			
			print("||", colonyMenuDelay);
			
			if (thirdLen == 0) //spaces in the middle
			{
				if (i == 0 || i == 2)
				{
					print("=====", colonyMenuDelay);
				}
				else //i == 1
				{
					print("  " + third + "  ", colonyMenuDelay);
				}
			}
			else if (thirdLen == 1)
			{
				if (i == 0 || i == 2)
				{
					print("========", colonyMenuDelay);
				}
				else //i == 1
				{
					print("   " + third + "   ", colonyMenuDelay);
				}
			}
			else if (thirdLen == 2)
			{
				if (i == 0 || i == 2)
				{
					print("=======", colonyMenuDelay);
				}
				else //i == 1
				{
					print("  " + third + "  ", colonyMenuDelay);
				}
			}
			else //thirdLen == 3
			{
				if (i == 0 || i == 2)
				{
					print("========", colonyMenuDelay);
				}
				else
				{
					print("  " + third + "  ", colonyMenuDelay);
				}
			}
			
			if (thirdLen == 0) //spaces from the side
			{
				print("||       ||\n", colonyMenuDelay);
			}
			else if (thirdLen == 1 || thirdLen == 3)
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
	
	public static void enter()
	{
		Scanner kb = new Scanner(System.in);
		kb.nextLine();
	}
}