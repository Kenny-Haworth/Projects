#include "Employee.h"

#include<string>
using namespace std;

Employee::Employee(string nm, int id, string dept, string pos)
{
	name = nm;
	idNumber = id;
	department = dept;
	position = pos;
}

Employee::Employee(string nm, int id)
{
	name = nm;
	idNumber = id;
	department = "";
	position = "";
}

Employee::Employee()
{
	name = "";
	idNumber = 0;
	department = "";
	position = "";
}

string Employee::getName()
{
	return name;
}

int Employee::getIdNumber()
{
	return idNumber;
}

string Employee::getDepartment()
{
	return department;
}

string Employee::getPosition()
{
	return position;
}

void Employee::setName(string nm)
{
	name = nm;
}

void Employee::setIdNumber(int id)
{
	idNumber = id;
}

void Employee::setDepartment(string dept)
{
	department = dept;
}

void Employee::setPosition(string pos)
{
	position = pos;
}