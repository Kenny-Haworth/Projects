/**
	@author Kendall Haworth
	
	Programming challenge "Bank Accounts" for project 2
*/

#include <string> 
#include <iostream>
using namespace std;

//forward declaration of classes
class SavingsAccount;
class CheckingAccount;

//base class
class BankAccount
{
	public:
		//constructor to initialize the balance, annual interest rate, and other variables
		BankAccount(double bal, double rate)
		{
			balance = bal;
			interest = rate;
			numDeposits = 0;
			numWithdrawals = 0;
			charges = 0;
		}
		
		//deposits money in the account
		virtual void deposit(double dep)
		{
			balance += dep;
			numDeposits++;
			cout << "$" << dep << " has been added to your account." << endl;
			cout << "Your standing balance is now $" << balance << "." << endl;
		}
		
		//withdraws money from the account
		virtual void withdraw(double withdraw)
		{
			balance -= withdraw;
			numWithdrawals++;
			
			cout << "$" << withdraw << " has been removed from your account." << endl;
			cout << "Your standing balance is now $" << balance << "." << endl;
		}
		
		//calculates the montly interest
		virtual void calcInt()
		{
			//if the account balance is negative, they have no interest
			if (balance < 0)
			{
				cout << "Your balance is less than 0 and you have no interest rate." << endl;
				cout << "Your standing balance is now $" << balance << "." << endl;
			}
			else
			{
				double monthlyInterestRate = (interest/12);
				double monthlyInterest = balance*monthlyInterestRate;
				balance += monthlyInterest;
				cout << "$" << monthlyInterest << " has been added to your account due to your monthly interest." << endl;
				cout << "Your annual interest rate is currently " << interest << "." << endl;
				cout << "Your standing balance is now $" << balance << "." << endl;
			}
		}
		
		//subtract the monthly service charges, calculate the montly interest, and reset monthly variables
		virtual void monthlyProc()
		{
			balance -= charges;
			cout << "$" << charges << " is being subtracted from your account for monthly service charges." << endl;
			calcInt();
			numWithdrawals = 0;
			numDeposits = 0;
			charges = 0;
		}
	
	//variables are declared protected so the derived classes may access them
	protected:
		double balance;
		int numDeposits;
		int numWithdrawals;
		double interest; //annual interest rate
		double charges; //monthly service charge
};

//savings account is derived from the bank account class
class SavingsAccount : public BankAccount
{
	public:
		//constructor to intialize the status variable and then call the base class constructor
		SavingsAccount(double bal, double rate) : BankAccount(bal, rate)
		{
			//the account is active as long as the balance is greater than $25
			if (bal >= 25)
			{
				status = true;
			}
			else
			{
				status = false;
			}
			
			BankAccount(bal, rate); //calls the base class constructor
		}
	
		//withdraws the requested amount as long as the account is active
		void withdraw(double withdraw)
		{
			if (status)
			{
				//if the withdraw brings the account beneath $25, the account becomes inactive
				if ((balance-withdraw) < 25)
				{
					status = false;
				}
				BankAccount::withdraw(withdraw); //call the base class's version of withdraw
			}
			else //the account is inactive and so a withdraw cannot be made
			{
				cout << "The account balance is beneath $25 and is inactive. A withdrawal cannot be made." << endl;
				cout << "Your current balance is $" << balance << "." << endl;
			}
		}
		
		//deposits the requested amount
		void deposit(double dep)
		{
			//if the account is inactive and the deposit brings the account balance to or above 25 dollars, the account becomes active
			if (!status && (balance+dep) >= 25)
			{
				status = true;
			}
			BankAccount::deposit(dep); //call the base class's version of deposit
		}
		
		//adds to the service charge and calls the base class's monthlyProc method
		void monthlyProc()
		{
			//for every withdraw over 4, the account holder is charged an extra dollar
			if (numWithdrawals > 4)
			{
				charges += (numWithdrawals-4);
			}
			
			BankAccount::monthlyProc(); //call the base class's version of monthlyProc
			
			//the the balance falls back below $25, the account becomes inactive
			if (balance < 25)
			{
				status = false;
			}
		}
	
	//private variables not accessible to anything outside the derived class
	private:
		bool status; //a flag variable to represent an active or inactive account
};

//a checking account derived from the bank account
class CheckingAccount : public BankAccount
{
	public:
		//constructor to call the base class's constructor
		CheckingAccount(double bal, double rate) : BankAccount(bal, rate)
		{	
			BankAccount(bal, rate); //calls the base class constructor
		}
		
		//A withdraw method implemented as per the book's instructions:
		//If a withdraw "will cause the balance to go below $0, a service charge of $15 will be taken from the account. (The withdrawal will not be made)."
		void withdraw(double withdraw)
		{
			//if the withdraw will be greater than the balance of the account, do not perform the withdraw. Instead, charge $15 to the account
			if (balance - withdraw < 0)
			{
				cout << "Your account does not have this much money to withdraw!" << endl;
				cout << "A withdrawal will not be made, and a service charge of $15 will now be charged to your account." << endl;
				balance -= 15;
				cout << "Your current account balance is now $" << balance << "." << endl;
			}
			else //the withdraw was not more than the account's standing balance
			{
				BankAccount::withdraw(withdraw); //calls the base class's version of withdraw
			}
		}
		
		//Adds the montly fee of $5 plus %0.10 per withdrawal before subtracting monthly service charges
		void monthlyProc()
		{
			charges += (5 + (.1*numWithdrawals));
			BankAccount::monthlyProc(); //calls the base class's version of monthlyProc
		}
};

int main()
{
	double balance;
	double annual;
	
	//the savings account is tested first, then the checkings account
	cout << "We will begin with testing a savings account, and then move on to a checkings account." << endl;
	cout << "Enter the initial balance of the savings account: ";
	cin >> balance;
	cout << "Enter the annual interest rate for the savings account (a number between 0 and 1): ";
	cin >> annual;
	
	SavingsAccount account(balance, annual); //create a savings account object
	
	//variables declared outside the do-while loop
	int input;
	double depos;
	double withdrawal;
	
	do
	{
		//display the menu
		printf("Savings Account Menu\n\n");
		printf("\t1. Make a deposit\n");
		printf("\t2. Make a withdrawal\n");
		printf("\t3. Calculate the montly interest\n");
		printf("\t4. Subtract the monthly service charges\n");
		printf("\t5. Quit (move on to the checking account menu)\n\n");
		printf("\tEnter your choice (1-5): ");
		scanf("%d", &input);
		
		switch (input)
		{
			case 1:
				cout << "Enter the amount to deposit: ";
				cin >> depos;
				account.deposit(depos);
				break;
				
			case 2:
				cout << "Enter the amount to withdrawal: ";
				cin >> withdrawal;
				account.withdraw(withdrawal);
				break;
				
			case 3:
				account.calcInt();
				break;
				
			case 4:
				account.monthlyProc();
				break;
				
			case 5:
				cout << "Moving on to the checking account class..." << endl;
				break;
				
			default:
				printf("Please enter a valid number from 1 to 5.\n\n");
				break;
		}
	}
	while (input != 5); //quit once the user inputs 5
	
	//now test the checkings account class
	cout << "Enter the initial balance of the checkings account: ";
	cin >> balance;
	cout << "Enter the annual interest rate for the checkings account (a number between 0 and 1): ";
	cin >> annual;
	
	CheckingAccount check(balance, annual); //create a checkings account object
	
	do
	{
		//display the menu
		printf("Checkings Account Menu\n\n");
		printf("\t1. Make a deposit\n");
		printf("\t2. Make a withdrawal\n");
		printf("\t3. Calculate the montly interest\n");
		printf("\t4. Subtract the monthly service charges\n");
		printf("\t5. Quit\n\n");
		printf("\tEnter your choice (1-5): ");
		scanf("%d", &input);
		
		switch (input)
		{
			case 1:
				cout << "Enter the amount to deposit: ";
				cin >> depos;
				check.deposit(depos);
				break;
				
			case 2:
				cout << "Enter the amount to withdrawal: ";
				cin >> withdrawal;
				check.withdraw(withdrawal);
				break;
				
			case 3:
				check.calcInt();
				break;
				
			case 4:
				check.monthlyProc();
				break;
				
			case 5:
				cout << "The program will now end." << endl;
				break;
				
			default:
				printf("Please enter a valid number from 1 to 5.\n\n");
				break;
		}
	}
	while (input != 5); //quit once the user inputs 5
	
	return 0;
}