#include "stdafx.h"
#include <string>
#include <iostream>
using namespace std;

class Circle
{
	private:
		double radius;
		double pi = 3.14159;
	
	public:
		Circle();
		Circle(double rad);
	
		//setters (accessors)
		void setRadius(double rad);
	
		//getters (mutators)
		double getRadius();
		double getArea();
		double getDiameter();
		double getCircumference();
};

Circle::Circle()
{
	radius = 0.0;
}

Circle::Circle(double rad)
{
	radius = rad;
}

void Circle::setRadius(double rad)
{
	radius = rad;
}

double Circle::getRadius()
{
	return radius;
}

double Circle::getArea()
{
	return pi * radius*radius;
}

double Circle::getDiameter()
{
	return radius * 2;
}

double Circle::getCircumference()
{
	return 2 * pi * radius;
}

int main()
{
	double radius;

	cout << "Enter a value for the radius: ";
	cin >> radius;

	Circle myCircle(radius);

	cout << "The circle's area is " << myCircle.getArea() << "." << endl;
	cout << "The circle's diameter is " << myCircle.getDiameter() << "." << endl;
	cout << "The circle's circumference is " << myCircle.getCircumference() << "." << endl;

	return 0;
}



























int x = 25;
cout << x;
foo(x);
cout << x;

foo(int x)
{
	x = 3;
}

2525


