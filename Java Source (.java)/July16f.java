class July16f
{
     // Toss a pair of dice over and over
     // until we throw a "double" -- both values on
     // the dice are the same.  In other words, stop
     // after throwing two 1's, or two 2's, or two 3's ...

     public static void main (String [] args)
     {
     
        int die1 = 0;
        int die2 = 1;
       
        while ( die1 != die2)
        {
           die1 =  (int) (Math.random() * 6) + 1;
           die2 =  (int) (Math.random() * 6) + 1;
           System.out.println ("You just rolled a " + die1 + 
                                  " and a "  + die2);
        }
        System.out.println ("You just rolled a DOUBLE!");
     }
}
   
