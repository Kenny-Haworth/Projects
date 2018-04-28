import java.util.Scanner;

public class primeTest
{
	public static void main(String[] args)
	{
		int b;
		Scanner kb = new Scanner(System.in);

		System.out.println("Enter the end of the range to print prime numbers out.");
		b = kb.nextInt();

		
		for (int i = 1; i < b; i++)
		{
			boolean isPrimeNumber = true;
			
			for (int j = 2; j < i; j++)
			{	
				if (i % j == 0)
				{
					isPrimeNumber = false;
					break;
				}
			}
			
			if (isPrimeNumber)
			{
				System.out.print(i + " ");
			}
		}
	}
}