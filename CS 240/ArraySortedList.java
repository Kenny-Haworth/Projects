/**
	An ADT Sorted List implemented using a fixed
	sized array of size 10 (not required for HW 3, did it anyways).
	@author Kendall Haworth
	@version 1.0
*/

public class ArraySortedList<T extends Comparable<T>> extends ArrayList<T> implements SortedListInterface<T>
{
	/**	Add an entry to the end of the list.
		The list size will be increased by 1.
		Other item positions will be affected based upon
		the position it is sorted into the list, based upon comparable.
		@param item The Object to be added.
	*/
	public void add(T item)
	{
		for (int i = 0; i < endOfList; i++)
		{
			if ()
		}
		endOfList++;
	}
}