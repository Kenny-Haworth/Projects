/**
	A node class that has one address and one value.
	@author Kendall Haworth
	@version 1.0
*/

public class ValueNode<V>
{
	private V value;
	private ValueNode<V> nextValue;
	
	public ValueNode(V value)
	{
		this.value = value;
		this.nextValue = null;
	}
	
	public V getValue()
	{
		return value;
	}
	
	public ValueNode<V> getNextValue()
	{
		return nextValue;
	}
	
	public void setValue(V newValue)
	{
		value = newValue;
	}
	
	public void setNextValue(ValueNode<V> theNextValue)
	{
		nextValue = theNextValue;
	}
}