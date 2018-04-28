/**
	An ADT Stack implemented using
	singly-linked nodes.
	
	@author Kendall Haworth
	@version 1.0
*/

import java.util.*;

public final class NodeStack<T> implements StackInterface<T>
{
	Node<T> root;
	
	public NodeStack()
	{
		root = null;
	}
	
	/** Adds a new entry to the top of this stack.
		@param newEntry  An object to be added to the stack. */
	public void push(T newEntry)
	{
		if (root == null)
		{
			root = new Node<T>(newEntry);
		}
		else
		{
			Node<T> newNode = new Node<T>(newEntry);
			
			Node<T> current = getEnd();
			current.setNext(newNode);
		}
	}
  
	/** Removes and returns this stack's top entry.
		@return  The object at the top of the stack. 
		@throws  EmptyStackException if the stack is empty before the operation. */
	public T pop()
	{	
		if (isEmpty())
		{
			System.out.println("There is nothing to remove from this stack!");
			throw new EmptyStackException();
		}
		
		if (root.getNext() == null)
		{
			T item = root.getData();
			root = null;
			return item;
		}
		else
		{
			Node<T> secLast = root;
		
			while(secLast.getNext().getNext() != null)
			{
				secLast = secLast.getNext();
			}
		
			Node<T> last = secLast.getNext();
			secLast.setNext(null);
		
			return last.getData();
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
		
		Node<T> last = getEnd();
		return last.getData();
	}
  
    /** Detects whether this stack is empty.
		@return  True if the stack is empty. */
    public boolean isEmpty()
	{
		return (root == null);
	}
  
    /** Removes all entries from this stack. */
    public void clear()
	{
		root = null;
	}
	
	/**Retrieves the stack's last node, or the node on top of the stack.
		@return The node on top of the stack. */
	private Node<T> getEnd()
	{
		Node<T> current = root;
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		
		return current;
	}
}