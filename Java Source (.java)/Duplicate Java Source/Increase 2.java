    /*       ahh nice and simple version     /
   /    less efficient but easy to read     /
  /                                        /
 /            Harvard CS-1                /
/  Nicholas Gallimore                   */
/////////////////////////////////////////
import java.util.Scanner;

public class Increase
{
    public static void main(String[] args)
    {
        final int DAYS = 10;                                    // SETS NUMBER OF DAYS IN THE TIME PERIOD

        Scanner inputPrice = new Scanner(System.in);            // makes a new scanner called inputPrice
        
        // tells the user how many stock prices to input 
        System.out.println("Please enter " + DAYS + " prices and I'll find the largest increase!");
        
        int startPrice = inputPrice.nextInt();                  // remember the price for day #1
        int endPrice = inputPrice.nextInt();                    // remember the price for day #2

        int currentIncrease = endPrice - startPrice;            // computes the amount increased
        int largestIncrease = currentIncrease;                  // currently this is the largest price increase
        int startDay = 1;                                       // we start off at day #1
        int endDay = 2;                                         // we start off with the ending day being #2

        int largestStartPrice = startPrice;                     // remember the start price of the largest increase
        int largestEndPrice = endPrice;                         // remember the end price of the largest increase

        int largestStartDay = startDay;                         // remember the start day of the largest increase
        int largestEndDay = endDay;                             // remember the end day of the largest increase
        
        // lets take a look to see if the price difference between day #2 and day #3 is bigger
        for (startDay = endDay; startDay < DAYS; startDay++)    
        {
            startPrice = endPrice;                              // next starting price
            endPrice = inputPrice.nextInt();                    // next ending price
            currentIncrease = endPrice - startPrice;            // computes the amount increased
            if (currentIncrease > largestIncrease)              // if we found a larger increase
            {
                largestIncrease = currentIncrease;              // remember the amount  
                largestStartPrice = startPrice;                 // remember the start price
                largestEndPrice = endPrice;                     // remember the end price
                largestStartDay = startDay;                     // remember the start day
                largestEndDay = startDay + 1;                   // remember the end day
            }    
        }
        if (largestIncrease > 0)                                // if the price increased
        {
            // prints the value, start and end price, and days the largest price increase happened
            System.out.println("Largest increase of " + largestIncrease);
            System.out.println("from " + largestStartPrice + " to " + largestEndPrice);
            System.out.println("occurred between day #" + largestStartDay + " and day #" + largestEndDay + "."); 
        }
        // tells the user the price never increased
        else
            System.out.println("The price of this stock never increased!");
    }
}
