import java.util.Scanner;

public class PigLatin
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String s;
        do
        {
            boolean space = false;
            boolean single = true;
            System.out.println("\nEnter a word to be translated.");
            s = input.nextLine();
            int j = 0;
            String word = "";
            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) == ' ')
                    single = false;
            if (single == false)
            {
                for (int i = 0; i < s.length(); i++)
                {
                    if (s.charAt(i) == ' ' || i + 1 == s.length())
                    {
                        space = true;
                        word = s.substring(j, i);
                        j = i + 1;
                        if (i + 1 == s.length())
                            word = word + s.substring(s.length() - 1);
                        System.out.print(convert(word) + " ");
                    }
                }
            }
            if (single == true)
                System.out.print(convert(s));
        }
        while(s != "");
    }
    public static boolean vowel(char c)
    {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        else
            return false;
    }
    public static String convert(String s)
    {
        int length = s.length();
        if (s.length() == 0)
            return "";
        if ( vowel(s.charAt(0)) )
            return(s + "-way");
        else
        {
            for (int i = 0; i < length; i++)
            {
                if ( vowel ( s.charAt(i) ) )
                {
                    String start = s.substring(i, length );
                    String end = s.substring(0, i);
                    String word = start + "-" + end + "ay";
                    return(word);
                }
            }
        }
        return "";
    }
}