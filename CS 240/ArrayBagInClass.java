/**
A class of bags implemented using a fixed sized array.

*/

public final class ArrayBag<T> implements BagInterface<T>
{
	//member variables
	private static final int DEFAULT_CAPACITY = 20;
	private final T[] bag;
	private int numOfEntries;
	
	public ArrayBag()
	{
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayBag(int desiredSize)
	{
		@SuppressWarning("unchecked")
		T[] tempBag = (T[])new Object[desiredSize]; //This is an unchecked cast!!!
		bag = tempBag;
		numOfEntries = 0;
	}
	
	/** Adds a new entry to this bag.
	    @param newEntry  The object to be added as a new entry.
	    @return  True if the addition is successful, or false if not. */
	public boolean add(T newEntry)
	{
		boolean result = true;
		//check if it is possible to add
		if(isBagFull())
		{
			//Bag is full
			result = false;
		}
		else
		{
			bag[numOfEntries] = newEntry;
			numOfEntries++;
		}
		return result;
	}
	
	public int getCurrentSize()
	{
		int x = 1;
		return x;
	}
	
	//define later on
	//true = full
	// false = still room
	private boolean isBagFull()
	{
		return true;
	}
	
	public T remove()
	{
		if(isEmpty())
		{
			//notify bag is empty
			return null;
		}
		else
		{
			T item = bag[numOfEntries-1]; //captures data with variable
			bag[numOfEntries-1] = null; //removes item from bag
			numOfEntries--; //decrement item in bag count
			return item;
		}
	}
	
	public boolean remove(T anEntry)
	{
		if (contains(anEntry)) //Item is in bag
		{
			for(int i = 0; i < numOfEntries; i++)
			{
				if(bag[i] == anEntry)
				{
					bag[i] = bag[numOfEntries -1];
					bag[numOfEntries -1] = null;
					numOfEntries--;
					return = true;
				}
			}
		}
		else //Item is NOT in bag
		{
			return false;
		}
	}
}