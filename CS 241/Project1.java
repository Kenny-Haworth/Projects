/**
	@author Kendall Haworth
	
	Project 1 for CS 241-02
	
	This is the driver class and contains the main method,
	the actual ADT is in the file BinaryTree.java
*/


import java.util.Scanner;
import java.util.StringTokenizer;

public class Project1
{
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree(); //create an instance of binary tree
		boolean loop = true;
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Please enter the initial sequence of values: ");
		String input = kb.nextLine();
		
		//the string tokenizer will break up the input into individual tokens
		StringTokenizer token = new StringTokenizer(input, " ");
		
		while (token.hasMoreTokens())
		{
			input = token.nextToken();
			tree.add(Integer.parseInt(input)); //change the string tokens to integers and add them to the tree
		}
		
		//print out the traversals
		System.out.print("\nPre-order: ");
		tree.preorder();
		System.out.print("\nIn-order: ");
		tree.inorder();
		System.out.print("\nPost-order: ");
		tree.postorder();
		System.out.println("\n");
		
		while (loop)
		{
			System.out.print("Command? ");
			input = kb.nextLine();
			
			//a tokenizer is used to separate the command from the integer input
			token = new StringTokenizer(input, " ");
			input = token.nextToken();
		
			if (input.equalsIgnoreCase("I")) //insert a node
			{
				int data = Integer.parseInt(token.nextToken());
				BinaryNode node = tree.add(data);
				
				if (node == null) //if null was returned, it already exists in this tree
				{
					System.out.println(data + " already exists, ignore.");
				}
				else
				{
					System.out.print("In-order: ");
					tree.inorder();
					System.out.println();
				}
			}
			else if (input.equalsIgnoreCase("D")) //delete a node
			{
				int data = Integer.parseInt(token.nextToken());
				BinaryNode node = tree.remove(data);
				
				if (node == null) //if null was returned, the node doesn't exist
				{
					System.out.println(data + " doesn't exist!");
				}
				else
				{
					System.out.print("In-order: ");
					tree.inorder();
					System.out.println();
				}
			}
			else if (input.equalsIgnoreCase("P")) //find the predecessor
			{
				BinaryNode predecessor = tree.findPredecessor(Integer.parseInt(token.nextToken()));
				
				if (predecessor == null) //if null was returned, there is no predecessor or the node doesn't exist
				{
					System.out.println("This node either has no predecessor or does not exist!");
				}
				else
				{
					System.out.println(predecessor.getData());
				}
			}
			else if (input.equalsIgnoreCase("S")) //find the successor
			{
				BinaryNode successor = tree.findSuccessor(Integer.parseInt(token.nextToken()));
				
				if (successor == null) //if null was returned, there is no successor or the node doesn't exist
				{
					System.out.println("This node either has no successor or does not exist!");
				}
				else
				{
					System.out.println(successor.getData());
				}
			}
			else if (input.equalsIgnoreCase("E")) //exit the program
			{
				System.out.println("Thank you for using my program!");
				loop = false; //end the loop
			}
			else if (input.equalsIgnoreCase("H")) //display the menu
			{
				System.out.println("   I	Insert a value");
				System.out.println("   D	Delete a value");
				System.out.println("   P	Find predecessor");
				System.out.println("   S	Find successor");
				System.out.println("   E	Exit the program");
				System.out.println("   H	Display this message");
			}
			else //if anything was inputted besides what is allowed, the program will ask for input again
			{
				System.out.println("That is not an input I recognize!");
			}
		}
	}
}