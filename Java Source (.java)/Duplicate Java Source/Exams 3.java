// Exams.java
/**
 *  Illustrates the use of the switch statement
 *
 *  @author   Dr. Henry H. Leitner
 *  @version  Last_modified:  July 3, 2011
 */

import java.util.*;

class Exams 
{
    public static void main (String [] args) 
    {
        int examScore = 0;
    
	    Scanner keyboard = new Scanner(System.in);

        System.out.print ("INPUT STUDENT EXAM SCORES, ");
	    System.out.println ("OR -1 TO END THE LOOP!\n");

        while (examScore != -1) 
        {
	    System.out.print("Type one exam score: ");
            examScore = keyboard.nextInt();
            
            switch (examScore) 
            {
              case -1:            // end of input
                break;
              case 7:
              case 6:
                System.out.print ("Barely Passing...\n\n");
                break;
              case 3:
              case 4:
                System.out.print ("Flunking\n\n");
                break;
              case 2: case 0: case 1:
                System.out.print ("Exceptionally Flunking\n\n");
                break;
              case 8:
              case 9:
                System.out.print ("Good\n\n");
                break;
              case 10:
                System.out.print ("Exceptionally Good!\n\n");
                break;
              case 5:
                System.out.print ("Barely Passing\n\n");
                break;
              default:
                System.out.print ("Not a legal grade!\n\n");
                break;
            }                       //end of switch block   
        }                           //end of while statement 
        System.out.print ("No more data!\n");
    }
}

