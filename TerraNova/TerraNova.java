/**
	A text-based video game based off the Netflix series Terra Nova
	(not currently available on Netflix, unfortunately). It ran for one
	season and inspired me to make this game.
	
	This game is currently not complete but see "Terra Nova Pseudocode.txt"
	to see a list of planned features.
	
	The basis for this game is the player must make decisions to keep their colony
	healthy each day. Each day is a loop and certain events are randomized.
*/

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.InputMismatchException;
import java.io.*;
import Managers.*;

public class TerraNova
{
	public static void main(String[] args) throws Exception
	{
		int input;
		int textDelay = 0; //1 is OFF, 0 is ON
		final int loop = 0;
		DisplayManager displayManager = new DisplayManager();
		
		do
		{
			input = displayManager.displayMainMenu(textDelay);
			
			if (input == 1)
			{
				displayManager.displayExposition(textDelay);
				startGame(textDelay);
			}
			else if (input == 2)
			{
				if (textDelay == 0)
				{
					textDelay = 1;
					System.out.println("\nText delay has been turned off.\n");
				}
				else if (textDelay == 1)
				{
					textDelay = 0;
					System.out.println("\nText delay has been turned on.\n");
				}
			}
			else if (input == 3)
			{
				displayManager.displayTutorial(textDelay);
			}
			else if (input == 4)
			{
				displayManager.displayCredits(textDelay);
			} 
		}
		while (loop == 0);
	}
	
	public static void startGame(int textDelay) throws InterruptedException, IOException
	{
		int day = 1;
		
		boolean gameOver = false; //special events control
		boolean portal = true;
		boolean lucas = false;
		boolean fairMaiden = false;
		
		int colonyMenuDelay = 2; //text delays
		int menuDelay = 6;
		int largeMenuDelay = 2; //menu's with more options should have faster text delay
		int questionDelay = 30;
		int darkStatementDelay = 500;
		int resultDelay = 30;
		int waitAfterQuestionDelay = 750;
		int resourceGainDelay = 125;
		
		String hunts = "Events/Hunts/"; //to access various files
		String resources = "Events/Resources/";
		String events = "Events/";
		String menus = "Menus/";
		
		if (textDelay == 1) //text delay is turned OFF
		{
			colonyMenuDelay = 0;
			menuDelay = 0;
			largeMenuDelay = 0;
			questionDelay = 0;
			darkStatementDelay = 0;
			resultDelay = 0;
			waitAfterQuestionDelay = 0;
			resourceGainDelay = 0;
		}
		
		ColonyManager colony = new ColonyManager(60, 40, 10, 0, 10, 0); //creates a colony with these base stats
								//happiness, food, population, offense, defense, materials
		
		WeatherManager weatherManager = new WeatherManager(resultDelay, darkStatementDelay, resourceGainDelay); //creates a weather manager to manage a colony's weather
		
		DisplayManager displayManager = new DisplayManager(colonyMenuDelay); //creates a display manager to display the main menu and the colony menu
		
		MenuManager menuManager = new MenuManager(questionDelay, waitAfterQuestionDelay, menuDelay, largeMenuDelay, resultDelay, colonyMenuDelay); //creates a menu manager to display all menu's except the main menu and colony menu
		
		EventManager eventManager = new EventManager(resultDelay, resourceGainDelay, darkStatementDelay); //creates an event manager to handle events
		
		int input; //declared, uninitialized variables
		int attackStrength;
		int enemyAttack;
		int attackType;
		int Special;
		int rescueSpecial;
		int returnSpecial;
		
		Scanner kb = new Scanner(System.in);
		Random random = new Random();
		
		while (!gameOver)
		{
			print("Day", resultDelay);
			print(" " + day + "", waitAfterQuestionDelay);
			print(" in the colony of Terra Nova.\n", resultDelay);
			print("\n", resultDelay);
			print("           ", 0); //no delay
			print("Your current colony statistics:", resultDelay);
			print("\n", darkStatementDelay);	
			displayManager.displayColonyStatistics(colony); //display colony menu
			
			weatherManager.applyWeather(colony); //apply weather events
			
			boolean optionChosen = false;
			
			while(!optionChosen)
			{
				input = menuManager.displayMenu(colony, menus + "PrimaryMenu.txt");
				
				if (input == 1) //festival
				{
					input = menuManager.displayMenu(colony, menus + "FestivalMenu.txt");
					
					optionChosen = eventManager.executeEvent(colony, input, events + "FestivalEvents.txt");
				}
				else if (input == 2) //feast
				{
					input = menuManager.displayMenu(colony, menus + "FeastMenu.txt");
					
					optionChosen = eventManager.executeEvent(colony, input, events + "FeastEvents.txt");
				}
				else if (input == 3) //hunt
				{
					input = menuManager.displayMenu(colony, menus + "HuntMenu.txt");
					
					if (input == 1) //hunting outside the gates
					{
						optionChosen = eventManager.executeEvent(colony, input, hunts + "Gates.txt");
					}
					else if (input == 2) //hunting at the waterfalls
					{
						int result = dangerChance(10, colony.getOffense());
						
						if (result == 2) //chance events
						{
							if ((random.nextInt(4) + 1) != 1) //75% chance
							{
								result++; //result is 3 now
							}
						}
						
						optionChosen = eventManager.executeEvent(colony, result, hunts + "Waterfalls.txt");
					}
					else if (input == 3) //hunting at the open plains
					{
						int result = dangerChance(35, colony.getOffense());
						
						if (result == 2) //chance events
						{
							if ((random.nextInt(4) + 1) != 1) //75% chance
							{
								result++; //result is 3 now
							}
						}
						
						optionChosen = eventManager.executeEvent(colony, result, hunts + "Plains.txt");
					}
					else if (input == 4) //hunting in the deep forest
					{
						int result = dangerChance(50, colony.getOffense());
						
						if (result == 2) //chance events
						{
							if ((random.nextInt(4) + 1) != 1) //75% chance
							{
								result++; //result is 3 now
							}
						}
						
						optionChosen = eventManager.executeEvent(colony, result, hunts + "Forest.txt");
					}
					else if (input == 5) //hunting at the badlands
					{
						int result = dangerChance(75, colony.getOffense());
						
						if (result == 2) //chance events
						{
							if ((random.nextInt(5) + 1) != 1) //80% chance
							{
								result++; //result is 3 now
							}
						}
						
						optionChosen = eventManager.executeEvent(colony, result, hunts + "Badlands.txt");
					}
					else if (input == 6) //hunting at the t-rex breeding grounds
					{
						int result = dangerChance(100, colony.getOffense());
						
						if (result == 2) //chance events
						{
							if ((random.nextInt(4) + 1) != 1) //75% chance
							{
								result++; //result is 3 now
							}
						}
						
						optionChosen = eventManager.executeEvent(colony, result, hunts + "Rex.txt");
					}
				}
				else if (input == 4) //resources
				{
					input = menuManager.displayMenu(colony, menus + "ResourcesMenu.txt");
					
					if (input == 1) //gathering materials right outside the gates
					{
						optionChosen = eventManager.executeEvent(colony, input, resources + "Gates.txt");
					}
					else if (input == 2) //gathering materials at the riverbeds
					{
						int result = dangerChance(10, colony.getOffense());
						
						if (result == 2) //chance events
						{
							if ((random.nextInt(4) + 1) != 1) //75% chance
							{
								result++; //result is 3 now
							}
						}
						
						optionChosen = eventManager.executeEvent(colony, result, resources + "Riverbeds.txt");
					}
					else if (input == 3) //gathering materials at the cove
					{
						int result = dangerChance(35, colony.getOffense());
						
						if (result == 2) //chance events
						{
							if ((random.nextInt(4) + 1) != 1) //75% chance
							{
								result++; //result is 3 now
							}
						}
						
						optionChosen = eventManager.executeEvent(colony, result, resources + "Cove.txt");
					}
					else if (input == 4) //gathering materials in the caves
					{
						int result = dangerChance(50, colony.getOffense());
						
						if (result == 2) //chance events
						{
							if ((random.nextInt(4) + 1) != 1) //75% chance
							{
								result++; //result is 3 now
							}
						}
						
						optionChosen = eventManager.executeEvent(colony, result, resources + "Caves.txt");
					}
					else if (input == 5) //gathering materials at the volcano, 50 mats
					{
						int result = dangerChance(75, colony.getOffense());
						
						if (result == 2) //chance events
						{
							if ((random.nextInt(4) + 1) != 1) //75% chance
							{
								result++; //result is 3 now
							}
						}
						
						optionChosen = eventManager.executeEvent(colony, result, resources + "Volcano.txt");
					}
				}
			}
			
			enemyAttack = random.nextInt(2) + 1; //50% chance of being attacked
			if (enemyAttack == 1)
			{
				if (day <= 10)
				{
					print("Dino attack!\n", resultDelay);
					attackStrength = random.nextInt(8 + (2*day)) + 1;
					enter();
						
					print("Your defense: " + colony.getDefense() + "\n", resultDelay);
					print("Dino attack strength:", resultDelay);
					print(" " + attackStrength + "", waitAfterQuestionDelay);
					print("\n", resultDelay);
					
					if (colony.getDefense() > attackStrength)
					{
						print("You fought the dinosaurs out of your territory!\n", resultDelay);
						enter();
					}
					else if (colony.getDefense() < attackStrength)
					{
						print("The dinosaurs have overrun your base!\n", resultDelay);
						print("GAME OVER!\n", darkStatementDelay);
						enter();
						break;
					}
					else if (attackStrength == colony.getDefense())
					{
						print("\nThe battle is tied! Because you hold the defensive position, they are unable to overrun you!\n", resultDelay);
						print("However, because you cannot overcome the dinosaurs, your troop's moral has been greatly lowered!\n", resultDelay);
						print("\t-20 happiness\n", resourceGainDelay);
						colony.subtractHappiness(20);
						enter();
					}
				}
				else if (day > 10)
				{
					attackType = random.nextInt(2) + 1;
					if (attackType == 1)
					{
						print("Dino attack!\n", resultDelay);
						attackStrength = random.nextInt(8 + (2*day)) + 1;
						enter();
						
						print("Your defense: " + colony.getDefense() + "\n", resultDelay);
						print("Dino attack strength:", resultDelay);
						print(" " + attackStrength + "", waitAfterQuestionDelay);
						print("\n", resultDelay);
						
						if (colony.getDefense() > attackStrength)
						{
							print("You fought the dinosaurs out of your territory!\n", resultDelay);
							enter();
						}
						else if (colony.getDefense() < attackStrength)
						{
							print("The dinosaurs have overrun your base!\n", resultDelay);
							print("GAME OVER!\n", darkStatementDelay);
							enter();
							break;
						}
						else if (attackStrength == colony.getDefense())
						{
							print("The battle is tied! But because you hold the defensive position, they are unable to overrun you!\n", resultDelay);
							print("However, because you cannot overcome the dinosaurs, your troop's moral has been greatly lowered!\n", resultDelay);
							print("\t-20 happiness\n", resourceGainDelay);
							colony.subtractHappiness(20);
							enter();
						}
					}
					else if (attackType == 2)
					{
						print("Sixer attack!\n", resultDelay);
						attackStrength = random.nextInt(8 + (2*day)) + 1;
						enter();
						
						print("Your defense: " + colony.getDefense() + "\n", resultDelay);
						print("Sixer attack strength:", resultDelay);
						print(" " + attackStrength + "", waitAfterQuestionDelay);
						print("\n", resultDelay);
						
						if (colony.getDefense() > attackStrength)
						{
							print("You fought the Sixers out of your territory!\n", resultDelay);
							enter();
						}
						else if (colony.getDefense() < attackStrength)
						{
							print("The Sixers have overtaken your base!\n", resultDelay);
							print("GAME OVER!\n", darkStatementDelay);
							enter();
							break;
						}
						else if (attackStrength == colony.getDefense())
						{
							print("The battle is tied! But because you hold the defensive position, they are unable to conquer you!\n", resultDelay);
							print("However, because you cannot overcome the Sixers, your troop's moral has been greatly lowered!\n", resultDelay);
							print("\t-20 happiness\n", resourceGainDelay);
							colony.subtractHappiness(20);
							enter();
						}
					}
				}
			}
			
			optionChosen = false;
			
			while(!optionChosen) //upgrades menu
			{
				input = menuManager.displayMenu(colony, menus + "UpgradeMenu.txt");
				
				if (input == 1) //offensive upgrade menu
				{
					input = menuManager.displayMenu(colony, menus + "OffensiveMenu.txt");
					
					optionChosen = eventManager.executeEvent(colony, input, events + "OffensiveEvents.txt");
				}
				else if (input == 2) //defensive upgrade menu
				{
					input = menuManager.displayMenu(colony, menus + "DefensiveMenu.txt");
					
					optionChosen = eventManager.executeEvent(colony, input, events + "DefensiveEvents.txt");
				}
				else if (input == 3)
				{
					optionChosen = true;
				}
			}
			
			//population consuming food at end of day
			if (colony.getFood() >= colony.getPopulation())
			{
				print("Your people have consumed food by the end of the day.\n", resultDelay);
				print("\t-" + colony.getPopulation() + " food\n", resourceGainDelay);
				colony.subtractFood(colony.getPopulation());
			}
			else //food < population
			{
				print("You have " + colony.getPopulation() + " people at the end of the day, but only " + colony.getFood() + " food to feed them all!\n", resultDelay);
				print(colony.getPopulation()-colony.getFood() + " people went unfed today, so " + (colony.getPopulation()-colony.getFood())/2 + " of them starved to death!\n", resultDelay);
				print("\t-" + colony.getFood() + " food\n", resourceGainDelay);
				print("\t-" + (colony.getPopulation()-colony.getFood())/2 + " population\n", resourceGainDelay);
				colony.subtractPopulation((colony.getPopulation()-colony.getFood())/2);
				colony.subtractFood(colony.getFood()); //could also write a method to set food and set it to 0 here
			}
			
			weatherManager.revertWeather(colony); //remove weather events
			enter();
			
			if (portal = true)
			{
				if (colony.getPopulation() < colony.getFood() && colony.getPopulation() < colony.getMaterials())
				{
					print("The portal has given you a small amount of resources at the end of the day.\n", resultDelay);
					print("\t+2 population\n", resourceGainDelay);
					print("\t+3 food\n", resourceGainDelay);
					print("\t+3 materials\n", resourceGainDelay);
					colony.addPopulation(2);
					colony.addFood(3);
					colony.addMaterials(3);
				}
				else if (colony.getFood() < colony.getPopulation() && colony.getFood() < colony.getMaterials())
				{
					print("The portal has given you a small amount of resources at the end of the day.\n", resultDelay);
					print("\t+1 population\n", resourceGainDelay);
					print("\t+5 food\n", resourceGainDelay);
					print("\t+3 materials\n", resourceGainDelay);
					colony.addPopulation(1);
					colony.addFood(5);
					colony.addMaterials(3);
				}
				else if (colony.getMaterials() < colony.getFood() && colony.getMaterials() < colony.getPopulation())
				{
					print("The portal has given you a small amount of resources at the end of the day.\n", resultDelay);
					print("\t+1 population\n", resourceGainDelay);
					print("\t+3 food\n", resourceGainDelay);
					print("\t+5 materials\n", resourceGainDelay);
					colony.addPopulation(1);
					colony.addFood(3);
					colony.addMaterials(5);
				}
				else
				{
					print("The portal has given you a small amount of resources at the end of the day.\n", resultDelay);
					print("\t+1 population\n", resourceGainDelay);
					print("\t+4 food\n", resourceGainDelay);
					print("\t+4 materials\n", resourceGainDelay);
					colony.addPopulation(1);
					colony.addFood(4);
					colony.addMaterials(4);
				}
			}
			else //portal = false, not implemented yet
			{
				print("The day ends on a bleak note as you reflect that the portal has been destroyed.\n", resultDelay);
				print("You are alone and cut off from civilization, ", resultDelay);
				print("forever.\n", darkStatementDelay);
			}
			
			Special = random.nextInt(50) + 1;
			if (Special == 1 && !fairMaiden && day >= 50)
			{
				fairMaiden = true; //fairMaiden can never happen again
				
				eventManager.executeEvent(colony, 0, events + "FairMaidenEvent.txt"); //read fair maiden exposition out
				input = menuManager.displayMenu(colony, menus + "FairMaidenMenu.txt"); //display the menu, get an input of 1 or 2
				
				if (input == 1) //attempting to find the girl
				{
					eventManager.executeEvent(colony, 1, events + "FairMaidenEvent.txt");
					
					double roll = random.nextDouble();
					double chances = colony.getOffense()/100;
					
					if (chances > roll)
					{
						rescueSpecial = 1; //success
					}
					else
					{
						rescueSpecial = 0; //failure
					}
					
					if (rescueSpecial == 1) //success in finding the girl
					{
						eventManager.executeEvent(colony, 3, events + "FairMaidenEvent.txt");
						
						roll = random.nextDouble();
						chances = colony.getDefense()/100;
						
						if (chances > roll)
						{
							returnSpecial = 1; //success
						}
						else
						{
							returnSpecial = 0; //failure
						}
							
						if (returnSpecial == 1) //sucess in returning the girl, lots of good things!
						{
							eventManager.executeEvent(colony, 5, events + "FairMaidenEvent.txt");
						}
						else //failure in returning the girl
						{
							eventManager.executeEvent(colony, 6, events + "FairMaidenEvent.txt");
						}
					}
					else //failure in finding the girl
					{
						eventManager.executeEvent(colony, 4, events + "FairMaidenEvent.txt");
					}
				}
				else if (input == 2) //not trying to get the special
				{
					eventManager.executeEvent(colony, 2, events + "FairMaidenEvent.txt");
				}
			} //end fair maiden event
			else //if the fair maiden event doesn't occur, print a new line
			{
				print("\n", resultDelay);
			}
			
			print("||=================== End of Day " + day + " ===================||\n", menuDelay);
			enter();
			
			day++;
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //clears the screen
			print("\n", resultDelay);
			
		} // ends the while loop at the very beginning
	} //ends method
	
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
	
	/**
	@return 0 for failure, 1 for partial success, and 2 for complete success
	*/
	public static int dangerChance(int requirement, int current)
	{
		int low = requirement/2;
		int high = requirement - 1;
		
		if (current < low)
		{
			return 0;
		}
		else if (current > high)
		{
			return 2;
		}
		else
		{
			double totalLowChance = .25;
			double totalHighChance = .9;
			
			double completeLowChance = 0;
			double completeHighChance = .7;
			
			double totalChancePerStep = (totalHighChance - totalLowChance)/(high-low);
			double completeChancePerStep = (completeHighChance - completeLowChance)/(high-low);
			
			double percentTotal = (current - low) * totalChancePerStep + totalLowChance;
			double percentComplete = (current - low) * completeChancePerStep;
			double percentPartial = percentTotal - percentComplete;
			
			Random random = new Random();
			double roll = random.nextDouble();
			
			if (roll <= percentPartial)
			{
				return 1;
			}
			else if (roll <= percentTotal)
			{
				return 2;
			}
			
			return 0;
		}
	}
}





















//print("Spinosaurus are large, territorial creatures, preferring to hunt in sheltered coves and shallow reefs for fish and small animals.\n", resultDelay);


/**							
				   	               ____
					              / *__)
				                 /  / 
				                /  /
				               /  /
                     _____    /  /
	             ___/     \__/  /
               /               /
              /               |
	         / /|             |
            / / |   _______   |
           / /  |  |       |  |
		  /_/   |  |       |  |
		        |  |       |  |
				|__|       |__|
				
*/