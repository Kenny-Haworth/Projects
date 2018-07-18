/**
	@author Kendall Haworth
	
	Exception Project in-class assignment
*/

#include<iostream>
#include<string>
using namespace std;

//forward declaration of classes
class ProductionWorker;
 
class Employee
{
	protected:
		string name;
		int number;
		string hireDate;
	
	public:
		class InvalidEmployeeNumber{};
	
		Employee(string na, int nu, string hire)
		{
			//if the employee number is less than 0 or greater than 9999, throw an exception
			if (nu < 0 || nu > 9999)
			{
				throw InvalidEmployeeNumber();
			}
	
			name = na;
			number = nu;
			hireDate = hire;
		}
	
		void setName(string na)
		{
			name = na;
		}
	
		void setNumber(int nu)
		{
			if (nu < 0 || nu > 9999)
			{
				throw InvalidEmployeeNumber();
			}
	
			number = nu;
		}
	
		void setHire(string hire)
		{
			hireDate = hire;
		}
	
		string getName()
		{
			return name;
		}
	
		int getNumber()
		{
			return number;
		}
	
		string getDate()
		{
			return hireDate;
		}
};

//class ProductionWorker is derived from Employee
class ProductionWorker : public Employee
{
	private:
		int shift;
		double hourlyPay;
	
	public:
		class InvalidShift{};
		class InvalidPayRate{};
	
		ProductionWorker(int shi, double hourly, string na, int nu, string hire) : Employee(na, nu, hire)
		{
			//if the shift is not 1 or 2, throw an exception
			if (shi < 1 || shi > 2)
			{
				throw InvalidShift();
			}
		
			//if the pay is negative, throw an exception
			if (hourly < 0)
			{
				throw InvalidPayRate();
			}
	
			shift = shi;
			hourlyPay = hourly;
		}
	
		void setShift(int shi)
		{
			if (shi < 1 || shi > 2)
			{
				throw InvalidShift();
			}
	
			shift = shi;
		}
	
		void setHourlyPay(double hourly)
		{
			if (hourly < 0)
			{
				throw InvalidPayRate();
			}
	
			hourlyPay = hourly;
		}
	
		int getShift()
		{
			return shift;
		}
	
		double getHourlyPay()
		{
			return hourlyPay;
		}
};
 
int main()
{
    cout << "I will now make a production worker without any exceptions and try to print the object's information: " << endl;
	
    try
    {
        ProductionWorker worker(1, 100, "John Smith", 5321, "October 31, 2015");
		cout << "The shift is " << worker.getShift() << ", the worker makes $" << worker.getHourlyPay() << ", the worker's name is " << worker.getName() << ", the worker's ID is " << worker.getNumber() << ", and the worker was hired on " << worker.getDate() << "." << endl;
    }
    catch (ProductionWorker::InvalidShift)
    {
        cout << "Error! An invalid number for the shift was entered!" << endl;
    }
    catch (ProductionWorker::InvalidPayRate)
    {
        cout << "Error! A negative number was entered for the pay rate!" << endl;
    }
	catch (Employee::InvalidEmployeeNumber)
    {
        cout << "Error! An invalid employee number was entered!" << endl;
    }
	
	cout << "\nNow, I will create an employee with a number greater than 9999 and try to print the object's information: " << endl;
 
    try
    {
        Employee employee("Mark Teddy", 10000, "January 1st, 2013");
		cout << "The employee's name is " << employee.getName() << ", the employee's ID is " << employee.getNumber() << ", and the employee was hired on " << employee.getDate() << "." << endl;
    }
    catch (Employee::InvalidEmployeeNumber)
    {
        cout << "Error! An invalid employee number was entered!" << endl;
    }
 
	cout << "\nNow I will create a production worker with a shift number not 1 or 2 and try to print the object's information: " << endl;
 
    try
    {
        ProductionWorker worker1(10, 500, "Josh Pippins", 8914, "April 3rd, 1996");
		cout << "The shift is " << worker1.getShift() << ", the worker makes $" << worker1.getHourlyPay() << ", the worker's name is " << worker1.getName() << ", the worker's ID is " << worker1.getNumber() << ", and the worker was hired on " << worker1.getDate() << "." << endl;
    }
    catch (ProductionWorker::InvalidShift)
    {
        cout << "Error! An invalid number for the shift was entered!" << endl;
    }
    catch (ProductionWorker::InvalidPayRate)
    {
        cout << "Error! A negative number was entered for the pay rate!" << endl;
    }
	catch (Employee::InvalidEmployeeNumber)
    {
        cout << "Error! An invalid employee number was entered!" << endl;
    }
	 
	cout << "\nFinally, I will create a production worker with a negative hourly pay rate and try to print the object's information: " << endl;
 
    try
    {
        ProductionWorker worker2(1, -1, "Larry Stewart", 5327, "May 13th, 1990");
		cout << "The shift is " << worker2.getShift() << ", the worker makes $" << worker2.getHourlyPay() << ", the worker's name is " << worker2.getName() << ", the worker's ID is " << worker2.getNumber() << ", and the worker was hired on " << worker2.getDate() << "." << endl;
    }
    catch (ProductionWorker::InvalidShift)
    {
        cout << "Error! An invalid number for the shift was entered!" << endl;
    }
    catch (ProductionWorker::InvalidPayRate)
    {
        cout << "Error! A negative number was entered for the pay rate!" << endl;
    }
	catch (Employee::InvalidEmployeeNumber)
    {
        cout << "Error! An invalid employee number was entered!" << endl;
    }
 
    cout << "\nThe program is now finished." << endl;
   
    return 0;
}