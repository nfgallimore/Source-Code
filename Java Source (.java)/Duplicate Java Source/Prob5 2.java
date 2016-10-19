class Prob5
{
    public static void main(String[] args)
    {
    
        prob4();
    }
    // global boolean variables
    public static boolean a; public static boolean b;
    
    // exactly one value is true and the other false
    public static boolean testBool()
    {
        if ( !  (a && b) && (a || b) )
            return true;
        else return false;
    }
    // neither a nor b is true
    public static boolean first()
    {
        if ( !(a && b) )
            return true;
        else return false;
    }
    // either a or b is true
    public static boolean second()
    {
        if (a || b)
            return true;
        else
            return false;
    }
    // exactly one value is true and the other false
    public static boolean success()
    {
        if (first() && second()) { System.out.println("Matching Combo!"); return true; }
        else { System.out.println("Try again"); return false; }
    }
    // prints a truth table
    public static boolean prob1 (boolean a, boolean b, boolean wantToPrint)
    {
        if ( wantToPrint )
        {
            boolean tempA = a;  boolean tempB = b;                                                                                                                  // saves input
            a = true; b = true; if ( testBool() ) System.out.print("True"); else System.out.print("False"); System.out.print(" when both are true.\n");             // True True
            a = false; b = false; if ( testBool() )System.out.print("True"); else System.out.print("False"); System.out.print(" when both are false.\n");           // False False
            a = true; b = false; if ( testBool() )System.out.print("True"); else System.out.print("False"); System.out.print(" when a is true, and b is false\n");  // True False
            a = false; b = true; if ( testBool() )System.out.print("True"); else System.out.print("False"); System.out.print(" when a is false, and b is true.\n"); // False True
            a = tempA; b = tempB; success();
        }
        if (!(a && b) && (a || b)) return true; else return false;
                                                        
        /* ----------------------------------------------------------------
           AN EXCLAMATION POINT only modifies one OPERATION  !!!!!!!!!!
         ----------------------------------------------------------------
         One OPERATION has exactly two OPERANDS!
         
         Example: (a + b)  a is first operand, b is second operand,
         
         while the + sign is the operator
                  
         ----------------------------------------------------------
           ELIMINATION ORDER OF POSSIBLE OUTCOMES (tt, ff, tf, ft)
         ----------------------------------------------------------
            1. True True
            2. False False
                        True False
                        False True                                             */
    }
    static void prob2()
    {
        for (int k = 0; k < 20; k += 2)
        {
            for (int j = 0; j < 5; j++)
            {
                System.out.print( "*" );
            }
            System.out.println();
        }
    }
    static void prob3() // runtime error
    {
        String s1 = "String";
        char c = s1.charAt( s1.length() );
    }
    static void prob4()
    {
        // I.
        int x = 0; while (x > 0) { x--; } System.out.println( "x = " + x);
        x = 0; do { x--; } while (x > 0); System.out.println(" x = " + x);
        
        // II.
        x = 1; while (x > 0) { x--; } System.out.println( "x = " + x);
        x = 1; do { x--; } while (x > 0); System.out.println(" x = " + x);
        
        // III.
        x = -1; while (x > 0) { x--; } System.out.println( "x = " + x);
        x = -1; do { x--; } while (x > 0); System.out.println(" x = " + x); 
    }
    // recursively finds log base 2
    static double prob5 (int k)
    {
        if (k <= 1) return 0;
        else return 1 + prob5 (k / 2);
    }
    static int possibleOutcomes(int factors, int possibilities)
    {
        if (factors < possibilities && factors > 1) return 0;
        else if (factors == 1) return possibilities;
        else return possibilities * possibleOutcomes(factors - 1, possibilities);
    }
}

