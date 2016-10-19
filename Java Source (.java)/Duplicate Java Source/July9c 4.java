import java.util.*;

class July9c
{
   public static void main (String [] args)
   {
       Scanner keyboard = new Scanner (System.in);
       System.out.print ("Please input a numeric grade: ");
       int grade = keyboard.nextInt();

       if (grade >= 90) System.out.println ("A");
       else if (grade >= 80) System.out.println ("A-");
       else if (grade >= 70) System.out.println ("B+");
       else System.out.println ("That does not compute!");

   }
}   


