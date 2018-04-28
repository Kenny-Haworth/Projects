import java.util.Iterator;

public class Iterators
{
	public static void main(String[] args)
	{
		VectorStack<String> stack = new VectorStack<String>();
		ArrayDictionary<String, String> dictionary = new ArrayDictionary<String,String>();
		ArrayQueue<String> queue = new ArrayQueue<String>();
		
		stack.push("you next year, ");
		stack.push("I really enjoyed ");
		stack.push("Merry ");
		
		dictionary.add("1", "Christmas ");
		dictionary.add("2", "your class! ");
		dictionary.add("3", "hopefully in another ");
		
		queue.enqueue("Professor Nima! ");
		queue.enqueue("I hope to see ");
		queue.enqueue("class!");
		
		Iterator<String> stackIterator = stack.getStackIterator();
		Iterator<String> dictionaryIterator = dictionary.getValueIterator();
		Iterator<String> queueIterator = queue.getQueueIterator();
		
		Iterator<String> mainIterator = new Iterator<String>()
		{
			int i = 0;
			
			public boolean hasNext()
			{
				return queueIterator.hasNext(); //It ends with the queue iterator
			}
			
			public String next()
			{
				i++;
				
				if (i == 1 || i == 4 || i == 7)
				{
					return stackIterator.next();
				}
				else if (i == 2 || i == 5 || i == 8)
				{
					return dictionaryIterator.next();
				}
				else if (i == 3 || i == 6 || i == 9)
				{
					return queueIterator.next();
				}
				return null;
			}
			
			public void remove()
			{
				throw new UnsupportedOperationException();
			}
		};
		
		while (mainIterator.hasNext())
		{
			System.out.print(mainIterator.next());
		}
	}
}