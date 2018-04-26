public class Gerbil extends Rodent
{
	private String size;
	private int numTeeth;
	
	public Gerbil(String si, int teeth)
	{
		size = si;
		numTeeth = teeth;
	}
	
	public void setSize(String siz)
	{
		size = siz;
	}
	
	public void setNumTeeth(int teeth)
	{
		numTeeth = teeth;
	}
	
	public String getSize()
	{
		return size;
	}
	
	public int getNumTeeth()
	{
		return numTeeth;
	}
}