import java.util.*;

class July25
{
      public static void main (String [] args)
      {
          int [] iq = {126, 167, 95, 17, -5, 11};
          increase (iq);
          System.out.println  ( Arrays.toString (iq) ); 
          reverse (iq);
          System.out.println  ( Arrays.toString (iq) );
      }

      static void reverse (int [] list)
      {
          for (int i = 0; i < list.length / 2; i++)
          {
               int temp = list [i];
               list [i] = list [ list.length - i - 1];
               list [ list.length - i - 1] = temp;
          }
      }    

      static void increase ( int [] a)
      {
           for (int i = 0; i < a.length; i++)
           { 
                a[i] = a[i] *2;
           }
      }
}


