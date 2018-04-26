import java.util.Scanner;
import java.io.*;
                        
public class Matthew
{
        public static void main(String []args) throws IOException
        {
                double[] array;
                
                array = inputData();
                System.out.println("Original Array: ");
                printArray(array);
                System.out.println("The average temperature is: " + average(array));
                System.out.println("The highest temperature is: " + max(array));
                System.out.println("The lowest temperature is: " + min(array));
                System.out.println("Sorted array: ");
                selectionSort(array);
        }                       
        public static double[] inputData() throws IOException
        {
                String filename;
                Scanner kb = new Scanner(System.in);
				
                 
                System.out.print("Enter input filename: ");
                filename = kb.nextLine();
                 
                File file = new File(filename);
                Scanner inputFile = new Scanner(file);
                int month = inputFile.nextInt();
				double[] array = new double[month];
                
                for (int i = 0; i < array.length; i++) // Puts values in the array for as long as the array is, according to the first number in the text file.
				{
					array[i] = inputFile.nextDouble();
				}
                inputFile.close();
                return array;
        }
        public static void printArray(double[] array)
        {
                Scanner kb = new Scanner(System.in);
                         
                System.out.println("Original array: ");  
                for(int i = 0; i < array.length; i++)
                {
                        System.out.print(array[i] + " ");
                        if(i % 10 == 0)
                        {
                                System.out.println("/n");
                        }
                }
        }
        public static double average(double[] array)
        {
                double total = 0;
                double average;
                for(int i = 0; i < array.length; i++)
                {
                        total += array[i];
                }
                average = total / array.length;

                return average;
        }
        public static double max(double[] array)
        {
                double highest = array[0];
                for(int i = 1; i < array.length; i++)
                {
                        if(array[i] > highest)
                        {
                                highest = array[i];
                        }
                }
                return highest;
        }
        public static double min(double[] array)
        {
                double lowest = array[0];
                for(int i = 1; i < array.length; i++)
                {
                        if(array[i] < lowest)
                        {
                                lowest = array[i];
                        }
                }
                return lowest;
        }
        public static void selectionSort(double[] array)
        {
                int startScan, index;
                int minIndex = 0;
                double minValue = 0;

                for(startScan = 0; startScan < (array.length - 1); startScan++)
                {
                        minIndex = startScan;
                        minValue = array[startScan];
                        for(index = startScan + 1; index < array.length; index++)
                        {
                                if(array[index] < minValue)
                                {
                                        minValue = array[index];
                                        minIndex = index;
                                }
                        }
                }
                array[minIndex] = array[startScan];
                array[startScan] = minValue;
                 
                System.out.println(array);   
        }
}
