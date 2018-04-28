import java.util.*;

public final class VectorStack<T> implements StackInterface<T>
{
	Vector<T> stack;
	
	public VectorStack()
	{
		stack = new Vector<T>();
	}
	
	/** Adds a new entry to the top of this stack.
		@param newEntry  An object to be added to the stack. */
	public void push(T newEntry)
	{
		stack.add(newEntry);
		//System.out.println(newEntry + " has been added to the stack.");
	}
  
	/** Removes and returns this stack's top entry.
		@return  The object at the top of the stack. 
		@throws  EmptyStackException if the stack is empty before the operation. */
	public T pop()
	{
		if (isEmpty())
		{
			System.out.println("There is nothing in this vector to remove!");
			throw new EmptyStackException();
		}
		
		T item = stack.lastElement();
		stack.remove(stack.size()-1);
		return item;
	}
  
	/** Retrieves this stack's top entry.
		@return  The object at the top of the stack.
		@throws  EmptyStackException if the stack is empty. */
	public T peek()
	{
		if (isEmpty())
		{
			System.out.println("There is nothing in this vector to look at!");
			throw new EmptyStackException();
		}
		
		T item = stack.lastElement();
		return item;
	}
  
    /** Detects whether this stack is empty.
		@return  True if the stack is empty. */
    public boolean isEmpty()
	{
		return (stack.isEmpty());
	}
  
    /** Removes all entries from this stack. */
    public void clear()
	{
		stack.removeAllElements();
	}
	
	public Iterator<T> getStackIterator()
	{
		VectorStack<T> temp = new VectorStack<T>();
		VectorStack<T> temp2 = new VectorStack<T>();
		
		while(!this.isEmpty())
		{
			temp.push(this.pop());
		}
		
		while(!temp.isEmpty())
		{
			T data = temp.pop();
			this.push(data);
			temp2.push(data);
		}
		
		Iterator<T> iter = new Iterator<T>()
		{
			public boolean hasNext()
			{
				return !temp2.isEmpty();
			}
			
			public T next()
			{
				return temp2.pop();
			}
			
			public void remove()
			{
				//stubs, unsupported operation
			}
		};
		return iter;
	}
}