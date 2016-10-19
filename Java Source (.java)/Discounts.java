import java.util.Arrays.*;
import java.util.*;

public class Discounts
{
	public static void main(String[] args)
	{
		discounts();
		System.out.println(d.increase(1428.59, 1615.41));
	}
	public static double discounts()
	{
		Scanner keyboard2 = new Scanner(System.in);
		
		double[][] d = new double[10][0];
		System.out.println("Enter the price: ");
		d[0][0] = keyboard2.nextDouble();

		Scanner keyboard = new Scanner(System.in);
		
		int num = 0;
		boolean next = true;

		do {
			System.out.println("Enter discount and tell me when your done: ");
			if (keyboard.hasNextDouble()) 
				d[num] = keyboard.nextDouble();
			else next = false;
			num++;
		} while (next != false);
		double p = d[0][0];

		for (int i = 0; i < d.length; i++)
			p = p - p * d[i];
		return p / d[0][0];
	}
	
}