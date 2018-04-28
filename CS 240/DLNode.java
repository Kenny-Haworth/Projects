public class DLNode<T>
{
	private T data;
	private DLNode<T> previous;
	private DLNode<T> next;
	
	public DLNode(T data, DLNode<T> previous, DLNode<T> next)
	{
		this.data = data;
		this.previous = previous;
		this.next = next;
	}
	
	public DLNode(T data)
	{
		this.data = data;
		this.previous = null;
		this.next = null;
	}
	
	public T getData()
	{
		return data;
	}
	
	public DLNode<T> getNext()
	{
		return next;
	}
	
	public DLNode<T> getPrevious()
	{
		return previous;
	}
	
	public void setData(T newData)
	{
		data = newData;
	}
	
	public void setNext(DLNode<T> nextNode)
	{
		next = nextNode;
	}
	
	public void setPrevious(DLNode<T> previousNode)
	{
		previous = previousNode;
	}
}