class July9d
{
       // There are some 3-digit integers that have a special property ...
       //  They are equal to the sum of the cube of their individual digits
       //  Find and print all of them!

    public static void main (String [] args)
    {
       for (int n = 100; n <= 999; n++)
       {
             int h = n / 100;
             int u = n % 10;

             int t = (n / 10) % 10;

             if (n == h*h*h + t*t*t + u*u*u) 
             {
                 System.out.println (n);
             }
        }
        System.out.println (" Here is an alternative solution: ");

        for (int h = 1; h <= 9; h++)
        {
             for (int t = 0; t <= 9; t++)
             {
                  for (int u = 0; u <= 9; u++)
                  {
                        if (h*h*h + t*t*t + u*u*u == 100*h + 10*t + u)
                        {
                           System.out.println ( "" + h + t +u);
                        }
                  }
             }
        }      
     }
 }
