/**
	@author Kendall Haworth
	
	A Game of 21 programming challenge for hw #3
*/

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>
using namespace std;

//Die class to simulate the rolling of a die
class Die
{
	private:
		int value;
		static int sides;
	
	public:
		Die();
		void roll();
		int getValue();
};

int Die::sides = 6;

Die::Die()
{
	unsigned seed = time(0);
	srand(seed);
	roll();
}

void Die::roll()
{
	const int minValue = 1;
	value = (rand() % (sides - minValue + 1)) + minValue;
}

int Die::getValue()
{
	return value;
}

int main()
{
	//each player gets 2 dice
	Die player1;
	Die player2;
	Die cp1;
	Die cp2;
	bool loop = true;
	bool playerTotalOver = false;
	int playerTotal = 0;
	int cpTotal = 0;
	string input;
	
	do
	{
		do
		{
			cout << "Rolling the dice..." << endl;
			
			player1.roll();
			player2.roll();
			cp1.roll();
			cp2.roll();
			
			playerTotal += (player1.getValue() + player2.getValue());
			cpTotal += (cp1.getValue() + cp2.getValue());
			
			//the player can continue to roll as long as they are under 21
			if (playerTotal <= 21)
			{
				cout << "Your total is " << playerTotal << ". Would you like to roll again? (y for yes) ";
				cin >> input;
			}
			else //the player is over 21
			{
				cout << "Your total is " << playerTotal << "." << endl;
				playerTotalOver = true;
			}
		}
		while(input == "y" && !playerTotalOver);
		
		cout << "Your total was " << playerTotal << ". The computer's total was " << cpTotal << "." << endl;
		
		if (playerTotal > 21 && cpTotal > 21) //both went over 21 and lost
		{
			cout << "You both lose!" << endl;
		}
		else if (playerTotal > 21 && cpTotal <= 21) //the player went over 21 and lost
		{
			cout << "The computer wins!" << endl;
		}
		else if (cpTotal > 21 && playerTotal <= 21) //the computer went over 21 and lost
		{
			cout << "You win!" << endl;
		}
		else if (playerTotal > cpTotal) //the player got more points than the computer and won
		{
			cout << "You win!" << endl;
		}
		else if (playerTotal < cpTotal) //the computer got more points than the player and won
		{
			cout << "You lose!" << endl;
		}
		else if (cpTotal == playerTotal) //the player and computer tied
		{
			cout << "Tie game!" << endl;
		}
		
		cout << "Would you like to play again? (y for yes) ";
		cin >> input;
		
		if (input != "y")
		{
			loop = false; //exit the proram
		}
		else
		{
			//reset the loop variables
			cpTotal = 0;
			playerTotal = 0;
			playerTotalOver = false;
		}
	}
	while(loop);
	
	return 0;
}