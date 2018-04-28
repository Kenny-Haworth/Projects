import java.util.Random;
import java.util.Scanner;

public class codehelp
{
	public static int userScore = 0, compScore = 0, tieScore = 0;
	
	public static void main(String[] args)
	{

		Scanner kb = new Scanner(System.in);

		String userChoice, compChoice = "", tryAgain;
		int choiceNum, compNum, userNum;
		char letter;
		boolean tie;

		Random randNum = new Random();

		do
		{
			choiceNum = randNum.nextInt(3) +1;
	
			if(choiceNum == 1)
				compChoice = "rock";
			else if(choiceNum == 2)
				compChoice = "paper";
			else if(choiceNum == 3)
				compChoice = "scissors";

			compNum = compChoice(compChoice); 

			System.out.println("enter a choice! enter in \"rock\", \"paper\", or \"scissors\"");
			userChoice = kb.nextLine();

			userNum = userChoice(userChoice);

			System.out.println("your choice is: " + userChoice);
			System.out.println("the computer's choice is : " + compChoice);

			tie = compareChoice(userNum, compNum);
			
			System.out.println("do you want to try again? y or n");
			tryAgain = kb.nextLine();
			System.out.println();
			
			letter = tryAgain.charAt(0);


			if(letter == 'n')
			{
				System.out.println("thanks for playing! ^_^");
				System.exit(0);
			}
		}
		while( tie == true || letter == 'y' || letter == 'Y');
              
	}


	public static int compChoice(String ch)
	{
		int compNum = 0;
		
		if(ch.equalsIgnoreCase("rock")) {
			compNum = 1;
		}
		else if(ch.equalsIgnoreCase("paper")) {
			compNum = 2;
		}
		else if(ch.equalsIgnoreCase("scissors")) {
			compNum = 3;
		}
		
		return compNum;
        	
	}
        
	public static int userChoice(String userCh)
	{
		int userNum = 0;
		if(userCh.equalsIgnoreCase("rock"))
			userNum = 1;
		else if(userCh.equalsIgnoreCase("paper"))
			userNum = 2;
		else if (userCh.equalsIgnoreCase("scissors"))
			userNum = 3;
		else if(!(userCh.equalsIgnoreCase("scissors")) || !(userCh.equalsIgnoreCase("paper")) || !(userCh.equalsIgnoreCase("rock")))
		{
			System.out.println("incorrect input, try again");
			System.exit(0);
		}
			return userNum;
    }

        //how to keep track of score so it holds the points overall and not reset back to 0???
	public static boolean compareChoice(int user, int comp)
	{
		boolean tie = false;
		int userTotal = 0, compTotal = 0, tieTotal = 0;
		
		if(user > comp || (user == 1 && comp == 3))
		{
			System.out.println("you win!\n");
			userScore++;
		
		}
		else if(comp > user || (user == 3 && comp == 1))
		{
			System.out.println("you lose!\n");
			compScore++;
		
		}
		else if(comp == user)
		{
			System.out.println("you tied, try again\n");
			tieScore++;
			tie = true;
		}
		
		displayScore(userScore, compScore, tieScore);
		
		return tie; 
    }
	
	public static void displayScore(int user, int comp, int tie)
	{
		System.out.println("User\t\t " + "Computer\t" + "Ties");
		System.out.println("------------------------------------");
		System.out.println(user + "\t\t" + comp +"\t\t" + tie);
		
	}
}