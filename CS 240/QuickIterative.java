/**
	A quick sort algorithm that uses iteration to
	sort an array from low numbers to high numbers.
	@author Kendall Haworth
*/

import java.util.Random;

public class QuickIterative
{
	public static void main(String[] args) throws EmptyQueueException
	{
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>(); //Creates a new linked queue
		
		int[] array = new int[10];
		
		Random randomObj = new Random();
		
		//This loop fills each element of the array with random numbers.
		for (int q = 0; q < array.length; q++)
		{
			array[q] = randomObj.nextInt(1000);
			System.out.print(array[q] + " ");
		}
		
		System.out.println();
		
		//Define initial pointer positions and variables
		int leftPointer = 0;
		int rightPointer = array.length - 1;
		boolean finishedSorting = false;
		int pivotPoint;
		int pivot;
		int index;
		
		while (!finishedSorting) //Loops as long as more sorting needs to be done
		{
			pivot = array[rightPointer]; //Rearrange the pivot and index
			index = leftPointer - 1;
		
			for (int q = leftPointer; q < rightPointer; q++)
			{
				if (array[q] <= pivot) //Swap elements if they are less than the pivot.
				{
					index++;
				
					int temp = array[index];
					array[index] = array[q];
					array[q] = temp;
				}
			}
			
			//Swap the first element greater than the pivot with the pivot.
			pivotPoint = index + 1;
			array[rightPointer] = array[index + 1];
			array[index + 1] = pivot;

			
			queue.enqueue(leftPointer); //Add the left partition to the queue
			queue.enqueue(pivotPoint - 1);
				

			queue.enqueue(pivotPoint + 1); //Add the right partition to the queue
			queue.enqueue(rightPointer);
			

			do
			{
				if (queue.isEmpty()) //When the queue is empty, there is nothing left to sort
				{
					finishedSorting = true;
				}
				else	//When the queue is not empty, there is more sorting to do
				{
					leftPointer = queue.dequeue();
					rightPointer = queue.dequeue();
				}
			}
			while (leftPointer >= rightPointer && !finishedSorting); 
			//If leftPointer >= rightPointer, this segment of the array does not need to be sorted further,
			//so the next two pointers should be pulled from the queue
		}
		
		//This loop prints out the sorted array.
		for (int m = 0; m < array.length; m++)
		{
			System.out.print(array[m] + " ");
		}
	}
}