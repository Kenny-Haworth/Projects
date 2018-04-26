import java.util.Scanner;

public class DayOfWeek
{
	enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}
	
	public static void main(String[] args)
	{
		Day choice;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Select a day of the week:");
		System.out.println("SUNDAY");
		System.out.println("MONDAY");
		System.out.println("TUESDAY");
		System.out.println("WEDNESDAY");
		System.out.println("THURSDAY");
		System.out.println("FRIDAY");
		System.out.println("SATURDAY");
		System.out.println("Enter a day of the week: ");
		choice = Day.valueOf(keyboard.nextLine());
		
		switch (choice)
		{
			case SUNDAY:
			{
				System.out.println("The business is open from 11 to 5 on SUNDAY.");
				break;
			}
			case MONDAY:
			{
				System.out.println("The business is open from 9 to 9 on MONDAY.");
				break;
			}
			case TUESDAY:
			{
				System.out.println("The business is open from 9 to 9 on TUESDAY.");
				break;
			}
			case WEDNESDAY:
			{
				System.out.println("The business is open from 9 to 9 on WEDNESDAY.");
				break;
			}
			case THURSDAY:
			{
				System.out.println("The business is open from 9 to 9 on THURSDAY.");
				break;
			}
			case FRIDAY:
			{
				System.out.println("The business is open from 9 to 9 on FRIDAY.");
				break;
			}
			case SATURDAY:
			{
				System.out.println("The business is open from 10 to 6 on SATURDAY.");
				break;
			}
		}
	}
}