/**
	A class to handle events.
		@note Make print method and delays universal.
*/

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class EventManager
{
	private int resultDelay;
	private int resourceGainDelay;
	private int darkStatementDelay;
	
	public EventManager(int result, int resourceGain, int darkStatement)
	{
		resultDelay = result;
		resourceGainDelay = resourceGain;
		darkStatementDelay = darkStatement;
	}
	
	public boolean executeEvent(ColonyManager colony, int input, String textFile) throws FileNotFoundException, InterruptedException
	{
		File inputFile = new File(textFile);
		Scanner inputData = new Scanner(inputFile);
		
		boolean complete = false;
		
		while (inputData.hasNext() && !complete)
		{
			String cheese = inputData.nextLine();
			
			if (!cheese.equals("") && cheese.charAt(0) - '0' == input) //the section in the text file to print has been found
			{
				cheese = inputData.nextLine(); //the first line is blank
				boolean statEnding = false;
				
				while(inputData.hasNext()) //until the end of the text file has been reached
				{
					cheese = inputData.nextLine();
					boolean noNewLine = false;
					boolean noEnter = false;
					
					if (!cheese.equals("") && cheese.charAt(0) == '	') //The line is stat changes or an enter. Any stat changes are always at the end of a section
					{
						if (cheese.equals("	enter()"))
						{
							enter();
							continue; //immediately go to the next iteration
						}
						
						StringTokenizer token = new StringTokenizer(cheese, "+-; 	"); //ignores all tabs, spaces, +'s, -'s, and ;'s
						String firstAmount = token.nextToken(); //the specified amount to add or subtract
						int secondAmount = 0;
						
						if (cheese.indexOf('+') >= 0 && cheese.indexOf('-') >= 0) //double stat gain/loss
						{
							secondAmount = Integer.parseInt(token.nextToken());
						}
						
						String stat = token.nextToken(); //the specified stat to add
						int multiply = 1;
						int divide = 1;
						int amount = 0;
						
						if (firstAmount.indexOf('/') > 0) //the stat change is proportion
						{
							StringTokenizer tokener = new StringTokenizer(firstAmount, "/");
							multiply = Integer.parseInt(tokener.nextToken());
							divide = Integer.parseInt(tokener.nextToken());
							
							if (stat.equals("happiness"))
							{
								amount = colony.getHappiness();
							}
							else if (stat.equals("food"))
							{
								amount = colony.getFood();
							}
							else if (stat.equals("population"))
							{
								amount = colony.getPopulation();
							}
							else if (stat.equals("offense"))
							{
								amount = colony.getOffense();
							}
							else if (stat.equals("defense"))
							{
								amount = colony.getDefense();
							}
							else if (stat.equals("materials"))
							{
								amount = colony.getMaterials();
							}
							
							StringBuilder stringBuilder = new StringBuilder(); //now change cheese to the proper amount
							stringBuilder.append("	"); //begin with a tab
							
							if ((cheese.indexOf('+') >= 0 && (cheese.indexOf('-') == -1 || (cheese.indexOf('+') < cheese.indexOf('-'))))) //add a + or -
							{
								stringBuilder.append("+");
							}
							else if (cheese.indexOf('-') >= 0 && (cheese.indexOf('+') == -1 || (cheese.indexOf('-') < cheese.indexOf('+'))))
							{
								stringBuilder.append("-");
							}
							
							stringBuilder.append(secondAmount + ((multiply*amount)/divide)); //the correct amount
							stringBuilder.append(" "); //a space
							stringBuilder.append(stat); //the stat at the end
							
							if (cheese.charAt(cheese.length()-1) == ';') //it is the last line to be read
							{
								stringBuilder.append(";");
							}
							
							cheese = stringBuilder.toString(); //and set cheese to what was made
							
							if ((secondAmount + ((multiply*amount)/divide)) == 0) //there is no gain or loss
							{
								if (cheese.charAt(cheese.length()-1) == ';') //the last line to be read should not be read
								{
									complete = true;
									enter();
									break;
								}
								else //don't print the line, just go to the next iteration
								{
									continue;
								}
							}
						}
						else //the stat change is an int
						{
							amount = Integer.parseInt(firstAmount);
						}
						
						//perform the stat change on the colony
						if (cheese.indexOf('+') >= 0 && (cheese.indexOf('-') == -1 || (cheese.indexOf('+') < cheese.indexOf('-')))) //+ is before the - or the - does not exist
						{
							if (stat.equals("happiness"))
							{
								colony.addHappiness(secondAmount + ((multiply*amount)/divide));
							}
							else if (stat.equals("food"))
							{
								colony.addFood(secondAmount + ((multiply*amount)/divide));
							}
							else if (stat.equals("population"))
							{
								colony.addPopulation(secondAmount + ((multiply*amount)/divide));
							}
							else if (stat.equals("offense"))
							{
								colony.addOffense(secondAmount + ((multiply*amount)/divide));
							}
							else if (stat.equals("defense"))
							{
								colony.addDefense(secondAmount + ((multiply*amount)/divide));
							}
							else if (stat.equals("materials"))
							{
								colony.addMaterials(secondAmount + ((multiply*amount)/divide));
							}
						}
						else if (cheese.indexOf('-') >= 0 && (cheese.indexOf('+') == -1 || (cheese.indexOf('-') < cheese.indexOf('+')))) //- is before the + or the + does not exist
						{
							if (stat.equals("happiness"))
							{
								colony.subtractHappiness(secondAmount + ((multiply*amount)/divide));
							}
							else if (stat.equals("food"))
							{
								colony.subtractFood(secondAmount + ((multiply*amount)/divide));
							}
							else if (stat.equals("population"))
							{
								colony.subtractPopulation(secondAmount + ((multiply*amount)/divide));
							}
							else if (stat.equals("offense"))
							{
								colony.subtractOffense(secondAmount + ((multiply*amount)/divide));
							}
							else if (stat.equals("defense"))
							{
								colony.subtractDefense(secondAmount + ((multiply*amount)/divide));
							}
							else if (stat.equals("materials"))
							{
								colony.subtractMaterials(secondAmount + ((multiply*amount)/divide));
							}
						}
						
						if (cheese.charAt(cheese.length()-1) == ';') //the stat change is the last line in the section, remove the ";" later
						{
							statEnding = true;
						}
						else //the stat change is not the last line in the section, print it out now
						{
							print(cheese + "\n", resourceGainDelay);
							continue; //immediately go to the next iteration, the stat has been read
						}
					}
					
					//the end of the section has been reached, remove the semicolon. A custom character is also possible for the end of a section
					if ((!cheese.equals("") && cheese.charAt(cheese.length()-1) == ';') || (!cheese.equals("") && cheese.indexOf('#') >= 0 && cheese.charAt(cheese.indexOf('#') - 1) == ';'))
					{
						complete = true;
						
						if (cheese.equals(";")) //the last line is blank, no spaces
						{
							enter();
							break; //nothing after this will be printed, or it will be "unreachable statement"
						}
						
						StringTokenizer token = new StringTokenizer(cheese, ";"); //remove the ; in the statement
						cheese = token.nextToken(); //get the first part. There may be a second for a custom delay
						
						if (token.hasMoreTokens()) //there is a custom delay at the end, not a stat ending
						{
							StringBuilder stringBuilder = new StringBuilder(cheese);
							stringBuilder.append(token.nextToken()); //add the custom delay back in
							cheese = stringBuilder.toString();
						}
						else if (statEnding) //the last line is a stat and needs a different delay. If it's not a stat, it can be printed normally
						{
							print(cheese + "\n", resourceGainDelay);
							enter(); //for the last line the user must press enter
							break;
						}
					}
					
					if (cheese.indexOf('#') >= 0) //a custom delay or case has been specified
					{
						StringTokenizer token = new StringTokenizer(cheese, "#");
						cheese = token.nextToken(); //remove the # off the end
						String customDelay = token.nextToken(); //get the custom delay
						
						if (customDelay.equals("noNewLine")) //no new line should be printed
						{
							//a dark statement should be printed with no new line
							if (!cheese.equals("") && cheese.charAt(cheese.length()-1) == '.' && cheese.charAt(cheese.length()-2) == '.' && cheese.charAt(cheese.length()-3) == '.')
							{
								noNewLine = true;
							}
							else //just print without a new line
							{
								print(cheese, resultDelay);
							}
						}
						else if (customDelay.equals("noEnter")) //the last line should be printed without an enter
						{
							//a dark statement should be printed with no enter as the last line
							if (!cheese.equals("") && cheese.charAt(cheese.length()-1) == '.' && cheese.charAt(cheese.length()-2) == '.' && cheese.charAt(cheese.length()-3) == '.')
							{
								noEnter = true;
							}
							else //just don't have an enter for the last line
							{
								print(cheese + "\n", resultDelay);
								break;
							}
						}
						else if (customDelay.equals("darkStatementDelay"))
						{
							print(cheese + "\n", darkStatementDelay);
						}
						else //the custom delay is a time
						{
							if (resultDelay == 0 && resourceGainDelay == 0 && darkStatementDelay == 0) //text delay is turned OFF
							{
								print(cheese + "\n", 0);
							}
							else //text delay is turned ON
							{
								print(cheese + "\n", Integer.parseInt(customDelay)); 
							}
						}
						
						if (!complete) //the custom delay could have been the last line, in which case don't go to the next iteration
						{
							continue; //immediately go to the next iteration
						}
					}
					
					//the last three characters are ..., indicating a dark statement
					if (!cheese.equals("") && cheese.charAt(cheese.length()-1) == '.' && cheese.charAt(cheese.length()-2) == '.' && cheese.charAt(cheese.length()-3) == '.')
					{
						StringBuilder stringBuilder = new StringBuilder(cheese);
						stringBuilder.deleteCharAt(cheese.length()-1); //remove the last 3 characters from the string
						stringBuilder.deleteCharAt(cheese.length()-2);
						stringBuilder.deleteCharAt(cheese.length()-3);
						cheese = stringBuilder.toString(); //now print the line without the ...
						print(cheese, resultDelay);
						
						if (noNewLine) //no new line should be printed after the dark statement
						{
							print("...", darkStatementDelay);
						}
						else if (noEnter) //the line is the end of a section and should be printed without an enter
						{
							print("...\n\n", darkStatementDelay); //needs two new lines since the enter counts as one
							break;
						}
						else //a new line should be printed
						{
							print("...\n", darkStatementDelay); //and print the dark statement with the proper delay
						}
					}
					else
					{
						if (cheese.equals("")) //print empty lines slower, they break up the text
						{
							print("\n", darkStatementDelay);
						}
						else
						{
							print(cheese + "\n", resultDelay);
						}
					}
					
					if (complete)
					{
						enter(); //for the last line the user must press enter
						break;
					}
				}
			}
		}
		
		inputData.close();
		return complete; //complete is true if the section was found, false if it was not and the whole file was scanned
	}
	
	public static void print(String data, long delay) throws InterruptedException
	{
		for (char ch : data.toCharArray())
		{
			System.out.print(ch);
			TimeUnit.MILLISECONDS.sleep(delay);
		}
	}
	
	public static void enter()
	{
		Scanner kb = new Scanner(System.in);
		kb.nextLine();
	}
}