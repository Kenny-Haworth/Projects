import java.util.Scanner;

public class DictionaryTester
{
	public static void main(String[] args)
	{
		NodeDictionary<String, String> dictionary = new NodeDictionary<String, String>();
		boolean loop = true;
		Scanner kb = new Scanner(System.in);
		
		while (loop)
		{
			System.out.println();
			System.out.println("What would you like to do?");
			String input = kb.nextLine();
			String secondInput;
			String V;
		
			if (input.equalsIgnoreCase("ADD"))
			{
				System.out.println("Enter the key to add to your dictionary:");
				input = kb.nextLine();
				System.out.println("Enter the value to add to your dictionary:");
				secondInput = kb.nextLine();
				V = dictionary.add(input, secondInput);
				
				if (V == null)
				{
					System.out.println("The key \"" + input + "\" and the value \"" + secondInput + "\" have been added to this dictionary.");
				}
				else
				{
					System.out.println("The key \"" + input + "\" already existed, so the value \"" + secondInput + "\" has replaced the already existing value " + V + ".");
				}
			}
			else if (input.equalsIgnoreCase("REMOVE"))
			{
				System.out.println("Enter the key you would like to remove from this dictionary: ");
				input = kb.nextLine();
				V = dictionary.remove(input);
				
				if (V == null)
				{
					System.out.println("The key " + input + " does not exist in this dictionary!");
				}
				else
				{
					System.out.println("The key \"" + input + "\" and it's value \"" + V + "\" have been removed from this dictionary.");
				}
			}
			else if (input.equalsIgnoreCase("GETVALUE"))
			{
				System.out.println("Enter the key you would like to know the corresponding value of: ");
				input = kb.nextLine();
				V = dictionary.getValue(input);
				
				if (V == null)
				{
					System.out.println("The key \"" + input + "\" does not exist in this dictionary!");
				}
				else
				{
					System.out.println("The value corresponding to " + input + " is " + V + ".");
				}
			}
			else if (input.equalsIgnoreCase("CONTAINS"))
			{
				System.out.println("Enter the key you would like to check is in the dictionary: ");
				input = kb.nextLine();
				if (dictionary.contains(input))
				{
					System.out.println(input + " IS in the dictionary.");
				}
				else
				{
					System.out.println(input + " is NOT in the dictionary.");
				}
			}
			else if (input.equalsIgnoreCase("ISEMPTY"))
			{
				if (dictionary.isEmpty())
				{
					System.out.println("The dictionary IS empty.");
				}
				else
				{
					System.out.println("The dictionary is NOT empty.");
				}
			}
			else if (input.equalsIgnoreCase("DISPLAY"))
			{
				System.out.println();
				dictionary.display();
			}
			else if (input.equalsIgnoreCase("SIZE"))
			{
				System.out.println("There are " + dictionary.getSize() + " entires in this dictionary.");
			}
			else if (input.equalsIgnoreCase("CLEAR"))
			{
				dictionary.clear();
				System.out.println("The dictionary has been cleared of items.");
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