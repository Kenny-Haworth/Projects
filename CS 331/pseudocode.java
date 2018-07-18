While (the number n has not been found)
{
	Split the data set into equal sizes of 1/3 and 2/3 of the data
	if (the value between these two sets equals the number n)
	{
		The number has been found
	}
	else if (the value is less than the value between these two sets)
	{
		take the left set (of size 1/3 the original) and loop
	}
	else if (the value is greater than the value between these two sets)
	{
		take the right set (of size 2/3 the original) and loop
	}
	else
	{
		the value does not exist in this data set
	}
}










//Let maxWeight be the maximum capacity of the knapsack
//objectWeights[] is an array of the weights of each object
//objectValues[] is an array of the values of each object
//n is the number of objects

int knapSack(int objectWeights[], int objectValues[], int n, int maxWeight)
{
	//double the size of objectWeights and objectValues, copy each of their elements and add it back to itself
	//this is because we have two copies of each object
	
	int row, column
	int graph[2*n+1][maxWeight+1] //there should be twice as many rows for 2 of each object
	
	//Build the graph row by row
	for (starting from row 0 to row 2n incrementing by 1)
	{
		for (starting from column 0 to column maxWeight incrementing by 1)
		{
			if (the row or column is 0) //first row and column is all zeroes
			{
				set graph[row][column] as 0
			}
			else if (objectWeights[row-1] <= column) //adding the item will not go over the bag's weight
			{
				//if adding the item gives more value, add it. Otherwise the value should be that of the previous cell
				graph[row][column] = max(objectValues[row-1] + graph[row-1][column-objectWeights[row-1]], graph[row-1][column])
			}
			else //adding the item will go over the bag's weight. The bag's weight should be the same as the last cell
			{
				graph[row][column] = graph[row-1][column]
			}
		}
	}
	
	return graph[n][maxWeight] //the optimal answer is in the very bottom right cell in the 2D array
}


















