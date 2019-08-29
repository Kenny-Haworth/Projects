//this is another method of filling newton's matrix using recursion
//however, it is very slow compared to traditional methods
//this is not a complete program

/**
 * This method computes all necessary C values for Newton's interpolation method and uses
 * them to fill out the matrix. It is a recursive function that starts at the most
 * complicated term (i.e. C(0,1,2,3,4) for 5 input points) and works down to the most
 * basic term (C(0)).
 * 
 * The first point represents the first parameters and the last point represents the last parameter.
 * For example, compute(1,4,matrix) is equivalent to computing C(1,2,3,4) and filling in the matrix
 * cell at the appropraite point.
 * 
 * @param first The first C value parameter
 * @param last The last C value parameter
 * @param matrix The matrix to fill in
 * @param x The x values of the points
 * @param y The y values of the points
 * @return Returns the C value. For example, C(0,1,2,3,4) might return the double 5.16.
 */
public static double compute(int first, int last, double[][] matrix, double[] x, double[] y)
{
    if (first == last) //base case
    {
        matrix[first][0] = y[first];
        return matrix[first][0];
    }
    else //recursive case
    {
        if (matrix[first+1][last-first-1] != 0 && matrix[first][last-1-first] != 0) //both data points are already computed and have been placed in the table, just use them
        {
            matrix[first][last-first] = (matrix[first+1][last-first-1] - matrix[first][last-1-first])/(x[last] - x[first]);
        }
        else if (matrix[first+1][last-first-1] != 0) //only the first data point has already been computed and placed in the table
        {
            matrix[first][last-first] = (matrix[first+1][last-first-1] - compute(first, last-1, matrix, x, y))/(x[last] - x[first]);
        }
        else if (matrix[first][last-1-first] != 0) //only the last data point has already been comptued and placed in the table
        {
            matrix[first][last-first] = (compute(first+1, last, matrix, x, y) - matrix[first][last-1-first])/(x[last] - x[first]);
        }
        else //neither points have been computed and placed in the table
        {
            matrix[first][last-first] = (compute(first+1, last, matrix, x, y) - compute(first, last-1, matrix, x, y))/(x[last] - x[first]);
        }

        return matrix[first][last-first];
    }
}