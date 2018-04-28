/*************************************************************************
  Winter 2017 CS 240 Programming Exam : Person

 Author: Kendall Haworth

 Dependencies: Stack, Queue, Dictionary

 Description:  Models a person, a list of messages that they can
               read, and a list of their friends, so that when you
               post a message, all your friends can read it too.

**************************************************************************/

import java.util.Iterator;

public class Person
{
	String name;
	NodeDictionary<String, Person> dictionary;
	NodeStack<String> messages;
	
	// Create a new Person with this name.
	public Person(String name)
	{
		dictionary = new NodeDictionary<String, Person>();
		messages = new NodeStack<String>();
		this.name = name;	
	}
	
	// Make these two people become friends with each other.
	// Throw an exception if you try to meet yourself.
	// We are allowed to assume we didn't meet this person yet.
	public void meet(Person otherPerson)
	{
		if (otherPerson.getName().equals(name))
		{
			throw new RuntimeException("You cannot become friends with yourself!");
		}
		
		dictionary.add(name, otherPerson);

		if (!otherPerson.knows(this))
		{
			otherPerson.meet(this);
		}
	}
	
	// Are these two people friends?
	// Throw an exception if you ask about knowing yourself.
	public boolean knows(Person otherPerson)
	{
		if (otherPerson.getName().equals(name))
		{
			throw new RuntimeException("You can't be your own friend!");
		}
		
		if (dictionary.isEmpty() || !dictionary.getValue(name).getName().equals(otherPerson.getName()))
		{
			return false;
		}
		
		return true;
	}
	
	// Post a message to my list and the lists of all my friends
	public void post(String message)
	{
		messages.push(message);
		
		if (!dictionary.isEmpty())
		{
			Iterator<Person> valueIterator = dictionary.getValueIterator();
			
			while (valueIterator.hasNext())
			{
				valueIterator.next().post2(message);
			}
		}
	}
	
	private void post2(String message)
	{
		messages.push(message);
	}
	
	// Print a header, then all messages this Person can read, newest first
	public void listMessages()
	{
		System.out.println("== The wall of " + name + " ==");
		
		NodeStack<String> temp = new NodeStack<String>();
		
		while (!messages.isEmpty())
		{
			String cheese = messages.pop();
			temp.push(cheese);
			System.out.println(cheese);
		}
		
		while (!temp.isEmpty())
		{
			messages.push(temp.pop());
		}
		
		System.out.println();
	}
	
	public String getName()
	{
		return name;
	}
}