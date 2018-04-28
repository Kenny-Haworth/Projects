/**
	An Interface of an ADT SORTED LIST
	
	@author Kendall Haworth
	@version 1.0
*/

public interface SortedListInterface<T>
{
	/**	Add an entry to the end of the list.
		The list size will be increased by 1.
		Other item positions will be affected based upon
		the position it is sorted into the list, based upon comparable.
		@param item The Object to be added.
	*/
	public void add(T item);
	
	/**
		Remove an entry from the specified position of the list.
		The list size will be decreased by 1.
		Other item positions below the specified index position will be effected.
		@param position The location of the item to be removed.
		@throws IndexOutOfBoundsException if the specified index is not part of the list.
	*/
	public void remove(int position);
	
	/**
		Replaces an entry in the list at the specified position with the specified item.
		@param position The position to replace an item in the list.
		@param item The item to replace it with.
	*/
	public void replace(int position, T item);
	
	/**
		Returns an item based on the specified position in the list.
		The items in the list will not be effected.
		@param position The location of the item on the list to be returned.
		@return T The item at the specified position in the list.
	*/
	public T view(int position);
	
	/**
		Removes all items from the list.
	*/
	public void clear();
	
	/**
		Determines whether the received item is in the list.
		@param item The item to see if the list contains.
		@return boolean True if the item is there, false if it is not.
	*/
	public boolean contains(T item);
	
	/**
		Determines the length of the list.
		@return int The length of the list.
	*/
	public int getLength();
	
	/**
		Determines if the list is empty.
		@return boolean True if the list is empty, false if it is not.
	*/
	public boolean isEmpty();
	
	/**
		Prints the list out.
	*/
	public void toArray();
}