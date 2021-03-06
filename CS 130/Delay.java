import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delay
{
	public static void main(String[] args) throws Exception
	{
		printWithDelays("HELLO", TimeUnit.MILLISECONDS, 1000);
	}

	public static void printWithDelays(String data, TimeUnit unit, long delay) throws InterruptedException
	{
		for (char ch:data.toCharArray())
		{
			System.out.print(ch);
			unit.sleep(delay);
		}
	}
}