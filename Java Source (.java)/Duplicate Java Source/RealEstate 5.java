import java.util.Scanner;

class RealEstate
{
    public static void main (String args[])
    {
        double length;
        double width;
        System.out.println();   
        // gets user input for length
        Scanner input = new Scanner(System.in);
        do
        {
            System.out.print("Enter LENGTH: ");
            length = input.nextDouble();
        }
        while(!numValid(length));
        
        // gets user input for width
        Scanner input2 = new Scanner(System.in);
        do
        {
            System.out.print("Enter WIDTH: ");
            width = input2.nextDouble();
        }
        while(!numValid(width));
        
        System.out.println("\nYou have " + length * width / 43560 + " acres!\n");
        
    }
    
    private static boolean numValid(double num)
    {
        if (num < 0)
        {
            System.out.println("Inappropriate values, try again.");
            return false;
        }
        else
            return true;
    }
}