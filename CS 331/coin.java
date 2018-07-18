import java.util.Scanner;

public class coin
{
	public static void main(String[] args)
	{
		//25, 10, 5, 10
		
		int coinA = 25;
		int coinB = 10;
		int coinC = 5;
		int coinD = 1;
		
		int A = 0;
		int B = 0;
		int C = 0;
		int D = 0;
		
		Scanner koreanboy = new Scanner(System.in);
		System.out.println("Enter a value: ");
		int value = koreanboy.nextInt();
		
		while (value != 0)
		{
			if (value > coinA)
			{
				value-=coinA;
				A++;
			}
			else if (value > coinB)
			{
				value-=coinB;
				B++;
			}
			else if (value > coinC)
			{
				value-=coinC;
				C++;
			}
			else if(value > 0)
			{
				value-=coinD;
				D++;
			}
		}
		
		System.out.println("Number of 25: " + A);
		System.out.println("Number of 10: " + B);
		System.out.println("Number of 5: " + C);
		System.out.println("Number of 1: " + D);
	}
}