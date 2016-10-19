//  While2.java
/**
 *  Illustrate use of sentinel input value & while loop
 *
 *  @author   Dr. Henry H. Leitner
 *  @version  Last_modified July 11, 2013
 */

import java.util.*;
 
class While2
{
    public static void main (String [] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        final int SENTINEL = -1;
        int count = 0;
        int sum = 0;

        System.out.println ("TYPE ZERO OR MORE INTEGERS, FOLLOWED BY ");
        System.out.println (SENTINEL + ", and the numbers will be summed up!\n");

        while (true) 
        {   
            System.out.print("Input an integer: ");
            int n = keyboard.nextInt();
            if (n == SENTINEL) break;
            sum += n;
            count++;
        } 
        
        System.out.println ("SUM OF " + count + " NUMBERS WAS " + sum);
    }
}
