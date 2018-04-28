import java.util.Scanner;

public class DLDequeTester
{
	public static void main(String[]args) throws EmptyQueueException
	{
		NodeDeque<String> queue = new NodeDeque<String>();
		boolean loop = true;
		Scanner kb = new Scanner(System.in);
		
		while (loop)
		{
			System.out.println();
			System.out.println("What would you like to do?");
			String input = kb.nextLine();
		
			if (input.equalsIgnoreCase("ADD FRONT"))
			{
				System.out.println("Enter what you would like to add to the front of your queue:");
				input = kb.nextLine();
				queue.addToFront(input);
			}
			else if (input.equalsIgnoreCase("ADD BACK"))
			{
				System.out.println("Enter what you would like to add to the back of your queue:");
				input = kb.nextLine();
				queue.addToBack(input);
			}
			else if (input.equalsIgnoreCase("REMOVE FRONT"))
			{
				String item = queue.removeFront();
				System.out.println(item + " has been removed from the front of the queue.");
			}
			else if (input.equalsIgnoreCase("REMOVE BACK"))
			{
				String item = queue.removeBack();
				System.out.println(item + " has been removed from the back of the queue.");
			}
			else if (input.equalsIgnoreCase("GET FRONT"))
			{
				String item = queue.getFront();
				System.out.println("The item in the front of the queue is " + item);
			}
			else if (input.equalsIgnoreCase("GET BACK"))
			{
				String item = queue.getBack();
				System.out.println("The item in the back of the queue is " + item);
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