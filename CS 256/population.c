/**
	Calculates the size of the population for number of years.
	
	Author: Kendall Haworth
*/

#include <stdio.h>

int main()
{
	//starting variables
	int population;
	int birthRate;
	int deathRate;
	int numYears;
	
	do
	{
		printf("Enter the starting size of the population: ");
		scanf("%i", &population);
		
		if (population < 2)
		{
			printf("The population must be greater than 2!\n");
		}
	}
	while(population < 2); //population must be at least 2
	
	do
	{
		printf("Enter the annual birth rate: ");
		scanf("%i", &birthRate);
		
		if (birthRate < 0)
		{
			printf("The birth rate cannot be negative!\n");
		}
	}
	while(birthRate < 0); //birth rate cannot be negative
	
	do
	{
		printf("Enter the annual death rate: ");
		scanf("%i", &deathRate);
		
		if (deathRate < 0)
		{
			printf("The death rate cannot be negative!\n");
		}
	}
	while(deathRate < 0); //death rate cannot be negative
	
	do
	{
		printf("Enter the number of years to display: ");
		scanf("%i", &numYears);
		
		if (numYears < 1)
		{
			printf("The number of years to display must be 1 or greater!\n");
		}
	}
	while(numYears < 1); //number of years to display must be at least one
	printf("\n");
	
	int newPop;
	int counter = 1;
	
	//loop until all the years have been displayed
	while (numYears > 0)
	{
		newPop = population + birthRate - deathRate;
		
		if (newPop < 0) //the population is dead and cannot be negative
		{
			printf("Whoops! Your population is all dead at year %i!\n", counter);
			break;
		}
		
		printf("Year %i:\n", counter++);
		printf("\tPopulation = %i\n\n", newPop);
		
		population = newPop;
		numYears--;
	}
	
	return 0;
}