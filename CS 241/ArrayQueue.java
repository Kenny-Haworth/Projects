import java.util.*;

public final class ArrayQueue<T>
{
	private T[] array;
	private final int ARRAY_SIZE = 100;
	int front;
	int back;
	
	public ArrayQueue()
	{
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[ARRAY_SIZE];
		array = tempStack;
		front = 0;
		back = 0;
	}
		
	/** Adds a new entry to the back of this queue.
		@param newEntry  An object to be added. */
	public void enqueue(T newEntry)
	{
		if (isFull())
		{
			System.out.println("The queue is full! You cannot add anything else!");
		}
		else
		{
			array[back] = newEntry;
			//System.out.println(newEntry + " has been added to the queue.");
			
			back++;
			
			if (back == array.length)
			{
				back = 0;
			}
		}
	}
  
	/** Removes and returns the entry at the front of this queue.
		@return  The object at the front of the queue. 
		@throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() throws EmptyQueueException
	{
		T item = null;
		if (isEmpty())
		{
			throw new EmptyQueueException("The queue is empty! There is nothing to remove!");
		}
		
		item = array[front];
		array[front] = null;
		front++;
		
		if (front == array.length)
		{
				front = 0;
		}
		
		return item;
	}
  
	/**  Retrieves the entry at the front of this queue.
		@return  The object at the front of the queue.
		@throws  EmptyQueueException if the queue is empty. */
	public T getFront() throws EmptyQueueException
	{
		if (isEmpty())
		{
			throw new EmptyQueueException("There is nothing to look at in this queue!");
		}
	
		return array[front];
	}
  
	/** Detects whether this queue is empty.
		@return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty()
	{
		return (front == back && array[front] == null);
	}
  
	/** Removes all entries from this queue. */
	public void clear()
	{
		for (int q = 0; q < ARRAY_SIZE; q++)
		{
			array[q] = null;
		}
		front = 0;
		back = 0;
	}
	
	/** Detects whether this queue is full.
		@return True if the queue is full, or false otherwise. */
	private boolean isFull()
	{
		for (int p = 0; p < ARRAY_SIZE; p++)
		{
			if (array[p] == null)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public Iterator<T> getQueueIterator()
	{
		Iterator<T> iter = new Iterator<T>()
		{
			private int pointer = front-1;
			
			public boolean hasNext()
			{
				return pointer != back-1;
			}
			
			public T next()
			{
				pointer++;
				
				if (pointer == array.length)
				{
					pointer = 0;
				}
				
				return array[pointer];
			}
			
			public void remove()
			{
				//stubs, unsupported operation
			}
		};
		return iter;
	}
}