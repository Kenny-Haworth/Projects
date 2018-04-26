//This program calculates the sale price of an item that is regulary priced at $59,
//with a 20 percent discount subtracted.

public class Discount
{
	public static void main(String[] args)
	{
		double regularPrice = 59.0;
		double discount;
		double salePrice;
		
		discount = regularPrice * .2;
		
		salePrice = regularPrice - discount;
		
		System.out.println("Regular price: $" + regularPrice);
		System.out.println("Discount amount $" + discount);
		System.out.println("Sale price: $" + salePrice);
	}
}