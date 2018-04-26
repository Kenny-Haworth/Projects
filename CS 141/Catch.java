import java.io.FileNotFoundException;

public class Catch
{
	private static Haworth_Diamond one = null;
	public static void main (String[] args)
	{
		try
		{
			Haworth_Diamond one = null;
		
			tryMethod(one);
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			System.out.println("The program executed successfully.");
		}
	}
	public static void tryMethod(Haworth_Diamond one)
	{
		System.out.println("This is a method.");
	}
}