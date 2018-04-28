import javax.swing.JOptionPane;

// This program demonstrates the if statement
// It will only display a congratulations message if the average score is greater than 90.

public class AverageScore
{
	public static void main(String[] args)
	{
		double score1;
		double score2;
		double score3;
		double average;
		String input;
		
		JOptionPane.showMessageDialog(null, "This program is designed to find your average test" +
										" score. Please insert values from 0 to 100.");
		
		input = JOptionPane.showInputDialog("Please Enter Score #1:");
		score1 = Double.parseDouble(input);
		
		if (score1 > 100)
				JOptionPane.showMessageDialog(null, "Invalid number. Please enter a number" +
												"from 0 to 100. You must now restart the program.");
												
		input = JOptionPane.showInputDialog("Please Enter Score #2:");
		score2 = Double.parseDouble(input);
		
		input = JOptionPane.showInputDialog("Please Enter Score #3:");
		score3 = Double.parseDouble(input);
		
		average = (score1 + score2 + score3)/3.0;
		
		JOptionPane.showMessageDialog(null, "The average is " + average + ".");
		
		if (average > 90)
			JOptionPane.showMessageDialog(null, "Wow, that's a great score!! Congratulations!!!");
		
		if (average < 60)
			JOptionPane.showMessageDialog(null, "That's a bad score, you should consider studying more!");
		
		if (average >= 60)
			JOptionPane.showMessageDialog(null, "You got a D, you should consider studying more!");
		
		System.exit(0);
	}
}