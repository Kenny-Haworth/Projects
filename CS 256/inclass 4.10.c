#include <stdio.h>

int main()
{
	int var = 20;
	int *ip; //ip is a pointer to type int!
	
	ip = &var;
	
	printf("Address of var variable: %x\n", &var);
	
	printf("Address stored in ip variable: %x\n", ip);
	
	printf("Value of *ip variable: %d\n", *ip);
	
	return 0;
}

//PASS BY POINTER

#include <stdio.h>

void swap(int* x, int* y)
{
	int z = *x;
	*x = *y;
	*y = z;
}

int main()
{
	int *ptr = NULL;
	
	printf("The value of ptr is: %x\n", ptr); //ptr = 0 = null
	
	int a = 45; int b = 35;
	printf("Before Swap\n");
	printf("a = %d b = %d\n", a, b);
	
	swap(&a, &b);
	
	printf("After swap with pass by pointer\n");
	printf("a = %d b = %d\n", a, b);
	
	return 0;
}

//PASS BY REFERENCE IS NOT SUPPORTED BY C*/

int x = 2;
int y = 4;
int *ptr = NULL;

ptr = &x; //ptr points to x
*ptr = 10; //change value of x to 10
ptr = &y; //ptr points to y
*ptr = 20; //change value of y to 20

char greeting[6] = {'H', 'e', 'l', 'l', 'o', '\0'};
//or
char greeting[] = "Hello";

#include <stdio.h>

int main()
{
	//char greeting[6] = {'H', 'e', 'l', 'l', 'o', '\0'};
	char greeting[] = "Hello";
	printf("Greeting message: %s\n", greeting);
	return 0;
}

#include <string.h>
#include <stdio.h>

int main()
{
	char str1[12] = "hello";
	char str2[12] = "world";
	char str3[12];
	int len;
	
	//copy str1 into str3
	strcpy(str3, str1);
	printf("strcopy(str3, str1): %s\n", str3);
	
	//concatenates str1 and str2
	strcat(str1, str2);
	printf("strcat(str3, str1): %s\n", str1);
	
	//total length of str1 after concatenation
	len = strlen(str1);
	printf("strlen(str1): %d\n", len);
	
	return 0;
}

#include <string.h>
#include <stdio.h>

typedef struct Books
{
	char title[50];
	char author[50];
	char subject[100];
	int book_id;
} Book; //;

int main()
{
	//struct Books Book1;
	Book Book1;
	
	strcpy(Book1.title, "C Programming");
	strcpy(Book1.author, "Nima Davarpanah");
	strcpy(Book1.subject, "C Programming Tutorial");
	Book1.book_id = 6495407;
	
	printf("Book 1 title: %s\n", Book1.title);
	printf("Book 1 author: %s\n", Book1.author);
	printf("Book 1 subject: %s\n", Book1.subject);
	printf("Book 1 book_id: %d\n", Book1.book_id);
	return 0;
}

#include <string.h>
#include <stdio.h>

union Data
{
	int i;
	float f;
	char str[100];
};

int main()
{
	union Data henry;
	
	printf("Memory size occupied by data: %d\n", sizeof(henry));
	
	union Data data;
	
	data.i = 10;
	printf("data.i: %d\n", data.i);
	
	data.f = 220.5;
	printf("data.f: %f\n", data.f);
	
	strcpy(data.str, "C Programming");
	printf("data.str: %s\n", data.str);

	return 0;
}