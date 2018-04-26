public class ShowCircleData
{
	public static void main(String[] args)
	{
		double variable = CircleCalculations.calculateArea(9);
		double variable2 = CircleCalculations.calculateCircumference(13);
		System.out.println("A circle with a radius of 9 has an area of: "+
							variable + " and a circle with a radius of 13 has a circumference of: " +
							variable2 + ".");
	}
}