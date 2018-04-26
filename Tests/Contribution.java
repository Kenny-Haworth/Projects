//This program calculates the amount of pay that will be contributed to a 
//retirement plan if 5%, 8%, and 10% of monthly pay is withheld.

public class Contribution
{
	public static void main(String[] args)
	{
		double monthlyPay = 6000.0;
		double contribution;
		
		contribution = monthlyPay * 0.05;
		System.out.println("5 percent is $" + contribution + " per month.");
		
		contribution = monthlyPay * 0.08;
		System.out.println("8 percent is $" + contribution + " per month.");
		
		contribution = monthlyPay * 0.1;
		System.out.println("5 percent is $" + contribution + " per month.");
	}
}
