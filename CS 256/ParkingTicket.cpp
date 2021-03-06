
#include "stdafx.h"

#include <cstdlib> 
#include<iostream>
#include <string>
using namespace std;

class ParkingMeter;
class ParkingTicket;
class PoliceOfficer;

class ParkedCar
{
private:
	string make;
	string model;
	string liscenseNumber;
	int minutesParked;

public:
	ParkedCar(string ma, string mo, string li, int mi);
	string getMake(ParkingTicket & pTicket);
	string getModel(ParkingTicket & pTicket);
	string getLiscenseNumber(ParkingTicket & pTicket);
	int getMinutes(ParkingMeter& pTicket);

};

ParkedCar::ParkedCar(string ma, string mo, string li, int mi) 
{
	make = ma;
	model = mo;
	liscenseNumber = li;
	minutesParked = mi;
}

class ParkingMeter
{
private:
	int minutes;
public:
	friend int ParkedCar::getMinutes(ParkingMeter& pMeter);
	void setMinutes(int n);
	int getPay(ParkingTicket& pTicket);
};

void ParkingMeter::setMinutes(int n) 
{
	minutes = n;
}

int ParkedCar::getMinutes(ParkingMeter& pMeter)
{ 
	return minutesParked; 
}

class PoliceOfficer
{
private:
	string name;
	string badgeNumber;

public:
	PoliceOfficer(string s, string b);
	string getName(ParkingTicket& pTicket);
	string getBadge(ParkingTicket& pTicket);
};

PoliceOfficer::PoliceOfficer(string s, string b)
{
	name = s;
	badgeNumber = b;
}

class ParkingTicket
{
public:
	friend string ParkedCar::getMake(ParkingTicket & pTicket);
	friend string ParkedCar::getModel(ParkingTicket & pTicket);
	friend string ParkedCar::getLiscenseNumber(ParkingTicket & pTicket);
	friend int ParkingMeter::getPay(ParkingTicket& pMeter);
	friend string PoliceOfficer::getName(ParkingTicket& pTicket);
	friend string PoliceOfficer::getBadge(ParkingTicket& pTicket);
};

string ParkedCar::getMake(ParkingTicket & pTicket) { return make; }
string ParkedCar::getModel(ParkingTicket & pTicket) { return model; }
string ParkedCar::getLiscenseNumber(ParkingTicket & pTicket) { return liscenseNumber; }
string PoliceOfficer::getName(ParkingTicket& pTicket) { return name; }
string PoliceOfficer::getBadge(ParkingTicket& pTicket) { return badgeNumber; }
int ParkingMeter::getPay(ParkingTicket& pMeter)
{
	int hours = minutes;
	int additionalHours = 0;
	int payment = 0;
	if (hours < 120) { payment = 25; }

	else
	{
		hours = hours - 120;
		additionalHours = hours/60;
		if (hours % 60 != 0)
		{
			additionalHours++;
		}
		payment = 25 + (additionalHours * 10);
	}

	return payment;
}




int main()
{
	ParkingMeter meter;
	PoliceOfficer police("John", "37893");
	ParkedCar car("Honda", "Civic", "2FW34QE1", 181);
	ParkingTicket ticket;

	cout << "Car Make: " << car.getMake(ticket) << endl;
	cout << "Car Model: " << car.getModel(ticket) << endl;
	cout << "Car Liscense Number: " << car.getLiscenseNumber(ticket) << endl;
	cout << "Car Time Parked: " << car.getMinutes(meter) << endl;
	cout << "Police name: " << police.getName(ticket) << endl;
	cout << "Police badge: " << police.getBadge(ticket) << endl;

	meter.setMinutes(car.getMinutes(meter));

	cout << "Ticket Price: " << meter.getPay(ticket) << endl;

	return 0;
}