import java.util.*;

class OffByOneError
{
  public static void main (String [] args)
  {
    // Compute the number of years required to double an investment
    int years = 0;   // OR SHOULD THIS BE INITIALIZED TO THE VALUE 0 ???
    double rate;
    double balance, initialBalance;

    Scanner keyboard = new Scanner( System.in );
    System.out.println("I'll figure how long it'll take to double your money!");

    System.out.print("What's the initial balance you are investing?  $");
    initialBalance =  keyboard.nextDouble();

    System.out.print("What's the annual percent rate of interest? ");
    rate = keyboard.nextDouble();

    balance = initialBalance;

    while (balance < 2 * initialBalance)    // OR SHOULD THIS BE <=  ????
    {
       years++ ;
       double interest = balance * rate / 100;
       balance = balance + interest;
    }
    System.out.println("The investment reached the target after " +
                       years + " years.");
  }
}
