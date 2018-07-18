public class TowerOfHanoi
{
	public static void main(String[] args)
	{
		moveDisks(3, "Tower A", "Tower C ", "Tower B");
	}
	
	public static void moveDisks(int n, String fromTower, String toTower, String auxTower)
	{
		if (n == 1)
		{
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
		}
		else
		{
			moveDisks(n-1, fromTower, auxTower, toTower);
			
			System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
			
			moveDisks(n-1, auxTower, toTower, fromTower);
		}
	}
}