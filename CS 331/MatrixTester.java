/*
*  Name: Matias Mariano Kim
*  Professor: Dr. Gilbert Young
*  Class: CS 331 Design and Analysis of Algorithms
*  Assignment: Project #1
*  Due Date: 5/10/2018
*/

import java.util.Random;

public class MatrixTester 
{
    static int matrixSize;
    /*
    *   The main method runs through an infinite loop starting with the
    *   value n, and increasing at a rate of 2^i. Then, two random square 
    *   matrices are generated and each algorithm will run 50 times respectively
    *   and the average time spent at a given instance is calculated.
    */
    public static void main(String[] args) 
    {
        final int NUMOFTIMES = 3;
        int n;
        long bTime, fTime;
        long TimeC = 0;
        long TimeDC = 0;
        long TimeS = 0;
        int[][] A, B;
        
        for(int i = 1; i > 0; i++)
        {
            n = (int) Math.pow(2, i);
            matrixSize = n;
            
            A = createMatrix(n);
            B = createMatrix(n);
            
            for(int j = 0; j < NUMOFTIMES; j++)
            {
                bTime = System.nanoTime();
                classicMatrixMultiplication(A, B, A.length);
                fTime = System.nanoTime();
                TimeC += fTime - bTime;
                
                bTime = System.nanoTime();
                divideAndConquerMatrixMultiplication(A, B, A.length);
                fTime = System.nanoTime();
                TimeDC += fTime - bTime;
                
                bTime = System.nanoTime();
                strassenMatrixMultiplication(A, B, A.length);
                fTime = System.nanoTime();
                TimeS += fTime - bTime;
            }
            
            TimeC = TimeC / NUMOFTIMES;
            TimeDC = TimeDC / NUMOFTIMES;
            TimeS = TimeS / NUMOFTIMES;  
            
            System.out.println("For n = " + n + ":");
            System.out.println("Classic Matrix Multiplication time in nanoseconds: ");
            System.out.println(TimeC);
            System.out.println("Classic Matrix Multiplication time in seconds: ");
            System.out.println(TimeC / 1000000000.0);
            System.out.println("Divide and Conquer Matrix Multiplication time in nanoseconds: ");
            System.out.println(TimeDC);
            System.out.println("Divide and Conquer Matrix Multiplication time in seconds: ");
            System.out.println(TimeDC / 1000000000.0);
            System.out.println("Strassen's Matrix Multiplication time in nanoseconds: ");
            System.out.println(TimeS);
            System.out.println("Strassen's Matrix Multiplication time in seconds: ");
            System.out.println(TimeS / 1000000000.0);
            System.out.println();
        }
    }  
    
    /*
    *   This method will create a square matrix given parameter of size n 
    *   and fill the matrix with random numbers ranging from 0 to 100.
    */
    public static int[][] createMatrix(int n)
    {
        Random randomizer = new Random();
        int[][] matrix = new int[n][n];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                matrix[i][j] = randomizer.nextInt(100);
            }
        }
        return matrix;
    }
    
    /*
    *   This method entails the classicmatrix multiplication algorithm
    *   It takes the two square matrices A and B as parameters as well as
    *   a variable n that indicates the size of the new matrix C. This
    *   method involves three nested for loops and simple arithmetic.
    */
    public static int[][] classicMatrixMultiplication(int[][] A, int[][] B, int n)
    {
        int[][] C = new int[matrixSize][matrixSize];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                for(int k = 0; k < n; k++)
                {
                    C[i][j] += A[i][j] * B[k][j];
                }
            }
        }
        return C;
    }
    
    /*
    *   This method demonstrates the divide-and-conquer method of 
    *   matrix multiplication which once again takes two square matrices
    *   A and B as parameters and also a variable n that indicates the size 
    *   of the new matrix C. The approach of this method is that it recursively
    *   calls itself and divides the matrix into smaller matrices that comprise
    *   of 1/4 of the size of the starting matrix.
    */
    public static int[][] divideAndConquerMatrixMultiplication(int[][] A, int[][] B, int n)
    {
        int[][] C = new int[n][n];
        
        if(n == 1)
        {
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }
        else
        {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
            
            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);
            split(A, B11, 0, 0);
            split(A, B12, 0, n / 2);
            split(A, B21, n / 2, 0);
            split(A, B22, n / 2, n / 2);
            
            int[][] C11 = add(divideAndConquerMatrixMultiplication(A11, B11, n / 2), divideAndConquerMatrixMultiplication(A12, B21, n / 2), n / 2);
            int[][] C12 = add(divideAndConquerMatrixMultiplication(A11, B12, n / 2), divideAndConquerMatrixMultiplication(A12, B22, n / 2), n / 2);
            int[][] C21 = add(divideAndConquerMatrixMultiplication(A21, B11, n / 2), divideAndConquerMatrixMultiplication(A22, B21, n / 2), n / 2);
            int[][] C22 = add(divideAndConquerMatrixMultiplication(A21, B12, n / 2), divideAndConquerMatrixMultiplication(A22, B22, n / 2), n / 2);
            
            build(C11, C, 0, 0);
            build(C12, C, 0, n / 2);
            build(C21, C, n / 2, 0);
            build(C22, C, n / 2, n / 2);
        }
        return C;
    }
    
    /*
    *   This method simply calls the strassenMatrixMultiplication method and 
    *   returns the value of the newly created matrix C with size of n.
    */
    public static int[][] strassenMatrixMultiplication(int[][] A, int[][] B, int n)
    {
        int[][] C = new int[n][n];
        strassenMatrixMultiplicationGuide(A, B, C, n);
        return C;
    }
    
    /*
    *   This method entails Strassen's Matrix Multiplication algorithm which
    *   first utilizes the divide-and-conquer method and then creates 7 different
    *   matrices from P - V. These matrices will all be used to create a new matrix
    *   C with size of n.
    */
    public static void strassenMatrixMultiplicationGuide(int[][] A, int[][] B, int[][] C, int n)
    {
        if(n == 2)
        {
            C[0][0] = (A[0][0] * B[0][0]) + (A[0][1] * B[1][0]);
            C[0][1] = (A[0][0] * B[0][1]) + (A[0][1] * B[1][1]);
            C[1][0] = (A[1][0] * B[0][0]) + (A[1][1] * B[1][0]);
            C[1][1] = (A[1][0] * B[0][1]) + (A[1][1] * B[1][1]);
        }
        else
        {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
            
            int[][] P = new int[n/2][n/2];
            int[][] Q = new int[n/2][n/2];
            int[][] R = new int[n/2][n/2];
            int[][] S = new int[n/2][n/2];
            int[][] T = new int[n/2][n/2];
            int[][] U = new int[n/2][n/2];
            int[][] V = new int[n/2][n/2];
            
            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);
            split(A, B11, 0, 0);
            split(A, B12, 0, n / 2);
            split(A, B21, n / 2, 0);
            split(A, B22, n / 2, n / 2);
            
            strassenMatrixMultiplicationGuide(add(A11, A22, n / 2), add(B11, B22, n / 2), P, n / 2);
            strassenMatrixMultiplicationGuide(add(A21, A22, n / 2), B11, Q, n / 2);
            strassenMatrixMultiplicationGuide(A11, sub(B12, B22, n / 2), R, n / 2);
            strassenMatrixMultiplicationGuide(A22, sub(B21, B11, n / 2), S, n / 2);
            strassenMatrixMultiplicationGuide(add(A11, A12, n / 2), B22, T, n / 2);
            strassenMatrixMultiplicationGuide(sub(A21, A11, n / 2), add(B11, B12, n / 2), U, n / 2);
            strassenMatrixMultiplicationGuide(sub(A12, A22, n / 2), add(B21, B22, n / 2), V, n / 2);
            
            int[][] C11 = add(sub(add(P, S, P.length), T, T.length), V, V.length);
            int[][] C12 = add(R, T, R.length);
            int[][] C21 = add(Q, S, Q.length);
            int[][] C22 = add(sub(add(P, R, P.length), Q, Q.length), U, U.length);
    
            build(C11, C, 0, 0);
            build(C12, C, 0 , n / 2);
            build(C21, C, n / 2, 0);
            build(C22, C, n / 2, n / 2);
        }
    }
        
    /*
    *   This method essentially constructs a new matrix based off smaller matrices.
    *   It takes both the initialMatrix and the finalMatrix as parameters and pieces
    *   the initialMatrix in order to create the finalMatrix.
    */
    private static void build(int[][] initialMatrix, int[][] finalMatrix, int a, int b)
    {
        int c = b;
        
        for(int i = 0; i < initialMatrix.length; i++)
        {
            for(int j = 0; j < initialMatrix.length; j++)
            {
                finalMatrix[a][c++] = initialMatrix[i][j];
            }
            c = b;
            a++;
        }
    }
    
    /*
    *   The add method basically adds the components of one matrix to
    *   another to create a new matrix and it takes two matrices, A and B, as 
    *   parameters.
    */
    private static int[][] add(int[][] A, int[][] B, int n)
    {
        int[][] C = new int[n][n];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }
    
    /*
    *   The sub method basically subtracts the components of one matrix from
    *   another to create a new matrix and it takes two matrices, A and B, as 
    *   parameters.
    */
    private static int[][] sub(int[][] A, int[][] B, int n)
    {
        int[][] C = new int[n][n];
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }
    /*
    *   This method essentially deconstructs a matrix into smaller matrices.
    *   It takes both the initialMatrix and the finalMatrix as parameters and 
    *   splits the finalMatrix to create smaller matrices.
    */
    private static void split(int[][] initialMatrix, int[][] finalMatrix, int a, int b)
    {
        int c = b;
        
        for(int i = 0; i < finalMatrix.length; i++)
        {
            for(int j = 0; j < finalMatrix.length; j++)
            {
                finalMatrix[i][j] = initialMatrix[a][c++];
            }
            c = b;
            a++;
        }
    }
}
