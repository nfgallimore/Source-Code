// Gpa.java
/**
 *  Reads one's GPA over n consecutive semesters, prints the average GPA
 *  and whether or not the GPA increased every semester.
 *
 *  @author   Dr. Henry H. Leitner
 *  @version  Last_modified: June 22, 2013
 */
import java.util.*;

class Gpa 
{
    public static void main (String [] args) 
    {
        final int N = 5;          // Number of semesters to use 
        double oldGpa;            // yesterday's GPA 
        double gpa  = 0.0;        // most recent GPA; it's zero because 
                                  // .. we haven't read any yet
        double sum = 0.0;         // sum of all GPA's, initialized 
        boolean increasing= true; // true if GPA is increasing
                                  // assume true to start with

        System.out.print ("\nType a double value that represents ");
        System.out.print ("your grade-point-average (GPA) ...\n");
        Scanner keyboard = new Scanner (System.in);

        for (int semester = 1; semester <= N; semester++)  
        {      
            oldGpa = gpa;               // save yesterday's GPA
            System.out.print ("At end of semester #" +
                               semester + ":  "); 
            gpa = keyboard.nextDouble();  // read today's GPA
            sum += gpa;                   // update running sum 
            // A better version would verify legal GPAs are input
            if (gpa <= oldGpa) increasing = false;
        }
        System.out.print ("Average GPA was ... ");
        System.out.println (sum / N); 

        if (increasing)         // if increasing is true 
             System.out.print ("GPA did INCREASE every semester!\n");
        else System.out.print ("GPA did NOT increase every semester!\n");
    }
}
