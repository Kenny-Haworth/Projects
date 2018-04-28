/**
	Allows two players to play a game of tic-tac-toe.
	
	Author: Kendall Haworth
*/

#include <stdio.h>

//function declaration
void print(char array[3][3]);

//global variables
int arraySize = 3;

int main()
{
	//create and initialize the game board
	char array[arraySize][arraySize];
	
	for (int i = 0; i < arraySize; i++)
	{
		for (int q = 0; q < arraySize; q++)
		{
			array[i][q] = '*';
		}
	}
	
	int gameOver = 0;
	int currentPlayer = 2;
	
	//loop until the game ends
	while (gameOver == 0)
	{
		//print the game board
		print(array);

		int column;
		int row;
		
		//every turn a different player gets to go
		if (currentPlayer % 2 == 0)
		{
			do
			{
				printf("Player 1, enter a row: ");
				scanf("%d", &row);
				
				if (row < 1 || row > 3)
				{
					printf("You can only insert 1, 2, or 3!\n");
				}
			}
			while (row < 1 || row > 3);
			
			do
			{
				printf("Enter a column: ");
				scanf("%d", &column);
				
				if (column < 1 || column > 3)
				{
					printf("You can only insert 1, 2, or 3!\n");
				}
			}
			while (column < 1 || column > 3);
			
			array[row-1][column-1] = 'X';
		}
		else
		{
			do
			{
				printf("Player 2, enter a row: ");
				scanf("%d", &row);
				
				if (row < 1 || row > 3)
				{
					printf("You can only insert 1, 2, or 3!\n");
				}
			}
			while (row < 1 || row > 3);
			
			do
			{
				printf("Enter a column: ");
				scanf("%d", &column);
				
				if (column < 1 || column > 3)
				{
					printf("You can only insert 1, 2, or 3!\n");
				}
			}
			while (column < 1 || column > 3);
			
			array[row-1][column-1] = 'O';
		}
		printf("\n");
		currentPlayer++;
		
		//8 total ways to win, 3 columns, 3 rows, and 2 diagonals
		if (array[0][0] == 'X' && array[0][1] == 'X' && array[0][2] == 'X' ||
			array[1][0] == 'X' && array[1][1] == 'X' && array[1][2] == 'X' ||
			array[2][0] == 'X' && array[2][1] == 'X' && array[2][2] == 'X' ||
			array[0][0] == 'X' && array[1][0] == 'X' && array[2][0] == 'X' ||
			array[0][1] == 'X' && array[1][1] == 'X' && array[2][1] == 'X' ||
			array[0][2] == 'X' && array[1][2] == 'X' && array[2][2] == 'X' ||
			array[0][0] == 'X' && array[1][1] == 'X' && array[2][2] == 'X' ||
			array[0][2] == 'X' && array[1][1] == 'X' && array[2][0] == 'X')
			{
				printf("PLAYER 1 WINS!\n");
				print(array);
				gameOver = 1;
			}
		
		//player 2 wins
		if (array[0][0] == 'O' && array[0][1] == 'O' && array[0][2] == 'O' ||
			array[1][0] == 'O' && array[1][1] == 'O' && array[1][2] == 'O' ||
			array[2][0] == 'O' && array[2][1] == 'O' && array[2][2] == 'O' ||
			array[0][0] == 'O' && array[1][0] == 'O' && array[2][0] == 'O' ||
			array[0][1] == 'O' && array[1][1] == 'O' && array[2][1] == 'O' ||
			array[0][2] == 'O' && array[1][2] == 'O' && array[2][2] == 'O' ||
			array[0][0] == 'O' && array[1][1] == 'O' && array[2][2] == 'O' ||
			array[0][2] == 'O' && array[1][1] == 'O' && array[2][0] == 'O')
			{
				printf("PLAYER 2 WINS!\n");
				print(array);
				gameOver = 1;
			}

		int tieGame = 1;
		
		//the game is a tie if all the positions are filled on the board with no 3-in-a-rows
		for (int i = 0; i < arraySize; i++)
		{
			for (int q = 0; q < arraySize; q++)
			{
				if (array[i][q] == '*')
				{
					tieGame = 0;
				}
			}
		}
		
		if (tieGame == 1)
		{
			printf("TIE GAME!\n");
			print(array);
			gameOver = 1;
		}
	}//end while loop
	
	return 0;
}

/**
	Prints the game board
*/
void print(char array[3][3])
{
	printf("   1 2 3 <--- column\n");
		
	for (int i = 0; i < arraySize; i++)
	{
		for (int q = 0; q < arraySize; q++)
		{
			if (i == 0 && q == 0)
			{
				printf(" 1 ");
			}
			else if (i == 1 && q == 0)
			{
				printf(" 2 ");
			}
			else if (i == 2 && q == 0)
			{
				printf(" 3 ");
			}
			
			printf("%c", array[i][q]);
			printf(" ");
		}
		printf("\n");
	}

	printf(" ^\n");
	printf("row\n");
}