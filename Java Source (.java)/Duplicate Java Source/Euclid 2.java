// Euclid's Algorithm for Greatest Common Division
// Given m, and n
// step 1: Divide first number by second number
//         In other words divide m by n
// step 2: If there's a remainder of 0, all done because n is the GCD
// step 3: Otherwise replace m by the value of n
//          replace n by the remainder of previous divsion.
//          GO BACK TO STEP #1
public class Euclid
{
    public static void main(String[] args)
    {
        int m = 60;
        int n = 12;
        int gcd = 0;
        gcd = idk(gcd, m, n);
        System.out.println(gcd);
    }
    public static int idk(int gcd, int n, int m)
    {
        for (int i = n; i < n; m % n != 0, n = m % n)
        {
            if (m % n == 0)
                return (n);
            else 
                n = m % n;
        }
    
}
