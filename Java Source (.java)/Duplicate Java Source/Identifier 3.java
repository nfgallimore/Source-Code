import java.util.Scanner;
public class Identifier
{
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");
        String a = input.next();
        
        if (isJavaIdentifierStart(a))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    public static boolean isJavaIdentifierStart (String s)
    {
        char c = (char)s.charAt(0);
        if (ch >= 'A' && ch <= 'Z'
             || ch >= 'a' && ch <= 'z'
             || ch == '$' || ch == '_' )
            return true;
        else return false;
    }
}