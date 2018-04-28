/**
	An ADT Sorted List implemented
	using singly-linked nodes.
	@author Kendall Haworth
	@version 1.0
*/

public class NodeSortedList<T extends Comparable<T>> extends NodeList<T> implements SortedListInterface<T>
{
	/**	Add an entry to the end of the list.
		The list size will be increased by 1.
		Other item positions will be affected based upon
		the position it is sorted into the list, based upon comparable.
		@param item The Object to be added.
	*/
	public void add(T item)
	{
		if (root == null) //If there are no nodes, nothing needs to be compared.
		{
			Node<T> newNode = new Node<T>(item);
			root = newNode;
		}
		else
		{
			Node<T> newNode = new Node<T>(item);
			
			if (newNode.compareTo(root) <= 0) //If the new node is smallest, it becomes the new root node
			{
				newNode.setNext(root);
				root = newNode;
			}
			else
			{
				Node<T> temp = root;
				
				while (temp.getNext() != null && newNode.compareTo(temp.getNext()) > 0) //iterates until it is in the proper sorted positon
				{																		//or the end of the nodes has been reached
					temp = temp.getNext();
				}
				
				if (temp.getNext() == null) //if it's at the end of the queue, just link the last node to the new node
				{
					temp.setNext(newNode);
				}
				else //if its between nodes, link the one before it to the new node and the the new node to the one after it
				{
					Node<T> temp2 = temp.getNext();
					temp.setNext(newNode);
					newNode.setNext(temp2);
				}
			}
		}
	}
}