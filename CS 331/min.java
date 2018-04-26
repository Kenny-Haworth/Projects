public class min
{
	public static void main(String[] args)
	{
		int result = calculate(625);
		System.out.println(result);
	}
	
	public static int calculate(int n)
	{
		if(n == 1)
		{
			return 1;
		}
		else
		{
			return 7*calculate(n/5) + 10*n;
		}
	}
}