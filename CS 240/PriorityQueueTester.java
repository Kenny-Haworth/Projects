import java.util.Scanner;

public class PriorityQueueTester
{
	public static void main(String[]args) throws EmptyQueueException
	{
		PriorityQueue<String> queue = new PriorityQueue<String>();
		boolean loop = true;
		Scanner kb = new Scanner(System.in);
		
		while (loop)
		{
			System.out.println();
			System.out.println("What would you like to do?");
			String input = kb.nextLine();
		
			if (input.equalsIgnoreCase("ADD"))
			{
				System.out.println("Enter what you would like to add to your queue:");
				input = kb.nextLine();
				queue.add(input);
			}
			else if (input.equalsIgnoreCase("REMOVE"))
			{
				boolean condition = false;
				if (queue.isEmpty())
				{
					condition = true;
				}
				String item = queue.remove();
				
				if (!condition)
				{
					System.out.println(item + " has been removed from the queue.");
				}
			}
			else if (input.equalsIgnoreCase("PEEK"))
			{
				String item = queue.peek();
				System.out.println("The item at the front of the queue is " + item + ".");
			}
			else if (input.equalsIgnoreCase("ISEMPTY"))
			{
				if (queue.isEmpty())
				{
					System.out.println("The queue IS empty.");
				}
				else
				{
					System.out.println("The queue is NOT empty.");
				}
			}
			else if (input.equalsIgnoreCase("SIZE"))
			{
				int size = queue.getSize();
				System.out.println("There are currently " + size + " items in this queue.");
			}
			else if (input.equalsIgnoreCase("CLEAR"))
			{
				queue.clear();
				System.out.println("The queue has been cleared of items.");
			}
			else if (input.equalsIgnoreCase("EXIT"))
			{
				loop = false;
			}
			else
			{
				System.out.println("That is not an input I recognize!");
			}
		}
	}
}