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
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.InputMismatchException;
import java.io.IOException;

public class TerraNova
{
	public static void main(String[] args) throws Exception
	{
		int input;
		int textDelay = 1; //1 is OFF, 0 is ON
		final int loop = 0;
		
		do
		{	
			//input = DisplayMainMenu(textDelay);
			input = 1; //REMOVE THIS LINE
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
					System.out.println("Text delay has been turned off.");
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
		
		print("||==========================================||\n", dinoDelay);
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
		int happiness = 60; //base stats
		int food = 40;
		int population = 10;
		int offense = 0;
		int defense = 10;
		int materials = 10;
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
			print(" \n", darkStatementDelay);
			displayColonyStatistics(happiness, food, population, offense, defense, materials, menuDelay);
			
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
					happiness -= 10;
				}
				else if (weather == 2)
				{
					sunshine = true;
					print("The sun is out and it's shining brightly today!\n", resultDelay);
					print("\t+10 happiness\n", resourceGainDelay);
					happiness += 10;
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
					offense -= 10;
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
					defense -= 10;
				}
			}
			
			optionNotChosen = true;
			
			print("\n", optionDelay);
			
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
						displayColonyStatistics(happiness, food, population, offense, defense, materials, menuDelay);
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
							displayColonyStatistics(happiness, food, population, offense, defense, materials, menuDelay);
						}
						else if (input == 5)
						{
							break;
						}
						else
						{
							if (!(input == 1 || input == 2 || input == 3 || input == 4))
							{
								print("\nPlease enter 1, 2, 3, or 4.\n\n", optionDelay);
							}
							else
							{
								if (input == 1 && materials < 10)
								{
									print("\nYou need at least 10 materials to hold a dance!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 2 && materials < 18)
								{
									print("\nYou need at least 18 materials to hold a parade!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 3 && materials < 30)
								{
									print("\nYou need at least 30 materials to hold a play!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 4 && materials < 45)
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
						population += 5;
						materials -= 10;
						print("Your people enjoyed the lively dancing!\n", resultDelay);
						print("\t +5 population\n", resourceGainDelay);
						print("\t-10 materials\n", resourceGainDelay);
						enter();
					}
					else if (input == 2)
					{
						population += 10;
						materials -= 18;
						print("The people paraded through the streets in ornate costumes!\n", resultDelay);
						print("\t+10 population\n", resourceGainDelay);
						print("\t-18 materials\n", resourceGainDelay);
						enter();
					}
					else if (input == 3)
					{
						population += 20;
						materials -= 30;
						print("Actors performed an amazing play for the entertainment of the people!\n", resultDelay);
						print("\t+20 population\n", resourceGainDelay);
						print("\t-30 materials\n", resourceGainDelay);
						enter();
					}
					else if (input == 4)
					{
						population += 30;
						materials -= 45;
						print("A fair was held with several entertaining games and events!\n", resultDelay);
						print("\t+30 population\n", resourceGainDelay);
						print("\t-45 materials\n", resourceGainDelay);
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
							displayColonyStatistics(happiness, food, population, offense, defense, materials, menuDelay);
						}
						else if (input == 5)
						{
							break;
						}
						else
						{
							if (!(input == 1 || input == 2 || input == 3 || input == 4))
							{
								print("\nPlease enter 1, 2, 3, or 4.\n\n", optionDelay);
							}
							else
							{
								if (input == 1 && food < 10)
								{
									print("\nYou need at least 10 food to hold a picnic!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 2 && food < 18)
								{
									print("\nYou need at least 18 food to hold a banquet!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 3 && food < 30)
								{
									print("\nYou need at least 30 food to hold a barbeque!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 4 && food < 45)
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
						happiness += 5;
						food -= 10;
						print("Your people enjoyed a quiet picnic on the green rolling hills just outside the colony gates!\n", resultDelay);
						print("\t +5 happiness\n", resourceGainDelay);
						print("\t-10 food\n", resourceGainDelay);
						enter();
					}
					else if (input == 2)
					{
						happiness += 10;
						food -= 18;
						print("Everyone enjoyed the palete of food at the banquet!\n", resultDelay);
						print("\t+10 happiness\n", resourceGainDelay);
						print("\t-18 food\n", resourceGainDelay);
						enter();
					}
					else if (input == 3)
					{
						happiness += 20;
						food -= 30;
						print("Meat and fish were grilled over open fires and handed out for the barbeque!\n", resultDelay);
						print("\t+20 happiness\n", resourceGainDelay);
						print("\t-30 food\n", resourceGainDelay);
						enter();
					}
					else if (input == 4)
					{
						happiness += 30;
						food -= 45;
						print("Large, long tables were placed together and heaps of food were brought out in the all-you-can-eat feast!\n", resultDelay);
						print("\t+30 happiness\n", resourceGainDelay);
						print("\t-45 food\n", resourceGainDelay);
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
							displayColonyStatistics(happiness, food, population, offense, defense, materials, menuDelay);
						}
						else if (input == 7)
						{
							break;
						}
						else
						{
							if (!(input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 6))
							{
								print("\nPlease enter 1, 2, 3, 4, 5, or 6.\n\n", resultDelay);
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
						food += 5;
						print("You scavenged the area right outside your gates!\n", resultDelay);
						print("\t+5 food\n", resourceGainDelay);
						enter();
					}
					else if (input == 2) //hunting at the waterfalls
					{
						food += 10;
						print("You raided the waterfalls for food!\n", TimeUnit.MILLISECONDS, resultDelay);
						print("\t+10 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
						enter();
					}
					else if (input == 3) //hunting at the open plains
					{
						food += 20;
						print("Your people successfully hunted small dinosaurs and found food out on the open plains!\n", resultDelay);
						print("\t+20 food\n", resourceGainDelay);
						enter();
					}
					else if (input == 4) //hunting in the deep forest
					{
						food += 30;
						print("Your people hunted velociraptors and picked edible vines and creepers for food!\n", resultDelay);
						print("\t+30 food\n", resourceGainDelay);
						enter();
					}
					else if (input == 5) //hunting at the badlands
					{
						food += 50;
						print("Your people fought off large, dangerous dinosaurs in the badlands for food!\n", resultDelay);
						print("\t+50 food\n", resourceGainDelay);
						enter();
					}
					else if (input == 6) //hunting at the t-rex breeding grounds
					{
						food += 60;
						print("You raided the T-rex breeding area for food!\n", resultDelay);
						print("\t+60 food\n", resourceGainDelay);
						enter();
					}
				}
				else if (input == 4)
				{
					do
					{
						print("Where would you like to harvest resources", questionDelay);
						print("?", waitAfterQuestionDelay);
						print("\n\n", optionDelay);
						print("\t1) The Riverbeds         (+5 materials,  low danger)\n", optionDelay);
						print("\n", optionDelay);
						print("\t2) The Shoreline         (+10 materials, medium danger)\n", optionDelay);
						print("\n", optionDelay);
						print("\t3) The Underwater Caves  (+20 materials, medium-high danger)\n", optionDelay);
						print("\n", optionDelay);
						print("\t4) The Deep Mines        (+30 materials, high danger)\n", optionDelay);
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
							displayColonyStatistics(happiness, food, population, offense, defense, materials, menuDelay);
						}
						else if (input == 5)
						{
							break;
						}
						else
						{
							if (!(input == 1 || input == 2 || input == 3 || input == 4))
							{
								print("\nPlease enter 1, 2, 3, or 4.\n\n", optionDelay);
							}
							else
							{
								optionNotChosen = false;
							}
						}
					}
					while (!(input == 1 || input == 2 || input == 3 || input == 4));
					
					print("\n", resultDelay);
					
					if (input == 1)
					{
						materials += 5;
						print("The Riverbeds were scoured for stone and minerals!\n", resultDelay);
						print("\t+5 materials\n", resourceGainDelay);
						enter();
					}
					else if (input == 2)
					{
						materials += 10;
						print("The shoreline was scavenged for wood and valuable resources!\n", resultDelay);
						print("\t+10 materials\n", resourceGainDelay);
						enter();
					}
					else if (input == 3)
					{
						materials += 20;
						print("The Underwater Caves were picked of their resources!\n", resultDelay);
						print("\t+20 materials\n", resourceGainDelay);
						enter();
					}
					else if (input == 4)
					{
						materials += 30;
						print("Your people took pickaxes and mined for resources deep underground!\n", resultDelay);
						print("\t+30 materials\n", resourceGainDelay);
						enter();
					}
				}
			}
			
			enemyAttack = random.nextInt(2) + 1; //chances of being attacked
			if (enemyAttack == 1)
			{
				if (day <= 10)
				{
					print("Dino attack!\n", resultDelay);
					attackStrength = random.nextInt(8 + (2*day)) + 1;
					enter();
						
					print("Your defense: " + defense + "\n", attackDelay);
					print("Dino attack strength:", attackDelay);
					print(" " + attackStrength + "", waitAfterQuestionDelay);
					print("\n", attackDelay);
					
					if (defense > attackStrength)
					{
						print("You fought the dinosaurs out of your territory!\n", resultDelay);
						enter();
					}
					else if (defense < attackStrength)
					{
						print("The dinosaurs have overrun your base!\n", resultDelay);
						print("GAME OVER!\n", gameOverDelay);
						enter();
						break;
					}
					else if (attackStrength == defense)
					{
						print("\nThe battle is tied! Because you hold the defensive position, they are unable to overrun you!\n", resultDelay);
						print("However, because you cannot overcome the dinosaurs, your troop's moral has been greatly lowered!\n", resultDelay);
						print("\t-20 happiness\n", resourceGainDelay);
						happiness -= 20;
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
						
						print("Your defense: " + defense + "\n", attackDelay);
						print("Dino attack strength: " + attackStrength + "\n", attackDelay);
						print(" " + attackStrength + "", waitAfterQuestionDelay);
						print("\n", resultDelay);
						
						if (defense > attackStrength)
						{
							print("You fought the dinosaurs out of your territory!\n", resultDelay);
							enter();
						}
						else if (defense < attackStrength)
						{
							print("The dinosaurs have overrun your base!\n", resultDelay);
							print("GAME OVER!\n", gameOverDelay);
							enter();
							break;
						}
						else if (attackStrength == defense)
						{
							print("The battle is tied! But because you hold the defensive position, they are unable to overrun you!\n", resultDelay);
							print("However, because you cannot overcome the dinosaurs, your troop's moral has been greatly lowered!\n", resultDelay);
							print("\t-20 happiness\n", resourceGainDelay);
							happiness -= 20;
							enter();
						}
					}
					else if (attackType == 2)
					{
						print("Sixer attack!\n", resultDelay);
						attackStrength = random.nextInt(8 + (2*day)) + 1;
						enter();
						
						print("Your defense: " + defense + "\n", attackDelay);
						print("Sixer attack strength: " + attackStrength + "\n", attackDelay);
						print(" " + attackStrength + "", waitAfterQuestionDelay);
						print("\n", resultDelay);
						
						if (defense > attackStrength)
						{
							print("You fought the Sixers out of your territory!\n", resultDelay);
							enter();
						}
						else if (defense < attackStrength)
						{
							print("The Sixers have overtaken your base!\n", resultDelay);
							print("GAME OVER!\n", gameOverDelay);
							enter();
							break;
						}
						else if (attackStrength == defense)
						{
							print("The battle is tied! But because you hold the defensive position, they are unable to conquer you!\n", resultDelay);
							print("However, because you cannot overcome the Sixers, your troop's moral has been greatly lowered!\n", resultDelay);
							print("\t-20 happiness\n", resourceGainDelay);
							happiness -= 20;
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
						displayColonyStatistics(happiness, food, population, offense, defense, materials, menuDelay);
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
							displayColonyStatistics(happiness, food, population, offense, defense, materials, menuDelay);
						}
						else if (input == 4)
						{
							break;
						}
						else
						{
							if (!(input == 1 || input == 2 || input == 3))
							{
								print("\nPlease enter 1, 2, or 3.\n\n", resultDelay);
							}
							else
							{
								if (input == 1 && materials < 15)
								{
									print("\nYou need at least 15 materials to craft spears!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 2 && materials < 40)
								{
									print("\nYou need at least 40 materials to craft guns!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 3 && materials < 100)
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
						offense += 5;
						materials -= 15;
						print("Your people have made spears from hide, flint, stone, and wood!\n", resultDelay);
						print("\t +5 offense\n", resourceGainDelay);
						print("\t-15 materials\n\n", resourceGainDelay);
					}
					else if (input == 2)
					{
						offense += 10;
						materials -= 40;
						print("Your people have fashioned guns using resources from the portal!\n", resultDelay); // Only Display choice for guns if portal is true (set it up
						print("\t+10 offense\n", resourceGainDelay);									   // for higher values of materials, after Lucas should be done)
						print("\t-40 materials\n\n", resourceGainDelay);
					}
					else if (input == 3)
					{
						offense += 20;
						materials -= 100;
						print("Your men have put together ballistas using leather, wood, and metal!\n", resultDelay); //
						print("\t+ 20 offense\n", resourceGainDelay);
						print("\t-100 materials\n\n", resourceGainDelay);
					}
				}
				else if (input == 2)
				{
					do
					{
						print("||=============== Defensive Upgrades ===============||\n", menuDelay);
						print("\n", optionDelay);
						print("\t1) Reinforced Walls      (+ 5 defense, -15 materials)\n", optionDelay);
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
							displayColonyStatistics(happiness, food, population, offense, defense, materials, menuDelay);
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
								print("\nPlease enter 1, 2, or 3.\n\n", resultDelay);
							}
							else
							{
								if (input == 1 && materials < 15)
								{
									print("\nYou need at least 15 materials to create reinforced walls!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 2 && materials < 40)
								{
									print("\nYou need at least 40 materials to make personal body armor!\n\n", resultDelay);
									input = -1;
								}
								else if (input == 3 && materials < 100)
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
						defense += 5;
						materials -= 15;
						print("\nYour people have reinforced the wall with hide, stone, and wood!\n", resultDelay);
						print("\t +5 defense\n", resourceGainDelay);
						print("\t-15 materials\n", resourceGainDelay);
						kb.nextLine();
					}
					else if (input == 2)
					{
						defense += 10;
						materials -= 40;
						print("\nYour people have made personal body armor from dinosaur hide!\n", resultDelay); // Only this choice if survived
						print("\t+10 defense\n", resourceGainDelay);									 	           // 10 dino attacks or something
						print("\t-40 materials\n", resourceGainDelay);
						kb.nextLine();
					}
					else if (input == 3)
					{
						defense += 20;
						materials -= 100;
						print("\nYour people dug trenches using iron shovels!\n", resultDelay);
						print("\t+ 20 defense\n", resourceGainDelay);
						print("\t-100 materials\n", resourceGainDelay);
					}
				}
				else if (input == 3)
				{
					optionNotChosen = false;
				}
			}
			
			if (food >= population)
			{
				print("Your people have consumed food by the end of the day.\n", resultDelay);
				print("\t-" + population + " food\n", resourceGainDelay);
				food -= population;
			}
			else //food < population
			{
				print("You have " + population + " people at the end of the day, but only " + food + " food to feed them all!\n", resultDelay);
				print(population-food + " people went unfed today, so " + (population-food)/2 + " of them starved to death!\n", resultDelay);
				print("\t-" + food + " food\n", resourceGainDelay);
				print("\t-" + (population-food)/2 + " population\n", resourceGainDelay);
				population -= (population-food)/2;
				food = 0;
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
				happiness += 10;
			}
			else if (sunshine == true)
			{
				sunshine = false;
				print("\nThe bright, orange sun has finally sunk beneath the horizon at the end of the day", resultDelay);
				print("...\n", darkStatementDelay);
				print("Everyone's mood darkens as the world is once again cast into shadows", resultDelay);
				print("...\n", darkStatementDelay);
				print("\t-10 happiness\n", resourceGainDelay);
				happiness -= 10;
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
				offense += 10;
			}
			else if (fog == true)
			{
				fog = false;
				print("\nThe fog finally has begun to lift at the end of the day!\n", resultDelay);
				print("Your men are now at ease, being able to see far beyond your walls once more.\n", resultDelay);
				print("\t+10 defense\n", resourceGainDelay);
				defense += 10;
			}
			
			enter();
			
			if (portal = true)
			{
				if (population < food && population < materials)
				{
					population += 2;
					food += 3;
					materials += 3;
					print("The portal has given you a small amount of resources at the end of the day.\n", resultDelay);
					print("\t+2 population\n", resourceGainDelay);
					print("\t+3 food\n", resourceGainDelay);
					print("\t+3 materials\n", resourceGainDelay);
				}
				else if (food < population && food < materials)
				{
					population += 1;
					food += 5;
					materials += 3;
					print("The portal has given you a small amount of resources at the end of the day.\n", resultDelay);
					print("\t+1 population\n", resourceGainDelay);
					print("\t+5 food\n", resourceGainDelay);
					print("\t+3 materials\n", resourceGainDelay);
				}
				else if (materials < food && materials < population)
				{
					population += 1;
					food += 3;
					materials += 5;
					print("The portal has given you a small amount of resources at the end of the day.\n", resultDelay);
					print("\t+1 population\n", resourceGainDelay);
					print("\t+3 food\n", resourceGainDelay);
					print("\t+5 materials\n", resourceGainDelay);
				}
				else
				{
					population += 1;
					food += 4;
					materials += 4;

					print("The portal has given you a small amount of resources at the end of the day.\n", resultDelay);
					print("\t+1 population\n", resourceGainDelay);
					print("\t+4 food\n", resourceGainDelay);
					print("\t+4 materials\n", resourceGainDelay);
				}
			}
			else if (portal = false)
			{
				print("The day ends on a bleak note as you reflect that the portal has been destroyed.\n", resultDelay);
				print("You are alone and cut off from civilization, ", resultDelay);
				print("forever.\n", darkStatementDelay);
			}
			
			//consider beginning the roll for fairMaiden later in the game, as even if a player gets it early they won't get her,
			//its not very fair for the player
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
						displayColonyStatistics(happiness, food, population, offense, defense, materials, menuDelay);
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
					
					if (offense < 100)
					{
						if (offense > 90)
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
						else if (offense > 80)
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
						else if (offense > 70)
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
						else if (offense > 60)
						{
							rescueSpecial = random.nextInt(5) + 1; //60% chance
							if (rescueSpecial == 2 || rescueSpecial == 3)
							{
								rescueSpecial = 0;
							}
						}
						else if (offense > 50)
						{
							rescueSpecial = random.nextInt(2) + 1; //50% chance
						}
						else if (offense > 40)
						{
							rescueSpecial = random.nextInt(5) + 1; //40% chance
							if (rescueSpecial == 2)
							{
								rescueSpecial = 1; //success
							}
						}
						else if (offense > 30)
						{
							rescueSpecial = random.nextInt(10) + 1; //30% chance
							if (rescueSpecial == 2 || rescueSpecial == 3)
							{
								rescueSpecial = 1;
							}
						}
						else if (offense > 20)
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
						print("Sometime later, deep in the dense forests of the far north...\n", resultDelay);
						print("Your driver turns and tells you that you're closing in on the origin of the radio signal!\n", resultDelay);
						print("Your lean forward in your seat in anticipation, eyes straining to see through the thick windshield", resultDelay);
						print("...\n", darkStatementDelay);
						print("Suddenly, there she is!\n", resultDelay);
						print("Shivering and afraid, your squadron quickly forms a defensive perimeter around her!\n", resultDelay);
						print("You leap out of your rover and wrap a blanket around her, assuring her that she's safe now!\n", resultDelay);
						
						if (defense < 100)
						{
							if (defense > 90)
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
							else if (defense > 80)
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
							else if (defense > 70)
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
							else if (defense > 60)
							{
								returnSpecial = random.nextInt(5) + 1; //60% chance
								if (returnSpecial == 2 || returnSpecial == 3)
								{
									returnSpecial = 0;
								}
							}
							else if (defense > 50)
							{
								returnSpecial = random.nextInt(2) + 1; //50% chance
							}
							else if (defense > 40)
							{
								returnSpecial = random.nextInt(5) + 1; //40% chance
								if (returnSpecial == 2)
								{
									returnSpecial = 1; //success
								}
							}
							else if (defense > 30)
							{
								returnSpecial = random.nextInt(10) + 1; //30% chance
								if (returnSpecial == 2 || returnSpecial == 3)
								{
									returnSpecial = 1;
								}
							}
							else if (defense > 20)
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
						print("Sometime later, deep in the dense forests of the far north...\n", resultDelay);
						print("A dense fog seems to have slowly crept into this region.\n", resultDelay);
						print("You're beginning to have second thoughts about this rescue mission", resultDelay);
						print("...\n", darkStatementDelay);
						print("\n...\n\n", darkStatementDelay);
						print("Suddenly, a large pack of raptors materialize from the fog!\n", resultDelay);
						print("Your offensive capabilities are no match for their speed! Your men are overrun and split into every direction!\n", resultDelay);
						print("Your troops are savagely torn limb from limb and you barely make it out with the men in your rover alive!\n", resultDelay);
						print("Using your radios you manage to regroup with what is left of your squadron. It's going to a quiet ride back to Terra Nova", resultDelay);
						print("...\n", darkStatementDelay);
						int checkPop = population/2;
						print("\t-" + checkPop + " population\n", resourceGainDelay);
						population -= checkPop;
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
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			print("\n", resultDelay);
			
		} // ends the while loop at the very beginning
	} //ends method
	
	public static boolean check(int required, int current)
	{
		if (required > current)
		{
			return false;
		}
		return true;
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
	
	public static void saveGameStatistics()
	{
		System.out.println("The game has been saved."); //Save all the current game statistics, then just run the loop with the inputted data!
														//Perhaps don't initialize starting game data, but read it from a text file? Then saved games would	
														//be read in through the same means, and it wouldn't change the system for new game/continue game.
														//This means I must add a continue section at the menu as well! Save date/time as well (see import statements)
	}

	public static void displayColonyStatistics(int happiness, int food, int population, int offense, int defense, int materials, int menuDelay) throws InterruptedException
	{
		int happinessLen = Integer.toString(happiness).length() - 1;
		int foodLen = Integer.toString(food).length() - 1;
		int populationLen = Integer.toString(population).length() - 1;
		int offenseLen = Integer.toString(offense).length() - 1;
		int defenseLen = Integer.toString(defense).length() - 1;
		int materialsLen = Integer.toString(materials).length() - 1;
		
		print("||====================================================||\n", menuDelay);
		print("||                                                    ||\n", menuDelay);
		print("||       Happiness        Food        Population      ||\n", menuDelay);     
		
		printBoxes(happinessLen, foodLen, populationLen, happiness, food, population, menuDelay);
		
		print("||                                                    ||\n", menuDelay);
		
		if (materialsLen == 1)
		{
			print("||        Offense       Defense        Materials      ||\n", menuDelay);
		}
		else
		{
			print("||        Offense       Defense       Materials       ||\n", menuDelay);
		}
		
		printBoxes(offenseLen, defenseLen, materialsLen, offense, defense, materials, menuDelay);
		
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
}























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