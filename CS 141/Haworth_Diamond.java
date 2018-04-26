/***************************************************************
* File: Haworth_Diamond.java
* Author: Kendall Haworth
* Class: CS 141-01 – Intro to Programming and Problem Solving
*
* Assignment: Program 4
* Date last modified: 2/14/2017
*
* Purpose: This program is a class for the DiamondTester.java program
* that will create an array of Haworth_Diamond objects, return them, and sort them.
* 
****************************************************************/

public class Haworth_Diamond implements Comparable<Haworth_Diamond>
{	
	private enum ClarityGrade {FL, IF, VVS1, VVS2, VS1, VS2, SI1, SI2, I1, I2, I3}
							// DE, FG, HI  , JK  , LM , NO , PQ , RS , TU, VW, XY, Z
							// This enum will be used later to compare to the colors shown beneath the enum,
							// with each enum equal to two colors until the end as shown.
	ClarityGrade grade;
	
	private String stockNumber;
	private double carot;
	private String clarity;
	private char color;
	private String cut;
	
	// Constructor: Haworth_Diamond
	// Purpose: Initializes all the variables for the Haworth_Diamond object.
	
	public Haworth_Diamond(String stock, double car, String clar, char col, String cu)
	{
		stockNumber = stock;
		carot = car;
		clarity = clar;
		color = col;
		cut = cu;
	}
	
	// Method: getStock
	// Purpose: Returns the stockNumber.
	
	public String getStock()
	{
		return new String(stockNumber);
	}
	
	// Method: getCarot
	// Purpose: Returns the carot.
	
	public double getCarot()
	{
		return carot;
	}
	
	// Method: getClarity
	// Purpose: Returns the clarity.
	
	public String getClarity()
	{
		return new String(clarity);
	}
	
	// Method: getColor
	// Purpose: Returns the color.
	
	public char getColor()
	{
		return color;
	}
	
	// Method: getCut
	// Purpose: Returns the cut.
	
	public String getCut()
	{
		return new String(cut);
	}
	
	// Method: toString
	// Purpose: Returns a string of the sent object's information.
	
	public String toString()
	{
		return "The diamond's information is as follows: " +
				"The stockNumber is " + stockNumber +
				", the  carot is " + carot +
				", the clarity is " + clarity +
				", the color is " + color +
				", and the cut is " + cut + ".";
	}
	
	// Method: compareTo
	// Purpose: Compares the carot, color, and clarity of Haworth_Diamond objects to sort them.
	
	public int compareTo(Haworth_Diamond other)
	{
		if (this.getCarot()<other.getCarot())	// First the carot's are compared, with the best carot getting precedence in sorting.
		{
			return 1;
		}
		else if (this.getCarot()>other.getCarot())
		{
			return -1;
		}
		else
		{
			if (this.bestAttributeValue()>other.bestAttributeValue()) // If the carots are the same, the Haworth_Diamond objects are then
			{														  // sorted in the array based upon their best attribute, which is either
				return 1;											  // clarity or color. See the bestAttributeValue() method.
			}
			else if (this.bestAttributeValue()<other.bestAttributeValue())
			{
				return -1;
			}
			else	// If they have the same value for the best attribute, then the "worst" attribute's need to be compared.
			{
				if ((grade.valueOf(this.getClarity()).ordinal())>(grade.valueOf(other.getClarity()).ordinal())) // The operations performed here are similar to the bestAttributeValue() method.
				{
					return 1;
				}
				else if ((grade.valueOf(this.getClarity()).ordinal())<(grade.valueOf(other.getClarity()).ordinal()))
				{
					return -1;
				}
				else
				{
					if ((Math.floor(this.getColor() - 'D') * .5)>(Math.floor(other.getColor() - 'D') * .5)) // The operations performed here are similar to the bestAttributeValue() method.
					{
						return 1;
					}
					else if ((Math.floor(this.getColor() - 'D') * .5)<(Math.floor(other.getColor() - 'D') * .5))
					{
						return -1;
					}
					else // Finally, if their carot, clarity, and color values are the same they do not need to be swapped, as the objects are the same.
					{
						return 0;
					}
				}
			}
		}		
	}
	
	// Method: bestAttributeValue()
	// Purpose: To return whatever is better for the particular Haworth_Diamond object,
	//			either the clarity or the color.
	
	public double bestAttributeValue()
	{
		double colorNumber = Math.floor((getColor() - 'D') * .5);	// The color value is multiplied by .5 and rounded using Math.floor
																	// so that each set of two values (such as the first two, 0*.5 and .5*.5)
																	// will always equal the value of the corresponding clarity.

		double clarityNumber = grade.valueOf(getClarity()).ordinal(); // Here the enum at the very beginning of the class is called. First, the Haworth_Diamond object's
																	  // clarity String is called "using grade.valueOf(getClarity())" and set equal to the corresponding enum value.
																	  // Then the placement of it in the enum is returned using "ordinal()".
		
		if (colorNumber < clarityNumber) // We want to return the "better" attribute, which is the lowest number.
		{
			return colorNumber;
		}
		else if (colorNumber > clarityNumber)
		{
			return clarityNumber;
		}
		else // If the best attribute is exactly the same for the object's clarity and color, it doesn't matter which is returned.
		{
			return colorNumber;
		}
	}
}