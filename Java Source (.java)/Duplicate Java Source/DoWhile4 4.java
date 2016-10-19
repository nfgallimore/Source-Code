// DoWhile4.java

/**
 *  Illustrate use of sentinel input value & do-while loop
 *
 *  @author   Dr. Henry H. Leitner
 *  @version  Last Modified June 28, 2013
 */
 
import java.util.*;

class DoWhile4 
{
    public static void main (String [] args) 
    {
        final int SENTINEL = -1;
        int count = -1;
        int sum = -SENTINEL;         // Why?
        int n = 0;
        Scanner keyboard = new Scanner (System.in);

        System.out.println ("TYPE ZERO OR MORE INTEGERS, FOLLOWED BY ");
        System.out.println (SENTINEL + ", and the numbers will be summed up!\n");

        do 
        {   
            System.out.print ("Input an integer: ");
            n = keyboard.nextInt ();
            count++;
            sum += n;
        } while (n != SENTINEL);
        
        System.out.println ("SUM OF " + count + " NUMBERS WAS " + sum);
    }
}
