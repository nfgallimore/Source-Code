// Fib2.java

/**  
 *  This program calculates and prints the first 20 Fibonacci numbers
 *  Strategy is to calculate 2 at a time, 
 *       without using a temporary variable 
 *
 *  @author   Dr. Henry H. Leitner
 *  @version  Last modified July 2, 2013
*/
    

class Fib2 
{
    public static void main (String[] args)  
    {   
    
        int oddFib = 0;
        int evenFib = 1;
        
        System.out.println ("HERE ARE THE FIRST 20 FIBONACCI NUMBERS");
        System.out.printf ("f0  %9d\n", oddFib );
        System.out.printf ("f1  %9d\n", evenFib );

        // calculate the next 18, two per iteration 
        
        for (int halfCount = 1; halfCount < 10; halfCount++)
        { 
                // oddFib is smaller and can be overwritten
            oddFib = evenFib + oddFib ;
            System.out.printf ( "f%-2d %9d\n", (2 * halfCount ), oddFib);
                // now evenFib is smaller
            evenFib  = oddFib  + evenFib;
            System.out.printf ( "f%-2d %9d\n", (2 * halfCount +1 ), evenFib);

        }
    }
}
