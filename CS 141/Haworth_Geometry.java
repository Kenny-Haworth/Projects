/***************************************************************
* File: Haworth_Geometry.java
* Author: Kendall Haworth
* Class: CS 141-01 – Intro to Programming and Problem Solving
*
* Assignment: Program 2
* Date last modified: 18/1/17
*
* Purpose: This program calculates the area of a rectange,
* circle, and triangle and is run by another driver program.
* 
****************************************************************/

public class Haworth_Geometry
{
	//Method: calculateCircle
	//Purpose: Calculates the area of a circle with a given radius
	//         and returns -1 if the radius is negative.
	
	public static double calculateCircle (int radius)
	{
		if (radius <= 0)
		{
			System.out.println("Error, radius must be greater than 0.");
			return -1;
		}
		else
		{
			return Math.PI*radius*radius;
		}
	}
	
	//Method: calculateCircle
	//Purpose: Calculates the area of a rectangle with a given length
	//         and width and returns -1 if the values are negative.
	
	public static double calculateRectangle (int length, int width)
	{
		if (length <=0 || width <=0)
		{
			System.out.println("Error, length and width must be greater than 0.");
			return -1;
		}
		else
		{
			return length*width;
		}
	}
	
	//Method: calculateCircle
	//Purpose: Calculates the area of a triangle with a given base
	//         and height and returns -1 if the values are negative.
	
	public static double calculateTriangle (int base, int height)
	{
		if (base <= 0 || height <=0)
		{
			System.out.println("Error, base and height must be greater than 0.");
			return -1;
		}
		else
		{
			return base*height*0.5;
		}
	}
}