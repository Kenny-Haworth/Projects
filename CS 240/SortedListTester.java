import java.util.Scanner;

public class SortedListTester
{
	public static void main(String[] args)
	{
		NodeSortedList<String> list = new NodeSortedList<String>();
		boolean loop = true;
		Scanner kb = new Scanner(System.in);
		
		while (loop)
		{
			System.out.println();
			System.out.println("What would you like to do?");
			String input = kb.nextLine();
			String secondInput;
			int intInput;
		
			if (input.equalsIgnoreCase("ADD"))
			{
				System.out.println("Enter what you would like to add to your list:");
				input = kb.nextLine();
				list.add(input);
				System.out.println(input + " has been added and sorted into this list.");
			}
			else if (input.equalsIgnoreCase("REMOVE"))
			{
				System.out.println("Enter the number you would like to remove from this list: ");
				intInput = kb.nextInt();
				list.remove(intInput);
				System.out.println("Position " + intInput + " has been removed from this list.");
				kb.nextLine();
			}
			else if (input.equalsIgnoreCase("REPLACE"))
			{
				System.out.println("Enter the number position you would like to replace: ");
				intInput = kb.nextInt();
				kb.nextLine();
				System.out.println("Enter the item you would like to replace it with: ");
				secondInput = kb.nextLine();
				list.replace(intInput, secondInput);
				System.out.println("Position " + intInput + " on the list is now " + secondInput + ".");
			}
			else if (input.equalsIgnoreCase("VIEW"))
			{
				System.out.println("What position would you like to look at?");
				intInput = kb.nextInt();
				System.out.println("The " + intInput + " item on the list is " + list.view(intInput) + ".");
				kb.nextLine();
			}
			else if (input.equalsIgnoreCase("CLEAR"))
			{
				list.clear();
				System.out.println("The list has been cleared of items.");
			}
			else if (input.equalsIgnoreCase("CONTAINS"))
			{
				System.out.println("Enter what you would like to check is on the list: ");
				input = kb.nextLine();
				if (list.contains(input))
				{
					System.out.println(input + " IS on the list.");
				}
				else
				{
					System.out.println(input + " is NOT on the list.");
				}
			}
			else if (input.equalsIgnoreCase("LENGTH"))
			{
				System.out.println("There are " + list.getLength() + " items on this list.");
			}
			else if (input.equalsIgnoreCase("ISEMPTY"))
			{
				if (list.isEmpty())
				{
					System.out.println("The list IS empty.");
				}
				else
				{
					System.out.println("The list is NOT empty.");
				}
			}
			else if (input.equalsIgnoreCase("PRINT"))
			{
				list.toArray();
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