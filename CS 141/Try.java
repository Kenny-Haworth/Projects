import java.util.*;

public class Try
{
	public static void main(String[] args)
	{
		double answer;
		double num1, num2, num3;
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter the first number:");
		num1 = kb.nextDouble();
		
		System.out.println("Enter the second number:");
		num2 = kb.nextDouble();
		
		System.out.println("Enter the third number:");
		num3 = kb.nextDouble();
		
		try
		{
			System.out.println("1");
			System.out.println(root(num1, num2, num3));
			System.out.println("2");
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("U stupid this is WRONG!");
			System.out.println(e.getMessage());
		}
	}
	
	public static double root(double A, double B, double C) throws IllegalArgumentException
	{
		if (A==0)
		{
			throw new IllegalArgumentException("A can't be zero.");
		}
		else
		{
			double disc = B*B - 4*A*C;
			if (disc < 0)
			{
				throw new IllegalArgumentException("Discriminant < zero.");
			}
			return (-B + Math.sqrt(disc))/(2*A);
		}
	}
}