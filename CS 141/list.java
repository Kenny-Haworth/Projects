import java.util.ArrayList;

public class list
{
	public static void main(String[] args)
	{
		ArrayList<Integer> numList = new ArrayList<Integer>();
		
		numList.add(10);
		numList.add(20);
		numList.add(30);
		
		System.out.println(numList);
		
		int number;
		int q = 2;
		
		for (int index = 0; index < 2; index++)
		{
			number = numList.get(index);
			numList.set(q, ++number);
			--q;
		}
		
		System.out.println(numList);
		
		/*
		
		int a = numList.get(0);
		int b = numList.get(1);
		int c = numList.get(2);

		numList.set(0, ++c);
		numList.set(1, ++b);
		numList.set(2, ++a);
		
		System.out.println(numList);*/
	}
}