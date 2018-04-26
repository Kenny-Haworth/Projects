/** Name: Kendall Haworth
	
	Class: CS140, Section 01
	
	Create a java program that calculates your gross pay by using your hourly pay rate
	and the number of hours you worked this week. If you worked less than 15 hours, you
	get $0 and your pay is deferred to next week. If you work overtime (more than 40 hours),
	your pay is 1.5x the rate for your overtime hours. You are not paid for more than 60 hours
	a week. Only whole hours can be counted.
	
	Date Due: October 18, 2016
	
*/

import java.util.Scanner;

public class Project2Task1
{
	public static void main(String[] args)
	{
		double inputHours; //To hold the hours the user inputted that they worked per week.
		double payRate; //To hold the user's hourly pay rate.
		double grossPay; //To hold the user's gross pay.
		double regularPay; //To hold the user's regular pay rate without overtime hours.
		int overTimeHours; //To hold the number of overtime hours the user worked (calculated).
		double overTimePay; //To hold the amount of money earned from overtime hours (calculated).
		double overTimePayRate; // To hold the overtime pay rate for overtime hours (calclated).
		int numberOfVolunteerHours; //To hold how many hours the user worked for no pay.
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the number of hours you worked this week:");
		inputHours = keyboard.nextDouble();
		
		int hours = (int)inputHours; //To convert hours to an integer, rounded down to the nearest whole number.
									// This is because only whole hours are counted towards the gross pay.
		
		System.out.println("Enter your hourly pay rate:");
		payRate = keyboard.nextDouble();
		
		if (hours < 15)
			System.out.println("Your gross pay is $0. Sorry, you need to work at least 15 hours" +
								" this week to get paid. Your hours will be deferred to next week.");
		else if (hours >= 15 && hours <= 40)
		{
			grossPay = payRate * hours;
			System.out.println("Your gross pay is $" + grossPay + ".");
		}
		else if (hours >40 && hours <=60)
		{
			regularPay = payRate * 40;
			overTimeHours = hours - 40;
			overTimePayRate = payRate * (1.5);
			overTimePay = overTimePayRate * overTimeHours;
			grossPay = regularPay + overTimePay;
			
			System.out.println("Your gross pay is $" + grossPay + ".");
		}
		else if (hours > 60)
		{
			numberOfVolunteerHours = hours - 60;
			hours = 60;
			regularPay = payRate * 40;
			overTimeHours = hours - 40;
			overTimePayRate = payRate * (1.5);
			overTimePay = overTimePayRate * overTimeHours;
			grossPay = regularPay + overTimePay;
			
			
			System.out.println("Your gross pay is $" + grossPay + ". You worked " +
								numberOfVolunteerHours + " volunteer hours, because you are " +
								"only paid for 60 hours a week.");
		}
	}
}