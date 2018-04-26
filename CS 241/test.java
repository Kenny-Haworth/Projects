public class test
{
	public static void main(String[] args)
	{
		Entry[] entries = new Entry[20];
		
		for (int i = 0; i < 20; i++)
		{
			entries[i] = new Entry();
		}
		
		System.out.println(entries[0].getDistance());
	}
}