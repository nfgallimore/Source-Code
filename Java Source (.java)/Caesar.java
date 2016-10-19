import java.util.Scanner;
import java.io.File;
class Caesar
{
    public static void main(String[] args)
    {
        try
        {
            final int KEY = 52;
            String s = "";
            
            File input = new File (args[0]);
            Scanner reader = new Scanner (input);
            
            do
            {
                s+= reader.nextLine();
                s+= "\n";
            }
            while (reader.hasNext());
            
            for (int i = 0; i < s.length(); i++)
            {
                char c = s.charAt(i);
                
                if ( !isAlpha(c) )
                    System.out.print(c);
                
                else if ( isAlpha(c) && (c  <= 'Z' - KEY || c <= 'z' - KEY))
                    System.out.print( (char) (c + KEY) );
            
                else
                    System.out.print( (char) ( (c + KEY) % 26 ) );
            }
        }
        
        catch (java.io.FileNotFoundException e)
        {
            System.out.println("Cannot open file!");
        }
    }
    public static boolean isAlpha(char c)
    {
        if (c >= 'A' && c <= 'Z' ||
            c >= 'a' && c <= 'z')
            return true;
        else return false;
    }
}