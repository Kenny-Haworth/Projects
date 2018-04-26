/***************************************************************
* File: Haworth_BankAccount.java
* Author: Kendall Haworth
* class: CS 141 – Programming and Problem Solving
*
* Assignment: Program 5
* Date Last Modified: 2/24/2017
*
* Purpose: This program allows bank account objects to be created
* and serves as the parent class to Haworth_SavingsAccount.java.
*
****************************************************************/ 

public abstract class Haworth_BankAccount
{
	protected double balance;
	private int numDeposits;
	protected int numWithdrawals;
	private double annualInterestRate;
	protected double serviceCharges = 5;
	
	//Constructor: Haworth_BankAccount
	//Purpose: Creates Haworth_BankAccount objects and
	// 		   initializes their balance and interest.
	public Haworth_BankAccount(double cBalance, double cInterest)
	{
		balance = cBalance;
		annualInterestRate = cInterest;
	}
	
	//Method: deposit
	//Purpose: Deposits the passed amount into a Haworth_BankAccount
	// 		   object and increments the number of total deposits.
	public void deposit(double amountDeposited)
	{
		balance += amountDeposited;
		numDeposits++;
	}
	
	//Method: withdraw
	//Purpose: Withdraws the passed amount into a Haworth_BankAccount
	// 		   object and increments the number of total withdrawals.
	public void withdraw(double amountWithdrawn)
	{
		if (balance < amountWithdrawn)
		{
			System.out.println("Error: Not enough funds in this account.");
		}
		else
		{
			balance -= amountWithdrawn;
			numWithdrawals++;
		}
	}

	//Method: calcInterest
	//Purpose: Calculates the total monthlyInterst and
	// 		   adds it to the total balance.
	public void calcInterest()
	{
		double monthlyInterestRate = (annualInterestRate/12);
		double monthlyInterest = (balance*(monthlyInterestRate/100));
		balance += monthlyInterest;
	}
	
	//Method: monthlyProcess
	//Purpose: Subtracts the service charges from the balance, calls the
	// 		   calcInterst() method, and set the deposits, withdrawls, and
	//		   service charges to 0.
	public void monthlyProcess()
	{
		balance -= serviceCharges;
		calcInterest();
		numDeposits = 0;
		numWithdrawals = 0;
		serviceCharges = 0;
	}
	
	//Method: getBalance
	//Purpose: Returns the balance
	public double getBalance()
	{
		return balance;
	}

	//Method: getNumDeposits
	//Purpose: Returns the  number of deposits
	public int getNumDeposits()
	{
		return numDeposits;
	}
	
	//Method: getNumWithdrawls
	//Purpose: Returns the  number of withdrawals
	public int getNumWithdrawls()
	{
		return numWithdrawals;
	}

	//Method: getInterestRate
	//Purpose: Returns the annual interest rate
	public double getInterestRate()
	{
		return annualInterestRate;
	}
	
	//Method: getServiceCharges
	//Purpose: Returns the service charges
	public double getServiceCharges()
	{
		return serviceCharges;
	}
	
	//Method: setBalance
	//Purpose: sets the balance
	public void setBalance(double bal)
	{
		balance = bal;
	}
	
	//Method: setNumDeposits
	//Purpose: sets the number of deposits
	public void setNumDeposits(int deposits)
	{
		numDeposits = deposits;
	}
	
	//Method: setNumWithdrawals
	//Purpose: sets the number of withdrawals
	public void setNumWithdrawls(int withdrawals)
	{
		numWithdrawals = withdrawals;
	}
	
	//Method: setInterestRate
	//Purpose: sets the interest rate
	public void setInterestRate(double interest)
	{
		annualInterestRate = interest;
	}
	
	//Method: setServiceCharges
	//Purpose: sets the service charges
	public void setServiceCharges(double charges)
	{
		serviceCharges = charges;
	}
}