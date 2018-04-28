public final class CircularLinkedQueue<T> implements QueueInterface<T>
{
	private Node<T> free;
	private Node<T> back;
	private final int MAX_SIZE = 10;
	private int numOfNodes = 0;
	
	public CircularLinkedQueue()
	{
		free = new Node<T>(null, free);
		back = free;
	}
	
	/** Adds a new entry to the back of this queue.
		@param newEntry  An object to be added. */
	public void enqueue(T newEntry)
	{
		if (isFull())
		{
			System.out.println("There is no more room to make more nodes!");
		}
		else if (numOfNodes < 10 && emptyNodes())
		{
			Node<T> temp = free;
			while (temp.getNext().getData() != null)
			{
				temp = temp.getNext();
			}
			
			temp.setData(newEntry);
			back = temp;
			
			System.out.println(newEntry + " has been added to the queue.");
		}
		else if (numOfNodes < 10)
		{
			Node<T> newNode = new Node<T>(newEntry);
			newNode.setNext(back);
			free.setNext(newNode);
			back = newNode;
			numOfNodes++;
			System.out.println(newEntry + " has been added to the queue.");
		}
		else
		{
			Node<T> current = free;
			while(current.getNext() != back)
			{
				current = current.getNext();
			}
			
			current.setData(newEntry);
			back = current;
			System.out.println(newEntry + " has been added to the queue.");
		}
	}
  
	/** Removes and returns the entry at the front of this queue.
		@return  The object at the front of the queue. 
		@throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() throws EmptyQueueException
	{
		if (isEmpty())
		{
			System.out.println("There is nothing in this queue to remove!");
			throw new EmptyQueueException();
		}
		
		Node<T> current = back;
		while (current.getNext().getData() != null)
		{
			current = current.getNext();
		}
		T data = current.getData();
		
		
		T nodeData = null;
		T nextNodeData = null;
		Node<T> here = back;
		back = back.getNext();
		
		nodeData = here.getData();
		here.setData(null);
		
		int count = 2;
		
		while (here.getNext().getData() != null)
		{
			if (count % 2 == 0)
			{
				here = here.getNext();
				nextNodeData = here.getData();
				here.setData(nodeData);
			}
			else
			{
				here = here.getNext();
				nodeData = here.getData();
				here.setData(nextNodeData);
			}
			count++;
		}
		
		return data;
	}
  
	/**  Retrieves the entry at the front of this queue.
		@return  The object at the front of the queue.
		@throws  EmptyQueueException if the queue is empty. */
	public T getFront() throws EmptyQueueException
	{
		if (isEmpty())
		{
			System.out.println("There is nothing in this queue to look at!");
			throw new EmptyQueueException();
		}
		
		Node<T> current = back;
		while (current.getNext().getData() != null)
		{
			current = current.getNext();
		}
		
		return current.getData();
	}
  
	/** Detects whether this queue is empty.
		@return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty()
	{
		boolean empty = true;
		Node<T> temp = free;
		
		for (int q = 0; q < numOfNodes; q++)
		{
			temp = temp.getNext();
			if (temp.getData() != null)
			{
				empty = false;
			}
		}
		return empty;
	}
  
	/** Removes all entries from this queue. */
	public void clear()
	{
		Node<T> temp = free;
		for (int q = 0; q < numOfNodes; q++)
		{
			temp = temp.getNext();
			temp.setData(null);
		}
	}
	
	/** Determines whether there is more space to add more data.
		@return True if there is no space, false if there is not.*/
	private boolean isFull()
	{
		boolean full = true;
		Node<T> temp = free;
		
		for (int q = 0; q < numOfNodes; q++)
		{
			if (temp.getNext().getData() == null)
			{
				full = false;
			}
		}
		
		if (numOfNodes < 10)
		{
			full = false;
		}
		
		return full;
	}
	
	/**Determines if there are nodes created that are empty.
		@return True if there are empty nodes, false if there are not.*/
	private boolean emptyNodes()
	{
		boolean empty = false;
		Node<T> temp = free;
		
		for (int q = 0; q < numOfNodes; q++)
		{
			if (temp.getNext().getData() == null)
			{
				empty = true;
			}
		}
		
		return empty;
	}
}