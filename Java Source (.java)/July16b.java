class July16b
{
    public static void main (String [] args)
    {
         int heads = 0;
         int tails = 0;
         for (int i = 1; i <= 10000; i++)
         {
            if (Math.random() > 0.5) heads++;
            else tails++; 
         }
         System.out.println ("# of heads = " + heads +
                              " and the # of tails = "  + tails);
    }
}    
