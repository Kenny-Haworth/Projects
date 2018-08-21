/**
	A class to manage all of a colony's information.
*/

package Managers;

public class ColonyManager
{
	private int happiness;
	private int food;
	private int population;
	private int offense;
	private int defense;
	private int materials;
	
	public ColonyManager(int happ, int foo, int pop, int off, int def, int mat)
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
	//returns how much was added
	public int addHappiness(int amount)
	{
		if ((amount + happiness) > 100) //happiness caps at 100
		{
			int added = 100 - happiness; //the amount that was added
			happiness = 100;
			return added;
		}
		else
		{
			happiness += amount;
			return amount;
		}
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
	
	//returns how much was subtracted
	public int subtractHappiness(int amount)
	{
		if ((happiness - amount) < 0)
		{
			int subtracted = happiness;
			happiness = 0;
			return subtracted;
		}
		else
		{
			happiness -= amount;
			return amount;
		}
	}
	
	public int subtractFood(int amount)
	{
		if ((food - amount) < 0)
		{
			int subtracted = food;
			food = 0;
			return subtracted;
		}
		else
		{
			food -= amount;
			return amount;
		}
	}
	
	public int subtractPopulation(int amount)
	{
		if ((population - amount) < 0)
		{
			int subtracted = population;
			population = 0;
			return subtracted;
		}
		else
		{
			population -= amount;
			return amount;
		}
	}
	
	public int subtractOffense(int amount)
	{
		if ((offense - amount) < 0)
		{
			int subtracted = offense;
			offense = 0;
			return subtracted;
		}
		else
		{
			offense -= amount;
			return amount;
		}
	}
	
	public int subtractDefense(int amount)
	{
		if ((defense - amount) < 0)
		{
			int subtracted = defense;
			defense = 0;
			return subtracted;
		}
		else
		{
			defense -= amount;
			return amount;
		}
	}
	
	public int subtractMaterials(int amount)
	{
		if ((materials - amount) < 0)
		{
			int subtracted = materials;
			materials = 0;
			return subtracted;
		}
		else
		{
			materials -= amount;
			return amount;
		}
	}
}