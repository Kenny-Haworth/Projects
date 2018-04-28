import java.util.*;

public class StackTester
{
	public static void main(String[]args)
	{
		NodeStack<String> stack = new NodeStack<String>();
		boolean loop = true;
		Scanner kb = new Scanner(System.in);
		
		while (loop)
		{
			System.out.println();
			System.out.println("What would you like to do?");
			String input = kb.nextLine();
		
			if (input.equalsIgnoreCase("ADD"))
			{
				System.out.println("Enter what you would like to add to your stack:");
				input = kb.nextLine();
				stack.push(input);
			}
			else if (input.equalsIgnoreCase("REMOVE"))
			{
				String item = stack.pop();
				System.out.println(item + " has been removed from the stack.");
			}
			else if (input.equalsIgnoreCase("PEEK"))
			{
				String item = stack.peek();
				
				if (item == null)
				{
					System.out.println("There is nothing in this stack to look at!");
				}
				else
				{
					System.out.println("The item on the top of the stack is " + stack.peek());
				}
			}
			else if (input.equalsIgnoreCase("ISEMPTY"))
			{
				if (stack.isEmpty())
				{
					System.out.println("The stack is empty.");
				}
				else
				{
					System.out.println("The stack is not empty.");
				}
			}
			else if (input.equalsIgnoreCase("CLEAR"))
			{
				stack.clear();
				System.out.println("The stack has been cleared of items.");
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