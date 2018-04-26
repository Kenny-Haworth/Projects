/**
	@author Kendall Haworth
	
	Project 3 for CS 241-02
	
	This is the driver class and contains the main method,
	the actual ADT for the graph and Dijkstra's Algorithm
	is in the file Digraph.java
*/

import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;

public class Project3
{
	public static void main(String[] args) throws IOException, EmptyQueueException
	{	
		Digraph graph = new Digraph(); //creates and initializes a directed graph with the input files "city.dat" and "road.dat"
		boolean loop = true; //controls the main input loop
		Scanner kb = new Scanner(System.in);
		StringTokenizer token;
		String input;
		
		while (loop)
		{
			System.out.print("Command? "); //prompt the user for a command
			input = kb.nextLine();
		
			if (input.equalsIgnoreCase("Q")) //Query the information
			{
				System.out.print("City code: "); //get the city code
				input = kb.nextLine();
				graph.cityInfo(input); //call the information with the given city code
			}
			else if (input.equalsIgnoreCase("D")) //Find the shortest distance between two cities
			{
				System.out.print("City codes: "); //get the city codes
				input = kb.nextLine();
				token = new StringTokenizer(input, " ");
				
				String first = token.nextToken(); //use a string tokenizer to break up the input into two strings
				String second = null;
				
				if (token.hasMoreTokens()) //get the second string if the user inputted one
				{
					second = token.nextToken();
				}
				
				if (first.equals(second)) //The city codes are the same
				{
					System.out.println("The distance from this city to itself is 0.");
				}
				else //find the shortest distance and path between the given cities
				{
					graph.distance(first, second);
				}
			}
			else if (input.equalsIgnoreCase("I")) //insert a road
			{
				System.out.print("City codes and distance: "); //get the city codes and distance
				input = kb.nextLine();
				token = new StringTokenizer(input, " ");
				
				String first = token.nextToken(); //use a string tokenizer to break up the input
				
				if (!token.hasMoreTokens())
				{
					System.out.println("Please enter a valid second city and distance!");
				}
				else
				{
					String second = token.nextToken();
					
					if (!token.hasMoreTokens())
					{
						System.out.println("Please enter a valid distance for the road between these cities!");
					}
					else
					{
						String third = token.nextToken();
					
						if (first.equals(second)) //the city codes are the same
						{
							System.out.println("You cannot insert a city road to itself!");
						}
						else
						{
							graph.insert(first, second, third); //insert the road with the given city codes and distance
						}
					}
				}
			}
			else if (input.equalsIgnoreCase("R")) //remove a road
			{
				System.out.print("City codes: "); //get the city codes
				input = kb.nextLine();
				token = new StringTokenizer(input, " ");
				
				String first = token.nextToken(); //break up the string using a string tokenizer
				String second = null;
				
				if (token.hasMoreTokens()) //get the second string if the user inputted one
				{
					second = token.nextToken();
				}
				
				if (first.equals(second)) //the city codes are the same
				{
					System.out.println("You cannot remove a city road to itself!");
				}
				else
				{
					graph.remove(first, second); //remove the road between the given city codes
				}
			}
			else if (input.equalsIgnoreCase("H")) //display the menu
			{
				System.out.println("   Q	Query the city information by entering the city code.");
				System.out.println("   D	Find the minimum distance between two cities.");
				System.out.println("   I	Insert a road by entering two city codes and the distance.");
				System.out.println("   R	Remove an existing road by entering two city codes.");
				System.out.println("   H	Display this message.");
				System.out.println("   E	Exit.");
			}
			else if (input.equalsIgnoreCase("E")) //exit the program
			{
				loop = false; //end the loop
			}
			else //if anything was inputted besides what is allowed, the program will ask for input again
			{
				System.out.println("That is not an input I recognize!");
			}
		}
	}
}