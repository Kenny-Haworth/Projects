
	if (a > 20)
	{
		printf("a is greater than 20\n");
	}
	else
	{
		printf("a is not less than 20\n");
	}
	printf("Value of a is: %d\n", a);

	if (a == 10)
	{
		printf("Value of a is 10\n");
	}
	else if (a == 20)
	{
		printf("Value of a is 20\n");
	}
	else if (a == 30)
	{
		printf("Value of a is 30\n");
	}
	else
	{
		printf("none of the values are matching\n");
	}

	char grade = 'A';

	switch(grade)
	{
		case 'A':
			printf("Excellent!\n");
			break;
		case 'B':
		case 'C':
			printf("Well done\n");
			break;
		default:
			printf("Invalid grade\n");
	}

	a = 10;

	while (a < 20)
	{
		printf("Value of a: %d\n", a);
		a++;
	}

	int a = 10;
	do
	{
		printf("value of a: %d\n", a);
		a = a + 1;
	}
	while (a < 20);

	return 0;



	for (int a = 10; a < 20; a++)
	{
		printf("Value of a: %d\n", a);
	}

}

FUNCTION
return_type function_name(parameter list)
{
	body of the function
}

DEFINING A FUNCTION
function returning the max between two numbers */

#include <stdio.h> //pre-processor notation, include the library
int max(int num1, int num2);
int x = 8;

int main()
{
	int a = 50;
	int b = 100;
	int ret;
`
	ret = max(a, b);

	printf ("max value is: %d\n", ret);

	return 0;
}

int max(int num1, int num2)
{
	if (num1 > num2)
	{
		return num1;
	}
	else
	{
		return num2;
	}
	
	char big[6];
	int small[77];
	double balance[] = {1000.0, 2.0, 3.4, 7.0, 50.0};
	balance[2] = 50.0;
	double x = balance[1];

	int a [5][2] = {{0,0} {2,5} {23, 43};
}
