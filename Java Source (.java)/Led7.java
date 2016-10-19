// Led7.java

/**
 *  This program prints the numerals 0 to 9 on the screen
 *   as they would appear in a "7 segment LED" display
 *  This program illustrates stepwise refinement,
 *   the use of variables and symbolic constants,
 *   and the for loop.
 *
 *  @author   Dr. Henry H. Leitner
 *  @version  Last_modified: June 8, 2013
 *
 * SYNTAX NOTE: the main program below contains several syntactic
 *      constructs that it's easiest to "take on faith" for now -
 *      they'll make plenty of sense soon enough.  Here's a brief
 *      explanation of "public static void main (String [] args)"
 *
 *      public:  means the function can be run by any code that can
 *               access class Led7,
 *
 *      static:  means there is only one copy of the function for
 *               the entire class, vs a copy for every object of the 
 *               class
 *
 *      void:    means the function "returns absolutely nothing"
 *
 *      String [] args:  it's possible to supply information to 
 *                       a java program when it's started up -
 *                       we won't be doing so for quite a while!
 */

class Led7 

{
    static final char   ROW_CHAR = '=',
                        COL_CHAR = '|';
    static final int    WIDTH = 10,
                        HEIGHT = 3,
                        NUM_BLANK = 4;

    /**
     * This method will print a single space character
     */
    static void space () // output a single space character
    { 
        System.out.print (' ');
    }

    /**
     * This method prints a horizontal line
     */
    static void horizLine () 
    {
        space ();
        for (int i = 1; i <= WIDTH; i++)
	{
            System.out.print (ROW_CHAR);
	}
        System.out.println ();
    }

    /**
     * This method will print left and right vertical lines
     */
    static void leftRight () 
    {
        for (int i = 1; i <= HEIGHT; i++) 
        {
            System.out.print (COL_CHAR);
            for (int j = 1; j <= WIDTH; j++)  space ();
            System.out.println (COL_CHAR);
        }
    }

    /**
     * This prints a left-sided vertical line
     */
    static void leftOnly () 
    {
        for (int i = 1; i <= HEIGHT; i++)  
	{
            System.out.println (COL_CHAR);
	}
    }

    /**
     * This prints a right-sided vertical line
     */
    static void rightOnly () 
    {
        for (int i = 1; i <= HEIGHT; i++) 
        {
            for (int j = 1 ;j <= WIDTH+1; j++)  space ();
            System.out.println (COL_CHAR);
        }
    }

    /**
     * This causes NUM_BLANK empty lines to print
     */
    static void blankLines ()
    { 
        for (int i = 1; i <= NUM_BLANK; i++)
            System.out.println ();
    }

    /**
     * This causes the numeral 0 to be printed.
     */
    static void write_0 () 
    {
         horizLine ();
         leftRight ();
         System.out.println ();
         leftRight ();
         horizLine ();
    }

    /**
     * This causes the numeral 1 to be printed.
     */
    static void write_1 () 
    {
        rightOnly ();
        System.out.println ();
        rightOnly ();
    }

    /**
     * This causes the numeral 2 to be printed.
     */
    static void write_2 () 
    {
        horizLine ();
        rightOnly ();
        horizLine ();
        leftOnly ();
        horizLine ();
    }

    /**
     * This causes the numeral 3 to be printed.
     */
    static void write_3 () 
    {
        horizLine ();
        rightOnly ();
        horizLine ();
        rightOnly ();
        horizLine ();
    }

    /**
     * This causes the numeral 4 to be printed.
     */
    static void write_4 () 
    {
        leftRight ();
        leftRight ();
        horizLine ();
        rightOnly ();
        rightOnly ();
    }

    /**
     * This causes the numeral 5 to be printed.
     */
    static void write_5 () 
    {
        horizLine ();
        leftOnly ();
        horizLine ();
        rightOnly ();
        horizLine ();
    }

    /**
     * This causes the numeral 6 to be printed.
     */
    static void write_6 () 
    {
        horizLine ();
        leftOnly ();
        horizLine ();
        leftRight ();
        horizLine ();
    }

    /**
     * This causes the numeral 7 to be printed.
     */
    static void write_7 () 
    {
        horizLine ();
        rightOnly ();
        System.out.println ();
        rightOnly ();
    }

    /**
     * This causes the numeral 8 to be printed.
     */
    static void write_8 () 
    {
        horizLine ();
        leftRight ();
        horizLine ();
        leftRight ();
        horizLine ();
    }

    /**
     * This causes the numeral 9 to be printed.
     */
    static void write_9 () 
    {
        horizLine ();
        leftRight ();
        horizLine ();
        rightOnly ();
        horizLine ();
    }

    public static void main (String [] args) 
    {
        write_0 ();
        blankLines ();
        write_1 ();
        blankLines ();
        write_2 ();
        blankLines ();
        write_3 ();
        blankLines ();
        write_4 ();
        blankLines ();
        write_5 ();
        blankLines ();
        write_6 ();
        blankLines ();
        write_7 ();
        blankLines ();
        write_8 ();
        blankLines ();
        write_9 ();
        blankLines ();
    }
}              // end of class Led7
