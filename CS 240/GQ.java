public class GQ
{
	int[] myArray;
	int last;
	
	public GQ()
	{
		myArray = new int[10];
		last = 0;
	}
	
	public int get (int i)
	{
		return myArray[i];
	}
	
	public void addLast (int item)
	{
		myArray[last] = item;
		last++;
	}
	
	public void addFirst(int item)
	{
		for (int i = last; i > 0; i--)
		{
			myArray[i] = myArray[i-1];
		}
		
		myArray[0] = item;
		last++;
	}
	
	public int remove(int i)
	{
		int temp = myArray[i];
		
		for (int q = i; q < last; q++)
		{
			myArray[q] = myArray[q+1];
		}
		last--;
		return temp;
	}
	
	public void printArray()
	{
		for (int i = 0; i < last; i++)
		{
			System.out.print(myArray[i] + " ");
		}
		System.out.println();
	}
}