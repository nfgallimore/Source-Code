/** Hanoi.java
 *  Solve "Towers of Hanoi" puzzle
 *
 *    @author:  Dr. Henry H. Leitner
 *    @version: Last Modified July 13, 2012 
 */

import java.util.*;

class Hanoi
{
  static void towers ( char origin , char dest, char intermed,
                       int numDisks)
  {
     if ( numDisks == 1) 
        System.out.println ("Move disk #1 from " + origin + " to " + dest);
     else
     {  
        towers ( origin, intermed, dest,  numDisks-1 );
        System.out.println ("Move disk #" + numDisks 
                             + " from " + origin + " to " + dest);
        towers ( intermed, dest, origin, numDisks-1);
     }
  }
    
  public static void main (String[] args)
  {
     int n;
     Scanner keyboard = new Scanner(System.in);

     System.out.print ("How many disks you wanna play with? ");
     n = keyboard.nextInt();
    
     towers( 'S', 'D',  'I',  n);
  }
}
