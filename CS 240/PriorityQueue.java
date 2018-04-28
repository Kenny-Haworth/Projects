/**
	An ADT Priority Queue implemented using
	singly-linked nodes.
	@author Kendall Haworth
	@version 1.0
*/

public class PriorityQueue<T extends Comparable<T>> implements PriorityQueueInterface<T>
{
	private Node<T> root;
	
	public PriorityQueue()
	{
		root = null;
	}
	
	/** Adds a new entry to this priority queue.
	@param newEntry  An object to be added. */
	public void add(T newEntry)
	{
		if (root == null) //If there are no nodes, nothing needs to be compared.
		{
			Node<T> newNode = new Node<T>(newEntry);
			root = newNode;
		}
		else
		{
			Node<T> newNode = new Node<T>(newEntry);
			
			if (newNode.compareTo(root) <= 0) //If the new node is smallest, it becomes the new root node
			{
				newNode.setNext(root);
				root = newNode;
			}
			else
			{
				Node<T> temp = root;
				
				while (temp.getNext() != null && newNode.compareTo(temp.getNext()) >= 0) //iterates until it is in the proper sorted positon
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

	/** Removes and returns the entry having the highest priority.
	@return  Either the object having the highest priority or,
	if the priority queue is empty before the operation, null. */
	public T remove()
	{
		if (isEmpty())
		{
			System.out.println("There is nothing to remove from this priority queue!");
		}
		else
		{
			if (root.getNext() == null) //if there's only one node, the root node is removed
			{
				T item = root.getData();
				root = null;
				return item;
			}
			else //if there's more than one node, remove the root node and set the next node as the root node
			{
				T data = root.getData();
				Node<T> temp = root;
				root = root.getNext();
				temp.setData(null);
				
				return data;
			}
		}
		return null;
	}

	/** Retrieves the entry having the highest priority.
	@return  Either the object having the highest priority or,
	if the priority queue is empty, null. */
	public T peek()
	{
		if (!isEmpty())
		{
			return root.getData(); //root is the front of the queue
		}
		
		return null;
	}

	/** Detects whether this priority queue is empty.
	@return  True if the priority queue is empty, or false otherwise. */
	public boolean isEmpty()
	{
		return root == null;
	}

	/** Gets the size of this priority queue.
	@return  The number of entries currently in the priority queue. */
	public int getSize()
	{
		if (!isEmpty()) //if its empty, there are 0 nodes
		{
			int count = 1; //if the root node is the only node, there is only 1 node
			Node<T> current = root;
			while (current.getNext() != null) //count down the line of nodes
			{
				current = current.getNext();
				count++;
			}
			return count;
		}
		
		return 0;
	}

	/** Removes all entries from this priority queue. */
	public void clear()
	{
		root = null;
	}
}