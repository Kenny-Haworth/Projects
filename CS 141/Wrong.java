public class Wrong
{
	public static void main (String[] args)
	{
		String word = "John Will";
		try
		{
			if(word.contains(" "))
			{
				throw new Exception1();
			}
			if(word.contains("n"))
			{
				throw new Exception2();
			}
			if(word.contains("q"))
			{
				throw new Exception3();
			}
		}
		catch(Exception1 | Exception2 | Exception3 ex)
		{
			System.out.println("There is a space, n, or q in your string");
		}
	}
}