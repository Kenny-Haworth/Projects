/**
	Algorithm 2, Quick Sort Iterative
	
	@author Kendall Haworth
*/

public class algorithm2
{
	/**
		@param array The array to search for the kth element.
		@param k The kth element to find.
		@return The kth element in the array.
	*/
	public int quickSortIterative(int[] array, int k)
	{
		//Define pointers and initial variables
		boolean finishedSorting = false;
		int leftPointer = 0;
		int rightPointer = array.length-1;
		int pivotPoint;
		int pivot;
		int index = 0;
		
		while (!finishedSorting) //Loops as long as k is not found
		{
			pivot = array[rightPointer]; //Rearrange the pivot and index
			index = leftPointer - 1;
		
			//swap elements about the pivot for the portion of the array to be sorted
			for (int q = leftPointer; q < rightPointer; q++)
			{
				if (array[q] <= pivot) //Swap elements if they are less than the pivot.
				{				
					int temp = array[++index];
					array[index] = array[q];
					array[q] = temp;
				}
			}
			
			//Swap the first element greater than the pivot with the pivot.
			array[rightPointer] = array[index + 1];
			array[index + 1] = pivot;
			pivotPoint = index + 1;
			
			if (pivotPoint == k) //if the pivot was the kth element, the algorithm is complete
			{
				finishedSorting = true;
			}
			else if (pivotPoint > k) //if the pivot was greater than the kth element, search the left side
			{
				rightPointer = pivotPoint - 1;
			}
			else //pivotPoint < k, if the pivot was less than the kth element, search the right side
			{
				leftPointer = pivotPoint + 1;
			}
		}
		
		return array[index+1]; //returns the kth element
	}
}