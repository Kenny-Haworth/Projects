// ConsoleApplication5.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
using namespace std;

template <class T>
T square(T number)
{
	return number * number;
}

int main()
{
	int userInt;
	double userDouble;

	cout << "Enter an int and a floating point value:";
	cin >> userInt >> userDouble;
	cout << "Here are their squares:";
	cout << square(userInt) << " and " << square(userDouble) << endl;

	return 0;
}