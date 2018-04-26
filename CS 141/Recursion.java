import java.util.Scanner;

public class Recursion
{
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a number. I will tell you how many 8's are in the number:");
		int number = keyboard.nextInt();
		int total = count8(number);
		
		System.out.println("There are " + count8(number) + "8's in this number.");
	}
	
	public static int count8(int n)
	{
		int count = 0;
		
		if (n % 10 == 8)
		{
			count ++;
		}
		
		n /= 10;
		
		if (n <= 9)
		{
			if (n == 8)
			{
				count++;
			}
			return count;
		}
		else
		{
			count8(n);
		}
	}
}