/**
	@author Kendall Haworth
	
	Programming challenges 7 and 8 (PersonData and CustomerData, PreferredCustomer classes)
*/

#include <iostream>
#include <string>

using namespace std;

class CustomerData;
class PreferredCustomer;

class PersonData
{
	public:
		string getLastName(){return lastName;}
		string getFirstName(){return firstName;}
		string getAddress(){return address;}
		string getCity(){return city;}
		string getState(){return state;}
		int getZip(){return zip;}
		int getPhone(){return phone;}
		
		void setLastName(string last){lastName = last;}
		void setFirstName(string first){firstName = first;}
		void setAddress(string add){address = add;}
		void setCity(string ci){city = ci;}
		void setState(string sta){state = sta;}
		void setZip(int zi){zip = zi;}
		void setPhone(double pho){phone = pho;}
		
	private:
		string lastName;
		string firstName;
		string address;
		string city;
		string state;
		int zip;
		int phone;
};

class CustomerData : public PersonData
{
	public:
		int getCustomerNumber(){return customerNumber;}
		bool getMailingList(){return mailingList;}
		
		void setCustomerNumber(int num){customerNumber = num;}
		void setMailingList(bool mail){mailingList = mail;}
	
	private:
		int customerNumber;
		bool mailingList;
};

class PreferredCustomer : public CustomerData
{
	public:
		double getPurchasesAmount(){return purchasesAmount;}
		double getDiscountLevel(){return discountLevel;}
		
		void setPurchasesAmount(int purchases)
		{
			if (purchases < 0)
			{
				cout << "You cannot enter a negative purchase amount!" << endl;
			}
			else
			{
				if (purchases >= 2000)
				{
					discountLevel = .1;
				}
				else if (purchases >= 1500)
				{
					discountLevel = .07;
				}
				else if (purchases >= 1000)
				{
					discountLevel = .06;
				}
				else if (purchases >= 500)
				{
					discountLevel = .06;
				}
				
				purchasesAmount = purchases;
			}
		}
		void setDiscountLevel(double discount){discountLevel = discount;}
		
	private:
		double purchasesAmount;
		double discountLevel;
};

int main()
{
	cout << "Now creating and initializing a person data class." << endl;
	PersonData person;
	
	person.setAddress("1923 Valley Home Drive");
	person.setCity("Lost Angeles");
	person.setFirstName("John");
	person.setLastName("Sturges");
	person.setState("Ohio");
	person.setPhone(5628395837);
	person.setZip(90631);
	
	cout << "The person created is named " << person.getFirstName() << " " << person.getLastName() << "." << endl;
	cout << "They also live in " << person.getState() << ", " << person.getCity() << ". Their address is " << person.getAddress() << ".\n" << endl;
	
	cout << "Now creating and initializing a customer data class, which is derived from the person data class" << endl;
	CustomerData cust;
	
	cust.setCustomerNumber(3234);
	cust.setMailingList(true);
	cust.setFirstName("Michael");
	cust.setLastName("Smith");
	
	cout << "The customers number is " << cust.getCustomerNumber() << " and their mailing list is set to " << cust.getMailingList() << "(true)." << endl;
	cout << "The customer also has a name (using the base class) of " << cust.getFirstName() << " " << cust.getLastName() << ".\n" << endl;
	
	cout << "Now creating and initializing a preferred customer class with $1000 of purchases." << endl;
	PreferredCustomer data;
	
	data.setPurchasesAmount(1000);
	
	cout << "The person has spent a total of $" << data.getPurchasesAmount() << " and has a discount of " << data.getDiscountLevel() << "." << endl;
	cout << "The preferred customer can also set customers and person data. I will demonstrate." << endl;
	
	data.setAddress("1353 waterfall Avenue");
	data.setCity("Maine");
	
	data.setMailingList(false);
	data.setCustomerNumber(1323);
	
	cout << "The customers number is " << data.getCustomerNumber() << " and their mailing list is set to " << data.getMailingList() << "(false)." << endl;
	cout << "The customer lives in " << data.getCity() << " and their address is " << data.getAddress() << "." << endl;
	
	
	return 0;
}