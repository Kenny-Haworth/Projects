/**
	@author Kendall Haworth
	
	Project 2 for CS 241-02
	
	This is the driver class and contains the main method,
	the actual ADT is in the file MaxHeap.java
*/

import java.util.Scanner;
import java.util.Random;

public class Project2
{
	public static void main(String[] args)
	{
		MaxHeap heap; //create two heaps, a normal and an optimal heap
		MaxHeap optimal;
		
		Random random = new Random();
		Scanner kb = new Scanner(System.in);
		
		boolean loop = true;
		boolean generate;
		
		int[] array; //array to store random numbers
		int input; //user's input
		int total; //the regular method total # of swaps
		int optTotal; //the optimal method total # of swaps
		
		while (loop)
		{
			array = new int[100]; //store 100 random integers
			heap = new MaxHeap(); //create the regular max heap
			optimal = new MaxHeap(); //create the optimal max heap
			
			System.out.println("\nPlease select how to test the program:");
			System.out.println("(1) 20 sets of 100 randomly generated integers");
			System.out.println("(2) Fixed integer values 1-100");
			System.out.print("Enter choice: ");
			input = kb.nextInt();
			System.out.println();
		
			if (input == 1)
			{
				total = 0; //initialize number of swaps
				optTotal = 0;
				
				for (int i = 0; i < 20; i++) //loop for 20 sets
				{
					heap = new MaxHeap(); //clear and reset the heaps and array for each set
					optimal = new MaxHeap();
					array = new int[100];
					
					for (int q = 0; q < 100; q++) //loop for 100 random integers
					{
						generate = true;
						
						while (generate)
						{
							input = random.nextInt(100000); //generate a random number
							boolean duplicate = false;
						
							//check the random number against the numbers that have already been generated
							for (int r = 0; r < q; r++)
							{
								//if there's a duplicate, generate a new random number
								if (array[r] == input)
								{
									duplicate = true;
									break;
								}
							}
							
							//if there's not a duplicate, add it to the array
							if (!duplicate)
							{
								array[q] = input;
								generate = false;
							}
						}
					}
					
					//add the array of random numbers to heaps, saving the number of swaps
					for (int m = 0; m < array.length; m++)
					{
						int number = heap.add(array[m]);
						optimal.addOptimal(array[m]);
						
						total += number;
					}
					optTotal += optimal.reheap();
				}
				
				total /= 20; //get the average number of swaps over 20 sets
				optTotal /= 20;
				System.out.println("Average swaps for series of insertions: " + total);
				System.out.print("Average swaps for optimal method: " + optTotal + "\n");
			}
			else if (input == 2)
			{
				total = 0; //initialize number of swaps
				optTotal = 0;
				
				//add 1-100 to both heaps, keeping track of the number of swaps
				for (int i = 1; i <= 100; i++)
				{
					int number = heap.add(i);
					optimal.addOptimal(i);
					
					total += number;
				}
				
				//print the number of swaps and output for the regular heap
				System.out.print("Heap built using series of insertions: ");
				heap.print();
				System.out.println("\nNumber of swaps: " + total);
				
				//call remove on regular heap 10 times
				for (int i = 0; i < 10; i++)
				{
					heap.remove();
				}
				
				//print the regular heap after removals
				System.out.print("Heap after 10 removals: ");
				heap.print();				
				
				//print the number of swaps and output for the optimal heap
				optTotal = optimal.reheap();
				System.out.print("\n\nHeap built using optimal method: ");
				optimal.print();
				System.out.println("\nNumber of swaps: " + optTotal);
				
				//call remove on optimal heap 10 times
				for (int i = 0; i < 10; i++)
				{
					optimal.remove();
				}
				
				//print the optimal heap after removals
				System.out.print("Heap after 10 removals: ");
				optimal.print();
				System.out.println();
			}
			else //if anything was inputted besides what is allowed, the program will ask for input again
			{
				System.out.println("That is not an input I recognize!");
			}
		}
	}
}