import java.util.Scanner;

class July16d
{
    public static void main (String [] args)
    {
         Scanner keyboard = new Scanner (System.in);

         System.out.print ("How many pieces of chalk should I throw? ");
         int n = keyboard.nextInt();

         int count = 0;

         for (int i = 1; i <= n; i++)
         {   // throw a piece of chalk
             double x = Math.random();
             double y = Math.random();

             if (x*x + y*y <= 1.0) count++ ;
         }
         System.out.println ("The approximate value of PI is ... " +
                                   (double) count / n  * 4  );
     }
 }    
