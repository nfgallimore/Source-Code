import java.util.Scanner;
public class PencilPaper
{

    public static void main (String[] args)
    {
        System.out.println(repeat("hello", 3));
    }
    // problem 1
    public static int mystery (int n)
    {
        if (n < 0) return -mystery(-n);
        else if (n < 10) return (n + 1) % 10;
        else return 10 * mystery (n / 10) + (n + 1) % 10;
    }
    public static void mysteryTest()
    {
        System.out.println(mystery(7));     //  8
        System.out.println(mystery(42));    //  53
        System.out.println(mystery(-790));  // -801
        System.out.println(mystery(89294)); // 90305
        
        /*
         return - mystery(790);
         -801
         return 10 * mystery(79) + (791) % 10
         10 *         80  + 1
         801
         
         return 10 * mystery(7) + (80) % 10
         10 *      8     + 80 % 10
         80           + 80 % 10
         80           + 0
         
         
         1. 10 * mystery(8929) +  5
         
         2.      10 * mystery(892)
         
         3.          10 * mystery(89) + 3
         
         4.              10 * mystery(8)
         
         5.                  9 % 10 = 9
         
         6.              10 * 9 = 90
         
         7.          10 * 90 + 3 = 903
         
         8.      10 * 903 = 9030
         
         9. 10 * 9030 + 5 = 9305
         
         10. 90300 + 5 = 90305
         
         
         */
    }
    // Creates a method named processFile that takes a single Scanner parameter named input and doesn't return anything.
    static void processFile (Scanner input)
    {
        // checks if the file has a new line
        while (input.hasNextLine())
        {
            // creates a new string out of that line
            String first = input.nextLine();
            
            // checks if the file has another new line
            if (input.hasNextLine())
            {
                // creates a new string out of the second line
                String second = input.nextLine();
                // prints the second line
                System.out.println(second);
            }
            // prints the first line
            System.out.println(first);
        }
    }
    static String repeat (String s, int n) {
        if (n < 0) { System.out.println("Error, invalid argument"); System.exit(0); }
        else if (n == 1) return s;
        else return s + repeat(s, n - 1);
    }
}

