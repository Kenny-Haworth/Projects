import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class midterm
{
	public static void main(String[] args) throws InterruptedException
	{
		final int textDelay = 0;
		final int newLineDelay = 500;
		
		print("Welcome to your study buddy for Gilbert Young's CS 331 midterm!", TimeUnit.MILLISECONDS, textDelay);
		print("\n", TimeUnit.MILLISECONDS, newLineDelay);
		print("To begin, we will simply go over the efficiencies of algorithms!", TimeUnit.MILLISECONDS, textDelay);
		print("\n", TimeUnit.MILLISECONDS, newLineDelay);
		print("\n", TimeUnit.MILLISECONDS, newLineDelay);
		print("Uppercase and lowercase letters do not matter, simply enter your answer without spaces (such as \"nlogn\").\n", TimeUnit.MILLISECONDS, textDelay);
		print("Exponents may be represented by a \"^\", such as \"2^n\".", TimeUnit.MILLISECONDS, textDelay);
		print("\n", TimeUnit.MILLISECONDS, newLineDelay);
		print("Let's begin!", TimeUnit.MILLISECONDS, textDelay);
		print("\n", TimeUnit.MILLISECONDS, newLineDelay);
		print("\n", TimeUnit.MILLISECONDS, newLineDelay);
		
		//sorting algorithms: tower of hanoi(2^n), Strassen's algorithm (n^2.81), classical matrix multiplication (n^3),
		//divide and conquer (not strassens) matrix multiplication(n^3), merge sort (nlogn for all), quick sort (nlogn, nlogn, n^2),
		//bubble sort (n, n^2  , n^2), binary search (1, logn, logn),
		
		
		//INSERTION SORT (N, N^2, N^2), SEQUENTIAL SEARCH (1, N, N), selection sort (n^2 comparisons, n swaps all cases)
		//FIND MAX AND MIN 2(N-1) REGULAR COMPARISONS, two large integers (n^2 traditional and divide and conquer, n^1.58 fast way)
		//complexity of binary search in really small portions??
		
		Random random = new Random();
		boolean[] array = new boolean[16];
		
		for (int i = 0; i < array.length; i++)
		{
			array[i] = false;
		}
		
		String input;
		Scanner kb = new Scanner(System.in);
		int completed = 0;
		double correct = 0;
		
		while (completed != 16)
		{
			int number = random.nextInt(16) + 1;
			
			if (!array[number-1])
			{
				array[number-1] = true;
			}
			else
			{
				while (array[number-1])
				{
					number++;
					
					if (number == 17)
					{
						number = 1;
					}
				}
				array[number-1] = true;
			}
			
			boolean found = false;
			
			while (!found)
			{
				if (number == 1)
				{	
					print("What is the time complexity of solving the Tower of Hanoi problem?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("2^n"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is 2^n.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 2)
				{
					print("What is the time complexity of Strassen's algorithm?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("n^2.81"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is n^2.81.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 3)
				{
					print("What is the time complexity of a classical matrix multiplication algorithm?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("n^3"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is n^3.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 4)
				{
					print("What is the time complexity of the divide and conquer (not Strassen's) matrix multiplication algorithm?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("n^3"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is n^3.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 5)
				{
					print("What is the best case for merge sort?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("nlogn"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is nlogn.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 6)
				{
					print("What is the average case for merge sort?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("nlogn"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is nlogn.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 7)
				{
					print("What is the worst case for merge sort?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("nlogn"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is nlogn.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 8)
				{
					print("What is the best case for quick sort?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("nlogn"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is nlogn.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 9)
				{
					print("What is the average case for quick sort?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("nlogn"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is nlogn.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 10)
				{
					print("What is the worst case for quick sort?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("n^2"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is n^2.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 11)
				{
					print("What is the best case for bubble sort?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("n"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is n.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 12)
				{
					print("What is the average case for bubble sort?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("n^2"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is n^2.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 13)
				{
					print("What is the worst case for bubble sort?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("n^2"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is n^2.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 14)
				{
					print("What is the best case for binary search?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("1"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is 1.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 15)
				{
					print("What is the average case for binary search?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("logn"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is logn.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				else if (number == 16)
				{
					print("What is the worst case for binary search?", TimeUnit.MILLISECONDS, textDelay);
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					input = kb.nextLine();
					
					if (input.equalsIgnoreCase("logn"))
					{
						print("Correct!", TimeUnit.MILLISECONDS, textDelay);
						correct++;
					}
					else
					{
						print("Wrong, the complexity is logn.", TimeUnit.MILLISECONDS, textDelay);
					}
					print("\n", TimeUnit.MILLISECONDS, newLineDelay);
					
					completed++;
					found = true;
				}
				print("\n", TimeUnit.MILLISECONDS, newLineDelay);
			}
		}
		
		print("\n", TimeUnit.MILLISECONDS, newLineDelay);
		
		double grade = (correct/16)*100;
		
		if (grade == 100)
		{
			print("You got " + correct + "/16 correct and scored " + grade + "%! Fantastic!", TimeUnit.MILLISECONDS, textDelay);
		}
		else if (grade >= 90)
		{
			print("You got " + correct + "/16 correct and scored " + grade + "%! Great job!", TimeUnit.MILLISECONDS, textDelay);
		}
		else if (grade >= 80)
		{
			print("You got " + correct + "/16 correct and scored " + grade + "%! You're getting there!", TimeUnit.MILLISECONDS, textDelay);
		}
		else if (grade >= 70)
		{
			print("You got " + correct + "/16 correct and scored " + grade + "%! Keep trying!", TimeUnit.MILLISECONDS, textDelay);
		}
		else if (grade < 70)
		{
			print("You got " + correct + "/16 correct and scored " + grade + "%! Study harder!", TimeUnit.MILLISECONDS, textDelay);
		}
		
		//perhaps complexities?
		
		//additional questions (logloglogn, lower bound O(1))
		
		//additional need-to-knows, tower of hanoi and hw stuff
	}
	
	public static void print(String data, TimeUnit unit, long delay) throws InterruptedException
	{
		for (char ch : data.toCharArray())
		{
			System.out.print(ch);
			unit.sleep(delay);
		}
	}
}