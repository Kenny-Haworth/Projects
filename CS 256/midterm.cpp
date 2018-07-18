/**
	@author Kendall Haworth
	
	Midterm revision for CS 256
*/

#include <iostream>
#include <string>
#include <vector>
using namespace std;

//forward declaration of classes
class Parent;
class Child;

class Human
{
	friend class Child;
	friend class Parent;
	private:
		string name;
		int age;
		char sex;
	
		Human()
		{
			name = "";
			age = 0;
			sex = 'M';
		}
	
	protected:
		Human(string humansName, int humansAge, char humansSex)
		{
			name = humansName;
			age = humansAge;
			sex = humansSex;
		}
		
		string works;
	
	public:
		string getWork()
		{
			return works;
		}
	
		string getName()
		{
			return name;
		}
	
		int getAge()
		{
			return age;
		}
	
		char getSex()
		{
			return sex;
		}
	
		void setName(string humanName)
		{
			name = humanName;
		}
	
		void setAge(int humanAge)
		{
			age = humanAge;
		}
	
		void setSex(char humanSex)
		{
			sex = humanSex;
		}
		
		virtual void work(string myWork)
		{
			works = myWork;
		}
};

class Parent : public Human
{
	private:
		vector<Child> children;
	
	public:
		Parent(string humansName, int humansAge, char humansSex) : Human(humansName, humansAge, humansSex)
		{
		}
	
		Parent() : Human()
		{
		}
	
		vector<Child> getChild()
		{
			return children;
		}
	
		void setChild(vector<Child> child)
		{
			children = child;
		}
		
		void setChildName(Child &c, string name);
};

class Child : public Human
{
	friend class Parent;
	private:
		Parent Mom;
		Parent Dad;
	
		Child()
		{
			
		}
	
	public:
		Child(Parent m, Parent d)
		{
			//set all the parent's member variables passed upon the passed objects
			Mom.setName(m.getName());
			Mom.setAge(m.getAge());
			Mom.setSex(m.getSex());
	
			Dad.setName(d.getName());
			Dad.setAge(d.getAge());
			Dad.setSex(d.getSex());
		}
};

//the parent can set the child's name
void Parent::setChildName(Child &c, string name)
{
	c.name = name;
}

int main()
{
	//create the Simpson family
	Parent Homer("Homer", 36, 'M');
	Parent March("March", 34, 'F');
	Child Lisa(March, Homer);
	Child Bart(March, Homer);
	Child Maggie(March, Homer);
	
	//set the children's age
	Lisa.setAge(12);
	Bart.setAge(10);
	Maggie.setAge(3);
	
	//set the children's sex
	Lisa.setSex('F');
	Bart.setSex('M');
	Maggie.setSex('F');
	
	//set the Simpson family's work
	Homer.work("Safety Inspector");
	March.work("Housewife");
	Lisa.work("Student");
	Bart.work("Student");
	Maggie.work("Play");
	
	//have March set Maggie's name and Homer set Bart and Lisa's name
	March.setChildName(Maggie, "Maggie");
	Homer.setChildName(Bart, "Bart");
	Homer.setChildName(Lisa, "Lisa");
	
	//print out Homer, Lisa, and Maggie's names, age, sex, and work
	cout << "My name is " << Homer.getName() << ". I am " << Homer.getAge() << " years of age, I am " << Homer.getSex() << ", and I work as a " << Homer.getWork() << "." << endl;
	cout << "My name is " << Lisa.getName() << ". I am " << Lisa.getAge() << " years of age, I am " << Lisa.getSex() << ", and I work as a " << Lisa.getWork() << "." << endl;
	cout << "My name is " << Maggie.getName() << ". I am " << Maggie.getAge() << " years of age, I am " << Maggie.getSex() << ", and I work as a " << Maggie.getWork() << "." << endl;

	return 0;
}