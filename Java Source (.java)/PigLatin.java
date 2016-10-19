import java.util.Scanner;

public class PigLatin
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
    
        String s; 
        do
        {
            System.out.println("\nEnter a sentence to be translated.");
            s = input.nextLine();
            int length = s.length();
            int j = 0;
            boolean singleWord = true;
            
            // checks if input is a word or a sentence
            for (int i = 0; i < length; i++)                            
                if (s.charAt(i) == ' ')
                    singleWord = false;
            
            // input is a sentence
            if (singleWord == false)
            {
                for (int i = 0; i < length; i++)
                {
                    String word;
                    if (s.charAt(i) == ' ' || i + 1 == length)          
                    {
                        word = s.substring(j, i);
                        j = i + 1;                                      
                        if (i + 1 == length)                                   
                            word = word + s.substring(length - 1);      
                        System.out.print(convert(word) + " ");       
                    } 
                }
            }
            // input is a single word
            if (singleWord == true)
                System.out.print(convert(s));
        }
        while(s.length() != 0);
    }
    
    // if char is a vowel
    public static boolean vowel(char c)
    {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
        else return false;
    }
    public static boolean vowel(char c)
    {
    	boolean lower;
    	if (c >= 'A' && c <= 'Z') 
    	{
    		c | 32;
    		lower = false;
    	}
    	if (c == e || c == a || c == i || c = o || c = u)
    
    // converts string to Pig Latin and returns it
    public static String convert(String s)
    {
        int length = s.length();

        if (s.length() == 0)
		return "";

        // if a vowel adds -way
        if ( vowel(s.charAt(0)) )
            return(s + "-way");
        
        // searches for constant and moves it to end of word followed by ay
        for (int i = 0; i < length; i++)
        {
            char c = s.charAt(i);
            if ( vowel ( c ) )
            {
                String start = s.substring(i, length );
                String end = s.substring(0, i);
                String word = start + "-" + end + "ay";
                return word;
            }
        }
        return(s + "ay");
    }
}
