#include <cstdio>
using namespace std;

//a very simple class definition
class Class1
{
	int i = 0; //member variables
	
	public:
		void setvalue(const int value) //member functions
		{
			i = value;
		}
		
		int getvalue() const
		{
			return i;
		}
};

int main (int argc, char ** argv)
{
	int i = 47;
	Class1 object1;
	
	object1.setvalue(i);
	printf("value is %d\n", object1.getvalue());
	return 0;
}

#include <cstdio> 
#include <string> 

using namespace std; 

const string unk = "unknown"; 
const string clone_prefix = "clone-"; 

// -- interface -- 
class Animal
{
	string _type = ""; //member variables
	string _name = ""; 
	string _sound = ""; 
	
	public: 
		Animal();   //default constructor, member function
		Animal(const string & type, const string & name, const string & sound); //member function
	
		Animal(const Animal &); //copy constructor, member function
		Animal & operator=(const Animal &); // copy operator
		~Animal();  // destructor 
	
		void print() const; 
}; 

// -- implementation -- //initialization list
Animal::Animal() : _type(unk), _name(unk), _sound(unk)
{ 
    puts("default constructor"); //prints to the console
}


Animal::Animal(const string & type, const string & name, const string & sound) 

    : _type(type), _name(name), _sound(sound)
	{
		puts("constructor with arguments"); 
	}

Animal::Animal(const Animal & a)
{
    puts("copy constructor"); 
    _name = clone_prefix + a._name; 
    _type = a._type; 
    _sound = a._sound; 
} 

Animal::~Animal()
{ 
    printf("destructor: %s the %s\n", _name.c_str(), _type.c_str()); 
} 

void Animal::print() const
{
	printf("%s the %s says %s\n", _name.c_str(), _type.c_str(), _sound.c_str()); 
} 

Animal & Animal::operator=(const Animal & o)
{
    puts("assignment operator"); 

    if (this != &o)
	{
        _name = clone_prefix + o._name; 
        _type = o._type; 
        _sound = o._sound; 
    } 
    return *this; 
} 

int main(int argc, char ** argv)
{
    Animal a;
    a.print();
	
    const Animal b("goat", "bob", "baah"); 
    b.print();
	
    const Animal c = b; 
    c.print();
	
    a = c; 
    a.print(); 

    return 0; 
}*/

#include <iostream>
using namespace std;

int main()
{
	int i = 0;
	cout << "Please enter an integer value: ";
	cin >> i;
	cout << "The value you entered is " << i;
	cout >> " and its double is " << i * 2 << ".\n";
	return 0;
}