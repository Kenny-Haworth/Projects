/**
	A text-based video game based off the Netflix series Terra Nova
	(not currently available on Netflix, unfortunately). It ran for one
	season and inspired me to make this game.
	
	This game is currently NOT complete but see "Terra Nova Pseudocode.txt"
	to see a list of planned features.
	
	The basis for this game is the player must make decisions to keep their colony
	healthy each day. Each day is a loop and certain events are randomized.
*/

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.util.InputMismatchException;

public class TerraNova
{
	public static void main(String[] args) throws Exception
	{
		int input;
		int textDelay = 0; //1 is OFF, 0 is ON
		final int loop = 0;
		
		do
		{	
			input = DisplayMainMenu(textDelay);
			//input = 1; //REMOVE THIS LINE
			if (input == 1)
			{
				exposition(textDelay);
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
				tutorial(textDelay);
			}
			else if (input == 4)
			{
				credits(textDelay);
			} 
		}
		while (loop == 0);
	}
	
	public static int DisplayMainMenu(int textDelay) throws Exception
	{
		int input;
		int mainmenuDelay = 8;
		int dinoDelay = 3;
		int questionDelay = 50;
		
		if (textDelay == 1)
		{
			mainmenuDelay = 0;
			dinoDelay = 0;
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
		print("||                              ____        ||\n", dinoDelay);
		print("||                             / *__)       ||\n", dinoDelay);
		print("||                            /  /          ||\n", dinoDelay);
		print("||                           /  /           ||\n", dinoDelay);
		print("||                          /  /            ||\n", dinoDelay);
        print("||                _____    /  /             ||\n", dinoDelay);
	    print("||            ___/     \\__/  /              ||\n", dinoDelay); // Offset one space because of escape character "\"
        print("||           /              /               ||\n", dinoDelay);
        print("||          /               |               ||\n", dinoDelay);
	    print("||         / /|             |               ||\n", dinoDelay);
        print("||        / / |   _______   |               ||\n", dinoDelay);
        print("||       / /  |  |       |  |               ||\n", dinoDelay);
		print("||      /_/   |  |       |  |               ||\n", dinoDelay);
		print("||            |  |       |  |               ||\n", dinoDelay);
		print("||            |__|       |__|               ||\n", dinoDelay);
		print("||                                          ||\n", dinoDelay);																				
		print("||==========================================||\n", dinoDelay);
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
	
	public static void exposition(int textDelay) throws Exception
	{
		int loreDelay = 50;
		
		if (textDelay == 1)
		{
			loreDelay = 0;
		}
		
		print("\n", loreDelay);
		print("Here's the lore.\n", loreDelay);
		print("\n", loreDelay);
	}
	
	public static void tutorial(int textDelay) throws Exception
	{
		int tutorialDelay = 10;
		
		if (textDelay == 1)
		{
			tutorialDelay = 0;
		}
		
		print("\n", tutorialDelay);
		print("Here's the tutorial.\n", tutorialDelay);
		print("\n", tutorialDelay);
	}
	
	public static void credits(int textDelay) throws Exception
	{
		int creditsDelay = 10;
		
		if (textDelay == 1)
		{
			creditsDelay = 0;
		}
		
		print("\n", creditsDelay);
		print("I'm Kenny and I made the game.\n", creditsDelay);
		print("\n", creditsDelay);
	}
	
	
	
	public static void startGame(int textDelay) throws Exception
	{
		ColonyManager colony = new ColonyManager(60, 40, 10, 0, 10, 0); //creates a colony with these base stats
									//happiness, food, population, offense, defense, materials
		int day = 1;
		
		boolean gameOver = false; //special events control
		boolean portal = true;
		boolean lucas = false;
		boolean fairMaiden = false;
		
		boolean rain = false; //weather control
		boolean sunshine = false;
		boolean lightning = false;
		boolean snow = false;
		boolean wind = false;
		boolean fog = false;
		int weatherChance;
		int weather;
		
		int menuDelay = 2;
		int optionDelay = 8;
		int questionDelay = 30;
		int resultDelay = 30;
		int gameOverDelay = 400;
		int attackDelay = 50;
		int endofdayDelay = 10;
		int darkStatementDelay = 500;
		
		int huntMenuDelay = 2;
		int waitAfterQuestionDelay = 750;
		int resourceGainDelay = 125;
		
		if (textDelay == 1) //text delay is turned OFF
		{
			menuDelay = 0;
			optionDelay = 0;
			questionDelay = 0;
			resultDelay = 0;
			gameOverDelay = 0;
			attackDelay = 0;
			endofdayDelay = 0;
			darkStatementDelay = 0;
			
			huntMenuDelay = 0;
			waitAfterQuestionDelay = 0;
			resourceGainDelay = 0;
		}
		
		int input; //declared, uninitialized variables
		int attackStrength;
		int enemyAttack;
		int attackType;
		int Special;
		int rescueSpecial;
		int returnSpecial;
		
		boolean optionNotChosen = true;
		
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
			displayColonyStatistics(colony, menuDelay);
			
			weatherChance = random.nextInt(2) + 1; //%50 chance of weather
			if (weatherChance == 1)
			{
				weather = random.nextInt(6) + 1;
				if (weather == 1)
				{
					rain = true;
					print("It's raining today", resultDelay);
					print("...\n", darkStatementDelay);
					print("\t-10 happiness\n", resourceGainDelay);
					colony.subtractHappiness(10);
				}
				else if (weather == 2)
				{
					sunshine = true;
					print("The sun is out and it's shining brightly today!\n", resultDelay);
					print("\t+10 happiness\n", resourceGainDelay);
					colony.addHappiness(10);
				}
				else if (weather == 3)
				{
					lightning = true;
					print("There's a lightning storm today!\n", resultDelay); //Low chance of someone dying? Maybe make materials harder to get?
				}
				else if (weather == 4)
				{
					snow = true;
					print("It's snowing today!\n", resultDelay);
					print("The increased cold will drive animals into their dens for the day, making them harder to hunt!\n", resultDelay); //Decrease food gains if this condition is set to true
				}
				else if (weather == 5)
				{
					wind = true;
					print("There are high winds today", resultDelay);
					print("...\n", darkStatementDelay);
					print("The wailing of the wind through the trees slowly eats on everyone's nerves", resultDelay);
					print("...\n", darkStatementDelay);
					print("\t-10 offense\n", resourceGainDelay);
					colony.subtractOffense(10);
				}
				else if (weather == 6)
				{
					fog = true;
					print("A dense fog has settled in over the area this morning", resultDelay);
					print("...\n", darkStatementDelay);
					print("You can barely see 15 feet beyond your walls!\n", resultDelay);
					print("This will make it much more difficult to see enemies", resultDelay);
					print("...\n", darkStatementDelay);
					print("\t-10 defense\n", resourceGainDelay);
					colony.subtractDefense(10);
				}
				
				print("\n", resultDelay);
			}
			
			optionNotChosen = true;
			
			while (optionNotChosen)
			{
				do
				{
					print("What would you like to do today", questionDelay);
					print("?", waitAfterQuestionDelay);
					print("\n\n", optionDelay);
					print("\t1) Hold a festival  	(increases population, costs materials)\n", optionDelay);
					print("\n", optionDelay);
					print("\t2) Hold a feast     	(increases happiness, costs food)\n", optionDelay);
					print("\n", optionDelay);
					print("\t3) Go on a hunt     	(increases food, may be dangerous)\n", optionDelay);
					print("\n", optionDelay);
					print("\t4) Gather resources 	(increases materials, may be dangerous)\n", optionDelay);
					
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
						displayColonyStatistics(colony, menuDelay);
					}
					else
					{
						if (!(input == 1 || input == 2 || input == 3 || input == 4))
						{
							print("\nPlease enter 1, 2, 3, or 4.\n\n", optionDelay);
						}
					}
				}
				while (!(input == 1 || input == 2 || input == 3 || input == 4));
				
				print("\n", optionDelay);
				
				if (input == 1)
				{
					do
					{
						print("How big of a festival would you like", questionDelay);
						print("?", waitAfterQuestionDelay);
						print("\n", optionDelay);
						print("\n", optionDelay);
						print("\t1) A Dance        (+5 population,  -10 materials)\n", optionDelay);
						print("\n", optionDelay);
						print("\t2) A Parade       (+10 population, -18 materials)\n", optionDelay);
						print("\n", optionDelay);
						print("\t3) A Play         (+20 population, -30 materials)\n", optionDelay);
						print("\n", optionDelay);
						print("\t4) A Carnival     (+30 population, -45 materials)\n", optionDelay);
						print("\n", optionDelay);
						print("\t5) Go back", optionDelay);
						print("\n", optionDelay);
						
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
							displayColonyStatistics(colony, menuDelay);
						}
						else if (input == 5)
						{
							break;
						}
						else
						{
							if (!(input == 1 || input == 2 || input == 3 || input == 4))
							{
								print("\nPlease enter 1, 2, 3, 4, or 5.\n\n", optionDelay);
							}
							else
							{
								if (input == 1 && colony.getMaterials() < 10)
								{
									print("\nYou need at least 10 materials to hold a dance!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 2 && colony.getMaterials() < 18)
								{
									print("\nYou need at least 18 materials to hold a parade!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 3 && colony.getMaterials() < 30)
								{
									print("\nYou need at least 30 materials to hold a play!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 4 && colony.getMaterials() < 45)
								{
									print("\nYou need at least 45 materials to hold a carnival!\n\n", resultDelay);
									input = -1;
								}
								else
								{
									optionNotChosen = false;
								}
							}
						}
						
						
					}
					while (!(input == 1 || input == 2 || input == 3 || input == 4));
					
					print("\n", optionDelay);
					
					if (input == 1)
					{
						print("Your people enjoyed the lively dancing!\n", resultDelay);
						print("\t +5 population\n", resourceGainDelay);
						print("\t-10 materials\n", resourceGainDelay);
						colony.addPopulation(5);
						colony.subtractMaterials(10);
						enter();
					}
					else if (input == 2)
					{
						print("The people paraded through the streets in ornate costumes!\n", resultDelay);
						print("\t+10 population\n", resourceGainDelay);
						print("\t-18 materials\n", resourceGainDelay);
						colony.addPopulation(10);
						colony.subtractMaterials(18);
						enter();
					}
					else if (input == 3)
					{
						print("Actors performed an amazing play for the entertainment of the people!\n", resultDelay);
						print("\t+20 population\n", resourceGainDelay);
						print("\t-30 materials\n", resourceGainDelay);
						colony.addPopulation(20);
						colony.subtractMaterials(30);
						enter();
					}
					else if (input == 4)
					{
						print("A fair was held with several entertaining games and events!\n", resultDelay);
						print("\t+30 population\n", resourceGainDelay);
						print("\t-45 materials\n", resourceGainDelay);
						colony.addPopulation(30);
						colony.subtractMaterials(45);
						enter();
					}
				}
				else if (input == 2)
				{
					do
					{
						print("How big of a feast would you like", questionDelay);
						print("?", waitAfterQuestionDelay);
						print("\n\n", optionDelay);
						print("\t1) A Picnic                  (+5 happiness,  -10 food)\n", optionDelay);
						print("\n", optionDelay);
						print("\t2) A Banquet                 (+10 happiness, -18 food)\n", optionDelay);
						print("\n", optionDelay);
						print("\t3) A Barbeque                (+20 happiness, -30 food)\n", optionDelay);
						print("\n", optionDelay);
						print("\t4) A huge multi-meal feast!  (+30 happiness, -45 food)\n", optionDelay);
						print("\n", optionDelay);
						print("\t5) Go back", optionDelay);
						print("\n", optionDelay);
						
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
							displayColonyStatistics(colony, menuDelay);
						}
						else if (input == 5)
						{
							break;
						}
						else
						{
							if (!(input == 1 || input == 2 || input == 3 || input == 4))
							{
								print("\nPlease enter 1, 2, 3, 4, or 5.\n\n", optionDelay);
							}
							else
							{
								if (input == 1 && colony.getFood() < 10)
								{
									print("\nYou need at least 10 food to hold a picnic!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 2 && colony.getFood() < 18)
								{
									print("\nYou need at least 18 food to hold a banquet!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 3 && colony.getFood() < 30)
								{
									print("\nYou need at least 30 food to hold a barbeque!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 4 && colony.getFood() < 45)
								{
									print("\nYou need at least 45 food to hold a feast!\n\n", resultDelay);
									input = -1;
								}
								else
								{
									optionNotChosen = false;
								}
							}
						}
					}
					while (!(input == 1 || input == 2 || input == 3 || input == 4));
					
					print("\n", optionDelay);
					
					if (input == 1)
					{
						print("Your people enjoyed a quiet picnic on the green rolling hills just outside the colony gates!\n", resultDelay);
						print("\t +5 happiness\n", resourceGainDelay);
						print("\t-10 food\n", resourceGainDelay);
						colony.addHappiness(5);
						colony.subtractFood(10);
						enter();
					}
					else if (input == 2)
					{
						print("Everyone enjoyed the palete of food at the banquet!\n", resultDelay);
						print("\t+10 happiness\n", resourceGainDelay);
						print("\t-18 food\n", resourceGainDelay);
						colony.addHappiness(10);
						colony.subtractFood(18);
						enter();
					}
					else if (input == 3)
					{
						print("Meat and fish were grilled over open fires and handed out for the barbeque!\n", resultDelay);
						print("\t+20 happiness\n", resourceGainDelay);
						print("\t-30 food\n", resourceGainDelay);
						colony.addHappiness(20);
						colony.subtractFood(30);
						enter();
					}
					else if (input == 4)
					{
						print("Large, long tables were placed together and heaps of food were brought out in the all-you-can-eat feast!\n", resultDelay);
						print("\t+30 happiness\n", resourceGainDelay);
						print("\t-45 food\n", resourceGainDelay);
						colony.addHappiness(30);
						colony.subtractFood(45);
						enter();
					}
				}
				else if (input == 3)
				{
					do
					{
						print("Where would you like to hunt", questionDelay);
						print("?", waitAfterQuestionDelay);
						print("\n", optionDelay);
						print("\n", optionDelay);
						print("\t1) Right Outside the Gates                 (+5 food)\n", huntMenuDelay);
						print("                                                   (no danger)\n", huntMenuDelay); //0 offense requirement
						print("\n", huntMenuDelay);
						print("\t2) The Waterfalls                          (+10 food)\n", huntMenuDelay);
						print("                                                   (low danger)\n", huntMenuDelay); //10
						print("\n", huntMenuDelay);
						print("\t3) The Open Plains                         (+20 food)\n", huntMenuDelay);
						print("                                                   (moderate danger)\n", huntMenuDelay); //35
						print("\n", huntMenuDelay);
						print("\t4) The Deep Forest                         (+30 food)\n", huntMenuDelay);
						print("                                                   (moderate-high danger)\n", huntMenuDelay); //50
						print("\n", huntMenuDelay);
						print("\t5) The Badlands                            (+50 food)\n", huntMenuDelay);
						print("                                                   (high danger)\n", huntMenuDelay); //75
						print("\n", huntMenuDelay);
						print("\t6) The Tyrannosaurus Rex Breeding Grounds  (+60 food)\n", huntMenuDelay);
						print("                                                   (very high danger)\n", huntMenuDelay); //100
						print("\n", huntMenuDelay);
						print("\t7) Go back", huntMenuDelay);
						print("\n", huntMenuDelay);
						
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
							displayColonyStatistics(colony, menuDelay);
						}
						else if (input == 7)
						{
							break;
						}
						else
						{
							if (!(input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 6))
							{
								print("\nPlease enter 1, 2, 3, 4, 5, 6, or 7.\n\n", resultDelay);
							}
							else
							{
								optionNotChosen = false;
							}
						}
					}
					while (!(input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 6));
					
					print("\n", resultDelay);
					
					if (input == 1)
					{
						print("You scavenged the area right outside your gates for food!\n", resultDelay);
						print("You feel safe in the shadow of your walls, but there's not very much food here either", resultDelay);
						print("...\n", darkStatementDelay);
						print("\t+5 food\n", resourceGainDelay);
						colony.addFood(5);
						enter();
					}
					else if (input == 2) //hunting at the waterfalls
					{
						int result = dangerChance(10, colony.getOffense());
						
						if (result == 0) //failure
						{
							print("Your scavenging party hikes to the waterfalls a few miles east of Terra Nova.\n", resultDelay);
							print("You find edible mushrooms and fish in the rivers and streams beneath the waterfalls.\n", resultDelay);
							print("While gathering food, your party suddenly hears long, udulating calls from all around you!\n", resultDelay);
							print("Before you can retreat, half a hundred small Velociraptors, each about the size of your foot, emerge from the foliage and surround you!\n", resultDelay);
							print("Your men try to kick them and fight them off, but the Velociraptors get back up and lunge again!\n", resultDelay);
							print("Unable to win the fight, your party drop their packs and run for it!\n", resultDelay);
							print("Unfortunately, several members of your party trip and fall to the Velociraptors' sharp fangs and are quickly swarmed by them", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return here some other time, you should craft some spears to fend off the Velociraptors", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t-" + colony.getPopulation()/4 + " population\n", resourceGainDelay);
							colony.subtractPopulation(colony.getPopulation()/4);
						}
						else if (result == 1) //success and failure
						{
							print("Your scavenging party hikes to the waterfalls a few miles east of Terra Nova.\n", resultDelay);
							print("You find edible mushrooms and fish in the rivers and streams beneath the waterfalls.\n", resultDelay);
							print("While gathering food, your party suddenly hears long, udulating calls from all around you!\n", resultDelay);
							print("Before you can retreat, half a hundred small Velociraptors, each about the size of your foot, emerge from the foliage and surround you!\n", resultDelay);
							print("Some of you have come with sharp spears and are able to defend yourselves, retreating with the food you have managed to scavenge so far.\n", resultDelay);
							print("However, those without spears can only kick at the Velociraptors, who simply get back up and lunge at them again!\n", resultDelay);
							print("Unable to protect themselves, they panic and run off into the jungle, closely followed by several Velociraptors", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return to the riverbeds some other time, you should consider bringing enough spears for everyone", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t+7 food\n", resourceGainDelay);
							print("\t-3 population\n", resourceGainDelay);
							colony.addFood(7);
							colony.subtractPopulation(3);
						}
						else //result == 2, success
						{
							int attacked = random.nextInt(4) + 1; //25% chance of getting attacked
							
							if (attacked == 1)
							{
								print("Your scavenging party hikes to the waterfalls a few miles east of Terra Nova.\n", resultDelay);
								print("You find edible mushrooms and fish in the rivers and streams beneath the waterfalls.\n", resultDelay);
								print("While gathering food, your party suddenly hears long, udulating calls from all around you!\n", resultDelay);
								print("Half a hundred small Velociraptors, each about the size of your foot, emerge from the foliage and surround you!\n", resultDelay);
								print("Fortunately, you have all come with sharp spears and have no difficulty fending them off.\n", resultDelay);
								print("You gather what you can and return to Terra Nova before dark. The trip was a success!\n", resultDelay);
								print("\t+8 food\n", resourceGainDelay);
								colony.addFood(8);
							}
							else //not attacked
							{
								print("Your scavenging party hikes to the waterfalls only a few miles east of Terra Nova.\n", resultDelay);
								print("You find edible mushrooms and fish in the rivers and streams beneath the waterfalls.\n", resultDelay);
								print("The area is calm and your party is able to fish and gather uninterrupted.\n", resultDelay);
								print("You regroup and return to Terra Nova before dark. The trip was a success!\n", resultDelay);
								print("\t+10 food\n", resourceGainDelay);
								colony.addFood(10);
							}
						}
						
						enter();
					}
					else if (input == 3) //hunting at the open plains
					{
						int result = dangerChance(35, colony.getOffense());
						
						if (result == 0) //failure
						{
							print("Your party travels west to scavenge the green, rolling plains for food.\n", resultDelay);
							print("There appear to be plenty of berries and fruit to pick here.\n", resultDelay);
							print("There are also several packs of docile dinosaurs grazing in the plain and gathered at the watering holes, such as stegosarus, brachiosaurus, ankylosarus, and pteranodons.\n", resultDelay);
							print("\n", darkStatementDelay);
							print("Sometime later, after you have been scavenging for a while, you begin to feel uneasy. There are no longer dinosaurs all around you. They seem to have migrated elsewhere", resultDelay);
							print("...\n", darkStatementDelay);
							print("Suddenly, you hear a deep roar that shakes the trees at the edge of the clearing, and a Therizinosaurus bursts into the open, headed straight for your party!\n", resultDelay);
							print("You are unable to defend yourselves against it's long, sharp claws, so you will have to make it to the safety of the trees at the edge of the clearing!\n", resultDelay);
							print("You all drop your packs and make a run for it, but it catches up to you and slashes several members of your party, bringing them down.\n", resultDelay);
							print("You finally make it to the treeline. As what is left of your party retreat back to Terra Nova, you can hear the screams of your friends behind you as the Therizinosaurus devours them", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return here some other time, you should use some form of transportation to outrun any Therizinosaurs", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t-" + colony.getPopulation()/2 + " population\n", resourceGainDelay);
							colony.subtractPopulation(colony.getPopulation()/2);
						}
						else if (result == 1) //success and failure
						{
							print("Your party travels west to scavenge the green, rolling plains for food on a couple of land buggies.\n", resultDelay);
							print("There appear to be plenty of berries and fruit to pick here.\n", resultDelay);
							print("There are also several packs of docile dinosaurs grazing in the plain and gathered at the watering holes, such as stegosarus, brachiosaurus, ankylosarus, and pteranodons.\n", resultDelay);
							print("\n", darkStatementDelay);
							print("Sometime later, after you have been scavenging for a while, you begin to feel uneasy. There are no longer dinosaurs all around you. They seem to have migrated elsewhere", resultDelay);
							print("...\n", darkStatementDelay);
							print("Suddenly, you hear a deep roar that shakes the trees at the edge of the clearing, and a Therizinosaurus bursts into the open, headed straight for your party!\n", resultDelay);
							print("You are unable to defend yourselves against it's long, sharp claws, but your buggies should be able to reach the safety of the trees at the edge of the clearing before it reaches you.\n", resultDelay);
							print("Unfortunately, there are not enough buggies for everyone. Those unable to find a seat or grab on to a buggy are forced to drop their packs and make a run for it.\n", resultDelay);
							print("You make it to the treeline and everyone in your buggy quickly jump out so you can turn around and pick up the rest of the group that was on foot.\n", resultDelay);
							print("However, before you can make a return trip the Therizinosaur overcomes the members on foot and slashes them to pieces", resultDelay);
							print("...\n", darkStatementDelay);
							print("As what is left of your party retreat back to Terra Nova, you can hear the screams of your friends behind you as the Therizinosaurus devours them", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return here some other time, you should consider bringing enough buggies for everyone to outrun any Therizinosaurs", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t+15 food\n", resourceGainDelay);
							print("\t-5 population\n", resourceGainDelay);
							colony.addFood(15);
							colony.subtractPopulation(5);
						}
						else //result == 2, success
						{
							int attacked = random.nextInt(4) + 1; //25% chance of getting attacked
							
							if (attacked == 1)
							{
								print("Your party travels west to scavenge the green, rolling plains for food on several land buggies.\n", resultDelay);
								print("There appear to be plenty of berries and fruit to pick here.\n", resultDelay);
								print("There are also several packs of docile dinosaurs grazing in the plain and gathered at the watering holes, such as stegosarus, brachiosaurus, ankylosarus, and pteranodons.\n", resultDelay);
								print("\n", darkStatementDelay);
								print("Sometime later, after you have been scavenging for a while, you begin to feel uneasy. There are no longer dinosaurs all around you. They seem to have migrated elsewhere", resultDelay);
								print("...\n", darkStatementDelay);
								print("Suddenly, you hear a deep roar that shakes the trees at the edge of the clearing, and a Therizinosaurus bursts into the open, headed straight for your party!\n", resultDelay);
								print("You are unable to defend yourselves against it's long, sharp claws, but your buggies can easily reach the safety of the trees at the edge of the clearing before it reaches you.\n", resultDelay);
								print("Everyone quickly makes it to the treeline and turn to observe the Therizinosaur.\n", resultDelay);
								print("It appears to have lost interest in your party. Perhaps it was simply looking for some easy prey.\n", resultDelay);
								print("It stomps around the area looking for berries and other fruit. Therizinosaurs are primarily herbivores, afterall.\n", resultDelay);
								print("Since the Therizinosaurus poses no threat, your party is able to continue searching for food, simply keeping a good radius from the beast to prevent angering it.\n", resultDelay);
								print("Your party gathers a good deal of food from picking berries and fruit on the plains and head back to Terra Nova!\n", resultDelay);
								print("\t+18 food\n", resourceGainDelay);
								colony.addFood(18);
							}
							else //not attacked
							{
								print("Your party travels west to scavenge the green, rolling plains for food on several land buggies.\n", resultDelay);
								print("There are also several packs of docile dinosaurs grazing in the plain and gathered at the watering holes, such as stegosarus, brachiosaurus, ankylosarus, and pteranodons.\n", resultDelay);
								print("\n", darkStatementDelay);
								print("Sometime later, your party has easily found a good deal of food from picking berries and other fruit on the plains.\n", resultDelay);
								print("You even managed to take down several small oviraptors for some meat thanks to the speed of your buggies!\n", resultDelay);
								print("\t+20 food\n", resourceGainDelay);
								colony.addFood(20);
							}
						}
						
						enter();
					}
					else if (input == 4) //hunting in the deep forest
					{
						int result = dangerChance(50, colony.getOffense());
						
						if (result == 0) //failure
						{
							print("Your party ventures southwest into the deep forest for food.\n", resultDelay);
							print("There are thousands of trees all around you, growing thick and closely together. Little light penetrates this area due to the dense forest canopy.\n", resultDelay);
							print("Visibility is reduced to around 25 feet in front of you.\n", resultDelay);
							print("Because the trees grow so close together, buggies cannot enter this forest, so all your party has brought to defend yourselves are spears.\n", resultDelay);
							print("It is eerily quiet, and the only sounds you can hear around you are the crunching of twigs and foliage underfoot as you walk", resultDelay);
							print("...\n", darkStatementDelay);
							print("There are several edible vines and creepers in this forest, as well as small berries. You start to harvest what you can find.\n", resultDelay);
							print("The silence and darkness begin to wear on everyones nerves. Perhaps you should consider heading back", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Before you can voice your concerns, your party hears a faint, audible cackling from deeper within the forest.\n", resultDelay);
							print("The sound steadily grows louder. Other voices begin to join in as well, making the cackling yet louder.\n", resultDelay);
							print("Your party forms a tight circle, spears thrust outward, and begin slowly walking back the way you came.\n", resultDelay);
							print("Just as the cackling rises to a climax, you see Utahraptors emerge from the trees. They are easily 6 feet tall and weigh half a ton each.\n", resultDelay);
							print("They begin to circle you, looking for a break in your party's defenses. Your party yells and stabs at the raptors, attempting to hold them back.\n", resultDelay);
							print("However, your makeshift spears are unable to penetrate their thick skin. It seems the Utahraptors realize this as well, and all at once they attack!\n", resultDelay);
							print("Those that aren't immediately taken down by the Utahraptors drop their packs and flee in every direction. As you run, you hear the cries of your friends as they fall to the raptors", resultDelay);
							print("...\n", darkStatementDelay);
							print("You eventually find your way outside the forest and regroup with what is left of your party. It's going to be a long walk back to Terra Nova", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return here some other time, you should consider crafting a weapon strong enough to penetrate the Utahraptors' thick hides", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t-" + (3*colony.getPopulation())/5 + " population\n", resourceGainDelay);
							colony.subtractPopulation((3*colony.getPopulation())/5);
						}
						else if (result == 1) //success and failure
						{
							print("Your party ventures southwest into the deep forest for food.\n", resultDelay);
							print("There are thousands of trees all around you, growing thick and closely together. Little light penetrates this area due to the dense forest canopy.\n", resultDelay);
							print("Visibility is reduced to around 25 feet in front of you.\n", resultDelay);
							print("Because the trees grow so close together, buggies cannot enter this forest, so your party has brought a handful of muskets to defend yourselves. Those without muskets carry spears.\n", resultDelay);
							print("It is eerily quiet, and the only sounds you can hear around you are the crunching of twigs and foliage underfoot as you walk", resultDelay);
							print("...\n", darkStatementDelay);
							print("There are several edible vines and creepers in this forest, as well as small berries. You start to harvest what you can find.\n", resultDelay); 
							print("The silence and darkness begin to wear on everyones nerves. Perhaps you should consider heading back", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Just as you are thinking this, your party hears a faint, audible cackling from deeper within the forest.\n", resultDelay);
							print("The sound steadily grows louder. Other voices begin to join in as well, making the cackling yet louder.\n", resultDelay);
							print("Your party forms a tight circle, with those with spears keeping them thrust outward, and begin slowly walking back the way you came.\n", resultDelay);
							print("Just as the cackling rises to a climax, you see Utahraptors emerge from the trees. They are easily 6 feet tall and weigh half a ton each.\n", resultDelay);
							print("You order each member of your team with a musket to target a different Utahraptor, but not to fire. You know as soon as you fire, they will attack.\n", resultDelay);
							print("You want the raptors to get as close as possible before you fire so you don't miss. The raptors begin to circle your party, looking for any breaks in your defenses.\n", resultDelay);
							print("Once they are close enough, you give the order and your party opens fire! Several Utahraptors immediately fall, but the others pounce on the vulnerable members of your party.\n", resultDelay);
							print("Those that aren't immediately taken down by the Utahraptors quickly reload and fire again, falling yet more raptors.\n", resultDelay);
							print("Realizing they are outmatched, the raptors run off in every direction. You hear their cackling grow fainter as they retreat back into the dark forest", resultDelay);
							print("...\n", darkStatementDelay);
							print("There is a good amount of meat to be harvested from the fallen raptors, but several members of your party died in the fight", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return here some other time, you should consider bringing enough muskets for everyone", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t+25 food\n", resourceGainDelay);
							print("\t-10 population\n", resourceGainDelay);
							colony.addFood(25);
							colony.subtractPopulation(10);
						}
						else //result == 2, success
						{
							int attacked = random.nextInt(4) + 1; //25% chance of getting attacked
							
							if (attacked == 1)
							{
								print("Your party ventures southwest into the deep forest for food.\n", resultDelay);
								print("There are thousands of trees all around you, growing thick and closely together. Little light penetrates this area due to the dense forest canopy.\n", resultDelay);
								print("Visibility is reduced to around 25 feet in front of you.\n", resultDelay);
								print("Because the trees grow so close together, buggies cannot enter this forest, so your party has all brought muskets to defend yourselves.\n", resultDelay);
								print("It is eerily quiet, and the only sounds you can hear around you are the crunching of twigs and foliage underfoot as you walk", resultDelay);
								print("...\n", darkStatementDelay);
								print("There are several edible vines and creepers in this forest, as well as small berries. You harvest more than enough. Perhaps you should consider heading back", resultDelay);
								print("...\n\n", darkStatementDelay);
								print("Just as you are thinking this, your party hears a faint, audible cackling from deeper within the forest.\n", resultDelay);
								print("The sound steadily grows louder. Other voices begin to join in as well, making the cackling yet louder.\n", resultDelay);
								print("Your party forms a tight circle and begin slowly walking back the way you came.\n", resultDelay);
								print("Just as the cackling rises to a climax, you see Utahraptors emerge from the trees. They are easily 6 feet tall and weigh half a ton each.\n", resultDelay);
								print("You order each member of your team with a musket to target a different Utahraptor, but not to fire. You know as soon as you fire, they will attack.\n", resultDelay);
								print("You want the raptors to get as close as possible before you fire so you don't miss. The raptors begin to circle your party, looking for any breaks in your defenses.\n", resultDelay);
								print("Once they are close enough, you give the order and your party opens fire! Over half the Utahraptors immediately fall, discouraging the ones still standing from immediately leaping.\n", resultDelay);
								print("Realizing they are outmatched, the raptors run off in every direction. You hear their cackling grow fainter as they retreat back into the dark forest", resultDelay);
								print("...\n", darkStatementDelay);
								print("There is a good amount of meat to be harvested from the fallen raptors, along with the creepers and berries you already picked.\n", resultDelay);
								print("The trip was a great success!\n", resultDelay);
								print("\t+35 food\n", resourceGainDelay);
								colony.addFood(35);
							}
							else //not attacked
							{
								print("Your party ventures southwest into the deep forest for food.\n", resultDelay);
								print("There are thousands of trees all around you, growing thick and closely together. Little light penetrates this area due to the dense forest canopy.\n", resultDelay);
								print("Visibility is reduced to around 25 feet in front of you.\n", resultDelay);
								print("Because the trees grow so close together, buggies cannot enter this forest, so your party has all brought muskets to defend yourselves.\n", resultDelay);
								print("It is eerily quiet, and the only sounds you can hear around you are the crunching of twigs and foliage underfoot as you walk", resultDelay);
								print("...\n", darkStatementDelay);
								print("There are several edible vines and creepers in this forest, as well small berries. You harvest more than enough. It is time to head back to Terra Nova.\n", resultDelay);
								print("\t+30 food\n", resourceGainDelay);
								colony.addFood(30);
							}
						}
						
						enter();
					}
					else if (input == 5) //hunting at the badlands
					{
						int result = dangerChance(75, colony.getOffense());
						
						if (result == 0) //failure
						{
							print("Your party ventures far southeast into the badlands in search of food.\n", resultDelay);
							print("The badlands are a large, dried-out lake. It looks like a desert, completely flat and barren.\n", resultDelay);
							print("The ground underfoot is hard and cracked, and the sky is a somber grey.\n", resultDelay);
							print("There is nothing living as far as the eye can see. Will you really be able to find food here?\n", resultDelay);
							print("Your party explores deeper into the badlands on small buggies, keeping an eye out for food or enemies", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Sometime later, your party has searched a great deal of the badlands and have no food to show for it. You have only found the skeleton remains of large dinosaurs.\n", resultDelay);
							print("Your party begins to head back to Terra Nova. When you are about halfway through the badlands on your way back, one of the members of your team points and shouts.\n", resultDelay);
							print("Off in the distance behind you is something very small rapidly heading towards you. It's too far away to make out clearly", resultDelay);
							print("...\n", darkStatementDelay);
							print("A minute later, someone else points out a second object, this one in front of you, and then a third object on your left!\n", resultDelay);
							print("As they grow closer, you begin to make out the shape of an Allosaurus!\n", resultDelay);
							print("Allosaurs are smart and vicious carnivores, over 30 feet tall with a weight of at least 2 metric tons. They hunt in packs to corner their prey.\n", resultDelay);
							print("Your buggies are too slow to outrun them, so you'll have to fight. You wonder if the muskets you brought will be enough to fend them off", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("The battle is short and brutal. Your muskets draw blood but the Allosaurs seem unperturbed.\n", resultDelay);
							print("They immobilize your buggies by flipping them or stomping on them, and then proceed to methodically crush your team members in their jaws one by one.\n", resultDelay);
							print("Those that weren't stunned when the buggies crashed take off running in every direction.\n", resultDelay);
							print("You will be unable to outrun the Allosaurs, and there is nowhere to hide on this flat terrain.\n", resultDelay);
							print("The only way to survive is if the Allosaurs choose to chase after someone running in the opposite direction instead of you", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Later, you finally make it back to Terra Nova. Nobody else has made it back except for you.\n", resultDelay);
							print("Perhaps if you decide to return to the badlands some other time, you should consider bringing something powerful enough to kill Allosaurs", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t-" + (10 + (3*colony.getPopulation())/5) + " population\n", resourceGainDelay);
							colony.subtractPopulation(10 + ((3*colony.getPopulation())/5));
						}
						else if (result == 1) //success and failure
						{
							print("Your party ventures far southeast into the badlands in search of food.\n", resultDelay);
							print("The badlands are a large, dried-out lake. It looks like a desert, completely flat and barren.\n", resultDelay);
							print("The ground underfoot is hard and cracked, and the sky is a somber grey.\n", resultDelay);
							print("There is nothing living as far as the eye can see. Will you really be able to find food here?\n", resultDelay);
							print("Your party explores deeper into the badlands on small buggies, keeping an eye out for food or enemies", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Sometime later, your party has searched a great deal of the badlands and have no food to show for it. You have only found the skeleton remains of large dinosaurs.\n", resultDelay);
							print("Your party begins to head back to Terra Nova. When you are about halfway through the badlands on your way back, one of the members of your team points and shouts.\n", resultDelay);
							print("Off in the distance behind you is something very small rapidly heading towards you. It's too far away to make out clearly", resultDelay);
							print("...\n", darkStatementDelay);
							print("A minute later, someone else points out a second object, this one in front of you, and then a third object on your left!\n", resultDelay);
							print("As they grow closer, you begin to make out the shape of an Allosaurus!\n", resultDelay);
							print("Allosaurs are smart and vicious carnivores, over 30 feet tall with a weight of at least 2 metric tons. They hunt in packs to corner their prey.\n", resultDelay);
							print("Your buggies are too slow to outrun them, so you'll have to fight. Some of your men have assault rifles, and the rest have muskets.\n", resultDelay);
							print("Hopefully it is enough to fend them off.\n", resultDelay);
							print("\n", darkStatementDelay);
							print("The battle is short and brutal. As soon as the Allosaurs are in range your party concentrates fire on one and bring it down.\n", resultDelay);
							print("The muskets draw blood but the Allosaurs seem unperturbed by them. The assault rifles seem to be the only thing that phases them.\n", resultDelay);
							print("The remaining two Allosaurs immobilize your buggies by flipping them or stomping on them, and then proceed to methodically crush your team members in their jaws one by one.\n", resultDelay);
							print("Those that weren't stunned when the buggies crashed quickly reload and concentrate fire on the second Allosaur, bringing it down as well.\n", resultDelay);
							print("The final Allosaur flees, realizing it is outmatched. There will be a plethora of meat to harvest from the two dead Allosaurs, but it was at the cost of several of your friend's lives", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return to the badlands some other time, you should consider bringing enough assault rifles for everyone", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t+40 food\n", resourceGainDelay);
							print("\t-15 population\n", resourceGainDelay);
							colony.addFood(40);
							colony.subtractPopulation(15);
						}
						else //result == 2, success
						{
							int attacked = random.nextInt(5) + 1; //80% chance of getting attacked, otherwise no food for you!
							
							if (attacked == 1) //not attacked
							{
								print("Your party ventures far southeast into the badlands in search of food.\n", resultDelay);
								print("The badlands are a large, dried-out lake. It looks like a desert, completely flat and barren.\n", resultDelay);
								print("The ground underfoot is hard and cracked, and the sky is a somber grey.\n", resultDelay);
								print("There is nothing living as far as the eye can see. Will you really be able to find food here?\n", resultDelay);
								print("Your party explores deeper into the badlands on small buggies, keeping an eye out for food or enemies", resultDelay);
								print("...\n\n", darkStatementDelay);
								print("Sometime later, your party has searched a great deal of the badlands and have no food to show for it. You have only found the skeleton remains of large dinosaurs.\n", resultDelay);
								print("The ride back to Terra Nova is uneventful. Perhaps this is just bad luck", resultDelay);
								print("...\n", darkStatementDelay);
							}
							else //attacked, get food
							{
								print("Your party ventures far southeast into the badlands in search of food.\n", resultDelay);
								print("The badlands are a large, dried-out lake. It looks like a desert, completely flat and barren.\n", resultDelay);
								print("The ground underfoot is hard and cracked, and the sky is a somber grey.\n", resultDelay);
								print("There is nothing living as far as the eye can see. Will you really be able to find food here?\n", resultDelay);
								print("Your party explores deeper into the badlands on small buggies, keeping an eye out for food or enemies", resultDelay);
								print("...\n\n", darkStatementDelay);
								print("Sometime later, your party has searched a great deal of the badlands and have no food to show for it. You have only found the skeleton remains of large dinosaurs.\n", resultDelay);
								print("Your party begins to head back to Terra Nova. When you are about halfway through the badlands on your way back, one of the members of your team points and shouts.\n", resultDelay);
								print("Off in the distance behind you is something very small rapidly heading towards you. It's too far away to make out clearly", resultDelay);
								print("...\n", darkStatementDelay);
								print("A minute later, someone else points out a second object, this one in front of you, and then a third object on your left!\n", resultDelay);
								print("As they grow closer, you begin to make out the shape of an Allosaurus!\n", resultDelay);
								print("Allosaurs are smart and vicious carnivores, over 30 feet tall with a weight of at least 2 metric tons. They hunt in packs to corner their prey.\n", resultDelay);
								print("Your buggies are too slow to outrun them, so you'll have to fight. All of your men have assault rifles, so you are confident in your ability to bring the beasts down.\n", resultDelay);
								print("\n", darkStatementDelay);
								print("The battle is short and brutal. As soon as the Allosaurs are in range, half your party concentrate fire on the first and half your party fire at the second.\n", resultDelay);
								print("Both Allosaur's fall, and the final Allosaur flees, realizing it is outmatched. There will be a plethora of meat to harvest from the two dead Allosaurs!\n", resultDelay);
								print("\t+50 food\n", resourceGainDelay);
								colony.addFood(50);
							}
						}
						
						enter();
					}
					else if (input == 6) //hunting at the t-rex breeding grounds
					{
						int result = dangerChance(100, colony.getOffense());
						
						if (result == 0) //failure
						{
							print("Your party travels far north into Tyrannosaurus territory for food.\n", resultDelay);
							print("Lush jungle surrounds you. There is plenty of fruit and berries to pick.\n", resultDelay);
							print("It seems herbivores do not venture into this region, which is why there is so much food", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Sometime later, your party has harvested a great deal of food and are ready to head back to Terra Nova.\n", resultDelay);
							print("As you walk back, you feel a faint rumbling in the toes of your feet. You glance at a puddle of water next to you.\n", resultDelay);
							print("Ripples emanate from the center of the puddle and spread outward during each rumble.\n", resultDelay);
							print("An earthquake? No", resultDelay);
							print("...\n", darkStatementDelay);
							print("The rumbling is growing steadily louder. It's massive footsteps!\n", resultDelay);
							print("A terrible roar splits the air! It's a T-rex!\n", resultDelay);
							print("Your party has brought assault rifles as defense, but in this thick jungle the rex isn't visible until it is almost directly on top of you!\n", resultDelay);
							print("Unable to get many shots off, the rex quickly crushes and devours whoever is in it's path!\n", resultDelay);
							print("Fortunately, it is easy to drop your packs, run, and hide in the jungle, although the rex still manages to get a few of you", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Later, you finally make it back to Terra Nova and regroup with the others. Thankfully, almost all the members of your party have made it back.\n", resultDelay);
							print("That wasn't so bad!\n", resultDelay);
							print("\t-5 population\n", resourceGainDelay);
							colony.subtractPopulation(5);
							enter();
							
							print("You sit with your hunting party in the safety of Terra Nova's walls and begin to recover.\n", resultDelay);
							print("You drink your fill from your water canteen and look deep into it, reflecting on the men you lost today", resultDelay);
							print("...\n", darkStatementDelay);
							print("...and the water ripples...\n", darkStatementDelay);
							print("Your eyes widen. Suddenly wide awake, you shout at the top of your lungs, ", resultDelay);
							print("\"T-REX! RAISE THE DEFENSES! EVERYONE ON THE WALLS!!!\"\n", attackDelay);
							print("Everyone stares at you, thinking you surely must be reliving the traumatic event earlier today.\n", resultDelay);
							print("But the shaking grows stronger, and you yell yet again.\n", resultDelay);
							print("Beginning to realize the situation, the wall guards spring to life and beginning arming the outter walls with your strongest weapons.\n", resultDelay);
							print("The beast must have perceived you entering it's territory as a threat, and followed your scent back to Terra Nova!\n", resultDelay);
							print("Before your men can fully prepare, it emerges into the clearing surrounding the outer walls and charges!\n", resultDelay);
							print("It tears an opening into the wall and savagely begins to crush and destroy everything in it's path", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("The battle was long and bloody, but the beast finally falls. Terra Nova is in ruins.\n", resultDelay);
							print("There are several holes in the walls, your weapons cache was destroyed, and nearly all the houses and buildings were demolished.\n", resultDelay);
							print("The granary was crushed in the battle as well. The meat from the rex will not be enough to replace the food that was lost.\n", resultDelay);
							print("It will take all your materials to rebuild Terra Nova.\n", resultDelay);
							print("Almost everyone died", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return to the T-rex breeding grounds some other time, you should consider bringing something powerful enough to kill a rex", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t-50 happiness\n", resourceGainDelay);
							print("\t-" + (5*colony.getFood())/6 + " food\n", resourceGainDelay);
							print("\t-" + (4*colony.getPopulation())/5 + " population\n", resourceGainDelay);
							print("\t-30 offense\n", resourceGainDelay);
							print("\t-40 defense\n", resourceGainDelay);
							print("\t-" + colony.getMaterials() + " materials\n", resourceGainDelay);
							
							colony.subtractHappiness(50);
							colony.subtractFood((5*colony.getFood())/6);
							colony.subtractPopulation((4*colony.getPopulation())/5);
							colony.subtractOffense(30);
							colony.subtractDefense(40);
							colony.subtractMaterials(colony.getMaterials());
						}
						else if (result == 1) //success and failure
						{
							print("Your party travels far north into Tyrannosaurus territory for food.\n", resultDelay);
							print("Lush jungle surrounds you. There is plenty of fruit and berries to pick.\n", resultDelay);
							print("It seems herbivores do not venture into this region, which is why there is so much food", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Sometime later, your party has harvested a great deal of food and are ready to head back to Terra Nova.\n", resultDelay);
							print("As you walk back, you feel a faint rumbling in the toes of your feet. You glance at a puddle of water next to you.\n", resultDelay);
							print("Ripples emanate from the center of the puddle and spread outward during each rumble.\n", resultDelay);
							print("An earthquake? No", resultDelay);
							print("...\n", darkStatementDelay);
							print("The rumbling is growing steadily louder. It's massive footsteps!\n", resultDelay);
							print("A terrible roar splits the air! It's a T-rex!\n", resultDelay);
							print("Your party has brought assault rifles and a rocket launcher as defense, but in this thick jungle the rex isn't visible until it is almost directly on top of you!\n", resultDelay);
							print("Luckily, your man with the rocket launcher manages to land a direct hit on the rex, severely wounding it.\n", resultDelay);
							print("However, the rex still manages to crush and devour several members of your team before you can bring it down.\n", resultDelay);
							print("At least the animal will make for some good meat in addition to all the fruit and berries you harvested", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return to the T-rex breeding grounds some other time, you should consider bringing a second rocket launcher", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t+55 food\n", resourceGainDelay);
							print("\t-20 population\n", resourceGainDelay);
							colony.addFood(55);
							colony.subtractPopulation(20);
						}
						else //result == 2, success
						{
							int attacked = random.nextInt(4) + 1; //25% chance of getting attacked, increases food gains
							
							if (attacked == 1) //attacked
							{
								print("Your party travels far north into Tyrannosaurus territory for food.\n", resultDelay);
								print("Lush jungle surrounds you. There is plenty of fruit and berries to pick.\n", resultDelay);
								print("It seems herbivores do not venture into this region, which is why there is so much food", resultDelay);
								print("...\n\n", darkStatementDelay);
								print("Sometime later, your party has harvested a great deal of food and are ready to head back to Terra Nova.\n", resultDelay);
								print("As you walk back, you feel a faint rumbling in the toes of your feet. You glance at a puddle of water next to you.\n", resultDelay);
								print("Ripples emanate from the center of the puddle and spread outward during each rumble.\n", resultDelay);
								print("An earthquake? No", resultDelay);
								print("...\n", darkStatementDelay);
								print("The rumbling is growing steadily louder. It's massive footsteps!\n", resultDelay);
								print("A terrible roar splits the air! It's a T-rex!\n", resultDelay);
								print("Your party has brought assault rifles and a couple of rocket launchers as defense!\n", resultDelay);
								print("Luckily, your men with the rocket launchers manage to land direct hits, severely wounding the rex.\n", resultDelay);
								print("It is a simple matter from there to bring it down with the assault rifles.\n", resultDelay);
								print("It will make for some great meat in addition to all the fruit and berries you harvested!\n", resultDelay);
								print("\t+65 food\n", resourceGainDelay);
								colony.addFood(65);
							}
							else //not attacked
							{
								print("Your party travels far north into Tyrannosaurus territory for food.\n", resultDelay);
								print("Lush jungle surrounds you. There is plenty of fruit and berries to pick.\n", resultDelay);
								print("It seems herbivores do not venture into this region, which is why there is so much food", resultDelay);
								print("...\n\n", darkStatementDelay);
								print("Sometime later, your party has harvested a great deal of food and are ready to head back to Terra Nova.\n", resultDelay);
								print("The expedition was successful and uneventful!\n", resultDelay);
								print("\t+60 food\n", resourceGainDelay);
								colony.addFood(60);
							}
						}
						
						enter();
					}
				}
				else if (input == 4)
				{
					do
					{
						print("Where would you like to gather resources", questionDelay);
						print("?", waitAfterQuestionDelay);
						print("\n\n", optionDelay);
						print("\t1) Right Outside the Gates      (+5 materials, no danger)\n", optionDelay); //0
						print("\n", optionDelay);
						print("\t2) The Riverbeds                (+10 materials, low danger)\n", optionDelay); //10 danger value
						print("\n", optionDelay);
						print("\t3) The Cove                     (+20 materials, moderate danger)\n", optionDelay); //35
						print("\n", optionDelay);
						print("\t4) The Caves                    (+30 materials, moderate-high danger)\n", optionDelay); //50
						print("\n", optionDelay);
						print("\t5) The Volcano                  (+50 materials, high danger)\n", optionDelay); //75
						print("\n", optionDelay);
						print("\t6) Go back", optionDelay);
						print("\n", optionDelay);
						
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
							displayColonyStatistics(colony, menuDelay);
						}
						else if (input == 6)
						{
							break;
						}
						else
						{
							if (!(input == 1 || input == 2 || input == 3 || input == 4 || input == 5))
							{
								print("\nPlease enter 1, 2, 3, 4, 5, or 6.\n\n", optionDelay);
							}
							else
							{
								optionNotChosen = false;
							}
						}
					}
					while (!(input == 1 || input == 2 || input == 3 || input == 4 || input == 5));
					
					print("\n", resultDelay);
					
					if (input == 1) //gathering materials right outside the gates
					{
						print("You scavenged the area right outside your gates for materials!\n", resultDelay);
						print("You feel safe in the shadow of your walls, but there's not very many materials here either", resultDelay);
						print("...\n", darkStatementDelay);
						print("\t+5 materials\n", resourceGainDelay);
						colony.addMaterials(5);
						enter();
					}
					else if (input == 2) //gathering materials at the riverbeds
					{
						int result = dangerChance(10, colony.getOffense());
						
						if (result == 0) //failure
						{
							print("Your party heads east to scavenge for materials at the riverbeds.\n", resultDelay);
							print("There is wood and hardened stones here that will be good for making tools.\n", resultDelay);
							print("As you are gathering, you notice a small dinosaur standing on a nearby boulder, observing the party.\n", resultDelay);
							print("You point it out to everyone else. The dinosaur cocks its head. It seems harmless enough, so your party continues to gather.\n", resultDelay);
							print("You feel like you know this dinosaur from somewhere, but you're not sure where", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Sometime later, one of your men gets too close to the dinosaur. It shrieks, and a large fan bristles out on either side of its neck!\n", resultDelay);
							print("You recognize it now, it's a Dilophosaurus! The Dilophosaur spits venom into the face of the man who stumbled too close!\n", resultDelay);
							print("The man falls to the ground, clutching his eyes from the venom!\n", resultDelay);
							print("Not satisfied, the Dilo turns to the rest of your party and approaches, making hissing noises like a rattle snake!\n", resultDelay);
							print("The hissing seems to have attracted other Dilophosaurs as well! You have brought nothing to fight with, and will have to run!\n", resultDelay);
							print("Your party drop their packs and take off, but the Dilophosaurs manage to pick off several of you by pouncing with their sharp claws", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return to the riverbeds some other time, you should consider bringing something to fend the Dilophosaurs off", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t-" + colony.getPopulation()/4 + " population\n", resourceGainDelay);
							colony.subtractPopulation(colony.getPopulation()/4);
						}
						else if (result == 1) //success and failure
						{
							print("Your party heads east to scavenge for materials at the riverbeds.\n", resultDelay);
							print("There is wood and hardened stones here that will be good for making tools.\n", resultDelay);
							print("As you are gathering, you notice a small dinosaur standing on a nearby boulder, observing the party.\n", resultDelay);
							print("You point it out to everyone else. The dinosaur cocks its head. It seems harmless enough, so your party continues to gather.\n", resultDelay);
							print("You feel like you know this dinosaur from somewhere, but you're not sure where", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Sometime later, one of your men gets too close to the dinosaur. It shrieks, and a large fan bristles out on either side of its neck!\n", resultDelay);
							print("You recognize the dinosaur now, it's a Dilophosaurus! The Dilophosaur spits venom into the face of the man who stumbled too close!\n", resultDelay);
							print("The man falls to the ground, clutching his eyes from the venom!\n", resultDelay);
							print("The Dilo turns to the rest of your party and advances, making hissing noises like a rattle snake!\n", resultDelay);
							print("The hissing seems to have attracted other Dilophosaurs as well! You have brought a few spears to fight with, so your party tries to fend them off!\n", resultDelay);
							print("To keep a good distance from the spitting poison, you hurl the spears at the Dilophosaurs. They easily bring them down or severely injure them.\n", resultDelay);
							print("However, your party does not have enough spears to take out all the Dilophosaurs. After your party has thrown the few you have, you are defenseless.\n", resultDelay);
							print("Some of your men run to pull their spears out of the Dilophosaurs they have already hit, while your men without spears throw sharp stones at the Dilo's.\n", resultDelay);
							print("Eventually your party emerges victorious, but the Dilophosaurs managed to pick off several of you by pouncing with their sharp claws", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return to the riverbeds some other time, you should consider bringing enough spears for everyone", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t+7 materials\n", resourceGainDelay);
							print("\t-3 population\n", resourceGainDelay);
							colony.addMaterials(7);
							colony.subtractPopulation(3);
						}
						else //result == 2, success
						{
							int attacked = random.nextInt(4) + 1; //25% chance of getting attacked
							
							if (attacked == 1) //attacked
							{
								print("Your party heads east to scavenge for materials at the riverbeds.\n", resultDelay);
								print("There is wood and hardened stones here that will be good for making tools.\n", resultDelay);
								print("As you are gathering, you notice a small dinosaur standing on a nearby boulder, observing the party.\n", resultDelay);
								print("You point it out to everyone else. The dinosaur cocks its head. It seems harmless enough, so your party continues to gather.\n", resultDelay);
								print("You feel like you know this dinosaur from somewhere, but you're not sure where", resultDelay);
								print("...\n\n", darkStatementDelay);
								print("Sometime later, one of your men gets too close to the dinosaur. It shrieks, and a large fan bristles out on either side of its neck!\n", resultDelay);
								print("You recognize the dinosaur now, it's a Dilophosaurus! The Dilophosaur spits venom into the face of the man who stumbled too close!\n", resultDelay);
								print("The man falls to the ground, clutching his eyes from the venom!\n", resultDelay);
								print("The Dilo turns to the rest of your party and advances, making hissing noises like a rattle snake!\n", resultDelay);
								print("The hissing seems to have attracted other Dilophosaurs as well! You have all brought spears to fight with, and engage the Dilophosaurs!\n", resultDelay);
								print("To keep a good distance from the spitting poison, you hurl the spears at the Dilophosaurs. They easily bring them down or injure them.\n", resultDelay);
								print("Your party emerges victorious! Luckily, the effects of the poison were temporary and your man who was hit at the beginning of the fight has recovered.\n", resultDelay);
								print("Your party is exhausted from the fight and decide to head back to Terra Nova.\n", resultDelay);
								print("\t+8 materials\n", resourceGainDelay);
								colony.addMaterials(8);
							}
							else //not attacked
							{
								print("Your party heads east to scavenge for materials at the riverbeds.\n", resultDelay);
								print("There is wood and hardened stones here that will be good for making tools.\n", resultDelay);
								print("You gather all that is worth salvaging. The trip is uneventful and you all head back to Terra Nova.\n", resultDelay);
								print("\t+10 materials\n", resourceGainDelay);
								colony.addMaterials(10);
							}
						}
						
						enter();
					}
					else if (input == 3) //gathering materials at the cove
					{
						int result = dangerChance(35, colony.getOffense());
						
						if (result == 0) //failure
						{
							print("Your party ventures to the far west to look for materials. It is a several hour walk to reach the sea.\n", resultDelay);
							print("A natural, circular cove has formed here, leaving a calm bay with gentle waves.\n", resultDelay);
							print("There appear to be plenty of scrap and driftwood washed ashore here as well.\n", resultDelay);
							print("Your party begins to pick through the sand, salvaging anything useful.\n", resultDelay);
							print("Some of your men enter the water to dive for small treasures buried in the sand bar.\n", resultDelay);
							print("\n", darkStatementDelay);
							print("Sometime later, you notice your men in the water struggling to overcome large waves.\n", resultDelay);
							print("It strikes you as odd that such large waves are forming in such a gentle cove", resultDelay);
							print("...\n", darkStatementDelay);
							print("You peer out over the surface of the water to find the source of the disturbance and see a fin sticking up out of the water!\n", resultDelay);
							print("You immediately think of a shark, but a shark couldn't be making waves that large.\n", resultDelay);
							print("What's more, this fin is huge, at least as tall as you are, and sticks up out of the water like a half circle, unlike the typical triangle fins sharks have.\n", resultDelay);
							print("You shout at your men in the water to get out of the bay, pointing towards the fin. The scavengers on the shore begin to run toward you to regroup.\n", resultDelay);
							print("Before the men in the water can reach the shoreline, the fin rises out of the water and a Spinosaurus is revealed, rapidly swimming straight towards your men!\n", resultDelay);
							print("Your men are slow and sluggish in the water, and the Spinosaurus easily overcomes them. You can do nothing for them.\n", resultDelay);
							print("The best thing you can do now is run. However, the Spinosaur emerges from the water and reveals it's uncanny ability to run on land just as fast as it swims in water!\n", resultDelay);
							print("You all drop your packs to run faster, but several of you are picked off by the beast before you can finally lose it", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return here some other time, you should consider bringing some form of transportation to outrun the Spinosaur", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t-" + colony.getPopulation()/2 + " population\n", resourceGainDelay);
							colony.subtractPopulation(colony.getPopulation()/2);
						}
						else if (result == 1) //success and failure
						{
							print("Your party ventures to the far west to look for materials.\n", resultDelay);
							print("Your men take turns riding the buggies and walking, since there are not enough buggies for everyone to ride in.\n", resultDelay);
							print("You reach the western sea by high noon.\n", resultDelay);
							print("A natural, circular cove has formed here, leaving a calm bay with gentle waves.\n", resultDelay);
							print("There appear to be plenty of scrap and driftwood washed ashore here as well.\n", resultDelay);
							print("Your party begins to pick through the sand, salvaging anything useful.\n", resultDelay);
							print("Some of your men enter the water to dive for small treasures buried in the sand bar.\n", resultDelay);
							print("\n", darkStatementDelay);
							print("Sometime later, you notice your men in the water struggling to overcome large waves.\n", resultDelay);
							print("It strikes you as odd that such large waves are forming in such a gentle cove", resultDelay);
							print("...\n", darkStatementDelay);
							print("You peer out over the surface of the water to find the source of the disturbance and see a fin sticking up out of the water!\n", resultDelay);
							print("You immediately think of a shark, but a shark couldn't be making waves that large.\n", resultDelay);
							print("What's more, this fin is huge, at least as tall as you are, and sticks up out of the water like a half circle, unlike the typical triangle fins sharks have.\n", resultDelay);
							print("You shout at your men in the water to get out of the bay, pointing towards the fin. The scavengers on the shore begin to run toward you to regroup.\n", resultDelay);
							print("Before the men in the water can reach the shoreline, the fin rises out of the water and a Spinosaurus is revealed, rapidly swimming straight towards your men!\n", resultDelay);
							print("Your men are slow and sluggish in the water, and the Spinosaurus easily overcomes them. You can do nothing for them.\n", resultDelay);
							print("The best thing you can do now is run. The Spinosaur emerges from the water and reveals it's uncanny ability to run on land just as fast as it swims in water!\n", resultDelay);
							print("Luckily, your buggies are fast enough to lose it, and all the scavengers can hop on since half of your men are still in the water.\n", resultDelay);
							print("However, this leaves the divers at the mercy of the Spinosaur, as it turns to reenter the water and finish them off", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return here some other time, you should consider keeping an eye out for the Spinosaur and bring enough buggies for everyone", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t+15 materials\n", resourceGainDelay);
							print("\t-5 population\n", resourceGainDelay);
							colony.addMaterials(15);
							colony.subtractPopulation(5);
						}
						else //result == 2, success
						{
							int attacked = random.nextInt(4) + 1; //25% chance of getting attacked
							
							if (attacked == 1) //attacked
							{
								print("Your party ventures to the far west to look for materials.\n", resultDelay);
								print("Your men are all able to ride buggies, making the long trip much faster.\n", resultDelay);
								print("You make good time reaching the western sea.\n", resultDelay);
								print("A natural, circular cove has formed here, leaving a calm bay with gentle waves.\n", resultDelay);
								print("There appear to be plenty of scrap and driftwood washed ashore here as well.\n", resultDelay);
								print("Your party begins to pick through the sand, salvaging anything useful.\n", resultDelay);
								print("Some of your men enter the water to dive for small treasures buried in the sand bar.\n", resultDelay);
								print("\n", darkStatementDelay);
								print("Sometime later, you notice your men in the water struggling to overcome large waves.\n", resultDelay);
								print("It strikes you as odd that such large waves are forming in such a gentle cove", resultDelay);
								print("...\n", darkStatementDelay);
								print("You peer out over the surface of the water to find the source of the disturbance and see a fin sticking up out of the water!\n", resultDelay);
								print("You immediately think of a shark, but a shark couldn't be making waves that large.\n", resultDelay);
								print("What's more, this fin is huge, at least as tall as you are, and sticks up out of the water like a half circle, unlike the typical triangle fins sharks have.\n", resultDelay);
								print("You shout at your men in the water to get out of the bay, pointing towards the fin. The scavengers on the shore begin to run toward you to regroup.\n", resultDelay);
								print("Your divers in the water reach the shore just as the fin rises out of the water and a Spinosaurus is revealed, swimming straight towards you!\n", resultDelay);
								print("The best thing you can do now is run. The Spinosaur emerges from the water and reveals it's uncanny ability to run on land just as fast as it swims in water!\n", resultDelay);
								print("Luckily, your buggies are fast enough to lose it, and there is enough buggies for everyone to ride in.\n", resultDelay);
								print("The Spinosaur quickly loses interest, but continues to territorially patrol the cove.\n", resultDelay);
								print("It would be best to leave it alone for the time being. Your weapons are not strong enough to take it down without great risk.\n", resultDelay);
								print("You still have managed to obtain a sizable amount of materials. The expedition was a success!\n", resultDelay);
								print("\t+18 materials\n", resourceGainDelay);
								colony.addMaterials(18);
							}
							else //not attacked
							{
								print("Your party ventures to the far west to look for materials.\n", resultDelay);
								print("Your men are all able to ride buggies, making the long trip much faster.\n", resultDelay);
								print("You make good time reaching the western sea.\n", resultDelay);
								print("A natural, circular cove has formed here, leaving a calm bay with gentle waves.\n", resultDelay);
								print("There appear to be plenty of scrap and driftwood washed ashore here as well.\n", resultDelay);
								print("Your party begins to pick through the sand, salvaging anything useful.\n", resultDelay);
								print("Some of your men enter the water to dive for small treasures buried in the sand bar.\n", resultDelay);
								print("\n", darkStatementDelay);
								print("Sometime later, you look across the sea and see the sun stretching towards the horizon.\n", resultDelay);
								print("You estimate there is little over an hours worth of light left.\n", resultDelay);
								print("Your party has obtained a good amount of materials. The trip was successful and uneventful.\n", resultDelay);
								print("It is time to head back to Terra Nova.\n", resultDelay);
								print("\t+20 materials\n", resourceGainDelay);
								colony.addMaterials(20);
							}
						}
						
						enter();
					}
					else if (input == 4) //gathering materials in the caves
					{
						int result = dangerChance(50, colony.getOffense());
						
						if (result == 0) //failure
						{
							print("Your party ventures south towards the mountains to gather materials.\n", resultDelay);
							print("The climate is much colder and wetter in this region. The terrain becomes rocky and steeply inclined.\n", resultDelay);
							print("You find large cave openings that lead deep into the mountain. The caves are damp and dark.\n", resultDelay);
							print("The caves narrow further in, so your party splits into small groups, with each group tackling a different cave entrance.\n", resultDelay);
							print("You have brought pickaxes to mine the precious stones in these caves.\n", resultDelay);
							print("The stones will be good for making tools and reinforcing Terra Nova's walls.\n", resultDelay);
							print("Your group stays near enough to the cave's entrance to have enough light to see with.\n", resultDelay);
							print("\n", darkStatementDelay);
							print("Sometime later, your group has ventured farther into the cave in the search of more stones now that your eyes have adjusted to the darkness.\n", resultDelay);							
							print("Suddenly, a bright pair of orange eyes blaze out of the darkness, staring directly at you!\n", resultDelay);							
							print("Your group turns and begin stumbling through the dark back towards the cave entrance, but turning your backs was a bad idea!\n", resultDelay);							
							print("With a shriek, the eyes leap forward with astounding speed, and you can make out razor-sharp teeth sink into the leg of the man next to you!\n", resultDelay);							
							print("He yells but quickly falls unconscious! It seems the bite of this animal has some sort of venomous effect to immobilize their prey!\n", resultDelay);							
							print("You all drop your packs and run for the cave entrance, cutting yourselves on jagged rocks and rough cave walls as you feel towards the exit.\n", resultDelay);							
							print("Several of your men fall to the beast. Some try to strike at it with their pickaxes but it is too fast to take in close quarters.\n", resultDelay);
							print("You finally see the way out and emerge into the sunlight. You turn and see the glowing orange eyes slowly take form.\n", resultDelay);							
							print("It's a Troodon! It pauses momentarily as it enters the light, shrieks, and then continues to chase after you!\n", resultDelay);							
							print("As you run, you see the other groups shout and run out of their caves as well, with more Troodons chasing after them!\n", resultDelay);
							print("\n", darkStatementDelay);
							print("You eventually shake off the Troodons and regroup with what is left of your party.\n", resultDelay);
							print("You all want to return and help those that fell to the Troodons, but you know it will only end worse, as you have nothing to fight them with", resultDelay);
							print("...\n", darkStatementDelay);
							print("For now, you will have to hope they escape the Troodons and make it back to Terra Nova", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return here some other time, you should consider crafting a weapon that can take out the Troodons from a distance", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t-" + (3*colony.getPopulation())/5 + " population\n", resourceGainDelay);
							colony.subtractPopulation((3*colony.getPopulation())/5);
						}
						else if (result == 1) //success and failure
						{
							print("Your party ventures south towards the mountains to gather materials.\n", resultDelay);
							print("The climate is much colder and wetter in this region. The terrain becomes rocky and steeply inclined.\n", resultDelay);
							print("You find large cave openings that lead deep into the mountain. The caves are damp and dark.\n", resultDelay);
							print("The caves narrow further in, so your party splits into small groups, with each group tackling a different cave entrance.\n", resultDelay);
							print("You have brought a few muskets to protect yourselves and pickaxes to mine the precious stones in these caves.\n", resultDelay);
							print("The stones will be good for making tools and reinforcing Terra Nova's walls.\n", resultDelay);
							print("Your group stays near enough to the cave's entrance to have enough light to see with.\n", resultDelay);
							print("\n", darkStatementDelay);
							print("Sometime later, your group has ventured farther into the cave in the search of more stones now that your eyes have adjusted to the darkness.\n", resultDelay);							
							print("Suddenly, a bright pair of orange eyes blaze out of the darkness, staring directly at you!\n", resultDelay);
							print("Wielding a musket, you quickly get a shot off, flinging the eyes back into the darkness as you hear the beast shriek from the impact.\n", resultDelay);
							print("You reload but the cave has fallen silent. It seems there are no other attackers. You check on the beast and discover it is a Troodon!\n", resultDelay);
							print("Troodons are vicious cave-dwellers, with bites that render their prey unconscious. The one before you has a row of sharp teeth and long claws.\n", resultDelay);
							print("Not every group had someone with a musket. You should check on them to make sure they are okay", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("As your group finds their way out of the cave and emerge into the sunlight, you are met with shouts and screams!\n", resultDelay);							
							print("The other groups are running from their caves, closely followed by Troodons!\n", resultDelay);
							print("You and musket-wielders from other groups join to help take them out.\n", resultDelay);
							print("Your party eventually kill enough of them to force the remaining Troodons back into the caves.\n", resultDelay);
							print("It will not be safe to return to the caves for now.\n", resultDelay);
							print("Several groups still have the stones they mined, but it was at the cost of several lives", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return here some other time, you should consider bringing enough muskets for everyone", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t+25 materials\n", resourceGainDelay);
							print("\t-10 population\n", resourceGainDelay);
							colony.addMaterials(25);
							colony.subtractPopulation(10);
						}
						else //result == 2, success
						{
							int attacked = random.nextInt(4) + 1; //75% chance of getting attacked
							
							if (attacked == 1) //not attacked
							{
								print("Your party ventures south towards the mountains to gather materials.\n", resultDelay);
								print("The climate is much colder and wetter in this region. The terrain becomes rocky and steeply inclined.\n", resultDelay);
								print("You find large cave openings that lead deep into the mountain. The caves are damp and dark.\n", resultDelay);
								print("The caves narrow further in, so your party splits into small groups, with each group tackling a different cave entrance.\n", resultDelay);
								print("You have all brought muskets to protect yourselves and pickaxes to mine the precious stones in these caves.\n", resultDelay);
								print("The stones will be good for making tools and reinforcing Terra Nova's walls.\n", resultDelay);
								print("Your group stays near enough to the cave's entrance to have enough light to see with.\n", resultDelay);
								print("\n", darkStatementDelay);
								print("Sometime later, your group has ventured farther into the cave in the search of more stones now that your eyes have adjusted to the darkness.\n", resultDelay);							
								print("Your group gathers all you can carry and meet back up with the other groups. The mining trip was a great success!\n", resultDelay);
								print("\t+35 materials\n", resourceGainDelay);
								colony.addMaterials(35);
							}
							else //attacked
							{
								print("Your party ventures south towards the mountains to gather materials.\n", resultDelay);
								print("The climate is much colder and wetter in this region. The terrain becomes rocky and steeply inclined.\n", resultDelay);
								print("You find large cave openings that lead deep into the mountain. The caves are damp and dark.\n", resultDelay);
								print("The caves narrow further in, so your party splits into small groups, with each group tackling a different cave entrance.\n", resultDelay);
								print("You have all brought muskets to protect yourselves and pickaxes to mine the precious stones in these caves.\n", resultDelay);
								print("The stones will be good for making tools and reinforcing Terra Nova's walls.\n", resultDelay);
								print("Your group stays near enough to the cave's entrance to have enough light to see with.\n", resultDelay);
								print("\n", darkStatementDelay);
								print("Sometime later, your group has ventured farther into the cave in the search of more stones now that your eyes have adjusted to the darkness.\n", resultDelay);							
								print("Suddenly, a bright pair of orange eyes blaze out of the darkness, staring directly at you!\n", resultDelay);
								print("Wielding a musket, you quickly get a shot off, flinging the eyes back into the darkness as you hear the beast shriek from the impact.\n", resultDelay);
								print("You reload but the cave has fallen silent. It seems there are no other attackers. You check on the beast and discover it is a Troodon!\n", resultDelay);
								print("Troodons are vicious cave-dwellers, with bites that render their prey unconscious. The one before you has a row of sharp teeth and long claws.\n", resultDelay);
								print("The other groups had muskets as well, but you should check on them to make sure they are okay.\n", resultDelay);
								print("\n", darkStatementDelay);
								print("As your group finds their way out and emerge into the sunlight, you find the other groups were also attacked by Troodons but are safe.\n", resultDelay);							
								print("Continuing to mine will be risky now that you know Troodons are in the area. You have all already managed to mine a good deal of resources.\n", resultDelay);
								print("It is time to head back to Terra Nova.\n", resultDelay);
								print("\t+30 materials\n", resourceGainDelay);
								colony.addMaterials(30);
							}
						}
						
						enter();
					}
					else if (input == 5) //gathering materials at the volcano, 50 mats
					{
						int result = dangerChance(75, colony.getOffense());
						
						if (result == 0) //failure
						{
							print("Your party ventures northwest towards the volcano to gather materials.\n", resultDelay);
							print("The climate begins to grow hotter, the terrain becomes rocky, and the trees and foliage become sparser as you near the volcano.\n", resultDelay);
							print("You are eventually hiking uphill in the open, with no cover for miles.\n", resultDelay);
							print("However, this makes you feel safe, as you are confident you can spot any predators from miles away before they can reach you.\n", resultDelay);
							print("You hope there will be enough materials at the volcano's peak to make the trip worthwhile", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Sometime later, your party is nearing the peak. It is starting to get very hot. You shield your eyes from the sun and look around.\n", resultDelay);
							print("Instead of seeing the blue, open sky you see large dots on your vision. You blink rapidly to clear it, but the dots stay there.\n", resultDelay);
							print("You must be looking at clouds, because the objects are over 50 feet wide. But these clouds are a solid brown. The color looks more like a bird", resultDelay);
							print("...\n", darkStatementDelay);
							print("As you ponder the nature of the objects, they suddenly become much closer, no more than a hundred feet above the ground!\n", resultDelay);
							print("You can make them out clearly now! They're Quetzalcoatlus! Massive, flying carnivores! You warn your party as the Quetzals dive towards you!\n", resultDelay);
							print("\n", darkStatementDelay);
							print("Unfortunately, there is not very much your party can do in defense.\n", resultDelay);
							print("Muskets are the only form of protection you have brought, but they seem only to be a thorn to the Quetzals, making them squawk louder and attack with more energy.\n", resultDelay);
							print("The barren landscape that once seemed to protect you from predators is now a trap, as you will be unable to lose the Quetzals until you make it to the treeline!\n", resultDelay);							
							print("Your men are picked up by the Quetzals strong forearms, flown high into the sky, and released.\n", resultDelay);
							print("As you run the miles back to forest's edge, you hear the sickening sound of their bones snapping as they hit the hard earth all around you", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("You make it back to safety, but none of your men have made it back with you. It is time to go back to Terra Nova", resultDelay);
							print("...\n", darkStatementDelay);
							print("Perhaps if you decide to return to the volcano some other time, you should consider bringing something powerful enough to kill Quetzals", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t-" + (10 + (3*colony.getPopulation())/5) + " population\n", resourceGainDelay);
							colony.subtractPopulation(10 + ((3*colony.getPopulation())/5));
						}
						else if (result == 1) //success and failure
						{
							print("Your party ventures northwest towards the volcano to gather materials.\n", resultDelay);
							print("The climate begins to grow hotter, the terrain becomes rocky, and the trees and foliage become sparser as you near the volcano.\n", resultDelay);
							print("You are eventually hiking uphill in the open, with no cover for miles.\n", resultDelay);
							print("However, this makes you feel safe, as you are confident you can spot any predators from miles away before they can reach you.\n", resultDelay);
							print("You hope there will be enough materials at the volcano's peak to make the trip worthwhile", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Sometime later, your party is nearing the peak. It is starting to get very hot. You shield your eyes from the sun and look around.\n", resultDelay);
							print("Instead of seeing the blue, open sky you see large dots on your vision. You blink rapidly to clear it, but the dots stay there.\n", resultDelay);
							print("You must be looking at clouds, because the objects are over 50 feet wide. But these clouds are a solid brown. The color looks more like a bird", resultDelay);
							print("...\n", darkStatementDelay);
							print("As you ponder the nature of the objects, they suddenly become much closer, no more than a hundred feet above the ground!\n", resultDelay);
							print("You can make them out clearly now! They're Quetzalcoatlus! Massive, flying carnivores! You warn your party as the Quetzals dive towards you!\n", resultDelay);
							print("\n", darkStatementDelay);
							print("The barren landscape that once seemed to protect from predators is now a trap, as you will be unable to lose the Quetzals unless you can make it to treeline miles away.\n", resultDelay);							
							print("Your party has brought muskets and a few assault rifles as defense, so it will be better to stand and fight with what weapons you have.\n", resultDelay);
							print("The Quetzals pick up your men with their strong forearms, fly them high into the sky, and release them.\n", resultDelay);
							print("As you fight, you hear the sickening sound of their bones snapping as they hit the hard earth all around you.\n", resultDelay);
							print("Your party fire round after round into the Quetzals, but the muskets are only a thorn to the them, making them squawk louder and attack with more energy.\n", resultDelay);
							print("Luckily, the assault rifles manage to bring several of them down. They are able to shoot the Quetzals from much further away with a faster fire rate.\n", resultDelay);
							print("\n", darkStatementDelay);
							print("After a long and bloody battle, your party is victorious.\n", resultDelay);
							print("Many lives were lost, but their sacrifices will mean nothing if you do not reach the peak and get resources from this trip.\n", resultDelay);
							print("What is left of your party push to the peak and find a plethora of volcanic rock, obsidian, and precious stones.\n", resultDelay);
							print("Your party gathers until they are exhausted from the previous battle and the heat, and you all begin the long trek home", resultDelay);
							print("...\n\n", darkStatementDelay);
							print("Perhaps if you decide to return to the volcano some other time, you should consider bringing more assault rifles to kill any Quetzals that attack", resultDelay);
							print("...\n", darkStatementDelay);
							print("\t+40 materials\n", resourceGainDelay);
							print("\t-15 population\n", resourceGainDelay);
							colony.addMaterials(40);
							colony.subtractPopulation(15);
						}
						else //result == 2, success
						{
							int attacked = random.nextInt(4) + 1; //25% chance of getting attacked
							
							if (attacked == 1)
							{
								print("Your party ventures northwest towards the volcano to gather materials.\n", resultDelay);
								print("The climate begins to grow hotter, the terrain becomes rocky, and the trees and foliage become sparser as you near the volcano.\n", resultDelay);
								print("You are eventually hiking uphill in the open, with no cover for miles.\n", resultDelay);
								print("However, this makes you feel safe, as you are confident you can spot any predators from miles away before they can reach you.\n", resultDelay);
								print("You hope there will be enough materials at the volcano's peak to make the trip worthwhile", resultDelay);
								print("...\n\n", darkStatementDelay);
								print("Sometime later, your party is nearing the peak. It is starting to get very hot. You shield your eyes from the sun and look around.\n", resultDelay);
								print("Instead of seeing the blue, open sky you see large dots on your vision. You blink rapidly to clear it, but the dots stay there.\n", resultDelay);
								print("You must be looking at clouds, because the objects are over 50 feet wide. But these clouds are a solid brown. The color looks more like a bird", resultDelay);
								print("...\n", darkStatementDelay);
								print("As you ponder the nature of the objects, they suddenly become much closer, no more than a hundred feet above the ground!\n", resultDelay);
								print("You can make them out clearly now! They're Quetzalcoatlus! Massive, flying carnivores! You warn your party as the Quetzals dive towards you!\n", resultDelay);
								print("\n", darkStatementDelay);
								print("Your party has brought assault rifles as defense, so your men unload on the diving Quetzals!\n", resultDelay);
								print("Since everyone has a rifle, you are able to stand your ground and take out the Quetzals before they can grab anyone and fly off with them.\n", resultDelay);
								print("The battle is short, and your party is victorious. The landscape is once again silent.\n", resultDelay);
								print("You push to the peak of the volcano and find a plethora of volcanic rock, obsidian, and precious stones.\n", resultDelay);
								print("Your party gathers until they are exhausted from the previous battle and the heat, and you all begin the long trek home.\n", resultDelay);
								print("The trip was a success!\n", resultDelay);
								print("\t+45 materials\n", resourceGainDelay);
								colony.addMaterials(45);
							}
							else //not attacked
							{
								print("Your party ventures northwest towards the volcano to gather materials.\n", resultDelay);
								print("The climate begins to grow hotter, the terrain becomes rocky, and the trees and foliage become sparser as you near the volcano.\n", resultDelay);
								print("You are eventually hiking uphill in the open, with no cover for miles.\n", resultDelay);
								print("However, this makes you feel safe, as you are confident you can spot any predators from miles away before they can reach you.\n", resultDelay);
								print("You hope there will be enough materials at the volcano's peak to make the trip worthwhile", resultDelay);
								print("...\n\n", darkStatementDelay);
								print("You finally reach the peak of the volcano and find a plethora of volcanic rock, obsidian, and precious stones.\n", resultDelay);
								print("Your party gathers all they can carry and you begin the long trek home.\n", resultDelay);
								print("The trip was a great success!\n", resultDelay);
								print("\t+50 materials\n", resourceGainDelay);
								colony.addMaterials(50);
							}
						}
						
						enter();
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
						
					print("Your defense: " + colony.getDefense() + "\n", attackDelay);
					print("Dino attack strength:", attackDelay);
					print(" " + attackStrength + "", waitAfterQuestionDelay);
					print("\n", attackDelay);
					
					if (colony.getDefense() > attackStrength)
					{
						print("You fought the dinosaurs out of your territory!\n", resultDelay);
						enter();
					}
					else if (colony.getDefense() < attackStrength)
					{
						print("The dinosaurs have overrun your base!\n", resultDelay);
						print("GAME OVER!\n", gameOverDelay);
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
						
						print("Your defense: " + colony.getDefense() + "\n", attackDelay);
						print("Dino attack strength: " + attackStrength + "\n", attackDelay);
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
							print("GAME OVER!\n", gameOverDelay);
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
						
						print("Your defense: " + colony.getDefense() + "\n", attackDelay);
						print("Sixer attack strength: " + attackStrength + "\n", attackDelay);
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
							print("GAME OVER!\n", gameOverDelay);
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
			
			optionNotChosen = true;
			
			while (optionNotChosen)
			{
				do
				{
					print("Would you like to use materials to increase offensive or defensive capabilities", questionDelay);
					print("?", waitAfterQuestionDelay);
					print("\n\n", optionDelay);
					print("\t1) Increase Offense\n", optionDelay);
					print("\n", optionDelay);
					print("\t2) Increase Defense\n", optionDelay);
					print("\n", optionDelay);
					print("\t3) Continue to Next Day\n", optionDelay);
					
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
						displayColonyStatistics(colony, menuDelay);
					}
					else
					{
						if (!(input == 1 || input == 2 || input == 3))
						{
							print("\nPlease enter 1, 2, or 3.\n\n", resultDelay);
						}
					}
				}
				while (!(input == 1 || input == 2 || input == 3));
				
				print("\n", resultDelay);
				
				if (input == 1)
				{
					do
					{
						print("||=============== Offensive Upgrades ===============||\n", menuDelay);
						print("\n", optionDelay);
						print("\t1) Spears      (+ 5 offense, -15 materials)\n", optionDelay);
						print("\n", optionDelay);
						print("\t2) Guns        (+10 offense, -40 materials)\n", optionDelay);
						print("\n", optionDelay);
						print("\t3) Ballistas   (+20 offense, -100 materials)\n", optionDelay); // try tamed dinos as offense (requires food(each day)?)
						print("\n", optionDelay);
						print("\t4) Go back", optionDelay);
						print("\n", optionDelay);
						
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
							displayColonyStatistics(colony, menuDelay);
						}
						else if (input == 4)
						{
							break;
						}
						else
						{
							if (!(input == 1 || input == 2 || input == 3))
							{
								print("\nPlease enter 1, 2, 3, or 4.\n\n", resultDelay);
							}
							else
							{
								if (input == 1 && colony.getMaterials() < 15)
								{
									print("\nYou need at least 15 materials to craft spears!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 2 && colony.getMaterials() < 40)
								{
									print("\nYou need at least 40 materials to craft guns!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 3 && colony.getMaterials() < 100)
								{
									print("\nYou need at least 100 materials to craft ballistas!\n\n", resultDelay);
									input = -1;
								}
								else
								{
									optionNotChosen = false;
								}
							}
						}
					}
					while (!(input == 1 || input == 2 || input == 3));
					
					print("\n", resultDelay);
					
					if (input == 1)
					{
						print("Your people have made spears from hide, flint, stone, and wood!\n", resultDelay);
						print("\t +5 offense\n", resourceGainDelay);
						print("\t-15 materials\n\n", resourceGainDelay);
						colony.addOffense(5);
						colony.subtractMaterials(15);
					}
					else if (input == 2)
					{
						print("Your people have fashioned guns using resources from the portal!\n", resultDelay); // Only Display choice for guns if portal is true (set it up
						print("\t+10 offense\n", resourceGainDelay);									   // for higher values of materials, after Lucas should be done)
						print("\t-40 materials\n\n", resourceGainDelay);
						colony.addOffense(10);
						colony.subtractMaterials(40);
					}
					else if (input == 3)
					{
						print("Your men have put together ballistas using leather, wood, and metal!\n", resultDelay); //
						print("\t +20 offense\n", resourceGainDelay);
						print("\t-100 materials\n\n", resourceGainDelay);
						colony.addOffense(20);
						colony.subtractMaterials(100);
					}
				}
				else if (input == 2)
				{
					do
					{
						print("||=============== Defensive Upgrades ===============||\n", menuDelay);
						print("\n", optionDelay);
						print("\t1) Reinforced Walls       (+5 defense, -15 materials)\n", optionDelay);
						print("\n", optionDelay);
						print("\t2) Personal Body Armor   (+10 defense, -40 materials)\n", optionDelay);
						print("\n", optionDelay);
						print("\t3) Trenches              (+20 defense, -100 materials)\n", optionDelay);
						print("\n", optionDelay);
						print("\t4) Go back", optionDelay);
						print("\n", optionDelay);
						
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
							displayColonyStatistics(colony, menuDelay);
						}
						else if (input == 4)
						{
							print("\n", optionDelay);
							break;
						}
						else
						{
							if (!(input == 1 || input == 2 || input == 3))
							{
								print("\nPlease enter 1, 2, 3, or 4.\n\n", resultDelay);
							}
							else
							{
								if (input == 1 && colony.getMaterials() < 15)
								{
									print("\nYou need at least 15 materials to create reinforced walls!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 2 && colony.getMaterials() < 40)
								{
									print("\nYou need at least 40 materials to make personal body armor!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 3 && colony.getMaterials() < 100)
								{
									print("\nYou need at least 100 materials to dig trenches!\n\n", resultDelay);
									input = -1;
								}
								else
								{
									optionNotChosen = false;
								}
							}
						}
					}
					while (!(input == 1 || input == 2 || input == 3));
					
					if (input == 1)
					{
						print("\nYour people have reinforced the wall with hide, stone, and wood!\n", resultDelay);
						print("\t +5 defense\n", resourceGainDelay);
						print("\t-15 materials\n", resourceGainDelay);
						print("\n", resourceGainDelay);
						kb.nextLine();
						colony.addDefense(5);
						colony.subtractMaterials(15);
					}
					else if (input == 2)
					{
						print("\nYour people have made personal body armor from dinosaur hide!\n", resultDelay); // Only this choice if survived
						print("\t+10 defense\n", resourceGainDelay);									 	           // 10 dino attacks or something
						print("\t-40 materials\n", resourceGainDelay);
						print("\n", resourceGainDelay);
						kb.nextLine();
						colony.addDefense(10);
						colony.subtractMaterials(40);
					}
					else if (input == 3)
					{
						print("\nYour people dug trenches using iron shovels!\n", resultDelay);
						print("\t +20 defense\n", resourceGainDelay);
						print("\t-100 materials\n", resourceGainDelay);
						print("\n", resourceGainDelay);
						colony.addDefense(20);
						colony.subtractMaterials(100);
					}
				}
				else if (input == 3)
				{
					optionNotChosen = false;
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
			
			if (rain == true)
			{
				rain = false;
				print("\nThe rain seems to have finally died down at the end of the day!\n", resultDelay);
				print("You see a rainbow form off in the distance", resultDelay);
				print("...\n", darkStatementDelay);
				print("The Jurassic Age truly holds a beautiful world", resultDelay);
				print("...\n", darkStatementDelay);
				print("\t+10 happiness\n", resourceGainDelay);
				colony.addHappiness(10);
			}
			else if (sunshine == true)
			{
				sunshine = false;
				print("\nThe bright, orange sun has finally sunk beneath the horizon at the end of the day", resultDelay);
				print("...\n", darkStatementDelay);
				print("Everyone's mood darkens as the world is once again cast into shadows", resultDelay);
				print("...\n", darkStatementDelay);
				print("\t-10 happiness\n", resourceGainDelay);
				colony.subtractHappiness(10);
			}
			else if (lightning == true)
			{
				lightning = false;
				print("\nThe lightning storm has finally died down at the end of the day!\n", resultDelay); //end negative status effect
			}
			else if (snow == true)
			{
				snow = false;
				print("\nThe snow has finally stopped, and the animals are slowly re-emerging from their dens and homes!\n", resultDelay); //end negative status effect
			}
			else if (wind == true)
			{
				wind = false;
				print("\nThe howling gale of wind has finally ended at the end of the day!\n", resultDelay);
				print("Your guards finally relax as the world once again falls quiet and peaceful.\n", resultDelay);
				print("\t+10 offense\n", resourceGainDelay);
				colony.addOffense(10);
			}
			else if (fog == true)
			{
				fog = false;
				print("\nThe fog finally has begun to lift at the end of the day!\n", resultDelay);
				print("Your men are now at ease, being able to see far beyond your walls once more.\n", resultDelay);
				print("\t+10 defense\n", resourceGainDelay);
				colony.addDefense(10);
			}
			
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
						displayColonyStatistics(colony, menuDelay);
					}
					else
					{
						if (!(input == 1 || input == 2))
						{
							print("\nPlease enter only 1 or 2.\n\n", optionDelay);
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
			
			print("||=================== End of Day " + day + " ===================||\n", endofdayDelay);
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

	public static void displayColonyStatistics(ColonyManager colony, int menuDelay) throws InterruptedException
	{
		int happinessLen = Integer.toString(colony.getHappiness()).length() - 1;
		int foodLen = Integer.toString(colony.getFood()).length() - 1;
		int populationLen = Integer.toString(colony.getPopulation()).length() - 1;
		int offenseLen = Integer.toString(colony.getOffense()).length() - 1;
		int defenseLen = Integer.toString(colony.getDefense()).length() - 1;
		int materialsLen = Integer.toString(colony.getMaterials()).length() - 1;
		
		print("||====================================================||\n", menuDelay);
		print("||                                                    ||\n", menuDelay);
		print("||       Happiness        Food        Population      ||\n", menuDelay);     
		
		printBoxes(happinessLen, foodLen, populationLen, colony.getHappiness(), colony.getFood(), colony.getPopulation(), menuDelay);
		
		print("||                                                    ||\n", menuDelay);
		
		if (materialsLen == 1)
		{
			print("||        Offense       Defense        Materials      ||\n", menuDelay);
		}
		else
		{
			print("||        Offense       Defense       Materials       ||\n", menuDelay);
		}
		
		printBoxes(offenseLen, defenseLen, materialsLen, colony.getOffense(), colony.getDefense(), colony.getMaterials(), menuDelay);
		
		print("||                                                    ||\n", menuDelay);
		print("||====================================================||\n", menuDelay);
		enter();
	}
	
	/**
		@param firstLen, secondLen, and thirdLen: The number of digits of the stat - 1.
		@param first, second, and third: the actual stat
		@param menuDelay: the delay
		
		@note Fun fact, there are 27x27 possible combinations of menu's to be generated, or 729. By using a "smart" method such as this,
			  the required if statements can be brought down to just 49 by taking into account the number of digits of each stat and
			  the total spacing from either side of the menu. Special thanks to Ryan Bucinell for the idea behind this.
	*/
	public static void printBoxes(int firstLen, int secondLen, int thirdLen, int first, int second, int third, int menuDelay) throws InterruptedException
	{
		for (int i = 0; i < 3; i++)
		{
			if (firstLen == 0) //spaces from the side
			{
				print("||       ||", menuDelay);
			}
			else if (firstLen == 1)
			{
				print("||     ||", menuDelay);
			}
			else //firstLen == 2
			{
				print("||      ||", menuDelay);
			}
			
			if (firstLen == 0) //equals in the middle
			{
				if (i == 0)
				{
					print("=====", menuDelay);
				}
				else if (i == 1)
				{
					print("  " + first + "  ", menuDelay);
				}
				else //i == 2
				{
					print("=====", menuDelay);
				}
			}
			else if (firstLen == 1)
			{
				if (i == 0)
				{
					print("========", menuDelay);
				}
				else if (i == 1)
				{
					print("   " + first + "   ", menuDelay);
				}
				else //i == 2
				{
					print("========", menuDelay);
				}
			}
			else //firstLen == 2
			{
				if (i == 0)
				{
					print("=======", menuDelay);
				}
				else if (i == 1)
				{
					print("  " + first + "  ", menuDelay);
				}
				else //i == 2
				{
					print("=======", menuDelay);
				}
			}
			
			if (firstLen == 0 && secondLen == 0) //spaces inbetween
			{
				print("||     ||", menuDelay);
			}
			else if (firstLen == 0 || secondLen == 0)
			{
				print("||    ||", menuDelay);
			}
			else
			{
				print("||   ||", menuDelay);
			}
			
			if (secondLen == 0) //spaces in the middle
			{
				if (i == 0)
				{
					print("=====", menuDelay);
				}
				else if (i == 1)
				{
					print("  " + second + "  ", menuDelay);
				}
				else //i == 2
				{
					print("=====", menuDelay);
				}
			}
			else if (secondLen == 1)
			{
				if (i == 0)
				{
					print("========", menuDelay);
				}
				else if (i == 1)
				{
					print("   " + second + "   ", menuDelay);
				}
				else //i == 2
				{
					print("========", menuDelay);
				}
			}
			else //secondLen == 2
			{
				if (i == 0)
				{
					print("=======", menuDelay);
				}
				else if (i == 1)
				{
					print("  " + second + "  ", menuDelay);
				}
				else //i == 2
				{
					print("=======", menuDelay);
				}
			}
			
			if (secondLen == 0 && thirdLen == 0) //spaces inbetween
			{
				print("||     ", menuDelay);
			}
			else if (secondLen == 0 || thirdLen == 0)
			{
				print("||    ", menuDelay);
			}
			else
			{
				print("||   ", menuDelay);
			}
			
			if (secondLen != 1)
			{
				print(" ", menuDelay);
			}
			
			print("||", menuDelay);
			
			if (thirdLen == 0) //spaces in the middle
			{
				if (i == 0)
				{
					print("=====", menuDelay);
				}
				else if (i == 1)
				{
					print("  " + third + "  ", menuDelay);
				}
				else //i == 2
				{
					print("=====", menuDelay);
				}
			}
			else if (thirdLen == 1)
			{
				if (i == 0)
				{
					print("========", menuDelay);
				}
				else if (i == 1)
				{
					print("   " + third + "   ", menuDelay);
				}
				else //i == 2
				{
					print("========", menuDelay);
				}
			}
			else //thirdLen == 2
			{
				if (i == 0)
				{
					print("=======", menuDelay);
				}
				else if (i == 1)
				{
					print("  " + third + "  ", menuDelay);
				}
				else //i == 2
				{
					print("=======", menuDelay);
				}
			}
			
			if (thirdLen == 0) //spaces from the side
			{
				print("||       ||\n", menuDelay);
			}
			else if (thirdLen == 1)
			{
				print("||     ||\n", menuDelay);
			}
			else //thirdLen == 2
			{
				print("||      ||\n", menuDelay);
			}
		}
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