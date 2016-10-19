/*  File SumFile.java 
 *  Reads a text file of integers, prints the sum of the ints found.
 *  @author  Dr. Henry H. Leitner
 *  @version Last Modified:  June 20, 2012
*/

import java.io.*;
import java.util.*;

class SumFile 
{
   public static void main (String [] args) throws IOException
   {
      Scanner keyboard = new Scanner (System.in);
      System.out.print ("Type the name of an input file containing integers: ");
      String fileName = keyboard.nextLine();

      Scanner in = new Scanner (new File (fileName) );
      int  count = 0;     // the number of numbers input
      int sum = 0;        // the sum of the numbers

      while (in.hasNextInt() ) 
      {
          int x = in.nextInt();
          count++;
          System.out.println ("Value #" + count + " is " + x);
          sum += x;
       } 
       System.out.println("Sum of " + count + " numbers is " + sum);
       in.close();     
   }
}
