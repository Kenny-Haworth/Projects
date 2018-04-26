/** Name: Kendall Haworth
	
	Class: CS140, Section 01
	
	Project 1, Task 2 - Create a program that asks two users, one by one, to enter their name as well
	as three separate test scores. The program should display all three scores and the average of the
	three scores, separately, for each user.

*/

import java.util.Scanner;

public class Project1Task2
{
	public static void main(String[] args)
	{
		String user1Name; //To hold the first user's name.
		double user1Score1; //To hold the first user's first score.
		double user1Score2; //To hold the first user's second score.
		double user1Score3; //To hold the first user's third score.
		double user1Average; //To hold the first user's average.
		String user2Name; //To hold the second user's name.
		double user2Score1; //To hold the second user's first score.
		double user2Score2; //To hold the second user's second score.
		double user2Score3; //To hold the second user's third score.
		double user2Average; //To hold the second user's average.
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the name of the first user:");
		user1Name = keyboard.nextLine();
		
		System.out.println("Enter the first score:");
		user1Score1 = keyboard.nextDouble();
		
		System.out.println("Enter the second score:");
		user1Score2 = keyboard.nextDouble();
		
		System.out.println("Enter the third score:");
		user1Score3 = keyboard.nextDouble();
		
		user1Average = (user1Score1 + user1Score2 + user1Score3)/3;
		
		System.out.println("Hello, " + user1Name + ". Your first score is " + user1Score1 +
							". Your second score is " + user1Score2 + ". Your third score is " +
							user1Score3 + ". Your average score is " + user1Average + ".");
				
		keyboard.nextLine();
				
		System.out.println("Enter the name of the second user:");
		user2Name = keyboard.nextLine();
		
		System.out.println("Enter the first score:");
		user2Score1 = keyboard.nextDouble();
		
		System.out.println("Enter the second score:");
		user2Score2 = keyboard.nextDouble();
		
		System.out.println("Enter the third score:");
		user2Score3 = keyboard.nextDouble();
		
		user2Average = (user2Score1 + user2Score2 + user2Score3)/3;
		
		System.out.println("Hello, " + user2Name + ". Your first score is " + user2Score1 +
							". Your second score is " + user2Score2 + ". Your third score is " +
							user2Score3 + ". Your average score is " + user2Average + ".");
	}
}