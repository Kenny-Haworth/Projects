/***************************************************************
* File: Haworth_SavingsAccount.java
* Author: Kendall Haworth
* class: CS 141 – Programming and Problem Solving
*
* Assignment: Program 5
* Date Last Modified: 2/24/2017
*
* Purpose: This program allows savings account objects to be created,
* extended from the Haworth_BankAccount parent class.
*
****************************************************************/ 

public class Haworth_SavingsAccount extends Haworth_BankAccount
{	
	private boolean active = true;
	
	//Constructor: Haworth_SavingsAccount
	//Purpose: Creates Haworth_SavingsAccount objects and initializes
	// 		   their balance and interest.
	public Haworth_SavingsAccount(double cBalance, double cInterest)
	{
		super(cBalance, cInterest);
	}
	
	//Method: withdraw
	//Purpose: Withdraws the sent amount from the balance of a savings
	// 		   account object and changes activity to true or false.
	@Override
	public void withdraw(double withdrawalAmount)
	{
		if (this.getBalance() > 25)
		{
			active = true;
		}
		else
		{
			active = false;
		}
		
		if (active)
		{
			if ((this.getBalance() - withdrawalAmount) < 25)
			{
				System.out.println("Savings account is now inactive.");
				active = false;
			}
			super.withdraw(withdrawalAmount);
		}
		else
		{
			System.out.println("You must activate your account before making any withdrawals. " +
							   "To activate your account, the balance must be raised above $25.");
			System.out.println("Your current balance is $" + this.getBalance() + ".");
		}
	}
	
	//Method: deposit
	//Purpose: Deposits the passed amount into a Haworth_SavingsAccount object
	// 		   and changes activity to true if the account was previously inactive.
	@Override
	public void deposit(double depositAmount)
	{
		if ((!(active)) && (depositAmount + this.getBalance() > 25))
		{
			active = true;
			System.out.println("Savings account is now active.");
		}
		super.deposit(depositAmount);
	}
	
	//Method: monthlyProcess
	//Purpose: Calculates the serviceCharges (+$1 for every withdrawal over 4),
	// 		   identifies if the account will be active or inactive after the
	//		   numbers are processed, and then processes the numbers by referencing
	// 		   the parent account's method.
	@Override
	public void monthlyProcess()
	{
		if (this.getNumWithdrawls() > 4)
		{
			serviceCharges += (this.getNumWithdrawls() - 4);
		}
		
		if ((this.getBalance() - serviceCharges + ((this.getInterestRate()/1200) * this.getBalance())) < 25 && (active))
		{
			System.out.println("Savings account is now inactive.");
			active = false;
		}
		else if ((this.getBalance() - serviceCharges + ((this.getInterestRate()/1200) * this.getBalance())) > 25 && !(active))
		{
			System.out.println("Savings account is now active.");
			active = true;
		}
		super.monthlyProcess();
	}
}