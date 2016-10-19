class July11b
{
    public static void main (String [] args)
    {
         tableOfSquareRoots (3, 10, 1);
         tableOfSquareRoots (4, 16, 2);
    }

    static void tableOfSquareRoots (int start, int finish, int increment)
    {
         System.out.println ("N \t\t Square Root of N");
         for (int n = start; n <= finish; n += increment)
         {
             System.out.println (n + "\t\t" + Math.sqrt(n) );
         }
         System.out.println ("\n");
    }
}
