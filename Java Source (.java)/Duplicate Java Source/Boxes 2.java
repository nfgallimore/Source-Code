//Another illustration of parameter-passing
// Last edited on June 29, 2013

public class Boxes 
{
    public static void main (String [] args) 
    {
        line (13, '*', true);
        line (7, '/', false);
        line (35, '%', true);
        System.out.println ();
        box (10, 3, '*');
        box (5, 4, '=');
        box (20, 7, '$');
    }
    
    // Prints the given number of the second arg plus a line break,
    //  and an optional count of the # of characters printed 
    static void line (int count, char ch, boolean showNumber) 
    {
        repeat (ch, count);
        if (showNumber) System.out.println (" " + count);
        else System.out.println ();
    }

 
    // Prints a box using the character ch of the given size.
    static void box (int width, int height, char ch) 
    {
        line (width, ch, false);  // top of the box
        
        for (int line = 1; line <= height - 2; line++) 
        {
            System.out.print (ch);
	    repeat (' ', width - 2);
	    System.out.println(ch);
        }
        
        line (width,ch, false);    // bottom of the box
    }
    
    // Prints the given char the given number of times.
    static void repeat (char ch, int times) 
    {
        for (int i = 1; i <= times; i++) 
        {
	    System.out.print(ch);
        }
    }    
}
