/**
	@author Kendall Haworth
	
	Ship, CruiseShip, and CargoShip Classes programming challenge for hw #3
*/

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>
using namespace std;

//forward declaration of classes
class CruiseShip;
class CargoShip;

//base class
class Ship
{
	public:
		Ship(string na, string ye)
		{
			name = na;
			year = ye;
		}
		
		//virtual method because it will be overridden and redefined later in the derived classes
		virtual void print()
		{
			cout << "The ship's name is " << name << " and it was built in " << year << "." << endl;
		}
		
	//protected allows the derived class to access these member variables
	protected:
		string name;
		string year;
		
	//some private setters and getters for Ship
	private:
		void setYear(string ye)
		{
			year = ye;
		}
		
		void setName(string na)
		{
			name = na;
		}
		
		string getName()
		{
			return name;
		}
		
		string getYear()
		{
			return year;
		}
};

//derived class from Ship
class CruiseShip : public Ship
{
	public:
		CruiseShip(int pass, string na, string ye) : Ship(na, ye)
		{
			passengers = pass;
		}
	
		//overridden print method
		void print()
		{
			cout << "The ship's name is " << name << " and it has a maximum passenger carry limit of " << passengers << "." << endl;
		}
	
	private:
		int passengers;
		
		int getPassengers()
		{
			return passengers;
		}
		
		void setPassengers(int pass)
		{
			passengers = pass;
		}
};

//derived class from Ship
class CargoShip : public Ship
{
	public:
		CargoShip(int to, string na, string ye) : Ship(na, ye)
		{
			tons = to;
		}
		
		//overriden print method
		void print()
		{
			cout << "The ship's name is " << name << " and it has a cargo capacity of " << tons << " tons." << endl;
		}
		
	private:
		int tons;
		
		int getTons()
		{
			return tons;
		}
		
		void setTons(int to)
		{
			tons = to;
		}
};

int main()
{
	//creates an array of Ship pointers that are initialized with the addresses of dynamically allocated
	//Ship, CruiseShip, and CargoShip objects. The program steps through the array, calling each object's
	//print function as per instructions
	int numShips = 3;
	Ship* ships[numShips] = { new Ship("Challenger", "1937"), new CruiseShip(250, "Discovery", "1877"), new CargoShip(100, "Intrepid", "1930")};
	
	for (int i = 0; i < numShips; i++)
	{
		ships[i]->print();
	}

	return 0;
}