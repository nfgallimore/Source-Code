import java.util.Scanner;

public class Divisors
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input an integer value for m: ");
        int m = input.nextInt();
        System.out.println();
        
        System.out.print("Please input an integer value for n that\n is greater than or equal to " + m + ": ");
        int n = input.nextInt();

        for (int i = 0; m <= n; m++)
        {
            if (compute(m) == m)
                System.out.println("\n" + m + " is perfect");
            if (compute(m) < m)
                System.out.println("\n" + m + " is deficient");
            if (compute(m) > m)
                System.out.println("\n" + m + " is abundant");
        }
    }
    public static int compute(int m)
    {
        int divisor = 0;
        int i = 1;
        while (i < m)
        {
            if (m % i == 0) divisor = divisor + i;
            i++;
        }
        return divisor;
    }
}
