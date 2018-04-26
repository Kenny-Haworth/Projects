// Name: Kendall Haworth
// Date: October 25, 2016
// CS140 Section 1. Create a java program that uses nested for loops to display the given pattern.

public class asdf
{
	public static void main(String[] args)
	{
		final int baseSize = 6;
		
		for (int i=1; i <= baseSize; i++)
		{
			for (int r = 1; r <= i; r++)
			{
				System.out.print(r);
			}
			System.out.println();
		}
	}
}