import java.util.Scanner;

class July9b
{
    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner (System.in);

        int sum = 0;

        final int N = 5;     // how many #'s will get input

        System.out.println ("You'll type " + N + " integers... " +
                             " and I'll compute the average of them!");

        for (int i = 1; i <= N; i++)
        {
              System.out.print ("Please type an int: ");
              sum += keyboard.nextInt();
        }
        System.out.println ("The truncated average = " + (sum / N) );
     }
}     

