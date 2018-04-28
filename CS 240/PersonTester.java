public class PersonTester
{
	public static void main(String[] args)
	{	
		Person first = new Person("Bob");
		Person second = new Person("Mary");
		first.post("Only Bob can read this");
		second.post("Only Mary can read this");
	
		first.meet(second);
		second.post("I'm Mary, I posted this. Bob should be able to see this too.");
		first.post("I'm Bob, I posted this. Mary should be able to see this too.");
	
		first.listMessages();
		second.listMessages();
	}
}