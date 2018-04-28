/**
	A node class that has two addresses and one key.
	@author Kendall Haworth
	@version 1.0
*/

public class KeyNode<K, V>
{
	private K key;
	private KeyNode<K, V> nextKey;
	private ValueNode<V> thisValue;
	
	public KeyNode(K key)
	{
		this.key = key;
		this.nextKey = null;
		this.thisValue = null;
	}
	
	public KeyNode(K key, ValueNode<V> thisValue)
	{
		this.key = key;
		this.nextKey = null;
		this.thisValue = thisValue;
	}
	
	public K getKey()
	{
		return key;
	}
	
	public KeyNode<K, V> getNextKey()
	{
		return nextKey;
	}
	
	public ValueNode<V> getThisValue()
	{
		return thisValue;
	}
	
	public void setKey(K newKey)
	{
		key = newKey;
	}
	
	public void setNextKey(KeyNode<K, V> theNextKey)
	{
		nextKey = theNextKey;
	}
	
	public void setThisValue(ValueNode<V> theNextValue)
	{
		thisValue = theNextValue;
	}
}