class July16e
{

       static int rint (int a, int b)
       {
            int n = (int)  (Math.random() * (b-a+1));

            // value of n is between 0 .. b-a

            return  n + a;
       }

       public static void main (String [] args)
       {
           for (int i = 1; i <= 10; i++ )
             System.out.println ( rint (3, 17) );
       }
  }     
