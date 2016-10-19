class July18
{
   public static void main (String [] args)
   {
      for (int i = 0; i <= 127; i++)
      {
         System.out.println (i + "\t\t" + (char) i);
      }

      for (char ch = 'X'; ch <= 'c'; ch++ )
      {
          System.out.println (ch +  "\t\t" + (int) ch);
      }     

      for (int i = 0; i <= 127; i++)
      {
          System.out.printf ("%5o %5d %5x %5c \n",
                               i,  i,   i,  i);
      }                         
      System.out.println ("Hi, I am the SIGMA char \u03A3");
   }
}   
