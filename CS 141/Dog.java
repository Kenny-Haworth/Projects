// ****************************************************************
// Dog.java
//
// A class that holds a dog's name and can make it speak.
//
// ****************************************************************

public class Dog
{
	private int breedWeight;
 protected String name;
 // ------------------------------------------------------------
 // Constructor -- store name
 // ------------------------------------------------------------
 public Dog(String name)
 {
	this.name = name;
 }
 // ------------------------------------------------------------
 // Returns the dog's name
 // ------------------------------------------------------------
 public String getName()
 {
	return name;
 }
 // ------------------------------------------------------------
 // Returns a string with the dog's comments
 // ------------------------------------------------------------
 public String speak()
 {
	return "Woof";
 }
}

public class Labrador extends Dog
{
 private String color; //black, yellow, or chocolate?
 private static int breedWeight = 75;
 private String name;
 
 
 public Labrador(String name, String color)
{
	super(name);
	this.color = color;
}
 // ------------------------------------------------------------
 // Big bark -- overrides speak method in Dog
 // ------------------------------------------------------------
 public String speak()
 {
 return "WOOF";
 }
 // ------------------------------------------------------------
 // Returns weight
 // ------------------------------------------------------------
 public static int avgBreedWeight()
 {
 return breedWeight;
 }
 
 public String getColor()
 {
	 return new String(color);
 }
}
public class Yorkshire extends Dog
{
 public Yorkshire(String name)
 {
	super(name);
 }
 // ------------------------------------------------------------
 // Small bark -- overrides speak method in Dog
 // ------------------------------------------------------------
 public String speak()
 {
	return "woof";
 }
}