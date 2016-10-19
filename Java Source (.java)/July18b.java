import java.util.Scanner;

class July18b
{
     public static void main (String [] args)
     {
         Scanner keyboard = new Scanner (System.in);
         System.out.print ("Please type a string: ");

         String s = keyboard.nextLine();
         s = s.toUpperCase();

         int left = 0;
         int right = s.length() - 1;

         while (left < right)
         {
             char lc = s.charAt (left);
             char rc = s.charAt (right);

             if  ( !(lc >= 'A' && lc <= 'Z'))
             {
                 left++;
                 continue;
             }
             // at this point we know that lc contains an alphabetic character
             if  ( rc < 'A'  ||   rc > 'Z' )
             {
                 right--;
                 continue;
             } 
             // at this point, both lc and rc contain uppercase alphabetic chars

             if (lc != rc )
             {
                System.out.println ("NOT a palindrome!");
                return;
             }
             left++;
             right--;
         }
         System.out.println ("YES, it's a palindrome!");
   }   
 }  
