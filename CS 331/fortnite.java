/**
	Where are we dropping boys?
	
	A buddy of mine actually asked me to make this since he could never decide where to go in the game Fortnite.
	It simply picks a location at random.
*/

import java.util.Random;

public class fortnite
{
	public static void main(String[] args)
	{
		int locations = 20;
		
		Random random = new Random();
		
		int spot = random.nextInt(locations) + 1;
		
		if (spot == 1)
		{
			System.out.println("Junk Junction");
		}
		else if (spot == 2)
		{
			System.out.println("Haunted Hills");
		}
		else if (spot == 3)
		{
			System.out.println("Snobby Shores");
		}
		else if (spot == 4)
		{
			System.out.println("Greasy Grove");
		}
		else if (spot == 5)
		{
			System.out.println("Pleasant Park");
		}
		else if (spot == 6)
		{
			System.out.println("Loot Lake");
		}
		else if (spot == 7)
		{
			System.out.println("Tilted Towers");
		}
		else if (spot == 8)
		{
			System.out.println("Shifty Shafts");
		}
		else if (spot == 9)
		{
			System.out.println("Flush Factory");
		}
		else if (spot == 10)
		{
			System.out.println("Lucky Landing");
		}
		else if (spot == 11)
		{
			System.out.println("Fatal Fields");
		}
		else if (spot == 12)
		{
			System.out.println("Salty Springs");
		}
		else if (spot == 13)
		{
			System.out.println("Dusty Divot");
		}
		else if (spot == 1)
		{
			System.out.println("Anarchy Acres");
		}
		else if (spot == 14)
		{
			System.out.println("Risky Reels");
		}
		else if (spot == 15)
		{
			System.out.println("Tomato Town");
		}
		else if (spot == 16)
		{
			System.out.println("Wailing Woods");
		}
		else if (spot == 17)
		{
			System.out.println("Lonely Lodge");
		}
		else if (spot == 18)
		{
			System.out.println("Retail Row");
		}
		else if (spot == 19)
		{
			System.out.println("Moisty Mire");
		}
		else if (spot == 20)
		{
			System.out.println("Prison");
		}
	}
}