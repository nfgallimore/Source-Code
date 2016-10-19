import java.util.Scanner;

public class Babysit
{
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in)
        do
        {
            System.out.print("At what HOUR did the baby-sitter start work? ");
            int startHour = input.nextInt();
        }
        while ( !(startHour >= 6 && startHour <= 11))
        
        System.out.println();
        System.out.print("At what MINUTE did the baby-sitter start work? ");
        int startMin = input.nextInt();

        do
        {
            System.out.println("\n");
            System.out.print("At what HOUR did the baby-sitter finish working? ");
            int endHour = input.nextInt();
        }
        while ( !(endHour + 12 <= 21 && endHour >= 4) );
            
        System.out.println();
        System.out.print("At what MINUTE did the baby-sitter finish working? ");
        int endMin = input.nextInt();
        
        
    }
    public static void calculate (int startHour, int startMin, int endHour, int endMin)
    {
        final double scale6to8 = 5.50;
        final double scale8to12 = 8.00;
        final double scale12to4 = 10.00;
        
        endHour - startHour + ((endhour-startHour) * -2)
        
        
    }
}