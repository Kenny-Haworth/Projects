/**
	Project 2 for CS 331, main class
	
	@author Kendall Haworth
	@version 2.0
	
	A program that uses merge sort, iterative quick sort,
	recursive quick sort, and recursive quick sort with median
	of medians to find the kth element in the array, where
	k = 1, n/4, n/2, 3n/4, and n.
	
	The size of the array and the number of iterations to perform
	on each array size can be changed from the variables declared
	in the beginnning of the program.
	
	The program will return to the user the average time each algorithm
	took to find each k based on the number of iterations as well as the
	total average time for all algorithms. It will additionally print this
	information to a text document to allow for easy copy-and-pasting into
	a program like Excel to create graphs of the data.
	
	After each algorithm is called, the array becomes fully or partially sorted,
	and so each array is scrambled back to its original values after each algorithm
	is called. However, the values for each iteration are different, such that
	no two iterations work on the same data, even though each algorithm can find
	each k for that particular iteration using the same data.
*/

import java.util.Random;
import java.text.NumberFormat;
import java.io.*;

public class project2
{
	public static void main(String[] args) throws IOException
	{
		Random randomObj = new Random();
		
		//the number of iterations and the array size
		int iterations = 10000;
		int arraySize = 100;
		
		//to capture the total average time each algorithm takes
		double mergeTotal = 0;
		double quickIterativeTotal = 0;
		double quickRecursiveTotal = 0;
		double medianTotal = 0;
		
		//to capture the total average time each algorithm takes for k = 1st array element
		double mergek1 = 0;
		double quickk1 = 0;
		double quickRk1 = 0;
		double mediank1 = 0;
		
		//to capture the total average time each algorithm takes for k = 1/4 array element
		double mergek14 = 0;
		double quickk14 = 0;
		double quickRk14 = 0;
		double mediank14 = 0;
		
		//to capture the total average time each algorithm takes for k = 1/2 array element
		double mergek12 = 0;
		double quickk12 = 0;
		double quickRk12 = 0;
		double mediank12 = 0;
		
		//to capture the total average time each algorithm takes for k = 3/4 array element
		double mergek34 = 0;
		double quickk34 = 0;
		double quickRk34 = 0;
		double mediank34 = 0;
		
		//to capture the total average time each algorithm takes for k = last array element
		double mergekL = 0;
		double quickkL = 0;
		double quickRkL = 0;
		double mediankL	 = 0;
		
		PrintWriter outputFile = new PrintWriter("theoreticalResults.txt"); //to output the data to a file
		
		System.out.println("\nTesting array size of " + NumberFormat.getNumberInstance().format(arraySize) + " for " + NumberFormat.getNumberInstance().format(iterations) + " iterations:\n");
		
		//loop for number of iterations
		for (int l = 0; l < iterations; l++)
		{
			//an array to hold random numbers
			int[] randomArray = new int[arraySize];
			
			//the array each algorithm will store its final answer in
			int[] kArray = new int[4];

			//fill the randomArray with random numbers
			for (int q = 0; q < randomArray.length; q++)
			{
				randomArray[q] = randomObj.nextInt(1000000);
			}
			
			//create the array each other algorithm will use to solve the problem
			int[] mergeArray = new int[randomArray.length];
			int[] quickSortIterativeArray = new int[randomArray.length];
			int[] quickSortRecursiveArray = new int[randomArray.length];
			int[] medianArray = new int[randomArray.length];
			
			int k; //to hold the location k should be found at
			double startTime; //to hold the time the algorithm begins
			double duration; //to hold the time the algorithm takes
			
			//loop 5 times, the number of k's we have to find
			for (int i = 0; i < 5; i++)
			{
				if (i == 0)
				{
					k = 0; //array is zero-indexed, first element will be 0
				}
				else if (i == 1)
				{
					k = randomArray.length/4; //find the n/4th element
				}
				else if (i == 2)
				{
					k = randomArray.length/2; //find the n/2nd element
				}
				else if (i == 3)
				{
					k = 3*(randomArray.length/4); //find the 3n/4th element
				}
				else //i == 4
				{
					k = randomArray.length - 1; //find nth or last element
				}
				
				/**
					Make sure each array is filled with the same random elements for each iteration.
					
					Note that had the arrays not been reset to their original data, finding the kth element
					would have been much faster for subsequent searches.
					
					Also note that while the data is the same for finding each k for all 5 k sizes, each iteration uses different data.
				*/
				for (int j = 0; j < randomArray.length; j++)
				{
					mergeArray[j] = randomArray[j];
					quickSortIterativeArray[j] = randomArray[j];
					quickSortRecursiveArray[j] = randomArray[j];
					medianArray[j] = randomArray[j];
				}
				
				///////////////////////////////////
				//			Merge Sort		  	//
				/////////////////////////////////
				
				/**
					Calling and capturing the data from each algorithm is the same process
					for all 4 algorithms, so only the first is commented for readability.
				*/
				
				//create an object of algorithm1
				algorithm1 merge = new algorithm1();
				
				startTime = System.nanoTime(); //take the current system time
				
				//call the algorithm with the array
				merge.mergeSort(mergeArray, 0, mergeArray.length-1);
				kArray[0] = mergeArray[k]; //store the kth element in our kArray or answers array
				
				duration = System.nanoTime() - startTime; //the duration is the current system time minus the previous system time
				mergeTotal += duration; //capture the duration
				
				//add the duration to the corresponding data value for finding that particular k
				if (i == 0)
				{
					mergek1 += duration;
				}
				else if (i == 1)
				{
					mergek14 += duration;
				}
				else if (i == 2)
				{
					mergek12 += duration;
				}
				else if (i == 3)
				{
					mergek34 += duration;
				}
				else //i == 4
				{
					mergekL += duration;
				}
				
				/////////////////////////////////////////////
				//			Quick Sort Iterative		  //
				///////////////////////////////////////////
				
				algorithm2 quickIterative = new algorithm2();
				
				startTime = System.nanoTime();
				
				kArray[1] = quickIterative.quickSortIterative(quickSortIterativeArray, k);
				
				duration = System.nanoTime() - startTime;
				quickIterativeTotal += duration;
				
				if (i == 0)
				{
					quickk1 += duration;
				}
				else if (i == 1)
				{
					quickk14 += duration;
				}
				else if (i == 2)
				{
					quickk12 += duration;
				}
				else if (i == 3)
				{
					quickk34 += duration;
				}
				else //i == 4
				{
					quickkL += duration;
				}
				
				/////////////////////////////////////////////
				//			Quick Sort Recursive		  //
				///////////////////////////////////////////
				
				algorithm3 quickRecursive = new algorithm3();
				
				startTime = System.nanoTime();
				
				kArray[2] = quickRecursive.quickSortRecursive(quickSortRecursiveArray, k);
				
				duration = System.nanoTime() - startTime;
				quickRecursiveTotal += duration;
				
				if (i == 0)
				{
					quickRk1 += duration;
				}
				else if (i == 1)
				{
					quickRk14 += duration;
				}
				else if (i == 2)
				{
					quickRk12 += duration;
				}
				else if (i == 3)
				{
					quickRk34 += duration;
				}
				else //i == 4
				{
					quickRkL += duration;
				}
				
				/////////////////////////////////////////////////////////////
				//			Quick Sort Recursive Median of Medians		  //
				///////////////////////////////////////////////////////////
				
				algorithm4 MM = new algorithm4();
				
				startTime = System.nanoTime();
				
				kArray[3] = MM.quickSortRecursive(medianArray, k);
				
				duration = System.nanoTime() - startTime;
				medianTotal += duration;
				
				if (i == 0)
				{
					mediank1 += duration;
				}
				else if (i == 1)
				{
					mediank14 += duration;
				}
				else if (i == 2)
				{
					mediank12 += duration;
				}
				else if (i == 3)
				{
					mediank34 += duration;
				}
				else //i == 4
				{
					mediankL += duration;
				}
				
				//all 4 algorithms should have found the same kth element. If they did not, create a dump of the data and throw an error
				if (!(kArray[0] == kArray[1] && kArray[0] == kArray[2] && kArray[0] == kArray[3]))
				{
					System.out.println("K for 1st: " + kArray[0]);
					System.out.println("K for 2nd: " + kArray[1]);
					System.out.println("K for 3rd: " + kArray[2]);
					System.out.println("K for 4th: " + kArray[3]);
					System.out.println("ERROR!");
					System.exit(1);
				}
			}//end each k
		} //end all iterations
		
		//print the results to screen
		
		//The average time for each k should be obtained by dividing the sum of each k's time
		//by the number of iterations used
		System.out.println("For k = 1st array element");
		System.out.println("Average Merge Sort time:\t   " + mergek1/iterations);
		System.out.println("Average Quick Iterative time:\t   " + quickk1/iterations);
		System.out.println("Average Quick Recursive time:\t   " + quickRk1/iterations);
		System.out.println("Average Median Sort time:\t   " + mediank1/iterations + "\n");
		
		System.out.println("For k = 1/4 array element");
		System.out.println("Average Merge Sort time:\t   " + mergek14/iterations);
		System.out.println("Average Quick Iterative time:\t   " + quickk14/iterations);
		System.out.println("Average Quick Recursive time:\t   " + quickRk14/iterations);
		System.out.println("Average Median Sort time:\t   " + mediank14/iterations + "\n");
		
		System.out.println("For k = 1/2 array element");
		System.out.println("Average Merge Sort time:\t   " + mergek12/iterations);
		System.out.println("Average Quick Iterative time:\t   " + quickk12/iterations);
		System.out.println("Average Quick Recursive time:\t   " + quickRk12/iterations);
		System.out.println("Average Median Sort time:\t   " + mediank12/iterations + "\n");
		
		System.out.println("For k = 3/4 array element");
		System.out.println("Average Merge Sort time:\t   " + mergek34/iterations);
		System.out.println("Average Quick Iterative time:\t   " + quickk34/iterations);
		System.out.println("Average Quick Recursive time:\t   " + quickRk34/iterations);
		System.out.println("Average Median Sort time:\t   " + mediank34/iterations + "\n");
		
		System.out.println("For k = last array element");
		System.out.println("Average Merge Sort time:\t   " + mergekL/iterations);
		System.out.println("Average Quick Iterative time:\t   " + quickkL/iterations);
		System.out.println("Average Quick Recursive time:\t   " + quickRkL/iterations);
		System.out.println("Average Median Sort time:\t   " + mediankL/iterations + "\n");
		
		/**
			The average total time should be obtained by dividing each algorithm's total time
			by the number of iterations and the number of k's to search for (5 of them).
			
			For example, for each iteration each algorithm is run 5 times, once for each k, so
			the average for one iteration will be the total time divided by 5. Thus, the average
			for each iteration is the total time divided by the number of iterations divided by 5.
		*/
		System.out.println("For the average time for all k's");
		System.out.println("Average Merge Sort time:\t   " + (mergeTotal/iterations)/5);
		System.out.println("Average Quick Iterative time:\t   " + (quickIterativeTotal/iterations)/5);
		System.out.println("Average Quick Recursive time:\t   " + (quickRecursiveTotal/iterations)/5);
		System.out.println("Average Median Sort time:\t   " + (medianTotal/iterations)/5 + "\n");
		
		/**
			The overall average time is found by adding up the totals and dividing by the total number of iterations, the total number of algorithms,
			and the total number of k's to be found. Thus, because there are always 4 algorithms and 5 k's to find, we can divide by 20, as 4*5 = 20.
		*/
		System.out.println("Total average time for each iteration: " + (((mergeTotal+quickIterativeTotal+quickRecursiveTotal+medianTotal)/iterations)/20));
		
		//save the time results to file
		//save the merge times to file
		outputFile.println(mergek1/iterations);
		outputFile.println(mergek14/iterations);
		outputFile.println(mergek12/iterations);
		outputFile.println(mergek34/iterations);
		outputFile.println(mergekL/iterations);
		outputFile.println((mergeTotal/iterations)/5);
		outputFile.println("");
		
		//save the quick iterative times to file
		outputFile.println(quickk1/iterations);
		outputFile.println(quickk14/iterations);
		outputFile.println(quickk12/iterations);
		outputFile.println(quickk34/iterations);
		outputFile.println(quickkL/iterations);
		outputFile.println((quickIterativeTotal/iterations)/5);
		outputFile.println("");
		
		//save the quick recursive times to file
		outputFile.println(quickRk1/iterations);
		outputFile.println(quickRk14/iterations);
		outputFile.println(quickRk12/iterations);
		outputFile.println(quickRk34/iterations);
		outputFile.println(quickRkL/iterations);
		outputFile.println((quickRecursiveTotal/iterations)/5);
		outputFile.println("");
		
		//save the median of medians times to file
		outputFile.println(mediank1/iterations);
		outputFile.println(mediank14/iterations);
		outputFile.println(mediank12/iterations);
		outputFile.println(mediank34/iterations);
		outputFile.println(mediankL/iterations);
		outputFile.println((medianTotal/iterations)/5);
		outputFile.println("");
		
		//save the overall average time for each iteration to file
		outputFile.println((mergeTotal+quickIterativeTotal+quickRecursiveTotal+medianTotal)/iterations);
		
		//close the file
		outputFile.close();
		
	}//end main method	
}//end class