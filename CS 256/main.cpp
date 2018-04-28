/**#include <iostream>
//using namespace std;

int main()
{
	int i = 0;
	std::cout << "Please enter an integer value: ";
	std::cin >> i;
	std::cout << "The value you entered is " << i;
	std::cout << " and its double is " << i * 2 << ".\n";
	return 0;
}*/

#include <cstdio> 
#include <string>	//NOTE:strings in C++ are objects. In C they were char arrays 
namespace altstring
{
	const std::string prefix = "(altstring)";	//Declare constant string 
	//must announce standard namespace 
	class string
	{
		std::string _s = ""; 
		string(); 
		public: 
		string(const std::string & s) : _s(prefix + s) {}; 
		const char * c_str()
		{
			return _s.c_str();
		
		}
		
		operator const std::string & ()
		{
			return _s;
		}; 
	};
};	// namespace altstring 

using namespace std;

//std::string s1("This is a string");

int main(int argc, char ** argv)
{
	altstring::string s(s1);
	//std::puts(s.c_str());
	puts(s.c_str());
	return 0;
}