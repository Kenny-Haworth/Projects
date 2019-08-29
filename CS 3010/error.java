import java.lang.Math;

public class error
{
	public static void main(String[] args)
	{
		for (int x = 10; x > 0; x--)
		{
			System.out.println("For x = " + x);
			System.out.println("With high error: " + (Math.sqrt(Math.pow(x, 2) + 1) - 1));
			System.out.println("With low error: " + Math.pow(x, 2)/Math.sqrt(Math.pow(x, 2) + 1));
			System.out.println("Absolute difference in answers: " + Math.abs((Math.sqrt(Math.pow(x, 2) + 1) - 1) - (Math.pow(x, 2)/Math.sqrt(Math.pow(x, 2) + 1))));
			System.out.println("Relative Error: " + ((Math.pow(x, 2)/Math.sqrt(Math.pow(x, 2) + 1)) - ((Math.sqrt(Math.pow(x, 2) + 1) - 1))) /(Math.pow(x, 2)/Math.sqrt(Math.pow(x, 2) + 1)));
		}
	}
}