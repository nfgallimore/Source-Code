// EqReal.java
/**
 *  Shows the futility of testing for equality of DOUBLE values
 *
 *  Note:  For loop test can't be "x != 1.0", because of the 
 *         very problem we're looking at 
 *
 *  @author   Dr. Henry H. Leitner
 *  @version  Last_modified June 3, 2013
 */

class EqReal 
{
    public static void main (String [] args) 
    {

        double x;   
    
        for (x = 0.0; x != 1.0; x += 0.1) 
        {
            System.out.println (x);
        }
        System.out.println ("Final value of x is " + x);
    }
}

