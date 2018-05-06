/**
	@author Kendall Haworth

	Programming challenge 2, Day of the Year Modification
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
		
		//returns the day of the given month and number
		int getDate(string mon, int number);
		
		void setDay(int number)
		{
			day = number;
		}
	
	public:
		//original constructor
		DayOfYear(int number);
		
		//secondary constructor with month
		DayOfYear(string mon, int day);
		void print();
		
		//prefix increment operator
		void operator++()
		{
			day++;
			
			if (day > 365)
			{
				day = 1;
			}
		}
		
		//postfix increment operator
		void operator++(int)
		{
			day++;
			
			if (day > 365)
			{
				day = 1;
			}
		}
		
		//prefix decrement operator
		void operator--()
		{
			day--;
			
			if (day < 1)
			{
				day = 365;
			}
		}
		
		//postfix decrement operator
		void operator--(int)
		{
			day--;
			
			if (day < 1)
			{
				day = 365;
			}
		}
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

//secondary constructor to set the day
DayOfYear::DayOfYear(string mon, int number)
{
	int day = getDate(mon, number);
	setDay(day);
}

//sets the day based on the given month and number
int DayOfYear::getDate(string mon, int number)
{
	if (mon == "January")
	{
		if (number > 0 && number < 32)
		{
			return number;
		}
		else //the day is outside the acceptable range
		{
			return 0;
		}
	}
	else if (mon == "February")
	{
		if (number > 0 && number < 29)
		{
			return number + 31;
		}
		else
		{
			return 0;
		}
	}
	else if (mon == "March")
	{
		if (number > 0 && number < 32)
		{
			return number + 59;
		}
		else
		{
			return 0;
		}
	}
	else if (mon == "April")
	{
		if (number > 0 && number < 31)
		{
			return number + 90;
		}
		else
		{
			return 0;
		}
	}
	else if (mon == "May")
	{
		if (number > 0 && number < 32)
		{
			return number + 120;
		}
		else
		{
			return 0;
		}
	}
	else if (mon == "June")
	{
		if (number > 0 && number < 31)
		{
			return number + 151;
		}
		else
		{
			return 0;
		}
	}
	else if (mon == "July")
	{
		if (number > 0 && number < 32)
		{
			return number + 181;
		}
		else
		{
			return 0;
		}
	}
	else if (mon == "August")
	{
		if (number > 0 && number < 32)
		{
			return number + 212;
		}
		else
		{
			return 0;
		}
	}
	else if (mon == "September")
	{
		if (number > 0 && number < 31)
		{
			return number + 243;
		}
		else
		{
			return 0;
		}
	}
	else if (mon == "October")
	{
		if (number > 0 && number < 32)
		{
			return number + 273;
		}
		else
		{
			return 0;
		}
	}
	else if (mon == "November")
	{
		if (number > 0 && number < 31)
		{
			return number + 304;
		}
		else
		{
			return 0;
		}
	}
	else if (mon == "December")
	{
		if (number > 0 && number < 32)
		{
			return number + 334;
		}
		else
		{
			return 0;
		}
	}
	else //month could not be found
	{
		return -1;
	}
}

//prints the month and day of the year. Also gives an error and terminates the program if the month or day didn't exist.
void DayOfYear::print()
{
	if (day < 0)
	{
		cout << "ERROR. This month does not exist!" << endl;
		exit(0);
	}
	else if (day == 0)
	{
		cout << "ERROR. An incorrect day was entered for this month!" << endl;
		exit(0);
	}
	else if (day <= 31)
	{
		cout << Jan << " " << day << "." << endl;
	}
	else if (day > 31 && day < 60)
	{
		cout << Feb << " " << day-31 << "." << endl;
	}
	else if (day > 59 && day < 91)
	{
		cout << Mar << " " << day-59 << "." << endl;
	}
	else if (day > 90 && day < 121)
	{
		cout << Apr << " " << day-90 << "." << endl;
	}
	else if (day > 120 && day < 152)
	{
		cout << May << " " << day-120 << "." << endl;
	}
	else if (day > 151 && day < 182)
	{
		cout << June << " " << day-151 << "." << endl;
	}
	else if (day > 181 && day < 213)
	{
		cout << July << " " << day-181 << "." << endl;
	}
	else if (day > 212 && day < 244)
	{
		cout << Aug << " " << day-212 << "." << endl;
	}
	else if (day > 243 && day < 274)
	{
		cout << Sep << " " << day-243 << "." << endl;
	}
	else if (day > 273 && day < 305)
	{
		cout << Oct << " " << day-273 << "." << endl;
	}
	else if (day > 304 && day < 335)
	{
		cout << Nov << " " << day-304 << "." << endl;
	}
	else if (day > 334)
	{
		cout << Dec << " " << day-334 << "." << endl;
	}
}

int main()
{
	int day;
	string month;
	int i = 0;

	while (i == 0)
	{
		cout << "Enter a month (capitalize the first letter): ";
		cin >> month;
		
		cout << "Enter a number for the day of this month (-1 to quit): ";
		cin >> day;
		
		if (day == -1)
		{
			i = 1;
		}
		else
		{
			DayOfYear test(month, day);
			cout << "The entered month and day is ";
			test.print();
			cout << "\n";
			
			cout << "I will now increment your day with PREfix. The next day will be ";
			++test;
			test.print();
			cout << "\n";
			
			cout<< "I will now incrememnt your day with POSTfix. The next day will be ";
			test++;
			test.print();
			cout << "\n";
			
			cout<< "The original day was ";
			DayOfYear test1(month, day);
			test1.print();
			cout << "\n";
			
			cout<< "I will now decrement your day with POSTfix. The previous day was ";
			--test1;
			test1.print();
			cout << "\n";
			
			cout<< "I will now decrement your day with POSTfix. The previous day was ";
			test1--;
			test1.print();
			cout << "\n";
		}
	}
	
	return 0;
}