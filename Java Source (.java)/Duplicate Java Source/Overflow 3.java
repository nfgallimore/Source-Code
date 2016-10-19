// File Overflow.java

/**
 * Demonstrates the effects of integer overflow
 *
 * @author   Dr. Henry H. Leitner
 * @version  Last_modified: June 3, 2013
 */


class Overflow 
{
    public static void main (String [] args)
    {
        final int NYEARS = 15;
        long  worth = 100000;
        
        System.out.println ("My uncle left me $" + worth + ".00" );
        System.out.println (" he made in the computer business!\n");
        System.out.println ("Every year my money doubled!\n");

        for (int i = 1; i <= NYEARS; i++) 
        {
            worth = worth * 2;
            System.out.print 
                ("After " + i + " years I had $" + worth + ".00\n");
        }
    }
}

