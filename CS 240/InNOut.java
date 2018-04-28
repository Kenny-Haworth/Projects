/**
	Final part 1 for CS 240.
	
	Simulates an In-N-Out restaurant.
	
	@author Kendall Haworth
	@version 1.0
*/

import java.util.Random;
import java.util.Iterator;

public class InNOut
{
	public static void main(String[] args) throws EmptyQueueException
	{
		Random random = new Random(); //Create a random number generator
		
		//Create all the menus using a list for each item
		NodeList<String> burger = new NodeList<String>();
		burger.add("Bun");
		burger.add("Patty");
		burger.add("Lettuce");
		burger.add("Tomato");
		burger.add("Onion");
		
		NodeList<String> cheeseBurger = new NodeList<String>();
		cheeseBurger.add("Cheese");
		cheeseBurger.add("Bun");
		cheeseBurger.add("Patty");
		cheeseBurger.add("Lettuce");
		cheeseBurger.add("Tomato");
		cheeseBurger.add("Onion");
		
		NodeList<String> veganBurger = new NodeList<String>(); //Vegan lettuce wrap burger, veganBurger for short
		veganBurger.add("Lettuce");
		veganBurger.add("Lettuce");
		veganBurger.add("Tomato");
		veganBurger.add("Onion");
		
		NodeList<String> burgerOnion = new NodeList<String>(); //Burger without onion, burgerOnion for short
		burgerOnion.add("Bun");
		burgerOnion.add("Patty");
		burgerOnion.add("Lettuce");
		burgerOnion.add("Tomato");
		
		NodeList<String> cheeseBurgerOnion = new NodeList<String>(); //Cheese burger without onion, cheeseBurgerOnion for short
		cheeseBurgerOnion.add("Cheese");
		cheeseBurgerOnion.add("Bun");
		cheeseBurgerOnion.add("Patty");
		cheeseBurgerOnion.add("Lettuce");
		cheeseBurgerOnion.add("Tomato");
		
		NodeList<String> burgerTomato = new NodeList<String>(); //Burger without tomato, burgerTomato for short
		burgerTomato.add("Bun");
		burgerTomato.add("Patty");
		burgerTomato.add("Lettuce");
		burgerTomato.add("Onion");
		
		//Create all the stacks to hold the ingredients
		NodeStack<Integer> Bun = new NodeStack<Integer>(); 
		NodeStack<Integer> Patty = new NodeStack<Integer>(); 
		NodeStack<Integer> Lettuce = new NodeStack<Integer>(); 
		NodeStack<Integer> Tomato = new NodeStack<Integer>(); 
		NodeStack<Integer> Onion = new NodeStack<Integer>();
		NodeStack<Integer> Cheese = new NodeStack<Integer>();
		
		//Create the queue to hold customers
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		
		//Declare variables outside the scope of the below for loop
		int day = 1201; //The starting day, December 1
		int shipment = 1; //The days until a shipment arrives. The first day must start with a shipment
		
		while (day < 1232) //The 31st is the last day of December, so if the day passes the 31st the simulation is complete
		{
			/** 
				The dictionary keeps track of what each customer ordered each day, so it needs to be cleared
				each day. Declaring it here ensures it will be cleared and re-created at the beginning of each day.
			*/
			NodeDictionary<Integer, Integer> dictionary = new NodeDictionary<Integer, Integer>();
			
			//Keep track of how many of each menu item was ordered for each day
			int menuOne = 0;
			int menuTwo = 0;
			int menuThree = 0;
			int menuFour = 0;
			int menuFive = 0;
			int menuSix = 0;
			
			//First, check if a shipment is coming in before In-N-Out opens
			shipment--; //counts down the days until a shipment arrives when shipment is 0
			if (shipment == 0) //A shipment is today
			{
				int numberOfItems = random.nextInt(1) + 100000; //+ 700; //Generates between 700 and 1000 items
				
				//Keep track of how many of each item arrives from the shipment
				int bun = 0;
				int patty = 0;
				int lettuce = 0;
				int tomato = 0;
				int onion = 0;
				int cheese = 0;
				
				for (int i = 0; i < numberOfItems; i++) //Loops as long as there are more ingredients to be added from the shipment
				{
					int ingredient = random.nextInt(6) + 1; //Creates an ingredient, 1 to 6
					
					if (ingredient == 1) //Increments the ingredient to add
					{
						bun++;
					}
					else if (ingredient == 2)
					{
						patty++;
					}
					else if (ingredient == 3)
					{
						lettuce++;
					}
					else if (ingredient == 4)
					{
						tomato++;
					}
					else if (ingredient == 5)
					{
						onion++;
					}
					else if (ingredient == 6)
					{
						cheese++;
					}
				}
				
				NodeStack<Integer> tempStack = new NodeStack<Integer>(); //Creates a temporary stack to order the ingredients
																		 //based on expiration date
					
				while (!Bun.isEmpty()) //Adds all the current buns to the temporary stack
				{
					tempStack.push(Bun.pop());
				}
				
				for (int i = 0; i < bun; i++) //Pushes all the new shipment buns onto the buns stack
				{
					Bun.push(5); //The number pushed to the stack indicates how many days until the ingredient expires
				}
				
				while (!tempStack.isEmpty()) //Pops all the old buns off the temporary stack and places them back on the buns stack
				{
					Bun.push(tempStack.pop());
				}
				
				
				while (!Patty.isEmpty()) //Adds all the current patties to the temporary stack
				{
					tempStack.push(Patty.pop());
				}
				
				for (int i = 0; i < patty; i++) //Pushes all the new shipment patties onto the patties stack
				{
					Patty.push(4); //The number pushed to the stack indicates how many days until the ingredient expires
				}
				
				while (!tempStack.isEmpty()) //Pops all the old patties off the temporary stack and places them back on the patties stack
				{
					Patty.push(tempStack.pop());
				}
				
				
				while (!Lettuce.isEmpty()) //Adds all the current lettuce to the temporary stack
				{
					tempStack.push(Lettuce.pop());
				}
				
				for (int i = 0; i < lettuce; i++) //Pushes all the new shipment lettuce onto the lettuce stack
				{
					Lettuce.push(3); //The number pushed to the stack indicates how many days until the ingredient expires
				}
				
				while (!tempStack.isEmpty()) //Pops all the old lettuce off the temporary stack and places them back on the lettuce stack
				{
					Lettuce.push(tempStack.pop());
				}
				
				
				while (!Tomato.isEmpty()) //Adds all the current tomatoes to the temporary stack
				{
					tempStack.push(Tomato.pop());
				}
				
				for (int i = 0; i < tomato; i++) //Pushes all the new shipment tomatoes onto the tomatoes stack
				{
					Tomato.push(3); //The number pushed to the stack indicates how many days until the ingredient expires
				}
				
				while (!tempStack.isEmpty()) //Pops all the old tomatoes off the temporary stack and places them back on the tomatoes stack
				{
					Tomato.push(tempStack.pop());
				}
				
				
				while (!Onion.isEmpty()) //Adds all the current onions to the temporary stack
				{
					tempStack.push(Onion.pop());
				}
				
				for (int i = 0; i < onion; i++) //Pushes all the new shipment onions onto the onions stack
				{
					Onion.push(5); //The number pushed to the stack indicates how many days until the ingredient expires
				}
				
				while (!tempStack.isEmpty()) //Pops all the old onions off the temporary stack and places them back on the onions stack
				{
					Onion.push(tempStack.pop());
				}
				
				
				while (!Cheese.isEmpty()) //Adds all the current cheese to the temporary stack
				{
					tempStack.push(Cheese.pop());
				}
				
				for (int i = 0; i < cheese; i++) //Pushes all the new shipment cheese onto the cheese stack
				{
					Cheese.push(2); //The number pushed to the stack indicates how many days until the ingredient expires
				}
				
				while (!tempStack.isEmpty()) //Pops all the old cheese off the temporary stack and places them back on the cheese stack
				{
					Cheese.push(tempStack.pop());
				}
				
				shipment = random.nextInt(4) + 3; //Generates a new shipment time between 3 and 6 days
			}//Ends shipment arrival
			
			int lostCustomerDay = 0; //All the customers lost for the day
			int lineCustomers = 0; //All the customers who were in line for the day
			
			for (int hour = 0; hour < 10; hour++) //In-N-Out customers arrive for 10 hours each day, from 10AM - 7PM
			{
				int customers = random.nextInt(100) + 1; //Generates between 1 and 100 customers for each hour
				
				if (customers > 50) //The queue can only hold 50 customers
				{
					lostCustomerDay += customers - 50; //Add the extra customers lost to the counter
					customers = 50; //Reset number of customers to the maximum allowed, 50
				}
				
				//Adds the customers to the queue, keeping track of what number customer they are for the day
				for (int i = lineCustomers; i < (customers + lineCustomers); i++)
				{
					queue.enqueue(i+1);
				}	
				lineCustomers += customers; //Keep track of how many customers got in line for the day
				
				while (!queue.isEmpty()) //Loops until all customers have been served for the hour
				{
					boolean canOrder = true; //If there is enough ingredients to order the item on the menu, they can order it
					int menuOrder = random.nextInt(6) + 1; //Generates the menu order between 1 and 6
					
					if (menuOrder == 1) //The customer orders a burger
					{
						for (int i = 0; i < burger.getLength(); i++) //Checks to ensure each ingredient on the list is in stock
						{
							String ingredient = burger.view(i+1);
							canOrder = inStock(ingredient, Bun, Patty, Lettuce, Tomato, Onion, Cheese);
							
							if (!canOrder) //Ingredients are missing and the item cannot be ordered
							{
								break; //Exits the above for loop
							}
						}
						
						if (canOrder) //If the ingredients are all in stock, create the item and pop the ingredients off their stacks
						{
							for (int i = 0; i < burger.getLength(); i++)
							{
								String ingredient = burger.view(i+1);
								createItem(ingredient, Bun, Patty, Lettuce, Tomato, Onion, Cheese);
							}
							menuOne++; //Indicate menu item number one was successfully ordered
							dictionary.add(queue.dequeue(), 1); //The customer leaves the line with food and their order is saved
						}
						else //Ingredients were missing and the item cannot be ordered
						{
							lostCustomerDay++; //In-N-Out lost revenue
							queue.dequeue(); //The customer leaves the line without food
						}
					}
					else if (menuOrder == 2) //The customer orders a cheese burger
					{
						for (int i = 0; i < cheeseBurger.getLength(); i++) //Checks to ensure each ingredient on the list is in stock
						{
							String ingredient = cheeseBurger.view(i+1);
							canOrder = inStock(ingredient, Bun, Patty, Lettuce, Tomato, Onion, Cheese);
							
							if (!canOrder) //Ingredients are missing and the item cannot be ordered
							{
								break; //Exits the above for loop
							}
						}
						
						if (canOrder) //If the ingredients are all in stock, create the item and pop the ingredients off their stacks
						{
							for (int i = 0; i < cheeseBurger.getLength(); i++)
							{
								String ingredient = cheeseBurger.view(i+1);
								createItem(ingredient, Bun, Patty, Lettuce, Tomato, Onion, Cheese);
							}
							menuTwo++; //Indicate menu item number two was successfully ordered
							dictionary.add(queue.dequeue(), 2); //The customer leaves the line with food and their order is saved
						}
						else //Ingredients were missing and the item cannot be ordered
						{
							lostCustomerDay++; //In-N-Out lost revenue
							queue.dequeue(); //The customer leaves the line without food
						}
					}
					else if (menuOrder == 3) //The customer orders a vegan lettuce wrap burger
					{
						for (int i = 0; i < veganBurger.getLength(); i++) //Checks to ensure each ingredient on the list is in stock
						{
							String ingredient = veganBurger.view(i+1);
							
							/**
								There is a unique case for the vegan lettuce wrap burger. It requires two lettuce,
								so simply checking twice if the lettuce stack isn't empty doesn't tell you if there are
								two lettuces to pop off the stack. Thus, the second time you check for lettuce you should
								first pop the stack, then check if the stack is empty to tell if you have enough lettuce 
								to make the vegan lettuce wrap burger. You can then push the lettuce you popped off the
								stack back onto the stack.
							*/
							if (i+1 != 2)
							{
								canOrder = inStock(ingredient, Bun, Patty, Lettuce, Tomato, Onion, Cheese);
							}
							else //Checking for the second lettuce
							{
								int temp = Lettuce.pop();
								if (Lettuce.isEmpty())
								{
									canOrder = false;
									Lettuce.push(temp);
									break;
								}
								Lettuce.push(temp);
							}
							
							if (!canOrder) //Ingredients are missing and the item cannot be ordered
							{
								break; //Exits the above for loop
							}
						}
						
						if (canOrder) //If the ingredients are all in stock, create the item and pop the ingredients off their stacks
						{
							for (int i = 0; i < veganBurger.getLength(); i++)
							{
								String ingredient = veganBurger.view(i+1);
								createItem(ingredient, Bun, Patty, Lettuce, Tomato, Onion, Cheese);
							}
							menuThree++; //Indicate menu item number three was successfully ordered
							dictionary.add(queue.dequeue(), 3); //The customer leaves the line with food and their order is saved
						}
						else //Ingredients were missing and the item cannot be ordered
						{
							lostCustomerDay++; //In-N-Out lost revenue
							queue.dequeue(); //The customer leaves the line without food
						}
					}
					else if (menuOrder == 4) //The customer orders a burger without onion
					{
						for (int i = 0; i < burgerOnion.getLength(); i++) //Checks to ensure each ingredient on the list is in stock
						{
							String ingredient = burgerOnion.view(i+1);
							canOrder = inStock(ingredient, Bun, Patty, Lettuce, Tomato, Onion, Cheese);
							
							if (!canOrder) //Ingredients are missing and the item cannot be ordered
							{
								break; //Exits the above for loop
							}
						}
						
						if (canOrder) //If the ingredients are all in stock, create the item and pop the ingredients off their stacks
						{
							for (int i = 0; i < burgerOnion.getLength(); i++)
							{
								String ingredient = burgerOnion.view(i+1);
								createItem(ingredient, Bun, Patty, Lettuce, Tomato, Onion, Cheese);
							}
							menuFour++; //Indicate menu item number four was successfully ordered
							dictionary.add(queue.dequeue(), 4); //The customer leaves the line with food and their order is saved
						}
						else //Ingredients were missing and the item cannot be ordered
						{
							lostCustomerDay++; //In-N-Out lost revenue
							queue.dequeue(); //The customer leaves the line without food
						}
					}
					else if (menuOrder == 5) //The customer orders a cheese burger without onion
					{
						for (int i = 0; i < cheeseBurgerOnion.getLength(); i++) //Checks to ensure each ingredient on the list is in stock
						{
							String ingredient = cheeseBurgerOnion.view(i+1);
							canOrder = inStock(ingredient, Bun, Patty, Lettuce, Tomato, Onion, Cheese);
							
							if (!canOrder) //Ingredients are missing and the item cannot be ordered
							{
								break; //Exits the above for loop
							}
						}
						
						if (canOrder) //If the ingredients are all in stock, create the item and pop the ingredients off their stacks
						{
							for (int i = 0; i < cheeseBurgerOnion.getLength(); i++)
							{
								String ingredient = cheeseBurgerOnion.view(i+1);
								createItem(ingredient, Bun, Patty, Lettuce, Tomato, Onion, Cheese);
							}
							menuFive++; //Indicate menu item number five was successfully ordered
							dictionary.add(queue.dequeue(), 5); //The customer leaves the line with food and their order is saved
						}
						else //Ingredients were missing and the item cannot be ordered
						{
							lostCustomerDay++; //In-N-Out lost revenue
							queue.dequeue(); //The customer leaves the line without food
						}
					}
					else if (menuOrder == 6) //The customer orders a burger without tomato
					{
						for (int i = 0; i < burgerTomato.getLength(); i++) //Checks to ensure each ingredient on the list is in stock
						{
							String ingredient = burgerTomato.view(i+1);
							canOrder = inStock(ingredient, Bun, Patty, Lettuce, Tomato, Onion, Cheese);
							
							if (!canOrder) //Ingredients are missing and the item cannot be ordered
							{
								break; //Exits the above for loop
							}
						}
						
						if (canOrder) //If the ingredients are all in stock, create the item and pop the ingredients off their stacks
						{
							for (int i = 0; i < burgerTomato.getLength(); i++)
							{
								String ingredient = burgerTomato.view(i+1);
								createItem(ingredient, Bun, Patty, Lettuce, Tomato, Onion, Cheese);
							}
							menuSix++; //Indicate menu item number six was successfully ordered
							dictionary.add(queue.dequeue(), 6); //The customer leaves the line with food and their order is saved
						}
						else //Ingredients were missing and the item cannot be ordered
						{
							lostCustomerDay++; //In-N-Out lost revenue
							queue.dequeue(); //The customer leaves the line without food
						}
					}
				} //Ends each hour
			} //Ends all 10 hours in the day
			
			//Throw out old food that has expired at the end of the day and save how much of each ingredient was thrown out
			LinkedQueue<Integer> expiredFood = expired(Bun, Patty, Lettuce, Tomato, Onion, Cheese);
			
			//Print day summary statements to the screen
			System.out.println("December " + day % 100);
			
			System.out.println("Customers lost: " + lostCustomerDay);
			
			System.out.println("Buns expired: " + expiredFood.dequeue()); //Gets the expired food from the linked queue
			System.out.println("Patties expired: " + expiredFood.dequeue());
			System.out.println("Lettuce expired: " + expiredFood.dequeue());
			System.out.println("Tomatoes expired: " + expiredFood.dequeue());
			System.out.println("Onions expired: " + expiredFood.dequeue());
			System.out.println("Cheese expired: " + expiredFood.dequeue());
			
			System.out.println("Burgers ordered: " + menuOne); //Prints how many of each menu item was ordered
			System.out.println("Cheese Burgers ordered: " + menuTwo);
			System.out.println("Vegan Lettuce Wrap Burgers ordered: " + menuThree);
			System.out.println("Burgers without onion ordered: " + menuFour);
			System.out.println("Cheese Burgers without onion ordered: " + menuFive);
			System.out.println("Burgers without tomato ordered: " + menuSix);
			
			if (!dictionary.isEmpty()) //Displays what menu item each customer ordered at the end of the day
			{
				Iterator<Integer> valueIterator = dictionary.getValueIterator();
	
				int i = 1;
				while (valueIterator.hasNext())
				{
					System.out.println("Customer " + i++ + " --> #" + valueIterator.next());
				}
			}
			
			if (shipment == 1)
			{
				System.out.println("Shipment tomorrow!\n");
			}
			else //Just formatting to separate the days clearly
			{
				System.out.println();
			}

			day++;
		}//Ends the day
	}//End main method
	
	/**
		This method checks whether or not the ingredient is in stock,
		or in other words contained in one of the stacks of ingredients.
		
		The stacks are sent to the method so that the method can access them.
		
		@param ingredient The ingredient to check if it is in stock
		@param Bun,Patty,Lettuce,Tomato,Onion,Cheese All the stacks of ingredients
		@return boolean True if the item is in stock, false if it is not
	*/
	public static boolean inStock(String ingredient, NodeStack Bun, NodeStack Patty, NodeStack Lettuce, NodeStack Tomato, NodeStack Onion, NodeStack Cheese)
	{
		if (ingredient.equals("Bun"))
		{
			if (Bun.isEmpty()) //If the stack is empty, the item cannot be made because there is not enough of that ingredient
			{
				return false;
			}
		}
		else if (ingredient.equals("Patty"))
		{
			if (Patty.isEmpty())
			{
				return false;
			}
		}
		else if (ingredient.equals("Lettuce"))
		{
			if (Lettuce.isEmpty())
			{
				return false;
			}
		}
		else if (ingredient.equals("Tomato"))
		{
			if (Tomato.isEmpty())
			{
				return false;
			}
		}
		else if (ingredient.equals("Onion"))
		{
			if (Onion.isEmpty())
			{
				return false;
			}
		}
		else if (ingredient.equals("Cheese"))
		{
			if (Cheese.isEmpty())
			{
				return false;
			}
		}
		
		return true;
	}
	
	/**
		Once it has been checked that there is enough ingredients to create the menu item,
		the menu item is created by popping each ingredient off the stack.
		
		The stacks are sent to the method so that the method can access them.
		
		@param ingredient The ingredient to be popped off the stack
		@param Bun,Patty,Lettuce,Tomato,Onion,Cheese All the stacks of ingredients
	*/
	public static void createItem(String ingredient, NodeStack<Integer> Bun, NodeStack<Integer> Patty, NodeStack<Integer> Lettuce, NodeStack<Integer> Tomato, NodeStack<Integer> Onion, NodeStack<Integer> Cheese)
	{
		if (ingredient.equals("Bun"))
		{
			Bun.pop();
		}
		else if (ingredient.equals("Patty"))
		{
			Patty.pop();
		}
		else if (ingredient.equals("Lettuce"))
		{
			Lettuce.pop();
		}
		else if (ingredient.equals("Tomato"))
		{
			Tomato.pop();
		}
		else if (ingredient.equals("Onion"))
		{
			Onion.pop();
		}
		else if (ingredient.equals("Cheese"))
		{
			Cheese.pop();
		}
	}
	
	/**
		Iterates through each ingredient stack. If the ingredient is expired,
		it is removed from the stack. Each ingredient is added to a temporary
		stack to check their expiration dates before being moved back to their
		original stacks in the correct order.
		
		The method additionally returns a linked queue that contains the number
		of how many of each ingredient was wasted.
		
		@param Bun,Patty,Lettuce,Tomato,Onion,Cheese All the stacks of ingredients
		@return LinkedQueue A linked queue that contains the number of how many of each ingredient was wasted
	*/
	public static LinkedQueue<Integer> expired(NodeStack<Integer> Bun, NodeStack<Integer> Patty, NodeStack<Integer> Lettuce, NodeStack<Integer> Tomato, NodeStack<Integer> Onion, NodeStack<Integer> Cheese)
	{
		LinkedQueue<Integer> expiredFood = new LinkedQueue<Integer>(); //Creates a linked queue to hold the expired items
		int wasteBun = 0;
		int wastePatty = 0;
		int wasteLettuce = 0;
		int wasteTomato = 0;
		int wasteOnion = 0;
		int wasteCheese = 0;
		
		NodeStack<Integer> tempStack = new NodeStack<Integer>();
		while (!Bun.isEmpty())
		{
			if (Bun.peek() == 1) //If the ingredient is expired, throw it out and increment the wasted ingredient
			{
				Bun.pop();
				wasteBun++;
			}
			else
			{
				tempStack.push(Bun.pop()-1); //If the ingredient is good, push it to the temp stack and make it a day older
			}
		}
		while (!tempStack.isEmpty()) //put everything back onto the original stack
		{
			Bun.push(tempStack.pop());
		}
		
		
		while (!Patty.isEmpty())
		{
			if (Patty.peek() == 1) //If the ingredient is expired, throw it out and increment the wasted ingredient
			{
				Patty.pop();
				wastePatty++;
			}
			else
			{
				tempStack.push(Patty.pop()-1); //If the ingredient is good, push it to the temp stack and make it a day older
			}
		}
		while (!tempStack.isEmpty()) //put everything back onto the original stack
		{
			Patty.push(tempStack.pop());
		}
		
		
		while (!Lettuce.isEmpty())
		{
			if (Lettuce.peek() == 1) //If the ingredient is expired, throw it out and increment the wasted ingredient
			{
				Lettuce.pop();
				wasteLettuce++;
			}
			else
			{
				tempStack.push(Lettuce.pop()-1); //If the ingredient is good, push it to the temp stack and make it a day older
			}
		}
		while (!tempStack.isEmpty()) //put everything back onto the original stack
		{
			Lettuce.push(tempStack.pop());
		}
		
		
		while (!Tomato.isEmpty())
		{
			if (Tomato.peek() == 1) //If the ingredient is expired, throw it out and increment the wasted ingredient
			{
				Tomato.pop();
				wasteTomato++;
			}
			else
			{
				tempStack.push(Tomato.pop()-1); //If the ingredient is good, push it to the temp stack and make it a day older
			}
		}
		while (!tempStack.isEmpty()) //put everything back onto the original stack
		{
			Tomato.push(tempStack.pop());
		}
		
		
		while (!Onion.isEmpty())
		{
			if (Onion.peek() == 1) //If the ingredient is expired, throw it out and increment the wasted ingredient
			{
				Onion.pop();
				wasteOnion++;
			}
			else
			{
				tempStack.push(Onion.pop()-1); //If the ingredient is good, push it to the temp stack and make it a day older
			}
		}
		while (!tempStack.isEmpty()) //put everything back onto the original stack
		{
			Onion.push(tempStack.pop());
		}
		
		
		while (!Cheese.isEmpty())
		{
			if (Cheese.peek() == 1) //If the ingredient is expired, throw it out and increment the wasted ingredient
			{
				Cheese.pop();
				wasteCheese++;
			}
			else
			{
				tempStack.push(Cheese.pop()-1); //If the ingredient is good, push it to the temp stack and make it a day older
			}
		}
		while (!tempStack.isEmpty()) //put everything back onto the original stack
		{
			Cheese.push(tempStack.pop());
		}
		
		expiredFood.enqueue(wasteBun); //Add the number of each wasted ingredient to the linked queue
		expiredFood.enqueue(wastePatty);
		expiredFood.enqueue(wasteLettuce);
		expiredFood.enqueue(wasteTomato);
		expiredFood.enqueue(wasteOnion);
		expiredFood.enqueue(wasteCheese);
		
		return expiredFood; //Return the number of wasted ingredients
	}
}