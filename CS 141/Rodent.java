public class Rodent
{
	private String size;
	private int numTeeth;
	private String color;
	private String gender;
	
	Rodent[] animal = new Rodent[3];
	animal[1] = new Hamster("small", "black");
	animal[2] = new Mouse("large", 'm');
	animal[3] = new Gerbil("medium", 3438);
	
	public Rodent(String siz, int teeth, String colo, char gend)
	{
		size = siz;
		numTeeth = teeth;
		color = colo;
		gender = gend;
	}
	
	public void setSize(String siz)
	{
		size = siz;
	}
	
	public void setNumTeeth(int teeth)
	{
		numTeeth = teeth;
	}
	
	public void setColor(String colo)
	{
		color = colo;
	}
	
	public void setGender(char gend)
	{
		gender = gend;
	}
	
	public String getSize()
	{
		return size;
	}
	
	public int getNumTeeth()
	{
		return numTeeth;
	}
	
	public String getColor()
	{
		return color;
	}
	
}