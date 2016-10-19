// Randemo.java

/**
 *  Demonstration of generating random numbers
 *
 *  @author   Dr. Henry H. Leitner
 *  @version  Last_modified: June 25, 2013
 */

class Randemo 
{
  public static void main (String [] args) 
  {
    System.out.println ("\n   ROLL DEM BONES!          RANDOM BATTING AVERAGES");

    for (int outer = 1; outer <= 10; outer++) 
    {
        for (int inner = 1; inner <= 6; inner++)
           System.out.printf ("%3d", (int) (Math.random()* 6 + 1));
                
        System.out.print ( "         ");

        for (int inner = 1; inner <= 6; inner++)
           System.out.printf ("%7.3f", Math.random() );

        System.out.println();
    }
  }
}
