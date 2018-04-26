public class Pets
{
	public static void main (String[] args)
	{
		Labrador dog1 = new Labrador("Aatena", "chocolate");
		Yorkshire dog2 = new Yorkshire("Matthew");
		Dog dog3 = new Dog("Kenny");
		
		System.out.println(dog1.getName() + " says " + dog1.speak());
		System.out.println(dog2.getName() + " says " + dog2.speak());
		System.out.println(dog3.getName() + " says " + dog3.speak());
	}
}