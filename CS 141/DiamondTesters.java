import java.util.Arrays;

public class DiamondTester
{
  public static void main (String[] args)
  {
    Hasan_Diamond[] stones = new Hasan_Diamond[16];
    
    stones[0] = new Hasan_Diamond( "A1023",  1.0, "VS1",  'F', "brilliant");
    stones[1] = new Hasan_Diamond( "A5911",  1.1, "VVS2", 'G', "rose");
    stones[2] = new Hasan_Diamond( "C5427",  1.0, "VS1",  'D', "princess");
    stones[3] = new Hasan_Diamond( "D8307",  1.6, "SI1",  'H', "brilliant");
    stones[4] = new Hasan_Diamond( "B4825",  0.3, "I1",   'D', "rose");
    stones[5] = new Hasan_Diamond( "A1844",  2.1, "VS2",  'D', "lozenge");
    stones[6] = new Hasan_Diamond( "A3747",  3.1, "SI2",  'W', "baguette");
    stones[7] = new Hasan_Diamond( "E6393",  2.3, "VS2",  'I', "brilliant");
    stones[8] = new Hasan_Diamond( "C5619",  2.8, "VVS1", 'E', "pear");
    stones[9] = new Hasan_Diamond( "E8348",  1.4, "VS2",  'G', "brilliant");
    stones[10] = new Hasan_Diamond("D2381",  1.7, "I3",   'G', "brilliant");
    stones[11] = new Hasan_Diamond("C9253",  1.3, "VS2",  'H', "baguette");
    stones[12] = new Hasan_Diamond("G3459",  2.1, "VS2",  'H', "rose");
    stones[13] = new Hasan_Diamond("B3598",  2.4, "VVS2", 'D', "pear");
    stones[14] = new Hasan_Diamond("D9836",  2.8, "IF",   'E', "princess");
    stones[15] = new Hasan_Diamond("E1046",  2.2, "FL",   'E', "rose");
	
    Arrays.sort(stones);
    
    for (int j=0; j<stones.length; j++)
	{
      System.out.println(stones[j].toString());
	}
  }  
}