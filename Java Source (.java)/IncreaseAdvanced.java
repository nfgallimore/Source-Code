/***************************************************************
 * Call me crazy but I went a little overboard on this problem *
 * I will submit this along with a more simplified version.    *
 *                                                             *
 *      Nicholas Gallimore                                     *
 *                                                             *
 ***************************************************************/

import java.util.Scanner;
public class IncreaseAdvanced
{

	public static void main(String[] args)
	{
		final int DAYS = 10;
		int diff = 0, price = 0, day = 0, low = 0, lowPrice = 0, lowDay = 0;
		Scanner inputPrice = new Scanner(System.in);
		clear(23);
        System.out.println("Please enter " + DAYS + " prices and I'll find the largest increase!");
		int[] prices = new int[DAYS + 1];
		for (int i = 1; i <= DAYS; i++)
		{
			clear(23);
			while (!inputPrice.hasNextInt())
			{
				System.out.println("Invalid input, please input an integer.");
				clear(23);
				inputPrice.nextLine();
			}
			if (inputPrice.hasNextInt() == true && i < DAYS)
			{
				prices[i] = inputPrice.nextInt();
				System.out.println("You entered " + prices[i] + " for day " + i + ". Please enter the price for day " + (i + 1) + ".");
			}
			if (prices[i] == prices[DAYS])
			{
				prices[i] = inputPrice.nextInt();
				System.out.println("You entered " + prices[i] + " for day " + i + ".");
				clear(23);
			} 
		}
		for (int days = 1; days < DAYS; days++)
		{
			int tmp = prices[days + 1] - prices[days];
			if (tmp > diff)
			{
				diff = tmp;
				price = prices[days];
				day = days;
			}
			if (low > tmp)
			{
				low = tmp;
				lowPrice = prices[days];
				lowDay = days;
			}
		}
		clear(23);
	    if (diff > 0)
	    {
	        System.out.println("\nLargest increase of " + diff + "\n from " + price + " to " + (diff + price) + "\n occurred between day #" + day + " and day #" + (day + 1) + ".");
	    	if (low == 0)
	    	{
	    		System.out.println("\nThe price of this stock never dropped!");
	    		clear(19);
	    	}
	    	// shows the lowest drop in price, took it out for sake of grading
	    	if (low < 0)
	    	{
	    		System.out.println("\nLargest drop of " + low + "\n from " + lowPrice + " to "  + (low + lowPrice) + "\n occurred between day #" + lowDay + " and day #" + (lowDay + 1) + ".");
	    		clear(17);
    		} 
    		else clear(21);
	    }
	    if (low < 0 && diff <= 0) 
	    {
	    	System.out.println("\nThe price of this stock never increased!");
	    	System.out.println("\nLargest drop of " + low + "\n from " + lowPrice + " to "  + (low + lowPrice) + "\n occurred between day #" + lowDay + " and day #" + (lowDay + 1) + ".");
			clear(19);
		}
		if (low == 0 && diff == 0) 
		{
			System.out.println("\nThe price of this stock never changed!");
			clear(23);
		}
	}
	public static void clear(int num)
	{
		for (int clear = 1; clear < num; clear++)
			System.out.println();
	}
}