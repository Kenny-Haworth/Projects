#include <stdio.h>

int main()
{
	double cost = 88.67; //$88.67 meal cost
	double tax = .0675; //%6.75 tax
	double tip = .2; //%20 of meal total cost
	
	double taxAmt = cost*tax;
	double subtotal = cost+taxAmt;
	double tipAmt = subtotal*tip;
	double total = subtotal + tipAmt;
		
	printf("Meal cost: %g\n", cost);
	printf("Tax amount: %.3g\n", taxAmt); //display answer with 3 significant digits
	printf("Tip amount: %.4g\n", tipAmt); //display answer with 4 significant digits
	printf("Total: %.5g\n", total); //display answer with 5 significant digits
	
	return 0;
}