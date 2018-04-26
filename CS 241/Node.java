/**
	An node implemented with generics and comparable
	for a priorty queue class.
	
	@author Kendall Haworth
	@version 1.0
*/

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>
{
	private T data;
	private Node<T> next;
	
	public Node(T data, Node<T> next)
	{
		this.data = data;
		this.next = next;
	}
	
	public Node(T data)
	{
		this.data = data;
		this.next = null;
	}
	
	public T getData()
	{
		return data;
	}
	
	public Node<T> getNext()
	{
		return next;
	}
	
	public void setData(T newData)
	{
		data = newData;
	}
	
	public void setNext(Node<T> nextNode)
	{
		next = nextNode;
	}
	
	public int compareTo(Node<T> other)
	{		
		return data.compareTo(other.data);
	}
}