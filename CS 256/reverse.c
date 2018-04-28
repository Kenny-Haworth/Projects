/**
	A program demonstrating a function that accepts
	an int array and the array's size as arguments,
	copies the array in reverse order, and returns
	a pointer to the new array.
	
	Author: Kendall Haworth
*/

#include <stdio.h>
#include <stdlib.h>

//function declaration
int *reverse(const int *, int);

int main()
{
	int arraySize = 10;
	int array[arraySize];
	
	//initialize the array with sequential numbers
	for (int i = 0; i < arraySize; i++)
	{
		array[i] = i;
	}
	
	//print the original array
	printf("Original array: ");
	for (int i = 0; i < arraySize; i++)
	{
		printf("%d ", array[i]);
	}
	printf("\n");
	
	//call the function to return the reversed array as a pointer
	int *new_array = reverse(array, arraySize);
	
	//print the reversed array using the pointer
	printf("Array printed using returned pointer: ");
	for (int i = 0; i < arraySize; i++)
	{
		printf("%d ", *(new_array + i));
	}
	
	return 0;
}

/**
	Reverses the passed array with the given size
	and returns the new array as a pointer
*/
int *reverse(const int *arr, int size)
{
	int *newArray = malloc(sizeof(int) * size);
	
	for (int i = (size-1); i > 0; i--)
	{
		newArray[size-i-1] = arr[i];
	}
	
	return newArray;
}