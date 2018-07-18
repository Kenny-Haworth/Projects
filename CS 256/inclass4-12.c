#include <stdio.h>

typedef int number;

int main()
{
	number c;
	printf("Enter a value: ");
	//fflush(stdout);
	c = getchar();
	
	printf("\nYou entered: ");
	putchar(c);
	
	return 0;
}

#include <stdio.h>

int main()
{
	char str[100];
	
	printf("Enter a value: ");
	gets(str);
	
	printf("\nYou entered: ");
	puts(str);
	
	return 0;
}

#include <stdio.h>

int main()
{
	char str[100];
	int i;
	
	printf("Enter a value: ");
	scanf("%s %d", str, &i);
	
	printf("\nYou entered: %s %d ", str, i);
	
	return 0;
}

#include <stdio.h>

int main()
{
	FILE *fp; //fp is file handler
	
	fp = fopen("textFilessss.txt", "w+"); //r read only, w write only
	fprintf(fp, "This is testing for fprintf...\n"); //print to file
	fputs("This is testing for fputs...\n", fp);
	fclose(fp);
	
	return 0;
}

#include <stdio.h>

int main()
{
	FILE *fp;
	char buff[255];
	
	fp = fopen("textFile.txt", "r");
	fscanf(fp, "%s", buff);
	printf("1: %s\n", buff);
	
	fgets(buff, 255, (FILE*)fp);
	printf("2: %s\n", buff);
	
	fgets(buff, 255, (FILE*)fp);
	printf("3: %s\n:", buff);
	fclose(fp);
	
	return 0;
}