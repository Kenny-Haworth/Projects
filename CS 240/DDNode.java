/**
	A node class that contains two pieces of data,
	a key and a value, and one address.
	
	@author Kendall Haworth
	@version 1.0
*/

public class DDNode<K, V>
{
	private K key;
	private V value;
	private DDNode<K, V> next;
	
	public DDNode(K key, V value, DDNode<K, V> next)
	{
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	public DDNode(K key, V value)
	{
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
	public K getKey()
	{
		return key;
	}
	
	public V getValue()
	{
		return value;
	}
	
	public DDNode<K, V> getNext()
	{
		return next;
	}
	
	public void setKey(K newKey)
	{
		key = newKey;
	}
	
	public void setValue(V newValue)
	{
		value = newValue;
	}
	
	public void setNext(DDNode<K, V> nextNode)
	{
		next = nextNode;
	}
}