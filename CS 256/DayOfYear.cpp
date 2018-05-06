/**
	@author Kendall Haworth

	Programming challenge 2, Day of the Year
*/

#include <iostream>
#include <string>
#include <stdio.h>
using namespace std;

class DayOfYear
{
	private:
		int day;
		static string Jan;
		static string Feb;
		static string Mar;
		static string Apr;
		static string May;
		static string June;
		static string July;
		static string Aug;
		static string Sep;
		static string Oct;
		static string Nov;
		static string Dec;
	
	public:
		//sets the day of year
		DayOfYear(int number);
		
		//prints the month and year
		void print();
};

//initialize static variables outside the class
string DayOfYear::Jan = "January";
string DayOfYear::Feb = "February";
string DayOfYear::Mar = "March";
string DayOfYear::Apr = "April";
string DayOfYear::May = "May";
string DayOfYear::June = "June";
string DayOfYear::July = "July";
string DayOfYear::Aug = "August";
string DayOfYear::Sep = "September";
string DayOfYear::Oct = "October";
string DayOfYear::Nov = "November";
string DayOfYear::Dec = "December";


DayOfYear::DayOfYear(int number)
{
	day = number;
}

void DayOfYear::print()
{
	if (day < 31)
	{
		cout << Jan << " " << day << endl;
	}
	else if (day > 31 && day < 60)
	{
		cout << Feb << " " << day-31 << endl;
	}
	else if (day > 59 && day < 91)
	{
		cout << Mar << " " << day-59 << endl;
	}
	else if (day > 90 && day < 121)
	{
		cout << Apr << " " << day-90 << endl;
	}
	else if (day > 120 && day < 152)
	{
		cout << May << " " << day-120 << endl;
	}
	else if (day > 151 && day < 182)
	{
		cout << June << " " << day-151 << endl;
	}
	else if (day > 181 && day < 213)
	{
		cout << July << " " << day-181 << endl;
	}
	else if (day > 212 && day < 244)
	{
		cout << Aug << " " << day-212 << endl;
	}
	else if (day > 243 && day < 274)
	{
		cout << Sep << " " << day-243 << endl;
	}
	else if (day > 273 && day < 305)
	{
		cout << Oct << " " << day-273 << endl;
	}
	else if (day > 304 && day < 335)
	{
		cout << Nov << " " << day-304 << endl;
	}
	else if (day > 334)
	{
		cout << Dec << " " << day-334 << endl;
	}
}

int main()
{
	int day;
	int i = 0;
	
	while (i == 0)
	{
		cout << "Enter a number for the day (-1 to quit): " << endl;
		cin >> day;
		
		if (day == -1)
		{
			i = 1;
		}
		else
		{
			DayOfYear test(day);
			cout << "The entered day is ";
			test.print();
		}
	}
	
	return 0;
}