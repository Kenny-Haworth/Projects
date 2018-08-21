/**
	A class to manage weather for a colony.
*/

package Managers;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WeatherManager
{	
	private boolean rain = false; //weather events
	private boolean sunshine = false;
	private boolean lightning = false;
	private boolean snow = false;
	private boolean wind = false;
	private boolean fog = false;
	
	private int resultDelay;
	private int darkStatementDelay;
	private int resourceGainDelay;
	
	private int amount; //for temporary amounts to be reverted
	
	public WeatherManager(int result, int darkStatement, int resourceGain)
	{
		resultDelay = result;
		darkStatementDelay = darkStatement;
		resourceGainDelay = resourceGain;
	}
	
	public void applyWeather(ColonyManager colony) throws InterruptedException
	{
		Random random = new Random();
		
		int weather = random.nextInt(2) + 1; //%50 chance of weather
		if (weather == 1)
		{
			weather = random.nextInt(6) + 1;
			if (weather == 1)
			{
				rain = true;
				print("It's raining today", resultDelay);
				print("...\n", darkStatementDelay);
				
				amount = colony.subtractHappiness(10);
				
				if (amount != 0)
				{
					print("\t-" + amount + " happiness\n", resourceGainDelay);
				}
			}
			else if (weather == 2)
			{
				sunshine = true;
				print("The sun is out and it's shining brightly today!\n", resultDelay);
				
				amount = colony.addHappiness(10);
				
				if (amount != 0)
				{
					print("\t+" + amount + " happiness\n", resourceGainDelay);
				}
			}
			else if (weather == 3)
			{
				lightning = true;
				print("There's a lightning storm today!\n", resultDelay); //Low chance of someone dying? Maybe make materials harder to get on the mountains!
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
				
				amount = colony.getOffense()/10;
				
				if (amount != 0)
				{
					print("\t-" + amount + " offense\n", resourceGainDelay);
					colony.subtractOffense(amount);
				}
			}
			else if (weather == 6)
			{
				fog = true;
				print("A dense fog has settled in over the area this morning", resultDelay);
				print("...\n", darkStatementDelay);
				print("You can barely see 15 feet beyond your walls!\n", resultDelay);
				print("This will make it much more difficult to see enemies", resultDelay);
				print("...\n", darkStatementDelay);
				
				amount = colony.getDefense()/10;
				
				if (amount != 0)
				{
					print("\t-" + amount + " defense\n", resourceGainDelay);
					colony.subtractDefense(amount);
				}
			}
			
			print("\n", resultDelay);
		}
	}
	
	public void revertWeather(ColonyManager colony) throws InterruptedException
	{
		if (rain)
		{
			rain = false;
			print("\nThe rain seems to have finally died down at the end of the day!\n", resultDelay);
			print("You see a rainbow form off in the distance", resultDelay);
			print("...\n", darkStatementDelay);
			print("The Jurassic Age truly holds a beautiful world", resultDelay);
			print("...\n", darkStatementDelay);
			
			if (amount != 0)
			{
				print("\t+" + amount + " happiness\n", resourceGainDelay);
				colony.addHappiness(amount);
			}
		}
		else if (sunshine)
		{
			sunshine = false;
			print("\nThe bright, orange sun has finally sunk beneath the horizon at the end of the day", resultDelay);
			print("...\n", darkStatementDelay);
			print("Everyone's mood darkens as the world is once again cast into shadows", resultDelay);
			print("...\n", darkStatementDelay);
			
			if (amount != 0) //success in adding happiness
			{
				print("\t-" + amount + " happiness\n", resourceGainDelay);
				colony.subtractHappiness(amount);
			}
		}
		else if (lightning)
		{
			lightning = false;
			print("\nThe lightning storm has finally died down at the end of the day!\n", resultDelay); //end negative status effect
		}
		else if (snow)
		{
			snow = false;
			print("\nThe snow has finally stopped, and the animals are slowly re-emerging from their dens and homes!\n", resultDelay); //end negative status effect
		}
		else if (wind)
		{
			wind = false;
			print("\nThe howling gale of wind has finally died down at the end of the day!\n", resultDelay);
			print("Your guards finally relax as the world once again falls quiet and peaceful.\n", resultDelay);
			
			if (amount != 0)
			{
				print("\t+" + amount + " offense\n", resourceGainDelay);
				colony.addOffense(amount);
			}
		}
		else if (fog)
		{
			fog = false;
			print("\nThe fog has finally begun to lift at the end of the day!\n", resultDelay);
			print("Your men are now at ease, being able to see far beyond your walls once more.\n", resultDelay);
			
			if (amount != 0)
			{
				print("\t+" + amount + " defense\n", resourceGainDelay);
				colony.addDefense(amount);
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