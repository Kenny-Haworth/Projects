/**
	@author Kendall Haworth
	
	Entry class for CS 241-02
	An object with three pieces of data,
	the shortest distance, the previous city code,
	and the city number.
*/

public class Entry implements Comparable<Entry>
{
	private int distance; //holds the shortest distance between
	private String code; //holds the city code, like AN or VV
	private int number; //holds the city number
	
	public Entry() //overriden constructor
	{
		distance = Integer.MAX_VALUE; //distance is initialized the infinity
		code = null; //the city code is initialized to null
		number = -1; //city code is initialized to -1, an impossible value
	}
	
	public void setDistance(int distance) //setter for distance
	{
		this.distance = distance;
	}
	
	public void setCode(String code) //setter for the city code
	{
		this.code = code;
	}
	
	public void setNumber(int number) //setter for the city number
	{
		this.number = number;
	}
	
	public int getDistance() //getter for distance
	{
		return distance;
	}
	
	public String getCode() //getter for the city code
	{
		return code;
	}
	
	public int getNumber() //getter for the city number
	{
		return number;
	}
	
	/**	Entry objects will be sorted in the priority queue
		according to their distances; a shorter distance puts
		the Entry object closer to the front of the queue
	*/
	public int compareTo(Entry other)
	{
		if (distance > other.getDistance())
		{
			return 1;
		}
		else if (distance < other.getDistance())
		{
			return -1;
		}
		
		return 0;
	}
}