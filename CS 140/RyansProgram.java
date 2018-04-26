/** Name: Kendall Haworth
   
    Class: CS140, Section 01
   
    Create a java program that calculates your gross pay by using your hourly pay rate
    and the number of hours you worked this week. If you worked less than 15 hours, you
    get $0 and your pay is deferred to next week. If you work overtime (more than 40 hours),
    your pay is 1.5x the rate for your overtime hours. You are not paid for more than 60 hours
    a week. Only whole hours can be counted.
   
    Date Due: October 18, 2016
   
*/
 
import java.util.Scanner;
 
public class RyansProgram
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
       
        System.out.print("Enter Month (1-12): ");
        int month = keyboard.nextInt();
        if( month < 1 || month > 12)
        {
            System.err.println("Invalid Month!");
        }
       
        System.out.print("Enter Day (1-31): ");
        int day = keyboard.nextInt();
        if( day < 1 || day > 31 )
        {
            System.err.println("Invalid Day!");
            return;
        }
       
        String season = "";
       
        //easy cases
        if( month == 4 || month == 5) season = "Spring";
        if( month == 7 || month == 8) season = "Summer";
        if( month == 4 || month == 5) season = "Fall";
        if( month == 1 || month == 2) season = "Winter";
       
        if( month == 3)
        {
            if( day >= 21 )
                season = "Spring";
            else
                season = "Winter";             
        }
        if(month == 6)
        {
            if( day >= 21 )
                season = "Summer";
            else
                season = "Spring";
        }
        if(month == 9)
        {
            if( day >= 21 )
                season = "Fall";
            else
                season = "Winter";
        }
        if( month == 12 )
        {
            if( day >= 21 )
                season = "Winter";
            else
                season = "Fall";
        }
        System.out.println( month + "/" + day + " is in the " + season + " season.");
    }
}