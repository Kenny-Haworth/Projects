/**
	An ADT Dictionary implemented using
	singly-linked nodes with double-data (DDNodes),
	a key and a value for each node.
	
	@author Kendall Haworth
	@version 1.0
*/
import java.util.Iterator;

public class NodeDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V>
{
	private DDNode<K, V> root;
	
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
			DDNode<K, V> newNode = new DDNode<K, V>(key, value);
			root = newNode;
		}
		else if (key.compareTo(root.getKey()) < 0) //If the new key is smaller than the root, it becomes the new root
		{
			DDNode<K, V> newNode = new DDNode<K, V>(key, value, root);
			root = newNode;
		}
		else
		{
			DDNode<K, V> temp = root;
			
			while (temp.getNext() != null && key.compareTo(temp.getKey()) > 0) //Iterates until the position to insert has been found
			{
				temp = temp.getNext();
			}
			
			if (key.compareTo(temp.getKey()) == 0) //if the keys are the same, change the value and return the old value
			{
				V thisValue = temp.getValue();
				temp.setValue(value);
				return thisValue;
			}
			else if (temp.getNext() == null && key.compareTo(temp.getKey()) > 0) //If it's being added as the last node, simply link it in
			{
				DDNode<K, V> newNode = new DDNode<K, V>(key, value);
				temp.setNext(newNode);
			}
			else //If it's being inserted between nodes, relink the node before it to the new node
			{
				temp = root;
			
				while (temp.getNext() != null && key.compareTo(temp.getNext().getKey()) > 0) //Iterates until the position to insert has been found
				{
					temp = temp.getNext();
				}
				
				DDNode<K, V> newNode = new DDNode<K, V>(key, value);
				DDNode<K, V> temp2 = temp.getNext();
				temp.setNext(newNode);
				newNode.setNext(temp2);
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
			V thisValue = root.getValue();
			
			DDNode<K, V> temp = root;
			root = root.getNext();
			temp = null;
			
			return thisValue;
		}
		else
		{
			DDNode<K, V> temp = root;
			
			while (temp.getNext() != null && !key.equals(temp.getNext().getKey())) //Iterates until the position to enter has been found
			{
				temp = temp.getNext();
			}
			
			if (temp.getNext() == null) //The key does not exist
			{
				return null;
			}
			else if (temp.getNext().getNext() == null) //The node to be removed is the last node
			{
				V thisValue = temp.getNext().getValue();
				temp.setNext(null);
				return thisValue;
			}
			else //The node to be removed is inbetween nodes
			{
				V thisValue = temp.getNext().getValue();
				temp.setNext(temp.getNext().getNext());
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
		DDNode<K, V> temp = root;
			
		while (temp.getNext() != null && !key.equals(temp.getKey())) //Iterates until the position to enter has been found
		{
			temp = temp.getNext();
		}
		
		if (key.equals(temp.getKey()))
		{
			return temp.getValue();
		}
		
		return null;
	}

	/** Sees whether a specific entry is in this dictionary.
		@param key  An object search key of the desired entry.
		@return  True if key is associated with an entry in the dictionary. */
	public boolean contains(K key)
	{
		DDNode<K, V> temp = root;
			
		while (temp.getNext() != null && !key.equals(temp.getKey())) //Iterates until the position to enter has been found
		{
			temp = temp.getNext();
		}
		
		if (key.equals(temp.getKey()))
		{
			return true;
		}
		
		return false;
	}
	
	/** Creates an iterator that traverses all search keys in this dictionary.
		@return	An iterator that provides sequential access to the search
				keys in the dictionary. */
	public Iterator<K> getKeyIterator()
	{
		Iterator<K> iter = new Iterator<K>()
		{
			private int i = 0;
			DDNode<K, V> temp = root;
			
			public boolean hasNext()
			{
				return (temp.getNext() != null || i != getSize());
			}
			
			public K next()
			{
				if (i != 0)
				{
					temp = temp.getNext();
				}
				i++;
				return temp.getKey();
			}
			
			public void remove()
			{
				throw new UnsupportedOperationException();
			}
		};
		return iter;
	}
   
	/** Creates an iterator that traverses all values in this dictionary.
		@return	An iterator that provides sequential access to the values
		in this dictionary. */
	public Iterator<V> getValueIterator()
	{
		Iterator<V> iter = new Iterator<V>()
		{
			private int i = 0;
			DDNode<K, V> temp = root;
			
			public boolean hasNext()
			{
				return (temp.getNext() != null || i != getSize());
			}
			
			public V next()
			{
				if (i != 0)
				{
					temp = temp.getNext();
				}
				i++;
				return temp.getValue();
			}
			
			public void remove()
			{
				throw new UnsupportedOperationException();
			}
		};
		return iter;
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
		if (!isEmpty()) //if its empty, there are 0 nodes
		{
			int count = 1;
			DDNode<K, V> temp = root;
			
			while (temp.getNext() != null)
			{
				temp = temp.getNext();
				count++;
			}
			
			return count;
		}
		
		return 0;
	}

	/** Removes all entries from this dictionary. */
	public void clear()
	{
		root = null;
	}
	
	/** Prints out all keys and their values in the dictionary using iterators. */
	public void display()
	{
		if (!isEmpty())
		{
			Iterator<K> keyIterator = getKeyIterator();
			Iterator<V> valueIterator = getValueIterator();

			int i = 1;
			while (keyIterator.hasNext())
			{
				System.out.println("\t" + i++ + ") " + keyIterator.next() + " ----> " + valueIterator.next());
			}
		}
		else
		{
			System.out.println("There is nothing in this dictionary to display!");
		}
	}
}