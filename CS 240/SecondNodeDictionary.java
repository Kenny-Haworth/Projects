/**
	An ADT Dictionary implemented using
	singly-linked nodes with double-data (DDNodes).
	@author Kendall Haworth
	@version 1.0
*/
import java.util.Iterator;

public class NodeDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V>
{
	private KeyNode<K, V> root;
	
	public NodeDictionary()
	{
		root = null;
	}
	
	/** Adds a new entry to this dictionary. If the given search key already
		exists in the dictionary, replaces the corresponding value.
		@param key		An object search key of the new entry.
		@param value	An object associated with the search key.
		@return	Either null if the new entry was added to the dictionary
				or the value that was associated with key if that value
				was replaced. */
	public V add(K key, V value)
	{
		if (root == null) //If there are no nodes, nothing needs to be compared.
		{
			ValueNode<V> newValueNode = new ValueNode<V>(value);
			KeyNode<K, V> newKeyNode = new KeyNode<K, V>(key, newValueNode);
			root = newKeyNode;
		}
		else if (key.compareTo(root.getKey()) < 0) //If the new key is smaller than the root, it becomes the new root
		{
			ValueNode<V> newValueNode = new ValueNode<V>(value);
			KeyNode<K, V> newKeyNode = new KeyNode<K, V>(key, newValueNode);
			
			newKeyNode.setNextKey(root);
			newValueNode.setNextValue(root.getThisValue());
			root = newKeyNode;
		}
		else
		{
			KeyNode<K, V> temp = root;
			
			while(temp.getNextKey() != null && key.compareTo(temp.getKey()) > 0)
			{
				temp = temp.getNextKey();
			}
			
			if (key.compareTo(temp.getKey()) == 0) //if the keys are the same, change the value and return the old value
			{
				V thisValue = temp.getThisValue().getValue();
				temp.getThisValue().setValue(value);
				
				return thisValue;
			}
			else if (temp.getNextKey() == null && key.compareTo(temp.getKey()) > 0) //If it's being added as the last node, simply link it in
			{
				ValueNode<V> newValueNode = new ValueNode<V>(value);
				KeyNode<K, V> newKeyNode = new KeyNode<K, V>(key, newValueNode);
				temp.setNextKey(newKeyNode);
			}
			else //If it's being inserted between nodes, relink the node before it to the new node
			{
				temp = root;
			
				while (temp.getNextKey() != null && key.compareTo(temp.getNextKey().getKey()) > 0) //Iterates until the position to insert has been found
				{
					temp = temp.getNextKey();
				}
				
				ValueNode<V> newValueNode = new ValueNode<V>(value);
				KeyNode<K, V> newKeyNode = new KeyNode<K, V>(key, newValueNode);
				KeyNode<K, V> temp2 = temp.getNextKey();
				temp.setNextKey(newKeyNode);
				temp.getThisValue().setNextValue(newValueNode);
				newKeyNode.setNextKey(temp2);
				newKeyNode.getThisValue().setNextValue(temp2.getThisValue());
			}
		}
		
		return null;
	}

	/** Removes a specific entry from this dictionary.
		@param key	An object search key of the entry to be removed.
		@return		Either the value that was associated with the search key
				or null if no such object exists. */
	public V remove(K key)
	{
		if (key.equals(root.getKey())) //If the entry to be removed is the root, reset the root
		{
			V thisValue = root.getThisValue().getValue();
			
			KeyNode<K, V> temp = root;
			root = root.getNextKey();
			temp.getThisValue() = null;
			temp = null;
			
			return thisValue;
		}
		else
		{
			KeyNode<K, V> temp = root;
			
			while (temp.getNextKey() != null && !key.equals(temp.getNextKey().getKey())) //Iterates until the position to enter has been found
			{
				temp = temp.getNextKey();
			}
			
			if (temp.getNextKey() == null) //The key does not exist
			{
				return null;
			}
			else if (temp.getNextKey().getNextKey() == null) //The node to be removed is the last node
			{
				V thisValue = temp.getNextKey().getThisValue().getValue();
				temp.setNextKey(null);
				temp.getThisValue().setNextValue(null);
				return thisValue;
			}
			else //The node to be removed is inbetween nodes
			{
				V thisValue = temp.getNextKey().getThisValue().getValue();
				temp.setNextKey(temp.getNextKey().getNextKey());
				temp.getThisValue().setNextValue(temp.getNextKey().getThisValue());
				return thisValue;
			}
		}
	}

	/** Retrieves from this dictionary the value associated with a given
		search key.
		@param key	An object search key of the entry to be retrieved.
		@return	Either the value that is associated with the search key
				or null if no such object exists. */
	public V getValue(K key)
	{
		return null;
	}

	/** Sees whether a specific entry is in this dictionary.
		@param key  An object search key of the desired entry.
		@return  True if key is associated with an entry in the dictionary. */
	public boolean contains(K key)
	{
		return false;
	}
	
	/** Creates an iterator that traverses all search keys in this dictionary.
		@return	An iterator that provides sequential access to the search
				keys in the dictionary. */
	public Iterator<K> getKeyIterator()
	{
		return null;
	}
   
	/** Creates an iterator that traverses all values in this dictionary.
		@return	An iterator that provides sequential access to the values
		in this dictionary. */
	public Iterator<V> getValueIterator()
	{
		return null;
	}	
	
	/** Sees whether this dictionary is empty.
		@return  True if the dictionary is empty. */
	public boolean isEmpty()
	{
		return root == null;
	}

	/** Gets the size of this dictionary.
		@return	The number of entries (key-value pairs) currently
				in the dictionary. */
	public int getSize()
	{
		return 0;
	}

	/** Removes all entries from this dictionary. */
	public void clear()
	{
		root = null;
	}
	
	/** Prints out all keys and their values in the dictionary. */
	public void display()
	{
		if (!isEmpty())
		{
			int i = 1;
			KeyNode<K, V> temp = root;
			System.out.println("\t" + i++ + ") " + temp.getKey() + " ---> " + temp.getThisValue().getValue());
		
			while (temp.getNextKey() != null)
			{
				temp = temp.getNextKey();
				System.out.println("\t" + i++ + ") " + temp.getKey() + " ---> " + temp.getThisValue().getValue());
			}
		}
		else
		{
			System.out.println("There is nothing in this dictionary to display!");
		}
	}
}