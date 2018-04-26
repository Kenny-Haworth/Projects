public class Array_Haworth
{
	public static void main(String[] args)
	{
		int[][] array = new int[5][10];
		
		for (int column = 0; column < 10; column++)
		{
			array[0][column] = column;
		}
		
		for (int row = 1; row < 5; row++)
		{
			for (int col = 0; col < 10; col++)
			{
				array[row][col] = (array[row-1][col]+10);
			}
		}
		
		System.out.println("# |\t0\t1\t2\t3\t4\t5\t6\t7\t8\t9");
		System.out.println("\n------------------------------------------------------------------------------------");
		System.out.print("0 |\t");
		for (int p = 0; p < 10; p++)
		{
			System.out.print(array[0][p] + "\t");
		}
		System.out.print("\n1 |\t");
		for (int u = 0; u < 10; u++)
		{
			System.out.print(array[1][u] + "\t");
		}
		System.out.print("\n2 |\t");
		for (int l = 0; l < 10; l++)
		{
			System.out.print(array[2][l] + "\t");
		}
		System.out.print("\n3 |\t");
		for (int m = 0; m < 10; m++)
		{
			System.out.print(array[3][m] + "\t");
		}
		System.out.print("\n4 |\t");
		for (int o = 0; o < 10; o++)
		{
			System.out.print(array[4][o] + "\t");
		}
	}
}