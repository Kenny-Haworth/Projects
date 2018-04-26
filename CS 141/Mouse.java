public class Mouse extends Rodent
{
	private String size;
	private char gender;
	
	public Mouse(String si, char gen)
	{
		size = si;
		gender = gen;
	}
	
	public void setSize(String siz)
	{
		size = siz;
	}
	
	public void setGender(char gend)
	{
		gender = gend;
	}
	
	public String getSize()
	{
		return size;
	}
	
	public char getGender()
	{
		return gender;
	}
}