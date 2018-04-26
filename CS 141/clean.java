import java.util.Scanner;

public class clean
{
	public static void main (String[] args)
	{
		System.out.printf("%d", fun(4, 3));
	}
	
public static int fun(int a, int b) 
{
   if (b == 0)
       return 0;
   if (b % 2 == 0)
       return fun(a+a, b/2);
 
   return fun(a+a, b/2) + a;
}
}