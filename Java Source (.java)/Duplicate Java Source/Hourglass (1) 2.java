public class Hourglass
{
    public static final int LINES = 23;
    
    public static void main(String[] args)
    {
        solidline();
        top();
        bottom();
        solidline();
        bottom();
        top();
        solidline();
    }
    
    public static void solidline()
    {
        int dashes = LINES * 2 - 1;
        System.out.print("+");
        for (int i = 1; i < dashes; i++)
        {
            System.out.print("-");
        }
        System.out.println("+");
    }
    
    public static void top()
    {


        for(int line = 1; line < LINES; line++)
        {
            // prints a bar
                System.out.print("|");
            
            // prints somes spaces
            int spaces = line - 1;
            for (int i = 0; i < spaces; i++)
                System.out.print(" ");
            
            // prints a backslash
            System.out.print("\\");
            
            // writes some dots
            int dots = (LINES * 2) - (line * 2) - 1;
            for (int i = 1; i < dots; i++)
            {
                System.out.print(".");
            }
            
            // writes a slash
            System.out.print("/");
            
            // prints somes spaces
            for (int i = 0; i < spaces; i++)
                System.out.print(" ");
            
            // prints a bar
            System.out.print("|");
            
            // prints a line
            System.out.println();
            
            
        }
    }
    
    public static void bottom()
    {

        for(int line = 1; line < LINES; line++)
        {
            // prints a bar
            System.out.print("|");
            
            // prints somes spaces
            int spaces = LINES - line - 1;
            for (int i = 0; i < spaces; i++)
                System.out.print(" ");
            
            // writes a slash
            System.out.print("/");
            
            // writes some dots
            int dots = 2 * line - 1;
            for (int i = 1; i < dots; i++)
            {
                System.out.print(".");
            }
            
            // prints a backslash
            System.out.print("\\");

            
            // prints somes spaces
            for (int i = 0; i < spaces; i++)
                System.out.print(" ");
            
            // prints a bar
            System.out.print("|");
            
            // prints a line
            System.out.println();
            
            
        }
    }
    

}