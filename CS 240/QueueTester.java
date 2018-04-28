import java.util.Scanner;

public class QueueTester
{
	public static void main(String[]args) throws EmptyQueueException
	{
		ArrayQueue<String> queue = new ArrayQueue<String>();
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
				queue.enqueue(input);
			}
			else if (input.equalsIgnoreCase("REMOVE"))
			{
				String item = queue.dequeue();
				System.out.println(item + " has been removed from the queue.");
			}
			else if (input.equalsIgnoreCase("FRONT"))
			{
				String item = queue.getFront();
				System.out.println("The item in the front of the queue is " + item);
			}
			else if (input.equalsIgnoreCase("ISEMPTY"))
			{
				if (queue.isEmpty())
				{
					System.out.println("The queue is empty.");
				}
				else
				{
					System.out.println("The queue is not empty.");
				}
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