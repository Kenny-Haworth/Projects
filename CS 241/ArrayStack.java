import java.util.*;

public final class ArrayStack<T>
{
	private final T[] stack;
	private int counter;
	private final int ARRAY_SIZE = 100;
	
	public ArrayStack()
	{
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[ARRAY_SIZE];
		stack = tempStack;
		counter = 0;
	}
	
	
	/** Adds a new entry to the top of this stack.
		@param newEntry  An object to be added to the stack. */
	public void push(T newEntry)
	{
		if (counter >= ARRAY_SIZE)
		{
			System.out.println("You cannot add anything else to this stack! It is full!");
		}
		else
		{
			stack[counter] = newEntry;
			counter++;
		}
	}
	
	/** Removes and returns this stack's top entry.
		@return  The object at the top of the stack. 
		@throws  EmptyStackException if the stack is empty before the operation. */
	public T pop()
	{
		if (isEmpty())
		{
			System.out.println("There is nothing in this stack to remove!");
			throw new EmptyStackException();
		}
		else
		{
			T item = stack[counter - 1];
			stack[counter - 1] = null;
			counter--;
			return item;
		}
	}
	
    /** Retrieves this stack's top entry.
       @return  The object at the top of the stack.
       @throws  EmptyStackException if the stack is empty. */
	public T peek()
	{
		if (isEmpty())
		{
			System.out.println("There is nothing in this stack to look at!");
			throw new EmptyStackException();
		}
		else
		{
			T item = stack[counter - 1];
			return item;
		}
	}
	
    /** Detects whether this stack is empty.
       @return  True if the stack is empty. */	
	public boolean isEmpty()
	{
		return (counter == 0);
	}
	public void clear()
	{
		for (int q = counter - 1; q >= 0; q --)
		{
			stack[q] = null;
		}
		counter = 0;
	}
}