/**
	An ADT Sorted Dictionary implemented
	using an array.
	
	@author Kendall Haworth
	@version 1.0
*/

import java.util.Iterator;

public class ArrayDictionary<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V>
{
	private final Entry<K, V>[] dictionary;
	private int numberOfEntries;
	
	public ArrayDictionary()
	{
		@SuppressWarnings("unchecked")
		Entry<K, V>[] tempDictionary = (Entry<K, V>[])new Entry[10]; //Unchecked cast
		dictionary = tempDictionary;
		numberOfEntries = 0;
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
		int i = 0;
		while (dictionary[i] != null && key.compareTo(dictionary[i].getKey()) > 0)
		{
			i++;
		}
		
		if (dictionary[i] == null) //In this case, the new Entry object is added after the last entry
		{
			dictionary[i] = new Entry<>(key, value);
			numberOfEntries++;
		}
		else if (key.compareTo(dictionary[i].getKey()) == 0) //If the keys are the same, change the value and return the old value.
		{
			V thisValue = dictionary[i].getValue();
			dictionary[i].setValue(value);
			return thisValue;
		}
		else //if the placement is found in the middle of the array, move all subsequent entries up the array by one
		{
			for (int q = numberOfEntries; q > i; q--)
			{
				dictionary[q] = dictionary[q-1];
			}
			
			dictionary[i] = new Entry<>(key, value);
			numberOfEntries++;
		}
		
		return null;
	}
   
	/** Removes a specific entry from this dictionary.
		@param key	An object search key of the entry to be removed.
		@return		Either the value that was associated with the search key
				or null if no such object exists. */
	public V remove(K key)
	{
		for (int i = 0; i < numberOfEntries; i++)
		{
			if (dictionary[i].getKey().equals(key))
			{
				V thisValue = dictionary[i].getValue();
				
				if (i == numberOfEntries-1) //If it's the last entry, remove it
				{
					dictionary[i] = null;
				}
				else //If it has entries after it, reindex everything in the array
				{
					for (int q = i; q < numberOfEntries-1; q++)
					{
						dictionary[q] = dictionary[q+1];
					}
					
					dictionary[numberOfEntries-1] = null;
				}
				
				numberOfEntries--;
				return thisValue;
			}
		}
		
		return null;
	}
   
	/** Retrieves from this dictionary the value associated with a given
		search key.
		@param key	An object search key of the entry to be retrieved.
		@return	Either the value that is associated with the search key
				or null if no such object exists. */
	public V getValue(K key)
	{
		for (int i = 0; i < numberOfEntries; i++)
		{
			if (dictionary[i].getKey().equals(key))
			{
				return dictionary[i].getValue();
			}
		}
		
		return null;
	}
   
	/** Sees whether a specific entry is in this dictionary.
		@param key  An object search key of the desired entry.
		@return  True if key is associated with an entry in the dictionary. */
	public boolean contains(K key)
	{
		for (int i = 0; i < numberOfEntries; i++)
		{
			if (dictionary[i].getKey().equals(key))
			{
				return true;
			}
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
			
			public boolean hasNext()
			{
				System.out.println("called HASnext");
				return i < getSize();
			}
			
			public K next()
			{
				System.out.println("called next");
				return dictionary[i++].getKey();
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
			
			public boolean hasNext()
			{
				return i < getSize();
			}
			
			public V next()
			{
				return dictionary[i++].getValue();
			}
			
			public void remove()
			{
				//stubs, unsupported operation
			}
		};
		return iter;
	}
   
	/** Sees whether this dictionary is empty.
		@return  True if the dictionary is empty. */
	public boolean isEmpty()
	{
		return numberOfEntries == 0;
	}
   
	/** Gets the size of this dictionary.
		@return	The number of entries (key-value pairs) currently
				in the dictionary. */
	public int getSize()
	{
		return numberOfEntries;
	}
   
	/** Removes all entries from this dictionary. */
	public void clear()
	{
		for (int i = 0; i < numberOfEntries; i++)
		{
			dictionary[i] = null;
		}
		numberOfEntries = 0;
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
	
	/**
		This inner class Entry allows us to create an object
		that we can store in our dictionary array, so we can have two pieces of data -
		a key and a value - encapsulated in this object in each element of our array.
	*/
	private class Entry<S, T>
	{
		private S key;
		private T value;
		
		private Entry(S searchKey, T dataValue)
		{
			key = searchKey;
			value = dataValue;
		}
		
		private S getKey()
		{
			return key;
		}
		
		private T getValue()
		{
			return value;
		}
		
		private void setValue(T newValue)
		{
			value = newValue;
		}
	}
}