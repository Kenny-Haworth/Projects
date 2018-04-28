import java.util.Iterator;
import java.util.ArrayList;
import java.util.*;

public class test
{
	public static void main(String[] args)
	{
		int one = 0;
		int two = 0;
		int three = 0;
		int four = 0;
		int five = 0;
		int six = 0;
		Random random = new Random();
		for (int i = 0; i < 50; i++)
		{
			int shipment = random.nextInt(6) + 1;
			if (shipment == 1)
			{
				one++;
			}
			else if (shipment == 2)
			{
				two++;
			}
			else if (shipment == 3)
			{
				three++;
			}
			else if (shipment == 4)
			{
				four++;
			}
			else if (shipment == 5)
			{
				five++;
			}
			else if (shipment == 6)
			{
				six++;
			}
		}
		
		System.out.println("One: " + one);
		System.out.println("Two: " + two);
		System.out.println("Three: " + three);
		System.out.println("Four: " + four);
		System.out.println("Five: " + five);
		System.out.println("Six: " + six);
	}
}