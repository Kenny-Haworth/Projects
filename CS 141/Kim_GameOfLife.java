public class Kim_GameOfLife
{
	int rows;
	int columns;
	char[][] array;
	char[][] tempArray;

	public static void main(String[] args) throws IOException
{
Scanner keyboard = new Scanner(System.in);

Kim_GameOfLife game = new Kim_GameOfLife();

System.out.println("Enter how many generations to compute: ");
int generation = keyboard.nextInt();
game.print();
computeNextGeneration(generation);
}

        public Kim_GameOfLife() throws IOException
        {
                Scanner keyboard = new Scanner(System.in);

                System.out.println("Enter file name: ");
                String filename = keyboard.nextLine();

                File file = new File(filename);
                Scanner inputFile = new Scanner(file);

                int columns = inputFile.nextInt();
                int rows = inputFile.nextInt();

                char[][] array = new char[rows][columns];
				char[][] tempArray = new char[rows][columns];

                print();
        }

        public int getCell(int column, int row)
        {
                if(column > columns)
                {
return 0;
                }
                if(row > rows)
                {
                        return 0;
                }
                return value;
        }

        public void setCell(int column, int row, int value)
        {
                if(value == 0)
                {
                        array[row][column] = '0';
                }
                else if(value == 1)
                {
                        array[row][column] = 'X';
                }
        }

        public static void computeNextGeneration(int generation)
        {
               
                for(int r = 0; r < rows; r++)
                {
                        for(int c = 0; c < columns; c++)
                        {
                                array[r][c] = tempArray[r][c];
                        }
                }
                int count = 1;
                if(generation != 0)
                {
                        System.out.println("Generation " + count);
                        System.out.println(tempArray);
                        computeNextGeneration(generation);
                        generation--;
                        count++;
                }
        }
 public int isNextGenAlive(int rows, int columns)
{
                int countNeighbors = 0;
                                if(array[r-1][c-1] == 1)
                                {
                                        countNeighbors++;
                                        continue;
                                }
                                else if(array[r-1][c] == 1)
                                {
                                        countNeighbors++;
                                        continue;
                                }
                                else if(array[r-1][c+1] == 1)
                                {
                                        countNeighbors++; 
                                        continue;
                                }
                                else if(array[r][c-1] == 1)
                                {
                                        countNeighbors++;
                                        continue;
                                }
                                else if(array[r][c+1] == 1)
                                {
                                        countNeighbors++;
                                        continue;
                                }
                                else if(array[r+1][c-1] == 1)
                                {
                                        countNeighbors++;
                                        continue;
                                }
                                else if(array[r+1][c] == 1)
                                {
                                        countNeighbors++;
                                        continue;
                                }
                                else if(array[r+1][c+1] == 1)
                                {
                                        countNeighbors++; 
                                }
                }
public void print()
        {
                for(int r = 0; r < rows; r++)
                {
                        for(int c = 0; c < columns; c++)
                        {
                                System.out.println(array[r][c]);
                        }
                                        
                }
        }
}