import java.util.Scanner;

public class PiReplace
{
	public static void main (String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a string:");
		String apple = keyboard.nextLine();
		System.out.println(changePi(apple));
	}
	
	public static String changePi(String str)
	{
		if (str.indexOf("pi") == - 1)
		{
			return str;
		}
		System.out.println(str);
		str = str.replaceFirst("pi", "3.14");
		return changePi(str);
		//return str.replace("pi", "3.14");
	}
}