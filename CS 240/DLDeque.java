/**
	A class implementing an ADT double-ended QUEUE using a doubly-linked node.
	@author Kendall Haworth
	@version 1.0
*/

public class DLDeque<T> implements DequeInterface<T>
{
	private DLNode<T> front;
	private DLNode<T> back;
	
	public DLDeque()
	{
		front = null;
		back = null;
	}
	
	/** Adds a new entry to the front/back of this dequeue.
		@param newEntry  An object to be added. */
	public void addToFront(T newEntry)
	{
		if (front == null)
		{
			DLNode<T> newNode = new DLNode<T>(newEntry);
			back = newNode;
			front = newNode;
		}
		else
		{
			DLNode<T> newNode = new DLNode<T>(newEntry);
			newNode.setPrevious(front);
			front.setNext(newNode);
			front = newNode;
		}
		System.out.println(newEntry + " has been added to the queue.");
	}
	
	public void addToBack(T newEntry)
	{
		if (back == null)
		{
			DLNode<T> newNode = new DLNode<T>(newEntry);
			back = newNode;
			front = newNode;
		}
		else
		{
			DLNode<T> newNode = new DLNode<T>(newEntry);
			newNode.setNext(back);
			back.setPrevious(newNode);
			back = newNode;
		}
	}
   
	/** Removes and returns the front/back entry of this dequeue.
		@return  The object at the front/back of the dequeue.
		@throws  EmptyQueueException if the dequeue is empty before the operation. */
	public T removeFront() throws EmptyQueueException
	{
		if (isEmpty())
		{
			System.out.println("There is nothing to remove from this queue!");
			throw new EmptyQueueException();
		}
		
		if (front == back)
		{
			T item = front.getData();
			front = null;
			back = null;
			return item;
		}
		else
		{
			T data = front.getData();
			front.setData(null);
			front.getPrevious().setNext(null);
			front = front.getPrevious();
			
			return data;
		}
	}
	
	public T removeBack() throws EmptyQueueException
	{
		if (isEmpty())
		{
			System.out.println("There is nothing to remove from this queue!");
			throw new EmptyQueueException();
		}
		
		if (front == back)
		{
			T item = back.getData();
			front = null;
			back = null;
			return item;
		}
		else
		{
			T data = back.getData();
			back.setData(null);
			back.getNext().setPrevious(null);
			back = back.getNext();
			
			return data;
		}
	}
   
	/** Retrieves the front/back entry of this dequeue.
		@return  The object at the front/back of the dequeue.
		@throws  EmptyQueueException if the dequeue is empty before the operation. */
	public T getFront() throws EmptyQueueException
	{
		if (isEmpty())
		{
			throw new EmptyQueueException("There is nothing in this queue to look at!");
		}
		
		return front.getData();
	}
	
	public T getBack() throws EmptyQueueException
	{
		if (isEmpty())
		{
			throw new EmptyQueueException("There is nothing in this queue to look at!");
		}
		
		return back.getData();
	}
   
	/*  Detects whether this dequeue is empty.
		@return  True if the dequeue is empty, or false otherwise. */
	public boolean isEmpty()
	{
		return (front == null && back == null);
	}
   
	/*  Removes all entries from this dequeue. */
	public void clear()
	{
		front = null;
		back = null;
	}
}