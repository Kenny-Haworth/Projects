//AN ITERATIVE VERSION OF MEDIAN OF MEDIANS
		
System.out.print("Array before sorting partitions: ");
for (int i = 0; i < (rightPointer-leftPointer)+1; i++)
{
	System.out.print(array[leftPointer+i] + " ");
}
System.out.println();

int partitionSize = 5;
int numberOfPartitions = (rightPointer-leftPointer+1)/partitionSize;

//sort each partition using insertion sort
for (int i = 0; i < numberOfPartitions; i++)
{
	for (int r = (partitionSize*i) + leftPointer; r < (partitionSize*(i+1)) + leftPointer; r++)
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
}

System.out.print("Array after sorting partitions: ");
for (int i = 0; i < (rightPointer-leftPointer)+1; i++)
{
	System.out.print(array[leftPointer+i] + " ");
}
System.out.println();

//perform insertion sort on the middle of each partition
for (int r = 1; r < numberOfPartitions; r++)
{
	for (int w = r; w > 0; w--)
	{
		if (array[(partitionSize/2) + (w*partitionSize)] < array[(partitionSize/2) + ((w-1)*partitionSize)]) //If the element is less than the element in front of it, swap them.
		{
			int temp = array[(partitionSize/2) + ((w-1)*partitionSize)];
			array[(partitionSize/2) + ((w-1)*partitionSize)] = array[(partitionSize/2) + (w*partitionSize)];
			array[(partitionSize/2) + (w*partitionSize)] = temp;
		}
		else 		//If it's greater than or equal to the element in front of it,
		{			//it is sorted up to that element and can break out of the second for loop.
			break;
		}
	}
}

return (partitionSize*((numberOfPartitions)/2)) + (partitionSize/2) - 1;

//A RECURSIVE VERSION OF MEDIAN OF MEDIANS USING QUICKSORT

		if ((rightPointer-leftPointer) <= 5)
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
			
			return (leftPointer+rightPointer)/2;
		}

		int incrementalOffset = (rightPointer-leftPointer+1)/5;
		int startingOffset = incrementalOffset/2;
		
		//split the array into 5 partitions and sort those partitions
		for (int i = 0; i < 5; i++)
		{
			medianOfMedians(array, leftPointer + (i*incrementalOffset), leftPointer + ((i+1)*incrementalOffset) - 1, k);
		}
		
		//perform insertion sort on the 5 middle points of each partition to find the median of medians
		for (int i = 1; i < 5; i++)
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
		
		return leftPointer + (2*incrementalOffset) + startingOffset;
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
		if ((rightPointer-leftPointer) <= 5)
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
			
			return (leftPointer+rightPointer)/2;
		}
		
		int numSublists = (rightPointer-leftPointer+1)/5;
		int[] medianArray = new int[numSublists];
		int[] medianArrayCopy = new int[numSublists];
		
		for (int i = 0; i < numSublists; i++)
		{
			int location = medianOfMedians(array, leftPointer + (5*i), leftPointer + (5*(i+1)) - 1, k);
			medianArray[i] = array[location];
			medianArrayCopy[i] = array[location];
		}
		
		/**System.out.print("Median array: ");
		for (int i = 0; i < medianArray.length; i++)
		{
			System.out.print(medianArray[i] + " ");
		}
		System.out.println();*/
		
		//int pivotLocation = medianOfMedians(medianArray, 0, medianArray.length-1);
		
		/**int i;
		for (i = 0; i < array.length; i++)
		{
			if (medianArray[pivotLocation] == medianArrayCopy[i])
			{
				break;
			}
		}*/

		//System.out.println("Returning the value of " + array[(pivotLocation+3)+(pivotLocation*3)]);
		return quickSort(medianArray, 0, medianArray.length-1, k);