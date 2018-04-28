/**
	Kendall Haworth
	Bronco ID: 011694826
*/

class employee
{
	String name;
	int idNumber;
	String department;
	String position;
	
	public:
		employee(String, int, String, String);
		employee(String, int);
		employee();
};

employee::employee(double na, int id, String depart, String pos)
{
	name = na;
	idNumber = id;
	department = depart;
	position = pos;
}

employee::employee(double na, int id)
{
	name = na;
	idNumber = id;
	department = "";
	position = "";
}

employee::employee()
{
	name = "";
	idNumber = 0;
	department = "";
	position = "";
}