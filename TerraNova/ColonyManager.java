/**
	A class to manage all of a colony's information.
*/

public class ColonyManager
{
	private int happiness;
	private int food;
	private int population;
	private int offense;
	private int defense;
	private int materials;
	
	ColonyManager(int happ, int foo, int pop, int off, int def, int mat)
	{
		happiness = happ;
		food = foo;
		population = pop;
		offense = off;
		defense = def;
		materials = mat;
	}
	
	//getters
	public int getHappiness()
	{
		return happiness;
	}
	
	public int getFood()
	{
		return food;
	}
	
	public int getPopulation()
	{
		return population;
	}
	
	public int getOffense()
	{
		return offense;
	}
	
	public int getDefense()
	{
		return defense;
	}
	
	public int getMaterials()
	{
		return materials;
	}
	
	//methods
	public void addHappiness(int amount)
	{
		happiness += amount;
	}
	
	public void addFood(int amount)
	{
		food += amount;
	}
	
	public void addPopulation(int amount)
	{
		population += amount;
	}
	
	public void addOffense(int amount)
	{
		offense += amount;
	}
	
	public void addDefense(int amount)
	{
		defense += amount;
	}
	
	public void addMaterials(int amount)
	{
		materials += amount;
	}
	
	public void subtractHappiness(int amount)
	{
		happiness -= amount;
	}
	
	public void subtractFood(int amount)
	{
		food -= amount;
	}
	
	public void subtractPopulation(int amount)
	{
		population -= amount;
	}
	
	public void subtractOffense(int amount)
	{
		offense -= amount;
	}
	
	public void subtractDefense(int amount)
	{
		defense -= amount;
	}
	
	public void subtractMaterials(int amount)
	{
		materials -= amount;
	}
}