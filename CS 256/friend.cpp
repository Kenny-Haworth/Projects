#include <iostream>
#include <string>
using namespace std;

class Dog;

class Cat
{
	friend class Dog;
	public:
		int numPaws = 4;
		int getNumPaws();
};

class Dog
{
		public:
		void print(Cat &c)
		{
			cout << "This cat has " << c.numPaws << " paws." << endl;
		}
};

int Cat::getNumPaws()
{
	return numPaws;
}

int main()
{
	Cat tabby;
	Dog yorkshire;
	
	Cat *ptr = new Cat;
	
	cout << ptr -> getNumPaws();
	
	yorkshire.print(tabby);
	
	return 0;
}




int array[10]; // 1 2 3 4

int *ptr = array;

for(int i = 0; i < 10; i++)
{
	cout << *ptr; //1
	ptr+=4;
}






int x = 25;

cout << x;

int *ptr = &x;

cout << ptr;
cout << *ptr; //25
cout << x; //25
cout << &x; //0xF5A3






