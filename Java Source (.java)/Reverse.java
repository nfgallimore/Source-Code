import java.util.*;

class Reverse
{
    public static void reverse (Scanner input)
    {
        if (input.hasNextLine())
        {
            String line = input.nextLine();
            reverse(input);
            System.out.println(line);
        }
    }

    public static void main (String [] args)
    {
        Scanner keyboard = new Scanner (System.in);
        System.out.println("Please type one string per line," +
                           " and I'll reverse them!");
        reverse(keyboard);
    }
}
