class July25b
{
     public static void main (String [] args)
     {
          int n = rint (4, 15);
          int [] harvard = new int [n];
          int [] yale = new int [n];

          for (int i = 0; i < harvard.length; i++)
          {
              harvard [i] = rint (50, 92);
              yale [i] = rint (48, 89);
              System.out.println ("In game " + (i+1) + ", Harvard: " +
                                   harvard[i] + ", Yale: " + yale[i] );
          }                         

          System.out.println ("The average # of points scored by Harvard = "
                               +  averagePoints (harvard) );

          System.out.println ("The average # of points scored by Yale = "
                               + averagePoints (yale) );

          System.out.println ("The most points scored by Harvard = " +
                                maxPoints (harvard) );

          System.out.println ("The most points scored by Yale = " +
                                maxPoints (yale) );

     }

     static int maxPoints (int [] team)
     {
        // you write the rest!
        int max = -1;
        for (int i = 0; i < team.length; i++)
        {
            if (team [i] > max) max = team[i];
        }
        return max;
     }    


     static double averagePoints ( int [] team)
     {
         int sum = 0;
         for (int i = 0; i < team.length; i++)
         {
              sum += team [i];
         }
         return (double) sum / team.length;
     }

     static int rint (int a, int b)
     {
         return (int) ( (b-a+1) * Math.random () ) + a;
     }    
}
