/** Name: Kendall Haworth
	
	Class: CS140, Section 01
	
	Create a java program that prompts the user for a month and day and then prints the season
	for that date determined by the following rules:
	
		Spring	3/21 – 6/20
		Summer	6/21 – 9/20
		Fall	9/21 – 12/20
		Winter	12/21 – 3/20
	
	Date Due: October 18, 2016
	
*/

import java.util.Scanner;

public class Project2Task2
{
	public static void main(String[] args)
	{
		int month; //To hold the month of the year.
		int day; //To hold the day of the year.
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the month of the year:");
		month = keyboard.nextInt();
		if (month < 1 || month > 12)
		{
			System.out.println("Invalid month! Please only enter numbers from 1-12!");
			return;
		}
		
		System.out.println("Enter the day of the year:");
		day = keyboard.nextInt();
		if (day < 1 || day > 31)
		{
			System.out.println("Invalid day! Please only enter numbers from 1-31!");
			return;
		}
		
	else if (month == 1 || month == 2)
		System.out.println(month + "/" + day + " is in the Winter season.");
	else if (month == 4 || month == 5)
		System.out.println(month + "/" + day + " is in the Spring season.");
	else if (month == 7 || month == 8)
		System.out.println(month + "/" + day + " is in the Summer season.");
	else if (month == 10 || month == 11)
		System.out.println(month + "/" + day + " is in the Fall season.");
	else if (month == 3 && day < 21)
		System.out.println(month + "/" + day + " is in the Winter season.");
	else if (month == 3 && day >= 21)
		System.out.println(month + "/" + day + " is in the Spring season.");
	else if (month == 6 && day < 21)
		System.out.println(month + "/" + day + " is in the Spring season.");
	else if (month == 6 && day >= 21)
		System.out.println(month + "/" + day + " is in the Summer season.");
	else if (month == 9 && day < 21)
		System.out.println(month + "/" + day + " is in the Summer season.");
	else if (month == 9 && day >= 21)
		System.out.println(month + "/" + day + " is in the Fall season.");
	else if (month == 12 && day < 21)
		System.out.println(month + "/" + day + " is in the Fall season.");
	else if (month == 12 && day >= 21)
		System.out.println(month + "/" + day + " is in the Winter season.");
	}
}