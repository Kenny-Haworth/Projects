/**
	Kendall Haworth, CS 256 Final
*/

#include <iostream>
#include <cstdlib>
#include <vector>
using namespace std;

class animal;
class tiger;
class penguin;
class polarBear;

class Zoo
{
	private:
		int money;
		
	public:
		void buyTiger()
		{
			money -= 10000;
		}
		
		void buyPolarBear()
		{
			money -= 5000;
		}
		
		void buyPenguin()
		{
			money -= 1000;
		}
	
		Zoo()
		{
			money = 100000; //begin with $100,000
		}
		
		int balance()
		{
			return money;
		}
		
		void subtractFunds(int cost)
		{
			money -= cost;
		}
		
		void addFunds(int amount)
		{
			money += amount;
		}
};

class animal
{
	private:
		const int averageFoodCost = 250;
	
	protected:
		int age;
		int numBabies;
		
	public:
		void incrementAge()
		{
			age++;
		}
		
		int payTigerCost()
		{
			return averageFoodCost*5;
		}
		
		int payPolarBearCost()
		{
			return averageFoodCost*3;
		}
		
		int payPenguinCost()
		{
			return averageFoodCost;
		}
		
		int getAge()
		{
			return age;
		}
		
		int getNumBabies()
		{
			return numBabies;
		}
};

class tiger : public animal
{
	public:
		tiger()
		{
			numBabies = 1;
			age = 3;
		}
		
		tiger(int newAge)
		{
			numBabies = 1;
			age = newAge;
		}
};

class polarBear : public animal
{
	public:
		polarBear()
		{
			numBabies = 2;
			age = 3;
		}
		
		polarBear(int newAge)
		{
			numBabies = 2;
			age = newAge;
		}
};

class penguin : public animal
{
	public:
		penguin()
		{
			numBabies = 3;
			age = 3;
		}
		
		penguin(int newAge)
		{
			numBabies = 3;
			age = newAge;
		}
};

int main()
{
	vector<tiger> allTigers; //this vector can hold unlimited tiger objects
	vector<polarBear> allPolarBears; //this vector can hold unlimited tiger objects
	vector<penguin> allPenguins; //this vector can hold unlimited tiger objects
	
	int amount;
	
	cout << "Welcome to Zoo Tycoon!" << endl;
	cout << "We will now create your zoo!" << endl;
	
	Zoo park;
	
	cout << "To begin, you may buy either one or two of each type of animal!" << endl;
	cout << "Your zoo can hold tigers, polar bears, and penguins." << endl;
	
	cout << "Your current balance is $" << park.balance() << "." << endl;
	do
	{
		cout << "Tigers cost $10,000. How many tigers would you like? (1-2)" << endl;
		cin >> amount;
		
		if (amount != 1 && amount != 2)
		{
			cout << "Please only enter 1 or 2!" << endl;
		}
	}
	while (amount != 1 && amount != 2);
	
	for (int i = 0; i < amount; i++)
	{
		tiger tig;
		allTigers.push_back(tig);
		park.buyTiger();
	}
	
	cout << "Your current balance is $" << park.balance() << "." << endl;
	do
	{
		cout << "Polar bears cost $5,000. How many polar bears would you like? (1-2)" << endl;
		cin >> amount;
		
		if (amount != 1 && amount != 2)
		{
			cout << "Please only enter 1 or 2!" << endl;
		}
	}
	while (amount != 1 && amount != 2);
	
	for (int i = 0; i < amount; i++)
	{
		polarBear polar;
		allPolarBears.push_back(polar);
		park.buyPolarBear();
	}
	
	cout << "Your current balance is now $" << park.balance() << "." << endl;
	do
	{
		cout << "Penguins cost $1,000. How many penguins would you like? (1-2)" << endl;
		cin >> amount;
		
		if (amount != 1 && amount != 2)
		{
			cout << "Please only enter 1 or 2!" << endl;
		}
	}
	while (amount != 1 && amount != 2);
	
	for (int i = 0; i < amount; i++)
	{
		penguin peng;
		allPenguins.push_back(peng);
		park.buyPenguin();
	}
	cout << "Your current balance is now $" << park.balance() << "." << endl;
	
	bool gameOver = false;
	
	while (!gameOver)
	{
		cout << "Each animal will now grow one day older." << endl;
		
		for (int i = 0; i < int(allTigers.size()); i++)
		{
			allTigers[i].incrementAge();
		}
		
		for (int i = 0; i < int(allPolarBears.size()); i++)
		{
			allPolarBears[i].incrementAge();
		}
		
		for (int i = 0; i < int(allPenguins.size()); i++)
		{
			allPenguins[i].incrementAge();
		}
		
		cout << "You will now pay the total feeding cost of each of your animals." << endl;
		
		for (int i = 0; i < int(allTigers.size()); i++)
		{
			if (allTigers[i].getAge() < 3) //if the animal is a baby, pay double the cost
			{
				park.subtractFunds(allTigers[i].payTigerCost() * 2);
			}
			park.subtractFunds(allTigers[i].payTigerCost()); //otherwise pay the normal cost
		}
		
		for (int i = 0; i < int(allPolarBears.size()); i++)
		{
			if (allPolarBears[i].getAge() < 3) //if the animal is a baby, pay double the cost
			{
				park.subtractFunds(allPolarBears[i].payPolarBearCost() * 2);
			}
			park.subtractFunds(allPolarBears[i].payPolarBearCost());
		}
		
		for (int i = 0; i < int(allPenguins.size()); i++)
		{
			if (allPenguins[i].getAge() < 3) //if the animal is a baby, pay double the cost
			{
				park.subtractFunds(allPenguins[i].payPenguinCost() * 2);
			}
			park.subtractFunds(allPenguins[i].payPenguinCost());
		}
		
		cout << "Your current balance is now $" << park.balance() << "." << endl;
		cout << endl;
		
		int randomizedEvent = rand() % 4 + 1; //1 to 4 randomly generated
		bool bonusEarned = false;
		int bonus = 0;
		
		if (randomizedEvent == 1)
		{
			cout << "A sickness has occurred in your zoo!" << endl;
			
			do
			{
				cout << "An animal must die! Which animal will die?" << endl;
				cout << "\t1) Tiger" << endl;
				cout << "\t2) Polar Bear" << endl;
				cout << "\t3) Penguin" << endl;
				cout << "Enter a choice 1-3: ";
				cin >> amount;
				
				if (amount != 1 && amount != 2 && amount != 3)
				{
					cout << "Please only enter 1, 2, or 3!" << endl;
				}
				
				if (amount == 1 && int(allTigers.size()) == 0)
				{
					cout << "You have no tigers to kill off! Choose another animal to have die!" << endl;
				}
				
				if (amount == 2 && int(allPolarBears.size()) == 0)
				{
					cout << "You have no polar bears to kill off! Choose another animal to have die!" << endl;
				}
				
				if (amount == 2 && int(allPenguins.size()) == 0)
				{
					cout << "You have no penguins to kill off! Choose another animal to have die!" << endl;
				}
			}
			while (amount != 1 && amount != 2 && amount != 3);
			
			if (amount == 1)
			{
				if (allTigers[int(allTigers.size())-1].getAge() < 3) //the animal at the end of the vector is a baby, charge double
				{
					park.subtractFunds(10000*2); //the cost of a tiger*2
				}
				park.subtractFunds(10000); //the cost of a tiger
				allTigers.resize(int(allTigers.size()) - 1); //using the erase function call didn't work for some reason, so this resizes the vector to the size - 1 and deletes an object
			}
			else if (amount == 2)
			{
				if (allPolarBears[int(allPolarBears.size())-1].getAge() < 3) //the animal at the end of the vector is a baby, charge double
				{
					park.subtractFunds(5000*2); //the cost of a polar bear*2
				}
				park.subtractFunds(5000); //the cost of a polar bear
				allPolarBears.resize(int(allPolarBears.size()) - 1);
			}
			else //amount == 3
			{
				if (allPenguins[int(allPenguins.size())-1].getAge() < 3) //the animal at the end of the vector is a baby, charge double
				{
					park.subtractFunds(1000*2); //the cost of a penguin*2
				}
				park.subtractFunds(1000); //the cost of a penguin
				allPenguins.resize(int(allPenguins.size()) - 1);
			}
		}
		else if (randomizedEvent == 2)
		{
			bonus = rand() % 250 + 250; //generate a bonus between $250-$500
			bonusEarned = true;
			cout << "The people love your tigers! They will earn an extra bonus of $" << bonus << " each today!" << endl; //the bonus is added later
		}
		else if (randomizedEvent == 3)
		{
			cout << "A new baby animal is born today!" << endl;
			
			do
			{
				cout << "Which animal is born?" << endl;
				cout << "\t1) Tiger" << endl;
				cout << "\t2) Polar Bear" << endl;
				cout << "\t3) Penguin" << endl;
				cout << "Enter a choice 1-3: ";
				cin >> amount;
				
				if (amount != 1 && amount != 2 && amount != 3)
				{
					cout << "Please only enter 1, 2, or 3!" << endl;
				}
			}
			while (amount != 1 && amount != 2 && amount != 3);
			
			if (amount == 1)
			{
				cout << "A baby tiger is born!" << endl;
				tiger tig(0);
				allTigers.push_back(tig);
			}
			else if (amount == 2)
			{
				cout << "Two baby polar bears are born!" << endl;
				polarBear bear1(0);
				polarBear bear2(0);
				allPolarBears.push_back(bear1);
				allPolarBears.push_back(bear2);
			}
			else //amount == 3
			{
				cout << "Three baby penguins are born!" << endl;
				penguin penguin1(0);
				penguin penguin2(0);
				penguin penguin3(0);
				allPenguins.push_back(penguin1);
				allPenguins.push_back(penguin2);
				allPenguins.push_back(penguin3);
			}
		}
		else //randomizedEvent == 4
		{
			cout << "Just a regular day at the zoo today." << endl; //nothing happens
		}
		
		cout << "Now adding today's profits..." << endl;
		
		for (int i = 0; i < int(allTigers.size()); i++)
		{
			if (allTigers[i].getAge() < 3) //earn double the profit for babies
			{
				park.addFunds((.1*10000)*2);
			}
			
			park.addFunds(.1*10000); //10% of tiger's cost
		}
		
		for (int i = 0; i < int(allPolarBears.size()); i++)
		{
			if (allPenguins[i].getAge() < 3) //earn double the profit for babies
			{
				park.addFunds((.05*5000)*2);
			}
			park.addFunds(.05*5000); //5% of polar bear's cost
		}
		
		for (int i = 0; i < int(allPenguins.size()); i++)
		{
			if (allPolarBears[i].getAge() < 3) //earn double the profit for babies
			{
				park.addFunds((.05*1000)*2);
			}
			park.addFunds(.05*1000); //5% of penguin's cost
		}
		
		if (bonusEarned) //the tigers earned a bonus today
		{
			for (int i = 0; i < int(allTigers.size()); i++)
			{
				park.addFunds(bonus);
			}
		}
		
		cout << "Your current balance is now $" << park.balance() << "." << endl;
	
		do
		{
			cout << "Would you like to buy an animal at the end of the day?" << endl;
			cout << "\t1) Tiger" << endl;
			cout << "\t2) Polar Bear" << endl;
			cout << "\t3) Penguin" << endl;
			cout << "\t4) No thanks" << endl;
			cout << "Enter a choice 1-4: ";
			cin >> amount;
			
			if (amount != 1 && amount != 2 && amount != 3 && amount != 4)
			{
				cout << "Please only enter 1, 2, 3, or 4!" << endl;
			}
		}
		while (amount != 1 && amount != 2 && amount != 3 && amount != 4);
		
		if (amount == 1)
		{
			cout << "You have bought a new tiger!" << endl;
			tiger tig;
			allTigers.push_back(tig);
			park.buyTiger();
			cout << "Your current balance is now $" << park.balance() << "." << endl;
		}
		else if (amount == 2)
		{
			cout << "You have bought a new polar bear!" << endl;
			polarBear polar;
			allPolarBears.push_back(polar);
			park.buyPolarBear();
			cout << "Your current balance is now $" << park.balance() << "." << endl;
		}
		else if (amount == 3)
		{
			cout << "You have bought a new penguin!" << endl;
			penguin peng;
			allPenguins.push_back(peng);
			park.buyPenguin();
			cout << "Your current balance is now $" << park.balance() << "." << endl;
		}
		
		do
		{
			cout << "Would you like to continue to the next day or end the game?" << endl;
			cout << "\t1) Continue to next day" << endl;
			cout << "\t2) End game" << endl;
			cout << "Enter a choice 1 or 2: ";
			cin >> amount;
			
			if (amount != 1 && amount != 2)
			{
				cout << "Please only enter 1 or 2!" << endl;
			}
		}
		while (amount != 1 && amount != 2);
		
		if (amount == 2)
		{
			cout << "Thanks for playing!" << endl;
			gameOver = true;
		}
		
		if (park.balance() < 0)
		{
			cout << "You've gone bankrupt! Your current balance is $" << park.balance() << "! Game over!" << endl;
			gameOver = true;
		}
		
		cout << endl;
		cout << endl;
	}//end game loop
	
	return 0;
}