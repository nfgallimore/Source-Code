import java.util.Scanner;

public class RealEstate
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a property description: ");
        String s = input.next();
        
        String test = "Desirable unfurnished flat in quiet residental area";
        int i = 0;
        if ( vowel(test.charAt(0)) )
        {
            System.out.print(charAt(0));
            i = 1;
        }
        {
            int length = test.length();
            for (; i < length; i++)
            {
                if (!vowel(test.charAt(i)))
                    System.out.print(charAt(i));
            }
            System.out.println();
        }
        
    }
    
    public static boolean vowel(char c)
    {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        else return false;
    }
}