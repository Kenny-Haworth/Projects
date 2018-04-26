import java.util.*;

public class Calculus implements Arithmetic
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		Calculus something = new Calculus();
	
		System.out.println("Enter an integer value:");
		int x = keyboard.nextInt();
	
		System.out.println("Enter another integer value:");
		int y = keyboard.nextInt();
		
		int added = something.summable(x,y);
		int subtracted = something.subtractable(x,y);
		
		System.out.println("Added these values are: " + added + ".");
		System.out.println("Subtracted these values are: " + subtracted + ".");
	}
	
	public int summable(int x, int y)
	{
		return x+y;
	}
	
	public int subtractable(int x, int y)
	{
		return x-y;
	}
}