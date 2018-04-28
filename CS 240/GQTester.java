public class GQTester
{
    public static void main(String[] args)
    {
        GQ g = new GQ();

        g.addFirst(1);
        g.printArray();
        g.addFirst(2);
        g.printArray();
        g.addLast(3);
        g.printArray();
        g.addLast(4);
        g.printArray();
        g.addFirst(5);
        g.printArray();
        g.addFirst(6);
        g.printArray();
        g.addLast(7);
        g.printArray();

        int s1 = g.get(2);
		System.out.println(s1);
        g.remove(2);
        g.printArray();
        int s2 = g.get(2);
		System.out.println(s2);
    }
}