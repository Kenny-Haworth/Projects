#include <iostream>
using namespace std;

int main()
{
	int length, width, area;
	
	cout << "This program calculates the area of a rectangle.\n";
	cout << "What is the length of the rectangle? ";
	cin >> length;
	cout << "What is the width of the rectangle? ";
	cin >> width;
	area = length*width;
	cout << "The area of the rectangle is " <<area << ".\n";
	
	return 0;
}

/**cout << "Programming is " << "great fun!" << endl;
	cout << "Try this\n";
	cout << "Or this\n";
	
	int apples = 20;
	cout << "We have " << apples << " apples";*/