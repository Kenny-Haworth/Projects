public int compareTo(Hasan_Diamond other) 
{
	if (this.getCarot()<other.getCarot())
	{
		return 1;
	}
	else if (this.getCarot()>other.getCarot())
	{	
		return -1;
	}
	else
	{
		int thisIndex = getBestofClarityorColor(this);
		int otherIndex = getBestofClarityorColor(other);
		if(thisIndex < otherIndex)
		{	
			return -1;
		}
		else if(otherIndex < thisIndex)
		{	
			return 1;
		}
		else
		{
			return (LOOK AT CLARITY AND COLOR, COMPARE DIRECTLY)
		}
	}
}