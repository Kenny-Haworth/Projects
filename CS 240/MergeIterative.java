/**
	A merge sort algorithm that uses iteration to
	sort an array from low numbers to high numbers.
	@author Kendall Haworth
*/

import java.util.Random;

public class MergeIterative
{
	public static void main(String[] args) throws EmptyQueueException
	{
		LinkedQueue<Integer> pointers = new LinkedQueue<Integer>(); //Creates a new linked queue
		DLDeque<Integer> queue = new DLDeque<Integer>(); //Creates a new linked queue
		
		int[] array = new int[10];
		
		Random randomObj = new Random();
		
		//This loop fills each element of the array with random numbers.
		for (int q = 0; q < array.length; q++)
		{
			array[q] = randomObj.nextInt(1000);
			System.out.print(array[q] + " ");
		}
		
		System.out.println();
		
		int first = 0;
		int last = array.length-1;
		int midpoint = 0;
		boolean loop = true;
		
		while (loop)
		{
			midpoint = (first + last)/2; //Add to the queue part of the array to be sorted
			queue.addToBack(first);
			queue.addToBack(midpoint);
			queue.addToBack(last);
			
			pointers.enqueue(first); //Split the array and use a different queue to store the pointers
			pointers.enqueue(midpoint);
			pointers.enqueue(midpoint+1);
			pointers.enqueue(last);
			
			do
			{
				if (pointers.isEmpty()) //If the pointers queue is empty, sorting is complete
				{
					loop = false;
					break;
				}
				else //If the pointers queue is not empty, get the next two pointers
				{
					first = pointers.dequeue();
					last = pointers.dequeue();
				}
			}
			while(first >= last); //If first < last, more sorting needs to be performed. Otherwise these pointers are not needed
		}
		
		//Declare variables outside the while loop
		int firstHalf;
		int secondHalf;
		int leftPointer;
		int rightPointer;
		int index;
		
		while (!queue.isEmpty()) //Loops until there is nothing left to sort
		{
			last = queue.removeBack(); //Removes numbers from the back of the queue
			midpoint = queue.removeBack();
			first = queue.removeBack();
			
			firstHalf = midpoint - first + 1; //Define the size of the left half
			secondHalf = last - midpoint; //Define the size of the right half
			
			int[] left = new int[firstHalf]; //Create a new array to hold the left sorted half
			int[] right = new int[secondHalf]; //Create a new array to hold the right sorted half
		
			for(int i = 0; i < firstHalf; i++) //Add the elements to the left half of the array
			{
				left[i] = array[first + i];
			}
		
			for(int i = 0; i < secondHalf; i++) //Add the elements to the right half of the array
			{
				right[i] = array[midpoint + 1 + i];
			}

			leftPointer = 0;
			rightPointer = 0;
			index = first;
		
			while(leftPointer < firstHalf && rightPointer < secondHalf) //Loops as long as there are more elements to sort
			{
				if(left[leftPointer] <= right[rightPointer]) //If the left element is less than the right element,
				{											//add the left element to the array and increment the left pointer
					array[index] = left[leftPointer];
					leftPointer++;
				}
				else									//If the right element is less than the left element,
				{										//add the right element to the array and increment the right pointer
					array[index] = right[rightPointer];
					rightPointer++;
				}
				index++;
			}

			while(leftPointer < firstHalf) //If there are more elements in the left side, add them to the array
			{
				array[index] = left[leftPointer];
				leftPointer++;
				index++;
			}

			while(rightPointer < secondHalf) //If there are more elements in the right side, add them to the array
			{
				array[index] = right[rightPointer];
				rightPointer++;
				index++;
			}
		}
		
		//This loop prints out the sorted array.
		for (int m = 0; m < array.length; m++)
		{
			System.out.print(array[m] + " ");
		}
	}
}