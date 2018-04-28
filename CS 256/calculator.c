/**
	Calculates the area of a circle, rectange, and triangle.
	
	Author: Kendall Haworth
*/

#include <stdio.h>
#include <math.h>

int main()
{
	//declare all variables
	int input;
	double radius;
	double length;
	double width;
	double area;
	double base;
	double height;

	do
	{
		//display the menu
		printf("Geometry Calculator\n\n");
		printf("\t1. Calculate the Area of a Circle\n");
		printf("\t2. Calculate the Area of a Rectangle\n");
		printf("\t3. Calculate the Area of a Triangle\n");
		printf("\t4. Quit\n\n");
		printf("\tEnter your choice (1-4): ");
		scanf("%d", &input);
		
		switch (input)
		{
			case 1:
				do
				{
					printf("Enter the radius of the circle: ");
					scanf("%lf", &radius);
					
					if (radius < 0)
					{
						printf("The radius must not be negative!\n");
					}
				}
				while(radius < 0);
				
				area = M_PI*pow(radius, 2);
				printf("The area of the circle is %lf\n\n", area);
				break;
				
			case 2:
				do
				{
					printf("Enter the length of the rectange: ");
					scanf("%lf", &length);
					
					if (length < 0)
					{
						printf("The length must not be negative!\n");
					}
				}
				while(length < 0);
				
				do
				{
					printf("Enter the width of the rectangle: ");
					scanf("%lf", &width);
					
					if (width < 0)
					{
						printf("The width must not be negative!\n");
					}
				}
				while(width < 0);
				
				area = length * width;
				printf("The area of the rectangle is %lf\n\n", area);
				break;
				
			case 3:
				do
				{
					printf("Enter the length of the triangle's base: ");
					scanf("%lf", &base);
					
					if (base < 0)
					{
						printf("The base must not be negative!\n");
					}
				}
				while(base < 0);
				
				do
				{
					printf("Enter the height of the triangle: ");
					scanf("%lf", &height);
					
					if (height < 0)
					{
						printf("The height must not be negative!\n");
					}
				}
				while(height < 0);
				
				area = base * height * .5;
				printf("The area of the triangle is %lf\n\n", area);
				break;
				
			case 4:
				break;
				
			default:
				printf("Please enter a valid number from 1 to 4.\n\n");
				break;
		} //end switch
	} //end loop
	while (input != 4); //quit once the user inputs 4
	
	return 0;
}