public class Hamster extends Rodent
{
	private String size;
	private String color;
	
	public Hamster(String si, String col)
	{
		size = si;
		color = col;
	}
	
	public void setSize(String siz)
	{
		size = siz;
	}
	
	public void setColor(String colo)
	{
		color = colo;
	}
	
	public String getSize()
	{
		return size;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public char getGender()
	{
		return gender;
	}
}