#include <stdio.h>

int main()
{
	for (int i = 0; i < 10; i++)
	{
		int q = -1;
		while (q < i)
		{
			printf("+");
			q++;
		}
		printf("\n");
	}
	
	printf("\n");
	
	for (int i = 10; i > 0; i--)
	{
		int q = 0;
		while (q < i)
		{
			printf("+");
			q++;
		}
		printf("\n");
	}
	
	return 0;
}