/**
	Algorithm 1, Merge Sort
	
	@author Kendall Haworth
*/

public class algorithm1
{
	/**
		@param array The array to be sorted.
		@param first The front pointer of the array.
		@param last The back pointer of the array.
	*/
	public void mergeSort(int[] array, int first, int last)
	{
		if (first < last) //If the array has more than one element, split it up more.
		{
			int midpoint = (first + last)/2;
			mergeSort(array, first, midpoint); //The left half of the array to be split up more
			mergeSort(array, midpoint+1, last); //The right half of the array to be split up more
			merge(array, first, midpoint, last); //Merge the array together
		}
	}
	
	/**
		@param array The array to be sorted.
		@param first The front pointer of the array.
		@param midpoint The middle pointer of the array.
		@param last The back pointer of the array.
	*/
	public void merge(int[] array, int first, int midpoint, int last)
	{
		int firstHalf = midpoint - first + 1; //Define the size of the left half
		int secondHalf = last - midpoint; //Define the size of the right half
		
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
	
		//create two pointers to keep track of the data read
		int leftPointer = 0;
		int rightPointer = 0;
		int index = first; //begin reading data at the beginning
		
		while(leftPointer < firstHalf && rightPointer < secondHalf) //Loops as long as there are more elements to sort
		{
			if(left[leftPointer] <= right[rightPointer]) //If the left element is less than the right element,
			{											 //add the left element to the array and increment the left pointer
				array[index++] = left[leftPointer++];
			}
			else //left[leftPointer] > right[rightPointer]	//If the right element is less than the left element,
			{												//add the right element to the array and increment the right pointer
				array[index++] = right[rightPointer++];
			}
		}
	
		while(leftPointer < firstHalf) //If there are more elements in the left side, add them to the array
		{
			array[index++] = left[leftPointer++];
		}
	
		while(rightPointer < secondHalf) //If there are more elements in the right side, add them to the array
		{
			array[index++] = right[rightPointer++];
		}
	}
}