// DoWhile3.java
 
/**
 *  Illustrate use of sentinel input value & do-while loop
 *
 *  @author   Dr. Henry H. Leitner
 *  @verison  Last modified June 28, 2013
 */
 
import java.util.*;

class DoWhile3 
{
    public static void main (String [] args) 
    {
        final int SENTINEL = -1;
        int count = -1;     // Why?
        int sum = 0;
        int n = 0;          // Why?;
        Scanner keyboard = new Scanner ( System.in );

        System.out.println ("TYPE ZERO OR MORE INTEGERS, FOLLOWED BY ");
        System.out.println (SENTINEL + ", and the numbers will be summed up!\n");
        do 
        {   
            count++;
            sum += n;
            System.out.print ("Input an integer: ");
            n = keyboard.nextInt();
        } while (n != SENTINEL);
        
        System.out.println ("SUM OF " + count + " NUMBERS WAS " + sum);
    }
}
