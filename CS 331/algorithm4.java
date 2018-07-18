/**
	Algorithm 4, Quick Sort Recursive with MM (median of medians)
	
	@author Kendall Haworth
*/

public class algorithm4
{
	/**
		@param array The array to search for the kth element.
		@param k The kth element to find.
		@return The kth element in the array.
	*/
	public int quickSortRecursive(int[] array, int k) //call quickSort with the starting pointers
	{
		return quickSort(array, 0, array.length - 1, k);
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
			//call medianOfMedians to find the best pivot location
			int pivotLocation = medianOfMedians(array, leftPointer, rightPointer);
			int pivot = array[pivotLocation];
			
			//move pivot to the end of the array
			int temp = array[rightPointer];
			array[rightPointer] = array[pivotLocation];
			array[pivotLocation] = temp;
			
			int index = leftPointer - 1; //set starting index
			int q = leftPointer; //save the leftPointer's position
			
			//swap elements about the pivot for the portion of the array to be sorted
			while (q != rightPointer)
			{
				if (array[q] <= pivot) //Swap elements if they are less than the pivot.
				{
					index++;
					
					//Small optimization technique. If the elements are the same, because the
					//medianOfMedians method already sorted them, then time does not need to be
					//wasted swapping them
					if (!(array[index] == array[q]))
					{
						temp = array[index];
						array[index] = array[q];
						array[q] = temp;
					}
				}
				
				q++; //increment the leftPointer dummy variable
			}
			
			//Swap the first element greater than the pivot with the pivot
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
	
	/**
		@param array The array to search for the kth element.
		@param leftPointer The front pointer of the array.
		@param rightPointer The back pointer of the array.
		@return The median of medians position in the array.
	*/
	public int medianOfMedians(int[] array, int leftPointer, int rightPointer)
	{
		//base case, once there are 1 or less elements in the array's subsection, simply sort the elements and return the midpoint
		if ((rightPointer-leftPointer) <= 1)
		{
			//perform an insertion sort
			for (int r = leftPointer+1; r < rightPointer+1; r++)
			{
				for (int w = r; w > 0; w--)
				{
					if (array[w] < array[w-1]) //If the element is less than the element in front of it, swap them.
					{
						int temp = array[w-1];
						array[w-1] = array[w];
						array[w] = temp;
					}
					else 		//If it's greater than or equal to the element in front of it,
					{			//it is sorted up to that element and can break out of the second for loop.
						break;
					}
				}
			}
			
			return (leftPointer+rightPointer)/2; //return the midpoint of the sorted subsection of the array
		}
		
		/**
			The offset is the number of partitions, set to 5 for each array.
			
			The incrementalOffset is the number of elements in each partition,
			so for an array size of 100, 100/(offset = 5) will be 20 elements
			in each partition.
			
			The startingOffset is the middle point of each partition, so for
			an array size of 100 where we have 5 partitions with 20 elements each,
			the midpoint of each partition will be 20/2 = 10 or the 10th element.
		*/
		int offset = 5;
		int incrementalOffset = (rightPointer-leftPointer+1)/offset;
		int startingOffset = incrementalOffset/2;
		
		//split the array into 5 partitions and sort those partitions
		for (int i = 0; i < offset; i++)
		{
			medianOfMedians(array, leftPointer + (i*incrementalOffset), leftPointer + ((i+1)*incrementalOffset) - 1);
		}
		
		//perform insertion sort on the middle points of each partition to find the median of medians
		for (int i = 1; i < offset; i++)
		{
			for (int w = i; w > 0; w--)
			{
				//If the element is less than the element in front of it, swap them.
				if (array[leftPointer + (w*incrementalOffset) + startingOffset] < array[leftPointer + ((w-1)*incrementalOffset) + startingOffset])
				{
					int temp = array[leftPointer + ((w-1)*incrementalOffset) + startingOffset];
					array[leftPointer + ((w-1)*incrementalOffset) + startingOffset] = array[leftPointer + (w*incrementalOffset) + startingOffset];
					array[leftPointer + (w*incrementalOffset) + startingOffset] = temp;
				}
				else 		//If it's greater than or equal to the element in front of it,
				{			//it is sorted up to that element and can break out of the second for loop.
					break;
				}
			}
		}
		
		//return the position of the median of medians in the array
		return leftPointer + (2*incrementalOffset) + startingOffset;
	}
}