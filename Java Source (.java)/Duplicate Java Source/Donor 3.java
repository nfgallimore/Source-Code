import java.util.Scanner;
public class Donor
{
	public static void main(String[] args)
	{
        double amount = 0;
		
        System.out.print("\nEnter the amount of a contribution: ");
		
        Scanner input = new Scanner(System.in);
        
        if (input.hasNextDouble()) amount = input.nextDouble();
       
        if (amount > 0)
        {
            if (amount >= 1000.00)
                System.out.println("Benefactor!");
            else
                if (amount < 1000.00 && amount >= 500.00)
                    System.out.println("Patron!");
            else
                if (amount < 500.00 && amount >= 100.00)
                    System.out.println("Supporter!");
            else
                if (amount < 100.00 && amount >= 15.00)
                    System.out.println("Friend!");
            else
                if (amount < 15.00)
                    System.out.println("Cheapskate!");
        }
	}
}