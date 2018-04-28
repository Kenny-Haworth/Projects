/**
	An ADT Sorted list implemented
	using doubly-linked nodes.
	@author Kendall Haworth
	@version 1.0
*/

public class DLNodeSortedList<T> extends DLNodeList<T> implements SortedListInterface<T>
{
	/**	Add an entry to the end of the list.
		The list size will be increased by 1.
		Other item positions will be affected based upon
		the position it is sorted into the list, based upon comparable.
		@param item The Object to be added.
	*/
	public void add(T item)
	{
		DLNode<T> newNode = new DLNode<T>(item);
		
		if (root == null) //If there are no nodes, the new node is the root node
		{
			root = newNode;
		}
		else
		{
			DLNode<T> temp = root;
			while (temp.getNext() != null) //iterate until the end of the list is reached
			{
				temp = temp.getNext();
			}
			temp.setNext(newNode); //the last node is linked to the new node
			newNode.setPrevious(temp); //the new node is linked back to the last node
		}
	}
}