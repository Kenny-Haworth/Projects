/**
	Algorithm 3, Quick Sort Recursive
	
	@author Kendall Haworth
*/

public class algorithm3
{
	/**
		@param array The array to search for the kth element.
		@param k The kth element to find.
		@return The kth element in the array.
	*/
	public int quickSortRecursive(int[] array, int k)
	{
		return quickSort(array, 0, array.length - 1, k); //call quickSort with the starting pointers
	}
	
	/**
		@param array The array to search for the kth element.
		@param leftPointer The front pointer of the array.
		@param rightPointer The back pointer of the array.
		@param k The kth element to find.
		@return The kth element in the array.
	*/
	public int quickSort(int[] array, int leftPointer, int rightPointer, int k)
	{
		//If the leftPointer is greater than or equal to the rightPointer, the portion to search
		//in the array is out of bounds. In practice, this is not actually needed, as the kth
		//value will always be found before the array runs out of bounds, even if it chooses
		//the kth value as the very last pivot.
		if (leftPointer < rightPointer)
		{
			int pivot = array[rightPointer]; //Rearrange the pivot and index
			int index = leftPointer - 1;
			int q = leftPointer; //save the leftPointer's position
			
			//swap elements about the pivot for the portion of the array to be sorted
			while (q != rightPointer)
			{
				if (array[q] <= pivot) //Swap elements if they are less than the pivot.
				{		
					int temp = array[++index];
					array[index] = array[q];
					array[q] = temp;
				}
				
				q++; //increment the leftPointer dummy variable
			}
			
			//Swap the first element greater than the pivot with the pivot.
			array[rightPointer] = array[index + 1];
			array[index + 1] = pivot;
			
			int pivotPoint = index + 1;
			
			if (pivotPoint == k) //if the pivot was the kth element, the algorithm is complete
			{
				return array[k];
			}
			else if (pivotPoint > k) //if the pivot was greater than the kth element, search the left side
			{
				quickSort(array, leftPointer, pivotPoint - 1, k); //left side of array to be sorted
			}
			else //pivotPoint < k, if the pivot was less than the kth element, search the right side
			{
				quickSort(array, pivotPoint + 1, rightPointer, k); //right side of array to be sorted
			}
		}
		
		return array[k]; //returns the kth element
	}
}