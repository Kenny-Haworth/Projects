#include "Employee.h"
#include <string>
#include <iostream>
using namespace std;

int main()
{
	Employee Susan("Susan Meyers", 47899, "Accounting", "Vice President");
	Employee Mark("Mark Jones", 39119);
	Employee Joy; //default constructor - no arguments

	//Finish Mark's info
	Mark.setDepartment("IT");
	Mark.setPosition("Programmer");

	//Finish Joy's info
	Joy.setName("Joy Rogers");
	Joy.setIdNumber(81774);
	Joy.setDepartment("Manufacturing");
	Joy.setPosition("Engineer");

	cout << "Name\t\t" << "ID Number\t" << "Department\t" << "Position" << endl;
	cout << Susan.getName() << "\t" << Susan.getIdNumber() << "\t\t" << Susan.getDepartment() << "\t" << Susan.getPosition() << endl;
	cout << Mark.getName() << "\t" << Mark.getIdNumber() << "\t\t" << Mark.getDepartment() << "\t\t" << Mark.getPosition() << endl;
	cout << Joy.getName() << "\t" << Joy.getIdNumber() << "\t\t" << Joy.getDepartment() << "\t" << Joy.getPosition() << endl;

	return 0;
}