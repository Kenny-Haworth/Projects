/**
	@author Kendall Haworth
	
	ADT Graph for CS 241-02
	Contains Dijkstra's algorithm
*/

import java.util.Scanner;
import java.io.*;
import java.lang.StringBuilder;

public class Digraph
{
	//global private arrays, available to all methods
	private String[][] array; //holds each city's information
	private int[][] data; //holds the path matrix for distances between cities
	
	/**
		Constructor for the Digraph class.
		Reads in the input files city.dat and road.dat
		and creates a 2D array and a path matrix to hold
		that information
	*/
	public Digraph() throws IOException
	{
		array = new String[20][5]; //initialize the city matrix (20 x 5 for 5 pieces of information for 20 cities)
		data = new int[20][20]; //initialize the path matrix (20 x 20 for 20 cities)
		
		File input = new File("city.dat"); //read in the first input file, city.dat
		Scanner inputFile = new Scanner(input);
		StringBuilder stringBuilder; //create a StringBuilder
		
		int row = 0;
		int column = 0;
		
		while (inputFile.hasNext()) //loop until the file is empty
		{
			int count = 0; //the number of strings currently read in one row
			
			for (int i = 0; i < 5; i++) //loop 5 times for 5 columns
			{
				if (!inputFile.hasNextInt()) //if it is not an int that has been read in, it's a string
				{
					count++;
				}
				else //reset the counter, only keep track of 3 strings in a row
				{
					count = 0;
				}
				
				if (count == 3) //3 strings in a row means a name has two parts to it (like Brea Canyon), so append them to the same string
				{
					stringBuilder = new StringBuilder(); //initialize a new string builder
					String cheese = inputFile.next(); //get the next string from the file
					String string = array[row][--column]; //get the previously saved string
					stringBuilder.append(string); //append the first string
					stringBuilder.append(" "); //append a space character
					stringBuilder.append(cheese); //append the second string
					String combined = stringBuilder.toString(); //get the combined string
					array[row][column++] = combined; //save the combined string
				}
				
				array[row][column++] = inputFile.next(); //save the data and advance to the next column
			}
			
			row++; //increment the row
			column = 0; //reset the column
		}
		
		input = new File("road.dat"); //read in the second input file, road.dat
		inputFile = new Scanner(input);
		
		int distance;
		
		while (inputFile.hasNext()) //loop until the file is empty
		{
			row = inputFile.nextInt(); //the first int is the from-city, range 1-20
			column = inputFile.nextInt(); //the second int is the to-city, range 1-20
			distance = inputFile.nextInt(); //the third int is the distance
			data[row-1][column-1] = distance; //save the data to a path matrix
		}

		inputFile.close();
	}
	
	/**
		Calculates the shortest distance between the given city codes.
		
		@param first The first city code.
		@param second The second city code.
	*/
	public void distance(String first, String second) throws EmptyQueueException
	{
		String firstCityName = null; //the first city name
		String secondCityName = null; //the second city name
		boolean foundFirst = false; //the first city is initially not found
		boolean foundSecond = false; //the second city is initially not found
		int firstCode = 0; //the first city's code, range 1-20
		int secondCode = 0; //the second city's code, range 1-20
		
		for (int row = 0; row < array.length; row++) //scan each row of the array
		{
			if (array[row][1].equals(first)) //the first city code matches the array's city code
			{
				firstCode = Integer.parseInt(array[row][0]); //save the first city code
				firstCityName = array[row][2]; //save the first city name
				foundFirst = true; //the first city has been found
			}
			else if (array[row][1].equals(second)) //the second city code matches the array's city code
			{
				secondCode = Integer.parseInt(array[row][0]); //save the second city code
				secondCityName = array[row][2]; //save the second city name
				foundSecond = true; //the second city has been found
			}
		}
		
		if (!foundFirst && !foundSecond) //neither city was found
		{
			System.out.println("The first and second city code do not exist!");
		}
		else if (!foundFirst) //the first city wasn't found
		{
			System.out.println("The first city code does not exist!");
		}
		else if (!foundSecond) //the second city wasn't found
		{
			System.out.println("The second city code does not exist!");
		}
		else //they both have been found, perform Djikstra's algorithm
		{
			PriorityQueue<Entry> queue = new PriorityQueue<Entry>(); //create a priority queue
			
			Entry[] entries = new Entry[20]; //creates an array of entry objects (see class Entry.java)
			boolean[] visited = new boolean[20]; //create a boolean array to keep track of which cities have been visited
			
			for (int i = 0; i < 20; i++) //initialize each Entry object
			{
				entries[i] = new Entry(); //call the constructor
				entries[i].setNumber(i); //set the unique city number
			}
			
			for (int i = 0; i < visited.length; i++) //initialize the boolean array
			{
				visited[i] = false; //all cities are not visited initially
			}
			
			entries[firstCode-1].setDistance(0); //set the starting city to a distance of 0
			queue.add(entries[firstCode-1]); //add the starting city to the priority queue
			
			while (!queue.isEmpty()) //loop until the prioirty queue is empty
			{
				Entry temp = queue.remove(); //remove the first Entry object
				int distance = temp.getDistance(); //save the shortest distance
				int cityNumber = temp.getNumber(); //save the cityNumber, range 0-19
				
				for (int co = 0; co < 20; co++) //add temp's neighbors to the priority queue
				{
					if (data[cityNumber][co] > 0 && !visited[co]) //if it is a neighbor and hasn't been visited, add it to the priority queue
					{
						queue.add(entries[co]);
					}
				}
				
				for (int co = 0; co < 20; co++) //search each of temp's neighbors for a shorter path
				{
					if (data[cityNumber][co] > 0 && ((distance + data[cityNumber][co]) < entries[co].getDistance())) //Dijkstra's algorithm, if it is a neighbor and the combined distance
					{																				//is less than the previous distance, it becomes the new shortest distance
						entries[co].setDistance((distance + data[cityNumber][co])); //set the new shortest distance
						entries[co].setCode(array[cityNumber][1]); //save the previous city taken to get to this location
						
						queue.remove(entries[cityNumber]); //remove the Entry object from the priority queue
						queue.add(entries[co]); //add the Entry object back to the priority queue. This ensures it is sorted properly
					}
				}
				
				visited[cityNumber] = true; //mark the city as visited
			}
			
			int distance = entries[secondCode-1].getDistance(); //get the shortest distance between the cities
			
			if (distance == Integer.MAX_VALUE) //if there was no path, the distance is infinity
			{
				System.out.println("There are no roads from " + firstCityName + " to " + secondCityName + "!");
			}
			else //a path exists
			{
				System.out.print("The minimum distance between " + firstCityName + " and " + secondCityName + " is " + distance + " through the route: ");
				
				ArrayStack<String> stack = new ArrayStack<String>(); //create a stack
				int current = secondCode-1; //begin at the last city and work backwards to the starting city
				
				while (entries[current].getCode() != null)
				{
					String name = entries[current].getCode(); //get the city code
					
					stack.push(name); //push the city code to the stack
					
					for (int row = 0; row < array.length; row++)
					{
						if (array[row][1].equals(name)) //the city code matches the one in the array
						{
							current = Integer.parseInt(array[row][0]); //save the city number, range 1-20
							current -= 1; //set the city number for arrays, range 0-19
							break; //exit the for loop; the city number has been found
						}
					}
				}
	
				while (!stack.isEmpty()) //continue until the stack is empty
				{
					String cheese = stack.pop(); //remove each element
					
					if (!stack.isEmpty()) //print the element
					{
						System.out.print(cheese + ", ");
					}
					else //the stack is empty, print the last city (the "to" city) with the last value on the stack
					{
						System.out.print(cheese + ", " + second + ".\n");
					}
				}
			}
		}
	}
	
	/**
		Prints out the city info for the given city code.
		
		@param code The given city code.
	*/
	public void cityInfo(String code)
	{
		boolean found = false; //the city is initially not found
		
		for (int row = 0; row < array.length; row++) //scan the entire array for the city
		{
			if (array[row][1].equals(code)) //the city code matches the array's city code
			{
				for (int c = 0; c < array[row].length; c++) //loop for each column in the row
				{
					System.out.print(array[row][c] + " "); //print out the city information
				}
				found = true; //the city has been found
			}
		}
		
		if (!found) //the city has not been found and doesn't exist
		{
			System.out.print("That city code does not exist!");
		}
		System.out.println();
	}
	
	/**
		Inserts a road from the first city code to the second
		city code with the given distance.
		
		@param first The first city code.
		@param second The second city code.
		@param third The distance between the cities.
	*/
	public void insert(String first, String second, String third)
	{
		String firstCityName = null; //the first city name
		String secondCityName = null; //the second city name
		boolean foundFirst = false; //the first city is initially not found
		boolean foundSecond = false; //the second city is initially not found
		int firstCode = 0; //the first city's code, range 1-20
		int secondCode = 0; //the second city's code, range 1-20
		
		for (int row = 0; row < array.length; row++) //scan each row of the array
		{
			if (array[row][1].equals(first)) //the first city code matches the array's city code
			{
				firstCode = Integer.parseInt(array[row][0]); //save the first city code
				firstCityName = array[row][2]; //save the first city name
				foundFirst = true; //the first city has been found
			}
			else if (array[row][1].equals(second)) //the second city code matches the array's city code
			{
				secondCode = Integer.parseInt(array[row][0]); //save the second city code
				secondCityName = array[row][2]; //save the second city name
				foundSecond = true; //the second city has been found
			}
		}
		
		if (!foundFirst && !foundSecond) //neither city was found
		{
			System.out.println("The first and second city code do not exist!");
		}
		else if (!foundFirst) //the first city wasn't found
		{
			System.out.println("The first city code does not exist!");
		}
		else if (!foundSecond) //the second city wasn't found
		{
			System.out.println("The second city code does not exist!");
		}
		else //they both have been found
		{
			if (data[firstCode-1][secondCode-1] == 0) //the road doesn't yet exist
			{
				data[firstCode-1][secondCode-1] = Integer.parseInt(third); //create the road with the given distance
				
				System.out.println("You have inserted a road from " + firstCityName + " to " + secondCityName + " with a distance of " + third + ".");
			}
			else //the road already exists
			{
				System.out.println("There already exists a road from " + firstCityName + " to " + secondCityName + "!");
			}
		}
	}
	
	/**
		Removes the road between the given city codes.
		
		@param first The first city code.
		@param second The second city code.
	*/
	public void remove(String first, String second)
	{	
		String firstCityName = null; //the first city name
		String secondCityName = null; //the second city name
		boolean foundFirst = false; //the first city is initially not found
		boolean foundSecond = false; //the second city is initially not found
		int firstCode = 0; //the first city's code, range 1-20
		int secondCode = 0; //the second city's code, range 1-20
		
		for (int row = 0; row < array.length; row++) //scan each row of the array
		{
			if (array[row][1].equals(first)) //the first city code matches the array's city code
			{
				firstCode = Integer.parseInt(array[row][0]); //save the first city code
				firstCityName = array[row][2]; //save the first city name
				foundFirst = true; //the first city has been found
			}
			else if (array[row][1].equals(second)) //the second city code matches the array's city code
			{
				secondCode = Integer.parseInt(array[row][0]); //save the second city code
				secondCityName = array[row][2]; //save the second city name
				foundSecond = true; //the second city has been found
			}
		}
		
		if (!foundFirst && !foundSecond) //neither city was found
		{
			System.out.println("The first and second city code do not exist!");
		}
		else if (!foundFirst) //the first city wasn't found
		{
			System.out.println("The first city code does not exist!");
		}
		else if (!foundSecond) //the second city wasn't found
		{
			System.out.println("The second city code does not exist!");
		}
		else //they both have been found
		{
			if (data[firstCode-1][secondCode-1] == 0) //the road doesn't exist between these cities
			{	
				System.out.println("The road from " + firstCityName + " to " + secondCityName + " doesn't exist.");
			}
			else //the road exists between these cities
			{
				data[firstCode-1][secondCode-1] = 0; //remove the road
				System.out.println("The road from " + firstCityName + " to " + secondCityName + " has been removed.");
			}
		}
	}
}