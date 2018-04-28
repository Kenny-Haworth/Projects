/**
	A program that simulates a seating chart for a small theater.
	
	Note:	The instructions weren't clear about labeling the columns.
			In the example they were labeled 0-9 three times, leaving duplicate
			seats. So when asking the user what column seat they want, I additionally
			ask what of the three seats they are referring to of that number.
	
	Author: Kendall Haworth
*/

#include <stdio.h>

//global variables
int rows = 15;
int columns = 30;

//function declaration
void print(char array[rows][columns]);

int main()
{
	//creating the seating chart and the prices array
	char array[rows][columns];
	double prices[rows];
	
	//initialize the seating chart
	for (int i = 0; i < rows; i++)
	{
		for (int q = 0; q < columns; q++)
		{
			array[i][q] = '#';
		}
	}
	
	//enter the prices for each row
	for (int i = 0; i < rows; i++)
	{
		printf("Enter the seat prices for row %i: ", i+1);
		scanf("%lf", &prices[i]);
	}
	
	//declare variables outside the program loop
	int loop = 0;
	int input;
	int r;
	int c;
	int number;
	double total = 0;
	int seatCounter = 0;
	double overallTotal = 0;
	
	while (loop == 0)
	{
		print(array);
		
		//display the menu
		printf("What would you like to do?\n");
		printf("\t1. Purchase a ticket\n");
		printf("\t2. See how many seats have been sold\n");
		printf("\t3. See how many seats are available in each row\n");
		printf("\t4. See how many seats are available in the entire auditorium\n");
		printf("\t5. View the total of all ticket sales\n");
		printf("\t6. Quit\n\n");
		printf("Enter your choice (1-6): ");
		scanf("%d", &input);
		
		switch (input)
		{
			case 1:
				do
				{
					do
					{
						printf("Enter a row number to buy a seat (1-15): ");
						scanf("%i", &r);
						
						if (r < 1 || r > 15)
						{
							printf("You must enter a valid number 1-15.\n");
						}
					}
					while (r < 1 || r > 15);
					
					do
					{
						printf("Enter a column number to buy a seat (0-9): ");
						scanf("%i", &c);
						
						if (c < 0 || c > 9)
						{
							printf("You must enter a valid number 0-9.\n");
						}
					}
					while (c < 0 || c > 9);
					
					do
					{
						printf("Which column %i", c);
						printf(" would you like to select? The first, second, or third? (1-3): ");
						scanf("%i", &number);
						
						if (number < 1 || number > 3)
						{
							printf("You must enter a valid number 1-3.\n");
						}
					}
					while (number < 1 || number > 3);
					
					if (array[r-1][c + ((number-1)*10)] == '#') //the seat is available
					{
						printf("This ticket will cost $%.2lf. Is this okay (1 for yes, 0 for no)? ", prices[r-1]);
						scanf("%i", &input);
						
						if (input == 0) //don't purchase this seat
						{
							break;
						}
						else //input == 1, purchase the seat
						{
							array[r-1][c + ((number-1)*10)] = '*';
							total += prices[r-1];
							overallTotal += prices[r-1];
							printf("You have purchased this seat! Your current bill is %.2lf. Would you like to buy another ticket(1 for yes, 0 for no)? ", total);
							scanf("%i", &input);
						}
					}
					else //the seat has already been sold
					{
						printf("That seat has already been sold!\n");
					}
				}
				while (input == 1);
				total = 0;
				
				break;
				
			case 2:
				printf("\nNumber of seats that have been sold: ");
				for (int r = 0; r < rows; r++)
				{
					for (int c = 0; c < columns; c++)
					{	
						if (array[r][c] == '*')
						{
							seatCounter++;
						}
					}
				}
				printf("%i\n", seatCounter);
				seatCounter = 0;
				break;
				
			case 3:
				printf("\nNumber of seats available in each row:\n\n");
				
				for (int r = 0; r < rows; r++)
				{
					for (int c = 0; c < columns; c++)
					{
						if (c == 0 && r < 9)
						{
							printf("Row %i:  ", r+1);
						}
						else if (c == 0 && r >= 9)
						{
							printf("Row %i: ", r+1);
						}
						
						if (array[r][c] == '#')
						{
							seatCounter++;
						}
					}
					printf("%i\n", seatCounter);
					seatCounter = 0;
				}
				
				break;
				
			case 4:
				printf("\nNumber of seats available in the entire auditorium: ");
				
				for (int r = 0; r < rows; r++)
				{
					for (int c = 0; c < columns; c++)
					{	
						if (array[r][c] == '#')
						{
							seatCounter++;
						}
					}
				}
				
				printf("%i\n", seatCounter);
				seatCounter = 0;
				break;
				
			case 5:
				printf("\nTotal of all ticket sales: $%.2lf\n", overallTotal);
				break;
				
			case 6:
				loop = 1;
				break;
				
			default:
				printf("\nPlease enter a valid number from 1 to 6.\n");
				break;
		} //end switch
	}//end while loop
	
	return 0;
}

//prints the theater seating chart
void print(char array[rows][columns])
{
	printf("\n                     Seats\n");
	printf("        012345678901234567890123456789\n");
	
	for (int r = 0; r < rows; r++)
	{
		for (int c = 0; c < columns; c++)
		{
			if (c == 0)
			{
				printf("Row %i\t", r+1);
			}
			printf("%c", array[r][c]);
		}
		printf("\n");
	}
	printf("\n");
}