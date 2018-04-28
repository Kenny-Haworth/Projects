#include <stdio.h>

int main()
{
	double level = 1.5;
	
	printf("Millimeters higher than the current level that the ocean's level will be in 5 years: %g\n", level*5);
	printf("Millimeters higher than the current level that the ocean's level will be in 7 years: %g\n", level*7);
	printf("Millimeters higher than the current level that the ocean's level will be in 10 years: %g\n", level*10);
	
	return 0;
}