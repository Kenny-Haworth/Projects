#include <stdio.h>

int main()
{
	int shares = 1000;
	double stockCost = 45.50;
	double commission = .2; //%2 commission
	double stockSell = 56.90;
	
	double moneyPaid = stockCost*shares;
	double firstCommission = commission*moneyPaid;
	
	double moneyEarned = stockSell*shares;
	double secondCommission = commission*moneyEarned;
	double total = moneyEarned - (moneyPaid + firstCommission + secondCommission);
	
	printf("Money paid for buying all stocks: %g\n", moneyPaid);
	printf("Commission paid when buying the stocks: %g\n", firstCommission);
	printf("Money earned for selling all stocks: %g\n", moneyEarned);
	printf("Commission paid when selling the stocks: %g\n", secondCommission);
	printf("Total profit: %g", total);
	
	return 0;
}