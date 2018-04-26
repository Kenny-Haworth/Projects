/***************************************************************
* File: Haworth_ExtendsAbstract.java
* Author: Kendall Haworth
* class: CS 141 – Programming and Problem Solving
*
* Assignment: Program 5
* Date Last Modified: 2/24/2017
*
* Purpose: This program extends Haworth_BankAccount.java to instantiate
* it and allow objects to be created of it in the Haworth_AccountDriver.java driver.
*
****************************************************************/ 

public class Haworth_ExtendsAbstract extends Haworth_BankAccount
{
	public Haworth_ExtendsAbstract(double cBalance, double cInterest)
	{
		super(cBalance, cInterest);
	}
}