/**
	An ADT Dictionary implemented
	using hashing.
	
	@author Kendall Haworth
	@author Drue Hidalgo
	@author Elshaday Assefa
	@version 1.0
*/

import java.util.Iterator;
import java.util.ArrayList;

public class HashDictionary<K, V> implements DictionaryInterface<K, V>
{
	private Entry<K, V>[] dictionary;
	private int numberOfEntries;
	
	public HashDictionary()
	{
		@SuppressWarnings("unchecked")
		Entry<K, V>[] tempDictionary = (Entry<K, V>[])new Entry[5]; //Unchecked cast
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
		for (int r = 0; r < dictionary.length; r++) //If the key already exists, replace the value with the new value
		{
			if (dictionary[r] != null && key.equals(dictionary[r].getKey()))
			{
				V thisValue = dictionary[r].getValue();
				dictionary[r].setValue(value);
				return thisValue;
			}
		}
		
		int hash = getHashIndex(key);
		int endPoint = hash - 1;
		if (endPoint < 0)
		{
			endPoint = dictionary.length-1;
		}

		while (dictionary[hash] != null && dictionary[hash].getFlag() != 1) //Search for an empty position in the array
		{
			if (hash == endPoint) //There are no empty positions left in the array
			{
				numberOfEntries = 0; //when rehashing, everything is added back
				reHash(getPrime());
				hash = getHashIndex(key);
				endPoint = hash - 1;
				if (endPoint < 0)
				{
					endPoint = dictionary.length-1;
				}
			}
			else
			{
				hash++;
				if (hash == dictionary.length)
				{
					hash = 0;
				}
			}
		}
		
		dictionary[hash] = new Entry<>(key, value);
		numberOfEntries++;
		
		return null;
	}
	
	/** Creates an new hash table and rehashes the indexes.
		@param tableSize The size of the new hash table.
	*/
	public void reHash(int tableSize)
	{
		Entry<K, V>[] oldDictionary = dictionary;
		
		@SuppressWarnings("unchecked")
		Entry<K, V>[] tempDictionary = (Entry<K, V>[])new Entry[tableSize];
		
		dictionary = tempDictionary;
		
		for (int i = 0; i < oldDictionary.length; i++)
		{
			if (oldDictionary[i] != null && oldDictionary[i].getFlag() != 1)
			{
				add(oldDictionary[i].getKey(), oldDictionary[i].getValue());
			}
		}
	}
	
	/** Returns an appropriate hash index for the given key.
		@param key The key to be turned into an index.
	*/
	public int getHashIndex(K key)
	{
		int hashIndex = key.hashCode() % dictionary.length;
		if (hashIndex < 0)
		{
			hashIndex += dictionary.length;
		}
		
		return hashIndex;
	}
	
	
	/** Removes a specific entry from this dictionary.
		@param key	An object search key of the entry to be removed.
		@return		Either the value that was associated with the search key
				or null if no such object exists. */
	public V remove(K key)
	{
		int hash = getHashIndex(key);
		System.out.println(hash);
		int endPoint = hash - 1;
		
		while (dictionary[hash] != null && !key.equals(dictionary[hash].getKey()))
		{
			System.out.println("looping");
			hash++;
			System.out.println(hash);
			if (hash == dictionary.length)
			{
				hash = 0;
			}
			
			if (hash == endPoint)
			{
				return null;
			}
		}
		
		V thisValue = dictionary[hash].getValue();
		dictionary[hash].removeEntry();
		numberOfEntries--;
		return thisValue;
	}
	
	/** Retrieves from this dictionary the value associated with a given
		search key.
		@param key	An object search key of the entry to be retrieved.
		@return	Either the value that is associated with the search key
				or null if no such object exists. */
	public V getValue(K key)
	{
		for (int i = 0; i < dictionary.length; i++)
		{
			if (dictionary[i] != null && dictionary[i].getKey().equals(key))
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
		for (int i = 0; i < dictionary.length; i++)
		{
			if (dictionary[i] != null && key.equals(dictionary[i].getKey()))
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
		ArrayList<K> arr = new ArrayList<K>();
		
		for (int i = 0; i < dictionary.length; i++)
		{
			if (dictionary[i] != null && dictionary[i].getFlag() != 1)
			{
				arr.add(dictionary[i].getKey());
			}
		}
		Iterator<K> keyIterator = arr.iterator();
		return keyIterator;
	}
	
	/** Creates an iterator that traverses all values in this dictionary.
		@return	An iterator that provides sequential access to the values
		in this dictionary. */
	public Iterator<V> getValueIterator()
	{
		ArrayList<V> arr = new ArrayList<V>();
		
		for (int i = 0; i < dictionary.length; i++)
		{
			if (dictionary[i] != null && dictionary[i].getFlag() != 1)
			{
				arr.add(dictionary[i].getValue());
			}
		}
		Iterator<V> valueIterator = arr.iterator();
		return valueIterator;
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
		for (int i = 0; i < dictionary.length; i++)
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
	
	/** Finds the next prime number at or above the passed in value. */
	public int getPrime()
	{		
		for (int i = dictionary.length*2; i < 10000; i++) //10,000 is max array size
		{
			boolean isPrimeNumber = true;
			
			for (int j = 2; j < i; j++)
			{	
				if (i % j == 0)
				{
					isPrimeNumber = false;
					break;
				}
			}
			
			if (isPrimeNumber)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	/**
		This inner class Entry allows us to create an object
		that we can store in our dictionary array, so we can have three pieces of data -
		a key, value, and flag - encapsulated in this object in each element of our array.
	*/
	private class Entry<K, V>
	{
		private K key;
		private V value;
		private int flag;
		
		private Entry(K searchKey, V dataValue)
		{
			key = searchKey;
			value = dataValue;
			flag = 0;
		}
		
		private K getKey()
		{
			return key;
		}
		
		private V getValue()
		{
			return value;
		}
		
		private int getFlag()
		{
			return flag;
		}
		
		private void setValue(V newValue)
		{
			value = newValue;
		}
		
		private void removeEntry()
		{
			key = null;
			value = null;
			flag = 1;
		}
	}
}