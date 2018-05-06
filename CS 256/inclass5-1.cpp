#include <iostream>
#include <stdio.h>
using namespace std;
 
class Count
{ 
	private: 
		int a;	//each object will have its own 
		int b;	//each object will have its own 
		static int count;	//one variable declared. Shared by all instances of class(OBJECTS) 
	public: 
		Count(int, int); 
		void printCount() const;	//means its const safe, data won't change when printed
		static void getCount(); 
}; 
 
int Count::count = 0;	//static variables need to be initalized outside of constructor 
 
void Count::getCount()
{
	cout << count << endl; 
} 
 
Count::Count(int a = 1, int b = 1)
{
	a = a; //THIS a = 1 (declared variable vs passed reference)
	this -> b = b;	//same this as b=b; 
	count++;	//All instances of objects will increment count by 1 
} 

void Count::printCount() const
{
	cout << count << endl; 
} 

int main() 
{ 
	Count A, B(2, 2), C(3, 3); 
	A.printCount(); 
	B.printCount(); 
	C.printCount();
	
    return 0; 
}

//printed 3 3 3