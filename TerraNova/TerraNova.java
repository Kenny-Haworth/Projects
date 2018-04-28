import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.*;

public class TerraNova
{
	public static void main(String[] args) throws Exception
	{
		int input;
		final int loop = 0;
		
		do
		{
			input = DisplayMainMenu();
			if (input == 1)
			{
				exposition();
				startGame();
				saveGameStatistics();
			} 
			else if (input == 2)
			{
				print("Here's the tutorial.\n", TimeUnit.MILLISECONDS, 10);
			}
			else if (input == 3)
			{
				print("I'm Kenny and I made the game.\n", TimeUnit.MILLISECONDS, 10);
			} 
		}
		while (loop == 0);
	}
	
	public static int DisplayMainMenu() throws Exception
	{
		int input;
		int mainmenuDelay = 8;
		int dinoDelay = 3;
		
		print("||==========================================||\n", TimeUnit.MILLISECONDS, dinoDelay);
		print("||                                          ||\n", TimeUnit.MILLISECONDS, mainmenuDelay);
		print("||         Welcome to Terra Nova!!!         ||\n", TimeUnit.MILLISECONDS, mainmenuDelay);
		print("||                                          ||\n", TimeUnit.MILLISECONDS, mainmenuDelay);
		print("||          1) New Game                     ||\n", TimeUnit.MILLISECONDS, mainmenuDelay);
		print("||                                          ||\n", TimeUnit.MILLISECONDS, mainmenuDelay);
		print("||          2) Tutorial                     ||\n", TimeUnit.MILLISECONDS, mainmenuDelay);
		print("||          (recommended for new players)   ||\n", TimeUnit.MILLISECONDS, mainmenuDelay);
		print("||                                          ||\n", TimeUnit.MILLISECONDS, mainmenuDelay);
		print("||          3) Credits                      ||\n", TimeUnit.MILLISECONDS, mainmenuDelay);
		print("||                              ____        ||\n", TimeUnit.MILLISECONDS, dinoDelay);
		print("||                             / *__)       ||\n", TimeUnit.MILLISECONDS, dinoDelay);
		print("||                            /  /          ||\n", TimeUnit.MILLISECONDS, dinoDelay);
		print("||                           /  /           ||\n", TimeUnit.MILLISECONDS, dinoDelay);
		print("||                          /  /            ||\n", TimeUnit.MILLISECONDS, dinoDelay);
        print("||                _____    /  /             ||\n", TimeUnit.MILLISECONDS, dinoDelay);
	    print("||            ___/     \\__/  /              ||\n", TimeUnit.MILLISECONDS, dinoDelay); // Offset one space because of escape character "\"
        print("||           /              /               ||\n", TimeUnit.MILLISECONDS, dinoDelay);
        print("||          /               |               ||\n", TimeUnit.MILLISECONDS, dinoDelay);
	    print("||         / /|             |               ||\n", TimeUnit.MILLISECONDS, dinoDelay);
        print("||        / / |   _______   |               ||\n", TimeUnit.MILLISECONDS, dinoDelay);
        print("||       / /  |  |       |  |               ||\n", TimeUnit.MILLISECONDS, dinoDelay);
		print("||      /_/   |  |       |  |               ||\n", TimeUnit.MILLISECONDS, dinoDelay);
		print("||            |  |       |  |               ||\n", TimeUnit.MILLISECONDS, dinoDelay);
		print("||            |__|       |__|               ||\n", TimeUnit.MILLISECONDS, dinoDelay);
		print("||                                          ||\n", TimeUnit.MILLISECONDS, dinoDelay);																				
		print("||==========================================||\n", TimeUnit.MILLISECONDS, dinoDelay);
		print("           Enter your number choice:          \n", TimeUnit.MILLISECONDS, 50); //Remove this line if I can highlight 1, 2, and 3 at some point, HIGHILIGHT NUMBER CHOICE
		
		Scanner keyboard = new Scanner(System.in);
		
		do
		{
			input = keyboard.nextInt();
			if (!(input == 1 || input == 2 || input == 3))
			{
				print("Please enter 1, 2, or 3.\n", TimeUnit.MILLISECONDS, mainmenuDelay);
			}
		}
		while (!(input == 1 || input == 2 || input == 3));
		return input;
	}
	
	public static void exposition() throws Exception
	{
		print("\n", TimeUnit.MILLISECONDS, 50);
		print("Here's the lore.\n", TimeUnit.MILLISECONDS, 50);
		print("\n", TimeUnit.MILLISECONDS, 50);
	}
	
	public static void startGame() throws Exception
	{
		int happiness = 60; //base stats
		int food = 20;
		int population = 20;
		int offense = 5;
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
		
		int menuDelay = 2; //2 text speed control
		int optionDelay = 8; //8
		int questionDelay = 60; //60
		int resultDelay = 30; //30
		int gameOverDelay = 400; //400
		int attackDelay = 50; //50
		int endofdayDelay = 10; //10
		int darkStatementDelay = 500; //500
		int num2000Delay = 2000; //2000
		
		int huntmenuDelay = 2; //2
		int waitAfterQuestionDelay = 1500; //1500
		int resourceGainDelay = 125; //125
		
		int input; //declared, uninitialized variables
		int attackStrength;
		int enemyAttack;
		int attackType;
		int Special;
		int rescueSpecial;
		int returnSpecial;
		
		String inputContinue;
		
		Scanner keyboard = new Scanner(System.in);
		Random random = new Random();
		
		while(!gameOver)
		{
			
			print("Day", TimeUnit.MILLISECONDS, attackDelay);
			print(" " + day + "", TimeUnit.MILLISECONDS, waitAfterQuestionDelay);
			print(" in the colony of Terra Nova", TimeUnit.MILLISECONDS, attackDelay);
			print(".", TimeUnit.MILLISECONDS, num2000Delay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			print("           Your current colony statistics:", TimeUnit.MILLISECONDS, resultDelay);
			print(" \n", TimeUnit.MILLISECONDS, darkStatementDelay);
			print("||====================================================||\n", TimeUnit.MILLISECONDS, menuDelay);
			print("||                                                    ||\n", TimeUnit.MILLISECONDS, menuDelay);
			print("||      Happiness         Food        Population      ||\n", TimeUnit.MILLISECONDS, menuDelay);     
			print("||     ||========||      ||==||      ||========||     ||\n", TimeUnit.MILLISECONDS, menuDelay);
			print("||     ||   " + happiness + "   ||      ||" + food + "||      ||   " + population + "   ||     ||\n", TimeUnit.MILLISECONDS, menuDelay);
			print("||     ||========||      ||==||      ||========||     ||\n", TimeUnit.MILLISECONDS, menuDelay);
			print("||                                                    ||\n", TimeUnit.MILLISECONDS, menuDelay);
			print("||       Offense       Defense        Materials       ||\n", TimeUnit.MILLISECONDS, menuDelay);
			print("||      ||=====||     ||======||     ||=======||      ||\n", TimeUnit.MILLISECONDS, menuDelay);
			print("||      ||  " + offense + "  ||     ||  " + defense + "  ||     ||   " + materials + "  ||      ||\n", TimeUnit.MILLISECONDS, menuDelay);
			print("||      ||=====||     ||======||     ||=======||      ||\n", TimeUnit.MILLISECONDS, menuDelay);
			print("||                                                    ||\n", TimeUnit.MILLISECONDS, menuDelay);
			print("||====================================================||\n", TimeUnit.MILLISECONDS, menuDelay);
			enter();
			
			weatherChance = random.nextInt(2) + 1; // (2) + 1, %50 chance of weather
			if (weatherChance == 1)
			{
				weather = random.nextInt(6) + 1;
				if (weather == 1)
				{
					rain = true;
					print("It's raining today", TimeUnit.MILLISECONDS, resultDelay);
					print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
					print("-10 happiness\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					happiness -= 10;
				}
				if (weather == 2)
				{
					sunshine = true;
					print("The sun is out and it's shining brightly today!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("+10 happiness\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					happiness += 10;
				}
				if (weather == 3)
				{
					lightning = true;
					print("There's a lightning storm today!\n", TimeUnit.MILLISECONDS, resultDelay); //Low chance of someone dying? Maybe make materials harder to get?
				}
				if (weather == 4)
				{
					snow = true;
					print("It's snowing today!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("The increased cold will drive out animals and make them easier to hunt!\n", TimeUnit.MILLISECONDS, resultDelay); //Increase food gains if this condition is set to true
				}
				if (weather == 5)
				{
					wind = true;
					print("There are high winds today", TimeUnit.MILLISECONDS, resultDelay);
					print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
					print("The wailing of the wind through the trees slowly eats on everyone's nerves", TimeUnit.MILLISECONDS, resultDelay);
					print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
					print("-10 offense\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					offense -= 10;
				}
				if (weather == 6)
				{
					fog = true;
					print("A dense fog has settled in over the area this morning", TimeUnit.MILLISECONDS, resultDelay);
					print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
					print("You can barely see 15 feet beyond your walls!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("This will make it much more difficult to see enemies", TimeUnit.MILLISECONDS, resultDelay);
					print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
					print("-10 defense\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					defense -= 10;
				}
			}
			
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			print("What would you like to do today", TimeUnit.MILLISECONDS, questionDelay);
			print("?", TimeUnit.MILLISECONDS, waitAfterQuestionDelay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			print("  1) Hold a festival  	(increases population, costs materials)\n", TimeUnit.MILLISECONDS, optionDelay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			print("  2) Hold a feast     	(increases happiness, costs food)\n", TimeUnit.MILLISECONDS, optionDelay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			print("  3) Go on a hunt     	(increases food, may be dangerous)\n", TimeUnit.MILLISECONDS, optionDelay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			print("  4) Gather resources 	(increases materials, may be dangerous)\n", TimeUnit.MILLISECONDS, optionDelay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			
			do
			{
				input = keyboard.nextInt();
				if (!(input == 1 || input == 2 || input == 3 || input == 4))
				{
					print("Please enter 1, 2, 3, or 4.\n", TimeUnit.MILLISECONDS, optionDelay);
				}
			}
			while (!(input == 1 || input == 2 || input == 3 || input == 4));
			
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			
			if (input == 1)
			{
				print("How big of a festival would you like", TimeUnit.MILLISECONDS, questionDelay);
				print("?", TimeUnit.MILLISECONDS, waitAfterQuestionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  1) A Dance        (+5 population,  -10 materials)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  2) A Parade       (+10 population, -18 materials)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  3) A Play         (+20 population, -30 materials)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  4) A Carnival     (+30 population, -45 materials)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				do
				{
					input = keyboard.nextInt();
					if (!(input == 1 || input == 2 || input == 3 || input == 4))
					{
						print("Please enter 1, 2, 3, or 4.\n", TimeUnit.MILLISECONDS, optionDelay);
					}
				}
				while (!(input == 1 || input == 2 || input == 3 || input == 4));
				
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				
				if (input == 1)
				{
					population += 5;
					materials -= 10;
					print("Your people enjoyed the lively dancing!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t +5 population\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t-10 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 2)
				{
					population += 10;
					materials -= 18;
					print("The people paraded through the streets in costumes!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+10 population\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t-18 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 3)
				{
					population += 20;
					materials -= 30;
					print("The actors performed an amazing play for the entertainment of the people!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+20 population\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t-30 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 4)
				{
					population += 30;
					materials -= 45;
					print("The fair was held with several entertaining games and events!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+30 population\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t-45 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
			}
			else if (input == 2)
			{
				print("How big of a feast would you like", TimeUnit.MILLISECONDS, questionDelay);
				print("?", TimeUnit.MILLISECONDS, waitAfterQuestionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  1) A Picnic                  (+5 happiness,  -10 food)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  2) A Banquet                 (+10 happiness, -18 food)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  3) A Barbeque                (+20 happiness, -30 food)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  4) A huge multi-meal Feast!  (+30 happiness, -45 food)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				do
				{
					input = keyboard.nextInt();
					if (!(input == 1 || input == 2 || input == 3 || input == 4))
					{
						print("Please enter 1, 2, 3, or 4.\n", TimeUnit.MILLISECONDS, optionDelay);
					}
				}
				while (!(input == 1 || input == 2 || input == 3 || input == 4));
				
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				
				if (input == 1)
				{
					happiness += 5;
					food -= 10;
					print("Your people enjoyed a quiet picnic on the green rolling hills just outside the colony gates!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t +5 happiness\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t-10 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 2)
				{
					happiness += 10;
					food -= 18;
					print("Everyone enjoyed the palete of food at the banquet!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+10 happiness\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t-18 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 3)
				{
					happiness += 20;
					food -= 30;
					print("Meat and fish were grilled over open fires and handed out for the barbeque!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+20 happiness\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t-30 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 4)
				{
					happiness += 30;
					food -= 45;
					print("Large, long tables were placed together and heaps of food were brought out in the all-you-can-eat feast!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+30 happiness\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t-45 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
			}
			else if (input == 3)
			{
				print("Where would you like to hunt", TimeUnit.MILLISECONDS, questionDelay);
				print("?", TimeUnit.MILLISECONDS, waitAfterQuestionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  1) Right Outside the Gates                 (+5 food)\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("                                             (no danger)\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("  2) The Waterfalls                          (+10 food)\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("                                             (low danger)\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("  3) The Open Plains                         (+20 food)\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("                                             (moderate danger)\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("  4) The Deep Forest                         (+30 food)\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("                                             (moderate-high danger)\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("  5) The Badlands                            (+50 food)\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("                                             (high danger)\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("  6) The Tyrannosaurus Rex Breeding Grounds  (+60 food)\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("                                             (very high danger)\n", TimeUnit.MILLISECONDS, huntmenuDelay);
				print("\n", TimeUnit.MILLISECONDS, huntmenuDelay);
	
				do
				{
					input = keyboard.nextInt();
					if (!(input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 6))
					{
						print("Please enter 1, 2, 3, 4, 5, or 6.\n", TimeUnit.MILLISECONDS, resultDelay);
					}
				}
				while (!(input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 6));
				
				print("\n", TimeUnit.MILLISECONDS, resultDelay);
				
				if (input == 1)
				{
					food += 5;
					print("You scavenged the area right outside your gates!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+5 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 2)
				{
					food += 10;
					print("You raided the waterfalls for food!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+10 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 3)
				{
					food += 20;
					print("You traversed the Open Plains for food!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+20 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 4)
				{
					food += 30;
					print("You searched the deep forest for food!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+30 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 5)
				{
					food += 50;
					print("You scavenged the Badlands for food!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+50 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 6)
				{
					food += 60;
					print("You raided the T-rex breeding area for food!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+60 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
			}
			else if (input == 4)
			{
				print("Where would you like to harvest resources", TimeUnit.MILLISECONDS, questionDelay);
				print("?", TimeUnit.MILLISECONDS, waitAfterQuestionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  1) The Riverbeds         (+5 materials,  low danger)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  2) The Shoreline         (+10 materials, medium danger)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  3) The Underwater Caves  (+20 materials, medium-high danger)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("  4) The Deep Mines        (+30 materials, high danger)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				do
				{
					input = keyboard.nextInt();
					if (!(input == 1 || input == 2 || input == 3 || input == 4))
					{
						print("Please enter 1, 2, 3, or 4.\n", TimeUnit.MILLISECONDS, resultDelay);
					}
				}
				while (!(input == 1 || input == 2 || input == 3 || input == 4));
				
				print("\n", TimeUnit.MILLISECONDS, resultDelay);
				
				if (input == 1)
				{
					materials += 5;
					print("The Riverbeds were scoured for resources!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+5 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 2)
				{
					materials += 10;
					print("The shoreline was picked of its resources!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+10 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 3)
				{
					materials += 20;
					print("The Underwater Caves were picked of their resources!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+20 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 4)
				{
					materials += 30;
					print("The mines were mined for their resources!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+30 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
			}
			
			enemyAttack = random.nextInt(1) + 1; //10?
			if (enemyAttack == 1)
			{
				if (day <= 10)
				{
					print("Dino attack!\n", TimeUnit.MILLISECONDS, resultDelay);
					attackStrength = random.nextInt(8 + (2*day)) + 1;
					enter();
						
					print("Your defense: " + defense + "\n", TimeUnit.MILLISECONDS, attackDelay);
					print("Dino attack strength:", TimeUnit.MILLISECONDS, attackDelay);
					print(" " + attackStrength + "", TimeUnit.MILLISECONDS, waitAfterQuestionDelay);
					print("\n", TimeUnit.MILLISECONDS, resultDelay);
					
					if (defense > attackStrength)
					{
						print("You fought the dinosaurs out of your territory!\n", TimeUnit.MILLISECONDS, resultDelay);
						enter();
					}
					else if (defense < attackStrength)
					{
						print("The dinosaurs have overrun your base!\n", TimeUnit.MILLISECONDS, resultDelay);
						print("GAME OVER!\n", TimeUnit.MILLISECONDS, gameOverDelay);
						enter();
						break;
					}
					else if (attackStrength == defense)
					{
						print("The battle is tied! But because you hold the defensive position, they are unable to overrun you!\n", TimeUnit.MILLISECONDS, resultDelay);
						print("However, because you cannot overcome the dinosaurs, your troop's moral has been greatly lowered!\n", TimeUnit.MILLISECONDS, resultDelay);
						print("\t-20 happiness\n", TimeUnit.MILLISECONDS, resultDelay);
						happiness -= 20;
						enter();
					}
				}
				else if (day > 10)
				{
					attackType = random.nextInt(2) + 1;
					if (attackType == 1)
					{
						print("Dino attack!\n", TimeUnit.MILLISECONDS, resultDelay);
						attackStrength = random.nextInt(8 + (2*day)) + 1;
						enter();
						
						print("Your defense: " + defense + "\n", TimeUnit.MILLISECONDS, attackDelay);
						print("Dino attack strength: " + attackStrength + "\n", TimeUnit.MILLISECONDS, attackDelay);
						print(" " + attackStrength + "", TimeUnit.MILLISECONDS, waitAfterQuestionDelay);
						print("\n", TimeUnit.MILLISECONDS, resultDelay);
						
						if (defense > attackStrength)
						{
							print("You fought the dinosaurs out of your territory!\n", TimeUnit.MILLISECONDS, resultDelay);
							enter();
						}
						else if (defense < attackStrength)
						{
							print("The dinosaurs have overrun your base!\n", TimeUnit.MILLISECONDS, resultDelay);
							print("GAME OVER!\n", TimeUnit.MILLISECONDS, gameOverDelay);
							enter();
							break;
						}
						else if (attackStrength == defense)
						{
							print("The battle is tied! But because you hold the defensive position, they are unable to overrun you!\n", TimeUnit.MILLISECONDS, resultDelay);
							print("However, because you cannot overcome the dinosaurs, your troop's moral has been greatly lowered!\n", TimeUnit.MILLISECONDS, resultDelay);
							print("\t-20 happiness\n", TimeUnit.MILLISECONDS, resultDelay);
							happiness -= 20;
							enter();
						}
					}
					else if (attackType == 2)
					{
						print("Sixer attack!\n", TimeUnit.MILLISECONDS, resultDelay);
						attackStrength = random.nextInt(8 + (2*day)) + 1;
						enter();
						
						print("Your defense: " + defense + "\n", TimeUnit.MILLISECONDS, attackDelay);
						print("Sixer attack strength: " + attackStrength + "\n", TimeUnit.MILLISECONDS, attackDelay);
						print(" " + attackStrength + "", TimeUnit.MILLISECONDS, waitAfterQuestionDelay);
						print("\n", TimeUnit.MILLISECONDS, resultDelay);
						
						if (defense > attackStrength)
						{
							print("You fought the Sixers out of your territory!\n", TimeUnit.MILLISECONDS, resultDelay);
							enter();
						}
						else if (defense < attackStrength)
						{
							print("The Sixers have overtaken your base!\n", TimeUnit.MILLISECONDS, resultDelay);
							print("GAME OVER!\n", TimeUnit.MILLISECONDS, gameOverDelay);
							enter();
							break;
						}
						else if (attackStrength == defense)
						{
							print("The battle is tied! But because you hold the defensive position, they are unable to conquer you!\n", TimeUnit.MILLISECONDS, resultDelay);
							print("However, because you cannot overcome the Sixers, your troop's moral has been greatly lowered!\n", TimeUnit.MILLISECONDS, resultDelay);
							print("\t-20 happiness\n", TimeUnit.MILLISECONDS, resultDelay);
							happiness -= 20;
							enter();
						}
					}
				}
			}
			
			print("Would you like to use materials to increase offensive or defensive capabilities", TimeUnit.MILLISECONDS, questionDelay);
			print("?", TimeUnit.MILLISECONDS, waitAfterQuestionDelay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			print("		1) Increase Offense\n", TimeUnit.MILLISECONDS, optionDelay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			print("		2) Increase Defense\n", TimeUnit.MILLISECONDS, optionDelay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			print("		3) Continue to Next Day\n", TimeUnit.MILLISECONDS, optionDelay);
			print("\n", TimeUnit.MILLISECONDS, optionDelay);
			do
			{
				input = keyboard.nextInt();
				if (!(input == 1 || input == 2 || input == 3))
				{
					print("Please enter 1, 2, or 3.\n", TimeUnit.MILLISECONDS, resultDelay);
				}
			}
			while (!(input == 1 || input == 2 || input == 3));
			
			print("\n", TimeUnit.MILLISECONDS, resultDelay);
			
			if (input == 1)
			{
				print("||=============== Offensive Upgrades ===============||\n", TimeUnit.MILLISECONDS, menuDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("		1) Spears      (+ 5 offense, -15 materials)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("		2) Guns        (+10 offense, -40 materials)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("		3) Ballistas   (+20 offense, -100 materials)\n", TimeUnit.MILLISECONDS, optionDelay); // try tamed dinos as offense (requires food(each day)?)
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				do
				{
					input = keyboard.nextInt();
					if (!(input == 1 || input == 2 || input == 3))
					{
						print("Please enter 1, 2, or 3.\n", TimeUnit.MILLISECONDS, resultDelay);
					}
				}
				while (!(input == 1 || input == 2 || input == 3));
				
				print("\n", TimeUnit.MILLISECONDS, resultDelay);
				
				if (input == 1)
				{
					offense += 5;
					materials -= 15;
					print("Your people have made spears from hide, flint, stone, and wood!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t +5 offense\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t-15 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 2)
				{
					offense += 10;
					materials -= 40;
					print("Your people have fashioned guns using resources from the portal!\n", TimeUnit.MILLISECONDS, resultDelay); // Only Display choice for guns if portal is true (set it up
					print("\t+10 offense\n", TimeUnit.MILLISECONDS, resourceGainDelay);									   // for higher values of materials, after Lucas should be done)
					print("\t-40 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 3)
				{
					offense += 20;
					materials -= 100;
					print("Meat and fish were grilled over open fires and handed out for the barbeque!\n", TimeUnit.MILLISECONDS, resultDelay); //
					print("\t+ 20 offense\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t-100 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
			}
			else if (input == 2)
			{
				print("||=============== Defensive Upgrades ===============||\n", TimeUnit.MILLISECONDS, menuDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("		1) Reinforced Walls      (+ 5 defense, -15 materials)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("		2) Personal Body Armor   (+10 defense, -40 materials)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				print("		3) Trenches              (+20 defense, -100 materials)\n", TimeUnit.MILLISECONDS, optionDelay);
				print("\n", TimeUnit.MILLISECONDS, optionDelay);
				
				do
				{
					input = keyboard.nextInt();
					if (!(input == 1 || input == 2 || input == 3))
					{
						print("Please enter 1, 2, or 3.\n", TimeUnit.MILLISECONDS, resultDelay);
					}
				}
				while (!(input == 1 || input == 2 || input == 3));
				
				if (input == 1)
				{
					defense += 5;
					materials -= 15;
					print("Your people have reinforced the wall with hide, stone, and wood!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t +5 defense\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t-15 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 2)
				{
					defense += 10;
					materials -= 40;
					print("Your people have made personal body armor from dinosaur hide!\n", TimeUnit.MILLISECONDS, resultDelay); // Only this choice if survived
					print("\t+10 defense\n", TimeUnit.MILLISECONDS, resourceGainDelay);									 	           // 10 dino attacks or something
					print("\t-40 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
				else if (input == 3)
				{
					defense += 20;
					materials -= 100;
					print("Your people dug trenches using iron shovels!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+ 20 defense\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t-100 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					enter();
				}
			}
			else if (input == 3)
			{
				print("Continuing to next day...\n", TimeUnit.MILLISECONDS, resultDelay);
				print("\n", TimeUnit.MILLISECONDS, resultDelay);
			}
			
			if (rain == true)
			{
				rain = false;
				print("The rain seems to have finally died down at the end of the day!\n", TimeUnit.MILLISECONDS, resultDelay);
				print("You see a rainbow form off in the distance", TimeUnit.MILLISECONDS, resultDelay);
				print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
				print("The Jurassic Age truly holds a beautiful world", TimeUnit.MILLISECONDS, resultDelay);
				print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
				print("+10 happiness\n", TimeUnit.MILLISECONDS, resourceGainDelay);
				happiness += 10;
			}
			else if (sunshine == true)
			{
				sunshine = false;
				print("The bright, orange sun has finally sunk beneath the horizon at the end of the day", TimeUnit.MILLISECONDS, resultDelay);
				print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
				print("Everyone's mood darkens as the world is once again cast into shadows", TimeUnit.MILLISECONDS, resultDelay);
				print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
				print("-10 happiness\n", TimeUnit.MILLISECONDS, resourceGainDelay);
				happiness -= 10;
			}
			else if (lightning == true)
			{
				lightning = false;
				print("The lightning storm has finally ended at the end of the day!\n", TimeUnit.MILLISECONDS, resultDelay); //end negative status effect
			}
			else if (snow == true)
			{
				snow = false;
				print("The snow has finally stopped, and the animals are slowly re-emerging from their dens and homes!\n", TimeUnit.MILLISECONDS, resultDelay); //end negative status effect
			}
			else if (wind == true)
			{
				wind = false;
				print("The howling gale of wind has finally ended at the end of the day!\n", TimeUnit.MILLISECONDS, resultDelay);
				print("Your guards finally relax as the world once again falls quiet and peaceful.\n", TimeUnit.MILLISECONDS, resultDelay);
				print("+10 offense\n", TimeUnit.MILLISECONDS, resourceGainDelay);
				offense += 10;
			}
			else if (fog == true)
			{
				fog = false;
				print("The fog finally has begun to lift at the end of the day!\n", TimeUnit.MILLISECONDS, resultDelay);
				print("You are once again at ease, being able to see far beyond your walls once more!\n", TimeUnit.MILLISECONDS, resultDelay);
				print("+10 defense\n", TimeUnit.MILLISECONDS, resourceGainDelay);
				defense += 10;
			}
			
			enter();
			
			if (portal = true)
			{
				if (population < food && population < materials)
				{
					population += 4;
					food += 3;
					materials += 3;
					print("The portal has given you a small amount of resources at the end of the day.\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+7 population\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t+3 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t+3 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
				}
				else if (food < population && food < materials)
				{
					population += 3;
					food += 7;
					materials += 3;
					print("The portal has given you a small amount of resources at the end of the day.\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+3 population\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t+7 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t+3 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
				}
				else if (materials < food && materials < population)
				{
					population += 3;
					food += 3;
					materials += 7;
					print("The portal has given you a small amount of resources at the end of the day.\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\t+3 population\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t+3 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					print("\t+7 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
				}
				else
				{
					population += 4;
					food += 4;
					materials += 4;
				
					int resourceGain = random.nextInt(3) + 1;
					if (resourceGain == 1)
					{
						population += 2;
						print("The portal has given you a small amount of resources at the end of the day.\n", TimeUnit.MILLISECONDS, resultDelay);
						print("\t+6 population\n", TimeUnit.MILLISECONDS, resourceGainDelay);
						print("\t+4 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
						print("\t+4 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					}
					else if (resourceGain == 2)
					{
						population += 2;
						print("The portal has given you a small amount of resources at the end of the day.\n", TimeUnit.MILLISECONDS, resultDelay);
						print("\t+4 population\n", TimeUnit.MILLISECONDS, resourceGainDelay);
						print("\t+6 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
						print("\t+4 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					}
					else if (resourceGain == 3)
					{
						population += 2;
						print("The portal has given you a small amount of resources at the end of the day.\n", TimeUnit.MILLISECONDS, resultDelay);
						print("\t +4 population\n", TimeUnit.MILLISECONDS, resourceGainDelay);
						print("\t +4 food\n", TimeUnit.MILLISECONDS, resourceGainDelay);
						print("\t +6 materials\n", TimeUnit.MILLISECONDS, resourceGainDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, resultDelay);
				}
			}
			else if (portal = false)
			{
				print("The day ends on a bleak note as you reflect that the portal has been destroyed.\n", TimeUnit.MILLISECONDS, resultDelay);
				print("You are alone and cut off from civilization, ", TimeUnit.MILLISECONDS, resultDelay);
				print("forever.\n", TimeUnit.MILLISECONDS, darkStatementDelay);
			}
			
			Special = random.nextInt(1) + 1; //100
			if (Special == 1 && !fairMaiden)
			{
				fairMaiden = true;
				print("\nJust before you turn in for bed, one of your men hails you on your radio, ", TimeUnit.MILLISECONDS, resultDelay);
				print("saying he's picked up something unusual scanning for radio frequencies.", TimeUnit.MILLISECONDS, resultDelay);
				print("\nCurious, you walk over to the command station to see for yourself. ", TimeUnit.MILLISECONDS, resultDelay);
				print("There appears to be someone trying to hail the base!\n", TimeUnit.MILLISECONDS, resultDelay);
				print("It seems to be the voice of a young girl, and she's stuck deep in the jungle, several hundred kilometers from your position!!!\n", TimeUnit.MILLISECONDS, resultDelay);
				print("Attempting a rescue mission this late at night will be very dangerous, but she'll surely be dead by morning if you leave her to die", TimeUnit.MILLISECONDS, resultDelay);
				print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
				print("What will you do", TimeUnit.MILLISECONDS, resultDelay);
				print("?", TimeUnit.MILLISECONDS, waitAfterQuestionDelay);
				print("\n", TimeUnit.MILLISECONDS, resultDelay);
				print("\n", TimeUnit.MILLISECONDS, resultDelay);
				print("	1) Rescue the girl! We can't just leave her to die!!\n", TimeUnit.MILLISECONDS, resultDelay);
				print("\n", TimeUnit.MILLISECONDS, resultDelay);
				print("	2) It's too dangerous! We have to think about the colony first!\n", TimeUnit.MILLISECONDS, resultDelay);
				print("\n", TimeUnit.MILLISECONDS, resultDelay);
				do
				{
					input = keyboard.nextInt();
					if (!(input == 1 || input == 2))
					{
						print("Please enter only 1 or 2.\n", TimeUnit.MILLISECONDS, optionDelay);
					}
				}
				while (!(input == 1 || input == 2));
				
				if (input == 1)
				{
					print("\nYou've made up your mind, you have to do everything in your power to save her!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("You sound the emergency alarm and order all available units to suit up and assemble at the land rovers!!!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("You quickly explain the situation to your troops, and see your own steel determination reflected in their eyes.\n", TimeUnit.MILLISECONDS, resultDelay);
					print("Without another seconds delay, you all mount up and set forth to rescue the girl!\n", TimeUnit.MILLISECONDS, resultDelay);
					print("\n", TimeUnit.MILLISECONDS, resultDelay);
					print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
					print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
					print("...\n\n", TimeUnit.MILLISECONDS, darkStatementDelay);
					
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
								rescueSpecial = 0;
							}
							else
							{
								rescueSpecial = 1;
							}
						}
						else if (offense > 70)
						{
							rescueSpecial = random.nextInt(10) + 1; //70% chance
							if (rescueSpecial == 10 || rescueSpecial == 9 || rescueSpecial == 8)
							{
								rescueSpecial = 0;
							}
							else
							{
								rescueSpecial = 1;
							}
						}
						else if (offense > 60)
						{
							rescueSpecial = random.nextInt(5) + 1; //60% chance
							if (rescueSpecial == 5 || rescueSpecial == 4)
							{
								rescueSpecial = 0;
							}
							else
							{
								rescueSpecial = 1;
							}
						}
						else if (offense > 50)
						{
							rescueSpecial = random.nextInt(2) + 1; //50% chance
						}
						else if (offense > 40)
						{
							rescueSpecial = random.nextInt(5) + 1; //40% chance
							if (rescueSpecial == 1 || rescueSpecial == 2)
							{
								rescueSpecial = 1; //success
							}
							else
							{
								rescueSpecial = 0; //failure
							}
						}
						else if (offense > 30)
						{
							rescueSpecial = random.nextInt(10) + 1; //30% chance
							if (rescueSpecial == 10 || rescueSpecial == 9 || rescueSpecial == 8)
							{
								rescueSpecial = 1;
							}
							else
							{
								rescueSpecial = 0;
							}
						}
						else if (offense > 20)
						{
							rescueSpecial = random.nextInt(5) + 1; //20% chance
							if (rescueSpecial == 5)
							{
								rescueSpecial = 1;
							}
							else
							{
								rescueSpecial = 0;
							}
						}
						else
						{
							rescueSpecial = random.nextInt(10) + 1; //10% chance
							if (rescueSpecial == 10)
							{
								rescueSpecial = 1;
							}
							else
							{
								rescueSpecial = 0;
							}
						}
					}
					else
					{
						rescueSpecial = 1;
					}
					
					if (rescueSpecial == 1)
					{
						print("Sometime later, deep in the dense forests of the far north...\n", TimeUnit.MILLISECONDS, resultDelay);
						print("Your driver turns and tells you that you're closing in on the origin of the radio signal!\n", TimeUnit.MILLISECONDS, resultDelay);
						print("Your lean forward in your seat in anticipation, eyes straining to see through the thick windshield", TimeUnit.MILLISECONDS, resultDelay);
						print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
						print("Suddenly, there she is!\n", TimeUnit.MILLISECONDS, resultDelay);
						print("Shivering and afraid, your squadron quickly forms a defensive perimeter around her!\n", TimeUnit.MILLISECONDS, resultDelay);
						print("You leap out of your rover and wrap a blanket around her, assuring her that she's safe now!\n", TimeUnit.MILLISECONDS, resultDelay);
						
						if (defense < 100)
						{
							returnSpecial = random.nextInt(1) + 1; //100-defense
						}
						else 
						{
							returnSpecial = 1;
						}
						
						if (returnSpecial == 1)
						{
							//success!!
						}
						else
						{
							//loss of population and Special
						}
					}
					else
					{
						print("Sometime later, deep in the dense forests of the far north...\n", TimeUnit.MILLISECONDS, resultDelay);
						print("A dense fog seems to have slowly crept into this region.\n", TimeUnit.MILLISECONDS, resultDelay);
						print("You're beginning to have second thoughts about this rescue mission", TimeUnit.MILLISECONDS, resultDelay);
						print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
						print("\n...\n\n", TimeUnit.MILLISECONDS, darkStatementDelay);
						print("Suddenly, a large pack of raptors materialize from the fog!\n", TimeUnit.MILLISECONDS, resultDelay);
						print("Your offensive capabilities are no match for their speed! Your men are overrun and split into every direction!\n", TimeUnit.MILLISECONDS, resultDelay);
						print("Your troops are savagely torn limb from limb and you barely make it out with the men in your rover alive!\n", TimeUnit.MILLISECONDS, resultDelay);
						print("Using your radios you manage to regroup with whats left of your squadron. It's going to a quiet ride back to Terra Nova", TimeUnit.MILLISECONDS, resultDelay);
						print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
						int checkPop = population/2;
						print("\t-" + checkPop + " population\n", TimeUnit.MILLISECONDS, resourceGainDelay);
						population -= checkPop;
					}
					
				}
				else if (input == 2)
				{
					print("As much as you'd like to save her, you simply can't justify risking everything for one girl.\n", TimeUnit.MILLISECONDS, resultDelay);
					print("With a heavy heart, you decide must ignore her cry for help.\n", TimeUnit.MILLISECONDS, resultDelay);
					print("You only hope it was the right decision to make\n", TimeUnit.MILLISECONDS, resultDelay);
					print("...\n", TimeUnit.MILLISECONDS, darkStatementDelay);
				}
			}
			
			print("\n", TimeUnit.MILLISECONDS, resultDelay);
			
			print("||================== End of Day " + day + " ==================||\n", TimeUnit.MILLISECONDS, endofdayDelay);
			enter();
			
			day++;
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
	
	public static void print(String data, TimeUnit unit, long delay) throws InterruptedException
	{
		for (char ch : data.toCharArray())
		{
			System.out.print(ch);
			unit.sleep(delay);
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
														//This means I must add a continue section at the menu as well! Save data/time as well (see import statements)
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