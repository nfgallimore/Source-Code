
/*Java program to find out square root of a given number
 * without using any Built-In Functions
 */
public class Square
{
  
    public static void main(String[] args)
    {
        int n = 453504209;
        System.out.println(square(n));
        n = 105592908;
  
    }
    public static int totient(int n)
    {
        int guess = 0;
        int squareRoot = n / 2;
        do
        {
            guess = squareRoot;
            squareRoot = (guess + (n / guess)) / 2;
        }
        while (( guess - squareRoot ) != 0);
        return squareRoot;
    }
}