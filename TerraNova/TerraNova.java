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
			print("           Your current colony statistics:", resultDelay);
			print("\n", darkStatementDelay);	
			displayManager.displayColonyStatistics(colony); //display colony menu
			
			weatherManager.applyWeather(colony); //apply weather events
			
			boolean optionChosen = false;
			
			while(!optionChosen)
			{
				input = menuManager.displayMenu(colony, "PrimaryMenu.txt");
				
				if (input == 1) //festival
				{
					input = menuManager.displayMenu(colony, "FestivalMenu.txt");
					
					optionChosen = eventManager.executeEvent(colony, input, "FestivalEvents.txt");
				}
				else if (input == 2) //feast
				{
					input = menuManager.displayMenu(colony, "FeastMenu.txt");
					
					optionChosen = eventManager.executeEvent(colony, input, "FeastEvents.txt");
				}
				else if (input == 3) //hunt
				{
					input = menuManager.displayMenu(colony, "HuntMenu.txt");
					
					if (input == 1) //hunting outside the gates
					{
						optionChosen = eventManager.executeEvent(colony, input, "HuntEventGates.txt");
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
						
						optionChosen = eventManager.executeEvent(colony, result, "HuntEventWaterfalls.txt");
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
						
						optionChosen = eventManager.executeEvent(colony, result, "HuntEventPlains.txt");
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
						
						optionChosen = eventManager.executeEvent(colony, result, "HuntEventForest.txt");
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
						
						optionChosen = eventManager.executeEvent(colony, result, "HuntEventBadlands.txt");
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
						
						optionChosen = eventManager.executeEvent(colony, result, "HuntEventRex.txt");
					}
				}
				else if (input == 4) //resources
				{
					input = menuManager.displayMenu(colony, "ResourcesMenu.txt");
					
					if (input == 1) //gathering materials right outside the gates
					{
						optionChosen = eventManager.executeEvent(colony, input, "ResourcesEventGates.txt");
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
						
						optionChosen = eventManager.executeEvent(colony, result, "ResourcesEventRiverbeds.txt");
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
						
						optionChosen = eventManager.executeEvent(colony, result, "ResourcesEventCove.txt");
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
						
						optionChosen = eventManager.executeEvent(colony, result, "ResourcesEventCaves.txt");
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
						
						optionChosen = eventManager.executeEvent(colony, result, "ResourcesEventVolcano.txt");
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
				input = menuManager.displayMenu(colony, "UpgradeMenu.txt");
				
				if (input == 1) //offensive upgrade menu
				{
					input = menuManager.displayMenu(colony, "OffensiveMenu.txt");
					
					optionChosen = eventManager.executeEvent(colony, input, "OffensiveEvents.txt");
				}
				else if (input == 2) //defensive upgrade menu
				{
					input = menuManager.displayMenu(colony, "DefensiveMenu.txt");
					
					optionChosen = eventManager.executeEvent(colony, input, "DefensiveEvents.txt");
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
			
			Special = random.nextInt(100) + 1;
			if (Special == 1 && !fairMaiden && day > 50)
			{
				fairMaiden = true;
				
				do
				{
					print("\nJust before you turn in for bed, one of your men hails you on your radio, ", resultDelay);
					print("saying he's picked up something unusual scanning for radio frequencies.", resultDelay);
					print("\nCurious, you walk over to the command station to see for yourself. ", resultDelay);
					print("There appears to be someone trying to hail the base!\n", resultDelay);
					print("It seems to be the voice of a young girl, and she's stuck deep in the jungle, several hundred kilometers from your position!!!\n", resultDelay);
					print("Attempting a rescue mission this late at night will be very dangerous, but she'll surely be dead by morning if you leave her to die", resultDelay);
					print("...\n", darkStatementDelay);
					print("What will you do", resultDelay);
					print("?", waitAfterQuestionDelay);
					print("\n", resultDelay);
					print("\n", resultDelay);
					print("	1) Rescue the girl! We can't just leave her to die!!\n", resultDelay);
					print("\n", resultDelay);
					print("	2) It's too dangerous! We have to think about the colony first!\n", resultDelay);
					print("\n", resultDelay);
					
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
						System.out.println();
						displayManager.displayColonyStatistics(colony);
					}
					else
					{
						if (!(input == 1 || input == 2))
						{
							print("\nPlease enter only 1 or 2.\n\n", menuDelay);
						}
					}
				}
				while (!(input == 1 || input == 2));
				
				if (input == 1)
				{
					print("\nYou've made up your mind, you have to do everything in your power to save her!\n", resultDelay);
					print("You sound the emergency alarm and order all available units to suit up and assemble at the land rovers!!!\n", resultDelay);
					print("You quickly explain the situation to your troops, and see your own steel determination reflected in their eyes.\n", resultDelay);
					print("Without another seconds delay, you all mount up and set forth to rescue the girl!\n", resultDelay);
					print("\n", resultDelay);
					print("...\n", darkStatementDelay);
					print("...\n", darkStatementDelay);
					print("...\n\n", darkStatementDelay);
					
					if (colony.getOffense() < 100)
					{
						if (colony.getOffense() > 90)
						{
							rescueSpecial = random.nextInt(10) + 1; //90% chance
							if (rescueSpecial == 10)
							{
								rescueSpecial = 0; //failure
							}
							else
							{
								rescueSpecial = 1; //success
							}
						}
						else if (colony.getOffense() > 80)
						{
							rescueSpecial = random.nextInt(5) + 1; //80% chance
							if (rescueSpecial == 5)
							{
								rescueSpecial = 0; //failure
							}
							else
							{
								rescueSpecial = 1; //success
							}
						}
						else if (colony.getOffense() > 70)
						{
							rescueSpecial = random.nextInt(10) + 1; //70% chance
							if (rescueSpecial == 8 || rescueSpecial == 9 || rescueSpecial == 10)
							{
								rescueSpecial = 0; //failure
							}
							else
							{
								rescueSpecial = 1; //success
							}
						}
						else if (colony.getOffense() > 60)
						{
							rescueSpecial = random.nextInt(5) + 1; //60% chance
							if (rescueSpecial == 2 || rescueSpecial == 3)
							{
								rescueSpecial = 0;
							}
						}
						else if (colony.getOffense() > 50)
						{
							rescueSpecial = random.nextInt(2) + 1; //50% chance
						}
						else if (colony.getOffense() > 40)
						{
							rescueSpecial = random.nextInt(5) + 1; //40% chance
							if (rescueSpecial == 2)
							{
								rescueSpecial = 1; //success
							}
						}
						else if (colony.getOffense() > 30)
						{
							rescueSpecial = random.nextInt(10) + 1; //30% chance
							if (rescueSpecial == 2 || rescueSpecial == 3)
							{
								rescueSpecial = 1;
							}
						}
						else if (colony.getOffense() > 20)
						{
							rescueSpecial = random.nextInt(5) + 1; //20% chance
						}
						else
						{
							rescueSpecial = random.nextInt(10) + 1; //10% chance
						}
					}
					else
					{
						rescueSpecial = 1;
					}
					
					if (rescueSpecial == 1) //success in finding the girl
					{
						print("Sometime later, deep in the dense jungle of the far north...\n", resultDelay);
						print("Your driver turns and tells you that you're closing in on the origin of the radio signal!\n", resultDelay);
						print("Your lean forward in your seat in anticipation, eyes straining to see through the thick windshield", resultDelay);
						print("...\n", darkStatementDelay);
						print("Suddenly, there she is!\n", resultDelay);
						print("Shivering and afraid, your squadron quickly forms a defensive perimeter around her!\n", resultDelay);
						print("You leap out of your rover and wrap a blanket around her, assuring her that she's safe now!\n", resultDelay);
						
						if (colony.getDefense() < 100)
						{
							if (colony.getDefense() > 90)
							{
								returnSpecial = random.nextInt(10) + 1; //90% chance
								if (returnSpecial == 10)
								{
									returnSpecial = 0; //failure
								}
								else
								{
									returnSpecial = 1; //success
								}
							}
							else if (colony.getDefense() > 80)
							{
								returnSpecial = random.nextInt(5) + 1; //80% chance
								if (returnSpecial == 5)
								{
									returnSpecial = 0; //failure
								}
								else
								{
									returnSpecial = 1; //success
								}
							}
							else if (colony.getDefense() > 70)
							{
								returnSpecial = random.nextInt(10) + 1; //70% chance
								if (returnSpecial == 8 || returnSpecial == 9 || returnSpecial == 10)
								{
									returnSpecial = 0; //failure
								}
								else
								{
									returnSpecial = 1; //success
								}
							}
							else if (colony.getDefense() > 60)
							{
								returnSpecial = random.nextInt(5) + 1; //60% chance
								if (returnSpecial == 2 || returnSpecial == 3)
								{
									returnSpecial = 0;
								}
							}
							else if (colony.getDefense() > 50)
							{
								returnSpecial = random.nextInt(2) + 1; //50% chance
							}
							else if (colony.getDefense() > 40)
							{
								returnSpecial = random.nextInt(5) + 1; //40% chance
								if (returnSpecial == 2)
								{
									returnSpecial = 1; //success
								}
							}
							else if (colony.getDefense() > 30)
							{
								returnSpecial = random.nextInt(10) + 1; //30% chance
								if (returnSpecial == 2 || returnSpecial == 3)
								{
									returnSpecial = 1;
								}
							}
							else if (colony.getDefense() > 20)
							{
								returnSpecial = random.nextInt(5) + 1; //20% chance
							}
							else
							{
								returnSpecial = random.nextInt(10) + 1; //10% chance
							}
						}
						else
						{
							returnSpecial = 1;
						}
						
						if (returnSpecial == 1) //sucess in returning the girl, lots of good things!
						{
							//success!!
						}
						else //failure in returning the girl
						{
							//loss of population and Special, maybe 1/4 loss population
						}
					}
					else //failure of getting to Special
					{
						print("Sometime later, deep in the dense jungle of the far north...\n", resultDelay);
						print("A dense fog seems to have slowly crept into this region.\n", resultDelay);
						print("You're beginning to have second thoughts about this rescue mission", resultDelay);
						print("...\n", darkStatementDelay);
						print("\n...\n\n", darkStatementDelay);
						print("Suddenly, a large pack of raptors materialize from the fog!\n", resultDelay);
						print("Your offensive capabilities are no match for their speed! Your men are overrun and split into every direction!\n", resultDelay);
						print("Your troops are savagely torn limb from limb and you barely make it out with the men in your rover alive!\n", resultDelay);
						print("Using your radios you manage to regroup with what is left of your squadron. It's going to a quiet ride back to Terra Nova", resultDelay);
						print("...\n", darkStatementDelay);
						print("\t-" + colony.getPopulation()/2 + " population\n", resourceGainDelay);
						colony.subtractPopulation(colony.getPopulation()/2);
					}
					
				}
				else if (input == 2)
				{
					print("\nAs much as you'd like to save her, you simply can't justify risking everything for one girl.\n", resultDelay);
					print("With a heavy heart, you decide must ignore her cry for help.\n", resultDelay);
					print("You only hope it was the right decision to make", resultDelay);
					print("...\n", darkStatementDelay);
				}
			}
			
			print("\n", resultDelay);
			
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