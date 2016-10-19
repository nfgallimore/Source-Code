import java.util.Scanner;

class July9
{
   public static void main (String [] args)
   {
      Scanner keyboard = new Scanner (System.in);

      System.out.print ("Please input an integer: ");
      int n = keyboard.nextInt();

      System.out.print ("Please input a real number: ");
      double d = keyboard.nextDouble();

      System.out.println ("The sum of the 2 numbers = " +  n+d );
   }
}

