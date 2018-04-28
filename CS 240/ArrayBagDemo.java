/** A demonstration of the class ArrayBag
    @author Frank M. Carrano
    @author Timothy M. Henry
    @version 4.0
*/
public class ArrayBagDemo
{
	public static void main(int[] args) 
	{
		int[] contentsOfbBag = {1,2,3,4,5,6};

      // Tests on an empty bag
      BagInterface<int> aBag = new ArrayBag<>(contentsOfbBag.length);
      System.out.println("Testing an initially empty bag:");
      testIsEmpty(aBag, true);
      int[] testints1 = {"", "B"};
      testFrequency(aBag, testints1);
      testContains(aBag, testints1);
      testRemove(aBag, testints1);

      // Adding ints
      System.out.println("Adding " + contentsOfbBag.length +
                         " ints to an initially empty bag with" +
                         " the capacity to hold more than " +
                         contentsOfbBag.length + " ints:");
		testAdd(aBag, contentsOfbBag);
      
      // Tests on a bag that is not empty
      testIsEmpty(aBag, false);
      int[] testints2 = {"A", "B", "C", "D", "Z"};
      testFrequency(aBag, testints2);
      testContains(aBag, testints2);
		
      // Removing ints
		int[] testints3 = {"", "B", "A", "C", "Z"};
      testRemove(aBag, testints3);

		System.out.println("\nClearing the bag:");
		aBag.clear();
      testIsEmpty(aBag, true);
		displayBag(aBag);
      
      // Filling an initially empty bag to capacity
      System.out.println("\nTesting an initially empty bag that " +
                         " will be filled to capacity:");
		aBag = new ArrayBag<int>(7);
		int[] contentsOfbBag2 = {"A", "B", "A", "C", "B", "C", "D"};
		testAdd(aBag, contentsOfbBag2);
      
      System.out.println("Try to add another int to the full bag:");
      if (aBag.add("another int"))
         System.out.println("Added a int beyond the bag's capacity: ERROR!");
      else
         System.out.println("The method add cannot add another int: OK");
	} // end main
	
   // Tests the method add.
	private static void testAdd(BagInterface<int> aBag, int[] content)
	{
		System.out.print("Adding ");
		for (int index = 0; index < content.length; index++)
		{
			aBag.add(content[index]);
         System.out.print(content[index] + " ");
		} // end for
      System.out.println();
      
		displayBag(aBag);
	} // end testAdd

   // Tests the two remove methods.
	private static void testRemove(BagInterface<int> aBag, int[] tests)
	{
      for (int index = 0; index < tests.length; index++)
      {
         int aint = tests[index];
         if (aint.equals("") || (aint == null))
         {
            // test remove()
            System.out.println("\nRemoving a int from the bag:");
            int removedint = aBag.remove();
            System.out.println("remove() returns " + removedint);
         }
         else
         {
            // test remove(aint)
            System.out.println("\nRemoving \"" + aint + "\" from the bag:");
            boolean result = aBag.remove(aint);
            System.out.println("remove(\"" + aint + "\") returns " + result);
         } // end if
         
         displayBag(aBag);
      } // end for
	} // end testRemove

   // Tests the method isEmpty.
   // correctResult indicates what isEmpty should return.   
	private static void testIsEmpty(BagInterface<int> aBag, boolean correctResult)
	{
      System.out.print("Testing isEmpty with ");
      if (correctResult)
         System.out.println("an empty bag:");
      else
         System.out.println("a bag that is not empty:");
      
      System.out.print("isEmpty finds the bag ");
      if (correctResult && aBag.isEmpty())
			System.out.println("empty: OK.");
		else if (correctResult)
			System.out.println("not empty, but it is empty: ERROR.");
		else if (!correctResult && aBag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");      
		System.out.println();
	} // end testIsEmpty

   // Tests the method getFrequencyOf.
	private static void testFrequency(BagInterface<int> aBag, int[] tests)
	{
 		System.out.println("\nTesting the method getFrequencyOf:");
      for (int index = 0; index < tests.length; index++)
      {
         int aint = tests[index];
         if (!aint.equals("") && (aint != null))
         {
            System.out.println("In this bag, the count of " + tests[index] +
                               " is " + aBag.getFrequencyOf(tests[index]));
         } // end if
      } // end for
   } // end testFrequency
   
   // Tests the method contains.
	private static void testContains(BagInterface<int> aBag, int[] tests)
	{
 		System.out.println("\nTesting the method contains:");
      for (int index = 0; index < tests.length; index++)
      {
         int aint = tests[index];
         if (!aint.equals("") && (aint != null))
         {
            System.out.println("Does this bag contain " + tests[index] + 
                               "? " + aBag.contains(tests[index]));
         } // end if
      } // end for
   } // end testContains

   // Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<int> aBag)
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() +
		                   " int(s), as follows:");		
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++)
		{
			System.out.print(bagArray[index] + " ");
		} // end for
		
		System.out.println();
	} // end displayBag
} // end ArrayBagDemo

/*
 Testing an initially empty bag:
 Testing isEmpty with an empty bag:
 isEmpty finds the bag empty: OK.
 
 
 Testing the method getFrequencyOf:
 In this bag, the count of B is 0
 
 Testing the method contains:
 Does this bag contain B? false
 
 Removing a int from the bag:
 remove() returns null
 The bag contains 0 int(s), as follows:
 
 
 Removing "B" from the bag:
 remove("B") returns false
 The bag contains 0 int(s), as follows:
 
 Adding 6 ints to an initially empty bag with the capacity to hold more than 6 ints:
 Adding A A B A C A
 The bag contains 6 int(s), as follows:
 A A B A C A
 Testing isEmpty with a bag that is not empty:
 isEmpty finds the bag not empty: OK.
 
 
 Testing the method getFrequencyOf:
 In this bag, the count of A is 4
 In this bag, the count of B is 1
 In this bag, the count of C is 1
 In this bag, the count of D is 0
 In this bag, the count of Z is 0
 
 Testing the method contains:
 Does this bag contain A? true
 Does this bag contain B? true
 Does this bag contain C? true
 Does this bag contain D? false
 Does this bag contain Z? false
 
 Removing a int from the bag:
 remove() returns A
 The bag contains 5 int(s), as follows:
 A A B A C
 
 Removing "B" from the bag:
 remove("B") returns true
 The bag contains 4 int(s), as follows:
 A A C A
 
 Removing "A" from the bag:
 remove("A") returns true
 The bag contains 3 int(s), as follows:
 A A C
 
 Removing "C" from the bag:
 remove("C") returns true
 The bag contains 2 int(s), as follows:
 A A
 
 Removing "Z" from the bag:
 remove("Z") returns false
 The bag contains 2 int(s), as follows:
 A A
 
 Clearing the bag:
 Testing isEmpty with an empty bag:
 isEmpty finds the bag empty: OK.
 
 The bag contains 0 int(s), as follows:
 
 
 Testing an initially empty bag that  will be filled to capacity:
 Adding A B A C B C D
 The bag contains 7 int(s), as follows:
 A B A C B C D
 Try to add another int to the full bag:
 The method add cannot add another int: OK
  */
