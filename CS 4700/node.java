public class node implements Comparable<node>
{
	private int[][] gameBoard = new int[3][3];
	private int cost;
	private int numberOfSteps;
	String path; //some way of keeping track of where we have been
	
	public node(int[][] array, int expense, String newPath, int steps)
	{	
		cost = expense;
		
		for (int i = 0; i < 3; i++)
		{
			for (int q = 0; q < 3; q++)
			{
				gameBoard[i][q] = array[i][q];
			}
		}
		
		path = newPath;
		numberOfSteps = steps;
	}
	
	public void setBoard(int[][] board)
	{
		gameBoard = board;
	}
	
	public void setCost(int expense)
	{
		cost = expense;
	}
	
	public int getSteps()
	{
		return numberOfSteps;
	}
	
	public String getPath()
	{
		return path;
	}
	
	public int[][] getBoard()
	{
		return gameBoard;
	}
	
	public int getCost()
	{
		return cost;
	}

	public int compareTo(node other)
	{
		if (cost > other.getCost())
		{
			return 1;
		}
		else if (cost < other.getCost())
		{
			return -1;
		}
		
		return 0;
	}
}