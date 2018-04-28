/**
	An ADT unsorted list implemented
	using doubly-linked nodes.
	@author Kendall Haworth
	@version 1.0
*/

public class DLNodeList<T> implements ListInterface<T>
{
	DLNode<T> root;
	
	public DLNodeList()
	{
		root = null;
	}
	
	/**	Add an entry to the end of the list.
		The list size will be increased by 1.
		Other item positions will be unaffected.
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
	
	/**	Add an entry to the specified position of the list.
		The list size will be increased by 1.
		Other item positions at or below specified index position will be effected.
		@param position The location the item should be placed in the list.
		@param item The Object to be added.
		@throws IndexOutOfBoundsException if either the postion < 1 or position > getLength()
	*/
	public void add(int position, T item)
	{
		DLNode<T> newNode = new DLNode<T>(item);
		DLNode<T> temp = root;
		int count = 1;
		
		if (position == 1) //if adding to the beginning of the list, the new root node is the new node
		{
			newNode.setNext(root);
			root.setPrevious(newNode);
			root = newNode;
		}
		else
		{
			while (count < position-1) //iterate until you reach the node before what you want to insert
			{
				temp = temp.getNext();
				count++;
			}
			DLNode<T> current = temp.getNext();
		
			temp.setNext(newNode); //rearrange the links: temp is before new node and current is after new node
			newNode.setNext(current);
			newNode.setPrevious(temp);
			current.setPrevious(newNode);
		}
	}
	
	/**
		Remove an entry from the specified position of the list.
		The list size will be decreased by 1.
		Other item positions below the specified index position will be effected.
		@param position The location of the item to be removed.
		@throws IndexOutOfBoundsException if the specified index is not part of the list.
	*/
	public void remove(int position)
	{
		DLNode<T> temp = root;
		
		if (position > getLength() || position < 1) //if position is greater than the number of nodes or less than 1, throw an error
		{
			throw new IndexOutOfBoundsException("That position does not exist on this list!");
		}
		else
		{	
			if (position == 1) //if removing the root node, set the root node equal to the next node
			{
				root = root.getNext();
			}
			else
			{
				int count = 1;
				DLNode<T> temp2 = root;
				while(count != position - 1) //iterate until the node before the desired node to be removed is found
				{
					temp2 = temp2.getNext();
					count++;
				}
				
				if (temp2.getNext().getNext() == null) //If the node to be removed is the last node in the list, unlink it
				{
					temp2.setNext(null);
				}
				else
				{
					DLNode<T> before = temp2;
					temp2 = temp2.getNext().getNext(); //find the node after the desired node to be removed
					before.setNext(temp2); 		//link the node before the node to be removed to the node after the node to be removed,
					temp2.setPrevious(before);	//which dereferences the node to be removed
				}
			}
		}
	}
	
	/**
		Replaces an entry in the list at the specified position with the specified item.
		@param position The position to replace an item in the list.
		@param item The item to replace it with.
	*/
	public void replace(int position, T item)
	{
		DLNode<T> temp = root;
		int count = 1;
		
		while (count < position) //iterate until count equals position
		{
			temp = temp.getNext();
			count++;
		}
		temp.setData(item); //replace the data in the node with the desired item
	}
	
	/**
		Returns an item based on the specified position in the list.
		The items in the list will not be effected.
		@param position The location of the item on the list to be returned.
		@return T The item at the specified position in the list.
	*/
	public T view(int position)
	{
		DLNode<T> temp = root;
		int count = 1;
		while (count < position) //iterate until count equals position
		{
			temp = temp.getNext();
			count++;
		}
		return temp.getData();
	}
	
	/**
		Removes all items from the list.
	*/
	public void clear()
	{
		root = null;
	}
	
	/**
		Determines whether the received item is in the list.
		@param item The item to see if the list contains.
		@return boolean True if the item is there, false if it is not.
	*/
	public boolean contains(T item)
	{
		DLNode<T> temp = root;
		
		if (temp.getData().equals(item)) //The root node must be checked for equality before moving to the next node
		{
			return true;
		}
		
		while (temp.getNext() != null) //compares the data between each node in the list and the item to be compared
		{
			temp = temp.getNext();
			if (temp.getData().equals(item)) //if there the same, the item is in the list
			{
				return true;
			}
		}
		return false; //If the item was never found, it is not in the list
	}
	
	/**
		Determines the length of the list.
		@return int The length of the list.
	*/
	public int getLength()
	{
		int count = 1; //we begin with 1 node, since we start at the root node, which is node 1
		DLNode<T> temp = root;
		
		if (root == null) //if there are no items, the length is 0
		{
			return 0;
		}
		
		while (temp.getNext() != null) //for every additional node, increase count by one until there are no nodes left
		{
			temp = temp.getNext();
			count++;
		}
		return count;
	}
	
	/**
		Determines if the list is empty.
		@return boolean True if the list is empty, false if it is not.
	*/
	public boolean isEmpty()
	{
		return root == null;
	}
	
	/**
		Prints the list out.
	*/
	public void toArray()
	{
		if (!isEmpty()) //only print if there is at least one item in the list
		{
			int i = 1;
			DLNode<T> temp = root;
			System.out.println("\t" + i++ + ") " + temp.getData());
			
			if (root.getNext() != null) //If there's only one item in the list, print only that item out
			{
				do
				{
					temp = temp.getNext();
					System.out.println("\t" + i++ + ") " + temp.getData());
				}
				while(temp.getNext() != null); //continue as long as there are more nodes to print
			}
		}
		else
		{
			System.out.println("There is nothing in this list to print out!");
		}
	}
}