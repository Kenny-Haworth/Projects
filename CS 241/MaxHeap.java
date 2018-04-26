/**
	@author Kendall Haworth
	
	Max Heap ADT for CS 241-02
*/

public class MaxHeap
{
	int[] array; //an array to hold the max heap
	int lastIndex; //holds the index of the first empty cell in the array
	
	public MaxHeap()
	{
		array = new int[101]; //initial size of the array
		lastIndex = 1; //initial first empty cell
	}
	
	/**
		Adds the given data to the max heap by adding the data in
		as a leaf and then rebalancing the tree if necessary.
		
		@param data The data to be added to the tree
		@return int The number of swaps on the data between parent and child
	*/
	public int add(int data)
	{
		int swaps = 0;
		int newIndex = lastIndex;
		int parentIndex = newIndex/2;
		
		//swap parent and child if necessary, working up the max heap to the root until a spot is found
		while (data > array[parentIndex] && parentIndex != 0)
		{	
			array[newIndex] = array[parentIndex];
			newIndex = parentIndex;
			parentIndex = newIndex/2;
			swaps++; //keep track of how many swaps are performed
		}
		
		array[newIndex] = data; //when the spot is found, insert the data
		lastIndex++; //increment last available open cell
		return swaps; //return number of swaps
	}
	
	/**
		Adds the data to the max heap using the optimal method.
		Does not sort the data until reheap() is called.
		
		@param data The data to be added to the tree
	*/
	public void addOptimal(int data)
	{
		array[lastIndex++] = data;
	}
	
	/**
		Calls the overloaded version of reheap() with the last
		cell in the array with data
		
		@return int The number of swaps performed during reheaping
	*/
	public int reheap()
	{
		return reheap(lastIndex-1);
	}
	
	/**
		Recursively performs reheap on the max heap
		
		@param lastIndex The last cell in the array with data that has not been sorted
		@return int The number of swaps performed during reheap()
	*/
	private int reheap(int lastIndex)
	{
		if (lastIndex == 0) //base case, root has been reached
		{
			return 0;
		}
		else
		{
			int newIndex = lastIndex; //make a copy of lastIndex
			int parentIndex = newIndex/2;
			int swaps = 0; //keep track of number of swaps
			
			//swap parent and child if necessary, working up the max heap to the root until a spot is found
			while (array[newIndex] > array[parentIndex] && newIndex != 1)
			{
				int data = array[newIndex];
				array[newIndex] = array[parentIndex];
				array[parentIndex] = data;
				newIndex = parentIndex;
				parentIndex = newIndex/2;
				swaps++;
			}
			
			//call reheap to sort the next cell, keeping track of the number of swaps
			return swaps + reheap(--lastIndex);
		}
	}
	
	/**
		Removes the largest number from the max heap, the root
	*/
	public void remove()
	{
		array[1] = array[lastIndex-1]; //swap the root with the last leaf
		array[lastIndex-1] = 0;
		
		int parent = 1; //perform a down-heap operation; begin at the root and move down
		int child = parent*2;
		
		//swap parent and largest child as long as the child is larger than the parent and the child isn't out of bounds
		while (child < lastIndex-1 && (array[child] > array[parent] || array[child+1] > array[parent]))
		{
			int data = array[parent];
			
			if (array[child] > array[child+1]) //swap parent with left child
			{
				array[parent] = array[child];
				array[child] = data;
				parent = child; //reset the parent
			}
			else //array[child+1] > array[child] //swap parent with right child
			{
				array[parent] = array[child+1];
				array[child+1] = data;
				parent = child+1; //reset the parent
			}
			
			child = parent*2; //reset the child
		}
		lastIndex--; //decrement last index of first empty cell
	}
	
	/**
		Prints out the array from beginning to end
	*/
	public void print()
	{
		for (int i = 1; i < lastIndex; i++) //begin at 1, the root node, and go to lastIndex
		{
			if (i == lastIndex-1) //no comma in print statement if it's the last node
			{
				System.out.print(array[i]);
			}
			else
			{
				if (array[i] != 0)
				{
					System.out.print(array[i] + ", ");
				}
			}
		}
	}
}