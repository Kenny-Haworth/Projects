/**Name: Kendall Haworth

	Class: CS140, Section 01
	
	Project 1, Task 1 - Create a program that will ask the user to enter the name
	of a software product they'd purchase, the cost of one copy, how many copies they would
	purchase, and the sales tax rate. Display a complete invoice (item purchased, unit price,
	number of units purchased, pre-tax subtotal, sales tax, and total of the sale).
	
	Date Due: October 10, 2016
*/

import java.util.Scanner;

public class Project1Task1
{
	public static void main(String[] args)
	{
		String name; // To hold the name of the product the user would purchase.
		double cost; // To hold the cost of one unit of the product.
		int copies; // To hold the number of copies or units the user would purchase.
		double salesTaxRate; // To hold the sales tax rate percentage for the unit(s).
		double preTaxSubTotal; // To hold the total before tax is calculated and added.
		double salesTax; // To hold the calculated sales tax.
		double total; // To hold the total price of everything.
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter the name of a software product you would purchase:");
		name = keyboard.nextLine();
		
		System.out.println("Enter the cost of a single copy or unit of the product:");
		cost = keyboard.nextDouble();
		
		System.out.println("Enter the number of copies you would like to purchase.");
		copies = keyboard.nextInt();
		
		System.out.println("Enter the sales tax rate of the product:");
		salesTaxRate = keyboard.nextDouble();
		
		preTaxSubTotal = cost * copies;
		salesTax = preTaxSubTotal * (salesTaxRate * (.01));
		total = preTaxSubTotal + salesTax;
		
		System.out.println("You have purchased " + copies + " units of " + name + " at $" + 
							cost + " each. The pre-tax subtotal is $" + preTaxSubTotal +
							". The sales tax is $" + salesTax + ". Your total is $" +
							total + ".");
	}
}