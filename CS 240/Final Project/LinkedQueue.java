/**
	An ADT Queue implemented using
	singly-linked nodes.
	
	@author Kendall Haworth
	@version 1.0
*/

public final class LinkedQueue<T> implements QueueInterface<T>
{
	private Node<T> front;
	private Node<T> back;
	private Node<T> root;
	
	public LinkedQueue()
	{
		front = null;
		back = null;
		root = null;
	}
	
	/** Adds a new entry to the back of this queue.
		@param newEntry  An object to be added. */
	public void enqueue(T newEntry)
	{
		if (back == null)
		{
			Node<T> newNode = new Node<T>(newEntry);
			newNode.setNext(root);
			back = newNode;
			front = newNode;
		}
		else
		{
			Node<T> newNode = new Node<T>(newEntry);
			newNode.setNext(back);
			back = newNode;
		}
		//System.out.println(newEntry + " has been added to the queue.");
	}
  
	/** Removes and returns the entry at the front of this queue.
		@return  The object at the front of the queue. 
		@throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() throws EmptyQueueException
	{
		if (isEmpty())
		{
			System.out.println("There is nothing to remove from this queue!");
			throw new EmptyQueueException();
		}
		
		if (back.getNext() == null)
		{
			T item = back.getData();
			back = null;
			front = null;
			return item;
		}
		else
		{
			Node<T> current = back;
			while (current.getNext() != front)
			{
				current = current.getNext();
			}
			T data = current.getNext().getData();
			current.setNext(root);
			front = current;
			
			return data;
		}
	}
  
	/**  Retrieves the entry at the front of this queue.
		@return  The object at the front of the queue.
		@throws  EmptyQueueException if the queue is empty. */
	public T getFront() throws EmptyQueueException
	{
		if (isEmpty())
		{
			throw new EmptyQueueException("There is nothing in this queue to look at!");
		}
		
		return front.getData();
	}
  
	/** Detects whether this queue is empty.
		@return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty()
	{
		return back == null;
	}
  
	/** Removes all entries from this queue. */
	public void clear()
	{
		front = null;
		back = null;
		root = null;
	}
}