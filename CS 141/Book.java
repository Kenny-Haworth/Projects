/***************************************************************
* File: Book.java
* Author: Kendall Haworth
* Class: CS 141-01 – Intro to Programming and Problem Solving
*
* Assignment: ICA
* Date last modified: 18/1/17
* 
****************************************************************/

import java.util.Scanner;

public class Book
{
	private int yearPublished;
	private String title;
	private String genre;
		
	public int getYearPublished()
	{
		return yearPublished;
	}
	
	public String getTitle()
	{
		return new String(title);
	}
	
	public String getGenre()
	{
		return new String(genre);
	}
	
	public Book (int yr, String t, String g)
	{
		yearPublished = yr;
		title = t;
		genre = g;
	}
	
	public boolean equals(Book book2)
	{
		boolean status;
		
		if (this.title.equals(book2.getTitle()) && this.yearPublished == book2.getYearPublished() && this.genre.equals(book2.getGenre()))
		{
			status = true;
		}
		else
		{
			status = false;
		}
		return status;
	}
	
	public String toString()
	{
		String result = "The book \"" + title + "\" was published in " + yearPublished + " and is the genre " + genre + ".";
		return result;
	}
}