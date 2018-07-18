import java.util.Random;

public class arrayFun
{
	public static void main(String[] args)
	{
		int[] array1 = new int[100000];
		int[] array2 = new int[100000];
		
		Random random = new Random();
		
		for (int i = 0; i < array1.length; i++)
		{
			array1[i] = random.nextInt(100);
		}
		
		for (int i = 0; i < array2.length; i++)
		{
			array2[i] = random.nextInt(100);
		}
		
		/**System.out.println("Array 1's data: ");
		
		for (int i = 0; i < array1.length; i++)
		{
			System.out.print(array1[i] + " ");
		}
		
		System.out.println();
		System.out.println("Array 2's data: ");
		
		for (int i = 0; i < array2.length; i++)
		{
			System.out.print(array2[i] + " ");
		}*/
		
		for (int i = 1; i < array1.length; i++)
		{
			int c = i;
			while(array1[c] < array1[c-1])
			{
				int temp = array1[c-1];
				array1[c-1] = array1[c];
				array1[c] = temp;
				c--;
				
				if (c == 0)
				{
					break;
				}
			}
		}
		
		for (int i = 1; i < array2.length; i++)
		{
			int c = i;
			while(array2[c] < array2[c-1])
			{
				int temp = array2[c-1];
				array2[c-1] = array2[c];
				array2[c] = temp;
				c--;
				
				if (c == 0)
				{
					break;
				}
			}
		}
		
		/**System.out.println();
		System.out.println("Sorted array 1: ");
		
		for (int i = 0; i < array1.length; i++)
		{
			System.out.print(array1[i] + " ");
		}
		
		System.out.println();
		System.out.println("Sorted array 2: ");
		
		for (int i = 0; i < array2.length; i++)
		{
			System.out.print(array2[i] + " ");
		}*/
		
		int[] array = new int[array1.length + array2.length];
		
		int array1Pointer = 0;
		int array2Pointer = 0;
		
		for (int i = 0; i < array.length; i++)
		{
			if (array1Pointer >= array1.length)
			{
				array[i] = array2[array2Pointer];
				array2Pointer++;
			}
			else if (array2Pointer >= array2.length)
			{
				array[i] = array1[array1Pointer];
				array1Pointer++;
			}
			else if (array1[array1Pointer] < array2[array2Pointer])
			{
				array[i] = array1[array1Pointer];
				array1Pointer++;
			}
			else
			{
				array[i] = array2[array2Pointer];
				array2Pointer++;
			}
		}
		
		System.out.println();
		System.out.println("Sorted combined array: ");
		
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}
}

import java.util.StringTokenizer;
import java.lang.StringBuilder;

class Solution
{
    public String solution(String S, int K)
    {
        if (K == 1)
        {
            String upper = S.toUpperCase();
            return upper;
        }
        else
        {
            StringTokenizer token = new StringTokenizer(S, "-");
            StringBuilder stringBuilder = new StringBuilder();
            
            while (token.hasMoreTokens())
            {
                String cheese = token.nextToken();
                String upper = cheese.toUpperCase();
                
                stringBuilder.append(upper);
            }
            
            String hello = stringBuilder.toString();
            
            /**for (int i = K; i < hello.length(); i+=K)
            {
                stringBuilder.insert(i, "-");
            }*/
            
            for (int i = hello.length()-K; i > 0; i-=K)
            {
                stringBuilder.insert(i, "-");
            }
            
            return stringBuilder.toString();
        }
    }
}