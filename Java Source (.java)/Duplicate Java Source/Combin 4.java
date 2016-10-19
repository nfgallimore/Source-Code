// Combin.java
/** 
 *  Prints out C(n, i) for ints n and i
 *
 * @author  Dr. Henry H. Leitner
 * @version Last_modified June 15, 2013
 */

import java.util.*;

class Combin 
{
    /**
     * This function computes the number of ways to select i 
     *  individuals from a collection of n
     *
     * @param  n   The number in the collection
     * @param  i   The quantity to be selected
     */
    static long combin (int n, int i)
    { 
        if ((i <= 0) || (i > n))  return 0;
        else
	{
            long temp = 1;
            for (int count = 1; count <= i; count++)
	    {
                 temp = temp * n / count;
                 n -- ;
            }
            return temp;
        }
    }

    public static void main (String [] args) 
    {
        int nObjects, subset;

        Scanner keyboard = new Scanner(System.in);
           
        System.out.print ("How many objects in the set? ");
        nObjects = keyboard.nextInt();
        System.out.print ("How many in the subset? ");
        subset = keyboard.nextInt();
          
        System.out.println 
	       ("There are " + combin (nObjects,subset) + " combinations!");
    }
}
