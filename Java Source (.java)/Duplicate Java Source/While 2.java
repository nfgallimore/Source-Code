//  While.java
/**
 *  Illustrate use of sentinel input value & while loop
 *
 *  @author   Dr. Henry H. Leitner
 *  @version  Last_modified July 3, 2013
 */

import java.util.*;
 
class While 
{
    public static void main (String [] args) 
    {
        Scanner keyboard = new Scanner (System.in);
        final int SENTINEL = -1;
        int count = 0;
        int sum = 0;

        System.out.println ("TYPE ZERO OR MORE INTEGERS, FOLLOWED BY ");
        System.out.println (SENTINEL + ", and the numbers will be summed up!\n");

        System.out.print("Input an integer: ");
        int n = keyboard.nextInt();
        while (n != SENTINEL) 
        {   
            count++;
            sum += n;           // from previous pass
            System.out.print ("Input an integer: ");
            n = keyboard.nextInt ();
        } 
        
        System.out.println ("SUM OF " + count + " NUMBERS WAS " + sum);
    }
}
