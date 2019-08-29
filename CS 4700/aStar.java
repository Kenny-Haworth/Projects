import java.util.Scanner;
import java.util.StringTokenizer;
import java.lang.Math;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

public class aStar
{	
	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		System.out.println("1) Generate a random 8-puzzle problem");
		System.out.println("2) Input a custom 8-puzzle problem");
		System.out.print("Enter your number choice: ");
		int choice = kb.nextInt();
		kb.nextLine();
		
		int[][] gameBoard = new int[3][3];
		
		if (choice == 1) //random game board
		{
			do
			{
				ArrayList<Integer> numberList = new ArrayList<>();
				numberList.add(0);
				numberList.add(1);
				numberList.add(2);
				numberList.add(3);
				numberList.add(4);
				numberList.add(5);
				numberList.add(6);
				numberList.add(7);
				numberList.add(8);
				
				Collections.shuffle(numberList);
				
				for (int r = 0; r < gameBoard.length; r++)
				{
					for (int c = 0; c < gameBoard.length; c++)
					{
						int num = numberList.remove(numberList.size()-1);
						System.out.println(num);
						gameBoard[r][c] = num;
					}
				}
			}
			while(!isSolvable(gameBoard));
			
			int[][] temporaryBoard = new int[gameBoard.length][gameBoard.length];
			
			for (int r = 0; r < gameBoard.length; r++)
			{
				for (int c = 0; c < gameBoard.length; c++)
				{
					temporaryBoard[r][c] = gameBoard[r][c];
				}
				System.out.println();
			}
			
			
			solutionh1(gameBoard);
			solutionh2(temporaryBoard);
		}
		else //choice == 2, custom game board
		{
			do
			{
				System.out.print("Please enter your custom number order: "); //check for duplicates or numbers outside the range of 0-8 inclusive, AND it has to be solvable (inversions)
				String numbers = kb.nextLine();
				StringTokenizer token = new StringTokenizer(numbers, " ");
				
				for (int r = 0; r < gameBoard.length; r++)
				{
					for (int c = 0; c < gameBoard.length; c++)
					{
						gameBoard[r][c] = Integer.parseInt(token.nextToken());
					}
				}
				
				if (!isSolvable(gameBoard))
				{
					System.out.println("The inputted puzzle is not solvable! Please enter another puzzle: ");
				}
			}
			while(!isSolvable(gameBoard));
			
			int[][] temporaryBoard = new int[gameBoard.length][gameBoard.length];
			
			for (int r = 0; r < gameBoard.length; r++)
			{
				for (int c = 0; c < gameBoard.length; c++)
				{
					temporaryBoard[r][c] = gameBoard[r][c];
				}
				System.out.println();
			}
			
			System.out.println("HEURISTIC 1");
			solutionh1(gameBoard);
			System.out.println("\n\nHEURISTIC 2");
			solutionh2(temporaryBoard);
		}
	}
	
	public static void solutionh1(int[][] gameBoard)
	{
		double startTime = System.nanoTime();
		int nodesSearched = 0;
		
		PriorityQueue<node> queue = new PriorityQueue<node>();
		queue.add(new node(gameBoard, 0, "", 0)); //board, cost, path, number of steps
		ArrayList<String> seenGameBoards = new ArrayList<String>();
		seenGameBoards.add(gameBoardtoString(gameBoard));
		
		while (queue.size() != 0)
		{
			node currentNode = queue.poll();
			int[][] currentBoard = currentNode.getBoard();
			
			if (isSolution(currentBoard))
			{
				double duration = System.nanoTime() - startTime;
				System.out.println("Time taken in milliseconds: " + duration/1000000);
				System.out.println("Number of nodes searched: " + nodesSearched);
				System.out.println("Optimal number of moves/depth: " + currentNode.getPath().length()/4);
				
				System.out.println("Initial puzzle: ");
				for (int r = 0; r < gameBoard.length; r++)
				{
					for (int c = 0; c < gameBoard.length; c++)
					{
						System.out.print(gameBoard[r][c]);
					}
					System.out.println();
				}
				System.out.println();
				
				String path = currentNode.getPath();
				
				for (int i = 0; i < path.length(); i+=4)
				{
					int row = path.charAt(i) - '0';
					int col = path.charAt(i+1) - '0';
					int row2 = path.charAt(i+2) - '0';
					int col2 = path.charAt(i+3) - '0';
					
					int temp = gameBoard[row][col];
					gameBoard[row][col] = gameBoard[row2][col2];
					gameBoard[row2][col2] = temp;
					
					System.out.println("Step " + ((i/4)+1) + ":");
					for (int r = 0; r < gameBoard.length; r++)
					{
						for (int c = 0; c < gameBoard.length; c++)
						{
							System.out.print(gameBoard[r][c]);
						}
						System.out.println();
					}
					System.out.println();
				}
				
				break;
			}
			else
			{
				int row = 0; //where the 0/space is located
				int column = 0;
				
				for (int r = 0; r < currentBoard.length; r++)
				{
					for (int c = 0; c < currentBoard.length; c++)
					{
						if (currentBoard[r][c] == 0)
						{
							row = r;
							column = c;
						}
					}
				}
				
				//create a copy of gameBoard
				int[][] tempBoard = new int[currentBoard.length][currentBoard.length];
				for (int r = 0; r < tempBoard.length; r++)
				{
					for (int c = 0; c < tempBoard.length; c++)
					{
						tempBoard[r][c] = currentBoard[r][c];
					}
				}
				
				//generate UP TO 4 new game boards
				for (int i = 0; i < 4; i++)
				{	
					int currentRow = 0;
					int currentCol = 0;
					
					if (i == 0)
					{
						currentRow = row-1;
						currentCol = column;
					}
					else if (i == 1)
					{
						currentRow = row;
						currentCol = column-1;
					}
					else if (i == 2)
					{
						currentRow = row+1;
						currentCol = column;
					}
					else if (i == 3)
					{
						currentRow = row;
						currentCol = column+1;
					}
					
					if (!((currentRow < 0 || currentRow > 2) || (currentCol < 0 || currentCol > 2)))
					{
						//swap 0 with valid position
						int temp = tempBoard[row][column];
						tempBoard[row][column] = tempBoard[currentRow][currentCol];
						tempBoard[currentRow][currentCol] = temp;
						
						if (!(seenGameBoards.contains(gameBoardtoString(tempBoard))))
						{
							seenGameBoards.add(gameBoardtoString(tempBoard));
							
							String path = Integer.toString(row) + Integer.toString(column) + Integer.toString(currentRow) + Integer.toString(currentCol);
							
							queue.add(new node(tempBoard, currentNode.getSteps() + heuristic1(tempBoard), currentNode.getPath() + path, currentNode.getSteps() + 1));
						}
						
						//reset the temporary board
						for (int r = 0; r < tempBoard.length; r++)
						{
							for (int c = 0; c < tempBoard.length; c++)
							{
								tempBoard[r][c] = currentBoard[r][c];
							}
						}
					}
				}
				
				nodesSearched += 1;
			}
		}
	}
	
	public static void solutionh2(int[][] gameBoard)
	{
				double startTime = System.nanoTime();
		int nodesSearched = 0;
		
		PriorityQueue<node> queue = new PriorityQueue<node>();
		queue.add(new node(gameBoard, 0, "", 0)); //board, cost, path, number of steps
		ArrayList<String> seenGameBoards = new ArrayList<String>();
		seenGameBoards.add(gameBoardtoString(gameBoard));
		
		while (queue.size() != 0)
		{
			node currentNode = queue.poll();
			int[][] currentBoard = currentNode.getBoard();
			
			if (isSolution(currentBoard))
			{
				double duration = System.nanoTime() - startTime;
				System.out.println("Time taken in milliseconds: " + duration/1000000);
				System.out.println("Number of nodes searched: " + nodesSearched);
				System.out.println("Optimal number of moves/depth: " + currentNode.getPath().length()/4);
				
				System.out.println("Initial puzzle: ");
				for (int r = 0; r < gameBoard.length; r++)
				{
					for (int c = 0; c < gameBoard.length; c++)
					{
						System.out.print(gameBoard[r][c]);
					}
					System.out.println();
				}
				System.out.println();
				
				String path = currentNode.getPath();
				
				for (int i = 0; i < path.length(); i+=4)
				{
					int row = path.charAt(i) - '0';
					int col = path.charAt(i+1) - '0';
					int row2 = path.charAt(i+2) - '0';
					int col2 = path.charAt(i+3) - '0';
					
					int temp = gameBoard[row][col];
					gameBoard[row][col] = gameBoard[row2][col2];
					gameBoard[row2][col2] = temp;
					
					System.out.println("Step " + ((i/4)+1) + ":");
					for (int r = 0; r < gameBoard.length; r++)
					{
						for (int c = 0; c < gameBoard.length; c++)
						{
							System.out.print(gameBoard[r][c]);
						}
						System.out.println();
					}
					System.out.println();
				}
				
				break;
			}
			else
			{
				int row = 0; //where the 0/space is located
				int column = 0;
				
				for (int r = 0; r < currentBoard.length; r++)
				{
					for (int c = 0; c < currentBoard.length; c++)
					{
						if (currentBoard[r][c] == 0)
						{
							row = r;
							column = c;
						}
					}
				}
				
				//create a copy of gameBoard
				int[][] tempBoard = new int[currentBoard.length][currentBoard.length];
				for (int r = 0; r < tempBoard.length; r++)
				{
					for (int c = 0; c < tempBoard.length; c++)
					{
						tempBoard[r][c] = currentBoard[r][c];
					}
				}
				
				//generate UP TO 4 new game boards
				for (int i = 0; i < 4; i++)
				{	
					int currentRow = 0;
					int currentCol = 0;
					
					if (i == 0)
					{
						currentRow = row-1;
						currentCol = column;
					}
					else if (i == 1)
					{
						currentRow = row;
						currentCol = column-1;
					}
					else if (i == 2)
					{
						currentRow = row+1;
						currentCol = column;
					}
					else if (i == 3)
					{
						currentRow = row;
						currentCol = column+1;
					}
					
					if (!((currentRow < 0 || currentRow > 2) || (currentCol < 0 || currentCol > 2)))
					{
						//swap 0 with valid position
						int temp = tempBoard[row][column];
						tempBoard[row][column] = tempBoard[currentRow][currentCol];
						tempBoard[currentRow][currentCol] = temp;
						
						if (!(seenGameBoards.contains(gameBoardtoString(tempBoard))))
						{
							seenGameBoards.add(gameBoardtoString(tempBoard));
							
							String path = Integer.toString(row) + Integer.toString(column) + Integer.toString(currentRow) + Integer.toString(currentCol);
							
							queue.add(new node(tempBoard, currentNode.getSteps() + heuristic2(tempBoard), currentNode.getPath() + path, currentNode.getSteps() + 1));
						}
						
						//reset the temporary board
						for (int r = 0; r < tempBoard.length; r++)
						{
							for (int c = 0; c < tempBoard.length; c++)
							{
								tempBoard[r][c] = currentBoard[r][c];
							}
						}
					}
				}
				
				nodesSearched += 1;
			}
		}
	}
	
	public static int heuristic1(int[][] gameBoard)
	{
		int current = 0;
		int count = 0;
		
		for (int r = 0; r < gameBoard.length; r++)
		{
			for (int c = 0; c < gameBoard.length; c++)
			{
				if (gameBoard[r][c] != current++)
				{
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static int heuristic2(int[][] gameBoard)
	{
		int current = 0;
		int count = 0;
		
		for (int r = 0; r < gameBoard.length; r++)
		{
			for (int c = 0; c < gameBoard.length; c++)
			{
				if (gameBoard[r][c] != current++)
				{
					int var = gameBoard[r][c];
					
					int expectedCol = var%3;
					int expectedRow = (var*3) + expectedCol;
					
					count += Math.abs(expectedRow - r);
					count += Math.abs(expectedCol - c);
				}
			}
		}
		
		return count;
	}
	
	public static boolean isSolution(int[][] gameBoard)
	{
		int current = 0;
		
		for (int r = 0; r < gameBoard.length; r++)
		{
			for (int c = 0; c < gameBoard.length; c++)
			{
				if (gameBoard[r][c] != current++)
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static String gameBoardtoString(int[][] gameBoard)
	{
		String number = "";
		
		for (int r = 0; r < gameBoard.length; r++)
		{
			for (int c = 0; c < gameBoard.length; c++)
			{
				number += Integer.toString(gameBoard[r][c]);
			}
		}
		
		return number;
	}
	
	public static boolean isSolvable(int[][] gameBoard)
	{
		int count = 0;
		
		String cheese = gameBoardtoString(gameBoard);
		
		for (int i = 0; i < cheese.length(); i++)
		{
			for (int j = i; j < cheese.length(); j++)
			{
				if (Integer.parseInt(cheese.charAt(i) + "") > Integer.parseInt(cheese.charAt(j) + "") && Integer.parseInt(cheese.charAt(j) + "") != 0)
				{
					count++;
				}
			}
		}
		
		return (count % 2 == 0);
	}
	
	/**
	for (int r = 0; r < gameBoard.length; r++)
	{
		for (int c = 0; c < gameBoard.length; c++)
		{
			System.out.print(gameBoard[r][c]);
		}
		System.out.println();
	}
	*/
}