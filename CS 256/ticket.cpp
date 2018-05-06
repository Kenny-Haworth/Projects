/**
	@author Kendall Haworth
	
	Parking Ticket Simulator programming challenge for hw #3
*/

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>
using namespace std;

//forward class declarations
class ParkingMeter;
class ParkingTicket;
class PoliceOfficer;

class ParkedCar
{
	//the police officer and the parking ticket can view the parked car's info
	friend class PoliceOfficer;
	friend class ParkingTicket;
	
	public:
		ParkedCar(string ma, string mo, string co, string lic, int min) //constructor for parked car
		{
			make = ma;
			model = mo;
			color = co;
			license = lic;
			minutes = min;
		}
		
	private:
		string make;
		string model;
		string color;
		string license;
		int minutes;
};

//////////////////////////////////////////////////////////////////////////////////////////

class ParkingMeter
{
	//the police officer and parking ticket can view the parking meter's info
	friend class PoliceOfficer;
	friend class ParkingTicket;
	
	public:
		ParkingMeter (int ti)
		{
			time = ti;
		}
		
	private:
		int time;
};

//////////////////////////////////////////////////////////////////////////////////////////

class PoliceOfficer
{
	public:
		PoliceOfficer(string na, int badge)
		{
			name = na;
			badgeNumber = badge;
		}
		
		bool examine(ParkedCar c, ParkingMeter p);
		ParkingTicket createTicket(ParkedCar c, ParkingMeter p);
		
	private:
		string name;
		int badgeNumber;
};

//the police officer will look at both the time the car has been sitting and how
//much the parking meter has been payed for and will determine if a ticket needs written or not
bool PoliceOfficer::examine(ParkedCar c, ParkingMeter p)
{
	if (c.minutes > p.time)
	{
		return true;
	}
	return false;
}

//////////////////////////////////////////////////////////////////////////////////////////

class ParkingTicket
{
	public:
		ParkingTicket(string name, int badgeNumber, ParkedCar c, ParkingMeter p);
		
	private:
		int fine;
};

//A ticket is being written at this point.
//The amount of money to be fined will be determined and outputted.
ParkingTicket::ParkingTicket(string name, int badgeNumber, ParkedCar c, ParkingMeter p)
{
	int timeOver = (c.minutes - p.time);
	
	//fine is $25 for the first hour
	int amount = 25;
	timeOver -= 60;
	
	//each hour or part of an hour over is another 10 bucks. Sucks.
	while(timeOver > 0)
	{
		amount += 10;
		timeOver -= 60;
	}
	
	fine = amount;
	
	cout << "The " << c.color << " " << c.make << " " << c.model << " with license number " << c.license << " is to be fined $" << fine << "." << endl;
	cout << "Officer " << name << " will be issuing the ticket. His badge number is " << badgeNumber << "." << endl;
}

//The police officer must write the ticket.
ParkingTicket PoliceOfficer::createTicket(ParkedCar c, ParkingMeter p)
{
	ParkingTicket ticket(name, badgeNumber, c, p);
	return ticket;
}

//////////////////////////////////////////////////////////////////////////////////////////

int main()
{
	cout << "This program is designed with user input for the time " << endl;
	cout << "the car has been parked and the time the parking meter has payed for." << endl;
	cout << "Other variables have been initialized automatically for demonstration purposes.\n" << endl;
	
	bool loop = true;
	int parked;
	int timePayed;
	while (loop)
	{
		cout << "Input the amount of time the car has been parked: ";
		cin >> parked;
		
		cout << "Input the amount of time that has been payed for in the parking meter: ";
		cin >> timePayed;
		
		ParkedCar car("Toyota", "Prius", "black", "A352BMD", parked);
		ParkingMeter meter(timePayed);
		PoliceOfficer officer("Joshua", 3162);
		
		cout << endl;
		cout << "Oh no! A police officer is coming to examine the car!!! What will he do?!" << endl;
		
		if (officer.examine(car, meter))
		{
			ParkingTicket ticket = officer.createTicket(car, meter);
		}
		else
		{
			cout << "The officer declares, \"All is well, no ticket needs to be assigned.\"" << endl;
			cout << "Phew!" << endl;
		}
		
		string input;
		cout << endl;
		cout << "Play again? (y for yes) ";
		cin >> input;
		
		if (input != "y")
		{
			if (input != "yes")
			{
				loop = false;
			}
		}
	}
	
	return 0;
}