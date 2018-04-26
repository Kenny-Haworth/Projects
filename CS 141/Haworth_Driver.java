/***************************************************************
* File: Haworth_Geometry.java
* Author: Kendall Haworth
* Class: CS 141-01 – Intro to Programming and Problem Solving
*
* Assignment: Program 2
* Date last modified: 18/1/17
*
* Purpose: This program calls the Haworth_Geometry class to calculate
* the area of a circle, rectangle, and triangle.
* 
****************************************************************/

import java.util.Scanner;

public class Haworth_Driver
{
	public static void main(String[] args)
	{
		boolean programRun = true; // Initialized the variable as true to control the while loop.
		
		while (programRun) // Will run as long as programRun is true.
		{
			Scanner keyboard = new Scanner(System.in);
		
			System.out.println("\nGeometry Calculator");				// Displays the main menu to give the user options.
			System.out.println("1. Calculate the Area of a Cirlce");
			System.out.println("2. Calculate the Area of a Rectange");
			System.out.println("3. Calculate the Area of a Triangle");
			System.out.println("4. Quit");
			System.out.println("\nEnter your choice (1-4):");
		
			int input = keyboard.nextInt();
		
			while (!(input == 1 || input == 2 || input == 3 || input == 4)) // Displays an error if 1, 2, 3, or 4 isn't inputted.
			{
				System.out.println("Error, please only enter 1, 2, 3, or 4.");
				System.out.println("Try again: ");
				input = keyboard.nextInt();
			}
		
			if (input == 1) // Calculates the area of a circle and shows it as long as the radius isn't negative.
			{
				System.out.println("Enter the radius of the circle: ");
				int radius = keyboard.nextInt();
				
				double areaCircle = Haworth_Geometry.calculateCircle(radius);
				
				if (areaCircle > 0)
				{
				System.out.println("The area of a circle with radius " + radius + " is " +
									areaCircle + ".");
				}
			}
		
			if (input == 2) // Calculates the area of a rectangle and shows it as long as the length and width aren't negative.
			{
				System.out.println("Enter the length of the rectangle: ");
				int length = keyboard.nextInt();
			
				System.out.println("Enter the width of the rectangle: ");
				int width = keyboard.nextInt();
				
				double areaRectangle = Haworth_Geometry.calculateRectangle(length, width);
				
				if (areaRectangle > 0)
				{
				System.out.println("The area of a rectangle with length " + length + " and width " +
								width + " is " + areaRectangle + ".");
				}
			}
		
			if (input == 3) // Calculates the area of a triangle and shows it as long as the base and height aren't negative.
			{
				System.out.println("Enter the base of the triangle: ");
				int base = keyboard.nextInt();
			
				System.out.println("Enter the height of the triangle: ");
				int height = keyboard.nextInt();
			
				double areaTriangle = Haworth_Geometry.calculateTriangle(base, height);
				
				if(areaTriangle > 0)
				{
				System.out.println("The area of a triangle with base " + base + " and height " +
									height + " is " + areaTriangle + ".");
				}
			}
		
			if (input == 4) // Displays a message and changes the programRun boolean value to false, shutting the program down.
			{
				System.out.println("The system will now shutdown.");
				programRun = false;
			}
		}
	}
}